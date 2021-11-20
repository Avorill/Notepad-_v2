package com.company;

public class Function_Edit {
    GUI gui;
    String text;

    public Function_Edit(GUI gui){
        this.gui = gui;
    }
    public void findAndReplace(){
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.textarea = gui.textArea;
        findAndReplace.find();
    }
}
