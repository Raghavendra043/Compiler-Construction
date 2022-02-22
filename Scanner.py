str = None

def bindStream(f):
    global str
    str = f.read()

def getNext():
    return str

def setLP(len):
    global str
    str = str[len:]