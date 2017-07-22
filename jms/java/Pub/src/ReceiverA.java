import java.util.Properties;
import java.util.Scanner;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;



public class ReceiverA {
	static class MyListener implements MessageListener {
		@Override
		public void onMessage(Message message) {
			try {
				System.out.println("Received message: " + ((TextMessage) message).getText());
			} catch (Exception e) {}
		}
	}

	public static void main(String args[]) throws Exception {
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
		TopicConnectionFactory connFactory 	= (TopicConnectionFactory) myContext.lookup("TopicConnectionFactory");

		// create a queue connection
		TopicConnection MyTopicConn = connFactory.createTopicConnection();
		MyTopicConn.start();

		// create a queue session
		TopicSession myTopicSession = MyTopicConn.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
		// create a queue receiver
		TopicSubscriber mySubcriber = myTopicSession.createSubscriber(oneTopic);
		mySubcriber.setMessageListener(new MyListener());
		Thread.sleep(60000);
		// close the queue connection
		MyTopicConn.close();
	}
}