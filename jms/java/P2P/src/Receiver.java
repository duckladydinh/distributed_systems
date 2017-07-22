import java.util.Properties;
import java.util.Scanner;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;



public class Receiver {
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
		environment.put("queue.queueOneQueue", "KWerQueue0001");
		environment.put("queue.queueTwoQueue", "KWerQueue0002");

		// get the initial myContext
		InitialContext myContext = new InitialContext(environment);
		
		// lookup the queue object
		Queue oneQueue = (Queue) myContext.lookup("queueOneQueue");

		Queue twoQueue = (Queue) myContext.lookup("queueTwoQueue");

		// lookup the queue connection factory
		QueueConnectionFactory connFactory 	= (QueueConnectionFactory) myContext.lookup("QueueConnectionFactory");

		// create a queue connection
		QueueConnection MyQueueConn = connFactory.createQueueConnection();
		MyQueueConn.start();

		// create a queue session
		QueueSession myQueueSession = MyQueueConn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		// create a queue receiver
		QueueReceiver myQueueReceiver = myQueueSession.createReceiver(oneQueue);
		myQueueReceiver.setMessageListener(new MyListener());
		// create a queue sender
		QueueSender myQueueSender = myQueueSession.createSender(twoQueue);
		myQueueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		Scanner in = new Scanner(System.in);
		while (true) {
			String line = in.nextLine();
			if (line.equals("BYE")) {
				break;
			}
			TextMessage myMessage = myQueueSession.createTextMessage(line);
			myQueueSender.send(myMessage);
			System.out.println("sent: " + myMessage.getText());
		}
		// close the queue connection
		MyQueueConn.close();
	}
}