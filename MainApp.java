package com.Inmatriculare.Auto;

import java.sql.*;

/* Clasa principala de unde incepe aplicatia sa se execute*/
public class MainApp {
    static int masinaCount = 1;
    public static void main(String[] args) {
        // Deschide prima fereastra - Welcome
        String dbUrl = "jdbc:postgresql:cars";
        String user = "postgres";
        String password = "cursjava";

        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from masina");
            while (myRs.next()) {
                masinaCount++;
            }
            new WelcomeGui(myStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

