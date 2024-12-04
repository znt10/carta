
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaSupervisor extends Janela {

    public void criarJanela(Perfil p) {
     // Criar a janela principal
            JFrame frame = new JFrame("Sistema do Supervisor");
            frame.setSize(800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null); // Layout nulo para posicionamento manual
            
            // Criar painel principal
            ImageIcon imagem = new ImageIcon("imageAluno.png");
            JLabel painel = new JLabel(imagem);
            painel.setBounds(0, 0, frame.getWidth(), frame.getHeight()); // Layout nulo para os componentes dentro do painel
            frame.add(painel);
    

            // Botão para realizar missões
            JButton btnFazerMissao = new JButton("Criar Missão");
            btnFazerMissao.setBounds(300, 370, 100, 30);
            btnFazerMissao.addActionListener(e -> {
                
                String[] opcoes = {"Jogo da Memoria","Jogo da Cores", "Jogo da Adivinhaçao"};
                JComboBox<String> box = new JComboBox<>(opcoes);
                //posiçao do butao
                box.setBounds(150,150,200,20);
                box.setSelectedIndex(0);
                painel.add(box);
                painel.revalidate(); // Necessário para atualizar o painel
                painel.repaint();
                JButton bntCorfirma = new JButton("Confirmar Missão");
                bntCorfirma.setBounds(150, 180, 200, 30);
                bntCorfirma.addActionListener(i ->{
                    String tipoM = (String) box.getSelectedItem();
                    p.getSupervisor().criarM(tipoM,p);
                }); 
                painel.add(bntCorfirma);
                
            });


        
            // Adicionar botões ao painel
            painel.add(btnFazerMissao);
        

        // Tornar a janela visível
        frame.setVisible(true);
    }

    
}
