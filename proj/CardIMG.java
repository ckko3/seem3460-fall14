import javax.swing.*;

public class CardIMG extends JLabel {
        public static int toFileID(int id) {
            // CODE HERE: ID mapping from rank ID to file ID
        	if(id%4==0)id+=7;
            else if(id%4==1)id+=5;
            else id+=2;
            if(id>51)id-=52;
            return id;
        }
        public CardIMG(int id) {
            this.setIcon(new ImageIcon("picture/"+toFileID(id)+".png"));
        }
    }