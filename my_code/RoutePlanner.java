package my_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RoutePlanner {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {

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

        // Déclarations de variables importantes 
        Set <String> routeDejaParcourue = new HashSet<>(); // Variale qui contenir toutes les routes déjà vérifiées
        List <String> nouveauaDepart  = new ArrayList<>(); // Variable qui contenir les nouveaux départs
        Queue<Map<String, String>> possiblesRoutesAVerifier = new LinkedList<>(); // Variable possibles routes à vérifier
        Map <String, Map<String, String>> routeAExplorer = new HashMap<>(); // La variable qui va prendre les prochaines routes à explorer

        // La boucle de recherche de nouvelles possibilités
        for(String routeChoisie :  nouveauaDepart){
            while (!possiblesRoutesAVerifier.isEmpty()) {
            
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
