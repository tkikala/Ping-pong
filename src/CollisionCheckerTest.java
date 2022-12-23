import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CollisionCheckerTest {

    CollisionChecker collisionChecker;

    @BeforeEach
    public void before() {
        collisionChecker = new CollisionChecker();
    }

    @Test
    void WhenBallYCoordinateIsLessOrEqualThanZero_didTouchTopOrBottomEdge_ReturnsTrue() {
        // arrange
        Integer ballYCoordinate = -1;
        Integer maxHeight = 123;

        // act
        Boolean result = collisionChecker.didTouchTopOrBottomEdge(ballYCoordinate, maxHeight);

        //assert
        assertTrue(result);
    }

    @Test
    void WhenBallYCoordinateIsMoreOrEqualToMaxHeight_didTouchTopOrBottomEdge_ReturnsTrue() {
        // arrange
        Integer ballYCoordinate = 124;
        Integer maxHeight = 123;

        // act
        Boolean result = collisionChecker.didTouchTopOrBottomEdge(ballYCoordinate, maxHeight);

        //assert
        assertTrue(result);
    }

    @Test
    void WhenBallYCoordinateIsMoreThanZeroAndLessThanMaxHeight_didTouchTopOrBottomEdge_ReturnsFalse() {
        // arrange
        Integer ballYCoordinate = 75;
        Integer maxHeight = 123;

        // act
        Boolean result = collisionChecker.didTouchTopOrBottomEdge(ballYCoordinate, maxHeight);

        //assert
        assertFalse(result);
    }

    @Test
    void WhenBallRectangleIntersectsWithPaddleRectangle_didTouchPaddle_ReturnsTrue() {
        // arrange
        Rectangle ballRectangle = new Rectangle(1,1,1,1);
        Rectangle paddleRectangle = new Rectangle(1,1,5,5);

        //act
        Boolean result = collisionChecker.didTouchPaddle(ballRectangle, paddleRectangle);

        //assert
        assertTrue(result);
    }

    @Test
    void WhenBallRectangleDoesNotIntersectsWithPaddleRectangle_didTouchPaddle_ReturnsFalse() {
        // arrange
        Rectangle ballRectangle = new Rectangle(1,1,1,1);
        Rectangle paddleRectangle = new Rectangle(15,15,1,1);

        //act
        Boolean result = collisionChecker.didTouchPaddle(ballRectangle, paddleRectangle);

        //assert
        assertFalse(result);
    }

    @Test
    void WhenBallXCoordinateIsLessOrEqualThanZero_didTouchLeftEdge_ReturnsTrue() {
        // arrange
        Integer ballXCoordinate = -5;

        //act
        Boolean result = collisionChecker.didTouchLeftEdge(ballXCoordinate);

        //assert
        assertTrue(result);
    }

    @Test
    void WhenBallXCoordinateIsMoreThanZero_didTouchLeftEdge_ReturnsTrue() {
        // arrange
        Integer ballXCoordinate = 10;

        //act
        Boolean result = collisionChecker.didTouchLeftEdge(ballXCoordinate);

        //assert
        assertFalse(result);
    }

    @Test
    void WhenBallXCoordinateIsMoreOrEqualToMaxWidth_didTouchRightEdge_ReturnsTrue() {
        // arrange
        Integer ballXCoordinate = 124;
        Integer maxWidth = 123;

        // act
        Boolean result = collisionChecker.didTouchRightEdge(ballXCoordinate, maxWidth);

        //assert
        assertTrue(result);
    }
}