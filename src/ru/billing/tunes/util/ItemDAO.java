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
        String sql = String.format("SELECT * FROM GUEST.ITEM WHERE ITEM_ID = %d", id);

        try
        {
            stmt = m_conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String title = rs.getString("TITLE");
                String artist = rs.getString("ARTIST");
                Date releaseDate = rs.getDate("RELEASEDATE");
                BigDecimal listPrice = rs.getBigDecimal("LISTPRICE");
                BigDecimal price = rs.getBigDecimal("PRICE");
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
        Collection<MusicItem> result = new ArrayList<MusicItem>();
        String wildcarded = "%" + keyword + "%";
        String sql = "SELECT * FROM GUEST.ITEM WHERE TITLE LIKE ?";
        PreparedStatement pstmt = m_conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("ITEM_ID");
            String title = rs.getString("TITLE");
            String artist = rs.getString("ARTIST");
            Date releaseDate = rs.getDate("RELEASEDATE");
            BigDecimal listPrice = rs.getBigDecimal("LISTPRICE");
            BigDecimal price = rs.getBigDecimal("PRICE");
            MusicItem ItemValue = new MusicItem(id, title, artist, releaseDate, listPrice, price);
            result.add(ItemValue);
        }
        return result;
    }

    public void create(MusicItem item)
            throws SQLException
    {
        java.sql.Date releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
        String sql = "INSERT INTO GUEST.ITEM (TITLE, ARTIST, RELEASEDATE, LISTPRICE, PRICE, VERSION)" + " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = m_conn.prepareStatement(sql);
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
