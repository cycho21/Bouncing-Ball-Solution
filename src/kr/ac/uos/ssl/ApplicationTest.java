package kr.ac.uos.ssl;

import kr.ac.uos.ssl.bean.ContainerManager;
import kr.ac.uos.ssl.gui.GraphicManager;

import java.awt.*;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-11-03
 */

public class ApplicationTest {


    public ApplicationTest() {
        startTest();
    }

    private void startTest() {

        ContainerManager containerManager = new ContainerManager();
        CommandMapper cMapper = new CommandMapper();
        setMapper(cMapper, containerManager);
        cMapper.makeBalls(5, Color.BLACK);
        cMapper.makeBalls(15, Color.BLACK);
        cMapper.makeBalls(20, Color.RED);
        cMapper.makeBalls(20, Color.PINK);
        cMapper.makeBalls(20, Color.BLUE);
        cMapper.makeBalls(20, Color.GREEN);
        cMapper.makeBalls(20, Color.MAGENTA);
        cMapper.makeBalls(20, Color.YELLOW);
        cMapper.makeBalls(20, Color.CYAN);
        cMapper.makeBalls(20, Color.ORANGE);

        GraphicManager graphicManager = new GraphicManager(cMapper);
        graphicManager.init();

        while (true) {
            try {
                graphicManager.getFrame().repaint();
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setMapper(CommandMapper cMapper, ContainerManager containerManager) {
        cMapper.setContainerManager(containerManager);
    }

    public static void main(String[] args) {
        new ApplicationTest();
    }
}
