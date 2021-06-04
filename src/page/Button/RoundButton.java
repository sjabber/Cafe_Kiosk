package page.Button;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {

    private int num;

    public RoundButton() {
        decorate();
    }

    public RoundButton(int num) {
        this.num = num;
        decorate();
    }

    public RoundButton(String imgPath) {
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        // 마우스가 올라간 상태인지, 눌린 상태인지에 따라 색상을 다르게 한다.
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isArmed()) {
            graphics.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(getBackground().brighter());
        } else {
            graphics.setColor(getBackground());
        }

        // 둥글기를 조절한다.
        graphics.fillRoundRect(0, 0, width, height, 50, 50);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        ImageIcon image = new ImageIcon("images/" + num + ".jpg");
        graphics.drawImage(image.getImage(), 30, 2, 110, 110, null);

        graphics.setColor(getForeground());
        graphics.setFont(getFont());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();

        super.paintComponent(g);
    }
}
