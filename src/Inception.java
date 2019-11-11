
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inception implements MouseListener {
	
	JFrame frame = new JFrame();
	Dimension SIZE = new Dimension(900, 1023);
	
	GameBoards gameBoard = new GameBoards();
	static Inception inception = new Inception();
	
	public static void main(String[] args) {
		inception.setFrame();
	}
	
	void setFrame() {
		frame.setSize(SIZE);
		gameBoard.drawingBoard.addMouseListener(this);
		frame.add(gameBoard.drawingBoard);
		gameBoard.makeLabels();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 30 && e.getX() <= 270) {
			System.out.println("Left Boards");
			
			if (e.getX() > 35 && e.getX() <= 105) {System.out.println("Left-Left Quadrants");}
			else if (e.getX() > 115 && e.getX() <= 185) {System.out.println("Left-Middle Quadrants");}
			else if (e.getX() > 195 && e.getX() <= 265) {System.out.println("Left-Right Quadrants");}
		}
		else if (e.getX() > 330 && e.getX() <= 570) {
			System.out.println("Middle Boards");
			
			if (e.getX() > 335 && e.getX() <= 405) {System.out.println("Middle-Left Quadrants");}
			else if (e.getX() > 415 && e.getX() <= 485) {System.out.println("Middle-Middle Quadrants");}
			else if (e.getX() > 495 && e.getX() <= 565) {System.out.println("Middle-Right Quadrants");}
		}
		else if (e.getX() > 630 && e.getX() <= 870) {
			System.out.println("Right Boards");
			
			if (e.getX() > 635 && e.getX() <= 705) {System.out.println("Right-Left Quadrants");}
			else if (e.getX() > 715 && e.getX() <= 785) {System.out.println("Right-Middle Quadrants");}
			else if (e.getX() > 795 && e.getX() <= 865) {System.out.println("Right-Right Quadrants");}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}