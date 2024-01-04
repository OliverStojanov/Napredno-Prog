package Zad42;

public class MovableCircle implements Movable {
    int radius;
    MovablePoint movablePoint;
    public MovableCircle(int radius, MovablePoint movablePoint) {
        this.radius = radius;
        this.movablePoint = movablePoint;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException{
        movablePoint.moveUp();
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        movablePoint.moveDown();
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        movablePoint.moveRight();
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        movablePoint.moveLeft();
    }

    @Override
    public int getCurrentXPosition() {
        return movablePoint.getCurrentXPosition();
    }

    @Override
    public int getCurrentYPosition() {
        return movablePoint.getCurrentYPosition();
    }

    @Override
    public boolean canBeFitted(int xMax, int yMax) {
        int x = getCurrentXPosition();
        int y = getCurrentYPosition();
        return (x+radius)<=xMax && (x-radius)>=0 && (y-radius)>=0 && (y+radius)<=yMax;
    }

    @Override
    public TYPE getType() {
        return TYPE.CIRCLE;
    }

    @Override
    public String getMessage() {
        return String.format("Movable circle with center (%d,%d) and radius %d can not be fitted into the collection", getCurrentXPosition(),getCurrentYPosition(),radius);
    }

    @Override
    public String toString() {
        return String.format("Movable circle with center coordinates (%d,%d) and radius %d", getCurrentXPosition(), getCurrentYPosition(), radius);
    }
}
