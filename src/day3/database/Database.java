package day3.database;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    public static void main(String[] args) {
        Database database = new Database();
        database.demo();
    }

    private void demo() {
        DataSource dataSource = configureDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement("DROP TABLE IF EXISTS emp");
                ps.execute();
                ps.close();
                ps = connection.prepareStatement("CREATE TABLE emp (NAME VARCHAR(100) PRIMARY KEY)");
                ps.execute();
                ps.close();
                ps = connection.prepareStatement("INSERT INTO emp VALUES (?)");
                ps.setString(1, "Alex");
                ps.execute();
                ps.close();
                ps = connection.prepareStatement("SELECT COUNT(*) as TOTAL FROM emp");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("TOTAL is " + rs.getLong("TOTAL"));
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }

    }

    private DataSource configureDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{"localhost"});
        dataSource.setDatabaseName("postgres");
        dataSource.setPortNumbers(new int[]{5432});
        dataSource.setUser("postgres");
        dataSource.setPassword("uqVx7d6Q59wsH5g3XJTs");
        return dataSource;
    }
}
