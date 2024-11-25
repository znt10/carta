package Teste;
import javax.swing.*;
import java.awt.*;

public class DesenhoSimples extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);

        
        g.fillRect(50, 50, 1600, 100);

        
        g.setColor(Color.RED);
        g.fillOval(200, 50, 100, 100);
    }

    public static void de() {

        
        JFrame frame = new JFrame();
        DesenhoSimples painel = new DesenhoSimples();
        frame.add(painel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
