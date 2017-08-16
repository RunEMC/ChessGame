package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

import Pieces.Piece;

public class Board {

	private Tile[][] board;
	private int rows, cols, tileWidth = 60;
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.board = new Tile[rows][cols];
	}
	
	public void initBoard() {
		boolean isWhite = true;
		int x = 0, y = 0, row = 0;
		
		setDefaultBackLine(row, true);
		row++;
		setDefaultFrontLine(row, false);
		y += tileWidth * 2;
		for (int i = 2; i < rows - 2; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (isWhite) {
					Tile tile = new Tile(new Piece("empty"), Color.white, false, true, x, y, tileWidth);
					this.setTile(tile, i, j);
					isWhite = false;
				}
				else {
					Tile tile = new Tile(new Piece("empty"), Color.black, false, true, x, y, tileWidth);
					this.setTile(tile, i, j);
					isWhite = true;
				}
				x += tileWidth;
			}
			isWhite = !isWhite;
			x = 0;
			y += tileWidth;
		}
		row = rows - 2;
		setDefaultFrontLine(row, true);
		row++;
		setDefaultBackLine(row, false);
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < this.rows; ++i) {
			for (int j = 0; j < this.cols; ++j) {
				this.board[i][j].render(g);
			}
		}
	}
	
	public void setTile(Tile tile, int row, int col) {
		this.board[row][col] = tile;
	}
	
	private void setDefaultFrontLine(int row, boolean white) {
		int x = 0, y = row * tileWidth;
		Color color = white ? Color.white : Color.black;
		Tile tile;
		
		for (int i = 0; i < cols; ++i) {
			tile = new Tile(new Piece("pawn"), color, false, false, x, y, tileWidth);
			setTile(tile, row, i);
			
			x += tileWidth;
			white = !white;
			color = white ? Color.white : Color.black;
		}
	}
	
	private void setDefaultBackLine(int row, boolean white) {
		int x = 0, y = row * tileWidth, col = 0;
		Color color = white ? Color.white : Color.black;
		Tile tile = new Tile(new Piece("rook"), color, false, false, x, y, tileWidth);
		
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("knight"), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("bishop"), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("queen"), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("king"), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("bishop"), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("knight"), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("rook"), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
	}
}
