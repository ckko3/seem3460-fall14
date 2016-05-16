import java.awt.*;

public class Player {
        // Hands for holding cards
        private final Color[] theme={Color.red,Color.blue};
        private final int id;
        public final Hand hand;
        public final Scoreboard panel;
        public final String name;
        
        public int score;
        public void reset() {
            updateScore(0);
            hand.reset();
        }
        public void updateScore(int i) {
            score=i;
            panel.updateScore(i);
        }
        public Player(String name,int id) {
            this.name=name;
            this.id=id;
            hand=new Hand(theme[id]);
            panel=new Scoreboard(name,id,theme[id]);
        }
    }