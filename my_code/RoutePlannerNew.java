package my_code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RoutePlannerNew {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        // Variables importantes
        Set <int[]> cheminParcourus = new HashSet<>();
        Queue <int []> futurCheminAExplorer = new LinkedList<>();
        // Map <String, int[]> futurCheminAExplorer = new HashMap<>();

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

        // Initialisation de la variable importante futurCheminAExplorer
        futurCheminAExplorer.add(new int[]{fromRow, fromColumn});

        // Exploration de chemins praticables
        while (!futurCheminAExplorer.isEmpty()) {
            if(futurCheminAExplorer.contains(new int[]{toRow, toColumn})){
                return true;
            }else{
                // Récupération de chemin un à un 
                int [] cheminTmp = futurCheminAExplorer.poll();
                

                // Teste de chemin praticables
                // Est ce que le chemin est déjà parcouru ?
                if(!cheminParcourus.contains(cheminTmp)){
                    // Ajout de cheminTmp dans chemin parcouru
                    cheminParcourus.add(cheminTmp);
                    int row = cheminTmp [0];
                    int column = cheminTmp [1];
                    
                    // Test en haut
                    if (row - 1 >= 0 ) {                        
                        if (mapMatrix[row - 1][column]) {
                            futurCheminAExplorer.add(new int[]{row - 1, column});
                        }else{
                            cheminParcourus.add(new int[]{row - 1, column});
                        }
                    }

                    // Test en bas
                    if (row + 1 < mapMatrix.length ) {
                        
                        if (mapMatrix[row + 1][column]) {
                            futurCheminAExplorer.add(new int[]{row + 1, column});
                        }else{
                            cheminParcourus.add(new int[]{row + 1, column});
                        }
                    }

                    // Test à gauche
                    if (column - 1 >= 0 ) {                        
                        if (mapMatrix[row ][column - 1]) {
                            futurCheminAExplorer.add(new int[]{row , column - 1});
                        }else{
                            cheminParcourus.add(new int[]{row, column - 1});
                        }
                    }

                    // Test à droite
                    if (column + 1 < mapMatrix[row].length ) {                        
                        if (mapMatrix[row ][column + 1]) {
                            futurCheminAExplorer.add(new int[]{row , column + 1});
                        }else{
                            cheminParcourus.add(new int[]{row, column + 1});
                        }
                    }
                }
            }
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
