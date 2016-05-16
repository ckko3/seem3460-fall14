import java.awt.Color;
import javax.swing.*;
import java.awt.*;


public class Scoreboard extends JPanel {
        public static final int NORTH=0;
        public static final int SOUTH=1;
        private JLabel nameLabel;
        private JLabel scoreLabel = new JLabel();
        
        protected void updateScore(int i) {
            scoreLabel.setText(Integer.toString(i));
            updateUI();
        }
        
        public Scoreboard(String name,int side,Color themeColor) {
            GridLayout layout = new GridLayout(0,1);
            this.setLayout(layout);
            nameLabel = new JLabel("   "+name+"   ");
            nameLabel.setOpaque(true);
            nameLabel.setBackground(themeColor);
            nameLabel.setForeground(Color.white);
            nameLabel.setFont(nameLabel.getFont().deriveFont(20f));
            scoreLabel.setFont(scoreLabel.getFont().deriveFont(50f));
            if (side==NORTH) {
                this.add(nameLabel);
                this.add(scoreLabel);
                this.add(new JLabel());
                this.add(new JLabel());
            } else if (side==SOUTH) {
                this.add(new JLabel());  
                this.add(new JLabel());
                this.add(scoreLabel);
                scoreLabel.setHorizontalAlignment(JLabel.RIGHT);
                this.add(nameLabel);
            }
        }
    }