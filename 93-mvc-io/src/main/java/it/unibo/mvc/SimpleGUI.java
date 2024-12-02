package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUI(Controller c) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5));
        frame.setLocationByPlatform(true);
        this.controller = c;
        JPanel out = new JPanel();
        JPanel in = new JPanel();
        out.setLayout(new BorderLayout());
        in.setLayout(new BorderLayout());
        JTextField jtf = new JTextField();
        JTextArea jta = new JTextArea();
        jta.setEditable(false);
        out.add(jtf, BorderLayout.NORTH);
        out.add(jta, BorderLayout.CENTER);
        out.add(in,BorderLayout.SOUTH);
        JButton p = new JButton("Print");
        p.addActionListener(l -> {
            try {
                controller.setNextPrint(jtf.getText());
                controller.show();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(p,"Operation failed");
            }
        });
        JButton s = new JButton("Show history");
        s.addActionListener(l -> {
            jta.setText("");
            try {
                var ls = c.getHistoryPrint();
                for (String string : ls) {
                    jta.append(" "+string);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(s,"Operation failed");
            }
        });
        in.add(p,BorderLayout.WEST);
        in.add(s,BorderLayout.EAST);
        frame.getContentPane().add(out);
    }

    public static void main(String[] args) {
        Controller c = new SimpleController();
        SimpleGUI sg = new SimpleGUI(c);
        sg.frame.setVisible(true);
    }
}
