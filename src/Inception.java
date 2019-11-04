
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inception {
	
	JFrame frame = new JFrame();
	Dimension SIZE = new Dimension(900, 1023);
	
	DrawBoards drawingBoard = new DrawBoards();
	static Inception inception = new Inception();
	
	public static void main(String[] args) {
		inception.setFrame();
	}
	
	void setFrame() {
		frame.setSize(SIZE);
		frame.add(drawingBoard);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}