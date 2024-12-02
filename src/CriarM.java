import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CriarM {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    private String corCorreta;
    private String corClicada;
    private JFrame j;


    public void jogoDaMemeria(){
        try{
        List<String> cartas = new ArrayList<>();
        Collections.addAll(cartas, "gato", "cachorro", "gato", "macaco", "cachorro", "macaco", "sapo", "sapo");
        Collections.shuffle(cartas);
        List<String> cartasEncontradas = new ArrayList<>(Collections.nCopies(cartas.size(), "?"));
        int cont = 0;

        while (cartasEncontradas.contains("?")){
            System.out.println("Cartas: " +cartasEncontradas);
            for (int i = 0; i < cartasEncontradas.size(); i++) {
                if(cartasEncontradas.get(i).contains("?")){
                    System.out.print(i + " - " + cartasEncontradas.get(i) + "  ");
            }}
            System.out.println();
            System.out.println("Escolha a primeira carta");
            int escolha1 = sc.nextInt();
            System.out.println("Escolha a segunda carta");
            int escolha2 = sc.nextInt();

            
            if(escolha1 == escolha2){
                System.out.println("Você não pode escolher a mesma carta duas vezes");
                continue;
            }
            if(cartas.get(escolha1).equals(cartas.get(escolha2))){
                cartasEncontradas.set(escolha1, cartas.get(escolha1));
                cartasEncontradas.set(escolha2, cartas.get(escolha2));
                System.out.println("Par encontrado");
            }else{
                System.out.println("Tente novamendo");
            }
            cont++;
        }
    
        System.out.println("Parabens você encontrou todas as cartas com " + cont + " tentativas");
        System.out.println(cartas);
    }catch(Exception e){
        System.out.println("Erro: " +e);
    }}



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
                g.fillOval(50, 50, 90, 90);
                g.setColor(Color.BLUE);
                g.fillOval(150, 50, 90, 90);
                g.setColor(Color.GREEN);
                g.fillOval(250, 50, 90, 90);
                g.setColor(Color.ORANGE);
                g.fillOval(350, 50, 90, 90);
            }
        };

        j.add(p, BorderLayout.CENTER);
        String[] cores = {"Vermelho", "Azul", "Verde", "Laranja"};
        corCorreta = cores[Random(cores)];
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
                if (isPointInCircle(x, y, 50, 50, 90)) { // Vermelho
                    corClicada = "Vermelho";
                } else if (isPointInCircle(x, y, 150, 50, 90)) { // Azul
                corClicada = "Azul";
                } else if (isPointInCircle(x, y, 250, 50, 90)) { // Verde
                    corClicada = "Verde";
                } else if (isPointInCircle(x, y, 350, 50, 90)) { // Laranja
                    corClicada = "Laranja";
                }else{
                    corClicada = null;
                }
            }
        });

        // Exibir janela
        j.setVisible(true);
    }

    private int Random(String [] cores) {
        return r.nextInt(cores.length);
    }

    // Verificando onde o usuário clicou
    // Se clicar na posiçao X= 450  Y=250 vai esta fora do circulo pois 450 ** 2 + 250 ** 2 > 90 ** 2
    // Se clicar na posiçao X= 100  Y= 50 vai estar dentro do circulo
    private boolean isPointInCircle(int x, int y, int circleX, int circleY, int radius) {
        int dx = x - circleX;
        int dy = y - circleY;
        return (dx * dx + dy * dy <= radius * radius);
    }

    // Método para verificar se a cor clicada é a correta
    private void verificarCor() {
        if (corClicada == null) { 
            JOptionPane.showMessageDialog(null, "Clique em uma cor primeiro!");
        } else if (corClicada.equalsIgnoreCase(corCorreta)) {
            JOptionPane.showMessageDialog(null, "Você escolheu a cor correta: " + corCorreta);
            // criei um abributo Jframe j para conseguir fechar a janela quando acerta
            j.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Cor errada! A cor correta era: " + corCorreta);
        }
    }



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
