//package page.menu;
//
//import page.*;
//import page.Button.HomeButton;
//import page.Button.LeftButton;
//import page.Button.RightButton;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.SQLException;
//
//public class MenuPage extends KioskPage {
//
//	private JPanel Top = new JPanel();
//	private JPanel Middle = new JPanel();
//	private JPanel Bottom = new JPanel();
//
//	// TopSetting -> 1 좌측, TopSetting -> 2 우측
//	private int TopSetting = 1; // default -> 1
//
//	// Selected -> 1번 MD, 2번 추천 음료, 3번 추천 디저트, 4번 아이스 커피, 5번 뜨거운 커피, 6번 디저트
//	private int Selected = 1; // default -> 1번
//
//	private final MenuTabbedPane menuTabbedPane;
////	private final SelectedOrderConfirmPanel selectedOrderConfirmPanel; // 일단 보류
//
//	private HomeButton homeBtn = new HomeButton();
//	private LeftButton Left = new LeftButton();
//	private RightButton Right = new RightButton();
//
//	private final JLabel lblNewLabel_1 = new JLabel("MD상품");
//	private final JLabel lblNewLabel_1_1 = new JLabel("추천음료");
//	private final JLabel lblNewLabel_1_3 = new JLabel("커피 (ICE)");
//	private final JLabel lblNewLabel_1_4 = new JLabel("커피 (HOT)");
//	private final JLabel lblNewLabel_1_2 = new JLabel("추천 디저트");
//
//	private void setHomeBtnListener() {
//		homeBtn.addActionListener(e -> {
//			try {
//				loadStartPage();
//			} catch (SQLException exception) {
//				exception.printStackTrace();
//			}
//		});
//	}
//
//	protected HomeButton getHomeBtn() {
//		return homeBtn;
//	}
//
//	public MenuPage() throws SQLException {
//		// 이후 -> 결제 확인호면, 이전 -> 홈화면
//		super(new PageData.Builder().nextPageType(PageType.PAY_PAGE).previousPageType(PageType.START_PAGE).build());
//		menuTabbedPane = new MenuTabbedPane(this, KioskPage.getOrderData());
//		setHomeBtnListener();
//		initPage();
//		setLayout();
//	}
//
//	private void initPage() {
//		this.add(initTopPanel());
//		this.add(initMiddlePanel());
//		this.add(initBottomPanel());
//	}
//
//	private JPanel initTopPanel() {
//		Top.setBounds(0, 0, 754, 94);
//		Top.add(menuTabbedPane, BorderLayout.CENTER);
//		Top.setBackground(new Color(255, 102, 102));
//		JLabel lblNewLabel = new JLabel("Easy Kiosk");
//		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
//		lblNewLabel.setForeground(new Color(255, 255, 255));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(0, 5, 764, 26);
//		Top.add(lblNewLabel);
//		Top.add(homeBtn);
//		Top.add(Left);
//		Top.add(Right);
//		Top.setLayout(null);
//
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setForeground(Color.WHITE);
//		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1.setBounds(70, 59, 90, 26);
//
//		Top.add(lblNewLabel_1);
//		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_1.setForeground(Color.WHITE);
//		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_1.setBounds(175, 60, 90, 26);
//
//		Top.add(lblNewLabel_1_1);
//		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_3.setForeground(Color.WHITE);
//		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_3.setBounds(421, 60, 113, 26);
//
//		Top.add(lblNewLabel_1_3);
//		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_4.setForeground(Color.WHITE);
//		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_4.setBounds(549, 60, 133, 26);
//
//		Top.add(lblNewLabel_1_4);
//		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_2.setForeground(Color.WHITE);
//		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_2.setBounds(280, 60, 126, 26);
//
//		Top.add(lblNewLabel_1_2);
//
//		return Top;
//	}
//
//	private JPanel initMiddlePanel() {
//		Middle.setBounds(0, 94, 754, 566);
//		return Middle;
//	}
//
//	private JPanel initBottomPanel() {
//		Bottom.setBounds(0, 660, 754, 238);
//		Bottom.setBackground(Color.red);
//		return Bottom;
//	}
//
//
//	// 홈버튼 누르면 주문내역 초기화
//	private void setLayout() {
//		this.getHomeBtn().addActionListener((e) -> KioskPage.getOrderData().clearMenu());
//	}
//
//}
