package DB;

import org.sqlite.SQLiteConfig;
import java.sql.*;

public class ConnectDB {

    public static Connection connection;
    public boolean isOpened = false;
    public static Statement statement;

    // 드라이버 한번만 로드
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 기본 생성자
    public ConnectDB() {
        // DB 커넥션을 한번만 맺도록 한다.
        if (connection == null) {
            dbConnect();
        }
    }

    // DB 연결 메서드
    private boolean dbConnect() {
        try {
            // SQLite 데이터베이스 파일에 연결
            SQLiteConfig config = new SQLiteConfig();
            // config.setReadOnly(true);
            String dbFile = ".\\cafe_kiosk.db";
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile, config.toProperties());
            statement = connection.createStatement();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        isOpened = true;
        return true;
    }

    public boolean dbClose() {
        if (!this.isOpened) {
            return true;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
