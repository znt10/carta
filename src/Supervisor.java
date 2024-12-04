
import java.util.Scanner;

public class Supervisor {
    private Boolean senhaCerta = false;

    private int senha = 12345;
    Scanner sc = new Scanner(System.in);



    public void criarM(String nome,Perfil p){
        p.getMissao().criarMissao(nome,p);
    }



    public void certo(int numeros, Perfil p){
        if(numeros == senha){
            p.setSup(true);
            senhaCerta = true;
        }
    }

    public Boolean getSenhaCerta() {
        return senhaCerta;
    }



    public void setSenhaCerta(Boolean senhaCerta) {
        this.senhaCerta = senhaCerta;
    }
}
