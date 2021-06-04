package page.payment;

import DB.ConnectDB;
import Main.MainFrame;
import page.Button.HomeButton;
import page.Button.LeftButton;
import page.Button.RightButton;
import page.KioskPage;
import page.PageData;
import page.PageType;
import util.KioskAudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardPage extends KioskPage {

    private JPanel Top = new JPanel();
    private JPanel Middle = new JPanel();

    private HomeButton homeBtn = new HomeButton();
    private LeftButton Left = new LeftButton();
    private RightButton Right = new RightButton();

    ConnectDB DB = new ConnectDB();
    private final JPanel panel_1 = new JPanel();
    private final JLabel lblNewLabel_1 = new JLabel("카드 결제");
    private final JLabel lblNewLabel_2 = new JLabel("다음 그림과 같이 신용/체크카드를 넣어주세요");
    private final JLabel totalPriceLabel = new JLabel("총 결제 금액 : ");
    private final JLabel priceLabel = new JLabel("");
    private final JLabel lblNewLabel_4 = new JLabel("할부 개월");
    private final JPanel panel_2 = new JPanel();
    private final JPanel panel_3 = new JPanel();
    private final JLabel cardNumberLabel = new JLabel("카드 번호 :");
    private final JPanel imagePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("images/card-insert.jpg");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    };

    public CreditCardPage() {
        super(new PageData.Builder().previousPageType(PageType.PAYMENT_PAGE).nextPageType(PageType.RECEIPT_PAGE).build());
        mainFrame = new MainFrame();
        mainFrame.setBounds(100, 100, 768, 850);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        return Top;
    }

    private JPanel initMiddlePanel() {
        Middle.setBounds(0, 94, 754, 1000);

        Middle.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(50, 5, 657, 700);
        Middle.add(panel);
        panel.setLayout(null);
        panel_1.setToolTipText("");
        panel_1.setForeground(Color.WHITE);
        panel_1.setBackground(Color.RED);
        panel_1.setBounds(0, 0, 657, 49);

        panel.add(panel_1);
        panel_1.setLayout(null);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 10, 657, 29);

        panel_1.add(lblNewLabel_1);
        lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 70, 657, 49);

        panel.add(lblNewLabel_2);
        lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(50, 473, 565, 32);

        panel.add(lblNewLabel_4);

        JButton cancelButton = new JButton("취소");
        cancelButton.setFont(new Font("굴림", Font.BOLD, 20));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(119, 596, 146, 94);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    loadPayPage();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        panel.add(cancelButton);

        JButton verifyButton = new JButton("승인 요청");
        verifyButton.setFont(new Font("굴림", Font.BOLD, 20));
        verifyButton.setForeground(Color.WHITE);
        verifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KioskAudioPlayer.newInstance("sound/ing.wav").play();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } finally {
                    try {
                        CreditCardPage.this.loadNextPage();
                        StampUpdate(PaymentPage.UserStamp + totalquantity, PaymentPage.ID);
//                        totalquantity = 0;
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                }

                priceLabel.setText(totalamount() + " 원");
                cardNumberLabel.setText("카드 번호 : 110 - XXX - XXXXXX");
            }
        });
        verifyButton.setBackground(Color.RED);
        verifyButton.setBounds(372, 596, 146, 94);
        panel.add(verifyButton);
        panel_2.setBounds(50, 414, 565, 49);

        panel.add(panel_2);
        panel_2.setLayout(null);
        totalPriceLabel.setBounds(0, 8, 206, 35);
        panel_2.add(totalPriceLabel);
        totalPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);

        priceLabel.setForeground(Color.RED);
        priceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
        priceLabel.setBounds(218, 8, 206, 35);
        panel_2.add(priceLabel);


        panel_3.setBounds(50, 511, 565, 49);
        panel.add(panel_3);
        panel_3.setLayout(null);
        cardNumberLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
        cardNumberLabel.setBounds(0, 8, 565, 35);

        panel_3.add(cardNumberLabel);
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBounds(208, 129, 250, 250);

        panel.add(imagePanel);
        return Middle;
    }

    private void StampUpdate(int stamp, String ID) throws SQLException {
        String query1 = "UPDATE user_info SET user_Stamp=" + stamp + " WHERE user_ID='" + ID + "';";
        ConnectDB.statement.executeUpdate(query1);
    }
}
