
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawBoards extends JPanel {
	
	Font playerFont = new Font("Georgia", Font.BOLD, 50);
	Font letterFont = new Font("Georgia", Font.PLAIN, 32);
	Font largeFont = new Font("Georgia", Font.PLAIN, 300);
	Font winFont = new Font("Georgia", Font.BOLD, 900);
	
	String player = "X";
	String[] playerList = new String[] {"X", "O"};
	
	Color color = Color.BLUE;
	Color[] colorList = new Color[] {Color.BLUE, Color.RED};
	
	String[][] boards;
	String[] outerBoards;
	Color[][] colors;
	Color[] outerColors;
	
	int[][] borders = new int[][] {{-1, -1}, {-1, -1}};
	
	public static void main(String[] args) {
		
	}
	
	DrawBoards (String[][] boards, String[] outerBoards, Color[][] colors, Color[] outerColors) {
		this.boards = boards;
		this.outerBoards = outerBoards;
		this.colors = colors;
		this.outerColors = outerColors;
	}
	
	public void setBorders(int x, int y) {
		for (int i = 0; i < 2; i++) {for (int j = 0; j < 2; j++) {borders[i][j] = -1;}}
		
		if (y <= 1) {borders[0][0] = x;}
		if (y >= 1) {borders[0][1] = x;}
		
		if (x <= 1) {borders[1][0] = y;}
		if (x >= 1) {borders[1][1] = y;}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 1000);
		
		for (int i = 0; i < 3; i++) {
			if (i == borders[0][0]) {g.setColor(color);}
			else {g.setColor(Color.WHITE);}
			g.drawLine(300 * i, 300, 300 * (i+1), 300);
		}
		for (int i = 0; i < 3; i++) {
			if (i == borders[0][1]) {g.setColor(color);}
			else {g.setColor(Color.WHITE);}
			g.drawLine(300 * i, 600, 300 * (i+1), 600);
		}
		for (int i = 0; i < 3; i++) {
			if (i == borders[1][0]) {g.setColor(color);}
			else {g.setColor(Color.WHITE);}
			g.drawLine(300, 300 * i, 300, 300 * (i+1));
		}
		for (int i = 0; i < 3; i++) {
			if (i == borders[1][1]) {g.setColor(color);}
			else {g.setColor(Color.WHITE);}
			g.drawLine(600, 300 * i, 600, 300 * (i+1));
		}
		
		g.setColor(Color.WHITE);
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				for (int i = 0; i < 2; i++) {
					g.drawLine((300 * x) + 30, (300 * y) + (80 * i) + 110, (300 * x) + 270, (300 * y) + (80 * i) + 110);
				}
			}
		}
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				for (int i = 0; i < 2; i++) {
					g.drawLine((300 * x) + (80 * i) + 110, (300 * y) + 30, (300 * x) + (80 * i) + 110, (300 * y) + 270);
				}
			}
		}
		
		g.setFont(largeFont);
		for (int board = 0; board < 9; board++) {
			g.setColor(this.outerColors[board]);
			g.drawString(this.outerBoards[board], 300 * (board % 3) + 42, 300 * (board / 3) + 254);
		}
		
		// Use outline text as to not cover up smaller letters. Thanks Mike!
		
		g.setFont(letterFont);
		for(int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				g.setColor(this.colors[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))]);
				g.drawString(this.boards[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))], (80 * x) + (20 * (x - (x % 3))) + 30 + 29, (80 * y) + (20 * (y - (y % 3))) + 53 + 24);
			}
		}
		
		g.setFont(playerFont);
		g.setColor(color);
		g.drawString("Player " + player, 342, 920);
	}
}