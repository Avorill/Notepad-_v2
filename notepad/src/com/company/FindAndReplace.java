package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndReplace {
    JFrame frame = new JFrame("Untitled");
    JTextArea textarea;
    public JDialog find(){

        JDialog findframe = new JDialog(frame , "find" , true);
        findframe.setLocation((int)frame.getLocationOnScreen().getX()+200 , (int)frame.getLocationOnScreen().getY()+200);
        findframe.setSize(400, 200);
        findframe.setLayout(null);


        JTextField findfield = new JTextField();
        JLabel findlabel = new JLabel("Find What:");
        findlabel.setBounds(10, 10, 100, 20);
        findfield.setBounds(findlabel.getX()+100, findlabel.getY(), 150, findlabel.getHeight());
        findframe.add(findlabel);
        findframe.add(findfield);

        JTextField replacefield = new JTextField();
        JLabel replacelabel = new JLabel("Replace With:");
        replacelabel.setBounds(10, 60, 100, 20);
        replacefield.setBounds(replacelabel.getX()+100, replacelabel.getY(), 150, replacelabel.getHeight());
        findframe.add(replacelabel);
        findframe.add(replacefield);

        JCheckBox matchcase = new JCheckBox("Match Case");
        matchcase.setBounds(270, 30, 150, 30);
        findframe.add(matchcase);

        JLabel status = new JLabel();
        status.setBounds(10, 130, 200, 20);
        findframe.add(status);

        JButton findnext = new JButton("Find Next");
        findnext .setBounds(10,100,120,20);
        findnext.addActionListener(new ActionListener(){
            int i=0;
            public void actionPerformed(ActionEvent e) {
                String text = textarea.getText();
                Pattern pat = Pattern.compile(findfield.getText());
                Matcher matcher=pat.matcher(text) ;
                if(matcher.find(i)){
                    textarea.setSelectionStart(matcher.start());
                    textarea.setSelectionEnd(i=matcher.end());
                }
                else{
                    status.setText("No more words found");
                    status.repaint();
                }
            }
        });
        findframe.add(findnext);

        JButton replace = new JButton("Replace");
        replace .setBounds(findnext.getX()+findnext.getWidth()+10,findnext.getY(),findnext.getWidth(),findnext.getHeight());
        replace.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String text = textarea.getText();
                Pattern pattern = Pattern.compile(findfield.getText());

                Matcher match = pattern.matcher(text);
                if(match.find()){
                    System.out.println(match.start());
                    textarea.setText(match.replaceFirst(replacefield.getText()));
                }
                else{
                    status.setText("No more words found");
                    status.repaint();
                }

            }

        });
        findframe.add(replace);

        JButton replaceall = new JButton("Replace All");
        replaceall .setBounds(replace.getX()+replace.getWidth()+10,findnext.getY(),findnext.getWidth(),findnext.getHeight());
        replaceall.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String text = textarea.getText();
                Pattern pattern;
                if(matchcase.isSelected()){
                    pattern = Pattern.compile(findfield.getText());
                }
                else{
                    pattern = Pattern.compile(findfield.getText(), Pattern.CASE_INSENSITIVE);
                }
                Matcher match = pattern.matcher(text);
                int i=0;
                if(match.find()){
                    int x=0;
                    while(match.find(x)){x=match.end();i++;}
                    textarea.setText(match.replaceAll(replacefield.getText()));
                }
                if(i==0)status.setText("No Words Found");
                else status.setText(i+" Word replaced");

                status.repaint();
            }

        });
        findframe.add(replaceall);

        findframe.setVisible(true);
        findframe.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        return findframe;

    }
}
