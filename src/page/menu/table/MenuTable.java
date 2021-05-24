//package page.menu.table;
//
//import page.MenuButton;
//import page.menu.Menu;
//import page.menu.MenuPage;
//import page.menu.order.OrderData;
//
//import javax.swing.*;
//import java.awt.*;
//
//// 추상 클래스
//public abstract class MenuTable {
//
//    private final JScrollPane scroll = new JScrollPane();
//    private final JPanel menuPanel = new JPanel();
//    private final MenuPage menuPage;
//
//    MenuTable(MenuPage menuPage, final int rows, final int cols) {
//        this.menuPage = menuPage;
//
//        initPanel(rows, cols);
//    }
//
//    // 메뉴 테이블 개수만큼 칸을 생성한다.
//    private void initPanel(int rows, int cols) {
//        rows = (rows > 0) ? rows : 0;
//        cols = (cols > 0) ? cols : 0;
//        menuPanel.setLayout(new GridLayout(rows, cols));
//        menuPanel.setBackground(Color.WHITE);
//    }
//
//    // 메뉴 버튼에 메뉴를 추가할 떄 사용한다.
//    Menu createMenu(final String name, final int price) {
//        return new Menu(name, price);
//    }
//
//    // 메뉴버튼을 만들 때 사용한다.
//    // Menu => page.Menu
//    MenuButton createMenuButton(final String imgPath, final Menu menu, final OrderData kioskOrderData) {
//        return new MenuButton(imgPath, menu, menuPage, kioskOrderData);
//    }
//
//    // 메뉴 추가
//    // ...는 MenuButtons 클래스의 객체인 매개변수가 여러개 들어올 수 있음을 의미한다.
//    void addMenu(final MenuButton... buttons) {
//        for (MenuButton button : buttons) {
//            menuPanel.add(button);
//        }
//    }
//
//    public Component getComponent() {
//        return scroll;
//    }
//}
