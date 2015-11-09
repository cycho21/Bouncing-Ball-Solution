package kr.ac.uos.ssl.bean;

import kr.ac.uos.ssl.configuration.Configuration;

import java.util.Random;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-11-03
 */

public class Ball {

    private final Random rand;
    private int x;
    private int y;
    private boolean go;
    private boolean directionX;
    private boolean directionY;
    private int xDelta;
    private int yDelta;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        rand = new Random();
        xDelta = rand.nextInt(10);
        yDelta = rand.nextInt(10);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void proc() {

        if(xDelta == 0) {
            xDelta = rand.nextInt(10);
        }

        if(yDelta == 0) {
            yDelta = rand.nextInt(10);
        }

        x += xDelta;
        y += yDelta;

        if (( xDelta > 0) && (x >= Configuration.WIDTH - 20)) {
            xDelta = -xDelta;
        }
        if (( xDelta < 0) && (x <= 0 )) {
            xDelta = -xDelta;
        }

        if (( yDelta > 0) && (y >= Configuration.HEIGHT - 20)) {
            yDelta = -yDelta;
        }
        if (( yDelta < 0) && (y <= 0 )) {
            yDelta = -yDelta;
        }
    }
}
