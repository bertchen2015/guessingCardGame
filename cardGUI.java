import javax.swing.BorderFactory;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event. * ;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class cardGUI implements ItemListener,
        ActionListener {
    private JPanel dropDown;
    private JFrame window;
    private String userRank;
    private JButton guessButton;
    private card currentCard;
    private JTextArea dropDownText;
    private String userSuit;
    private ImageIcon cardImg;
    private JTextArea gameInfo;
    private String totalGuess;
    private JLabel imgHolder;
    private ImageIcon cardBack;
    private JPanel gameContainer;
    private JComboBox suits;
    private JComboBox ranks;

    public int wins = 0;
    public int count = 0;
    public int cardsLeft = 52;

    public cardGUI() throws IOException {

        //Creating the frame
        window = new JFrame("Guessing Card Game");

        // creating the container
        gameContainer = new JPanel(new GridLayout(3, 3, 10, 10));

        // displaying info for player
        gameInfo = new JTextArea("Correct Guesses: " + wins + "\nTries: " + count + "\nRemaining in Deck: " + cardsLeft);
        gameInfo.setEditable(false);

        // creating the dropdown list
        suits = new JComboBox < >(card.Suit.values());
        ranks = new JComboBox < >(card.Rank.values());

        // creating the listeners
        suits.addItemListener(this);
        ranks.addItemListener(this);

        userSuit = suits.getSelectedItem().toString();
        userRank = ranks.getSelectedItem().toString();
        totalGuess = userRank + " of " + userSuit;

        // Displaying the instructions
        dropDownText = new JTextArea("Select a suit and rank and try to guess the card!");
        dropDownText.setEditable(false);

        //making sure the dropdowns fit. (Is buggy on fist click for some reason. if you click again it fixes itself)
        dropDown = new JPanel(new GridLayout(1, 3));
        dropDown.add(ranks);
        dropDown.add(new JLabel("of", JLabel.CENTER));
        dropDown.add(suits);

        //for the card images
        cardBack = new ImageIcon(ImageIO.read(new File("cards/b.gif")));
        cardImg = new ImageIcon();
        imgHolder = new JLabel(cardImg);

        // guess button
        guessButton = new JButton("Guess!");
        guessButton.addActionListener(this);

        // For closing the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(gameContainer);

        //Vamping the game container
        gameContainer.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        gameContainer.add(new JLabel(cardBack));
        gameContainer.add(imgHolder);
        gameContainer.add(dropDownText);
        gameContainer.add(gameInfo);
        gameContainer.add(guessButton);
        gameContainer.add(dropDown);

        //Making the window fit
        window.pack();
        window.setVisible(true);
    }

    //the action event!
    @Override
    public void actionPerformed(ActionEvent e) {
        currentCard = cardGame.deck.dealCard();

        if (currentCard == null) return;
        //making the image line up
        if (cardsLeft > 0) cardImg.setImage(currentCard.getCardImage());

        //Incremets win if they guess correctly
        if (totalGuess.equalsIgnoreCase(currentCard.toString())) wins++;

        //was told that this refreshes the page
        imgHolder.repaint();

        cardsLeft--;
        count++;
        gameInfo.setText("Correct Guesses: " + wins + "\nTries: " + count + "\nRemaining in Deck: " + cardsLeft);
    }

    //the updater
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        if (source == suits) userSuit = suits.getSelectedItem().toString();
        if (source == ranks) userRank = ranks.getSelectedItem().toString();
        totalGuess = userRank + " of " + userSuit;
    }
}