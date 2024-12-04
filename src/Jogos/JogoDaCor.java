package Jogos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JogoDaCor {
    private Random r = new Random();
    private JFrame j;
    private String corCorreta;
    private String corClicada;

    public void jogoDeCores() {
        j = new JFrame("Jogo de Cores");
        j.setSize(500, 300);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(new BorderLayout());

        // Painel para desenhar os círculos
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                this.setBackground(Color.white);

                // Desenhar círculos coloridos
                g.setColor(Color.RED);
                g.fillOval(50, 50, 90, 90); // Vermelho
                g.setColor(Color.BLUE);
                g.fillOval(150, 50, 90, 90); // Azul
                g.setColor(Color.GREEN);
                g.fillOval(250, 50, 90, 90); // Verde
                g.setColor(Color.ORANGE);
                g.fillOval(350, 50, 90, 90); // Laranja
            }
        };

        j.add(p, BorderLayout.CENTER);

        // Escolher a cor correta aleatoriamente
        String[] cores = {"Vermelho", "Azul", "Verde", "Laranja"};
        corCorreta = cores[r.nextInt(cores.length)];

        // Botão para verificar a escolha
        JButton verificarBotao = new JButton(corCorreta);
        verificarBotao.addActionListener(e -> verificarCor());
        j.add(verificarBotao, BorderLayout.SOUTH);

        // Adicionar MouseListener para capturar cliques nos círculos
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // Atualizar a corClicada com base no círculo clicado
                if (isPointInCircle(x, y, 95, 95, 45)) { // Vermelho (ajustado para centro do círculo)
                    corClicada = "Vermelho";
                } else if (isPointInCircle(x, y, 195, 95, 45)) { // Azul
                    corClicada = "Azul";
                } else if (isPointInCircle(x, y, 295, 95, 45)) { // Verde
                    corClicada = "Verde";
                } else if (isPointInCircle(x, y, 395, 95, 45)) { // Laranja
                    corClicada = "Laranja";
                } else {
                    corClicada = null;
                }
            }
        });

        // Exibir janela
        j.setVisible(true);
    }

    // Verificar se o ponto clicado está dentro de um círculo
    private boolean isPointInCircle(int x, int y, int circleX, int circleY, int radius) {
        int dx = x - circleX;
        int dy = y - circleY;
        return (dx * dx + dy * dy <= radius * radius);
    }

    // Método para verificar se a cor clicada é a correta
    private void verificarCor() {
        if (corClicada == null) {
            JOptionPane.showMessageDialog(j, "Clique em uma cor primeiro!");
        } else if (corClicada.equalsIgnoreCase(corCorreta)) {
            JOptionPane.showMessageDialog(j, "Você escolheu a cor correta: " + corCorreta);
            j.dispose();
        } else {
            JOptionPane.showMessageDialog(j, "Cor errada! A cor correta era: " + corCorreta);
        }
    }
}
