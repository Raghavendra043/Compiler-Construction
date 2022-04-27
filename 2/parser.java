import java.io.File;
import java.io.FileWriter;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class parser {

    public static void main(String[] args) {
        try {
            int line = 0;
            File f = new File("cfg.txt");
            Scanner s = new Scanner(f);
            
            List<production> Productions = new ArrayList<production>();
            while (s.hasNext()) {
                String S = s.nextLine();
                
                String first = " ";
                for(int i=0;i<S.length();i++){
                    if(S.charAt(i) ==' '){ first = S.substring(0, i);break;}
                }
                Productions.add(new production(first, wordcount(S)-2));     
                
                

            }
            
            ParserTable table = new ParserTable();
            List<String> stack = new ArrayList<String>();

            stack.add("0");
            //String[] test = {"INT", "MAIN", "(",  ")",  "{", "return", "0",";" ,"}","$"};
            //String[] test = {"INT", "MAIN", "(", ")", "{", "if", "(", "IDENTIFIER", ">", "INT",")", "{", "bruh", "(", "SL",")", ";", "}", "return", "0", ";", "}", "$"};

            String[] test = {"INT", "MAIN", "(", ")", "{", "for", "(", "IDENTIFIER", "=", "INT", "IDENTIFIER", ">" ,"INT", ";", "IDENTIFIER", "++",  ")", "{", "if", "(",  "IDENTIFIER" ,">" ,"INT", ")", "{", "bruh", "(", "SL", ")", ";", "}", "else", "{", "if", "(", "IDENTIFIER", ">", "FLOAT", ")", "{", "bruh", "(", "SL", ")", ";", "}", "}", "}", "}", "$"};

            int k = 0;
            int present = 0;
            int current = 0;


            String check = " ";
            while(!check.equals("acc")){
                System.out.println("\n________________________________\n");
                NonTerminal a1 = table.Acc.get(present);
                String a = a1.Map.get(test[current]);
                check = a;
                System.out.println(a);
                
                // String a2 = a2.Map.get(test[current]);
                

                if(a.charAt(0) == 's'){
                    stack.add(test[current]);

                    if(a.length() == 2){
                        stack.add(String.valueOf(a.charAt(1)));    
                    }else{
                        stack.add(a.substring(1, 3));
                    }
                    
                    present = Integer.parseInt(stack.get(stack.size()-1));
                    current+=1;
                }
                else if(a.charAt(0) == 'r'){

                    

                    int len = stack.size() - 1;
                    int res = 0;
                    if(a.length() == 2){
                        res = Integer.parseInt(String.valueOf(a.charAt(1)));    
                    }else{
                        res = Integer.parseInt(a.substring(1, 3));
                    }

                    // int res = Integer.parseInt(String.valueOf(a.charAt(1)));
                    int num = Productions.get(res).l*2;

                    for(int m=0;m<num;m++){
                        int l = stack.size() - 1;
                        stack.remove(l);
                    }
                    stack.add(Productions.get(res).NT);

                    if(res == 14){
                        System.out.println(num+", "+Productions.get(res).NT);
                    }

                    String curr = stack.get(stack.size()-1);
                    int pre = Integer.parseInt(stack.get(stack.size()-2) ) ;

                    NonTerminal a2 = table.Got.get(pre);

                    String ans = a2.Map.get(curr);

                    present = Integer.parseInt(ans);
                    
                    stack.add(ans);

                }
                for(int i=0;i<stack.size();i++){
                    System.out.print(stack.get(i)+",");
                }
                // break;
                k++;
            }
            
        } 
        catch(Exception e){
            System.out.println("Error- "+e);
        }
    }

    
        
    
        public static int wordcount(String string)  {  
            int count=0;  
              char ch[]= new char[string.length()];
              
              for(int i=0;i<string.length();i++)  
              {  
                  ch[i]= string.charAt(i);  
                  if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                      count++;  
              }
              if(String.valueOf(string.charAt(string.length()-1)).equals("$")){
                count-=1;
              }  
              return count;  
          }  
        
    
}

class production{

    String NT;
    int l;

    production(String Nt, int l){
        this.NT = Nt;
        this.l = l;
    }
}

class ParserTable{
    List<NonTerminal> Acc;
    List<NonTerminal> Got;

    ParserTable(){
        try {
            File f = new File("table1.txt");
            Scanner s = new Scanner(f);
            int i=0;
            List<NonTerminal> acc = new ArrayList<NonTerminal>();
            List<NonTerminal> got = new ArrayList<NonTerminal>();
            String Action[] = new String[1000];
            String Goto[] = new String[1000];
            while (s.hasNext()) {
                
                String S = s.nextLine();
                
                if(i==0){
                    Action = S.split("\\s+");
                    for(int j=  0;j<Action.length;j++){
                        System.out.print(Action[j]+",");
                    }
                }else if(i==1){
                    Goto = S.split("\t");
                    for(int j=  0;j<Goto.length;j++){
                        System.out.print(Goto[j]+",");
                    }
                }
                else{
                    String[] value = S.split("\t");
                    NonTerminal X = new NonTerminal(Action, value);
                    NonTerminal X1 = new NonTerminal(Goto, value, Action.length);
                    // System.out.println("\n-----------------------------\n");
                    
                    if(i == 13){
                    System.out.println(i-2);
                    for (Map.Entry<String, String> e : X.Map.entrySet()){
                        System.out.println("Key: " + e.getKey()+ " Value: " + e.getValue());
                    }
                    System.out.println("\n-----------------------------\n");
                    for (Map.Entry<String, String> e : X1.Map.entrySet()){
                        System.out.println("Key: " + e.getKey()+ " Value: " + e.getValue());
                    }
                }
                    
                    acc.add(X);
                    got.add(X1);
                }
                
                i++;
            }
            
            System.out.print(acc.get(11).Map.get("while"));
            this.Acc = acc;
            this.Got = got;
        } 
        catch(Exception e){System.out.println("Error- "+e);

        }
    }
}

class NonTerminal {
    HashMap<String, String> Map;

    NonTerminal(String[] title , String[] value){
        HashMap<String, String> map = new HashMap<>();
        for(int j=0;j<title.length;j++){
            map.put(title[j], value[j+1]);
        }
        this.Map = map;    
    }

    NonTerminal(String[] title , String[] value, int a){
        HashMap<String, String> map = new HashMap<>();
        for(int j=0;j<title.length;j++){
            map.put(title[j], value[a+j+1]);
        }
        this.Map = map;    
    }
}
