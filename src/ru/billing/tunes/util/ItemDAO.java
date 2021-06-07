package ru.billing.tunes.util;
import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ItemDAO
{
    private Connection m_conn = null;
    public ItemDAO(Connection conn)
            throws SQLException
    {
        m_conn = conn;
    }

    public MusicItem searchById(Long id) throws SQLException {
        MusicItem result = null;
        Statement stmt = null;
        var sql = String.format("SELECT * FROM APP.ITEM WHERE ITEM_ID = %d", id);
        try
        {
            stmt = m_conn.createStatement();
            var reSet = stmt.executeQuery(sql);
            if (reSet.next()) {
                var title = reSet.getString("TITLE");
                var artist = reSet.getString("ARTIST");
                var releaseDate = reSet.getDate("RELEASEDATE");
                var listPrice = reSet.getBigDecimal("LISTPRICE");
                var price = reSet.getBigDecimal("PRICE");
                result = new MusicItem(id, title, artist, releaseDate, listPrice, price);
            }
        }
        finally {
            stmt.close();
        }
        return result;
    }

    public Collection<MusicItem> searchByKeyword(String keyword)
            throws SQLException
    {
        var result = new ArrayList<MusicItem>();
        var wildcarded = "%" + " " + keyword + " " + "%";
        var sql = "SELECT * FROM APP.ITEM WHERE TITLE LIKE ?";
        var pstmt = m_conn.prepareStatement(sql);
        pstmt.setString(1, wildcarded);
        var reSet = pstmt.executeQuery();
        while (reSet.next()) {
            long id = reSet.getLong("ITEM_ID");
            var title = reSet.getString("TITLE");
            var artist = reSet.getString("ARTIST");
            var releaseDate = reSet.getDate("RELEASEDATE");
            var listPrice = reSet.getBigDecimal("LISTPRICE");
            var price = reSet.getBigDecimal("PRICE");
            var ItemValue = new MusicItem(id, title, artist, releaseDate, listPrice, price);
            result.add(ItemValue);
        }
        return result;
    }

    public void create(MusicItem item)
            throws SQLException
    {
        var releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
        String sql = "INSERT INTO APP.ITEM (TITLE, ARTIST, RELEASEDATE, LISTPRICE, PRICE, VERSION)" + "VALUES (?, ?, ?, ?, ?, ?)";
        var stmt = m_conn.prepareStatement(sql);
        stmt.setString(1, item.getTitle());
        stmt.setString(2, item.getArtist());
        stmt.setDate(3, releaseDate);
        stmt.setBigDecimal(4, item.getListPrice());
        stmt.setBigDecimal(5, item.getPrice());
        stmt.setInt(6, 1);
        System.out.println(stmt.executeUpdate());
        m_conn.commit();
    }

    public void close() {}
}
