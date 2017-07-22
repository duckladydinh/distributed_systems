import Pyro4

book = Pyro4.Proxy("PYRONAME:book")
Page = Pyro4.Proxy("PYRONAME:Page")
while True:
    line = input("\tType show to view (on server) or another string to add\n\t")
    if line == "show":
        book.show()
    else:
        book.add(line)
