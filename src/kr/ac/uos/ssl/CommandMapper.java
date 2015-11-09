package kr.ac.uos.ssl;

import kr.ac.uos.ssl.bean.Ball;
import kr.ac.uos.ssl.bean.BallContainer;
import kr.ac.uos.ssl.bean.ContainerManager;
import kr.ac.uos.ssl.configuration.Configuration;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-11-03
 */

public class CommandMapper {

    private final Random rand;
    private ContainerManager containerManager;

    public CommandMapper() {
        rand = new Random();
    }

    public void makeBalls(int numberOfBalls, Color color) {

        if(containerManager.getBallGroups() != null){
            if(colorCheck(color)) {
                for (BallContainer tempContainer : containerManager.getBallGroups()) {
                    if(tempContainer.getColor() == color ) {
                        for(int i = 0; i < numberOfBalls; i++){
//                            tempContainer.makeBall(numberOfBalls);
                            Ball ball = new Ball(rand.nextInt(Configuration.WIDTH), rand.nextInt(Configuration.HEIGHT));
                            tempContainer.getBalls().add(ball);
                        }
                    }
                }
            } else {
                BallContainer ballContainer = new BallContainer();
                ballContainer.init();
                ballContainer.setColor(color);
                ArrayList<Ball> ballList = new ArrayList<Ball>();
                    for(int i = 0; i < numberOfBalls; i++){
                        Ball ball = new Ball(rand.nextInt(Configuration.WIDTH), rand.nextInt(Configuration.HEIGHT));
                        ballList.add(ball);
                    }
                ballContainer.setBalls(ballList);

                containerManager.getBallGroups().add(ballContainer);
            }
        } else {
            BallContainer ballContainer = new BallContainer();
            ballContainer.init();
            containerManager.init();

            ballContainer.setColor(color);
            ballContainer.makeBall(numberOfBalls);
            containerManager.getBallGroups().add(ballContainer);
        }
    }

    private boolean colorCheck(Color color) {
        boolean colorBoolean = false;
            for (BallContainer tempContainer : containerManager.getBallGroups()) {
                if(tempContainer.getColor() == color ) {
                    colorBoolean = true;
                }
            }
        return colorBoolean;
    }

    public ContainerManager getContainerManager() {
        return containerManager;
    }

    public void setContainerManager(ContainerManager containerManager) {
        this.containerManager = containerManager;
    }
}