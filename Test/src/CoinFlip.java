public class CoinFlip {
    public static void main(String[] args) {
        Coins coin = new Coins();
        coin.flip();
        System.out.println("The coin has been flipped and it was " + ((coin.isHeads())? "heads" : "tails") + ".");
        if (coin.isHeads()) {
            System.out.println("Nice, you fucking win!");
        } else {
            System.out.println("LOL you lose, try again.");
        }
    }
}
