//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // so ttem  janela depois de criar conta 
        JanelaAluno j = new JanelaAluno();
        Perfil p = new Perfil();
        Supervisor s = new Supervisor();
        p.criarPerfil(s);
        if(p.isAlu() == true){
            j.criarJanela(p);
        }
        
}
}