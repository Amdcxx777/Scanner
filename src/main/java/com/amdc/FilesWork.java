package com.amdc;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.Scanner;

public class FilesWork extends Main{
    public static void OpenFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) { return f.getName().endsWith("txt"); }
            @Override
            public String getDescription() { return "Only txt files"; }
        });
        jfc.showOpenDialog(jFrame);
        Scanner scan = null;
        try { scan = new Scanner(new FileReader(jfc.getSelectedFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scan != null;
        while (scan.hasNextLine()) { // обработка файла
            String line = scan.nextLine(); // чтение строк из файла
            jta.append(line + "\n");
        }
    }

    public static void SaveFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) { return f.getName().endsWith("txt");}
            @Override
            public String getDescription() { return "txt"; }
        });
        jfc.showSaveDialog(jFrame);
        try { FileWriter fileWriter = new FileWriter(jfc.getSelectedFile() + ".txt");
            fileWriter.write(jta.getText());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
