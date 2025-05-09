package my_code;

public class teste {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        double finalSpeed = initialSpeed;
        for(int nbr : inclinations){
            finalSpeed -= nbr;
            if(finalSpeed <= 0)
                return 0;
        }
        return finalSpeed;
    }

    public static void main(String[] args){
        System.out.println(calculateFinalSpeed(60.0, new int[] { 0, 30, 0, -45, 0 }));
    }
}

