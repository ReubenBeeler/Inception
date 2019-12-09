
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Inception implements MouseListener {
	
	JFrame frame = new JFrame();
	Dimension SIZE = new Dimension(900, 1023);
	
	static GameBoards gameBoard = new GameBoards();
	
	public static void main(String[] args) {
		for (int big = 0; big < 9; big++) {
			for (int small = 0; small < 9; small++) {
				gameBoard.boards[big][small] = "";
			}
		}
		new Inception().setFrame();
	}
	
	void setFrame() {
		frame.setSize(SIZE);
		frame.add(gameBoard.drawingBoard);
		frame.addMouseListener(this);
		//gameBoard.makeLabels();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gameBoard.mouseClicked(e);
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