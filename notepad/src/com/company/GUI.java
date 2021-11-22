package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    //Text Area
    JTextArea textArea;
    JScrollPane scrollPane;
    //top menu bar
   // JMenuBar menuBar;
    BackgroundMenuBar backgroundMenuBar;
    JMenu menuFile, menuEdit, menuFormat, menuDesign;
    //file menu
    JMenuItem iNew, iSave, iSaveAs, iOpen, iExit;
    //edit menu
    JMenuItem   iFindAndReplace;
    //format menu
    JMenuItem iFont;
    //design menu
    JMenuItem iColor,iFontColor;
    private static final Font DEFAULT_SELECTED_FONT = new Font("Sans Serif", Font.PLAIN, 16);

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Design design = new Function_Design(this);
    Function_Edit edit = new Function_Edit(this);
    KeyHandler keyHandler = new KeyHandler(this);
    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createMenuFile();
        createMenuEdit();
        createMenuFormat();
        createMenuDesign();

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.addKeyListener(keyHandler);
        textArea.setFont(DEFAULT_SELECTED_FONT);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollPane);
       scrollPane.setBorder(BorderFactory.createEmptyBorder());
    }

    public void createMenuBar() {
        backgroundMenuBar = new BackgroundMenuBar();
        window.setJMenuBar(backgroundMenuBar);
        backgroundMenuBar.setBorder(null);
        menuFile = new JMenu("File");
        backgroundMenuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        backgroundMenuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        backgroundMenuBar.add(menuFormat);

        menuDesign = new JMenu("Design");
        backgroundMenuBar.add(menuDesign);

    }
    public  void createMenuFile(){
        iNew =  new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);



         iSave =  new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

         iSaveAs =  new JMenuItem("SaveAs");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

         iOpen =  new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

       iExit =  new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);


    }

    public void createMenuEdit(){



        iFindAndReplace =  new JMenuItem("Find and Replace");
        iFindAndReplace.addActionListener(this);
        iFindAndReplace.setActionCommand("Find and Replace");
        menuEdit.add(iFindAndReplace);

    }
    public void createMenuFormat(){
        iFont =  new JMenuItem("Font");
        iFont.addActionListener(this);
        iFont.setActionCommand("Font");
        menuFormat.add(iFont);


    }
    public void  createMenuDesign(){
        iColor =  new JMenuItem("Color");
        iColor.addActionListener(this);
        iColor.setActionCommand("Color");
        menuDesign.add(iColor);

        iFontColor =  new JMenuItem("Font Color");
        iFontColor.addActionListener(this);
        iFontColor.setActionCommand("Font Color");
        menuDesign.add(iFontColor);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New": file.newFile(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "SaveAs": file.saveAs(); break;
            case "Exit": file.exit(); break;
            case "Font": format.createFont(); break;
            case "Color":design.chooseColor(); break;
            case "Font Color": design.chooseFontColor();break;
            case "Find and Replace": edit.findAndReplace();break;
        }

    }
}

