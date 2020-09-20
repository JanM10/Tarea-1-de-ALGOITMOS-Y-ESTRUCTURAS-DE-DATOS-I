package com.company;

import javax.swing.*;

public class Cliente {

    public static void main(String[] args) {

        miMarco marco1 = new miMarco();
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


class miMarco extends JFrame{

    public miMarco(){

        setSize(600,600);

    }
}
