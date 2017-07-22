import java.util.Properties;
import java.util.Scanner;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;



public class Sender {
	public static void main(String[] args) throws Exception {
		Properties environment = new Properties();
		environment.put( Context.INITIAL_CONTEXT_FACTORY,
												  "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		environment.put( Context.PROVIDER_URL, 	  "tcp://localhost:61616");
		environment.put("topic.OneTopic", "KWerTopic0001");

		// get the initial myContext
		InitialContext myContext = new InitialContext(environment);

		// lookup the queue object
		Topic oneTopic = (Topic) myContext.lookup("OneTopic");
		// lookup the queue connection factory
		TopicConnectionFactory connFactory = (TopicConnectionFactory) myContext.lookup("TopicConnectionFactory");

		// create a queue connection
		TopicConnection MyTopicConn = connFactory.createTopicConnection();
		MyTopicConn.start();

		// create a queue session
		TopicSession myTopicSession = MyTopicConn.createTopicSession(false,Session.DUPS_OK_ACKNOWLEDGE);
		// create a queue sender
		TopicPublisher myPublisher = myTopicSession.createPublisher(oneTopic);
		myPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		Scanner in = new Scanner(System.in);
		while (true) {
			String line = in.nextLine();
			if (line.equals("BYE")) {
				break;
			}
			TextMessage myMessage = myTopicSession.createTextMessage(line);
			myPublisher.publish(myMessage);
			System.out.println("sent: " + myMessage.getText());
		}
		// close connection
		MyTopicConn.close();
	}
}