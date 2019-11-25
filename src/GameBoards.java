import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameBoards implements MouseListener{

	String[][] boards = new String[9][9];
	Dimension labelSize = new Dimension(70, 70);
	
	boolean end = false;
	int turn = 0;
	
	int startX = 0;
	int endX = 9;
	int startY = 0;
	int endY = 9;
	
	DrawBoards drawingBoard = new DrawBoards(boards);
	
	int xBox;
	int yBox;

	public static void main(String[] args) {
		
	}
	
	void update() {
		turn += 1;
		drawingBoard.player = drawingBoard.playerList[turn % 2];
		drawingBoard.playerColor = drawingBoard.colorList[turn % 2];
		drawingBoard.repaint();
	}
	
	void set(int x, int y) {
		if (boards[(x % 3) + (3 * (y % 3))][(y % 3) + (3 * (x % 3))].equals("")) {
			boards[(x % 3) + (3 * (y % 3))][(y % 3) + (3 * (x % 3))] = drawingBoard.player;
			startX = (x % 3) + (3 * (y % 3));
			startY = (y % 3) + (3 * (x % 3));
			endX = startX++;
			endY = startY++;
		} else {
			JOptionPane.showMessageDialog(drawingBoard, "Invalid Location: Specified Quadrant is Occupied");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		xBox = -1;
		for (int i = startX; i < endX; i++) {
			if (e.getX() > 80 * i + 35 && e.getX() <= 80 * i + 105) {xBox = i;}
		}

		yBox = -1;
		for (int i = startY; i < endY; i++) {
			if (e.getY() > 80 * i + 35 && e.getY() <= 80 * i + 105) {yBox = i;}
		}
		
		if (xBox != -1 && yBox != -1) {
			set(xBox, yBox);
		}
		
		update();
		
	/*	for (JLabel[] board : boards) {
			for (JLabel label : board) {
				if (e.getSource() == label) {
					label.setText(drawingBoard.player);
				}
			}
		}
	*/
		
	/*
	 * If using JLabels, use JLabel[][] boards = new JLabel[9][9];
	void makeLabels() {
		for (JLabel[] board : boards) {
			board = new JLabel[9];
			for (JLabel label : board) {
				label = new JLabel();
				label.setSize(labelSize);
				label.addMouseListener(this);
			}
		}
	}
	*/
		
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