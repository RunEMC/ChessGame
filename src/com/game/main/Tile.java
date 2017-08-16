package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

import Pieces.Piece;

public class Tile {
	
	private Piece piece;
	private Color color;
	// Moveable is to check whether a piece can move to that tile, 
	//   empty is to check whether that tile is empty
	private boolean moveable, empty;
	private int x, y, tileWidth;
	
	public Tile(Piece piece, Color color, boolean moveable, boolean empty, int x, int y, int tw) {
		this.piece = piece;
		this.color = color;
		this.moveable = moveable;
		this.empty = empty;
		this.x = x;
		this.y = y;
		this.tileWidth = tw;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, tileWidth, tileWidth);
		if (!empty) {
			piece.render(g, x, y);
		}
	}
}
