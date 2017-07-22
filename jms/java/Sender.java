import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSender;
import javax.jms.DeliveryMode;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

public class Sender {

	public static void main(String[] args) throws Exception {
		Properties environment = new Properties();
		environment.put( Context.INITIAL_CONTEXT_FACTORY,
												  "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		environment.put( Context.PROVIDER_URL, 	  "tcp://localhost:61616");
		environment.put("queue.queueSampleQueue", "KWerQueue0001");
		
		// get the initial myContext
		InitialContext myContext = new InitialContext(environment);

		// lookup the queue object
		Queue myQueue = (Queue) myContext.lookup("queueSampleQueue");

		// lookup the queue connection factory
		QueueConnectionFactory connFactory = (QueueConnectionFactory) myContext.lookup("QueueConnectionFactory");

		// create a queue connection
		QueueConnection MyQueueConn = connFactory.createQueueConnection();

		// create a queue session
		QueueSession myQueueSession = MyQueueConn.createQueueSession(false,Session.DUPS_OK_ACKNOWLEDGE);

		// create a queue sender
		QueueSender myQueueSender = myQueueSession.createSender(myQueue);
		myQueueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		// create a simple myMessage to say "Hello"
		TextMessage myMessage = myQueueSession.createTextMessage("Hello");

		// send the myMessage
		myQueueSender.send(myMessage);
		System.out.println("sent: " + myMessage.getText());

		// close connection
		MyQueueConn.close();
	}
}