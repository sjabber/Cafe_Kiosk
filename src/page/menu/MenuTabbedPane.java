package page.menu;

import page.menu.order.OrderData;
import page.menu.table.MD_table;
import page.menu.table.MenuTable;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Tab 형식으로 제공하는 컴포넌트
 */
public class MenuTabbedPane extends JTabbedPane {

    private final ArrayList<MenuTable> menuTableList = new ArrayList<>();

    MenuTabbedPane(MenuPage menuPage, final OrderData orderData) throws SQLException {
        createMenuTableOfList(menuPage, orderData);
    }

    private void createMenuTableOfList(MenuPage menuPage, OrderData orderData) throws SQLException {
        menuTableList.add(new MD_table(menuPage, orderData, 0, 4));
    }

    private void initTabbedPane() {
        this.setTabPlacement(JTabbedPane.TOP); // 상단위치


        for (MenuTable menuTable : menuTableList) {
            this.add(menuTable.getComponent());
        }
    }

}
