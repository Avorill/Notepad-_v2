package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName;
    String fileAdress;

    public Function_File(GUI gui) {
        this.gui = gui;


    }



    public void open() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);


        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        System.out.println(fileAdress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAdress + fileName));

            gui.textArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File not opened!");
        }
    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAdress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                System.out.println("Something wrong!");

            }

        }

    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAdress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("Something wrong!");
        }
    }
    public void newFile() {
        int a = JOptionPane.showConfirmDialog(gui.window, "Do you wnt to save?");
        if (a == JOptionPane.YES_OPTION) {
            saveAs();
            gui.textArea.setText("");
            gui.window.setTitle("New");
            fileName = null;
            fileAdress = null;
        }
        if(a == JOptionPane.NO_OPTION) {
            gui.textArea.setText("");
            gui.window.setTitle("New");
            fileName = null;
            fileAdress = null;
        }

        }

    public void exit() {
        System.exit(0);
    }
}