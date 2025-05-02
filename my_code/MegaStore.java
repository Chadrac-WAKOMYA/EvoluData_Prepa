package my_code;

public class MegaStore {

    public enum DiscountType {
        Standard,
        Seasonal,
        Weight;
    }

    public static double getDiscountedPrice(double cartWeight,
            double totalPrice,
            DiscountType discountType) {
        double discount = 0.0;

        switch (discountType) {
            case Standard:
                discount = 0.06; // Remise de 6%
                break;
            case Seasonal:
                discount = 0.12; // Remise de 12%
                break;
            case Weight:
                if (cartWeight > 10) {
                    discount = 0.18; // Remise de 18% si le poids est supérieur à 10
                } else {
                    discount = 0.06; // Remise de 6% autres cas
                }
                break;
        }

        return totalPrice * (1 - discount); // Calcule le prix après remise
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}
