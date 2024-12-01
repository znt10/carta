//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        // so ttem  janela depois de criar conta 
        Perfil p = new Perfil();
        Supervisor s = new Supervisor();
        Colecao colecao = new Colecao();
        p.criarPerfil(s);
            // Criar a janela principal
            JFrame frame = new JFrame("Sistema de Cartas e Missões");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Criar painel principal
            JPanel painel = new JPanel();
            painel.setLayout(new GridLayout(3, 1, 10, 10));


            // Botão para realizar missões
            JButton btnFazerMissao = new JButton("Fazer Missão");
            btnFazerMissao.addActionListener(e -> {
                p.getMissao().fazerMissao(p);
            });

            // Botão para visualizar cartas
            JButton btnVerCartas = new JButton("Ver Cartas");
            btnVerCartas.addActionListener(e -> {
                colecao.cartinhas(p);
            });

            
            // Adicionar botões ao painel
            painel.add(btnVerCartas);
            painel.add(btnFazerMissao);
            frame.add(painel, BorderLayout.CENTER);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
