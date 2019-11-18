
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
		//gameBoard.makeLabels();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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