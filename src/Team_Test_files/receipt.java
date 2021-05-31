package Team_Test_files;

import DB.ConnectDB;
import page.Button.HomeButton;
import page.Button.LeftButton;
import page.Button.RightButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class receipt {

    private JFrame frame;
    private JPanel Top = new JPanel();
    private JPanel Middle = new JPanel();

    private HomeButton homeBtn = new HomeButton();
    private LeftButton Left = new LeftButton();
    private RightButton Right = new RightButton();

    ConnectDB DB = new ConnectDB();
    private final JPanel panel_1 = new JPanel();
    private final JLabel headLabel = new JLabel("영수증 출력");
    private final JLabel lblNewLabel_2 = new JLabel("영수증을 출력하시겠습니까?");
    private final JLabel totalPriceLabel = new JLabel("총 결제 금액 : ");
    private final JLabel lblNewLabel_4 = new JLabel("할부 개월");
    private final JPanel panel_2 = new JPanel();
    private final JPanel panel_3 = new JPanel();
    private final JLabel cardNumberLabel = new JLabel("카드 번호 :");
    private final JLabel priceLabel = new JLabel("");



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	receipt window = new receipt();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public receipt() throws SQLException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws SQLException {
        frame = new JFrame();
        frame.setBounds(100, 100, 768, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        Middle.setBounds(0, 94, 754, 566);

        frame.getContentPane().add(Top);
        frame.getContentPane().add(Middle);
        Middle.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(52, 250, 657, 394);
        Middle.add(panel);
        panel.setLayout(null);
        panel_1.setToolTipText("");
        panel_1.setForeground(Color.WHITE);
        panel_1.setBackground(Color.RED);
        panel_1.setBounds(0, 0, 657, 49);
        
        panel.add(panel_1);
        panel_1.setLayout(null);
        headLabel.setForeground(Color.WHITE);
        headLabel.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        headLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headLabel.setBounds(0, 10, 657, 29);
        
        panel_1.add(headLabel);
        lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 90, 657, 49);
        
        panel.add(lblNewLabel_2);
        lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(50, 473, 565, 32);
        
        panel.add(lblNewLabel_4);

        JButton yesButton = new JButton("예");
        yesButton.setFont(new Font("굴림", Font.BOLD, 20));
        yesButton.setForeground(Color.WHITE);
        yesButton.setBackground(Color.BLACK);
        yesButton.setBounds(119, 200, 146, 94);
        panel.add(yesButton);
        
        JButton noButton = new JButton("아니오");
        noButton.setFont(new Font("굴림", Font.BOLD, 20));
        noButton.setForeground(Color.WHITE);
        noButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                cardNumberLabel.setText("카드 번호 : 110 - XXX - XXXXXX");
           }
        });
        noButton.setBackground(Color.RED);
        noButton.setBounds(372, 200, 146, 94);
        panel.add(noButton);
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
    }


}
