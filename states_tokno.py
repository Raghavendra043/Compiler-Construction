NONE = 0b00000000
EOF = -1
SP_OR_COMM, KW, ID, OP, INT, FP, DEL, STR = 'sp_comm', 'k', 'id', 'op', 'int', 'fp', 'del', 'str'
YES_SP_OR_COMM, YES_KW, YES_ID, YES_OP, YES_INT, YES_FP, YES_DEL, YES_STR = 0b10000000, 0b01000000, 0b00100000, 0b00010000, 0b00001000, 0b00000100, 0b00000010, 0b00000001

charSet = [
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_'
]

TokenNo = 0

spOrCommToken = TokenNo
TokenNo += 1

keywords = ['int', 'float', 'boolean', 'string',
            'while', 'until', 'if else', 'true', 'false']
keywordEnm = list(enumerate(keywords, start=TokenNo))
TokenNo += len(keywords)

idToken = TokenNo
TokenNo += 1

operators = ['+', '-', '*', '/', '%', '?', '>', '<', '!', ':',
             ':=', '==', '>=', '<=', '!=', '&&', '||']
opEnm = list(enumerate(operators, start=TokenNo))
TokenNo += len(operators)

intToken = TokenNo
TokenNo += 1

fpToken = TokenNo
TokenNo += 1

delimiters = ['{', '}', '[', ']', '(', ')', ';', ',']
delimEnm = list(enumerate(delimiters, start=TokenNo))
TokenNo += len(delimiters)

strToken = TokenNo
TokenNo += 1

IND_SP_COMM, IND_KW, IND_ID, IND_OP, IND_INT, IND_FP, IND_DEL, IND_STR = 0, 1, 2, 3, 4, 5, 6, 7

TokenNames = {
    IND_SP_COMM: 'Space / Comment',
    IND_KW: 'Keyword',
    IND_ID: 'Identifier',
    IND_OP: 'Operator',
    IND_INT: 'Integer Literal',
    IND_FP: 'Floating Point Literal',
    IND_DEL: 'Delimiter',
    IND_STR: 'String Literal'
}