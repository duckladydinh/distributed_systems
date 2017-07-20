import socket

HOST = ''
PORT = 8080


def server():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.bind((HOST, PORT))
    lines = []
    value = 0
    while True:
        dat = sock.recv(1024).decode('utf-8')
        value = max(value, len(dat))
        if dat == "Goodbye":
            break
        lines += [dat]
    sock.close()
    print("Received " + str(len(lines)) + " line(s)")
    print("Max Size " + str(value) + " byte(s)")



def intro():
    print('\tI AM SERVER ---- TESTING UDP Datagram!')
    print('\tRECEIVING 100,000 UDP packets to test!')
    print('\t-----------------------------------')


def main():
    intro()
    server()

if __name__ == '__main__':
    main()