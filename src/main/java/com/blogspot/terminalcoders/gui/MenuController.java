package com.blogspot.terminalcoders.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private JMenuBar mainMenuBar;
    private JMenu fileMenu;
    private JMenuItem connectHostMenu, aboutMenu, exitMenu;

    public MenuController() {
        // Init Menu Bar
        mainMenuBar = new JMenuBar();

        // Init Main Menu
        fileMenu = new JMenu("File");

        // Init File - Submenu
        connectHostMenu = new JMenuItem("Connect");
        aboutMenu = new JMenuItem("About");
        exitMenu = new JMenuItem("Exit");

        // Add Menu Items
        fileMenu.add(connectHostMenu);
        fileMenu.add(aboutMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenu);

        // Add to Menu Bar
        mainMenuBar.add(fileMenu);

        // Add Close Action
        exitMenu.addActionListener(new ExitActionListener());
    }

    public JMenuBar getMainMenuBar() {
        return mainMenuBar;
    }

    class ExitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
