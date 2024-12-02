import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;

public class JogoDeCores {
    public static void main(String[] args) {
        JFrame j = new JFrame("Jogo de Cores");
        j.setSize(500, 300);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(new BorderLayout());

        // Painel para desenhar os retângulos
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                this.setBackground(Color.WHITE);

                // Criar cores mais claras usando o método brighter()
                Color lightRed = Color.RED.brighter();
                Color lightBlue = Color.BLUE.brighter();
                Color lightGreen = Color.GREEN.brighter();
                Color lightOrange = Color.ORANGE.brighter();

                // Desenhar retângulos coloridos
                g.setColor(lightRed);
                g.fillRect(50, 50, 90, 90);
                g.setColor(lightBlue);
                g.fillRect(150, 50, 90, 90);
                g.setColor(lightGreen);
                g.fillRect(250, 50, 90, 90);
                g.setColor(lightOrange);
                g.fillRect(350, 50, 90, 90);
            }
        };

        j.add(p, BorderLayout.CENTER);
        j.setVisible(true);
    }
}


