package com.company;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndReplaceWindow extends JFrame implements ActionListener {
    GUI gui;
    public static final int OK_OPTION = 0;
    public static final int CANCEL_OPTION = 1;
    public static final int ERROR_OPTION = -1;
    protected int dialogResultValue = ERROR_OPTION;
    private JButton findNextButton;
    private JButton cancelButton;
    private JButton replaceAllButton;
    private JButton replaceButton;
    private JTextField findField;
    private JTextField replaceField;
    private JPanel rootPanel;

    public FindAndReplaceWindow(){

        getContentPane().add(rootPanel);
        setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width/4,dim.height/5);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        cancelButton.addActionListener(this);
        cancelButton.setActionCommand("Cancel");

        findNextButton.addActionListener(this);
        findNextButton.setActionCommand("Find");

        replaceButton.addActionListener(this);
        replaceButton.setActionCommand("Replace");

        replaceAllButton.addActionListener(this);
        replaceAllButton.setActionCommand("Replace All");

    }

    public String getFindText(){
        String findText = findField.getText();
        return findText;
    }
    public String getReplaceText(){
        String replaceText = replaceField.getText();
        return replaceText;
    }
    public void findNext(){
      
    }
    public void replace(){}
    public void  replaceAll(){
    }
    public void cancel(){
        dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         Object source = e.getSource();
            switch (command){
                case "Cancel": cancel(); break;
                case "Find": findNext(); break;
                case"Replace": break;
                case"Replace All": break;

            }
    }
}
