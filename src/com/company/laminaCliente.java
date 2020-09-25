package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

class laminaCliente extends JPanel {

    public laminaCliente(){

        JLabel texto = new JLabel("CLIENTE");

        add(texto);

        campo1 = new JTextField(20);

        add(campo1);

        miboton = new JButton("Enviar");

        EnviarTexto mievento = new EnviarTexto();

        miboton.addActionListener(mievento);

        add(miboton);
    }

    private class EnviarTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //System.out.println(campo1.getText());

            try {
                Socket misocket = new Socket("127.0.0.1", 5000);
            } catch (IOException ioException) {
                //ioException.printStackTrace();
                System.out.println(ioException.getMessage());
            }
        }
    }

    private JTextField campo1;

    private JButton miboton;
}
