package kr.ac.uos.ssl.gui;

import kr.ac.uos.ssl.CommandMapper;
import kr.ac.uos.ssl.configuration.Configuration;

import javax.swing.*;
import java.awt.*;

/**
 * @author Chan Yeon, Cho
 * @version 0.0.1 - SnapShot
 *          on 2015-11-04
 */

public class GraphicManager {

    private JFrame frame;
    private CustomPanel panel;
    private CommandMapper cMapper;

    public GraphicManager(CommandMapper cMapper) {
        this.cMapper = cMapper;
    }

    public void init() {
        makeFrame1();
        makePanel1();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void makePanel1() {
        panel = new CustomPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(Configuration.WIDTH, Configuration.HEIGHT));
        panel.setContainerManager(cMapper.getContainerManager());
    }

    public void makeFrame1() {
        frame = new JFrame("Balls Balls Balls");
        frame.setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setModel(CommandMapper cMapper) {
        this.cMapper = cMapper;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public CustomPanel getPanel() {
        return panel;
    }
}
