package page.menu;

import DB.ConnectDB;
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

    private final JLabel label1 = new JLabel("MD상품");
    private final JLabel label2 = new JLabel("추천음료");
    private final JLabel label3 = new JLabel("추천 디저트");
    private final JLabel label4 = new JLabel("커피 (ICE)");
    private final JLabel label5 = new JLabel("커피 (HOT)");


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
        setHomeBtnListener();
        initPage();
        setLayout();
    }

    private void initPage() throws SQLException {
        this.add(initTopPanel());
        this.add(initMiddlePanel());
        this.add(initBottomPanel());
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
        label2.setBounds(175, 60, 90, 31);
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
                System.out.println("MD 상품 클릭됨.");
                Selected = 2;
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
                System.out.println("MD 상품 클릭됨.");
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
                System.out.println("MD 상품 클릭됨.");
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
                System.out.println("MD 상품 클릭됨.");
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
                System.out.println("MD 상품 클릭됨.");
                Selected = 5;
                try {
                    loadMenuPage();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });



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
                case 1:
                    String query = "SELECT Pnum, price, Pname FROM MD WHERE price != 0";
                    PanelSet(query, Middle, DB);

                    selectPanel.setBounds(57, 52, 110, 43);
                    Top.add(selectPanel);

                    break;
                case 2:

                    selectPanel.setBounds(162, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
                case 3:

                    selectPanel.setBounds(277, 52, 130, 43);
                    Top.add(selectPanel);
                    break;
                case 4:

                    selectPanel.setBounds(410, 52, 130, 43);
                    Top.add(selectPanel);
                    break;
                case 5:

                    selectPanel.setBounds(555, 52, 130, 43);
                    Top.add(selectPanel);
                    break;
                case 6:
//
//                    selectPanel.setBounds(555, 52, 130, 43);
//                    Top.add(selectPanel);
                    break;
            }
        } else {
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

                    selectPanel.setBounds(277, 52, 130, 43);
                    Top.add(selectPanel);
                    break;
                case 4: // 커피 (ICE)

                    selectPanel.setBounds(372, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
                case 5: // 커피 (HOT)

                    selectPanel.setBounds(477, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
                case 6: // 디저트

                    selectPanel.setBounds(582, 52, 110, 43);
                    Top.add(selectPanel);
                    break;
            }
        }


        return Middle;
    }

    private JPanel initBottomPanel() {
        Bottom.setBounds(0, 660, 754, 238);
        Bottom.setBackground(Color.red);
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
                System.out.println(L1.getText());
                System.out.println(L2.getText());
            }
        });

        return btn;
    }


    // 홈버튼 누르면 주문내역 초기화
    private void setLayout() {
        this.getHomeBtn().addActionListener((e) -> KioskPage.getOrderData().clearMenu());
    }

}
