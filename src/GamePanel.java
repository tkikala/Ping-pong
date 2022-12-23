import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = (int) (FRAME_WIDTH * 0.5);
    static final int BALL_DIAMETER = 26;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    static final Dimension SCREEN = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);


    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle_1;
    Paddle paddle_2;
    Ball ball;
    Score score;
    CollisionChecker collisionChecker;

    GamePanel() {
        newPeddle();
        newBall();
        score = new Score(FRAME_WIDTH, FRAME_HEIGHT);
        collisionChecker = new CollisionChecker();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        //random = new Random();
        ball = new Ball((FRAME_WIDTH/2)-(BALL_DIAMETER/2), ((FRAME_HEIGHT/2)-(BALL_DIAMETER/2)), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPeddle() {
        paddle_1 = new Paddle(0, (FRAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1 );
        paddle_2 = new Paddle(FRAME_WIDTH-PADDLE_WIDTH, (FRAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2 );
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        score.draw(g);
        paddle_1.draw(g);
        paddle_2.draw(g);
        ball.draw(g);

    }

    public void move() {
        //with this method paddle moves will be smoother
        paddle_1.move();
        paddle_2.move();
        ball.move();

    }

    public void checkCollision() {
        //Reflection of Ball when it touches top and bottom edges!
        if(collisionChecker.didTouchTopOrBottomEdge(ball.y, FRAME_HEIGHT-BALL_DIAMETER)) {
            ball.setYDirection(-ball.yVelocity);
        }

        //Reflection of ball when it touches paddles!
        if(collisionChecker.didTouchPaddle(ball, new Rectangle(paddle_1.x, paddle_1.y1, paddle_1.width, paddle_1.height))) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;       // increasing ball's speed!
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(collisionChecker.didTouchPaddle(ball, new Rectangle(paddle_2.x, paddle_2.y2, paddle_2.width, paddle_2.height))) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;       // increasing ball's speed!
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        // Stop Paddles at Window Edge!
        if (paddle_1.y1 <= 0)
            paddle_1.y1 = 0;
        if (paddle_1.y1 >= (FRAME_HEIGHT-PADDLE_HEIGHT))
            paddle_1.y1 = FRAME_HEIGHT-PADDLE_HEIGHT;
        if (paddle_2.y2 <= 0)
            paddle_2.y2 = 0;
        if (paddle_2.y2 >= (FRAME_HEIGHT-PADDLE_HEIGHT))
            paddle_2.y2 = FRAME_HEIGHT-PADDLE_HEIGHT;


        //Gives player  1 point and / resets the game!
        if(collisionChecker.didTouchLeftEdge(ball.x)) {
            score.player_2++;
            newPeddle();
            newBall();

        }

        if(collisionChecker.didTouchRightEdge(ball.x, FRAME_WIDTH-BALL_DIAMETER)) {
            score.player_1++;
            newPeddle();
            newBall();
        }

       // if Someone reaches 20 points game resets!
        if(score.player_1 == 20){
            score.player_1 = 0;
            score.player_2 = 0;
            newPeddle();
            newBall();
        }
        if(score.player_2 == 20) {
            score.player_1 = 0;
            score.player_2 = 0;
            newPeddle();
            newBall();

        }




    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double nanoseconds = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nanoseconds;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            paddle_1.pressed(e);
            paddle_2.pressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddle_1.released(e);
            paddle_2.released(e);
        }
    }
}
