import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CriarM {
Scanner sc = new Scanner(System.in);
    Random r = new Random();
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

    public void jogoDeCores(){
        JPanel p = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            this.setBackground(Color.white);
            g.setColor(Color.black);
            g.fillOval(150, 50, 90, 90);
            g.setColor(Color.BLUE);
            g.fillOval(250, 50, 90, 90);
            g.setColor(Color.GREEN);
            g.fillOval(350, 50, 90, 90);
            g.setColor(Color.ORANGE);
            g.fillOval(450, 50, 90, 90);
        }};

        JFrame j = new JFrame();
        j.setSize(700,600);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(new BorderLayout());
        j.add(p,BorderLayout.CENTER);
        
        String [] cores = {"Azul", "Verde", "Laranja","Preto"};
        int nu = r.nextInt(cores.length);
        
        JButton b = new JButton(cores[nu]);
        b.setPreferredSize(new Dimension(100,50));
        JPanel buPanel = new JPanel();
        buPanel.add(b);
        j.getContentPane().add(buPanel, BorderLayout.SOUTH);


        


        j.setVisible(true);
    }

}
