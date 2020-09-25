package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;


public class marcoServidor extends JFrame implements Runnable {

    public marcoServidor() {

        setBounds(1200,300,280,350);

        JPanel milamina = new JPanel();

        milamina.setLayout(new BorderLayout());

        areatexto = new JTextArea();

        milamina.add(areatexto, BorderLayout.CENTER);

        add(milamina);

        setVisible(true);

        Thread mihilo = new Thread(this);

        mihilo.start();
    }

    @Override
    public void run() {
        System.out.println("Estoy a la escucha");

        try {
            ServerSocket servidor = new ServerSocket(5000); //Esta a la esucha y abre el puerto indicado

            while (true) {
                //servidor.accept(): las conecciones que vienen del exterior
                Socket misocket = servidor.accept();
                //DataInputStream: entra la informacion recivida
                DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
                //mensaje_texto: se almacena el mensaje enviado
                String mensaje_texto = flujo_entrada.readUTF();
                //Se hace un salto de linea y luego se ensena lo que que estaba almacenado en mensaje_teexto
                areatexto.append("\n" + mensaje_texto);

                misocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final JTextArea areatexto;
}
