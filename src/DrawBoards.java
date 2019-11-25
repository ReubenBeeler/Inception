
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class DrawBoards extends JPanel implements ActionListener {
	
	Font playerFont = new Font("Georgia", Font.BOLD, 50);
	Font letterFont = new Font("Georgia", Font.PLAIN, 32);

	String player = "X";
	String[] playerList = new String[] {"X", "O"};
	
	Color playerColor = Color.BLUE;
	Color[] colorList = new Color[] {Color.BLUE, Color.RED};
	String[][] boards;
	
	public static void main(String[] args) {
		
	}
	
	DrawBoards (String[][] boards) {
		this.boards = boards;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 1000);
		
		g.setColor(Color.WHITE);

		g.drawLine(0, 300, 900, 300);
		g.drawLine(0, 600, 900, 600);
		g.drawLine(300, 0, 300, 900);
		g.drawLine(600, 0, 600, 900);
		
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
		
		g.setFont(playerFont);
		g.drawString("Player " + player, 342, 920);
		
		g.setFont(letterFont);
		
		//g.setColor(Color.RED);
		//for(...) {
		//	for (...) {
		//		if (letter.equals("O") @ location) {g.drawString("O", ...);/*<-- RED*/}
		//		}
		//	}
		
		//g.setColor(Color.BLUE);
		//for(...) {
		//	for (...) {
		//		if (letter.equals("X") @ location) {g.drawString("X", ...);/*<-- BLUE*/}
		//		}
		//	}

		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				g.drawString(player, (80 * x) + (20 * (x - (x % 3))) + 30 + 29, (80 * y) + (20 * (y - (y % 3))) + 53 + 24);
			}
		}
	}
}