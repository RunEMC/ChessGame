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
	private boolean moveable = false, attackable = false, empty;
	private int x, y, oldX, oldY, tileWidth;
	//private TileAreaJLab tilearea;
	
	public Tile(Piece piece, Color color, boolean empty, int x, int y, int tw) {
		this.piece = piece;
		this.color = color;
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
		if (moveable) {
			g.setColor(Color.GREEN);
			g.fillRect(x + tileWidth/4, y + tileWidth/4, tileWidth/2, tileWidth/2);
		}
		if (attackable) {
			g.setColor(Color.red);
			g.fillRect(x + tileWidth*3/8, y + tileWidth*3/8, tileWidth/4, tileWidth/4);
		}
	}
	
	public void deactivate() {
		this.moveable = false;
		this.attackable = false;
	}
	
	public void setMovable(boolean move, boolean attack, int x, int y) {
		moveable = move;
		attackable = attack;
		oldX = x;
		oldY = y;
	}
	
	public void setEmpty(boolean newEmp) {
		empty = newEmp;
	}
	
	public void setPiece(Piece newPiece) {
		piece = newPiece;
	}
	
	public boolean checkActive() {
		return moveable;
	}
	
	public boolean checkEmpty() {
		return empty;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public int getOldX() {
		return oldX;
	}
	
	public int getOldY() {
		return oldY;
	}
}
