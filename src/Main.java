

public class Main {
    public static void main(String[] args) {
        // so ttem  janela depois de criar conta 
        Janela j = new JanelaAluno();
        Janela j2 = new JanelaSupervisor();
        Perfil p = new Perfil();
        p.criarPerfil();

        if(p.isAlu() == true){
            j.criarJanela(p);

        }else if(p.isSup() == true){
            j2.criarJanela(p);
        }
        
}
}