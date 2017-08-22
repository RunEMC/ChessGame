package com.game.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	private Board board;
	private Game game;
	
	public MouseInput(Board board, Game game) {
		this.board = board;
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int tw = board.getTileWidth();
		x = Math.floorDiv(x, tw);
		y = Math.floorDiv(y, tw);
		if (x < 8 && y < 8) {
			board.handleClick(y, x);
		}
		else {
			game.buttonPress(e.getX(), e.getY());
		}
		// Debug
		System.out.println("Mouse pressed at (" + e.getX() + ", " + e.getY() + ") Tile: (" + x + ", " + y + ")");
	}
}
