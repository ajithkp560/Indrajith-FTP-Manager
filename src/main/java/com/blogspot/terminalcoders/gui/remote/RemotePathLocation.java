package com.blogspot.terminalcoders.gui.remote;

import com.blogspot.terminalcoders.constants.Fonts;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RemotePathLocation extends JPanel {
//    private JPanel remotePanel = new JPanel(new BorderLayout());
    private JLabel remotePathLbl = new JLabel("Remote :");
    private JTextField remotePath = new JTextField();
    Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    Border paddingBorder = new EmptyBorder(2, 5, 2, 5);
    Font textFiledFont = Fonts.TEXTFIELD.getFont();

    public RemotePathLocation(String path) {
        super(new BorderLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        remotePathLbl.setBorder(new EmptyBorder(10, 20, 10, 10));
        remotePath.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
        remotePath.setFont(textFiledFont);
        this.add(remotePathLbl, BorderLayout.WEST);
        this.add(remotePath, BorderLayout.CENTER);
        setLocalPath(path);
    }

    public void setLocalPath(String path) {
        remotePath.setText(path);
    }


    public JTextField getRemotePath() {
        return this.remotePath;
    }
}
