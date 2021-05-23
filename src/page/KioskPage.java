package page;

import Main.MainFrame;
import page.menu.order.OrderData;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

// 주문받을 화면과 관련된 페이지 설정, 메서드들을 제공하는 MenuPage 의 부모클래스
public class KioskPage extends JPanel {

    public KioskPage() {};

    public KioskPage(PageData pageData) {
        this.pageData = pageData;
        initKioskPage();
        setTouchListener();
    };

    protected interface OnClickListener {
        public void onClick();
    }

    // 주문 데이터는 static 으로 관리되어야 한다. (어떤 페이지에서도 동일하게 보여져야 하기 때문)
    private static final OrderData orderData = new OrderData();
    private OnClickListener onClickListener = null;

    // 주문정보는 static 으로 관리한다.
    //private static final KioskOrderData kioskOrderData = new KioskOrderData();

    private PageData pageData;
    private MainFrame mainFrame;

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

    protected void loadNextPage() throws SQLException {
        PageType pageType = pageData.getNextPageType();
        if (pageType != PageType.EMPTY_PAGE) {
            mainFrame.attachPage(pageType.createKioskPage());
        }
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
}
