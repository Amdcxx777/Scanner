package com.amdc;
import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class Main {
    static JButton btnOk = new JButton("Ok");
    static JButton btnHelp = new JButton("Help");
    static JButton btnAdv = new JButton("Advanced");
    static JButton btnCancel = new JButton("Cancel");
    static JButton btnStart = new JButton("Start scan");
    static JButton btnStop = new JButton("Stop scan");
    static JButton btnClear = new JButton("  Clear  ");
    static JButton btnColor = new JButton("  Color  ");
    static JButton btnSysBaseRead = new JButton("Read Database");
    static JButton btnSysBaseSave = new JButton("Save Database");
    static JButton btnOptions = new JButton(" Options >> ");
    static JLabel hostJL = new JLabel("Host: ");
    static JLabel jLabel2 = new JLabel("Start port: ");
    static JLabel jLabel3 = new JLabel("Finish port: ");
    static JLabel jLabel4 = new JLabel("Time request ms: ");
    static JLabel portJLabel = new JLabel("Port scanning: ");
    static JRadioButton jrbNone = new JRadioButton("None");
    static JRadioButton jrbDB = new JRadioButton("Database:");
    static JTextField hostJTF = new JTextField("192.168.1.1",30);
    static JTextField startPort = new JTextField("1", 5);
    static JTextField endPort = new JTextField("65536", 5);
    static JTextField timeOut = new JTextField("1000", 6);
    static JTextField portView = new JTextField("1", 5);
    static Insets insets = new Insets(4, 4, 4, 4);
    static JTextArea jta = new JTextArea(20, 50);
    static JFrame jFrame = new JFrame();
    static Services services = new Services();
    static JRadioButton jRBAll = new JRadioButton("Show all ports");
    static JRadioButton jRBOnly = new JRadioButton("Show only open ports");
    static ButtonGroup btnGroup = new ButtonGroup();
    static boolean stop = true;
    static boolean pause = true;

    public static void main(String[] args) {
        jFrame = getFrame();
        btnOk.addActionListener(e -> JOptionPane.showMessageDialog(jFrame, "What you do it?", "Killer", JOptionPane.WARNING_MESSAGE));
        btnCancel.addActionListener(e -> JOptionPane.showConfirmDialog(jFrame, "What do you expect??", "Title", JOptionPane.YES_NO_CANCEL_OPTION));
        btnHelp.addActionListener(e -> JOptionPane.showOptionDialog(jFrame, "You are sure?", "Title", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                null, new Object[] {"one", "two", "three", "four", "five"}, 1));
        btnColor.addActionListener(e -> jta.setBackground(JColorChooser.showDialog(jFrame, "Title", blue)));
        btnStart.addActionListener(e-> {
            btnStart.setEnabled(false);
                new ScanPort(Integer.parseInt(startPort.getText()), Integer.parseInt(endPort.getText())).start();
        });
        btnStop.addActionListener(e-> stop = false);
        btnAdv.addActionListener(e-> pause = !pause );
        btnSysBaseRead.addActionListener(e -> FilesWork.OpenFile());
        btnSysBaseSave.addActionListener(e-> FilesWork.SaveFile());
        jFrame.revalidate();
    }

    private static JFrame getFrame() {
        jFrame = new JFrame("Scanner");
        jFrame.add(new CreatePanel());
        MenuBar.getMenuBar();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) { System.out.println("Look and Feel not set"); }
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dm = toolkit.getScreenSize();
        jFrame.setBounds(dm.width / 4, dm.height / 8, 800, 800);
        jFrame.setVisible(true);
        return jFrame;
    }
}
