package kr.ac.uos.ssl.bean;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-11-03
 */

public class ContainerManager {

    private ArrayList<BallContainer> ballGroups;

    public ContainerManager() {
    }

    public void init() {
        if (ballGroups == null) {
            ballGroups = new ArrayList<BallContainer>();
        }
    }

    public ArrayList<BallContainer> getBallGroups() {
        return ballGroups;
    }

    public void setBallGroups(ArrayList<BallContainer> ballGroups) {
        this.ballGroups = ballGroups;
    }

    public void moveBall(Graphics g) {
        for (int i =0; i < ballGroups.size(); i++) {
            for(Ball tempBall : ballGroups.get(i).getBalls()){
                tempBall.proc();
                g.setColor(ballGroups.get(i).getColor());
                g.fillOval(tempBall.getX(), tempBall.getY(), 20, 20);
            }
        }
    }
}
