package com.blogspot.terminalcoders.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Arrays;


public class LocalFileTable extends JTable {
    private DefaultTableModel tableModel;
    private String[] columns = new String[]{"Name", "Size", "Action"};
    private JTextField localPath;
    public String currentPath;

    public LocalFileTable(JTextField localPath) {
        this.tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };
        this.setModel(tableModel);
        this.setRowHeight(30);
        this.getColumnModel().getColumn(0).setCellRenderer(new FileNameCellRenderer());
        this.getColumnModel().getColumn(2).setCellRenderer(new UploadIconCellRenderer());
        this.localPath = localPath;

        this.setCurrentPath();
    }

    public void setCurrentPath() {
        this.currentPath = localPath.getText();
        this.loadCurrentPath(new File(this.currentPath));
    }

    private void loadCurrentPath(File currentPath) {
        this.tableModel.setRowCount(0);
        if(currentPath.getParentFile() != null){
            tableModel.addRow(new Object[] {"..", "Folder", ""});
        }

        File[] files = currentPath.listFiles();
        if(files != null) {
            Arrays.stream(files).forEach(file -> {
//                System.out.println("AKP " + file.getName());
                tableModel.addRow(new Object[]{
                        file.getName(),
                        file.isDirectory() ? "Folder" : "File",
                        file.isFile() ? file.length() +" bytes" : "",
                        ""
                });
            });
        }
    }

}
