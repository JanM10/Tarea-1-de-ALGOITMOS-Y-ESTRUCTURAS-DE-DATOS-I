package com.company;

import javax.swing.*;
import java.awt.*;

public class Lamina extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawString("Esto es una prueba", 100, 100);
    }
}
