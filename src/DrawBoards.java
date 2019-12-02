
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class DrawBoards extends JPanel implements MouseListener {
	
	Font playerFont = new Font("Georgia", Font.BOLD, 50);
	Font letterFont = new Font("Georgia", Font.PLAIN, 32);
	
	String player = "X";
	String[] playerList = new String[] {"X", "O"};
	
	Color[] colorList = new Color[] {Color.BLUE, Color.RED};
	
	String[][] boards;
	Color[][] colors;
	
	public static void main(String[] args) {
		
	}
	
	DrawBoards (String[][] boards, Color[][] colors) {
		this.boards = boards;
		this.colors = colors;
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
		
		g.setColor(Color.RED);
		for(int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				g.setColor(this.colors[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))]);
				g.drawString(this.boards[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))], (80 * x) + (20 * (x - (x % 3))) + 30 + 29, (80 * y) + (20 * (y - (y % 3))) + 53 + 24);
		
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse Entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse Exited");
	}
}