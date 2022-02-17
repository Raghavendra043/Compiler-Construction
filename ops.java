
public class ops {

public static void main(String[] args) {
String Str="String Operators1[]={\"+\",\"-\",\"*\",\"/\",\"%\",\":\",\">\",\"<\",\"!\",\"?\",\">=\",\"<=\",\":=\",\"==\",\"!=\",\"&&\",\"||\"};";

String Operators1[]={"+","-","*","/","%",":",">","<","!","?",">=","<=",":=","==","!=","&&","||"};

for (int i = 0; i < Str.length(); i++) {
    
	switch(Str.charAt(i))
	{
	case '+':    
		System.out.println(Str.charAt(i)+": is a operator at position "+i);   
        break;    
    case '-':    
    	System.out.println(Str.charAt(i)+": is a operator at position "+i);      
        break;    
    case '*':    
    	System.out.println(Str.charAt(i)+": is a operator at position "+i);       
        break;         
    case '/':    
    	System.out.println(Str.charAt(i)+": is a operator at position "+i);   
        break;    
    case '%':    
    	System.out.println(Str.charAt(i)+": is a operator at position "+i);    
        break;    
    case ':':    
    	if (Str.charAt(i+1)=='=')
    	{
    	System.out.println(Str.charAt(i)+"=: is a operator at position "+i);
    	i++;
    	}
    	else
    	{
    		System.out.println(Str.charAt(i)+": is a operator at position "+i);	
    	}
        break;   
    case '>':
    	if (Str.charAt(i+1)=='=')
    	{
    	System.out.println(Str.charAt(i)+"=: is a operator at position "+i);
    	i++;
    	}
    	else
    	{
    		System.out.println(Str.charAt(i)+": is a operator at position "+i);	
    	}
        break;
    case '<':    
    	if (Str.charAt(i+1)=='=')
    	{
    	System.out.println(Str.charAt(i)+"=: is a operator at position "+i);
    	i++;
    	}
    	else
    	{
    		System.out.println(Str.charAt(i)+": is a operator at position "+i);	
    	}
        break;    
    case '!':    
    	if (Str.charAt(i+1)=='=')
    	{
    	System.out.println(Str.charAt(i)+"=: is a operator at position "+i);
    	i++;
    	}
    	else
    	{
    		System.out.println(Str.charAt(i)+": is a operator at position "+i);	
    	}
        break;   
    case '?':    
    	System.out.println(Str.charAt(i)+": is a operator at position "+i);     
        break;
    case '=':    
    	if (Str.charAt(i+1)=='=')
    	{
    	System.out.println(Str.charAt(i)+"=: is a operator at position "+i);
    	i++;
    	}
    	else
    	//{System.out.println(Str.charAt(i)+": is a operator at position "+i);	}
        break;  
    case '&':    
    	if (Str.charAt(i+1)=='&')
    	{
    	System.out.println(Str.charAt(i)+"&: is a operator at position "+i);
    	i++;
    	}
    	else
    	//{System.out.println(Str.charAt(i)+": is a operator at position "+i);	}
        break; 
    case '|':    
    	if (Str.charAt(i+1)=='|')
    	{
    	System.out.println(Str.charAt(i)+"|: is a operator at position "+i);
    	i++;
    	}
    	else
    	//{System.out.println(Str.charAt(i)+": is a operator at position "+i);	}
        break;
	}
	}
}
}