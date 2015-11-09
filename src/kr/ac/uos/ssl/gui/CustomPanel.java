package kr.ac.uos.ssl.gui;

import kr.ac.uos.ssl.bean.ContainerManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-11-09
 */

public class CustomPanel extends JPanel {

    private ContainerManager containerManager;

    public void paint(Graphics g) {
        super.paint(g);
        containerManager.moveBall(g);
    }

    public void setContainerManager(ContainerManager containerManager) {
        this.containerManager = containerManager;
    }

}