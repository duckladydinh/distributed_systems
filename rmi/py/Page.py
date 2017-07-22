import Pyro4


@Pyro4.expose
class Page(object):
    def __init__(self, c = "I am just a little page"):
        self.__c = c

    def write(self, content):
        self.__c = content

    def read(self):
        return self.__c
