package com.game.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	private Board board;
	
	public MouseInput(Board board) {
		this.board = board;
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
		//Tile position = floor(x/60)
		System.out.println("Mouse pressed at (" + x + ", " + y + ")");
	}
}
