package omok;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial") // 컴파일 시 warning을 체크하지 않기 위해
public class DrawBorad extends JPanel {
	private MapSize size;
	private Map map;
	private final int STONE_SIZE = 28; // 돌 사이즈

	public DrawBorad(MapSize m, Map map) {
		setBackground(new Color(206, 167, 61)); // 배경색 지정
		size = m;
		setLayout(null);
		this.map = map;

	}

	@Override
	public void paintComponent(Graphics g1) {
		super.paintComponent(g1);
		g1.setColor(Color.BLACK); // 그려질 색을 블랙지정
		board(g1); // 보드를 그림
		drawStone(g1); // 배열에 정보에 따라 돌을 그림
	}

	public void board(Graphics g2) {
		for (int i = 1; i <= size.getSize(); i++) {
			// 가로 줄 그리기
			g2.drawLine(size.getCell(), i * size.getCell(), size.getCell() * size.getSize(), i * size.getCell());
			// 시작점 x: 30, 시작점 y : i값 (줄번호)*30, 끝점 x : 600,끝점 y : i값 (줄번호)*30

			// 세로줄 그리기
			g2.drawLine(i * size.getCell(), size.getCell(), i * size.getCell(), size.getCell() * size.getSize());
			// 시작점 x : i값 (줄번호)*30, 시작점 y : 30, 끝점 x : i값 (줄번호)*30, 끝점 y : 600
		}
	}

	public void drawStone(Graphics g3) {
		for (int y = 0; y < size.getSize(); y++) {
			for (int x = 0; x < size.getSize(); x++) {
				// 배열의 정보가 흑일경우 흑돌, 백일경우 백돌을 그림
				if (map.getXY(y, x) == map.getBlack())
					drawBlack(g3, x, y);
				else if (map.getXY(y, x) == map.getWhite())
					drawWhite(g3, x, y);
			}
		}
	}

	public void drawBlack(Graphics bg, int x, int y) {
		// 그려질 색을 블랙으로 바꿈
		bg.setColor(Color.BLACK);
		bg.fillOval((x + 1) * size.getCell() - 15, (y) * size.getCell() + 15, STONE_SIZE, STONE_SIZE);

	}

	public void drawWhite(Graphics wg, int x, int y) {
		// 그려질 색을 화이트로 바꿈
		wg.setColor(Color.WHITE);
		wg.fillOval(x * size.getCell() + 15, y * size.getCell() + 15, STONE_SIZE, STONE_SIZE);

	}
}
