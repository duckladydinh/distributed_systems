echo "PLEASE START THE ACTIVEMQ SERVER BEFORE RUNNING"
echo "This demo creates a JMS chat app using ACTIVEMQ"
echo "-----------------------------------------------"
gnome-terminal -x bash -c 'python3 sender.py; bash'
gnome-terminal -x bash -c 'python3 receiver.py; bash'
