import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class GameBoards {

	static String[][] boards = new String[9][9];
	static String[] outerBoards = new String[] {"", "", "", "", "", "", "", "", ""};
	static Color[][] colors = new Color[9][9];
	static Color[] outerColors = new Color[9];
	
	int[][] winConditions = new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
	
	int turn = 0;
	
	int startX = 0; int endX = 9;
	int startY = 0; int endY = 9;
	
	static DrawBoards drawingBoard = new DrawBoards(boards, outerBoards, colors, outerColors);
	
	int xBox;
	int yBox;

	public static void main(String[] args) {
		
	}
	
	void update() {
		turn += 1;
		drawingBoard.boards = boards;
		drawingBoard.outerBoards = checkInner();
		drawingBoard.colors = colors;
		drawingBoard.outerColors = outerColors;
		if (checkOuter()) {
			drawingBoard.end = true;
			drawingBoard.repaint();
		} else {
			drawingBoard.player = drawingBoard.playerList[turn % 2];
			drawingBoard.color = drawingBoard.colorList[turn % 2];
			drawingBoard.repaint();
		}
	}
	
	String[] checkInner() {
		if (outerBoards[(xBox / 3) + (3 * (yBox / 3))] == "") {
			boolean full = true;
			int countX = 0;
			for (int i = 0; i < boards[(xBox / 3) + (3 * (yBox / 3))].length; i++) {
				if (boards[(xBox / 3) + (3 * (yBox / 3))][i].equals("X")) {countX++;} else
				if (boards[(xBox / 3) + (3 * (yBox / 3))][i].equals("")) {full = false;}
			}
			
			if (full) {
				if (countX > 4) {
					outerBoards[(xBox / 3) + (3 * (yBox / 3))] = "X";
					outerColors[(xBox / 3) + (3 * (yBox / 3))] = Color.BLUE;
				} else {
					outerBoards[(xBox / 3) + (3 * (yBox / 3))] = "O";
					outerColors[(xBox / 3) + (3 * (yBox / 3))] = Color.RED;} 
			} else {
				for (int combos = 0; combos < 8; combos++) {
					int row = 0;
					for (int i = 0; i < 3; i++) {if (boards[(xBox / 3) + (3 * (yBox / 3))][winConditions[combos][i]].equals(drawingBoard.player)) {row++;}}
					if (row == 3) {
						outerBoards[(xBox / 3) + (3 * (yBox / 3))] = drawingBoard.player;
						outerColors[(xBox / 3) + (3 * (yBox / 3))] = drawingBoard.color;
					}
				}
			}
		} return outerBoards;
	}
	
	boolean checkOuter() {
		boolean bool = false;
		for (int combos = 0; combos < 8; combos++) {
			int row = 0;
			for (int i = 0; i < 3; i++) {if (outerBoards[winConditions[combos][i]].equals(drawingBoard.player)) {row++;}}
			if (row == 3) {bool = true;}
		}
		
		boolean full = true;
		int countX = 0;
		for (int i = 0; i < outerBoards.length; i++) {
			if (outerBoards[i].equals("X")) {countX++;} else
			if (outerBoards[i].equals("")) {full = false;}
		}
		
		if (full) {
			if (countX > 4) {drawingBoard.player = "X";} 
			else {drawingBoard.player = "O";}
			bool = true;
		}	return bool;
	}
	
	boolean set(int x, int y) {
		if (boards[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))].equals("")) {
			boards[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))] = drawingBoard.playerList[turn % 2];
			colors[(x / 3) + (3 * (y / 3))][(x % 3) + (3 * (y % 3))] = drawingBoard.colorList[turn % 2];
			boolean closed = true;
			for (int letter = 0; letter < 9; letter++) {if (boards[(x % 3) + (3 * (y % 3))][letter].equals("")) {closed = false;}}
			if (closed) {
				startX = 0; endX = 9;
				startY = 0; endY = 9;
				drawingBoard.setBorders(-1, -1);
			} else {
				startX = 3 * (x % 3); endX = startX + 3;
				startY = 3 * (y % 3); endY = startY + 3;
				drawingBoard.setBorders(x % 3, y % 3);
			}
			return true;
		} else {
			return false;
		//	JOptionPane.showMessageDialog(drawingBoard, "Invalid Location: Specified Quadrant is Occupied");
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (!drawingBoard.end) {
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
			
			if (75 < e.getX() && e.getX() < 175 && e.getY() >= 960) {
				JOptionPane.showMessageDialog(drawingBoard,  "This is a 2-player game. The classic tic-tac-toe board has gone to the next level.\nPlayer 'X' is blue and goes first; Player 'O' is red.\nClick on the square where you want to put a copy of your letter (X or O).\nThe next turn, your opponent will have to play in the tic-tac-toe board corresponding to the smaller square that you chose.\nThis region will be highlighted in your color.\n\nThere is one large tic-tac-toe board which contains 9 smaller boards. You win the game by controlling the larger board.\nThere are two ways to gain control of any board (large or small):\n\t1. You are the first player to make a 3-in-a-row ...or...\n\t2.There is a Cat's Game and you control the majority of the squares in that board.\nOnce a board is won by a player, ownership cannot switch to the other player.\n\n*Lastly, if the location of your opponent's previous move requires you to play in a board that is completely full, you may continue in any open tile in the game.\n\nPlay On!");
			}
		}
	}
}