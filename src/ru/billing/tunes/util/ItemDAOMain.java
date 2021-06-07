package ru.billing.tunes.util;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Collection;
import java.util.Date;


public class ItemDAOMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MusicItem musicItem = null;
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", "GUEST", "1234");
        ItemDAO itemDAO = new ItemDAO(conn);

        System.out.println("ID 1:");
        musicItem = itemDAO.searchById(1L);
        if (musicItem != null) {
            System.out.println(musicItem.toString());
        } else {
            System.out.println("not found");
        }
        System.out.println("ID 100:");
        musicItem = itemDAO.searchById(100L);
        if (musicItem != null) {
            System.out.println(musicItem.toString());
        } else {
            System.out.println("not found");
        }

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

        musicItem = new MusicItem(30L, "blabla", "joy division", new Date(), new BigDecimal("10.13"), new BigDecimal("10.745"));
        itemDAO.create(musicItem);
        conn.close();
    }
}
