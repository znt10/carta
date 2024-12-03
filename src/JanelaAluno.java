
import javax.swing.*;

public class JanelaAluno extends Janela {
    public void criarJanela(Perfil p) {
        // Criar a janela principal
        JFrame frame = new JFrame("Sistema do Aluno");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Layout nulo para posicionamento manual

        // Criar painel principal
        
        JLabel painel = new JLabel();
        painel.setBounds(0, 0, frame.getWidth(), frame.getHeight()); // Layout nulo para os componentes dentro do painel
        frame.add(painel);

        // Botão para realizar missões
        JButton btnFazerMissao = new JButton("Fazer Missão");
        btnFazerMissao.setBounds(100, 100, 200, 20);
        btnFazerMissao.addActionListener(e -> {
            p.getMissao().fazerMissao(p);
        });

        // Botão para Editar Perfil
        JButton bEditar = new JButton("Editar Perfil");
        bEditar.setBounds(200, 200, 200, 20);
        bEditar.addActionListener(e -> {
            JOptionPane.showInputDialog(null, "Mudar o nome ou Sair");
        });

        // Botão para visualizar cartas
        JButton btnVerCartas = new JButton("Ver Cartas");
        btnVerCartas.setBounds(300, 300, 200, 20);
        btnVerCartas.addActionListener(e -> {
            p.getMissao().getColecao().cartinhas(p);
        });

        // Adicionar botões ao painel
        painel.add(bEditar);
        painel.add(btnVerCartas);
        painel.add(btnFazerMissao);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
