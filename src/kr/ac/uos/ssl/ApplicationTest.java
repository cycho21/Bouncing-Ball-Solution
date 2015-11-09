package kr.ac.uos.ssl;

import kr.ac.uos.ssl.bean.Ball;
import kr.ac.uos.ssl.bean.ContainerManager;
import kr.ac.uos.ssl.configuration.Configuration;
import kr.ac.uos.ssl.gui.GraphicManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-11-03
 */

public class ApplicationTest {


    private ContainerManager containerManager;
    private GraphicManager graphicManager;
    private final Random rand;
    private BufferedImage image;
    private Graphics2D g;

    public ApplicationTest() {
        rand = new Random();
        startTest();
    }

    private void startTest() {

        containerManager = new ContainerManager();
        CommandMapper cMapper = new CommandMapper();
        setMapper(cMapper, containerManager);
        cMapper.makeBalls(20, Color.BLACK);
        cMapper.makeBalls(20, Color.PINK);
        cMapper.makeBalls(20, Color.BLUE);
        cMapper.makeBalls(20, Color.GREEN);
        cMapper.makeBalls(20, Color.MAGENTA);
        cMapper.makeBalls(20, Color.YELLOW);
        cMapper.makeBalls(20, Color.CYAN);
        cMapper.makeBalls(20, Color.ORANGE);

        graphicManager = new GraphicManager();
        graphicManager.init();

        while (true) {
            try {
                drawBall();
                moveBall();
                graphicManager.getFrame().repaint();
                Thread.sleep(Configuration.FRAME_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void process(Ball tempBall) {

        if(tempBall.getxDelta() == 0) {
            tempBall.setxDelta(rand.nextInt(10));
        }
        if(tempBall.getyDelta() == 0) {
            tempBall.setyDelta(rand.nextInt(10));
        }
        tempBall.setX(tempBall.getX()+tempBall.getxDelta());
        tempBall.setY(tempBall.getY()+tempBall.getyDelta());
        if (( tempBall.getxDelta() > 0) && (tempBall.getX() >= Configuration.WIDTH - 30)) {
            tempBall.setxDelta(-tempBall.getxDelta());
        }
        if (( tempBall.getxDelta() < 0) && (tempBall.getX() <= 0 )) {
            tempBall.setxDelta(-tempBall.getxDelta());
        }
        if (( tempBall.getyDelta() > 0) && (tempBall.getY() >= Configuration.HEIGHT - 30)) {
            tempBall.setyDelta(-tempBall.getyDelta());
        }
        if (( tempBall.getyDelta() < 0) && (tempBall.getY() <= 0 )) {
            tempBall.setyDelta(-tempBall.getyDelta());
        }
    }

    private void drawBall() {
        image = new BufferedImage(1280, 800, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1280, 800);

        for (int i =0; i < containerManager.getBallGroups().size(); i++) {
            for(Ball tempBall : containerManager.getBallGroups().get(i).getBalls()){
                g.setColor(containerManager.getBallGroups().get(i).getColor());
                g.fillOval(tempBall.getX(), tempBall.getY(), 30, 30);
            }
        }

        graphicManager.getPanel().setImage(image);
    }

    private void moveBall() {
        for (int i =0; i < containerManager.getBallGroups().size(); i++) {
            containerManager.getBallGroups().get(i).getBalls().forEach(this::process);
        }
    }

    private void setMapper(CommandMapper cMapper, ContainerManager containerManager) {
        cMapper.setContainerManager(containerManager);
    }

    public static void main(String[] args) {
        new ApplicationTest();
    }
}
