import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle  extends Rectangle{
    int id;
    int x;
    int y1;
    int y2;
    int width;
    int height;
    int yVelocity1;
    int yVelocity2;
    int speed = 10;

    Paddle(int x, int y, int width, int height, int id) {
        //super(x, y, width, height);
        this.x = x;
        if (id == 1) {
            y1 = y;
        } else if (id == 2) {
            y2 = y;
        }
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public void pressed(KeyEvent e) {
        // Check if W or S key was pressed (for paddle 1)
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(-speed, 1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(speed, 1);
        }

        // Check if UP or DOWN key was pressed (for paddle 2)
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setYDirection(-speed, 2);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setYDirection(speed, 2);
        }
        move();
    }

    public void released(KeyEvent e) {
        // Check if W or S key was released (for paddle 1)
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(0, 1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(0, 1);
        }

        // Check if UP or DOWN key was released (for paddle 2)
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setYDirection(0, 2);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setYDirection(0, 2);
        }
        move();
    }

    public void setYDirection(int yDirection, int paddleId) {
        if (paddleId == 1) {
            yVelocity1 = yDirection;
        } else if (paddleId == 2) {
            yVelocity2 = yDirection;
        }
    }

    public void move() {
        y1 += yVelocity1;
        y2 += yVelocity2;
    }

    public void draw(Graphics g){
        if (id == 1) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y1, width, height);
        }
        else {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y2, width, height);
        }
    }


}

