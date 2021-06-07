package ru.billing.tunes.util;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;


public class ItemDAOMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MusicItem musicItem = null;
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDbTest;create=true;", "Guest", "1234");
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getUserName());
        ItemDAO itemDAO = new ItemDAO(conn);
        musicItem = itemDAO.searchById(1L);
        if (musicItem != null) {
            System.out.println(musicItem.toString());
        } else {
            System.out.println("not found");
        }
        System.out.println("ID 40:");
        musicItem = itemDAO.searchById(100L);
        if (musicItem != null) {
            System.out.println(musicItem.toString());
        } else {
            System.out.println("not found");
        }
/*
        System.out.println("result of searching \"of\":");
        Collection<MusicItem> result2 = itemDAO.searchByKeyword("of");
        if (result2 != null) {
            for (MusicItem item: result2){
                System.out.println(item.toString());
            }
        } else {
            System.out.println("not found");
        }

        System.out.println("result of searching \"Gay\":");
        result2 = itemDAO.searchByKeyword("Gay");
        if (result2 != null) {
            for (MusicItem item: result2){
                System.out.println(item.toString());
            }
        }
        */
        musicItem = new MusicItem(22L, "Greatest", "Guns N Roses", new Date(), new BigDecimal("13.6"), new BigDecimal("19.54"));
        itemDAO.create(musicItem);
        conn.close();
    }
}
