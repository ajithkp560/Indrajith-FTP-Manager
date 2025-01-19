package com.blogspot.terminalcoders.gui.remote;

import com.blogspot.terminalcoders.gui.FileNameCellRenderer;
import com.blogspot.terminalcoders.gui.local.UploadIconCellRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Arrays;

public class RemoteFileTable extends JTable {
    private DefaultTableModel tableModel;
    private String[] columns = new String[]{"Name", "Size", "Action"};
    private JTextField remotePathField;
    public String currentPath;

    public RemoteFileTable(JTextField remotePathField) {
        this.tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        this.setModel(tableModel);
        this.setRowHeight(30);
        this.getColumnModel().getColumn(0).setCellRenderer(new FileNameCellRenderer());
        this.getColumnModel().getColumn(2).setCellRenderer(new DownloadIconCellRenderer());
        this.remotePathField = remotePathField;

        this.setCurrentPath();

        this.getColumnModel().getColumn(1).setPreferredWidth(75);
        this.getColumnModel().getColumn(2).setPreferredWidth(75);

        this.getColumnModel().getColumn(1).setMinWidth(75);
        this.getColumnModel().getColumn(1).setMaxWidth(100);

        this.getColumnModel().getColumn(2).setMinWidth(75);
        this.getColumnModel().getColumn(2).setMaxWidth(100);
    }

    public void setCurrentPath() {
        this.currentPath = remotePathField.getText();
        this.loadCurrentPath(new File(this.currentPath));
    }

    private void loadCurrentPath(File currentPath) {
        this.tableModel.setRowCount(0);
        if(currentPath.getParentFile() != null){
            tableModel.addRow(new Object[] {"..", "", ""});
        }

        File[] files = currentPath.listFiles();
        if(files != null) {
            Arrays.stream(files).forEach(file -> {
                tableModel.addRow(new Object[]{
                        file.getName(),
                        file.isFile() ? file.length() +" bytes" : "",
                        ""
                });
            });
        }
    }
}
