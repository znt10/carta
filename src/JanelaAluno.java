import javax.swing.*;
import java.awt.*;

public class JanelaAluno extends Janela {
    public void criarJanela(Perfil p) {
        // Criar a janela principal
        JFrame frame = new JFrame("Sistema do Aluno");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criar um painel principal para desenhar o fundo
        JPanel painelFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carregar e desenhar a imagem de fundo
                ImageIcon imagemFundo = new ImageIcon("imageAluno.png");
                g.drawImage(imagemFundo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelFundo.setLayout(null);

        // Criar os botões
        JButton btnFazerMissao = new JButton("Fazer Missão");
        btnFazerMissao.setBounds(300, 100, 200, 30); // Centralizado horizontalmente
        btnFazerMissao.addActionListener(e -> {
            p.getMissao().fazerMissao(p);
        });

        JButton bEditar = new JButton("Editar Perfil");
        bEditar.setBounds(300, 150, 200, 30); 
        bEditar.addActionListener(e -> {
            String nomeNovo = JOptionPane.showInputDialog(null, "Mudar o nome");
            p.editarPerfil(nomeNovo);
            JOptionPane.showMessageDialog(frame, "Perfil editado com sucesso!");
        });

        JButton btnVerCartas = new JButton("Ver Cartas");
        btnVerCartas.setBounds(300, 200, 200, 30); 
        btnVerCartas.addActionListener(e -> {
            p.getMissao().getColecao().cartinhas(p);
        });

        // Criar o botão "Voltar"
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(frame.getWidth() - 110, 10,100, 20);  // Posiciona o botão no canto superior esquerdo
        btnVoltar.addActionListener(e -> {
            frame.dispose();  // Fecha a janela atual
            new TesteJanelaPerfil().criarJanela(p);  // Volta para a tela de perfil
        });

        // Adicionar botões ao painel
        painelFundo.add(btnFazerMissao);
        painelFundo.add(bEditar);
        painelFundo.add(btnVerCartas);
        painelFundo.add(btnVoltar); // Adicionar o botão de voltar

        // Adicionar painel à janela
        frame.add(painelFundo);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
