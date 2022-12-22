import javax.swing.*;


public class MenuFrame extends JFrame {

    MenuPanel panel;
    Score score = new Score(GamePanel.FRAME_WIDTH,GamePanel.FRAME_HEIGHT);

    MenuFrame(){
        panel = new MenuPanel();
        this.add(panel);
        this.setTitle("Main Manu for Ping-Pong");
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}





