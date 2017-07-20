# gnome-terminal -x bash -c 'python3 main.py; bash'
# gnome-terminal -e         'python3 main.py'
import os
os.system("gnome-terminal -x bash -c 'python3 server/main.py; bash'")
os.system("gnome-terminal -e 'python3 client/main.py'")
print("\tThis is a demonstration for UDP socket")
print("\tThe client sends 100,000 UDP Datagrams")
print("\t, but the server receives much less!!!")
print("\t--------------------------------------")
