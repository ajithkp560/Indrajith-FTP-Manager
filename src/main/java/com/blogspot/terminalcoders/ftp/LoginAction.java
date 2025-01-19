package com.blogspot.terminalcoders.ftp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAction implements ActionListener {
    private JTextField hostnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginAction(JTextField hostnameField, JTextField usernameField, JPasswordField passwordField, JLabel messageLabel ) {
        this.hostnameField = hostnameField;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.messageLabel = messageLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
