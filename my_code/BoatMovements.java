package my_code;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        // throw new UnsupportedOperationException("Waiting to be implemented.");

        //Est ce que la position choisie est dans le repère ?
        if(fromColumn < 0 || fromRow < 0 || toColumn >= gameMatrix.length || toRow >= gameMatrix.length){
            return false; 
        }

        // Sens du déplacement devant ou derrière à gauche ou à droite
        int g = 0, d = 0, h = 0, b = 0;

        if (fromColumn == fromRow && fromColumn == toColumn && fromColumn == toRow){
            return false; // Le boat ne se déplce pas
        }else if (fromRow == toRow){
            if (fromColumn > toColumn) {
                g = 1;
            }else{
                d = 1;
            }
        }else if(fromColumn == toColumn){
            if (fromRow > toRow) {
                h = 1;
            }else{
                b = 1;
            }
        }else{
            return false; // Déplacement non pris en charge
        }


        // Valider les déplacements
        if(g == 1){
            for(int i = fromColumn -1; i >= toColumn; i-- ){
                if(gameMatrix[fromRow][i]) return false;
                return gameMatrix[fromRow][i];
            }
        }else if(d == 1){

        }else if(h == 1){

        }else if(b == 1){

        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
            {false, true,  true,  false, false, false},
            {true,  true,  true,  false, false, false},
            {true,  true,  true,  true,  true,  true},
            {false, true,  true,  false, true,  true},
            {false, true,  true,  true,  false, true},
            {false, false, false, false, false, false},
        };
        
        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}
