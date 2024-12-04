

public class Main {
    public static void main(String[] args) {
        Perfil p = new Perfil();
        
        Janela j2 = new JanelaSupervisor();
        //Janela j = new JanelaAluno();
        
        j2.criarJanela(p);
        //j.criarJanela(p);
        //JogoDaMemoria jogo = new JogoDaMemoria();
        //jogo.jogarDaMemoria();
        TesteJanelaPerfil t = new TesteJanelaPerfil();
        //t.criarJanela(p);
}
} 