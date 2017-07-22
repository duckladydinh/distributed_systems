from Book import Book

import Pyro4

book = Book()
book.add("I am a book in the server")

HOST = "localhost"
PORT = 8080
daemon = Pyro4.Daemon()
naming = Pyro4.locateNS(port = 8080)
uri = daemon.register(book)
naming.register("book", uri)

print("..STARTING THE SERVER WITH ONE BOOK OBJECT..")
daemon.requestLoop()