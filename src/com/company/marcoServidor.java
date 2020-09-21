package com.company;

import javax.swing.*;
import java.awt.*;

public class marcoServidor extends JFrame {

    public marcoServidor() {

        setBounds(1200,300,280,350);

        JPanel milamina = new JPanel();

        milamina.setLayout(new BorderLayout());

        JTextArea areatexto = new JTextArea();

        milamina.add(areatexto, BorderLayout.CENTER);

        add(milamina);

        setVisible(true);
    }

}
