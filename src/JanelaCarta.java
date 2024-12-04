import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class JanelaCarta {

    public void exibeCarta(Perfil p) {
        String[] nomes = {"Saudacao", "Ajuda", "Gostar", "Nao Gostar", "Fome", "Sede", "Cansaco", "Espera", "Agradecimento"};
        JFrame frame = new JFrame("Sistema do Supervisor");
        frame.setSize(1300, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Layout nulo para posicionamento manual
        
        // Parâmetros de posicionamento
        int larguraImagem = 150;  
        int alturaImagem = 200; 
        int espacoHorizontal = 20; 
        int espacoVertical = 30;   
        
        int x = 50; 
        int y = 100; 
        
        try (BufferedReader br = new BufferedReader(new FileReader(p.getNome() + ".txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                for (int i = 0; i < nomes.length; i++) { 
                    if (linha.equals(nomes[i])) {
                        String caminhoImagem = "Imagem das cartas/" + nomes[i] + ".PNG";
                        
                        // Verifica se o arquivo de imagem existe antes de carregá-lo
                        File imagemArquivo = new File(caminhoImagem);
                        if (imagemArquivo.exists()) {
                            // Carregar a imagem
                            ImageIcon imagem = new ImageIcon(caminhoImagem);
                            Image img = imagem.getImage(); // Obtém a imagem original
                            Image novaImagem = img.getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH); // Redimensiona a imagem
                            ImageIcon imagemRedimensionada = new ImageIcon(novaImagem);
                        
                            // Criar painel com a imagem redimensionada
                            JLabel painel = new JLabel(imagemRedimensionada);
                        
                            // Definir posição do painel
                            painel.setBounds(x, y, larguraImagem, alturaImagem); // Posição da imagem
                        
                            // Adicionar o painel à janela
                            frame.add(painel);
                        
                            // Atualizar a posição horizontal para a próxima imagem
                            x += larguraImagem + espacoHorizontal;
                        
                            // Se ultrapassar a largura da janela, pular para a linha seguinte
                            if (x + larguraImagem + espacoHorizontal > frame.getWidth()) {
                                x = 50;  // Resetar a posição horizontal
                                y += alturaImagem + espacoVertical; // Mover para a linha seguinte
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Criar o botão "Voltar"
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(frame.getWidth() - 110, 10, 100, 20);
        btnVoltar.addActionListener(e -> {
            frame.dispose(); // Fecha a janela atual
            new JanelaAluno().criarJanela(p); // Retorna para JanelaAluno
        });
        frame.add(btnVoltar);

        // Adicionar o botão "Voltar"
        frame.add(btnVoltar);
        frame.setVisible(true);
    }
}
