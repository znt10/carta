import java.awt.*;
import java.io.File;

import javax.swing.*;

public class TesteJanelaPerfil {
    public void criarJanela(Perfil p) {
        Supervisor s = new Supervisor();
        p.setAlu(false);
        p.setSup(false);
        if(p.isAlu() == false && p.isSup() == false) {

            // Criar a janela principal com tamanho 800x500
            JFrame frame = new JFrame("Sistema de Cartas e Missões");
            frame.setSize(800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            // Escreve o nome do aluno
            JTextField nome = new JTextField();
            nome.setBounds(300, 100, 200, 20); // Ajuste da posição do nome

            // Rótulo para informar onde escreve o nome
            JLabel nomeRotulo = new JLabel("Nome do Aluno:");
            nomeRotulo.setForeground(Color.BLACK);
            nomeRotulo.setBounds(200, 100, 100, 20); // Ajuste da posição do rótulo

            // Escreve se é aluno ou supervisor
            String[] Opcoes = {"Aluno", "Supervisor"};
            JComboBox<String> comboBox = new JComboBox<>(Opcoes);
            comboBox.setBounds(300, 150, 200, 20); // Ajuste da posição da combobox
            comboBox.setSelectedIndex(0);

            // Escolhendo a imagem da tela de criação de Perfil (ajustada para 800x500)
            ImageIcon imagemPerfil = new ImageIcon("imageAluno.png");
            Image imagemRedimensionada = imagemPerfil.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH); // Redimensiona para 800x500
            imagemPerfil = new ImageIcon(imagemRedimensionada);
            JLabel labelPerfil = new JLabel(imagemPerfil);
            labelPerfil.setBounds(0, 0, 800, 500); // Define a posição e o tamanho da imagem
            frame.add(labelPerfil);

            // Botão de criação de Perfil (centralizado na janela)
            JButton btnPerfil = new JButton("Criar Perfil");
            btnPerfil.setBounds(350, 400, 100, 50); // Centraliza o botão
            btnPerfil.addActionListener(e -> {
                String nomeAluno = nome.getText().trim();
                String tipo = (String) comboBox.getSelectedItem();
                if(tipo.equals("Aluno")){
                    File file = new File(nomeAluno + ".txt");
                    if(file.exists()){
                        JOptionPane.showMessageDialog(frame, nomeAluno + " entrou no Perfil");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Perfil criado para: " + nomeAluno);
                    }
                    p.criarPerfil(nomeAluno);
                } else {
                    JOptionPane.showMessageDialog(frame, "Entrou como Supervisor");
                    p.setNome(nomeAluno);
                    while(s.getSenhaCerta() == false){
                        String senha = JOptionPane.showInputDialog(frame, "Senha do Supervisor");
                        int senhaInt = Integer.parseInt(senha);
                        s.certo(senhaInt, p);
                        if(s.getSenhaCerta() == false){
                            JOptionPane.showMessageDialog(frame, "Senha incorreta");
                        }
                    }
                }

                if (p.isAlu() == true || p.isSup() == true) {
                    frame.dispose();
                    abrirProximaJanela(p);
                }
            });

            // Adiciona os componentes à janela
            labelPerfil.add(comboBox);
            labelPerfil.add(nomeRotulo);
            labelPerfil.add(btnPerfil);
            labelPerfil.add(nome);

            // Tornar a janela visível
            frame.setVisible(true);
        }
    }

    private void abrirProximaJanela(Perfil p) {
        if (p.isAlu()) {
            new JanelaAluno().criarJanela(p);
        } else if (p.isSup()) {
            new JanelaSupervisor().criarJanela(p);
        }
    }
}
