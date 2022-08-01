package omok;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
	private Map map;
	private MapSize ms;
	private DrawBorad d;
	private GUI main;

	public MouseEventHandler(Map m, MapSize ms, DrawBorad d, GUI main) {
		map = m;
		this.ms = ms;
		this.d = d;
		this.main = main;
	}

	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		// 입력된 x,y 좌표를 Cell(30)로 나눠 나온 값에 1,2를 빼 0~19사이로 맞춤
		int x = (int) Math.round(me.getX() / (double) ms.getCell()) - 1;
		int y = (int) Math.round(me.getY() / (double) ms.getCell()) - 2;
		if (x < 0 || y<0|| x > 19 || y > 19) {
			return;
		}

		if (map.getXY(y, x) == map.getBlack() || map.getXY(y, x) == map.getWhite()) {
			return;
		}

		System.out.println(x + " " + y); // 눌린 좌표값 확인
		map.setMap(y, x);// 입력된 좌표를 배열에 정보표시
		
		// map.checkThreeThree(y,x); // 삼삼 확인
		
		map.changeCheck();// 차례를 바꿈
		d.repaint(); // 맵을 새롭게 다시 그림
		
		if (map.winCheck(x, y)) { // 승리확인을 하고 승리한쪽이 나올경우 팝업창을 띄움
			if (map.getCheck() == true) {
				main.showWinnerMessage("백돌 승리!!");
				
			} else {
				main.showWinnerMessage("흑돌 승리!!");
			}
		}
	}

}
