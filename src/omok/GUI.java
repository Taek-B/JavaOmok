package omok;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private Container c;
	MapSize size = new MapSize();
	

	public GUI(String title) {
		c = getContentPane();
		setBounds(500, 200, 650, 700);
		c.setLayout(null);
		Map map = new Map(size);
		DrawBorad d = new DrawBorad(size, map);
		setContentPane(d);
		addMouseListener(new MouseEventHandler(map, size, d, this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showWinnerMessage(String messange) {
		JOptionPane.showMessageDialog(this, messange, "승리자", JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
	}
}
