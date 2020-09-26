package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class laminaCliente extends JPanel {

    public laminaCliente(){

        campochat = new JTextArea(20,95); //Aqui van a apoarecer todos los mensajes

        add(campochat);

        nick = new JTextField(5); //Una entrada para poner nombre de usuario

        add(nick);

        JLabel texto = new JLabel("CLIENTE");

        add(texto);

        ip = new JTextField(8); //Una entrada para especificar el ip en este caso 127.0.0.1(local)

        add(ip);

        campo1 = new JTextField(20);

        add(campo1);

        miboton = new JButton("Enviar"); //Un boton para enviar los mensajes

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

    private JTextField campo1, nick, ip;

    private JTextArea campochat;

    private JButton miboton;
}
