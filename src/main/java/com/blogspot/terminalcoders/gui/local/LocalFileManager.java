package com.blogspot.terminalcoders.gui.local;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class LocalFileManager extends JPanel {
    private File location;
    private JScrollPane scrollPane;
    private JTextField localPathField;
    private LocalFileTable localFileTable;

    public LocalFileManager(JTextField localPathField) {
        this.localPathField = localPathField;
        this.location = new File(localPathField.getText());
        this.localFileTable = new LocalFileTable(localPathField);
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
                                localPathField.setText(selectedFile.getCanonicalPath());
                                location = new File(localPathField.getText());
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
