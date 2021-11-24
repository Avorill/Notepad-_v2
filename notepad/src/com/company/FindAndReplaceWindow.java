package com.company;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndReplaceWindow extends JFrame implements ActionListener {
    
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
    GUI gui;
    public FindAndReplaceWindow(GUI guiFrame){
        gui = guiFrame;
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
    public void find(){

        gui.textArea.getHighlighter().removeAllHighlights();
        String input = gui.textArea.getText();
        int n = 0;
        Pattern p = Pattern.compile(getFindText());
        Matcher matcher = p.matcher(input);
        try {
            while(matcher.find()) {
                DefaultHighlighter.DefaultHighlightPainter highlighter = new DefaultHighlighter.DefaultHighlightPainter
                        (gui.backgroundMenuBar.getBackground().darker());

                gui.textArea.getHighlighter().addHighlight(matcher.start(), matcher.start() + getFindText().length(), highlighter);
                n = matcher.start()+getFindText().length();
                matcher.region(n, input.length()-1);
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
    public void replace(){

        String input = gui.textArea.getText();
        Pattern p = Pattern.compile(getFindText());
        Matcher matcher = p.matcher(input);
        String output = p.matcher(input).replaceFirst(getReplaceText());
        gui.textArea.setText(output);
    }
    public void  replaceAll(){

        String input = gui.textArea.getText();
        Pattern p = Pattern.compile(getFindText());
        String output = p.matcher(input).replaceAll(getReplaceText());
        gui.textArea.setText(output);
   }


    public void cancel(){
        gui.textArea.getHighlighter().removeAllHighlights();
        dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         switch (command){
                case "Cancel": cancel(); break;
                case "Find": find(); break;
                case"Replace":replace(); break;
                case"Replace All": replaceAll();break;

            }
    }
}
