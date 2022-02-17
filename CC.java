import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CC {

    public static void main(String agrs[]){
        
        try {
            int line = 0;
            File f = new File("test.txt");
            Scanner s = new Scanner(f);
            TokenType token =  new TokenType();
            while (s.hasNext()) {
                line+=1;
                System.out.println(s.nextLine());
                ArrayList<String> Token = new ArrayList<String>();
                Token = token.Token(s.nextLine());
            }
            
        } 
        catch(Exception e){System.out.println(e);}

    }
    
}


class TokenType {

    ArrayList<String> Token(String s){

        
        return 1;
    }
	
	boolean isKeyword(String s) {
		
		return false;
	}
	
	boolean isOperator(String s) {
		
		return false;
	}
	boolean isDelimeters(String s) {
		
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
