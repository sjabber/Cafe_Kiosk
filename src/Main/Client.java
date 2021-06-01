package Main;


import DB.ConnectDB;
import java.sql.SQLException;

public class Client {

	public static ConnectDB db;
    public static void main(String[] args) throws SQLException {


/*		 sqlite 데이터 베이스 사용 예제 (삭제 금지)
        db = new ConnectDB();
        String query =
                "SELECT Pname, price FROM I_coffee WHERE Pnum = ?;";
        PreparedStatement prep = db.connection.prepareStatement(query);
        prep.setInt(1, 1);
        ResultSet rs = prep.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("Pname") + ", " + rs.getInt("Price"));
        }*/

		//db = new ConnectDB();
        new MainFrame().setVisible(true);
    }
}
