import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class GameBoards {

	static String[][] boards = new String[9][9];
	static String[] outerBoards = new String[] {"", "", "", "", "", "", "", "", ""};
	static Color[][] colors = new Color[9][9];
	static Color[] outerColors = new Color[9];
	
	int[][] winConditions = new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
	
	boolean end = false;
	int turn = 0;
	
	int startX = 0; int endX = 9;
	int startY = 0; int endY = 9;
	
	static DrawBoards drawingBoard = new DrawBoards(boards, outerBoards, colors, outerColors);
	
	int xBox;
	int yBox;
	
	int line;

	public static void main(String[] args) {
		
	}
	
	void update() {
		turn += 1;
		drawingBoard.boards = boards;
		drawingBoard.outerBoards = checkInner();
		drawingBoard.colors = colors;
		drawingBoard.outerColors = outerColors;
		drawingBoard.player = drawingBoard.playerList[turn % 2];
		drawingBoard.color = drawingBoard.colorList[turn % 2];
		drawingBoard.repaint();
	}
	
	String[] checkInner () {
		for (int combos = 0; combos < 8; combos++) {
			line = 0;
			for (int i = 0; i < 3; i++) {if (boards[(xBox / 3) + (3 * (yBox / 3))][winConditions[combos][i]].equals(drawingBoard.player)) {line++;}}
			if (line == 3) {
				outerBoards[(xBox / 3) + (3 * (yBox / 3))] = drawingBoard.player;
				outerColors[(xBox / 3) + (3 * (yBox / 3))] = drawingBoard.color;
			}
		}
		return outerBoards;
	}
	
	boolean checkOuter () {
		return false;
	}
	
	boolean set(int x, int y) {
		if (boards[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))].equals("")) {
			boards[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))] = drawingBoard.playerList[turn % 2];
			colors[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))] = drawingBoard.colorList[turn % 2];
			startX = 3 * (x % 3); endX = startX + 3;
			startY = 3 * (y % 3); endY = startY + 3;
			drawingBoard.setBorders(x % 3, y % 3);
			return true;
		} else {
			return false;
		//	JOptionPane.showMessageDialog(drawingBoard, "Invalid Location: Specified Quadrant is Occupied");
		}
	}

	public void mouseClicked(MouseEvent e) {
		xBox = -1;
		for (int i = startX; i < endX; i++) {
			if (e.getX() > (80 * i) + (60*(i/3)) + 35 && e.getX() <= (80 * i) + (60*(i/3)) + 105) {xBox = i;}
		}

		yBox = -1;
		for (int i = startY; i < endY; i++) {
			if (e.getY() > (80 * i) + (60*(i/3)) + 58 && e.getY() <= (80 * i) + (60*(i/3)) + 128) {yBox = i;}
		}
		
		if (xBox != -1 && yBox != -1) {
			if(set(xBox, yBox)) {update();}
		}
		
	/*	for (JLabel[] board : boards) {
			for (JLabel label : board) {
				if (e.getSource() == label) {
					label.setText(drawingBoard.player);
				}
			}
		}
	*/
		
	/*
	 * If using JLabels, use JLabel[][] boards = new JLabel[9][9]; and
	 * Dimension labelSize = new Dimension(70, 70);
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
}