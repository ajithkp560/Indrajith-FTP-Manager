package com.blogspot.terminalcoders;

import com.blogspot.terminalcoders.gui.MainWindow;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow("Indrajith FTP Manager");
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
    }
}