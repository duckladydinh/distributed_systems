# gnome-terminal -x bash -c 'python3 main.py; bash'
# gnome-terminal -e         'python3 main.py'
import os
os.system("gnome-terminal -x bash -c 'python3 server/main.py; bash'")
os.system("gnome-terminal -e 'python3 client/main.py'")
print("\tThis ia a demonstration for TCP socket")
print("\tThe client sends 100,000 TCP packets")
print("\t, and the server receives all packets!!!")
print("\t--------------------------------------")
