package my_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrainComposition {
    private Deque <Integer> waggonComposite = new ArrayDeque<>();

    public void attachWagonFromLeft(int wagonId) {
        this.waggonComposite.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {        
        this.waggonComposite.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return this.waggonComposite.removeFirst();
    }

    public int detachWagonFromRight() {
        return this.waggonComposite.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
