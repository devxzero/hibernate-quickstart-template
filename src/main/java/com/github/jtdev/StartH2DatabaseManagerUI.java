package com.github.jtdev;

import java.sql.SQLException;

public class StartH2DatabaseManagerUI {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Console.main("-url", "jdbc:h2:file:./h2.db");
    }
}
