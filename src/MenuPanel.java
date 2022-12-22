import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuPanel extends JPanel {


     MenuPanel(){

         this.addKeyListener(new MenuPanel.AL());
         this.setBackground(Color.BLACK);
         this.setFocusable(true);
         this.setPreferredSize(GamePanel.SCREEN);
     }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
         g.setColor(Color.WHITE);
         g.setFont(new Font("Consolas", Font.BOLD,70));
         g.drawString("GAME MENU", 330, 100);
         g.setFont(new Font("Consolas", Font.BOLD,30));
         g.drawString("Press 'ENTER' to start the game", 265, 200);
         g.setFont(new Font("Consolas", Font.PLAIN,10));
         g.drawString("Created by Berkan Morris", 450, 450);

    }

    public class AL extends KeyAdapter {


        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                GameFrame gameFrame = new GameFrame();
            }

        }
     }
}

