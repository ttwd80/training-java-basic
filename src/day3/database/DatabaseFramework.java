package day3.database;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseFramework {
    public static void main(String[] args) {
        DatabaseFramework databaseFramework = new DatabaseFramework();
        databaseFramework.demo();
    }

    private void demo() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DatabaseConfiguration.class);
        context.refresh();
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        TransactionTemplate transactionTemplate = context.getBean(TransactionTemplate.class);
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                jdbcTemplate.execute("DROP TABLE IF EXISTS emp");
                jdbcTemplate.execute("CREATE TABLE emp (NAME VARCHAR(100) PRIMARY KEY)");
                System.out.println("count is " + jdbcTemplate.queryForObject("SELECT COUNT(*) FROM emp", Long.class));
                jdbcTemplate.update("INSERT INTO emp VALUES (?)", "Alex");
                jdbcTemplate.update("INSERT INTO emp VALUES (?)", "Charlie");
                jdbcTemplate.update("INSERT INTO emp VALUES (?)", "Dennis");
                System.out.println("count is " + jdbcTemplate.queryForObject("SELECT COUNT(*) FROM emp", Long.class));
                List<String> list = jdbcTemplate.query("SELECT * from emp", (resultSet, rowNum) -> {
                    return resultSet.getString("NAME");
                });
                System.out.println("The items are " + list);
                return null;
            }
        });
    }
}
