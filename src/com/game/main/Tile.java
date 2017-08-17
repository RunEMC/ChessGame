package com.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Pieces.Piece;

public class Tile {
	
	private Piece piece;
	private Color color;
	// Moveable is to check whether a piece can move to that tile, 
	//   empty is to check whether that tile is empty
	private boolean moveable, empty;
	private int x, y, tileWidth;
	//private TileAreaJLab tilearea;
	
	public Tile(Piece piece, Color color, boolean moveable, boolean empty, int x, int y, int tw) {
		this.piece = piece;
		this.color = color;
		this.moveable = moveable;
		this.empty = empty;
		this.x = x;
		this.y = y;
		this.tileWidth = tw;
		/*
		tilearea = new TileAreaJLab(new Dimension(tileWidth, tileWidth));
		tilearea.addMouseListener(this);
		addMouseListener(this);
		setPreferredSize(new Dimension(tileWidth, tileWidth));
		*/
		//d.addMouseListener(this);
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, tileWidth, tileWidth);
		if (!empty) {
			piece.render(g, x, y);
		}
	}
	
	public Piece getPiece() {
		return piece;
	}
}
