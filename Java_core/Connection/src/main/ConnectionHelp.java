package main;

import java.sql.*;

public class ConnectionHelp {
    static String url = "jdbc:oracle:thin:@27.118.22.14:1521:orcl" ;
    static  String username = "SCOTT" ;
    static String password = "SCOTT" ;

    public static java.sql.Connection getConnection() {
        java.sql.Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
