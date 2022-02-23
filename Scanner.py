from numpy import inexact


str = None

def bindStream(f):
    global str
    str = f.read()

def getNext():
    return str

def errorRead():
    x = 0
    try:
        while str[x] != '\n':
            x+=1
        return str[:x]
    except(IndexError):
        return str

def setLP(len):
    global str
    str = str[len:]