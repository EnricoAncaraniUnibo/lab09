package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    public SimpleGUI() {
        frame.setTitle("My first Java graphical inteface");
        JPanel jp = new JPanel();;
        jp.setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();;
        jp.add(jta,BorderLayout.CENTER);
        JButton jb = new JButton("Save");
        jp.add(jb,BorderLayout.SOUTH);
        frame.getContentPane().add(jp);
        frame.setLocationByPlatform(true);
        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int)s.getWidth()/5,(int)s.getHeight()/5);
    }

    public static void main(String[] args) {
        SimpleGUI g = new SimpleGUI();
        g.frame.setVisible(true);
    }
}
