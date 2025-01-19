package com.blogspot.terminalcoders.gui;

import com.blogspot.terminalcoders.gui.MainWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class LocalFileManager extends JPanel {
    private File location;
    private JScrollPane scrollPane;
    private JTextField localFile;
    private LocalFileTable localFileTable;

    public LocalFileManager(JTextField localFile) {
        this.localFile = localFile;
        this.location = new File(localFile.getText());
        this.localFileTable = new LocalFileTable(localFile);
        this.localFileTable.setCurrentPath();


        localFileTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = localFileTable.rowAtPoint(e.getPoint());
                int column = localFileTable.columnAtPoint(e.getPoint());
                System.out.println("Row "+row);
                System.out.println("Column "+column);
                if (row != -1) {
                    String fileName = localFileTable.getValueAt(row, 0).toString();
                    File selectedFileTemp = new File(location, fileName);
                    File selectedFile = null;
                    try {
                        selectedFile = new File(selectedFileTemp.getCanonicalPath());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(getParent(), "Error: "  + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                        return;
                    }

                    if (column == 0 && e.getClickCount() == 2) { // Navigate folder
                        if (selectedFile.isDirectory()) {
                            try {
                                localFile.setText(selectedFile.getCanonicalPath());
                                location = new File(localFile.getText());
                                localFileTable.setCurrentPath();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    } else if (column == 2) { // Upload action
                        if (!fileName.equals("..") && !fileName.equals(".")) {
                            JOptionPane.showMessageDialog(getParent(), "Uploaded: " + fileName);
                        }
                    }
                }
            }
        });
        this.scrollPane = new JScrollPane(localFileTable);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
