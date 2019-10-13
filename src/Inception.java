
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Inception {
	
	JFrame frame = new JFrame();
	Dimension size = new Dimension(100, 100);
	
	public static void main(String[] args) {
		new Inception().setFrame();
	}
	
	void setFrame() {
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//paintComponent
		
		frame.setVisible(true);
	}
	
	void drawChart(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(100, 100, 100, 400);
		g.drawLine(100, 100, 400, 100);
	}
	
}