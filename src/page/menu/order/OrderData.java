package page.menu.order;

import page.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class OrderData {

    private final List<Menu> orderMenuList = new ArrayList<>();

    // 주문한 개수만큼 계산한다.
    private class Calculator {

        // 주문한 개수를 반환한다.
        private int getOrdderQuantity() {
            return orderMenuList.size();
        }

        private int getTotalAmount() {
            int totalAmount = 0;
            for (Menu menu : orderMenuList) {
                totalAmount += menu.getPrice();
            }
            return totalAmount;
        }
    }

    private final Calculator calculator = new Calculator();

    public void clearMenu() {
        orderMenuList.clear();
    }

}
