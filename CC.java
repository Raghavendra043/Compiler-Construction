import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CC {

    public static void main(String agrs[]){
        
        try {
            int line = 0;
            File f = new File("test.txt");
            Scanner s = new Scanner(f);
            TokenType token =  new TokenType("wf");
            while (s.hasNext()) {
                line+=1;
                System.out.println(s.nextLine());
                ArrayList<String> Token = new ArrayList<String>();
            //    Token = token.Token(s.nextLine());
            }

            
            System.out.println(token.isOperator());
            System.out.println(token.isDelimeters());
            System.out.println(token.isKeyword());


            
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
    ArrayList<String> Token(){
        ArrayList<String> Tokens = new ArrayList<String>();

        //while(this.pos < this.S.length()){
        //    if(getCurrent() == 46){this.pos+=1;}
        //    else if(getCurrent() == hash) {Tokens.add();break;}
//
//        }
        
        return Tokens;
    }
	
	boolean isKeyword() {
		
        int a = 4, b = 20 ;
    	
        //String str1 = "int float boolean string while until if else true false a = 5 ;";
                
        String keywords[]={"int", "float", "boolean", "string", "while", "until", "if", "else", "true", "false"};   

        for(int i =0; i < keywords.length; i++) {
        	
        if (this.S.substring(a, b).contains(keywords[i])) {
            System.out.println("The Keyword " + keywords[i] +" is found in given string");
           
        }
        }

    	return true;
	}
	
	boolean isOperator() {

        switch(S.charAt(this.pos))
        {
        case '+':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
                System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }
            
            break;    
        case '-':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
                System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }       
            break;    
        case '*':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }       
            break;          
        case '/':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            } 
            break;    
        case '%': 
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }  
            break;
        case ':':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }  
            break;   
        case '>':
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }  
            break;
        case '<':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }  
            break;   
        case '!':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }  
            break;   
        case '?':    
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos); 
            break;
        case '=':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='=')
            {
            System.out.println(S.charAt(this.pos)+"= is a operator at position "+this.pos);
            }
            else
            {
            System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);	
            }  
            break;  
        case '&':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='&')
            {
            System.out.println(S.charAt(this.pos)+"& is a operator at position "+this.pos);
            }
            else
            //System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);      
            break;
        case '|':    
            if (this.pos+1 < S.length() && S.charAt(this.pos+1)=='|')
            {
            System.out.println(S.charAt(this.pos)+"| is a operator at position "+this.pos);
            }
            else
            //System.out.println(S.charAt(this.pos)+" is a operator at position "+this.pos);      
            break;
        }


		
		return true;
	}
	boolean isDelimeters() {

        switch(S.charAt(this.pos))
        {
            case '{':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);   
                break;    
            case '}':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);      
                break;    
            case '[':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);      
                break;         
            case ']':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);   
                break;    
            case '(':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);
                break;   
            case ')':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);  
                break;    
            case ';':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);   
                break; 
            case ',':    
                System.out.println(S.charAt(this.pos)+": is a delimiter at position "+this.pos);    
                break; 
        }

		
		return true;
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

