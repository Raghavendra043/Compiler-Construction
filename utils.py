def tokenNum(list, token):
    for i in list:
        if i[1] == token:
            return i[0]
    return -1


def binUtil(str):
    str = bin(str)[2:]
    if len(str) < 8:
        for i in range(8-len(str)):
            str = '0' + str
    return str