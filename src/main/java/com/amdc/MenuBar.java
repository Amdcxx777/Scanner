package com.amdc;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MenuBar extends Main{
    static void getMenuBar() { // crate MenuBar
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.setMnemonic('F');
        edit.setMnemonic('E');
        jMenuBar.add(file);
        jMenuBar.add(edit);
        file.add(new JMenuItem("New", new ImageIcon("src/res/drawable/1.png"))).addActionListener(e-> jta.setText(""));
//        file.add(new JMenuItem("Add", new ImageIcon("src/res/drawable/8.png")));
        file.add(new JMenuItem("Open", new ImageIcon("src/res/drawable/2.png"))).addActionListener(e-> FilesWork.OpenFile());
        file.add(new JMenuItem("Save", new ImageIcon("src/res/drawable/3.png"))).addActionListener(e-> FilesWork.SaveFile());
//        file.add(new JMenuItem("Import", new ImageIcon("src/res/drawable/24.png")));
//        file.add(new JMenuItem("Export", new ImageIcon("src/res/drawable/25.png")));
        file.addSeparator(); // Separator

        JMenuItem exit = new JMenuItem("Exit", new ImageIcon("src/res/drawable/4.png"));
        exit.setMnemonic('E'); // warm key
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E")); // сочетание кнопок для выхода
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);
//        edit.add(new JMenuItem("Find", new ImageIcon("src/res/drawable/23.png")));
//        edit.add(new JMenuItem("Cut", new ImageIcon("src/res/drawable/26.png")));

        edit.add(new JMenuItem("Copy", new ImageIcon("src/res/drawable/5.png"))).addActionListener(e-> {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(jta.getText()), null);
        });

        edit.add(new JMenuItem("Paste", new ImageIcon("src/res/drawable/6.png"))).addActionListener(e-> {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            DataFlavor dataFlavor = DataFlavor.stringFlavor;
            try { jta.setText(String.valueOf(clipboard.getData(dataFlavor)));
            } catch (UnsupportedFlavorException | IOException ex) { ex.printStackTrace(); }
        });

        edit.add(new JMenuItem("Delete", new ImageIcon("src/res/drawable/7.png"))).addActionListener(e-> jta.setText(""));
//        JMenu options = new JMenu("Options");
//        edit.add(options);
//        options.add("item One");
//        options.add("item Two");
        jFrame.setJMenuBar(jMenuBar);
    }
}
