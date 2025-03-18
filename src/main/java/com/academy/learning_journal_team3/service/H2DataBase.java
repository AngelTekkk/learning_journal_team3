//package com.academy.learning_journal_team3.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import static javax.management.remote.JMXConnectorFactory.connect;
//
//public class H2DataBase {
//    private final String url = "jdbc:h2:tcp://localhost/~/testdb";
//    private final String user = "sa";
//    private final String password = "";
//    private final Connection conn = DriverManager.getConnection(url, user, password);
//
//    public void setUpDatabase() {
//        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
//            String dropTableSQL = "DROP TABLE IF EXISTS users";
//            stmt.execute(dropTableSQL);
//            System.out.println("Tabelle gelöscht");
//
//
//            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
//                    "first_name VARCHAR(255), " +
//                    "last_name VARCHAR(255), " +
//                    "user_name VARCHAR(255), " +
//                    "email VARCHAR(255))";
//            stmt.execute(createTableSQL);
//            System.out.println("Tabelle erstellt");
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
