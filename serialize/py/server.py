import socket
from pickle import loads

HOST = ''
PORT = 8080


def server():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.bind((HOST, PORT))
    sock.listen(1)

    conn, client = sock.accept()
    dat = conn.recv(1 << 24, socket.MSG_WAITALL)
    books = loads(dat)
    for b in books:
        b.show()
    conn.close()
    sock.close()


def intro():
    print('\tI AM SERVER ---- RECEIVEING 2 BOOKS objects!')
    print('\tfrom client using serialization with Pickle!')
    print('\t-----------------------------------')


def main():
    intro()
    server()

if __name__ == '__main__':
    main()