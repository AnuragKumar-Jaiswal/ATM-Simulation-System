package bank.management.system;

import java.sql.*;

public class Conn {
    // Step 1: Register the Driver
    // Step 2: Create Connection
    // Step 3: Create Statement
    // Step 4: Execute Query
    // Step 5: Close Connection

    Connection c;
    Statement s;

    public Conn() {
        try {
            // Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Rishika@29");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
