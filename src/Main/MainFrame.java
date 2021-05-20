package Main;

import page.KioskPage;
import page.start.StartPage;
import util.Display;
import javax.swing.*;

// 화면의 틀을 정의한 클래스
public class MainFrame extends JFrame {

	public MainFrame() {
		init();
		setLocationByCenter();
		addPage(new StartPage());
	}

	private void init() {
		this.setLayout(null);
		this.setTitle("Caffe Kiosk"); // 상단 이름
		this.setBounds(100, 100, 768, 850); // 설정된 크기
		this.setResizable(false); // 사이즈 변경 불가하도록
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame 이 정상적으로 종료되도록
	}
	
	private void setLocationByCenter() {
		this.setLocation(Display.WINDOWS_HALF_WIDTH / 2, 0);
	}
	
	public void attachPage(KioskPage page) {
		removeAllComponents();
		addPage(page);
		refresh();
	}
	
	private void removeAllComponents() {
		this.getContentPane().removeAll();
	}
	
	private void addPage(KioskPage page) {
		page.setMainFrame(this); // 화면에 보여지는 메인 프레임을 지정한다.
		this.getContentPane().add(page);
	}

	// 레이아웃 변화 재확인
	private void refresh() {
		this.revalidate();
		this.repaint();
	}

}
