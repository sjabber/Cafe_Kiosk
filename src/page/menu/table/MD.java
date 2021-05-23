package page.menu.table;

import DB.ConnectDB;
import page.Button.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MD extends RoundButton {

    // DB 연결 객체
    ConnectDB DB = new ConnectDB();

    String query = "SELECT Pnum, price, Pname FROM MD WHERE price != 0";
    ResultSet rs = DB.statement.executeQuery(query);

    public MD() throws SQLException {
        init();
    }

    private void init() throws SQLException {
        int i = 0; // 가로
        int j = 0; // 세로
        int count = 0;
        while(rs.next()) {
            if (count == 4) {
                count = 0;
                j++;
            }

            // x 좌표값 (초기 위치 23 + 테두리 크기 172 + 여백공간 10)
            int x = 23 + (182 * i);

            // y 좌표값 (초기 위치 10 + 테두리 크기 173 + 여백공간 15)
            int y = 10 + (188 * j);

            int num = rs.getInt("Pnum");
            int price = rs.getInt("price");
            String name = rs.getString("Pname");

            // DB 에서 읽어온 정보를 대입한다.
            JLabel NameLabel = new JLabel(name);
            JLabel PriceLabel = new JLabel(price + "");

            // 라벨 삽입
            NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            NameLabel.setForeground(Color.BLACK);
            NameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
            NameLabel.setBounds(x + 2, y + 113, 155, 20);
            this.add(NameLabel);

            PriceLabel.setForeground(Color.RED);
            PriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
            PriceLabel.setBounds(x + 47, y + 136, 65, 25);
            this.add(PriceLabel);

            // 버튼에 이미지 삽입 & 위치 조정
            RoundButton btn = new RoundButton(num);


//            ImageIcon MenuIcon = new ImageIcon("images/MD/" + num + ".jpg");
//            Image resize = MenuIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
//            ImageIcon MenuImg = new ImageIcon(resize);
//            btn.setIcon(MenuImg);
            this.setBackground(Color.black);
            this.setBounds(23 + (182 * i), 10 + (188 * j), 172, 173);
            this.setBackground(Color.white);

            // 버튼을 누르면 결제창에 정보가 업로드 되도록 (아직 안함)
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            System.out.println(i);


            i++;
            count++;
        }
    }
}
