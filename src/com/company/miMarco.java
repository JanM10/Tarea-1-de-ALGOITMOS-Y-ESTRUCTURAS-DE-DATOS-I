package com.company;

import javax.swing.*;
import java.awt.*;

class miMarco extends JFrame {

    public miMarco(){

        Toolkit mipantalla = Toolkit.getDefaultToolkit();

        Dimension tamanoPantalla = mipantalla.getScreenSize();

        int alturaPantalla = tamanoPantalla.height;

        int anchoPantalla = tamanoPantalla.width;

        setSize(anchoPantalla/2,alturaPantalla/2);

        setLocation(anchoPantalla/4,alturaPantalla/4);

        setTitle("Ventana Cliente");

        setResizable(false);

        Lamina milanima = new Lamina();

        add(milanima);

    }
}
