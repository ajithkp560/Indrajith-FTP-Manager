package com.blogspot.terminalcoders.gui.remote;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Objects;

public class DownloadIconCellRenderer implements TableCellRenderer {
    private ImageIcon downloadIcon;

    public DownloadIconCellRenderer() {
        this.downloadIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/ico/download.png")));
        Image img = downloadIcon.getImage();
        img = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Resize to 32x32
        downloadIcon = new ImageIcon(img);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);

        if (value != null && !"..".equals(value) && !".".equals(value)) {
            label.setIcon(downloadIcon);
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
