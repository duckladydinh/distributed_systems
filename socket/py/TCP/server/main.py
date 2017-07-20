import socket

HOST = ''
PORT = 8080


def server():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.bind((HOST, PORT))
    sock.listen(1)

    conn, client = sock.accept()
    dat = conn.recv(1 << 24, socket.MSG_WAITALL).decode('utf-8')
    conn.close()
    sock.close()
    print("Received " + str(dat.count("\n")) + " line(s)")


def intro():
    print('\tI AM SERVER ---- TESTING TCP Datagram!')
    print('\tRECEIVING 100,000 TCP packets to test!')
    print('\t-----------------------------------')


def main():
    intro()
    server()

if __name__ == '__main__':
    main()