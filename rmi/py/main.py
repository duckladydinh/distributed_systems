# gnome-terminal -x bash -c 'python3 main.py; bash'
# gnome-terminal -e         'python3 main.py'
import os
os.system("gnome-terminal -x bash -c 'python3 -m Pyro4.naming; bash'")
os.system("gnome-terminal -x bash -c 'python3 server.py; bash'")
os.system("gnome-terminal -x bash -c 'python3 clientA.py; bash'")
os.system("gnome-terminal -x bash -c 'python3 clientB.py; bash'")
print("\tThis ia a demonstration for RMI")
print("\tA book in a server, two clients")
print("\tshow/add data, output on server")
print("\t-------------------------------")
print("\t-------------------------------")
