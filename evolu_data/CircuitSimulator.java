package evolu_data;

public class CircuitSimulator {
    public static boolean simulate(boolean input1, boolean input2, boolean input3, boolean input4) {
        boolean inputA = input2 && input3;
        boolean inputB = inputA || input4;
        
        return input1 && inputB;
    }
    
    public static void main(String[] args) {
        System.out.println(simulate(true, false, false, true)); // should print true
    }
}
