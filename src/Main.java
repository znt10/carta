//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        Perfil p = new Perfil();
        Supervisor s = new Supervisor();
        p.criarPerfil(s);
        // Criar a janela principal
        /*JFrame frame = new JFrame("Sistema de Cartas e Missões");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Criar painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 1, 10, 10));

        // Botão para criar perfil
        JButton btnCriarPerfil = new JButton("Criar Perfil");
        btnCriarPerfil.addActionListener(e -> {
            // Abrir caixa de diálogo para digitar o nome
            String nome = JOptionPane.showInputDialog(frame, "Digite o nome do perfil:");

            if (nome != null && !nome.trim().isEmpty()) {
                Perfil perfil = new Perfil();
                perfil.setNome(nome); // Configurar o nome no perfil
                Supervisor supervisor = new Supervisor();
                String con = JOptionPane.showInputDialog(frame,"Digite fazer atividade ou Ver coleçao");
                supervisor.conversa(perfil);

                JOptionPane.showMessageDialog(frame, "Perfil criado para: " + nome);
            } else {
                JOptionPane.showMessageDialog(frame, "O nome do perfil não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Botão para visualizar cartas
        JButton btnVerCartas = new JButton("Ver Cartas");
        btnVerCartas.addActionListener(e -> {
            Perfil perfil = new Perfil();
            Colecao colecao = new Colecao();
            colecao.cartinhas(perfil);
        });

        // Botão para realizar missões
        JButton btnFazerMissao = new JButton("Fazer Missão");
        btnFazerMissao.addActionListener(e -> {

            Missao missao = new Missao();
            missao.fazerMissao();
            JOptionPane.showMessageDialog(frame, "Missão realizada! Veja suas cartas.");
        });

        // Adicionar botões ao painel
        painel.add(btnCriarPerfil);
        painel.add(btnVerCartas);
        painel.add(btnFazerMissao);

        // Adicionar painel à janela
        frame.add(painel, BorderLayout.CENTER);

        // Tornar a janela visível
        frame.setVisible(true);
    */}
}
