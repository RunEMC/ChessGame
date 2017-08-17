package com.game.main;

import java.awt.Dimension;

import javax.swing.JLabel;

public class TileAreaJLab extends JLabel{
	Dimension minSize;

    public TileAreaJLab(Dimension dim) {
    	this.minSize = dim;
    }

    public Dimension getMinimumSize() {
        return minSize;
    }

    public Dimension getPreferredSize() {
        return minSize;
    }
}
