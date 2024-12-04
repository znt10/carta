import javax.swing.*;
import java.awt.*;

public class JanelaSupervisor extends Janela {

    public void criarJanela(Perfil p) {
        // Criar a janela principal
        JFrame frame = new JFrame("Sistema do Supervisor");
        frame.setSize(800, 500);  // Tamanho da janela 800x500
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Layout nulo para posicionamento manual

        // Criar painel principal com imagem de fundo que ocupa toda a janela
        JLabel painel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagemFundo = new ImageIcon("imageAluno.png");
                g.drawImage(imagemFundo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        painel.setBounds(0, 0, frame.getWidth(), frame.getHeight()); // Preencher toda a janela
        frame.add(painel);

        // Botão para criar missões (centralizado horizontalmente)
        JButton btnFazerMissao = new JButton("Criar Missão");
        int xPosition = (frame.getWidth() - 200) / 2; // Centralizar o botão horizontalmente
        btnFazerMissao.setBounds(xPosition, 70, 200, 30);
        btnFazerMissao.addActionListener(e -> {
            // Criar combo box para escolher o tipo de missão
            String[] opcoes = {"Jogo da Memoria", "Jogo da Cores", "Jogo da Adivinhação"};
            JComboBox<String> box = new JComboBox<>(opcoes);
            box.setBounds((frame.getWidth() - 200) / 2, 150, 200, 30); // Centralizar o combo box

            // Adicionar combo box ao painel
            painel.add(box);
            painel.revalidate(); // Necessário para atualizar o painel
            painel.repaint();

            // Botão de confirmar missão
            JButton bntCorfirma = new JButton("Confirmar Missão");
            bntCorfirma.setBounds((frame.getWidth() - 200) / 2, 280, 200, 30); // Centralizar o botão de confirmação
            bntCorfirma.addActionListener(i -> {
                String tipoM = (String) box.getSelectedItem();
                p.getSupervisor().criarM(tipoM, p);
            });
            painel.add(bntCorfirma);
        });

        // Criar o botão "Voltar"
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(frame.getWidth() - 110, 10, 100, 20);  // Posiciona o botão no canto superior esquerdo
        btnVoltar.addActionListener(e -> {
            frame.dispose();  // Fecha a janela atual
            new TesteJanelaPerfil().criarJanela(p);  // Volta para a tela de perfil
        });

        // Adicionar botões ao painel
        painel.add(btnFazerMissao);
        painel.add(btnVoltar); // Adicionar o botão de voltar

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
