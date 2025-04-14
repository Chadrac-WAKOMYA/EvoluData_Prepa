package my_code;

public class RoutePlanner {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        // throw new UnsupportedOperationException("Waiting to be implemented.");
        // Tester si le départ et l'arrivé sont dans mapMatrix 
        if(fromRow < 0 || fromRow >= mapMatrix.length ||
        fromColumn < 0 || fromColumn >= mapMatrix[0].length ||
        toRow < 0 || toRow >= mapMatrix.length ||
        toColumn < 0 || toColumn >= mapMatrix[0].length
        ){
            return false;
        }

        // Tester si le départ et l'arrivé  sont vrais
        if(!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]){
            return false; // Départ ou destination impossible
        }


        // Tester le changement d'itinéraire
        if(fromRow == toRow && fromColumn == toColumn){
            return false; // Il y a pas changement d'itinéraire
        }
        return  false;
    }
        
    public static void main(String[] args) {
        boolean[][] mapMatrix = {
            {true,  false, false},
            {true,  true,  false},
            {false, true,  true}
        };
        
        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
