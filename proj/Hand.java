import java.awt.Color;
import javax.swing.*;

 public class Hand extends JPanel {
        public Hand(Color themeColor) {this(30, 20, themeColor);}
        public Hand(int hshift, int bwidth, Color themeColor) {
            this.setLayout(new CardLayout(hshift));
            this.setBorder(BorderFactory.createEmptyBorder(bwidth,bwidth,bwidth,bwidth));
            this.setBackground(themeColor);
            this.distribute(0);
        }
        public void distribute(int id) {
            CardIMG cardIMG=new CardIMG(id);
            this.add(cardIMG);
            this.setComponentZOrder(cardIMG, 0);
            this.updateUI();
        }
        public void reset() {
            this.removeAll();
            this.repaint();
        }
    }