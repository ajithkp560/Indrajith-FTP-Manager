package com.blogspot.terminalcoders.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;

import javax.swing.*;
import java.io.IOException;

public class FTPConnection {
    FTPClient ftpClient = new FTPClient();
    static FTPConnection ftpConnection = new FTPConnection();
    JTextField hostField, portField, usernameField, passwordFiled;
    String host, port, username, password;
    JDialog parent;
    JLabel messageLabel;

    public void set(JTextField hostField, JTextField portField, JTextField usernameField, JTextField passwordFiled, JLabel messageLabel) {
        this.hostField = hostField;
        this.portField = portField;
        this.usernameField = usernameField;
        this.passwordFiled = passwordFiled;
        this.messageLabel = messageLabel;

        this.host = hostField.getText();
        this.port = portField.getText();
        this.username = usernameField.getText();
        this.password = passwordFiled.getText();

        if(this.username.equals("")){
            this.username = "anonymous";
        }

        if(this.password.equals("")) {
            this.password = "anonymous";
        }

        this.parent = (JDialog) SwingUtilities.getWindowAncestor(this.hostField);
    }

    public boolean connect() {
        System.out.println("Connecting to " + this.host +":" + port);
        try {
            ftpClient.connect(this.host, Integer.parseInt(port));
            boolean login = ftpClient.login(username, password);
            if(login) {
                this.parent.dispose();
                System.out.println("Succefully Loggedin");
                ftpClient.enterLocalPassiveMode(); // Switch to passive mode
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // Use binary file type

                String cwd = ftpClient.printWorkingDirectory();
                System.out.println(cwd);

                FTPFile[] files = ftpClient.listFiles();
                for(FTPFile file: files) {
                    System.out.println(file.getName() + " - " + file.isFile());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            messageLabel.setText("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return false;
    }

    public static FTPConnection getFtpConnection() {
        return ftpConnection;
    }
}
