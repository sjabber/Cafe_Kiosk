package page;

import DB.Product;
import Main.MainFrame;
import page.menu.order.OrderData;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// 주문받을 화면과 관련된 페이지 설정, 메서드들을 제공하는 MenuPage 의 부모클래스
public class KioskPage extends JPanel {

    public KioskPage() {
    }

    ;

    public KioskPage(PageData pageData) {
        this.pageData = pageData;
        initKioskPage();
        setTouchListener();
    }

    ;

    protected interface OnClickListener {
        public void onClick();
    }

    // 주문 데이터는 static 으로 관리되어야 한다. (어떤 페이지에서도 동일하게 보여져야 하기 때문)
    private static final OrderData orderData = new OrderData();
    private OnClickListener onClickListener = null;

    // 주문정보는 static 으로 관리한다.
    //private static final KioskOrderData kioskOrderData = new KioskOrderData();

    private PageData pageData;
    protected MainFrame mainFrame;

    private void initKioskPage() {
        this.setLayout(null);
        this.setBounds(100, 100, 768, 850); // 설정된 크기
        this.setLocation(0, 0);
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    protected static OrderData getOrderData() {
        return orderData;
    }
    protected void loadCreditCardPage() throws SQLException {
    	PageType pageType = PageType.CREDITCARD_PAGE;
        mainFrame.attachPage(pageType.createKioskPage());
    }
    protected void loadNextPage() throws SQLException {
        PageType pageType = pageData.getNextPageType();
        if (pageType != PageType.EMPTY_PAGE) {
            mainFrame.attachPage(pageType.createKioskPage());
        }
    }
    protected void loadPaymentPage() throws SQLException {
    	PageType pageType = PageType.PAYMENT_PAGE;
        mainFrame.attachPage(pageType.createKioskPage());
    }
    protected void loadCouponPage() throws SQLException {
    	PageType pageType = PageType.COUPON_PAGE;
        mainFrame.attachPage(pageType.createKioskPage());
    }
    protected void loadPayPage() throws SQLException {
    	PageType pageType = PageType.PAY_PAGE;
        mainFrame.attachPage(pageType.createKioskPage());
    }
    
    protected void loadMenuPage() throws SQLException {
        PageType pageType = PageType.MENU_PAGE;
        mainFrame.attachPage(pageType.createKioskPage());
    }

    protected void loadStartPage() throws SQLException {
        PageType pageType = PageType.START_PAGE;
        mainFrame.attachPage(pageType.createKioskPage());
    }

    protected void setOnClickListener(final OnClickListener listener) {
        onClickListener = listener;
    }

    // 터치(마우스 클릭)가 발생하면 이벤트가 발생한다.
    private void setTouchListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (onClickListener != null) {
                    //System.out.println("클릭 되었음.");
                    onClickListener.onClick();
                }
            }
        });
    }

    /*******************************************************************8
     장바구니 구현 연습
     */
    public static ArrayList<Product> CheckList = new ArrayList<>();
    public static Map<Product, Integer> cart = new HashMap<>();
    public static Set<Product> keys;

    public void menuadd(JTextField name, JLabel L1) {
        int quantity = Integer.parseInt(L1.getText());
        quantity = quantity + 1;
        keys = cart.keySet();
        for (Product p : keys) {
            if (p.getProd_name().equals(name.getText())) {
                cart.put(p, quantity);
                L1.setText(String.valueOf(quantity));
            }
        }
    }

    public void menudelete(JTextField name, JLabel L1) {
        int quantity = Integer.parseInt(L1.getText());
        quantity = quantity - 1;
        keys = cart.keySet();
        System.out.println(cart);


        if (quantity == 0) {
//			getIndex(name.getText());
            CheckList.remove(getIndex(name.getText()));
            for (Product p : keys) {
                if (p.getProd_name().equals(name.getText())) {
                    cart.remove(p);
                    break;
                }
            }
        } else {
            for (Product p : keys) {
                if (p.getProd_name().equals(name.getText())) {
                    cart.put(p, quantity);
                    L1.setText(String.valueOf(quantity));
                }
            }
        }
    }

    public int getIndex(String name) {
        int index = -1;

        for (int i = 0; i < CheckList.size(); i++) {
            if (CheckList.get(i).getProd_name().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public int totalamount() {
        keys = cart.keySet();
        total = 0;
        for (Product p : keys) {
            total += p.getProd_price() * cart.get(p);
        }
        return total;

    }
    //매장에서먹을지 나가먹을지 결정하는 변수
    //1 = IN , 2 = OUT
   public static int InorOutNumber;
   public static int total=0;
   public static int totalquantity=0;

}
