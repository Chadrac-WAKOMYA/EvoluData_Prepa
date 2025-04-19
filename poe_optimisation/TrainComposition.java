package poe_optimisation;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrainComposition {
    private Deque<Integer> waggonComposite = new ArrayDeque<>();

    public void attachWagonFromLeft(int wagonId) {
        this.waggonComposite.addFirst(wagonId); // Ajout à gauche
    }

    public void attachWagonFromRight(int wagonId) {
        this.waggonComposite.addLast(wagonId); // Ajout à droite
    }

    public int detachWagonFromLeft() {
        return this.waggonComposite.removeFirst(); // Détachement de gauche
    }

    public int detachWagonFromRight() {
        return this.waggonComposite.removeLast(); // Détachement de droite
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}