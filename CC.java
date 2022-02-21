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
        int start = 0;
        int end = 0;
        
        while(this.pos < this.S.length()){
            int state = 0;
            if(getCurrent() == '#'){
                System.out.println(this.S.substring(this.pos, this.S.length()-1)+" is Comment");
                break;
            }
            else if(getCurrent() == ' ' ){
                this.pos+=1;if(start==end){start+=1;end+=1;}else{
                    state = 1; 
                }
            } else if(getCurrent() == '"'){
                isStringLiteral();
                end = this.pos;
                start = end;
            }
            else if(isDelimeters()){this.pos+=1;state = 1;}
            else if(isOperator()){this.pos+=1;state = 1;}
            else{this.pos+=1;end+=1;}

            if(state == 1){
                if(isKeyword(start, end)){
                } else if(isIdentifier(start, end)){
                } else if(isInt(this.S.substring(start, end))){
                    System.out.println(this.S.substring(start, end)+" is an int");
                } else if(isFloat(this.S.substring(start, end))){
                    System.out.println(this.S.substring(start, end)+" is a float");
                } else{
                    if(start==end || (this.pos<this.S.length() && getCurrent() == ' ')){}else {
                    System.out.println("%"+this.S.substring(start, end)+"%is nothing"+start+","+end+","+this.pos);}
                }
                end = this.pos;
                start = end;
                state = 0;
            }
       }
        
        // return Tokens;
    }
	
	boolean isKeyword(int a, int b) {
		
        // int a = 0, b = 5 ;
    	
        //String str1 = "float";
                
        String keywords[]={"int", "float", "boolean", "string", "while", "until", "if", "else", "true", "false", "BRO", "bruh"};   

        for(int i =0; i < keywords.length; i++) {
        if (this.S.substring(a, b).equals(keywords[i])) {
            System.out.println("The Keyword " + keywords[i] +" is found in given string");
            return true;
        } 
        
        }

    	return false;
	}
	boolean isIdentifier(int a, int b){
        // int a = 0, b = 5 ;
	    int i = a, p=0;

        if(a==b){return false;}
	
	
		if((this.S.charAt(i)>=65 && this.S.charAt(i)<=90) || (this.S.charAt(i)>=97 && this.S.charAt(i)<=122)) 
		{
			
            i++; 
            p++;
            if( b-i > 1 ) 
            {
	            while ((this.S.charAt(i)>=65 && this.S.charAt(i)<=90) || (this.S.charAt(i)>=97 && this.S.charAt(i)<=122) || (this.S.charAt(i)==95) || (this.S.charAt(i)>=48 && this.S.charAt(i)<=57)) 
				{ 
	            	i++;
	            	p++;
	           		if (i == b) {
	           			break;
	           		}
	           		
	           		
	             }
            }
        }
		if( p == b-a ) {
			System.out.println(this.S.substring(a, b) + " is a identifier");
            return true;
		}

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
            this.pos+=1;
            }
            else
            {
                if(this.pos+1<this.S.length() && isInt( String.valueOf((this.S.charAt(this.pos+1)) )  ) ){
                    check = 0;
                }else{
                System.out.println(this.S.charAt(this.pos)+" is a operator at position "+this.pos);	
                check+=1;}
            }
            
            break;    
        case '-':    
            if (this.pos+1 < this.S.length() && this.S.charAt(this.pos+1)=='=')
            {
            System.out.println(this.S.charAt(this.pos)+"= is a operator at position "+this.pos);
            check+=1;
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
            this.pos+=1;
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
                        state = 1;
                        break;
                    } else if(Ch > 48 && Ch<=57){
                        state = 2;
                        break;
                    } else if(Ch == 43 || Ch == 45){
                        state = 3;
                        break;
                    }
                }
                case 1: {
                    if(Ch==48){
                        state = -1;
                        break;
                    }
                    else if(Ch >48 && Ch<=57){
                        state = 1;
                        break;
                    } else {
                        state = -1;
                        break;
                    }
                }
                case 2: {

                    if(Ch>=48 && Ch<=57){
                        state = 2;
                        break;
                    }
                }
                case 3:{
                    if(Ch>48 && Ch<=57){
                        state = 2;
                        break;
                    } else if(Ch == 48){
                        state=1;
                        break;
                    }
                }
                case -1:{
                    return false;
                }
            }

        }
        if(state ==1 || state == 2){
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
        if(state != -1 && state != 0){
            return true;
        }
		return false;
	}
	void isStringLiteral() {
        int state = 0;
        int f = 0;
        int start = this.pos;
        int end = start;
        while(this.pos < this.S.length()){

            switch(state){
                case 0:{
                    if(getCurrent()=='"'){state=1;this.pos+=1;end+=1;}
                    break;
                }
                case 1:{
                    if(getCurrent()=='"'){
                        this.pos+=1;
                        end+=1;
                        f= 1;
                    } else if(getCurrent() == 47 ){
                        if(this.pos+1<this.S.length() && (this.S.charAt(this.pos+1) == 'n' || this.S.charAt(this.pos+1) == 'r' || this.S.charAt(this.pos+1) == 't') ){
                            this.pos+=1;
                            state=1;end+=1;
                        }else{
                            state = 1;end+=1;this.pos+=1;
                        }
                    }else{
                        state = 1;this.pos+=1;end+=1;
                    }
                    break;
                }
            }
            if(f==1){
                System.out.println(this.S.substring(start, end)+"& is a String literal");
                break;
            }
        }
        if(f!=1){
            System.out.println("Error");
        }
	}
	
}

