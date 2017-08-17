package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

import Pieces.ID;
import Pieces.Piece;

public class Board {

	private Tile[][] board;
	private int rows, cols, tileWidth = 60;
	private boolean existActiveTile = false;
	private Tile activeTile;
	
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
					Tile tile = new Tile(new Piece("empty", ID.none), Color.white, false, true, x, y, tileWidth);
					this.setTile(tile, i, j);
					isWhite = false;
				}
				else {
					Tile tile = new Tile(new Piece("empty", ID.none), Color.black, false, true, x, y, tileWidth);
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
			deactivateTile(activeTile);
		}
		else {
			activateTile(tile);
		}
	}
	
	public int getTileWidth() {
		return tileWidth;
	}
	
	private void deactivateTile(Tile tile) {
		
	}
	
	private void activateTile(Tile tile) {
		Piece piece = tile.getPiece();
		String name = piece.getName();
		ID id = piece.getID();
		
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
			tile = new Tile(new Piece("pawn", id), color, false, false, x, y, tileWidth);
			setTile(tile, row, i);
			
			x += tileWidth;
			white = !white;
			color = white ? Color.white : Color.black;
		}
	}
	
	private void setDefaultBackLine(int row, boolean white, ID id) {
		int x = 0, y = row * tileWidth, col = 0;
		Color color = white ? Color.white : Color.black;
		Tile tile = new Tile(new Piece("rook", id), color, false, false, x, y, tileWidth);
		
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("knight", id), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("bishop", id), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("queen", id), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("king", id), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("bishop", id), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("knight", id), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
		
		tile = new Tile(new Piece("rook", id), color, false, false, x, y, tileWidth);
		this.setTile(tile, row, col);
		x+= tileWidth;
		col++;
		white = !white;
		color = white ? Color.white : Color.black;
	}
}
