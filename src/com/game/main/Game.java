package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -7680503433899772208L;
	
	// Private vars
	private Thread thread;
	private Boolean running = false, paused = false;
	private Board board;
	private static int rows = 8, cols = 8, tileWidth = 60, sideBarWidth = 0, botBarWidth = 20;
	
	// Public vars
	public static final int WIDTH = cols * tileWidth + sideBarWidth, HEIGHT = rows * tileWidth + botBarWidth; //WIDTH / 12 * 8;
	
	// Game constructor
	public Game() {
		board = new Board(rows, cols, tileWidth, botBarWidth);
		board.initBoard();
		this.addMouseListener(new MouseInput(board, this));
		
		new Window(WIDTH, HEIGHT, "Chess Game", this);
	}
	
	// Starts the game
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	// Stops the game from running
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Runs the game
	public void run() {
		while (running) {
			if (!paused) {
				render();	
			}
		}
		stop();
	}
	
	public void buttonPress(int x, int y) {
		// Check if reset button was clicked
		if (x > (cols - 1) * tileWidth && x < cols * tileWidth && y > (rows - 1) * tileWidth && y < rows * tileWidth + botBarWidth ) {
			paused = true;
			board.reset();
			paused = false;
			board.initBoard();
		}
	}
	
	// Render the graphics for the game
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(255, 255, 153));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		board.render(g);
		
		g.dispose();
		bs.show();
	}
	
	// Main
	public static void main(String[] args) {
		new Game();
	}
}

/*
1. Board -> list of list of tiles (changed to 2-D array)
2. Each tile contains its dimensions, color, clickable (bool) and its piece
3. Each piece is one of empty, pawn, knight,...
4. Each tile has an onclick event listener that first checks if it is clickable (see below)
   then checks its piece and shows the available movement positions
5. If a tile is clicked, its adjacent clickable field will be true based on the piece
6. Clicking on a clickable tile will update the board with the new piece in its correct position
*/