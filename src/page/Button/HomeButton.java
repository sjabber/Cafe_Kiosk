package page.Button;

import javax.swing.*;
import java.awt.*;

public class HomeButton extends JButton {

    public HomeButton() {
        init();
    }

    private void init() {
        ImageIcon HomeIcon = new ImageIcon("images/home.PNG");
        Image changeHomeImg = HomeIcon.getImage().getScaledInstance(30, 35, Image.SCALE_SMOOTH);
        ImageIcon home = new ImageIcon(changeHomeImg);
        this.setIcon(home);
        this.setBackground(new Color(255, 102, 102));
        this.setBounds(3, 3, 35, 35);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        //		homeBtn.setContentAreaFilled(false); // 클릭 표시 안나도록.
    }
}
