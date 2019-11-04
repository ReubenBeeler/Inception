
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class DrawBoards extends JPanel implements ActionListener {
	
	Font playerFont = new Font("Georgia", Font.BOLD, 50);
	String player = "X";
	int turn = 0;
	
	GameBoards gameBoard = new GameBoards();
	
	public static void main(String[] args) {
		
	}
	
	void update() {
		turn += 1;
		if (turn % 2 == 0) {player = "X";}
		else {player = "O";}
		repaint();
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
		
		g.drawLine(30, 110, 270, 110);
		g.drawLine(30, 190, 270, 190);
		g.drawLine(110, 30, 110, 270);
		g.drawLine(190, 30, 190, 270);
		
		g.drawLine(330, 110, 570, 110);
		g.drawLine(330, 190, 570, 190);
		g.drawLine(410, 30, 410, 270);
		g.drawLine(490, 30, 490, 270);
		
		g.drawLine(630, 110, 870, 110);
		g.drawLine(630, 190, 870, 190);
		g.drawLine(710, 30, 710, 270);
		g.drawLine(790, 30, 790, 270);
		
		g.drawLine(30, 410, 270, 410);
		g.drawLine(30, 490, 270, 490);
		g.drawLine(110, 330, 110, 570);
		g.drawLine(190, 330, 190, 570);
		
		g.drawLine(330, 410, 570, 410);
		g.drawLine(330, 490, 570, 490);
		g.drawLine(410, 330, 410, 570);
		g.drawLine(490, 330, 490, 570);
		
		g.drawLine(630, 410, 870, 410);
		g.drawLine(630, 490, 870, 490);
		g.drawLine(710, 330, 710, 570);
		g.drawLine(790, 330, 790, 570);
		
		g.drawLine(30, 710, 270, 710);
		g.drawLine(30, 790, 270, 790);
		g.drawLine(110, 630, 110, 870);
		g.drawLine(190, 630, 190, 870);
		
		g.drawLine(330, 710, 570, 710);
		g.drawLine(330, 790, 570, 790);
		g.drawLine(410, 630, 410, 870);
		g.drawLine(490, 630, 490, 870);
		
		g.drawLine(630, 710, 870, 710);
		g.drawLine(630, 790, 870, 790);
		g.drawLine(710, 630, 710, 870);
		g.drawLine(790, 630, 790, 870);
		
		g.setFont(playerFont);
		g.drawString("Player " + player, 342, 920);
	}
}