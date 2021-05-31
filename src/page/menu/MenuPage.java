package page.menu;

import DB.ConnectDB;
import DB.Product;
import Main.MainFrame;
import page.Button.HomeButton;
import page.Button.LeftButton;
import page.Button.RightButton;
import page.Button.RoundButton;
import page.KioskPage;
import page.PageData;
import page.PageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuPage extends KioskPage {

    ConnectDB DB = new ConnectDB();
    private JPanel Top = new JPanel();
    private JPanel Middle = new JPanel();
    private JPanel Bottom = new JPanel();
    private JPanel selectPanel;

    // TopSetting -> 1 좌측, TopSetting -> 2 우측
    private int TopSetting = 1; // default -> 1

    // Selected -> 1번 MD, 2번 추천 음료, 3번 추천 디저트, 4번 아이스 커피, 5번 뜨거운 커피, 6번 디저트
    public static Integer Selected = 1; // default -> 1번

//	private final MenuTabbedPane menuTabbedPane;
//	private final SelectedOrderConfirmPanel selectedOrderConfirmPanel; // 일단 보류

    private HomeButton homeBtn = new HomeButton();
    private LeftButton Left = new LeftButton();
    private RightButton Right = new RightButton();
    private final JPanel Bottompanel = new JPanel();

    private final JLabel label1 = new JLabel("MD상품");
    private final JLabel label2 = new JLabel("추천 메뉴");
    private final JLabel label3 = new JLabel("디저트");
    private final JLabel label4 = new JLabel("커피 (ICE)");
    private final JLabel label5 = new JLabel("커피 (HOT)");
    private JTextField Totalamount;
    private final JButton btnNewButton = new JButton("결제");
    private final JPanel panel_0 = new JPanel();
    private final JPanel panel_1 = new JPanel();
    private final JPanel panel_2 = new JPanel();
    private final JPanel panel_3 = new JPanel();
    private final JButton MinusOnList_0 = new JButton("-");
    private final JButton PlusOnList_0 = new JButton("+");
    private JTextField menulist_0;
    private JTextField menulist_1;
    private JTextField menulist_2;
    private JTextField menulist_3;
    private final JLabel menucount_0 = new JLabel("1");
    private final JLabel menucount_1 = new JLabel("1");
    private final JLabel menucount_2 = new JLabel("1");
    private final JLabel menucount_3 = new JLabel("1");

    private void setHomeBtnListener() {
        homeBtn.addActionListener(e -> {
            try {
                loadStartPage();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
    }

    protected HomeButton getHomeBtn() {
        return homeBtn;
    }

    public MenuPage() throws SQLException {
        // 이후 -> 결제 확인호면, 이전 -> 홈화면
        super(new PageData.Builder().nextPageType(PageType.PAY_PAGE).previousPageType(PageType.START_PAGE).build());
//		menuTabbedPane = new MenuTabbedPane(this, KioskPage.getOrderData());
        mainFrame = new MainFrame();
        mainFrame.setBounds(100, 100, 768, 850);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setHomeBtnListener();
        initPage();
        setLayout();
    }

    private void initPage() throws SQLException {
//    	this.frame.getContentPane().add(Top);
//    	this.frame.getContentPane().add(Middle);
//    	this.frame.getContentPane().add(Bottom);

        this.add(initTopPanel());
        this.add(initMiddlePanel());
        this.add(initBottomPanel());
        this.add(initCheckListPanel());
    }

    private JPanel initTopPanel() {

        Top.setBounds(0, 0, 754, 94);
//		Top.add(menuTabbedPane, BorderLayout.CENTER);
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

        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        label1.setBounds(70, 59, 90, 31);
        Top.add(label1);

        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        label2.setBounds(175, 60, 110, 31);
        Top.add(label2);

        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        label3.setBounds(280, 60, 126, 31);
        Top.add(label3);

        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        label4.setBounds(421, 60, 113, 31);
        Top.add(label4);

        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        label5.setBounds(549, 60, 133, 31);
        Top.add(label5);

        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("MD 상품 클릭됨.");
                Selected = 1;
                try {
                    loadMenuPage();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("추천 음료 클릭됨.");
                Selected = 2;
                try {
                    loadMenuPage();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("디저트 클릭됨.");
                Selected = 3;
                try {
                    loadMenuPage();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("커피 아이스 클릭됨.");
                Selected = 4;
                try {
                    loadMenuPage();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        label5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("커피 핫 클릭됨.");
                Selected = 5;
                try {
                    loadMenuPage();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        mainFrame.getContentPane().setLayout(null);

        mainFrame.getContentPane().add(Top);

        return Top;
    }

    private JPanel initMiddlePanel() throws SQLException {
        Middle.setBounds(0, 94, 754, 566);
        selectPanel = new JPanel();
        // Middle

        // Selected의 디폴트값은 1
        if (Selected == null) Selected = 1;

        if (TopSetting == 1) {
            switch (Selected) {
                case 1: // MD 상품
                    PanelSet("SELECT Pnum, price, Pname FROM MD WHERE price != 0", Middle, DB);

                    selectPanel.setBounds(57, 52, 110, 43);
                    Top.add(selectPanel);

                    break;

                case 2: // 추천 메뉴
                    String query = "SELECT Pnum, price, Pname\n" +
                            "FROM (SELECT Pr.Pnum, price, Pname, Count\n" +
                            "      From Products as Pr\n" +
                            "            LEFT JOIN I_coffee i ON i.Pnum = Pr.Pnum\n" +
                            "      ORDER BY Count DESC\n" +
                            "      LIMIT 12) as P\n" +
                            "where price is not null and Pname is not null\n" +
                            "ORDER BY Pnum";
                    PanelSet(query, Middle, DB);
                    selectPanel.setBounds(175, 52, 110, 43);
                    Top.add(selectPanel);
                    break;

                case 3: // 디저트
                    PanelSet("SELECT Pnum, price, Pname FROM dessert WHERE price != 0", Middle, DB);

                    selectPanel.setBounds(292, 52, 100, 43);
                    Top.add(selectPanel);
                    break;

                case 4: // 커피 (ICE)
                    PanelSet("SELECT Pnum, price, Pname FROM I_coffee WHERE price != 0", Middle, DB);
                    selectPanel.setBounds(410, 52, 130, 43);
                    Top.add(selectPanel);
                    break;

                case 5: // 커피 (HOT)
                    PanelSet("SELECT Pnum, price, Pname FROM H_coffee WHERE price != 0", Middle, DB);
                    selectPanel.setBounds(550, 52, 130, 43);
                    Top.add(selectPanel);
                    break;
            }
        }
/*        else {
            switch (Selected) {
                case 1: // MD 상품
                    String query = "SELECT Pnum, price, Pname FROM MD WHERE price != 0";
                    PanelSet(query, Middle, DB);

                    selectPanel.setBounds(57, 52, 110, 43);
                    Top.add(selectPanel);

                    break;
                case 2: // 추천음료

                    selectPanel.setBounds(162, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
                case 3: // 추천디저트
                    String query3 = "SELECT Pnum, price, Pname FROM dessert WHERE price != 0";
                    PanelSet(query3, Middle, DB);
                    selectPanel.setBounds(277, 52, 130, 43);
                    Top.add(selectPanel);

                    break;
                case 4: // 커피 (ICE)
                    String query4 = "SELECT Pnum, price, Pname FROM I_coffee WHERE price != 0";
                    PanelSet(query4, Middle, DB);
                    selectPanel.setBounds(372, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
                case 5: // 커피 (HOT)
                    String query5 = "SELECT Pnum, price, Pname FROM H_coffee WHERE price != 0";
                    PanelSet(query5, Middle, DB);
                    selectPanel.setBounds(477, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
                case 6: // 디저트

                    selectPanel.setBounds(582, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
            }
        }*/

        mainFrame.getContentPane().add(Middle);
        return Middle;
    }

    private JPanel initBottomPanel() {
        Bottom.setBounds(0, 660, 754, 238);
        Bottom.setBackground(Color.red);
        Bottom.setLayout(null);

        return Bottom;
    }

    private void PanelSet(String query, JPanel middle, ConnectDB db) throws SQLException {
        ResultSet rs = db.statement.executeQuery(query);

        int i = 0;
        int j = 0;
        int count = 0;

        while (rs.next()) {
            if (count == 4) {
                count = 0;
                i = 0;
                j++;
            }

            // x 좌표값 (초기 위치 23 + 테두리 크기 172 + 여백공간 10)
            int x = 18 + (182 * i);

            // y 좌표값 (초기 위치 10 + 테두리 크기 173 + 여백공간 15)
            int y = 10 + (188 * j);

            int num = rs.getInt("Pnum");
            int price = rs.getInt("price");
            String name = rs.getString("Pname");

//					// DB 에서 읽어온 정보를 대입한다.
            JLabel NameLabel = ProductName(x, y, name);
            JLabel PriceLabel = ProductPrice(x, y, price);

            middle.add(NameLabel);
            middle.add(PriceLabel);
            middle.add(ProductButton(x, y, num, NameLabel, PriceLabel));

            i++;
            count++;
        }

        middle.setLayout(null);
    }

    // 자주 사용하는 코드 메서드로 만듦.
    private JLabel ProductName(int x, int y, String name) {
        JLabel NameLabel = new JLabel(name);
        NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        NameLabel.setForeground(Color.BLACK);
        NameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        NameLabel.setBounds(x + 2, y + 113, 155, 20);

        return NameLabel;
    }

    private JLabel ProductPrice(int x, int y, int price) {
        JLabel PriceLabel = new JLabel(price + "");
        PriceLabel.setForeground(Color.RED);
        PriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        PriceLabel.setBounds(x + 55, y + 136, 65, 25);

        return PriceLabel;
    }

    private RoundButton ProductButton(int x, int y, int num, JLabel L1, JLabel L2) {
        // 버튼 위치 조정
        RoundButton btn = new RoundButton(num);
        btn.setBackground(Color.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 172, 173);


        // 버튼을 누르면 결제창에 정보가 업로드 되도록 (아직 안함)
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Product p = new Product(L1.getText(), Integer.parseInt(L2.getText()));
                //같은메뉴가 장바구니에 있을시 변화없음 (수량 하나 추가할지 고려해봐야함)
                if (getIndex(L1.getText()) == -1 && CheckList.size() < 4) {
                    CheckList.add(p);
                    cart.put(p, 1);
                }else if(CheckList.size()==4) {
                	JOptionPane4MAX();
                }

                viewcart();

            }
        });

        return btn;
    }

    public void viewcart() {
        int i = CheckList.size();
        int k = 0;
        panel_0.setVisible(false);
        panel_1.setVisible(false);
        panel_2.setVisible(false);
        panel_3.setVisible(false);
        keys = cart.keySet();

        switch (k) {
            case 0:
                if (k == i)
                    break;

                panel_0.setVisible(true);
                menulist_0.setText(CheckList.get(k).getProd_name());
                menucount_0.setText(cart.get(CheckList.get(k)) + "");
                k++;
            case 1:
                if (k == i)
                    break;
                panel_1.setVisible(true);
                menulist_1.setText(CheckList.get(k).getProd_name());
                menucount_1.setText(cart.get(CheckList.get(k)) + "");

                k++;

            case 2:
                if (k == i)
                    break;
                panel_2.setVisible(true);
                menulist_2.setText(CheckList.get(k).getProd_name());
                menucount_2.setText(cart.get(CheckList.get(k)) + "");
                k++;
            case 3:
                if (k == i)
                    break;
                panel_3.setVisible(true);
                menulist_3.setText(CheckList.get(k).getProd_name());
                menucount_3.setText(cart.get(CheckList.get(k)) + "");
                k++;
           
        }
        Totalamount.setText(totalamount() + "");
    }

    private JPanel initCheckListPanel() {
        Bottompanel.setBounds(0, 662, 754, 162);
        Bottom.add(Bottompanel);
        Bottompanel.setLayout(null);


        Totalamount = new JTextField();
        Totalamount.setText("0");
        Totalamount.setBounds(618, 6, 130, 45);
        Bottompanel.add(Totalamount);
        Totalamount.setColumns(10);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//장바구니가 비었으면 에러창 팝업, 담겨져있으면 결제창으로
            	try {
            		if(CheckList.size()==0) {
            			JOptionPaneEx();
            		}else if(CheckList.size()!=0){
            			loadPayPage();
            		}            		
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
        btnNewButton.setBounds(618, 53, 130, 103);

        Bottompanel.add(btnNewButton);
        panel_0.setBounds(6, 6, 609, 37);

        menucount_0.setHorizontalAlignment(SwingConstants.CENTER);
        menucount_0.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        menucount_0.setBounds(444, 11, 62, 16);
        panel_0.add(menucount_0);

        Bottompanel.add(panel_0);
        panel_0.setLayout(null);
        MinusOnList_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menudelete(menulist_0, menucount_0);
                viewcart();
            }
        });
        MinusOnList_0.setBounds(415, 6, 29, 29);

        panel_0.add(MinusOnList_0);

        menulist_0 = new JTextField();
        menulist_0.setBounds(35, 0, 351, 37);
        panel_0.add(menulist_0);
        menulist_0.setColumns(10);

        PlusOnList_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuadd(menulist_0, menucount_0);
                Totalamount.setText(totalamount() + "");
            }
        });
        PlusOnList_0.setBounds(506, 6, 29, 29);

        panel_0.add(PlusOnList_0);

        panel_1.setLayout(null);
        panel_1.setBounds(6, 43, 609, 37);
        Bottompanel.add(panel_1);

        menucount_1.setHorizontalAlignment(SwingConstants.CENTER);
        menucount_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        menucount_1.setBounds(444, 11, 62, 16);
        panel_1.add(menucount_1);

        JButton MinusOnList_1 = new JButton("-");
        MinusOnList_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menudelete(menulist_1, menucount_1);
                viewcart();
            }
        });
        MinusOnList_1.setBounds(415, 6, 29, 29);
        panel_1.add(MinusOnList_1);


        menulist_1 = new JTextField();
        menulist_1.setColumns(10);
        menulist_1.setBounds(35, 0, 351, 37);
        panel_1.add(menulist_1);

        JButton PlusOnList_1 = new JButton("+");
        PlusOnList_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuadd(menulist_1, menucount_1);
                Totalamount.setText(totalamount() + "");
            }
        });
        PlusOnList_1.setBounds(506, 6, 29, 29);
        panel_1.add(PlusOnList_1);

        panel_2.setLayout(null);
        panel_2.setBounds(6, 80, 609, 37);
        Bottompanel.add(panel_2);

        menucount_2.setHorizontalAlignment(SwingConstants.CENTER);
        menucount_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        menucount_2.setBounds(444, 11, 62, 16);
        panel_2.add(menucount_2);

        JButton MinusOnList_2 = new JButton("-");
        MinusOnList_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menudelete(menulist_2, menucount_2);
                viewcart();
            }
        });
        MinusOnList_2.setBounds(415, 6, 29, 29);
        panel_2.add(MinusOnList_2);


        menulist_2 = new JTextField();
        menulist_2.setColumns(10);
        menulist_2.setBounds(35, 0, 351, 37);
        panel_2.add(menulist_2);

        JButton PlusOnList_2 = new JButton("+");
        PlusOnList_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuadd(menulist_2, menucount_2);
                Totalamount.setText(totalamount() + "");
            }
        });
        PlusOnList_2.setBounds(506, 6, 29, 29);
        panel_2.add(PlusOnList_2);

        panel_3.setLayout(null);
        panel_3.setBounds(6, 117, 609, 37);
        Bottompanel.add(panel_3);

        menucount_3.setHorizontalAlignment(SwingConstants.CENTER);
        menucount_3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        menucount_3.setBounds(444, 11, 62, 16);
        panel_3.add(menucount_3);

        JButton MinusOnList_3 = new JButton("-");
        MinusOnList_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menudelete(menulist_3, menucount_3);
                viewcart();
            }
        });
        MinusOnList_3.setBounds(415, 6, 29, 29);
        panel_3.add(MinusOnList_3);


        menulist_3 = new JTextField();
        menulist_3.setColumns(10);
        menulist_3.setBounds(35, 0, 351, 37);
        panel_3.add(menulist_3);

        JButton PlusOnList_3 = new JButton("+");
        PlusOnList_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuadd(menulist_3, menucount_3);
                Totalamount.setText(totalamount() + "");
            }
        });
        PlusOnList_3.setBounds(506, 6, 29, 29);
        panel_3.add(PlusOnList_3);

        viewcart();

        mainFrame.getContentPane().add(Bottom);

        return Bottompanel;
    }

    // 홈버튼 누르면 주문내역 초기화
    private void setLayout() {
    	this.getHomeBtn();
    	getHomeBtn().addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		CheckList = new ArrayList<>();
    		cart = new HashMap<>();
    		}
    });
//        this.getHomeBtn().addActionListener((e) -> KioskPage.getOrderData().clearMenu());
    }
    // 장바구니에 아무것도 없을시 에러창 팝업
    public void JOptionPaneEx() {
		JOptionPane.showMessageDialog(this, "메뉴를 추가해주십시오.", "Message", JOptionPane.ERROR_MESSAGE);

    }
    public void JOptionPane4MAX() {
		JOptionPane.showMessageDialog(this, "메뉴는 최대 4종류 선택가능합니다.", "Message", JOptionPane.ERROR_MESSAGE);

    }
}
