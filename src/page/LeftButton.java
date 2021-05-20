package page;

import javax.swing.*;
import java.awt.*;

public class LeftButton extends JButton {

    public LeftButton() {
        init();
    }

    private void init() {
        ImageIcon LeftIcon = new ImageIcon("images/Left.png");
        Image changeLeftIcon = LeftIcon.getImage().getScaledInstance(30, 35, Image.SCALE_SMOOTH);
        ImageIcon LeftBtn = new ImageIcon(changeLeftIcon);
        this.setIcon(LeftBtn);
        this.setBackground(new Color(255, 102, 102));
        this.setBounds(16, 51, 35, 35);
        this.setFocusPainted(false); // 테두리 지우기
        this.setBorderPainted(false);  // 테두리 지우기 2
    }

}
