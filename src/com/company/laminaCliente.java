package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class laminaCliente extends JPanel implements Runnable {
    /***
     * En la lamina se agregan los JTextArea, JButton y Jlabel para que el usario puede intecatuar con ellos
     */
    public laminaCliente(){

        campochat = new JTextArea(20,95); //Aqui van a apoarecer todos los mensajes

        add(campochat);

        String nick_usuario = JOptionPane.showInputDialog("Nombre de usuario: ");

        JLabel n_nick = new JLabel("Nombre: ");

        if (n_nick.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe escribir un nombre");
        } else

        add(n_nick);

        nick = new JLabel(); //Una entrada para poner nombre de usuario

        nick.setText(nick_usuario);

        add(nick);

        JLabel inserte_ip = new JLabel("Ip: ");

        add(inserte_ip);

        ip = new JTextField(8); //Una entrada para especificar el ip en este caso 127.0.0.1(local)

        add(ip);

        JLabel mensaje_de_texto = new JLabel("Mensaje: ");

        add(mensaje_de_texto);

        campo1 = new JTextField(20);

        add(campo1);

        miboton = new JButton("Enviar"); //Un boton para enviar los mensajes

        EnviarTexto mievento = new EnviarTexto();

        miboton.addActionListener(mievento);

        add(miboton);

        Thread mihilo = new Thread(this);

        mihilo.start();
    }

    /***
     * Aqui el socket recibe un paquete con informacion y se escribe en el JTextArea llamado campochat
     */
    @Override
    public void run() {

        try{

            ServerSocket servidor_cliente = new ServerSocket(5001);

            Socket cliente;

            PaqueteEnvio paqueteRecibido;

            boolean flag = true;

            while (flag){

                cliente = servidor_cliente.accept();

                ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());

                paqueteRecibido = (PaqueteEnvio) flujoentrada.readObject();

                campochat.append("\n " + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private class EnviarTexto implements ActionListener {
        /***
         * En esta funcion se crea un scoket y se empaqueta la infromacion que se va a enviar
         * @param e aqui se recive un objeto de tipo ActionListener
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (campo1.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe escribir algo");
            } else{
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
    }

    private JTextField campo1, ip;

    private JLabel nick;

    private JTextArea campochat;

    private JButton miboton;
}
