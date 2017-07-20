import socket

HOST = ''
PORT = 8080


def intro():
    print('\tI AM CLIENT -- TESTING TCP packets!')
    print('\tSENDING 100,000 UDP packets to test!')
    print('\t-----------------------------------')


def client():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect((HOST, PORT))
    n = 100000
    for i in range(n):
        sock.send(bytes("Hello, World! " + str(i) + "\n", "utf-8"))
    sock.close()


def main():
    intro()
    client()

if __name__ == '__main__':
    main()