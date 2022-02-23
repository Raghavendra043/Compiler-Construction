from Constants import *
from utils import binUtil, tokenNum, numLines
from Scanner import getNext

str = None

#### The start of Main DFA. Returns the token if matched else None 
def DFA():
    global str
    str = getNext()
    tokens, state, final, lineNo = [], 0b00000000, None, 0
    
    tokens.append(isSpaceOrComm())
    tokens.append(isKeyword())
    tokens.append(isId())
    tokens.append(isOp())
    tokens.append(isInt())
    tokens.append(isFP())
    tokens.append(isDelimiter())
    tokens.append(isStr())
    
    for i in range(8):
        state |= tokens[i][2]
    state = binUtil(state)

    if state[IND_KW] == '1' and state[IND_ID] == '1':
        if tokens[IND_KW][1] >= tokens[IND_ID][1]:
            final = tokens[IND_KW]
            tokenName = TokenNames[IND_KW]
        else:
            final = tokens[IND_ID]
            tokenName = TokenNames[IND_ID]
    elif state[IND_SP_COMM] == '1' and state[IND_OP] == '1':
        final = tokens[IND_SP_COMM]
        lineNo += tokens[IND_SP_COMM][3]
        tokenName = TokenNames[IND_SP_COMM]
    elif state[IND_INT] == '1' and state[IND_FP] == '1' and state[IND_OP] == '1':
        final = tokens[IND_OP]
        tokenName = TokenNames[IND_OP]
    elif state[IND_INT] == '0' and state[IND_FP] == '1' and state[IND_OP] == '1':
        final = tokens[IND_OP]
        tokenName = TokenNames[IND_OP]
    elif state[IND_INT] == '1' and state[IND_FP] == '0' and state[IND_OP] == '1':
        final = tokens[IND_OP]
        tokenName = TokenNames[IND_OP]
    elif state[IND_INT] == '1' and state[IND_FP] == '1' and state[IND_OP] == '0':
        final = tokens[IND_FP]
        tokenName = TokenNames[IND_FP]
    else:
        for index in range(8):
            if state[index] == '1':
                if index == IND_SP_COMM:
                    lineNo += tokens[index][3]
                final = tokens[index]
                tokenName = TokenNames[index]
                break
    
    if final == None:
        tokenName = -1
    return (final, lineNo, tokenName)
 
 
'''
 Return foramt for all dfas below: (4-tuple)
    (
        Lexeme(if matched) or ''(if none of them match),
        If matched: Length of lexeme or -1(EOF)(if it is the end of input stream). Else: garbage value depending on where it stopped matching,
        final state(state numbers as shown in Constants.py). If not matched - 0b00000000(NONE state),
        Token Number. If not matched then -1 (Except SpaceOrComm dfa which returns number of \n used for tracking line numbers)
    )
'''
        
# DFA for matching spaces & comments. Format of Comments same as that of C's multi-line comments ( /* ... */ )
# The tokens returned are not printed rather they are used in keeping track of line numbers.
def isSpaceOrComm():
    state = SP_OR_COMM
    fp = 0
    lines = 0
    try:
        while True:
            if state == SP_OR_COMM:
                if str[fp] in [' ', '\n', '\t', '\r']:
                    if str[fp] == '\n':
                        lines += 1
                    state = 'sp'
                    fp += 1
                elif str[fp] == '/':
                    state = 'comm'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == 'sp':
                try:
                    if str[fp] in [' ', '\n', '\t', '\r']:
                        if str[fp] == '\n':
                            lines += 1
                        state = 'sp'
                        fp += 1
                    else:
                        state = YES_SP_OR_COMM
                except(IndexError):
                    state = YES_SP_OR_COMM

            elif state == 'comm':
                if str[fp] == '*':
                    state = 'comm-content'
                    fp+=1
                else:
                    return ('', fp, NONE, -1)
            
            elif state == 'comm-content':
                if str[fp] != '*':
                    state = 'comm-content'
                    fp+=1
                else:
                    state = 'end-comm-1'
                    fp+=1
            
            elif state == 'end-comm-1':
                if str[fp] == '/':
                    state = YES_SP_OR_COMM
                    fp+=1
                else:
                    state = 'comm-content'
                    fp+=1

            elif state == YES_SP_OR_COMM:
                try:
                    str[fp]
                    return ('', fp, state, numLines(str[:fp]))
                except(IndexError):
                    return ('', EOF, state, numLines(str[:fp]))

    except(IndexError):
        return ('', EOF, NONE, -1)


#### DFA for matching Keywords.
def isKeyword():
    fp = 0
    try:
        str[fp]
        for kw in keywords:
            try:
                if str[fp:len(kw)] == kw:
                    fp += len(kw)
                    str[fp]
                    return (str[:fp], fp, YES_KW, tokenNum(keywordEnm, str[:fp]))
            except(IndexError):
                return (str[:fp], EOF, YES_KW, tokenNum(keywordEnm, str[:fp]))

        return ('', 0, 0b00000000, -1)

    except(IndexError):
        return ('', EOF, 0b00000000, -1)


#### DFA for matching Identifiers
def isId():
    state = ID
    fp = 0
    try:
        while True:
            if state == ID:
                if str[fp] in charSet[:52]:
                    state = YES_ID
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == YES_ID:
                try:
                    if str[fp] in charSet:
                        state = YES_ID
                        fp += 1
                    else:
                        return (str[:fp], fp, state, idToken)
                except(IndexError):
                    return (str[:fp], EOF, state, idToken)

    except(IndexError):
        return ('', EOF, NONE, -1)
    

#### DFA for matching Operators
def isOp():
    state = OP
    fp = 0
    try:
        while True:
            if state == OP:
                if str[fp] in operators[:6]:
                    state = YES_OP
                elif str[fp] == ':':
                    state = ':'
                elif str[fp] == '>':
                    state = '>'
                elif str[fp] == '<':
                    state = '<'
                elif str[fp] == '!':
                    state = '!'
                elif str[fp] == '=':
                    state = '=='
                elif str[fp] == '&':
                    state = '&&'
                elif str[fp] == '|':
                    state = '||'
                else:
                    return ('', 0, NONE, -1)
                fp += 1

            elif state == YES_OP:
                try:
                    str[fp]
                    return (str[:fp], fp, YES_OP, tokenNum(opEnm, str[:fp]))
                except(IndexError):
                    return (str[:fp], EOF, YES_OP, tokenNum(opEnm, str[:fp]))

            elif state == ':' or state == '>' or state == '<' or state == '!':
                try:
                    if str[fp] == '=':
                        fp += 1
                        state = YES_OP
                    else:
                        state = YES_OP
                except(IndexError):
                    state = YES_OP

            elif state == '==':
                try:
                    if str[fp] == '=':
                        fp += 1
                        state = YES_OP
                    else:
                        return ('', 0, NONE, -1)
                except(IndexError):
                    return ('', 0, NONE, -1)

            elif state == '&&':
                try:
                    if str[fp] == '&':
                        fp += 1
                        state = YES_OP
                    else:
                        return ('', 0, NONE, -1)
                except(IndexError):
                    return ('', 0, NONE, -1)

            elif state == '||':
                try:
                    if str[fp] == '|':
                        fp += 1
                        state = YES_OP
                    else:
                        return ('', 0, NONE, -1)
                except(IndexError):
                    return ('', 0, NONE, -1)

    except(IndexError):
        return ('', EOF, NONE, -1)
    

#### DFA for matching Integers
def isInt():
    state = INT
    fp = 0
    try:
        while True:
            if state == INT:
                if str[fp] == '+' or str[fp] == '-':
                    state = '1'
                    fp += 1
                elif str[fp] in charSet[53:62]:
                    state = '2'
                    fp += 1
                elif str[fp] == '0':
                    state = '3'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '1':
                if str[fp] in charSet[53:62]:
                    state = '2'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '2':
                try:
                    if str[fp] in charSet[52:62]:
                        state = '2'
                        fp += 1
                    else:
                        state = YES_INT
                except(IndexError):
                    state = YES_INT

            elif state == '3':
                try:
                    if str[fp] == '0':
                        state = '3'
                        fp += 1
                    elif str[fp] in charSet[53:62]:
                        state = '4'
                        fp += 1
                    else:
                        state = YES_INT
                except(IndexError):
                    state = YES_INT

            elif state == '4':
                return ('', fp, NONE, -1)

            elif state == YES_INT:
                try:
                    str[fp]
                    return (str[:fp], fp, state, intToken)
                except(IndexError):
                    return (str[:fp], EOF, state, intToken)

    except(IndexError):
        return ('', EOF, NONE, -1)
    

#### DFA for matching Floating Point Numbers
def isFP():
    state = FP
    fp = 0
    try:
        while True:
            if state == FP:
                if str[fp] == '+' or str[fp] == '-':
                    state = '1'
                    fp += 1
                elif str[fp] in charSet[53:62]:
                    state = '2'
                    fp += 1
                elif str[fp] == '0':
                    state = '6'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '1':
                if str[fp] in charSet[53:62]:
                    state = '2'
                    fp += 1
                elif str[fp] == '0':
                    state = '8'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '2':
                if str[fp] in charSet[52:62]:
                    state = '2'
                    fp += 1
                elif str[fp] == '.':
                    state = '3'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '3':
                if str[fp] == '0':
                    state = '4'
                    fp += 1
                elif str[fp] in charSet[53:62]:
                    state = YES_FP
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '4':
                if str[fp] in charSet[53:62]:
                    state = YES_FP
                    fp += 1
                elif str[fp] == '0':
                    state = '4'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == YES_FP:
                try:
                    if str[fp] in charSet[52:62]:
                        state = YES_FP
                        fp += 1
                    else:
                        return (str[:fp], fp, state, fpToken)
                except(IndexError):
                    return (str[:fp], EOF, state, fpToken)

            elif state == '6':
                if str[fp] == '.':
                    state = '7'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '7':
                if str[fp] in charSet[52:62]:
                    state = YES_FP
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '8':
                if str[fp] == '.':
                    state = '3'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)
    except(IndexError):
        return ('', EOF, NONE, -1)
    

#### DFA for matching Delimiters
def isDelimiter():
    fp = 0
    state = DEL
    try:
        if str[fp] in delimiters:
            fp += 1
            state = YES_DEL

        if state == YES_DEL:
            try:
                str[fp]
                return (str[0], fp, state, tokenNum(delimEnm, str[0]))
            except(IndexError):
                return (str[0], EOF, state, tokenNum(delimEnm, str[0]))

        else:
            return ('', 0, NONE, -1)

    except(IndexError):
        return ('', EOF, NONE, -1)


#### DFA for matching String Literals
def isStr():
    state = STR
    fp = 0
    try:
        while True:
            if state == STR:
                if str[fp] == '"':
                    state = '1'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == '1':
                if str[fp] == '\\':
                    state = '3'
                    fp += 1
                elif str[fp] == '"':
                    state = YES_STR
                    fp += 1
                elif str[fp] not in ['\n', '\r', '\\', '"']:
                    state = '1'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

            elif state == YES_STR:
                try:
                    str[fp]
                    return (str[:fp], fp, state, strToken)
                except(IndexError):
                    return (str[:fp], EOF, state, strToken)

            elif state == '3':
                if str[fp] in ['\\', 'n', 'r', '"', 't']:
                    state = '1'
                    fp += 1
                else:
                    return ('', fp, NONE, -1)

    except(IndexError):
        return ('', EOF, NONE, -1)


#### Panic Mode Recovery in case none of the above dfas give a match.
def panic_mode():
    fp = 0
    while True:
        try:
            if str[fp] == '\n':
                return fp+1
            else:
                fp += 1
        except(IndexError):
            return -1