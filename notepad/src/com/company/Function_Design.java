package com.company;
import javax.swing.*;
import java.awt.*;

public class Function_Design {
    GUI gui;



    public Function_Design(GUI gui) {
        this.gui = gui;
    }
    public static Color getContrastColor(Color color) {
        double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
        return y >= 128 ? Color.black : Color.white;
    }
    public void chooseColor(){
        Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
        gui.window.getContentPane().setBackground(newColor);
       // gui.window.setBackground(newColor);
        gui.backgroundMenuBar.setColor(newColor.darker());
        gui.textArea.setBackground(newColor);
        gui.textArea.setForeground(getContrastColor(newColor));
        gui.textArea.setBorder(BorderFactory.createLineBorder(newColor));
        gui.backgroundMenuBar.setBorder(BorderFactory.createLineBorder(newColor.darker()));
        gui.menuFile.setForeground(getContrastColor(newColor.darker()));
        gui.menuDesign.setForeground(getContrastColor(newColor.darker()));
        gui.menuEdit.setForeground(getContrastColor(newColor.darker()));
        gui.menuFormat.setForeground(getContrastColor(newColor.darker()));




    }
    public void chooseFontColor(){
        Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
        gui.window.getContentPane().setBackground(newColor);
        gui.textArea.setForeground(newColor);
    }
}
