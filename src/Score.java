import java.awt.*;

public class Score extends Rectangle {

    public final int COURT_CIRCLE = 150;
    public final int CENTER_DOT = 10;
    static int FRAME_WIDTH;
    static int FRAME_HEIGHT;

    int player_1;
    int player_2;

    Score(int FRAME_WIDTH, int FRAME_HEIGHT){
        Score.FRAME_WIDTH = FRAME_WIDTH;
        Score.FRAME_HEIGHT = FRAME_HEIGHT;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.BOLD,50));
        g.drawLine(FRAME_WIDTH/2, 0, FRAME_WIDTH/2, FRAME_HEIGHT);
        g.drawOval((FRAME_WIDTH/2)-(COURT_CIRCLE/2), (FRAME_HEIGHT/2) - (COURT_CIRCLE/2), COURT_CIRCLE,COURT_CIRCLE);
        g.fillOval((FRAME_WIDTH/2)-(CENTER_DOT/2), (FRAME_HEIGHT/2) - (CENTER_DOT/2), CENTER_DOT,CENTER_DOT);
        g.drawString(String.valueOf(player_1/10) + String.valueOf(player_1%10), (FRAME_WIDTH/2)- 75, 50);
        g.drawString(String.valueOf(player_2/10) + String.valueOf(player_2%10), (FRAME_WIDTH/2)+ 20, 50);
    }
}
