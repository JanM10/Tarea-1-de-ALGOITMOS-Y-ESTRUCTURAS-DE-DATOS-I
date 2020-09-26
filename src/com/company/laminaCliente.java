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

                PaqueteEnvio datos = new PaqueteEnvio();

                datos.setNick(nick.getText()); //Se almacena el nombre de usuario

                datos.setIp(ip.getText()); //Se almacena la ip

                datos.setMensaje(campo1.getText()); //Se almacena el mensaje o texto enviado

                ObjectOutputStream paquete_con_datos = new ObjectOutputStream(misocket.getOutputStream()); //Flujo de
                // salida para enviar todos los datos
                paquete_con_datos.writeObject(datos);

                misocket.close();

            } catch (IOException ioException) {

                System.out.println(ioException.getMessage());
            }
        }
    }

    private JTextField campo1, nick, ip;

    private JTextArea campochat;

    private JButton miboton;
}
