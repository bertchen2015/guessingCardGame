import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class deckOfCards {
    public static card[] deck;
    public static int currentCard;

    public deckOfCards() throws IOException {
        deck = new card[52];
        int i = 0;
        //  this for loop uses IN to loop through all the suits
        for (card.Suit s: card.Suit.values()) {
            //this dose the same but with the ranks
            for (card.Rank r: card.Rank.values()) {

                //we are now assigning card values and image to the cards. Creating the entire deck.
                deck[i] = new card(r.getRank(), s.getSuit(), r.getRankValue(), ImageIO.read(new File("cards/" + r.getFileName() + s.getFileName() + ".gif")));
                i++;
            }
        }
        currentCard = 0;
    }

    //deals out the card
    public static card dealCard() {
        if (currentCard < deck.length) {
            card tempValue = deck[currentCard];
            currentCard++;
            return tempValue;
        }
        else {
            System.out.println("Error! You're out of cards!");
            return null;
        }
    }

    public void shuffle() {
        //making the rand variable
        Random rand = new Random();
        card temp;
        //goes through the whole deck.
        for (int i = 0; i < deck.length; i++) {
            //set variable equal to a random number
            int num = rand.nextInt(deck.length - 1);

            temp = deck[i];
            deck[i] = deck[num];
            deck[num] = temp;
        }
        currentCard = 0;
    }
}