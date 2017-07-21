# gnome-terminal -x bash -c 'python3 main.py; bash'
# gnome-terminal -e         'python3 main.py'
import os
os.system("gnome-terminal -x bash -c 'python3 server.py; bash'")
os.system("gnome-terminal -x bash -c 'python3 client.py; bash'")
print("\tThis ia a demonstration for serialization")
print("\tThe client sends 2 BOOK objects to server")
print("\t, and the server receives all them by TCP")
print("\t------------------sockets----------------")
print("\t--------------------------------------")
