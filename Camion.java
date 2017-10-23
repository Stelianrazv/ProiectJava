package com.Inmatriculare.Auto;

import java.sql.SQLException;
import java.sql.Statement;

public class Camion {
    int id;
    String Prenume;
    String Nume;
    String Judet;
    String Marca;
    String Model;
    String An;
    String NumarInmatriculare;


    public Camion (int id, String Prenume, String Nume, String Judet, String Marca, String Model, String An, String NumarInmatriculare) {
        this.id = id;
        this.Prenume = Prenume;
        this.Nume = Nume;
        this.Judet = Judet;
        this.Marca = Marca;
        this.Model = Model;
        this.An = An;
        this.NumarInmatriculare = NumarInmatriculare;
    }

    public void saveMasina(Statement myStmt) {
        String insertDb = "insert into masina"
                + "(id,Prenume,Nume,Judet,Marca,Model,An,NumarInmatriculare)"
                + "values ("
                + this.id + ", '" + this.Prenume + "','" +
                this.Nume + "'," + this.Judet + "','" + this.Marca + "','" + this.Model + "','" + this.An + "','" + this.NumarInmatriculare + ")";
        try {
            myStmt.executeUpdate(insertDb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
