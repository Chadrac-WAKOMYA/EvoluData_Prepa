package my_code;

public class RechercheTriee {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int retour = 0;
        for(int nb : sortedArray ){
            if(nb < lessThan) 
                retour += 1;
        } 
        return retour;
    }
    
    public static void main(String[] args) {
        System.out.println(RechercheTriee.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}
