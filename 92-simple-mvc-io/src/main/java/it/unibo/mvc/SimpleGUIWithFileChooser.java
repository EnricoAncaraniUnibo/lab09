package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUIWithFileChooser(Controller c) {
        this.controller = c;
        frame.setTitle("My second Java graphical interface");
        Dimension d = new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        frame.setSize(d);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        JTextField jtf = new JTextField();
        jtf.setEditable(false);
        showJTextField(jtf);
        JPanel out = new JPanel();
        JPanel in = new JPanel();
        JButton s = new JButton("Save");
        s.addActionListener(l -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(c.getFile()))) {
            } catch (IOException e) {
                JOptionPane.showMessageDialog(s, "Operation failed");
            }
        });
        JButton jb = new JButton("Browse...");
        jb.addActionListener(l -> {
            JFileChooser jfc = new JFileChooser();
            var funz = jfc.showSaveDialog(null);
            if(funz == JFileChooser.APPROVE_OPTION) {
                c.setFile(jfc.getSelectedFile());
                showJTextField(jtf);
            } else {
                JOptionPane.showMessageDialog(jb, "Operazione non riuscita");
            }
        });
        in.setLayout(new BorderLayout());
        out.setLayout(new BorderLayout());
        in.add(jtf,BorderLayout.CENTER);
        in.add(jb, BorderLayout.LINE_END);
        out.add(in, BorderLayout.NORTH);
        out.add(s,BorderLayout.SOUTH);
        frame.getContentPane().add(out);
    }

    public void showJTextField(JTextField jtf) {
        jtf.setText(controller.getPath());
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        SimpleGUIWithFileChooser sgwfc = new SimpleGUIWithFileChooser(c);
        sgwfc.frame.setVisible(true);
    }
}
