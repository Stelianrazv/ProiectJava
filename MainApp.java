package com.Inmatriculare.Auto;

import java.sql.*;

/* Clasa principala de unde incepe aplicatia sa se execute*/
public class MainApp {
    static int masinaCount = 1;
    static int camionCount = 1;
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
        try {
            Connection myConn2 = DriverManager.getConnection( dbUrl, user, password );
            Statement myStmt2 = myConn2.createStatement();
            ResultSet myRs2 = myStmt2.executeQuery( "select * from camion" );
            while (myRs2.next()) {
                camionCount++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

