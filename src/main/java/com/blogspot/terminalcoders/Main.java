package com.blogspot.terminalcoders;

import com.blogspot.terminalcoders.constants.OS;
import com.blogspot.terminalcoders.gui.MainWindow;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String osname = System.getProperty("os.name").toLowerCase();
        try {
            if(osname.contains("win")) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } else {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        MainWindow mainWindow = new MainWindow("Indrajith FTP Manager");
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
    }
}