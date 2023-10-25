package ru.mirea.task6;

public interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}


class MovablePoint implements Movable {
    int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() {
        x += xSpeed;
    }

    @Override
    public void moveDown() {
        x -= xSpeed;
    }

    @Override
    public void moveLeft() {
        y -= ySpeed;
    }

    @Override
    public void moveRight() {
        y += ySpeed;
    }
}


class MovableRectangle implements Movable {
    private MovablePoint topLeft, bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    public void setSpeed(int xSpeed, int ySpeed){
        topLeft.ySpeed = ySpeed;
        topLeft.xSpeed = xSpeed;
    }

    private boolean isEquSpeed(){
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=MovablePoint{x=" + topLeft.x + ", y="+ topLeft.y+
                "}, bottomRight=MovablePoint{x=" + bottomRight.x + ", y=" + bottomRight.y +
                "}, xSpeed = " + topLeft.xSpeed +
                ", ySpeed=" + topLeft.ySpeed +
                "}";
    }

    @Override
    public void moveUp() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveUp();
        bottomRight.moveUp();

    }

    @Override
    public void moveDown() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveDown();
        bottomRight.moveDown();

    }

    @Override
    public void moveLeft() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveLeft();
        bottomRight.moveLeft();

    }

    @Override
    public void moveRight() {
        if(!isEquSpeed()) throw new IllegalStateException("Скорости точек прямоугольника не совпадают!\n" +
                "topLeft:\n\txSpeed = " + topLeft.xSpeed + "\n\tySpeed = " + topLeft.ySpeed +
                "\nbottomRight:\n\txSpeed = " + bottomRight.xSpeed + "\n\tySpeed = " + bottomRight.ySpeed);
        topLeft.moveRight();
        bottomRight.moveRight();
    }
}


class MovableTest {
    public static void main(String[] args) {
        Movable m = new MovablePoint(0, 0, 1, 4);

        System.out.println("\nRectangle:\n");
        m = new MovableRectangle(0, 0, 4, 4, 2,4);
        System.out.println(m);
        m.moveRight();
        m.moveDown();
        System.out.println("Right+Down -> " + m);

        System.out.println("\nChanging speed for rectangle:");
        MovableRectangle r = (MovableRectangle)m;
        r.setSpeed(10, 0);
        try{
            r.moveDown();
        }catch (IllegalStateException e){
            System.out.println(e);
        }
    }
}
