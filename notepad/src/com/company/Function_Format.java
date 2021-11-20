
package com.company;

import java.awt.*;

public class Function_Format {
    GUI gui;
    public Function_Format(GUI gui) {
        this.gui = gui;
    }

    public void createFont() {
        JFontChooser fontChooser = new JFontChooser();
        int result = fontChooser.showDialog(gui.window);
        if (result == JFontChooser.OK_OPTION)
    {
       Font font = fontChooser.getSelectedFont();
       gui.textArea.setFont(font);
       System.out.println("Selected Font : " + font);
   }
    }
}