package com.blogspot.terminalcoders.gui.dialogbox;

import com.blogspot.terminalcoders.ftp.LoginAction;

import javax.swing.*;
import java.awt.*;

public class ConnectionDialogbox extends JDialog {
    private JTextField hostnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public ConnectionDialogbox(JFrame parent) {
        super(parent, "Login", true);
        setLayout(new GridBagLayout());
        setSize(400, 300);
        setLocationRelativeTo(parent);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Hostname
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Hostname:"), gbc);
        hostnameField = new JTextField(20);
        gbc.gridx = 1;
        add(hostnameField, gbc);

        // Username
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Username:"), gbc);
        usernameField = new JTextField(20);
        gbc.gridx = 1;
        add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // Message Label (Hidden by default)
        messageLabel = new JLabel("Login failed! Please try again.");
        messageLabel.setForeground(Color.RED);
        messageLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(messageLabel, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        // Button Actions
        loginButton.addActionListener(new LoginAction(hostnameField, usernameField, passwordField, messageLabel));
        cancelButton.addActionListener(e -> dispose());
    }


}
