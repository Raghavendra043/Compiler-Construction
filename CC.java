import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CC {

    public static void main(String agrs[]){
        
        try {
            int line = 0;
            File f = new File("test.txt");
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                line+=1;
                String S = s.nextLine();
                ArrayList<String> Token = new ArrayList<String>();
                System.out.println("Line :"+line);
                TokenType token =  new TokenType(S);
                System.out.println("Code : "+S);
                token.Token();
                System.out.print("\n---------------\n\n");
            }
            // System.out.println(token.isOperator());
            // System.out.println(token.isDelimeters());
        } 
        catch(Exception e){System.out.println(e);}

    }
    
}


class TokenType {
    
    String S;
    int pos = 0;

    TokenType (String S){
        this.S =  S;
    }
    public int getCurrent() {
        return this.S.charAt(this.pos);
    }
    void Token(){
        ArrayList<String> Tokens = new ArrayList<String>();

        while(this.pos < this.S.length()){
            if(getCurrent() == ' ' ){this.pos+=1;}           
            else if(isDelimeters()){this.pos+=1;}
            else if(isOperator()){this.pos+=1;}
            else{this.pos+=1;}
       }
        
        // return Tokens;
    }
	
	boolean isKeyword(String s) {
		
		return false;
	}
	
	boolean isOperator() {
        int check = 0;

        switch(this.S.charAt(this.pos))
        {
        case '+':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check = 1;
            }
            else
            {
                System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
                check+=1;
            }
            
            break;    
        case '-':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
                System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
                check+=1;
            }       
            break;    
        case '*':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            }       
            break;          
        case '/':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            } 
            break;    
        case '%': 
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            }  
            break;
        case ':':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            }  
            break;   
        case '>':
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            }  
            break;
        case '<':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            }  
            break;   
        case '!':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            }  
            break;   
        case '?':    
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos); 
            check+=1;
            break;
        case '=':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            }
            else
            {
            System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
            check+=1;
            }  
            break;  
        case '&':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='&')
            {
            System.out.println(this.S.charAt(this.pos)+"& is a operator at position "+this.pos);
            check+=1;
            }
            else{
            //System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos); }
            }
            break;
        case '|':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='|')
            {
            System.out.println(this.S.charAt(this.pos)+"| is a operator at position "+this.pos);
            check+=1;
            }
            // else
            //System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);      
            // check+=1;
            break;
        }

        if(check == 1){
            return true;
        }

		return false;
	}
	boolean isDelimeters() {
        int check = 0;

        switch(this.S.charAt(this.pos))
        {
            case '{':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);   
                check+=1;
                break;    
            case '}':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);      
                check+=1;
                break;    
            case '[':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);      
                check+=1;
                break;         
            case ']':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);   
                check+=1;
                break;    
            case '(':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);
                check+=1;
                break;   
            case ')':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);  
                check+=1;
                break;    
            case ';':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);   
                check+=1;
                break; 
            case ',':    
                System.out.println(this.S.charAt(this.pos)+" is a delimiter at position "+this.pos);    
                check+=1;
                break; 
        }

        if(check == 1){return true;}
		
		return false;
	}
	boolean isInt(String s) {

        int state = 0;
        for(int j=0;j<s.length();j++){
            int Ch = s.charAt(j);
            switch(state){
                case 0: {
                    if(Ch == 48){
                        state = 2;
                        break;
                    } else if(Ch > 48 && Ch<=57){
                        state = 1;
                        break;
                    }
                }
                case 1: {
                    if(Ch >=48 && Ch<=57){
                        state = 1;
                        break;
                    } else {
                        state = -1;
                        break;
                    }
                }
                case 2: {
                    if(Ch ==48){
                        state = -1;
                        break;
                    } else if(Ch>48 && Ch<=57){
                        state = 1;
                        break;
                    }
                }
                case -1:{
                    return false;
                }
            }

        }
        if(state ==1){
            return true;
        }
		return false;
	}
	boolean isFloat(String s) {

        int state = 0;
        for(int j=0;j<s.length();j++){
            int Ch = s.charAt(j);
            switch(state){
                case 0: {
                    if(Ch == 48){
                        state = 2;
                    } else if(Ch > 48 && Ch<=57){
                        state = 1;
                    } else if(Ch == 46){
                        state = 3;
                    }
                    break;
                }
                case 1: {
                    if(Ch >=48 && Ch<=57){
                        state = 1;
                    } else if(Ch == 46){
                        state = 3;
                    }
                    else {
                        state = -1;   
                    } 
                    break;
                }
                case 2: {
                    if(Ch ==48){
                        state = -1;
                    } else if(Ch>48 && Ch<=57){
                        state = 1;
                    } else if(Ch == 46){    
                        state = 3;
                    }
                    break;
                }
                case 3:{
                    if(Ch >=48 && Ch<=57){
                        state = 3;
                    } else {
                        state = -1;   
                    } 
                    break;
                }
                case -1:{
                    return false;
                }
            }

        }
        if(state != -1){
            return true;
        }
		return false;
	}
	boolean isStringLiteral(String s) {
		
		return false;
	}
	
}

