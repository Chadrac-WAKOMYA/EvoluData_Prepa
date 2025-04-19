package poe_optimisation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RoutePlanner {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        // Variables importantes
        Set<String> cheminParcourus = new HashSet<>();
        Queue<int[]> futurCheminAExplorer = new LinkedList<>();

        // Test de validité des coordonnées
        if(fromRow < 0 || fromRow >= mapMatrix.length ||
           fromColumn < 0 || fromColumn >= mapMatrix[0].length ||
           toRow < 0 || toRow >= mapMatrix.length ||
           toColumn < 0 || toColumn >= mapMatrix[0].length) {
            return false;
        }

        // Vérification des points de départ et d'arrivée
        if(!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]){
            return false;
        }

        // Vérification si départ et arrivée sont identiques
        if(fromRow == toRow && fromColumn == toColumn){            
            return true;
        }

        // Initialisation de la recherche
        futurCheminAExplorer.add(new int[]{fromRow, fromColumn});

        // Exploration des chemins
        while (!futurCheminAExplorer.isEmpty()) {
            int[] cheminTmp = futurCheminAExplorer.poll();
            int row = cheminTmp[0];
            int column = cheminTmp[1];

            // Vérification de la destination
            if(row == toRow && column == toColumn) {
                return true;
            }

            // Si le chemin a déjà été parcouru
            String cheminKey = row + "," + column;
            if(cheminParcourus.contains(cheminKey)) {
                continue;
            }
            cheminParcourus.add(cheminKey); 

            // Exploration des directions
            if (row - 1 >= 0 && mapMatrix[row - 1][column]) {
                futurCheminAExplorer.add(new int[]{row - 1, column});
            }
            if (row + 1 < mapMatrix.length && mapMatrix[row + 1][column]) {
                futurCheminAExplorer.add(new int[]{row + 1, column});
            }
            if (column - 1 >= 0 && mapMatrix[row][column - 1]) {
                futurCheminAExplorer.add(new int[]{row, column - 1});
            }
            if (column + 1 < mapMatrix[row].length && mapMatrix[row][column + 1]) {
                futurCheminAExplorer.add(new int[]{row, column + 1});
            }
        }
        
        return false;
    }
        
    public static void main(String[] args) {
        boolean[][] mapMatrix = {
            {true,  false, false},
            {true,  true,  false},
            {false, true,  true}
        };
        
        System.out.println(routeExists(0, 0, 2, 2, mapMatrix)); // Devrait retourner true
    }
}
