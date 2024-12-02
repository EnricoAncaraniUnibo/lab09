package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUI(Controller c) {
        controller = c;
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jb.addActionListener(e -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(controller.getPath()))) {
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(frame, "not worked");
            }
        });
    }

    public static void main(String[] args) {
        Controller con = new Controller();
        SimpleGUI g = new SimpleGUI(con);
        g.frame.setVisible(true);
    }
}
