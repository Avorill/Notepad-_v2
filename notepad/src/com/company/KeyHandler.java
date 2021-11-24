package com.company;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GUI gui;

    int caret_end_position,begin_position,begin_position_2,caret_end_position_2;
    String line, line_2;
    Function_File file;
    Function_Edit edit;


    public KeyHandler(GUI gui){
        this.gui = gui;
        this.file = gui.file;
        this.edit = gui.edit;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)  {
            file.save();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_F)  {
           edit.findAndReplace();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N)  {
            file.newFile();
        }
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_D) {
            GetRowNumber();
            try {
                begin_position = gui.textArea.getLineStartOffset(GetRowNumber() - 1);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
            try {
                caret_end_position = gui.textArea.getLineEndOffset(GetRowNumber() - 1);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
            try {
                line = gui.textArea.getText(begin_position, caret_end_position - begin_position);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }

            if (GetRowNumber() == gui.textArea.getLineCount()) {
                gui.textArea.insert("\n", caret_end_position);
            }
            gui.textArea.insert(line, caret_end_position);
        }


        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
            GetRowNumber();
            if (GetRowNumber() < gui.textArea.getLineCount()) {
                try {
                    begin_position = gui.textArea.getLineStartOffset(GetRowNumber() - 1);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    caret_end_position = gui.textArea.getLineEndOffset(GetRowNumber() - 1);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    line = gui.textArea.getText(begin_position, caret_end_position - begin_position);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    begin_position_2 = gui.textArea.getLineStartOffset(GetRowNumber());
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    caret_end_position_2 = gui.textArea.getLineEndOffset(GetRowNumber());
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    line_2 = gui.textArea.getText(begin_position_2, caret_end_position_2 - begin_position_2);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                if (GetRowNumber() == gui.textArea.getLineCount() - 2) {
                    String temp = gui.textArea.getText();
                    temp += "\n";
                    gui.textArea.setText(temp);
                }
                gui.textArea.setText(gui.textArea.getText().substring(0, begin_position) + line_2 + line +
                        gui.textArea.getText().substring(caret_end_position_2));
                gui.textArea.setCaretPosition(caret_end_position_2 - 1);
            }
        }


        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_UP) {
            GetRowNumber();
            if ((GetRowNumber() < gui.textArea.getLineCount()) && (GetRowNumber() > 1)) {
                try {
                    begin_position = gui.textArea.getLineStartOffset(GetRowNumber() - 1);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    caret_end_position = gui.textArea.getLineEndOffset(GetRowNumber() - 1);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    line = gui.textArea.getText(begin_position, caret_end_position - begin_position);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    begin_position_2 = gui.textArea.getLineStartOffset(GetRowNumber() - 2);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    caret_end_position_2 = gui.textArea.getLineEndOffset(GetRowNumber() - 2);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                try {
                    line_2 = gui.textArea.getText(begin_position_2, caret_end_position_2 - begin_position_2);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                gui.textArea.setText(gui.textArea.getText().substring(0, begin_position_2) + line + line_2 +
                        gui.textArea.getText().substring(caret_end_position));
                gui.textArea.setCaretPosition(begin_position_2);
            }
        }


        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X) {

            GetRowNumber();
            if (GetRowNumber() >= 0) {
                try {
                    begin_position = gui.textArea.getLineStartOffset(GetRowNumber() - 1);
                } catch (BadLocationException ex) {

                }
                try {
                    caret_end_position = gui.textArea.getLineEndOffset(GetRowNumber() - 1);
                } catch (BadLocationException ex) {

                }
                try {
                    line = gui.textArea.getText(begin_position, caret_end_position - begin_position);

                } catch (BadLocationException ex) {

                }
                if (GetRowNumber() == 1 && gui.textArea.getLineCount() ==1) {
                    gui.textArea.setText("");
                } else {
                    if(GetRowNumber() == 1 && gui.textArea.getLineCount() !=1){
                        gui.textArea.setText(gui.textArea.getText().substring(caret_end_position));
                    }
                    else{
                    if (GetRowNumber()== gui.textArea.getLineCount()) {
                        gui.textArea.setText(gui.textArea.getText().substring(0, begin_position) +
                                gui.textArea.getText().substring(caret_end_position));
                        gui.textArea.setCaretPosition(begin_position - 1);
                    } else {
                        gui.textArea.setText(gui.textArea.getText().substring(0, begin_position - 1) + "\n" +
                                gui.textArea.getText().substring(caret_end_position));
                        gui.textArea.setCaretPosition(begin_position - 1);
                    }
                }
                }

            }
        }

        }

    public int GetRowNumber() {
        int caretPos = gui.textArea.getCaretPosition();
        int rowNum = (caretPos == 0) ? 1 : 0;
        for (int offset = caretPos; offset > 0; ) {
            try {
                offset = Utilities.getRowStart(gui.textArea, offset) - 1;
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
            rowNum++;
        }
        return rowNum;
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


}
