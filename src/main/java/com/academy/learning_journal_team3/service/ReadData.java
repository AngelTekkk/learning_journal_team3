//package com.academy.learning_journal_team3.service;
//import com.academy.learning_journal_team3.service.H2DataBase;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class ReadData {
//    private final H2DataBase database;
//
//    public ReadData(H2DataBase database) {
//        this.database = database;
//    }
//
//    public void readUsers() {
//        try (Connection conn = database.connect();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("first_name") + ", Email: " + rs.getString("email"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
