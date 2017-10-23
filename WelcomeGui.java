package com.Inmatriculare.Auto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

public class WelcomeGui extends JFrame {
    JButton exitButton, registerCar, registerCamion;
    BufferedImage img;
    Statement myStmt2;

    public WelcomeGui(Statement myStmt2) {
        this.myStmt2 = myStmt2;
        // Titlul ferestrei
        this.setTitle( "Inregistrare Auto!" );
        // Modalitatea de inchidere a ferestrei
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // Marimea ferestrei
        this.setSize( 900, 500 );
        // Pozitioneaza fereastra in centrul ecranului
        this.setLocationRelativeTo( null );
        // Creaza mainPanel - panel principal care include toate elementele
        JLabel mainLabel = new JLabel();
        mainLabel.setSize( 900, 500 );
        try {
            img = ImageIO.read( new File( "C:\\Users\\Marcus\\Desktop\\truck.jpg" ) );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Modifica dimensiunile la imaginea de background
        Image dimg = img.getScaledInstance( mainLabel.getWidth(), mainLabel.getHeight(),
                Image.SCALE_SMOOTH );
        ImageIcon imageIcon = new ImageIcon( dimg );

        // Adauga imaginea de fond la mainLabel
        mainLabel.setIcon( imageIcon );
        mainLabel.setLayout( new BorderLayout() );
        this.setContentPane( mainLabel );

        // Creaza buttonPanel care va contine butoanele
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground( Color.BLACK );
        // Precizeaza layout pentru buttonPanel
        buttonPanel.setLayout( new FlowLayout( FlowLayout.CENTER, 10, 20 ) );

        // Butonul exit
        exitButton = new JButton( "Iesire" );
        exitButton.setPreferredSize( new Dimension( 195, 40 ) );
        exitButton.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
        exitButton.setBackground( Color.LIGHT_GRAY );

        // Butonul register
        registerCar = new JButton( "Inregistrare Masina" );
        registerCar.setPreferredSize( new Dimension( 195, 40 ) );
        registerCar.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
        registerCar.setBackground( Color.LIGHT_GRAY );

        // Butonul list
        registerCamion = new JButton( "Inregistrare Camion" );
        registerCamion.setPreferredSize( new Dimension( 195, 40 ) );
        registerCamion.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
        registerCamion.setBackground( Color.LIGHT_GRAY );

        // Face ca butoanele sa poata fi receptive la events
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        registerCar.addActionListener(listenForButton);
        registerCamion.addActionListener(listenForButton);

        // Adauga butoanele la buttonPanel
        buttonPanel.add(registerCar);
        buttonPanel.add(registerCamion);
        buttonPanel.add(exitButton);

        // Adauga buttonPanel la mainPanel
        mainLabel.add( buttonPanel, BorderLayout.SOUTH );

        // Face fereastra vizibila
        this.pack();
        this.setVisible( true );
    }

    // Pentru events
    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Sursa eventului este butonul "EXIT"
            if (e.getSource() == exitButton) {
                // Inchide fereastra Welcome
                System.exit( 0 );

            }// Sursa eventului este butonul "Inregistrare Masina"
            else if (e.getSource() == registerCar) {
                // Deschide fereastra Register
                new RegisterCar(myStmt2);
                // Inchide fereastra Welcome
                dispose();

            }// Sursa eventului este butonul "Inregistrare Camion"
            else if (e.getSource() == registerCamion) {
                // Deschide fereastra List
                new RegisterCamion(myStmt2);
                // Inchide fereastra Welcome
                dispose();
            }
        }
    }
}
