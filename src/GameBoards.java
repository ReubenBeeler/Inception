import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class GameBoards implements MouseListener {
	
	static JLabel[][] boards = new JLabel[9][9];
	static Dimension labelSize = new Dimension(70, 70);
	
	public static void main(String[] args) {
		for (JLabel[] board : boards) {board = new JLabel[9];
			for (JLabel label : board) {label = new JLabel(); label.setSize(labelSize);}}
	}
	
	void run() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (JLabel[] board : boards) {for (JLabel label : board) {if (e.getSource() == label) {label.setText(player);}}}
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