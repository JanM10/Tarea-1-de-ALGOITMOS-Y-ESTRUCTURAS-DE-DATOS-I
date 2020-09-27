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

            String nick, ip, mensaje;

            PaqueteEnvio paquete_recivido;

            while (true) {
                //servidor.accept(): las conecciones que vienen del exterior
                Socket misocket = servidor.accept();

                ObjectInputStream paquete_con_datos = new ObjectInputStream(misocket.getInputStream());

                paquete_recivido = (PaqueteEnvio) paquete_con_datos.readObject();

                nick = paquete_recivido.getNick();

                ip = paquete_recivido.getIp();

                mensaje = paquete_recivido.getMensaje();

                areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);//Se escribe la infromacion que venia en
                //el paquete dentro del chat

                Socket enviaDestinatario = new Socket(ip, 5001);//Un puente de comunicacion entre datos

                ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                //Reenvia la infromacion dentro de un paquete 

                paqueteReenvio.writeObject(paquete_recivido);

                paqueteReenvio.close();

                enviaDestinatario.close();

                misocket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final JTextArea areatexto;
}
