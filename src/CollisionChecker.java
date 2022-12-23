import java.awt.*;

public class CollisionChecker {

    public Boolean didTouchTopOrBottomEdge(Integer ballYCoordinate, Integer maxHeight) {
        return ballYCoordinate <= 0 || ballYCoordinate >= maxHeight;
    }

    public Boolean didTouchPaddle(Rectangle ball, Rectangle paddle) {
        return ball.intersects(paddle);
    }

    public Boolean didTouchLeftEdge(Integer ballXCoordinate) {
        return ballXCoordinate <= 0;
    }

    public Boolean didTouchRightEdge(Integer ballXCoordinate, Integer maxWidth) {
        return ballXCoordinate >= maxWidth;
    }
}
