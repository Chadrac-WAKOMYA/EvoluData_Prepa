package my_code;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        // Vérifier si les positions sont dans les limites de la matrice
        if (fromRow < 0 || fromRow >= gameMatrix.length ||
                fromColumn < 0 || fromColumn >= gameMatrix[0].length || // Correction ici
                toRow < 0 || toRow >= gameMatrix.length ||
                toColumn < 0 || toColumn >= gameMatrix[0].length) { // Correction ici
            return false; // Coordonnées hors limites
        }

        // Vérifier si le bateau se déplace à une position différente
        if (fromRow == toRow && fromColumn == toColumn) {
            return false; // Le bateau ne se déplace pas
        }

        // Déterminer la direction du mouvement
        if (fromRow == toRow) { // Mouvement horizontal
            int startCol = Math.min(fromColumn, toColumn);
            int endCol = Math.max(fromColumn, toColumn);
            for (int i = startCol; i <= endCol; i++) {
                if (!gameMatrix[fromRow][i]) {
                    return false; // Ne peut pas traverser la terre
                }
            }
            return true;
        } else if (fromColumn == toColumn) { // Mouvement vertical
            int startRow = Math.min(fromRow, toRow);
            int endRow = Math.max(fromRow, toRow);
            for (int i = startRow; i <= endRow; i++) {
                if (!gameMatrix[i][fromColumn]) {
                    return false; // Ne peut pas traverser la terre
                }
            }
            return true;
        }

        return false; // Déplacement non pris en charge
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

        // Tests
        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 2)); // false, No movement
    }
}