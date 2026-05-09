import java.lang.Math;

public class Coins {
    private final int HEADS = 0;
    private final int TAILS = 1;
    private int face;

    public Coins() {
        flip();
    }

    public void flip() {
        face = (int) (Math.random() * 2);
    }

    public boolean isHeads() {
        return face == HEADS;
    }
}
