package page;

import page.menu.Menu;
import page.menu.MenuPage;
import page.menu.order.OrderData;

import javax.swing.*;

public class MenuButton extends JButton {

    private final String PRICE_FONT_COLOR = "red";
    private final String IMG_PATH;
    private final Menu MENU;

    private MenuPage menuPage;
    private final OrderData orderData;

    public MenuButton(String imgPath, Menu menu, MenuPage menuPage, OrderData orderData) {
        this.IMG_PATH = imgPath;
        this.MENU = menu;
        this.menuPage = menuPage;
        this.orderData = orderData;
    }
}
