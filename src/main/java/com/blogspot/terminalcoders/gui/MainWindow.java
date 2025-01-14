package com.blogspot.terminalcoders.gui;

import javax.swing.*;

public class MainWindow extends JFrame {
    MenuController menuController = new MenuController();
    public MainWindow(String title) {
        super(title);

        // Add Menu to Window
        this.setJMenuBar(menuController.getMainMenuBar());
    }
}
