//package page.menu.table;
//
//import DB.ConnectDB;
//import Main.Client;
//import page.menu.MenuPage;
//import page.menu.order.OrderData;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class MD_table extends MenuTable {
//
//    // DB 연결 객체
//    ConnectDB db = Client.db;
//
//    String query = "SELECT Pnum, price, Pname FROM MD";
//    ResultSet rs = db.statement.executeQuery(query);
//
//    public MD_table(MenuPage menuPage, final OrderData orderData, int rows, int cols) throws SQLException {
//        super(menuPage, rows, cols);
//        resisterMD(orderData);
//    }
//
//    private void resisterMD(final OrderData orderData) throws SQLException {
//        while(rs.next()) {
//            int num = rs.getInt("Pnum");
//            int price = rs.getInt("price");
//            String name = rs.getString("Pname");
//
//            this.addMenu(createMenuButton("images/" + num + ".jpg", createMenu(name, price), orderData));
//        }
//    }
//}
