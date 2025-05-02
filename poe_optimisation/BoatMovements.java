package poe_optimisation;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        // Vérifier si les positions sont dans les limites de la matrice
        if (fromRow < 0 || fromRow >= gameMatrix.length ||
                fromColumn < 0 || fromColumn >= gameMatrix[fromRow].length ||
                toRow < 0 || toRow >= gameMatrix.length ||
                toColumn < 0 || toColumn >= gameMatrix[toRow].length) {
            return false;
        }

        // Vérifier si le bateau se déplace
        if (fromRow == toRow && fromColumn == toColumn) {
            return false; // Le bateau ne se déplace pas
        }

        // Sens du déplacement
        int g = 0, d = 0, h = 0, b = 0;

        if (fromRow == toRow) {
            if (fromColumn > toColumn) {
                g = 1; // Déplacement à gauche
            } else {
                d = 1; // Déplacement à droite
            }
        } else if (fromColumn == toColumn) {
            if (fromRow > toRow) {
                h = 1; // Déplacement vers le haut
            } else {
                b = 1; // Déplacement vers le bas
            }
        } else {
            return false; // Déplacement non pris en charge
        }

        // Valider les déplacements
        if (g == 1) { // Déplacement à gauche
            for (int i = fromColumn - 1; i >= toColumn; i--) {
                if (!gameMatrix[fromRow][i]) {
                    return false; // Ne peut pas traverser la terre
                }
            }
            return true;
        } else if (d == 1) { // Déplacement à droite
            for (int i = fromColumn + 1; i <= toColumn; i++) {
                if (!gameMatrix[fromRow][i]) {
                    return false; // Ne peut pas traverser la terre
                }
            }
            return true;
        } else if (h == 1) { // Déplacement vers le haut
            for (int i = fromRow - 1; i >= toRow; i--) {
                if (!gameMatrix[i][fromColumn]) {
                    return false; // Ne peut pas traverser la terre
                }
            }
            return true;
        } else if (b == 1) { // Déplacement vers le bas
            for (int i = fromRow + 1; i <= toRow; i++) {
                if (!gameMatrix[i][fromColumn]) {
                    return false; // Ne peut pas traverser la terre
                }
            }
            return true;
        }

        return false; // Si aucune condition n'est remplie
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                { false, true, true, false, false, false },
                { true, true, true, false, false, false },
                { true, true, true, true, true, true },
                { false, true, true, false, true, true },
                { false, true, true, true, false, true },
                { false, false, false, false, false, false },
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}