echo "PLEASE START THE ACTIVEMQ SERVER BEFORE RUNNING"
echo "This demo creates a JMS chat app using ACTIVEMQ"
echo "-----------------------------------------------"
gnome-terminal -x bash -c "javac -cp jms.jar  Sender.java && java -cp :activemq-all-5.15.0.jar Sender"
gnome-terminal -x bash -c "javac -cp jms.jar  Receiver.java && java -cp :activemq-all-5.15.0.jar Receiver"