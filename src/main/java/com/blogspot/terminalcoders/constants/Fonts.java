package com.blogspot.terminalcoders.constants;

import java.awt.*;

public enum Fonts {
    TEXTFIELD("Arial", Font.BOLD, 14);

    private final String font;
    private final int style;
    private final int size;

    Fonts(String font, int style, int size) {
        this.font = font;
        this.style = style;
        this.size = size;
    }

    public Font getFont() {
        return new Font(font, style, size);
    }
}
