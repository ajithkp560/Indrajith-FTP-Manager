package com.blogspot.terminalcoders.gui;

import com.blogspot.terminalcoders.constants.OS;
import com.blogspot.terminalcoders.gui.local.LocalFileManager;
import com.blogspot.terminalcoders.gui.local.LocalPathLocation;
import com.blogspot.terminalcoders.gui.remote.RemoteFileManager;
import com.blogspot.terminalcoders.gui.remote.RemotePathLocation;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MenuController menuController = new MenuController(this);
    private LocalPathLocation localPathLocation;
    private RemotePathLocation remotePathLocation;
    private OS os;
    private LocalFileManager localFileManager;
    private RemoteFileManager remoteFileManager;

    public MainWindow(String title) {
        super(title);
        this.setLayout(new BorderLayout());

        // Add Menu to Window
        this.setJMenuBar(menuController.getMainMenuBar());

        // Identify OS
        setOSandGetPath();

        // Add Local Path UI
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));

        // Local File Manager
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));

        localFileManager = new LocalFileManager(localPathLocation.getLocalPath());
        remoteFileManager = new RemoteFileManager(remotePathLocation.getRemotePath());

        centerPanel.add(localFileManager);
        centerPanel.add(remoteFileManager);

        topPanel.add(localPathLocation);
        topPanel.add(remotePathLocation);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    private void setOSandGetPath() {
        String osname = System.getProperty("os.name").toLowerCase();
        String homeDirectory = System.getProperty("user.home");
        if(osname.contains("win")) {
            os = OS.WINDOWS;
        } else {
            os = OS.UNIX;
        }
        localPathLocation = new LocalPathLocation(homeDirectory);
        remotePathLocation = new RemotePathLocation("");
    }
}
