from Page import Page
import Pyro4

@Pyro4.expose
class Book(object):
    def __init__(self, n = "I am a little book"):
        self.n = n
        self.p = []

    def add(self, c):
        p = Page(c)
        self.p += [p]

    def show(self):
        print(self.n)
        for p in self.p:
            print(p.read())
