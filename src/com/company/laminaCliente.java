package com.company;

import javax.swing.*;
import java.awt.*;

class laminaCliente extends JPanel {

    public laminaCliente(){

        JLabel texto = new JLabel("CLIENTE");

        add(texto);

        campo1 = new JTextField(20);

        add(campo1);

        miboton = new JButton("Enviar");

        add(miboton);
    }

    private JTextField campo1;

    private JButton miboton;
}
