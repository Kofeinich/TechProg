package ru.billing.tunes.util;
import ru.billing.stocklist.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        conn = DriverManager.getConnection("jdbc:derby:MyDbTest;create=true");
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getUserName());
        conn.close();

    }
}
