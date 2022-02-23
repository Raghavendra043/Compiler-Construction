import sys
import dfa
from Scanner import bindStream, setLP, errorRead
from Constants import EOF

if __name__ == '__main__':
    with open(sys.argv[1], 'r', 1) as f:
        bindStream(f)   # Binds the file input stream to the Scanner
        eof = False
        lp, lineNo = 0, 1
        with open('Output_'+sys.argv[1], 'w') as o:
            o.truncate()
            while not eof:
                setLP(lp)
                # Calls the dfa simulator which returns:
                # (the token, lineNo(to keep track of line numbers), TokenName)
                temp = dfa.DFA()
                nextToken = temp[0]
                lineNo += temp[1]
                tokenName = temp[2]
                
                # When none dfas match, it uses panic mode recovery 
                # to skip the line and move to the next line if there is one.
                if nextToken == None:   
                    lp = dfa.panic_mode()
                    o.write('----Error at Line '+str(lineNo)+
                            ': '+errorRead()+'\n')
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
                        o.write('Line '+str(lineNo)+'  '+'Token '+str(nextToken[3])+
                                '  '+'< '+tokenName+'   '+nextToken[0]+' >'+'\n')