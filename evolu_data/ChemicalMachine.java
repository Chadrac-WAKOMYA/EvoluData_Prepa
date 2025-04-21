package evolu_data;

import java.util.ArrayList;
import java.util.List;

public class ChemicalMachine
{
    public static List<String> applyHeat(List<String> ingredients)
    {
        List <String> retour = new ArrayList<>();
        String [] ingredientsTab = {" ", " "};
        int i = 0;

        for(String ingredient : ingredients){
            ingredientsTab[i] = ingredient;
            i += 1;
        }
        

        if(ingredientsTab[0] == "CYAN" && ingredientsTab[1] == "GREEN"){
            retour.add("ORANGE");   
        }else if (ingredientsTab[0] == "GREEN" && ingredientsTab[1] == "YELLOW"){
            retour.add("BROWN");
            retour.add("YELLOW");                        
        }else if (ingredientsTab[0] == "BROWN" && ingredientsTab[1] == "YELLOW"){            
            retour.add("MAGENTA");
        }else{
            retour.add("UNKNOWN");
        }
        

        return retour;
    }
    
    public static void main(String[] args)
    {
        List <String> one = new ArrayList<>();
        List <String> two = new ArrayList<>();
        one.add("BROWN");
        one.add("YELLOW");
        two.add("YELLOW");
        two.add("BROWN");

        System.out.println(applyHeat(one)); // should print [MAGENTA]
        System.out.println(applyHeat(two)); // should print [UNKNOWN]
    }
}