package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

import Pieces.ID;
import Pieces.Piece;

public class Board {

	private Tile[][] board;
	private int rows, cols, tileWidth = 60;
	private boolean existActiveTile = false;
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.board = new Tile[rows][cols];
	}
	
	public void initBoard() {
		boolean isWhite = true;
		int x = 0, y = 0, row = 0;
		
		setDefaultBackLine(row, true, ID.player2);
		row++;
		setDefaultFrontLine(row, false, ID.player2);
		y += tileWidth * 2;
		for (int i = 2; i < rows - 2; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (isWhite) {
					Tile tile = new Tile(new Piece("empty", ID.none), Color.white, true, x, y, tileWidth);
					this.setTile(tile, i, j);
					isWhite = false;
				}
				else {
					Tile tile = new Tile(new Piece("empty", ID.none), Color.black, true, x, y, tileWidth);
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
		setDefaultFrontLine(row, true, ID.player1);
		row++;
		setDefaultBackLine(row, false, ID.player1);
		
		// DEBUG
		Tile tempT = new Tile(new Piece("pawn", ID.player2), Color.black, false, 2*tileWidth, 5*tileWidth, tileWidth);
		setTile(tempT, 5, 2);
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
	
	public void handleClick(int row, int col) {
		Tile tile = board[row][col];
		
		if (existActiveTile) {
			// Check if we are moving a piece
			if (tile.checkActive()) {
				//int tempx = tile.getOldX();
				//int tempy = tile.getOldY();
				// Handle moving piece
			}
			else {
				deactivateTile(row, col);
				activateTile(tile, row, col);
			}	
		}
		else {
			activateTile(tile, row, col);
			existActiveTile = true;
		}
	}
	
	public int getTileWidth() {
		return tileWidth;
	}
	
	private void deactivateTile(int row, int col) {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				board[i][j].deactivate();
			}
		}
	}
	
	private void activateTile(Tile tile, int row, int col) {
		Piece piece = tile.getPiece();
		String name = piece.getName();
		ID id = piece.getID();
		// If it is player1, then we want to decrease row, otherwise we increase it
		int playerIncr = -1;
		
		// Player 1 clicks on their own piece
		if (id == ID.player2) {
			playerIncr = 1;
		}
		if (name == "pawn") {
			Tile testTile;
			// Check move forward
			if (row >= 0 && row < rows) {
				testTile = board[row + playerIncr][col];
				String testName = testTile.getPiece().getName();
				if (testName == "empty") {
					testTile.setMovable(true, false, row, col);
				}
				// Check attack left
				if (col - 1 >= 0) {
					testTile = board[row + playerIncr][col - 1];
					// Check that the tile is not empty and is not a piece of the same player
					if (!testTile.checkEmpty() && testTile.getPiece().getID() != id) {
						testTile.setMovable(true, true, row, col);
					}
				}
				if (col + 1 < cols) {
					testTile = board[row + playerIncr][col + 1];
					if (!testTile.checkEmpty() && testTile.getPiece().getID() != id) {
						testTile.setMovable(true, true, row, col);
					}
				}
			}
		}
		else {
			deactivateTile(row, col);
		}
		
		// Debug
		if (id == ID.player1) {
			System.out.println("Player1");
		}
		else if (id == ID.player2) {
			System.out.println("Player2");
		}
		System.out.println("Piece: " + name);
	}
	
	private void setDefaultFrontLine(int row, boolean white, ID id) {
		int x = 0, y = row * tileWidth;
		Color color = white ? Color.white : Color.black;
		Tile tile;
		
		for (int i = 0; i < cols; ++i) {
			tile = new Tile(new Piece("pawn", id), color, false, x, y, tileWidth);
			setTile(tile, row, i);
			
			x += tileWidth;
			white = !white;
			color = white ? Color.white : Color.black;
		}
	}
	
	private void setDefaultBackLine(int row, boolean white, ID id) {
		int x = 0, y = row * tileWidth, col = 0;
		Color color = white ? Color.white : Color.black;
		Tile tile = new Tile(new Piece("rook", id), color, false, x, y, tileWidth);
		
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("knight", id), color, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("bishop", id), color, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("queen", id), color, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("king", id), color, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("bishop", id), color, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("knight", id), color, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("rook", id), color, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
	}
}
