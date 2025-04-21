package evolu_data;

import java.util.Arrays;
import java.util.List;

public class DigitalFlasks {
    public static int getCount(List<Integer> flaskSizes, int waterAvailable, int tankVolume) {
        
        int actualTankVolume = tankVolume;
        int retour = 0;
        
        if(waterAvailable < tankVolume){
            return -1;
        }else{
            
            while (actualTankVolume > 0){
                for(int fiole : flaskSizes ){
                    
                    if(actualTankVolume > fiole){
                        actualTankVolume -= fiole;
                        retour += 1;
                    }else{
                        continue;
                    }
                    
                }
            }            
            
        }

        return retour;            
        
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 3, 7, 1, 5, 4);
        System.out.println(getCount(input, 100, 34));
    }
}
