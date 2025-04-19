package poe_optimisation;

public class RechercheTriee {
    public static int countNumbers(int[] arr, int lessThan) {
        int left = 0;
        int right = arr.length - 1;

        // Effectuer une recherche binaire
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < lessThan) {
                left = mid + 1; // Cherche à droite
            } else {
                right = mid - 1; // Cherche à gauche
            }
        }

        // `left` représente le nombre d'éléments inférieurs à `lessThan`
        return left; 
    }

    public static void main(String[] args) {
        System.out.println(RechercheTriee.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}
