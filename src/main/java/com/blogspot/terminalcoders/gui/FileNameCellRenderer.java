package com.blogspot.terminalcoders.gui;

import com.blogspot.terminalcoders.gui.local.LocalFileTable;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;

public class FileNameCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        String currentPath = ((LocalFileTable) table).currentPath;

        if (value != null) {
            String fileName = value.toString();
            File file = new File(currentPath, fileName);

            if (fileName.equals("..") || fileName.equals(".")) {
                label.setIcon(UIManager.getIcon("FileView.directoryIcon"));
            } else if (file.isDirectory()) {
                label.setIcon(UIManager.getIcon("FileView.directoryIcon"));
            } else {
                label.setIcon(UIManager.getIcon("FileView.fileIcon"));
            }

            label.setText(fileName);
        }

        if (isSelected) {
            label.setBackground(table.getSelectionBackground());
            label.setForeground(table.getSelectionForeground());
        } else {
            label.setBackground(table.getBackground());
            label.setForeground(table.getForeground());
        }

        return label;
    }
}
