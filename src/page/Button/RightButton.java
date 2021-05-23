package page.Button;

import javax.swing.*;
import java.awt.*;

public class RightButton extends JButton {
    public RightButton() {
        init();
    }

    private void init() {
        ImageIcon RightIcon = new ImageIcon("images/Right.png");
        Image changeRightIcon = RightIcon.getImage().getScaledInstance(30, 35, Image.SCALE_SMOOTH);
        ImageIcon RightBtn = new ImageIcon(changeRightIcon);
        this.setIcon(RightBtn);
        this.setBackground(new Color(255, 102, 102));
        this.setBounds(703, 51, 35, 35);
        this.setBorderPainted(false);
    }
}
