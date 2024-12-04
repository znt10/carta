package Jogos;

import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JogoDaAdivinhacao {
    public void jogoDeAdivinhacao() {
        // Gerar o número aleatório entre 1 e 10
        Random r = new Random();
        int numeroCorreto = r.nextInt(10) + 1;
    
        // Criar a janela principal
        JFrame frame = new JFrame("Jogo de Adivinhação");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    
        // Rótulo com instruções
        JLabel label = new JLabel("Adivinhe o número entre 1 e 10!", JLabel.CENTER);
        frame.add(label, BorderLayout.NORTH);
    
        // Campo de entrada para o palpite
        JTextField campoPalpite = new JTextField();
        frame.add(campoPalpite, BorderLayout.CENTER);
    
        // Botão para enviar o palpite
        JButton botao = new JButton("Tentar");
        frame.add(botao, BorderLayout.SOUTH);
    
        // Adicionar ação ao botão
        botao.addActionListener(e -> {
            try {
                int tentativa = Integer.parseInt(campoPalpite.getText());
    
                if (tentativa == numeroCorreto) {
                    JOptionPane.showMessageDialog(frame, "Parabéns! Você acertou o número " + numeroCorreto + "!");
                    frame.dispose(); // Fecha a janela ao acertar
                } else {
                    int diferenca = Math.abs(tentativa - numeroCorreto);
                    if (diferenca == 1) {
                        label.setText("Muito próximo! Tente novamente.");
                    } else if (diferenca <= 3) {
                        label.setText("Está próximo! Tente novamente.");
                    } else {
                        label.setText("Está distante! Tente novamente.");
                    }
                    campoPalpite.setText(""); // Limpa o campo de entrada
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido.");
            }
        });
    
        // Tornar a janela visível
        frame.setVisible(true);
    }
}
