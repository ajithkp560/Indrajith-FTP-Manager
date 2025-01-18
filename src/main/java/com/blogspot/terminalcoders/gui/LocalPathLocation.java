package com.blogspot.terminalcoders.gui;

import com.blogspot.terminalcoders.constants.Fonts;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LocalPathLocation extends JPanel {
//    private JPanel localPanel = new JPanel(new BorderLayout());
    private JLabel localPathLbl = new JLabel("Local :");
    private JTextField localPath = new JTextField();
    Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    Border paddingBorder = new EmptyBorder(2, 5, 2, 5);
    Font textFiledFont = Fonts.TEXTFIELD.getFont();

    public LocalPathLocation(String path) {
        super(new BorderLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        localPathLbl.setBorder(new EmptyBorder(10, 20, 10, 10));
        localPath.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
        localPath.setFont(textFiledFont);
        this.add(localPathLbl, BorderLayout.WEST);
        this.add(localPath, BorderLayout.CENTER);
        setLocalPath(path);
    }

    public void setLocalPath(String path) {
        localPath.setText(path);
    }

    public JTextField getLocalPath() {
        return this.localPath;
    }
}
