import socket
from Book import Book
from Page import Page
from pickle import dumps

HOST = ''
PORT = 8080


def intro():
    print('\tI AM CLIENT -- SENDING 2 BOOK objects!')
    print('\tto server by serializtion with Pickle!')
    print('\t---------------------------------------')


def client():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect((HOST, PORT))
    n = 2
    books = []
    for i in range(n):
        b = Book("Book no. " + str(i))
        for j in range(10):
            p = Page("I am page no. " + str(j) + " of " + b.n)
            b.add(p)
        books += [b]
    sock.send(dumps(books))
    sock.close()



def main():
    intro()
    client()

if __name__ == '__main__':
    main()