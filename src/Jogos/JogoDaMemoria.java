package Jogos;
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class JogoDaMemoria {

    private JFrame frame;
    private JButton[] botoes;
    private List<String> cartas;
    private List<String> cartasEncontradas;
    private int escolha1 = -1;
    private int escolha2 = -1;
    private int tentativas = 0;

    Scanner sc = new Scanner(System.in);

    public void jogarDaMemoria() {
        inicializarJogo();
        criarInterface();
    }

    private void inicializarJogo() {
        cartas = new ArrayList<>();
        Collections.addAll(cartas, "🐱", "🐶", "🐱", "🐒", "🐶", "🐒", "🐸", "🐸");
        Collections.shuffle(cartas);
        
        Collections.shuffle(cartas);
        cartasEncontradas = new ArrayList<>(Collections.nCopies(cartas.size(), "?"));
    }

    private void criarInterface() {
        frame = new JFrame("Jogo da Memória");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(4, 4, 10, 10));

        //colocando os nomes nos butao
        botoes = new JButton[cartas.size()];
        for (int i = 0; i < cartas.size(); i++) {
            JButton botao = new JButton("?");
            botao.setFont(new Font("Segoe UI Emoji", Font.BOLD, 18));
            final int index = i;
            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    processarEscolha(index);
                }
            });
            botoes[i] = botao;
            frame.add(botao);
        }

        frame.setVisible(true);
    }

    private void processarEscolha(int index) {
        if (cartasEncontradas.get(index) != "?") {
            JOptionPane.showMessageDialog(frame, "Esta carta já foi encontrada!");
            return;
        }

        if (escolha1 == -1) {
            escolha1 = index;
            botoes[index].setText(cartas.get(index));
        } else if (escolha2 == -1 && index != escolha1) {
            escolha2 = index;
            botoes[index].setText(cartas.get(index));
            verificarPar();
        } else {
            JOptionPane.showMessageDialog(frame, "Você já escolheu duas cartas!");
        }
    }

    private void verificarPar() {
        tentativas++;
        if (cartas.get(escolha1).equals(cartas.get(escolha2))) {
            cartasEncontradas.set(escolha1, cartas.get(escolha1));
            cartasEncontradas.set(escolha2, cartas.get(escolha2));
            JOptionPane.showMessageDialog(frame, "Par encontrado!");
        } else {
            JOptionPane.showMessageDialog(frame, "Não é um par. Tente novamente!");
            botoes[escolha1].setText("?");
            botoes[escolha2].setText("?");
        }

        escolha1 = -1;
        escolha2 = -1;

        if (!cartasEncontradas.contains("?")) {
            JOptionPane.showMessageDialog(frame,
                    "Parabéns! Você encontrou todas as cartas em " + tentativas + " tentativas!");
            frame.dispose();
        }
    }


}


