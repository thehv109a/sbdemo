package thehv.shares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleJdbcConnect {

    public void test_executeQuery() throws Exception {
        String sql = "select * From V$session";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.160.89.176:1521:xe",
                "sys as SYSDBA", "TheHV@123")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    System.out.println(resultSet);
                }
            }
        }
    }

    public void test_executeUpdate() throws Exception {
        String sql = "CREATE TABLE customers ( customer_id number(10) NOT NULL, customer_name varchar2(50) NOT NULL, city varchar2(50) );";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@103.160.89.176:1521:xe",
                "sys as SYSDBA", "TheHV@123")) {
            try (Statement statement = connection.createStatement()) {
                System.out.println("DONE: " + statement.executeUpdate(sql));
            }
        }
    }
}