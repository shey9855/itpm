package DataBaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {

    private Connector() {
    }
    private static final Connector obj = new Connector();

    public static Connector getInstance() {
        return obj;
    }

    private static Connection con;
    ResultSet rs;

    public Connection getConnection() throws Exception {
        if (con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://151.106.114.2:3306/u271442347_itpm_db_ST", "u271442347_5sEWH", "ItJyON9?6");
        }
        return con;
    }

    public int aud(String sql) throws Exception {
        getConnection();
        Statement st = con.createStatement();
        int i = st.executeUpdate(sql);
        return i;
    }

    public ResultSet srh(String sql) throws Exception {
        getConnection();
        Statement st = con.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
}
