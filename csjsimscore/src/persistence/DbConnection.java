package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author ChalewT
 */
public class DbConnection {
    public static Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@localhost:1521/XE");
        ods.setUser("XXX");
        ods.setPassword("1234");
        Connection conn = ods.getConnection();
        return conn;
    }
}
