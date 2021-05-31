package page.start;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import page.KioskPage;
import page.PageData;
import page.PageType;

public class StartPage extends KioskPage {

	private JPanel Top = new JPanel();
	private JPanel Middle = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("images/Main.PNG");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
		}
	};

	public StartPage() {
		super(new PageData.Builder().nextPageType(PageType.START_PAGE).build());
		initPage();
		setNextPage();
	}

	private void initPage() {
		this.add(initTopPanel());
		this.add(initMiddlePanel());
	}
	
	private JPanel initTopPanel() {
		Top.setLayout(new BorderLayout());
		Top.setBounds(0, 0, 764, 36);
		Top.setBackground(new Color(255, 102, 102));
		JLabel lblNewLabel = new JLabel("Easy Kiosk");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 5, 764, 26);
		Top.add(lblNewLabel);

		return Top;
	}
	
	private JPanel initMiddlePanel() {
		Middle.setBounds(0, 36, 764, 780);
		Middle.setLayout(null);
		this.add(Middle);

		return Middle;
	}

//	private void initialize() {
//		frame = new JFrame();
//		frame.setTitle("시작화면");
//		frame.setBounds(100, 100, 768, 850); // 프레임 크기
//		frame.setLocationRelativeTo(null); // 창이 가운데 나오도록
//		frame.setResizable(false); // 창 크기 변경 못하게
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame이 정상적으로 종료되도록
//		frame.getContentPane().setLayout(null);
//	}

	private void setNextPage() {
		this.setOnClickListener(() -> {
			try {
				StartPage.this.loadMenuPage();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		});
	}
}
