//package page.menu;
//
//import DB.ConnectDB;
//import page.KioskPage;
//import page.PageData;
//import page.PageType;
//import page.Button.HomeButton;
//import page.Button.LeftButton;
//import page.Button.RightButton;
//import page.Button.RoundButton;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DessertPage extends KioskPage {  //왠지 필요해보여서 extend했는데...
//
//
//	private JFrame frame;
//	private JPanel Top = new JPanel();
//	private JPanel Middle = new JPanel();
//	private JPanel Bottom = new JPanel();
//	private JPanel selectPanel = new JPanel();
//
//	// TopSetting -> 1 좌측, TopSetting -> 2 우측
//	private int TopSetting = 1; // default -> 1
//
//	// Selected -> 1번 MD, 2번 추천 음료, 3번 추천 디저트, 4번 아이스 커피, 5번 뜨거운 커피, 6번 디저트
//	//3번이 디저트가되었다
//	private int Selected = 3; // default -> 1번
//
//
//
//	private HomeButton homeBtn = new HomeButton();
//	private LeftButton Left = new LeftButton();
//	private RightButton Right = new RightButton();
//
//	ConnectDB DB = new ConnectDB();
//
//	private final JLabel lblNewLabel_1 = new JLabel("MD상품");
//	private final JLabel lblNewLabel_1_1 = new JLabel("추천음료");
//	private final JLabel lblNewLabel_1_3 = new JLabel("커피 (ICE)");
//	private final JLabel lblNewLabel_1_4 = new JLabel("커피 (HOT)");
//	private final JLabel lblNewLabel_1_2 = new JLabel("디저트");
//	private final JLabel lblNewLabel_3 = new JLabel("2000원");
//
//	//메인페이지에서 홈버튼 복붙한거
//	 private void setHomeBtnListener() {
//	        homeBtn.addActionListener(e -> {
//	            try {
//	                loadStartPage();
//	            } catch (SQLException exception) {
//	                exception.printStackTrace();
//	            }
//	        });
//	    }
//
//	    protected HomeButton getHomeBtn() {
//	        return homeBtn;
//	    }
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DessertPage window = new DessertPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public DessertPage() throws SQLException {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() throws SQLException {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 768, 850);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		Top.setBounds(0, 0, 754, 94);
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
//		lblNewLabel_1.setBounds(70, 60, 90, 26);
//		Top.add(lblNewLabel_1);
//
//		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_1.setForeground(Color.WHITE);
//		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_1.setBounds(175, 60, 90, 26);
//		Top.add(lblNewLabel_1_1);
//
//		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_3.setForeground(Color.WHITE);
//		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_3.setBounds(421, 60, 113, 26);
//		Top.add(lblNewLabel_1_3);
//
//		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_4.setForeground(Color.WHITE);
//		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_4.setBounds(549, 60, 133, 26);
//		Top.add(lblNewLabel_1_4);
//
//		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_2.setForeground(Color.WHITE);
//		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		lblNewLabel_1_2.setBounds(280, 60, 126, 26);
//		Top.add(lblNewLabel_1_2);
//
//		//버튼 액션필요해보여서 넣어둔것
//		lblNewLabel_1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("MD 상품 클릭됨.");
//                Selected = 1;
//                try {
//                    loadMenuPage();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        });
//
//		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("추천 음료 클릭됨");
//                Selected = 2;
//                try {
//                    loadMenuPage();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        });
//
//		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("디저트 클릭됨");
//                Selected = 3;
//                try {
//                    loadMenuPage();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        });
//
//		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("커피 아이스 클릭됨");
//                Selected = 4;
//                try {
//                    loadMenuPage();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        });
//
//		lblNewLabel_1_4.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("커피 핫 클릭됨.");
//                Selected = 5;
//                try {
//                    loadMenuPage();
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            }
//        });
//
//
//		Middle.setBounds(0, 94, 754, 566);
//
//		Bottom.setBounds(0, 660, 754, 238);
//		Bottom.setBackground(Color.red);
//
//		frame.getContentPane().add(Top);
//
//
//		selectPanel.setBounds(57, 52, 110, 43);
//		Top.add(selectPanel);
//		frame.getContentPane().add(Middle);
//		Middle.setLayout(null);
//
//
//
//
//
//		// Middle
//		switch(Selected) {
//			case 1:
//				String query = "SELECT Pnum, price, Pname FROM MD WHERE price != 0";
//				PanelSet(query, Middle, DB);
//
//				break;
//			case 2:
//
//				break;
//			case 3:
//				String query3= "SELECT Pnum, price, Pname FROM dessert WHERE price != 0";
//				PanelSet(query3, Middle, DB);
//				break;
//			case 4:
//
//				break;
//			case 5:
//
//				break;
//			case 6:
//
//				break;
//		}
//
//
//		frame.getContentPane().add(Bottom);
//	}
//
//	private void PanelSet(String query, JPanel middle, ConnectDB db) throws SQLException {
//		ResultSet rs = db.statement.executeQuery(query);
//
//		int i = 0;
//		int j = 0;
//		int count = 0;
//
//		while(rs.next()) {
//			if (count == 4) {
//				count = 0;
//				i = 0;
//				j++;
//			}
//
//			// x 좌표값 (초기 위치 23 + 테두리 크기 172 + 여백공간 10)
//			int x = 18 + (182 * i);
//
//			// y 좌표값 (초기 위치 10 + 테두리 크기 173 + 여백공간 15)
//			int y = 10 + (188 * j);
//
//			int num = rs.getInt("Pnum");
//			int price = rs.getInt("price");
//			String name = rs.getString("Pname");
//
////					// DB 에서 읽어온 정보를 대입한다.
//			JLabel NameLabel = ProductName(x, y, name);
//			JLabel PriceLabel = ProductPrice(x, y, price);
//
//			middle.add(NameLabel);
//			middle.add(PriceLabel);
//			middle.add(ProductButton(x, y, num, NameLabel, PriceLabel));
//
//			i++;
//			count++;
//		}
//
//		middle.setLayout(null);
//	}
//
//	// 자주 사용하는 코드 메서드로 만듦.
//	private JLabel ProductName(int x, int y, String name) {
//		JLabel NameLabel = new JLabel(name);
//		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		NameLabel.setForeground(Color.BLACK);
//		NameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
//		NameLabel.setBounds(x + 2, y + 113, 155, 20);
//
//		return NameLabel;
//	}
//
//	private JLabel ProductPrice(int x, int y, int price) {
//		JLabel PriceLabel = new JLabel(price + "");
//		PriceLabel.setForeground(Color.RED);
//		PriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
//		PriceLabel.setBounds(x + 55, y + 136, 65, 25);
//
//		return PriceLabel;
//	}
//
//	private RoundButton ProductButton(int x, int y, int num, JLabel L1, JLabel L2) {
//		// 버튼 위치 조정
//		RoundButton btn = new RoundButton(num);
//		btn.setBackground(Color.white);
//		btn.setFocusPainted(false);
//		btn.setBorderPainted(false);
//		btn.setBounds(x, y, 172, 173);
//
//
//		// 버튼을 누르면 결제창에 정보가 업로드 되도록 (아직 안함)
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(L1.getText());
//				System.out.println(L2.getText());
//			}
//		});
//
//		return btn;
//	}
//}
