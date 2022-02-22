import sys
import dfa
import Scanner
from states_tokno import EOF

if __name__ == '__main__':
    with open(sys.argv[1], 'r', 1) as f:
        Scanner.bindStream(f)
        eof = False
        lp, lineNo = 0, 1
        while not eof:
            temp = dfa.DFA()
            lineNo += temp[1]
            nextToken = temp[0]
            tokenName = temp[2]
            
            if nextToken == None:
                lp = dfa.panic_mode()
                if lp == -1:
                    eof = 1
                else:
                    lineNo += 1
            else:
                if nextToken[1] == EOF:
                    eof = 1
                else:
                    lp = nextToken[1]
                if nextToken[2] != 0b10000000:
                    print('line no:', lineNo, '<', tokenName, ',', nextToken[0], '>', nextToken[3])
            
            Scanner.setLP(lp)
