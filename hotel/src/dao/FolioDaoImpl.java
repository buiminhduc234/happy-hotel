package dao;

import model.Folio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FolioDaoImpl implements FolioDao {
    @Override
    public void insert(Folio folio) {
        if (folio == null)
            return;
        String sql = "INSERT INTO folio(id, name) VALUES(?,?)";
        try (Connection conn = DBUtility.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, folio.getId());
            pstmt.setString(2, folio.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Folio findById(int id) {
        return null;
    }
}
