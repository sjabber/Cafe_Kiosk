import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            String dbFile = "C:\\JAVA_WORK\\Cafe_Kiosk\\cafe_kiosk.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            Statement stat = conn.createStatement();
            ResultSet RS = stat.executeQuery("SELECT Iname, price FROM I_coffee WHERE Pnum = 1");
            while(RS.next()) {
                String id = RS.getString("Iname");
                String price = RS.getString("price");
                System.out.println(id + " " + price);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
