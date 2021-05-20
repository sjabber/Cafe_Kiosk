package page.menu;

import page.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MenuPage extends KioskPage {

	private JPanel Top = new JPanel();
	private JPanel Middle = new JPanel();

	private final MenuTabbedPane menuTabbedPane;
//	private final SelectedOrderConfirmPanel selectedOrderConfirmPanel; // 일단 보류

	private final HomeButton homeBtn = new HomeButton();
	public JButton Left = new LeftButton();
	public JButton Right = new RightButton();

	private final JLabel lblNewLabel_1 = new JLabel("MD상품");
	private final JLabel lblNewLabel_1_1 = new JLabel("추천음료");
	private final JLabel lblNewLabel_1_3 = new JLabel("커피 (ICE)");
	private final JLabel lblNewLabel_1_4 = new JLabel("커피 (HOT)");
	private final JLabel lblNewLabel_1_2 = new JLabel("추천 디저트");
	
	private void setHomeBtnListener() {
		homeBtn.addActionListener(e -> {
			try {
				loadStartPage();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		});
	}

	public MenuPage() throws SQLException {
		super(new PageData.Builder().previousPageType(PageType.START_PAGE).build());
		menuTabbedPane = new MenuTabbedPane(this, KioskPage.getOrderData());
		setHomeBtnListener();
		initPage();
	}

	private void initPage() {
		this.add(initTopPanel());
		this.add(initMiddlePanel());
	}

	private JPanel initTopPanel() {
		Top.setBounds(0, 0, 754, 94);
		Top.setBackground(new Color(255, 102, 102));
		JLabel lblNewLabel = new JLabel("Easy Kiosk");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 5, 764, 26);
		Top.add(lblNewLabel);
		Top.add(homeBtn);
		Top.add(Left);
		Top.add(Right);
		Top.setLayout(null);

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1.setBounds(70, 59, 90, 26);

		Top.add(lblNewLabel_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(175, 60, 90, 26);

		Top.add(lblNewLabel_1_1);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(421, 60, 113, 26);

		Top.add(lblNewLabel_1_3);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1_4.setBounds(549, 60, 133, 26);

		Top.add(lblNewLabel_1_4);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(280, 60, 126, 26);

		Top.add(lblNewLabel_1_2);

		return Top;
	}

	private JPanel initMiddlePanel() {
		Middle.setBounds(0, 94, 754, 719);
		return Middle;
	}

	private void setLayout() {

	}

}
