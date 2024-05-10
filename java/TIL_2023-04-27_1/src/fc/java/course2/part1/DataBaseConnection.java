package fc.java.course2.part1;

import fc.java.model2.Connection;
import fc.java.model2.MSSQLDriver;
import fc.java.model2.MySQLDriver;
import fc.java.model2.OracleDriver;

public class DataBaseConnection {
    public static void main(String[] args) {
        // Oracle DB 접속
        Connection conn = new OracleDriver();
        conn.getConnection("jdbc:oricle:think:@localhost:1521:XE","system","manager");

        // MySQL DB 접속
        Connection conn2 = new MySQLDriver();
        conn2.getConnection("jdbc:mysql:think:@localhost:1521:XE","root","12345");

        // MSSQL DB 접속
        Connection conn3 = new MSSQLDriver();
        conn3.getConnection("jdbc:mssql:think:@localhost:DatabaseName=mem","mssql","1234");
    }
}
