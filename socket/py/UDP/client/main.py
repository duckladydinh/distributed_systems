import socket

HOST = ''
PORT = 8080


def intro():
    print('\tI AM CLIENT -- TESTING UDP Datagram!')
    print('\tSENDING 100,000 UDP packets to test!')
    print('\t-----------------------------------')


def client():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    n = 100000
    for i in range(n):
        sock.sendto(bytes("Hello, World! " + str(i), 'utf-8'), (HOST, PORT))
    sock.sendto(bytes("Goodbye", 'utf-8'), (HOST, PORT))
    sock.close()

def main():
    intro()
    client()

if __name__ == '__main__':
    main()