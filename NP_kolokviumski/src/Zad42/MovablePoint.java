package Zad42;

public class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        if(y + ySpeed > MovablesCollection.YMAX)
            throw new ObjectCanNotBeMovedException(x,y+ySpeed);
        y += ySpeed;
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        if(y - ySpeed < 0)
            throw new ObjectCanNotBeMovedException(x, y-ySpeed);
        y -= ySpeed;
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        if(x + xSpeed < 0)
            throw new ObjectCanNotBeMovedException(x+xSpeed, y);
        x += xSpeed;
    }

    @Override
    public void moveLeft()  throws ObjectCanNotBeMovedException {
        if(x - xSpeed < 0)
            throw new ObjectCanNotBeMovedException(x-xSpeed,y);
        x -= xSpeed;
    }

    @Override
    public int getCurrentXPosition() {
        return x;
    }

    @Override
    public int getCurrentYPosition() {
        return y;
    }

    @Override
    public boolean canBeFitted(int xMax, int yMax) {
        return x>=0 && x<=xMax && y<=yMax && y>=0;
    }

    @Override
    public TYPE getType() {
        return TYPE.POINT;
    }

    @Override
    public String getMessage() {
        return String.format("Movable point with coordinates (%d,%d) can not be fitted into the collection", x,y);
    }

    @Override
    public String toString() {
        return String.format("Movable point with coordinates (%d,%d)", getCurrentXPosition(), getCurrentYPosition());
    }
}
