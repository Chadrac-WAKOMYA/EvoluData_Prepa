package evolu_data;


import java.util.HashMap;
import java.util.Map;

public class NumbersToText {    
    public static String numbersToLetters(String s) {
        Map <Integer, String> myDico = new HashMap<>();
        myDico.put(1,"A");
        myDico.put(2,"B");
        myDico.put(3,"C");
        myDico.put(4,"D");
        myDico.put(5,"E");
        myDico.put(6,"F");
        myDico.put(7,"G");
        myDico.put(8,"H");
        myDico.put(9,"I");
        myDico.put(10,"J");
        myDico.put(11,"K");
        myDico.put(12,"L");
        myDico.put(13,"M");
        myDico.put(14,"N");
        myDico.put(15,"O");
        myDico.put(16,"P");
        myDico.put(17,"Q");
        myDico.put(18,"R");
        myDico.put(19,"S");
        myDico.put(20,"T");
        myDico.put(21,"U");
        myDico.put(22,"V");
        myDico.put(23,"W");
        myDico.put(24,"X");
        myDico.put(25,"Y");
        myDico.put(26,"Z");

        String retour = "";

        for(int i = 0; i < s.length(); i++){
            String tmp = "";
            char c = s.charAt(i);
            if(c == '+' ){
                retour += " ";
            }               
            else if (c == ' '){
                retour += myDico.get(Integer.parseInt(tmp));
                tmp = "";
            }                
            else {
                tmp += String.valueOf(c);                
            }    
        }

        return retour;
        
    }
    
    public static void main(String[] args) {
        System.out.println(numbersToLetters("20 5 19 20+4 15 13 5"));
    }
}
