import java.awt.image.BufferedImage;

//initializing stuff
public class card {
    private BufferedImage cardImage;
    private String rank;
    private int value;
    private String suit;

    public enum Suit { //now they can be referred by their shortened letters!
        DIAMONDS("Diamonds", "d"),
        HEARTS("Hearts", "h"),
        SPADES("Spades", "s"),
        CLUBS("Clubs", "c");

        private final String suit; //more initializing!!
        private final String fileName;

        //creating the constructor for the suit
        Suit(String suit, String fileName) {
            this.suit = suit;
            this.fileName = fileName;
        }
        //returns file name!
        public String getFileName() {
            return this.fileName;
        }

        //going to be a lot of doing this
        public String getSuit() {
            return this.suit;
        }
    }

    public enum Rank { //only way we could think of...there has to be an easier way...
        ACE("Ace", 1, "a"),
        TWO("Two", 2, "2"),
        THREE("Three", 3, "3"),
        FOUR("Four", 4, "4"),
        FIVE("Five", 5, "5"),
        SIX("Six", 6, "6"),
        SEVEN("Seven", 7, "7"),
        EIGHT("Eight", 8, "8"),
        NINE("Nine", 9, "9"),
        TEN("Ten", 10, "t"),
        JACK("Jack", 11, "j"),
        QUEEN("Queen", 12, "q"),
        KING("King", 13, "k");

        private final String rank;
        private final int value;
        private final String fileName;

        //constructor of rank
        Rank(String rank, int value, String fileName) {
            this.rank = rank;
            this.value = value;
            this.fileName = fileName;
        }
        public String getFileName() { //same but with file name
            return this.fileName;
        }

        //returns numeric value of file so we know how to call it and which we're callling
        public int getRankValue() {
            return this.value;
        }

        public String getRank() {
            return this.rank;
        }

    }

    public card(String rank, String suit, int value, BufferedImage cardImage) { //creating the card itself
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.cardImage = cardImage;
    }

    // now we can get the image as well
    public BufferedImage getCardImage() {
        return cardImage;
    }

    //makes it a toString
    public String toString() {
        return rank + " of " + suit;
    }
}