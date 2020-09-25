package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
            //Lo que esta en el campo1 se escribe en el flujo_salida y esto se dirije a misocket
            try {
                Socket misocket = new Socket("127.0.0.1", 5000);
                //En el DataOutputStream sale la informacion escrita por el cliente
                DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());

                flujo_salida.writeUTF(campo1.getText());

                flujo_salida.close();

            } catch (IOException ioException) {

                System.out.println(ioException.getMessage());
            }
        }
    }

    private JTextField campo1;

    private JButton miboton;
}
