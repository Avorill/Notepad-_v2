package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Function_Edit {
    GUI gui;
    public Function_Edit(GUI gui){
        this.gui = gui;
    }



    public void findAndReplace(){
          FindAndReplaceWindow findAndReplaceWindow = new FindAndReplaceWindow(gui);
    }


}
