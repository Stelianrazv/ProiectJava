package com.Inmatriculare.Auto;

/* Fereastra Register */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import static java.awt.Color.BLACK;
import static java.awt.Color.black;
import static java.awt.Color.getColor;

public class RegisterCar extends JFrame {
    JButton exitButton,registerButton, backButton, listcarButton;
    JLabel PrenumeLabel, NumeLabel, JudetLabel, MarcaLabel, ModelLabel, AnLabel, NumarInmatriculareLabel;
    JTextField PrenumeField, NumeField, JudetField, MarcaField, ModelField, AnField, NumarInmatriculareField;
    JList anJList;
    DefaultListModel aniList = new DefaultListModel();
    Statement myStmt;

    public RegisterCar(Statement myStmt) {
        this.myStmt = myStmt;
        // Seteaza fereastra Register: titlu, mod de inchidere, dimensiuni si pozitia
        this.setTitle("Inregistrare Masini");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,500);
        this.setLocationRelativeTo(null);

        // Creaza main panel panel principal care contine toate celelalte elemente
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.CYAN);

        // Creaza regPanel pentru elementele principale din fereastra
        JPanel regPanel = new JPanel();
        regPanel.setLayout(new BoxLayout(regPanel, 1));

        // Creaza textul "First name"
        PrenumeLabel = new JLabel("Prenume");
        PrenumeLabel.setFont(new Font("Arial",Font.BOLD,16));
        regPanel.add(PrenumeLabel);
        // Creaza campul pentru a introduce prenumele
        PrenumeField = new JTextField(5);
        PrenumeField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(PrenumeField);

        // Creaza textul "Last Name"
        NumeLabel = new JLabel("Nume");
        NumeLabel.setFont(new Font("Arial",Font.BOLD,16));
        regPanel.add(NumeLabel);
        // Creaza campul pentru a introduce numele
        NumeField = new JTextField(5);
        NumeField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(NumeField);

        // Creaza campul PrefixJudet
        JudetLabel = new JLabel("Judet");
        JudetLabel.setFont(new Font("Arial",Font.BOLD,16));
        regPanel.add(JudetLabel);
        // Creaza campul pentru a introduce numele
        JudetField = new JTextField(5);
        JudetField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(JudetField);

        // Creaza campul DenumireaMasinii
        MarcaLabel = new JLabel("Denumire Masina");
        MarcaLabel.setFont(new Font("Arial",Font.BOLD,16));
        regPanel.add(MarcaLabel);
        // Creaza campul pentru a introduce DenumireaMasinii
        MarcaField = new JTextField(5);
        MarcaField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(MarcaField);

        // Creaz campul ModelMasina
        ModelLabel = new JLabel("Model Masina");
        ModelLabel.setFont(new Font("Arial",Font.BOLD,16));
        regPanel.add(ModelLabel);
        // Creaza campul pentru a introduce ModelMasina
        ModelField = new JTextField(5);
        ModelField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(ModelField);

        // Creaza campul AnMasina
        AnLabel = new JLabel("An Masina");
        AnLabel.setFont(new Font("Arial",Font.BOLD,16));
        regPanel.add(AnLabel);
        // Creaza campul pentru a introduce AnMasina
        AnField = new JTextField(5);
        AnField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(AnField);

        // Creaza campul NumarInmatriculare
        NumarInmatriculareLabel = new JLabel("Numar Inmatriculare");
        NumarInmatriculareLabel.setFont(new Font("Arial",Font.BOLD,16));
        regPanel.add(NumarInmatriculareLabel);
        // Creaza campul pentru a introduce AnMasina
        NumarInmatriculareField = new JTextField(5);
        NumarInmatriculareField.setFont(new Font("Arial", Font.BOLD, 16));
        regPanel.add(NumarInmatriculareField);


        // Adauga regPanel la mainPanel
        mainPanel.add(regPanel, BorderLayout.CENTER);

        // Creaza buttonPanel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));

        // Butonul "EXIT"
        exitButton = new JButton("Iesire");
        exitButton.setPreferredSize(new Dimension(150,40 ));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setBackground(Color.LIGHT_GRAY);

        // Butonul "REGISTER"
        registerButton = new JButton("Inregistrare");
        registerButton.setPreferredSize(new Dimension(150,40));
        registerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        registerButton.setBackground(Color.LIGHT_GRAY);

        // Butonul "REGISTER"
        listcarButton = new JButton("Lista Masini");
        listcarButton.setPreferredSize(new Dimension(150,40));
        listcarButton.setFont(new Font("Arial", Font.PLAIN, 18));
        listcarButton.setBackground(Color.LIGHT_GRAY);

        // Butonul "Back"
        backButton = new JButton("Inapoi");
        backButton.setPreferredSize(new Dimension(150,40));
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.setBackground(Color.LIGHT_GRAY);

        // Face ca butoanele sa poata fi receptive la events
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        registerButton.addActionListener(listenForButton);
        backButton.addActionListener(listenForButton);
        listcarButton.addActionListener(listenForButton);

        // Adauga butoanele la buttonPanel
        buttonPanel.add(registerButton);
        buttonPanel.add(listcarButton);
        buttonPanel.add(backButton);
        buttonPanel.add(exitButton);

        // adauga buttonPanel la mainPanel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        // Adauga mainPanel la Frame
        this.add(mainPanel);
        // Face fereastra vizibila
        this.setVisible(true);

    }
    // Pentru events
    private class ListenForButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Sursa eventului este butonul "EXIT"
            if (e.getSource() == exitButton){
                // Inchide fereastra Register
                System.exit(0);
            } else if (e.getSource() == registerButton) {

            }// Sursa eventului este butonul "Inregistrare Camion"
            else if (e.getSource() == backButton) {
                // Deschide fereastra List
                new WelcomeGui(myStmt);
                // Inchide fereastra Welcome
                dispose();

            }// Sursa eventului este butonul "LIST"
            else if (e.getSource() == listcarButton) {
                // Deschide fereastra List
                new ListCar(myStmt);
                // Inchide fereastra Welcome
                dispose();

                //Aici vom adauga acces la baza de date
                Masina masina = new Masina(MainApp.masinaCount, PrenumeField.getText(),NumeField.getText(),JudetField.getText(), MarcaField.getText(), ModelField.getText(), AnField.getText(),NumarInmatriculareField.getText());
                masina.saveMasina(myStmt);
                MainApp.masinaCount++;
                new WelcomeGui(myStmt);
                dispose();
            }
        }
    }
}
