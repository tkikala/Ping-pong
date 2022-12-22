import javax.swing.*;
import java.awt.*;

public class GameFrame  extends JFrame {
    GamePanel panel;
    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("2D Ping-Pong");
        this.setResizable(false);
        this.setBackground(new Color(31,78,47));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    }


