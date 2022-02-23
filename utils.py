def trim(str):
    fp = 0
    while str[fp] != '/':
        fp+=1
    return str[fp+1:]

def tokenNum(list, token):
    for i in list:
        if i[1] == token:
            return i[0]
    return -1

def numLines(str):
    fp, count = 0, 0
    while fp != len(str):
        if str[fp] == '\n':
            count += 1
        fp+=1
    
    return count

def binUtil(str):
    str = bin(str)[2:]
    if len(str) < 8:
        for i in range(8-len(str)):
            str = '0' + str
    return str