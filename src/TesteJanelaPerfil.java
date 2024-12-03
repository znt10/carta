
import java.awt.*;
import javax.swing.*;

public class TesteJanelaPerfil {
    public void criarJanela(Perfil p) {
        Supervisor s = new Supervisor();
        if(p.isAlu() == false && p.isSup() == false) {

        
     // Criar a janela principal
            JFrame frame = new JFrame("Sistema de Cartas e Missões");
            frame.setSize(510, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            //escreve o nome do aluno
            JTextField nome = new JTextField();
            nome.setBounds(150,100,200,20);

            //Rotulo para informa onde escreve o nome
            JLabel nomeRotulo = new JLabel("Nome do Aluno:");
            nomeRotulo.setForeground(Color.BLACK);
            nomeRotulo.setBounds(50, 100, 100, 20);


            //Escreve se é aluno ou supervisor
            String[] Opcoes = {"Aluno","Supervisor"};
            JComboBox<String> comboBox = new JComboBox<>(Opcoes);
            comboBox.setBounds(150,150,200,20);
            comboBox.setSelectedIndex(0);

            //escolhando a imagem da tela de criançao de Perfil
            ImageIcon imagemPerfil = new ImageIcon("imagemTelaPerfil.png");
            JLabel labelPerfil = new JLabel(imagemPerfil);
            labelPerfil.setBounds(0, 0, frame.getWidth(), frame.getHeight());
            frame.add(labelPerfil);
        

            //botao de criaçao de Perfil
            JButton btnPerfil = new JButton("Criar Perfil");
            btnPerfil.setBounds(200, 400, 100, 50);
            btnPerfil.addActionListener(e -> {
                String nomeAluno = nome.getText().trim();
                String tipo = (String) comboBox.getSelectedItem();
                if(tipo.equals("Aluno")){
                    JOptionPane.showMessageDialog(frame, "Perfil criado para: " + nomeAluno);
                    p.criarPerfil(nomeAluno);
                }else{
                    JOptionPane.showMessageDialog(frame, " Entrou como Supervisor");
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
            
            labelPerfil.add(comboBox);
            labelPerfil.add(nomeRotulo);
            labelPerfil.add(btnPerfil);
            labelPerfil.add(nome);

            
        // Tornar a janela visível
        frame.setVisible(true);
        }
    }



        private void abrirProximaJanela(Perfil p) {
            // Após o perfil ser criado, verifica se é aluno ou supervisor
            if (p.isAlu()) {
                new JanelaAluno().criarJanela(p);
            } else if (p.isSup()) {
                new JanelaSupervisor().criarJanela(p);
            }
        }
    
        
    }

