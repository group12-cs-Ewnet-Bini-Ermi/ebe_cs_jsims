/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import domain.College;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ChalewT
 */
public class CollegePersistence implements ICollegePersistence {

    @Override
    public boolean save(College college) throws SQLException {
        int affectedRow;
        String query = "Insert into COLLEGE (COLLEGENAME) Values(?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setString(1, college.getName());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

    @Override
    public List<College> getAll() throws SQLException {
        List<College> colleges = new ArrayList<College>();
        String sql = "Select * from COLLEGE Order By COLLEGENAME ASC";
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rslt = stmt.executeQuery();
        while (rslt.next()) {
            College college = new College();
            college.setId(rslt.getInt("COLLEGEID"));
            college.setName(rslt.getString("COLLEGENAME"));
            colleges.add(college);
        }

        return colleges;
    }

}
