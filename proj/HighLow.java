import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class HighLow extends JFrame implements ActionListener {
    private final JButton highButton;
    private final JButton lowButton;
    private final JButton newButton;
    private final JButton quitButton;
    private final JButton hintButton;
    private final JButton passButton;
    
    // A label of text
    private final JLabel statusLabel;
    
    // variables for storing game data
    private int[] cardDeck;
    private int cardDeckIndex;
    private final Player p[]={new Player("North",0),new Player("South",1)};
    
    // GUI constructor to make ActionListener registered
    public static HighLow start() {
        HighLow newHL=new HighLow();
        newHL.init();
        newHL.newGame();
        return newHL;
    }
    
    private HighLow() {
        // set caption
        super("Higher Or Lower?");
        
        // centerMainPanel for status label and buttons
        JPanel CenterMainPanel = new JPanel();
        CenterMainPanel.setLayout(new GridLayout(0,1));
        CenterMainPanel.setBorder(BorderFactory.createEmptyBorder(20,80,20,80));
        
        // add all panels to ContentPane of the Frame(HighLow)
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout(0,0));
        c.add(CenterMainPanel, BorderLayout.CENTER);
        c.add(p[0].hand, BorderLayout.NORTH);
        c.add(p[1].hand, BorderLayout.SOUTH);
        c.add(p[0].panel, BorderLayout.WEST);
        c.add(p[1].panel, BorderLayout.EAST);
        
        // add a status label
        int i = (int)(Math.random()*12);
        statusLabel = new JLabel("<html>[A label]<br>"
                + "A random number: " + String.valueOf(i));
        statusLabel.updateUI();
        CenterMainPanel.add(statusLabel);
        
        // add buttons
        highButton = new JButton("Higher!"); 
        CenterMainPanel.add(highButton);
        lowButton = new JButton("Lower!"); 
        CenterMainPanel.add(lowButton);
        passButton = new JButton("Pass"); 
        CenterMainPanel.add(passButton);
        hintButton = new JButton("Give me a hint?"); 
        CenterMainPanel.add(hintButton);
        newButton = new JButton("New Game"); 
        CenterMainPanel.add(newButton);
        quitButton = new JButton("Quit Game"); 
        CenterMainPanel.add(quitButton);
        
        // pack here auto-fits a best window size
        pack();
        setVisible(true);
        this.setLocation(300, 150);
        
        // enforce the effect of "close window"
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(
            new WindowAdapter() { 
                public void windowClosing(WindowEvent e) {
                    int d = JOptionPane.showConfirmDialog ( null, "You wanna quit?", 
                            "Close Window", JOptionPane.YES_NO_OPTION ) ;
                    if (d==JOptionPane.YES_OPTION) quitGame();
                }
            }
        );
    }
    
    private void init() {
        // register handler for all buttons
        highButton.addActionListener(this);
        lowButton.addActionListener(this);
        newButton.addActionListener(this);
        quitButton.addActionListener(this);
        hintButton.addActionListener(this);
        passButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        // assign the right event to buttons
        if (e.getSource() == newButton) {newGame();}
        else if (e.getSource() == highButton) {makeGuess(1);}
        else if (e.getSource() == lowButton) {makeGuess(0);}
        else if (e.getSource() == quitButton) {quitGame();}
        else if (e.getSource() == hintButton) {giveHint();}
        else if (e.getSource() == passButton) {pass();}
    }
    
    private void cardShuffle() {
        // this method prepares all cards in cardDeck
        // this is the ONLY function that should apply RANDOMNESS
        int i,irandom,temp;
        cardDeck=new int[52];
        cardDeckIndex=0;
        for (i=0;i<52;i++) cardDeck[i]=i;
        for (i=0;i<51;i++) {
            irandom=i+(int)(Math.random()*(52-i));
            temp=cardDeck[i];
            cardDeck[i]=cardDeck[irandom];
            cardDeck[irandom]=temp;
        }
    }
    
    private int nextCard() {
        int id=cardDeck[cardDeckIndex];
        cardDeckIndex+=1;
        return id;
    }
    
    private void newGame() {
        // CODE HERE: starts a new game
        // all initialization useful for resetting should be done here
        cardShuffle();
        p[0].reset();
        p[1].reset();
        p[0].hand.reset();
        p[1].hand.reset();
        p[0].hand.distribute(nextCard());
        p[1].hand.distribute(nextCard());
        statusLabel.setText("North's turn");
        highButton.setVisible(true);
        lowButton.setVisible(true);
        hintButton.setVisible(true);
        passButton.setVisible(true);
    }
    
    private void makeGuess(int guess) {
        // For guess: 1 means higher, 0 means lower
        // CODE HERE: adjust points to the guess made by a player
        // CODE HERE: prepare for next player's action
        int id = cardDeckIndex%2;
        if(cardDeck[cardDeckIndex]>cardDeck[cardDeckIndex-2])
    	p[id].updateScore(p[id].score+20*guess-10*(guess^1));
    	else
        p[id].updateScore(p[id].score-10*guess+20*(guess^1));
        p[id].hand.distribute(nextCard());
        if (cardDeckIndex==20) {endGame();} 
        else {statusLabel.setText(p[id^1].name+"'s turn");}
    }
    
    private void endGame() {
        // CODE HERE: locks the control until next game started
    	if(p[0].score>p[1].score)statusLabel.setText("North wins!");
    	else if(p[0].score<p[1].score)statusLabel.setText("South wins!");
    	else statusLabel.setText("Draw!");
    	highButton.setVisible(false);
        lowButton.setVisible(false);
        hintButton.setVisible(false);
        passButton.setVisible(false);
    }
    
    private void giveHint() {
        // CODE HERE(EX): outputs a count of remaining higher/lower cards
    	int i,higherCount=0,lowerCount=0;
    	for(i=cardDeckIndex;i<52;i++){
    		if(cardDeck[i]>cardDeck[cardDeckIndex-2])higherCount++;
    		else lowerCount++;
    	}
        JOptionPane.showMessageDialog(null, "Higher cards = "+higherCount+"\n"
        		+"Lower cards = "+lowerCount
                ,"Hint",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void pass() {
    	// not making a guess and gets zero point in a round
        int id = cardDeckIndex%2;
        p[id].hand.distribute(nextCard());
        if (cardDeckIndex==20) {endGame();} 
        else {statusLabel.setText(p[id^1].name+"'s turn");}
    }
    
    private void quitGame() {
        this.dispose();
    }
    
    public static void main(String[] args) {
        HighLow.start();
    }
}
