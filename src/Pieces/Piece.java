package Pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Piece {
	
	private String name;
	private ID id;
	private Image img;
	
	public Piece(String name, ID id) {
		this.name = name;
		this.id = id;
		
		String pieceColor = "player2";
		if (id == ID.player1) {
			pieceColor = "player1";
		}
		if (name != "empty") {
			try {
				img = ImageIO.read(new File("sprites/"+name+"_"+pieceColor+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public ID getID() {
		return id;
	}
	
	public void render(Graphics g, int x, int y, int tileWidth) {
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
		if (name != "empty") {
			g.fillRect(x, y, 10, 10);
		    g.drawImage(img, x, y, tileWidth, tileWidth, null);
		}
	}
}
