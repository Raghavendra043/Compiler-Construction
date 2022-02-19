
public class delimiters {

public static void main(String[] args) {
String Str="String delimiters[] = {\"{\", \"}\", \"[\", \"]\", \"(\", \")\", \";\", \",\"};";

String delimiters[] = {"{", "}", "[", "]", "(", ")", ";", ","};

for (int i = 0; i < Str.length(); i++) {
    
	switch(Str.charAt(i))
	{
	case '{':    
		System.out.println(Str.charAt(i)+": is a delimiter at position "+i);   
        break;    
    case '}':    
    	System.out.println(Str.charAt(i)+": is a delimiter at position "+i);      
        break;    
    case '[':    
    	System.out.println(Str.charAt(i)+": is a delimiter at position "+i);       
        break;         
    case ']':    
    	System.out.println(Str.charAt(i)+": is a delimiter at position "+i);   
        break;    
    case '(':    
    	System.out.println(Str.charAt(i)+": is a delimiter at position "+i);    
        break;   
    case ')':    
    	System.out.println(Str.charAt(i)+": is a delimiter at position "+i);   
        break;    
    case ';':    
    	System.out.println(Str.charAt(i)+": is a delimiter at position "+i);    
        break; 
    case ',':    
    	System.out.println(Str.charAt(i)+": is a delimiter at position "+i);    
        break; 
	}
	}
}
}