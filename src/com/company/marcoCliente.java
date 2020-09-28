package com.company;

import javax.swing.*;
import java.awt.*;

class marcoCliente extends JFrame {
    /***
     * En esta funcion se definen los parametros de la ventana del cliente y se crea una lamina
     */
    public marcoCliente(){

        Toolkit mipantalla = Toolkit.getDefaultToolkit();

        Dimension tamanoPantalla = mipantalla.getScreenSize();

        int alturaPantalla = tamanoPantalla.height;

        int anchoPantalla = tamanoPantalla.width;

        setSize(1000,600);

        setLocation(anchoPantalla/8,alturaPantalla/8);

        setTitle("Ventana Cliente");

        setResizable(false);

        laminaCliente milanima = new laminaCliente();

        add(milanima);

        milanima.setBackground(Color.GRAY);

    }
}
