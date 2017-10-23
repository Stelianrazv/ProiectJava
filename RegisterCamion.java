package com.Inmatriculare.Auto;

/* Fereastra Register */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class RegisterCamion extends JFrame {
    JButton exitButton, registerButton, menuButton, listCamionButton;
    JLabel PrenumeLabel, NumeLabel, JudetLabel, MarcaLabel, ModelLabel, AnLabel, NumarInmatriculareLabel;
    JTextField PrenumeField, NumeField, JudetField, MarcaField, ModelField, AnField, NumarInmatriculareField;
    JList anJList;
    DefaultListModel aniList = new DefaultListModel();
    Statement myStmt;

    public RegisterCamion(Statement myStmt) {
        this.myStmt = myStmt;

        // Seteaza fereastra Register: titlu, mod de inchidere, dimensiuni si pozitia
        this.setTitle( "Inregistrare camioane" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( 900, 500 );
        this.setResizable(false);
        this.setLocationRelativeTo( null );

        // Creaza main panel panel principal care contine toate celelalte elemente
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout( new BorderLayout() );
        mainPanel.setBackground( Color.CYAN );

        // Creaza regPanel pentru elementele principale din fereastra
        JPanel regPanel = new JPanel();
        regPanel.setLayout( new BoxLayout( regPanel, 1 ) );

        // Creaza textul "First name"
        PrenumeLabel = new JLabel( "Prenume" );
        PrenumeLabel.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( PrenumeLabel );
        // Creaza campul pentru a introduce prenumele
        PrenumeField = new JTextField( 5 );
        PrenumeField.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( PrenumeField );

        // Creaza textul "Last Name"
        NumeLabel = new JLabel( "Nume" );
        NumeLabel.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( NumeLabel );
        // Creaza campul pentru a introduce numele
        NumeField = new JTextField( 5 );
        NumeField.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( NumeField );

        // Creaza campul PrefixJudet
        JudetLabel = new JLabel( "Judet" );
        JudetLabel.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( JudetLabel );
        // Creaza campul pentru a introduce numele
        JudetField = new JTextField( 5 );
        JudetField.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( JudetField );

        // Creaza campul DenumireaMasinii
        MarcaLabel = new JLabel( "Denumire Masina" );
        MarcaLabel.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( MarcaLabel );
        // Creaza campul pentru a introduce DenumireaMasinii
        MarcaField = new JTextField( 5 );
        MarcaField.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( MarcaField );

        // Creaz campul ModelMasina
        ModelLabel = new JLabel( "Model Masina" );
        ModelLabel.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( ModelLabel );
        // Creaza campul pentru a introduce ModelMasina
        ModelField = new JTextField( 5 );
        ModelField.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( ModelField );

        // Creaza campul AnMasina
        AnLabel = new JLabel( "An Masina" );
        AnLabel.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( AnLabel );
        // Creaza campul pentru a introduce AnMasina
        AnField = new JTextField( 5 );
        AnField.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( AnField );

        // Creaza campul NumarInmatriculare
        NumarInmatriculareLabel = new JLabel( "Numar Inmatriculare" );
        NumarInmatriculareLabel.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( NumarInmatriculareLabel );

        // Creaza campul pentru a introduce AnMasina
        NumarInmatriculareField = new JTextField( 5 );
        NumarInmatriculareField.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        regPanel.add( NumarInmatriculareField );


        // Adauga regPanel la mainPanel
        mainPanel.add( regPanel, BorderLayout.CENTER );

        // Creaza buttonPanel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground( Color.BLACK );
        buttonPanel.setLayout( new FlowLayout( FlowLayout.CENTER, 10, 20 ) );

        // Butonul "Inregistrare"
        registerButton = new JButton( "INREGISTRARE" );
        registerButton.setPreferredSize( new Dimension( 180, 40 ));
        registerButton.setFont( new Font( "Arial", Font.PLAIN, 18));
        registerButton.setBackground(Color.LIGHT_GRAY);

        // Butonul "ListCar"
        listCamionButton = new JButton( "LISTA CAMIOANE" );
        listCamionButton.setPreferredSize( new Dimension( 200, 40 ));
        listCamionButton.setFont( new Font( "Arial", Font.PLAIN, 18));
        listCamionButton.setBackground(Color.LIGHT_GRAY);

        // Butonul "Back"
        menuButton = new JButton( "MENIU" );
        menuButton.setPreferredSize( new Dimension( 150, 40 ) );
        menuButton.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
        menuButton.setBackground( Color.LIGHT_GRAY );

        // Butonul "EXIT"
        exitButton = new JButton( "IESIRE" );
        exitButton.setPreferredSize( new Dimension( 150, 40 ) );
        exitButton.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
        exitButton.setBackground( Color.LIGHT_GRAY );

        // Face ca butoanele sa poata fi receptive la events
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        registerButton.addActionListener(listenForButton);
        menuButton.addActionListener(listenForButton);
        listCamionButton.addActionListener(listenForButton);

        // Adauga butoanele la buttonPanel
        buttonPanel.add(registerButton);
        buttonPanel.add(listCamionButton);
        buttonPanel.add(menuButton);
        buttonPanel.add(exitButton );

        // adauga buttonPanel la mainPanel
        mainPanel.add( buttonPanel, BorderLayout.SOUTH );
        // Adauga mainPanel la Frame
        this.add( mainPanel );
        // Face fereastra vizibila
        this.setVisible( true );

    }

    // Pentru events
    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Sursa eventului este butonul "Iesire"
            if (e.getSource() == exitButton) {
                // Inchide fereastra Register
                System.exit( 0 );
            } else if (e.getSource() == registerButton) {

                //Aici vom adauga acces la baza de date
                Masina masina = new Masina( MainApp.masinaCount, PrenumeField.getText(), NumeField.getText(), JudetField.getText(), MarcaField.getText(), ModelField.getText(), AnField.getText(), NumarInmatriculareField.getText() );
                masina.saveMasina(myStmt);
                MainApp.masinaCount++;
                new WelcomeGui(myStmt);
                dispose();

            }// Sursa eventului este butonul "Camioane"
            else if (e.getSource() == listCamionButton) {
                // Deschide fereastra Register
                new ListCamion(myStmt);
                // Inchide fereastra Welcome
                dispose();

            }// Sursa eventului este butonul "Masini"
            else if (e.getSource() == menuButton) {
                // Deschide fereastra Register
                new WelcomeGui(myStmt);
                // Inchide fereastra Welcome
                dispose();
            }
        }
    }
}




