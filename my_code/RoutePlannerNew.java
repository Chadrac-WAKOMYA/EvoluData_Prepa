package my_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RoutePlannerNew {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        // Variables importantes
        Set <Boolean> cheminParcourus = new HashSet<>();
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
            // futurCheminAExplorer.put("mapMatrix[fromRow][fromColumn]",new int[]{fromRow,fromColumn});
            return false; // Il y a pas changement d'itinéraire
        }

        // // Exploration de chemins praticables
        // while (futurCheminAExplorer.isEmpty()) {
        //     if(!futurCheminAExplorer.containsKey("mapMatrix[toRow][toColumn]")){
        //         Map <String, int[]> futurCheminAExplorerTmp = futurCheminAExplorer;
        //         futurCheminAExplorer.clear();

        //         // Je récupère les éléments de ma collection futurCheminAExplorerTmp
        //         for (Map.Entry<String, int[]> entry : futurCheminAExplorerTmp.entrySet()) {
        //             String key = entry.getKey();
        //             int row =  entry.getValue()[0];
        //             int column =  entry.getValue()[0];

        //             // Vérification case à gauche 
        //             if(row - 1 > 0){
        //                 if(mapMatrix[row - 1][column]){}
        //             }
        //         }
        
        //     }else{
        //         return true;
        //     }
        // }
        
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
