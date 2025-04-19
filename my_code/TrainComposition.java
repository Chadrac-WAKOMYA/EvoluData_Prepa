package my_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrainComposition {
    private Deque <Integer> waggonComposite = new ArrayDeque<>();

    public void attachWagonFromLeft(int wagonId) {
        this.waggonComposite.addLast(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        this.waggonComposite.addFirst(wagonId);
    }

    public int detachWagonFromLeft() {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromRight() {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
