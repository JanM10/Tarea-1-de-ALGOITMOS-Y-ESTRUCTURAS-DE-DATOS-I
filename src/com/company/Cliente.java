package com.company;

import javax.swing.*;
import java.awt.*;

public class Cliente {

    public static void main(String[] args) {

        miMarco marco1 = new miMarco();

        marco1.setVisible(true);

        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


class miMarco extends JFrame{

    public miMarco(){

        Toolkit mipantalla = Toolkit.getDefaultToolkit();

        Dimension tamanoPantalla = mipantalla.getScreenSize();

        int alturaPantalla = tamanoPantalla.height;

        int anchoPantalla = tamanoPantalla.width;

        setSize(anchoPantalla/2,alturaPantalla/2);

        setLocation(anchoPantalla/4,alturaPantalla/4);

        setTitle("Ventana Cliente");

        setResizable(false);

    }
}