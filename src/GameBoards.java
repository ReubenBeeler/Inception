import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class GameBoards implements MouseListener{

	JLabel[][] boards = new JLabel[9][9];
	Dimension labelSize = new Dimension(70, 70);
	
	boolean end = false;
	int turn = 0;
	
	DrawBoards drawingBoard = new DrawBoards();

	public static void main(String[] args) {
		
	}
	
	void update() {
		turn += 1;
		if (turn % 2 == 0) {drawingBoard.player = "X";}
		else {drawingBoard.player = "O";}
		drawingBoard.repaint();
	}
	
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

	@Override
	public void mouseClicked(MouseEvent e) {
		for (JLabel[] board : boards) {
			for (JLabel label : board) {
				if (e.getSource() == label) {
					label.setText(drawingBoard.player);
				}
			}
		}
		update();
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