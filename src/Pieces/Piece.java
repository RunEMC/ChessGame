package Pieces;

import java.awt.Color;
import java.awt.Graphics;

public class Piece {
	
	private String name;
	
	public Piece(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void render(Graphics g, int x, int y) {
		if (name == "pawn") {
			g.setColor(Color.gray);
		}
		else if (name == "rook") {
			g.setColor(Color.red);
		}
		else if (name == "knight") {
			g.setColor(Color.green);
		}
		else if (name == "bishop") {
			g.setColor(Color.blue);
		}
		else if (name == "king") {
			g.setColor(Color.yellow);
		}
		else if (name == "queen") {
			g.setColor(Color.pink);
		}
		if (name != "emtpy") {
			g.fillRect(x, y, 10, 10);;
		}
	}
}
