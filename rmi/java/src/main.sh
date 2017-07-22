echo THIS IS A DEMO FOR JAVA RMI
echo A CHAT BOT BETWEEN CLIENT A 
echo AND CLIENT B, WITH THE BOOK
echo ..OBJECT FROM THE SERVER..!
echo ...........................

gnome-terminal -x bash -c 'rmiregistry; bash'
gnome-terminal -x bash -c 'java server; bash'
gnome-terminal -x bash -c 'java clientA; bash'
gnome-terminal -x bash -c 'java clientB; bash'
