import java.util.ArrayList;
import java.util.Random;

public class Missao {
    private ArrayList<String> frases = new ArrayList<>();
    private ArrayList<String> nomes = new ArrayList<>();
    Colecao colecao = new Colecao();
    public void criarMissao(){


    }

    public void fazerMissao(){

        ganharBoosters();

    }

    private void ganharBoosters(){
        frases.add("Olá!");
        frases.add("Tudo bem?");
        frases.add("Eu preciso de ajuda.");
        frases.add("Eu gosto disso.");
        frases.add("Eu não gosto disso.");
        frases.add("Estou com fome.");
        frases.add("Estou com sede.");
        frases.add("Estou cansado.");
        frases.add("Por favor, espere.");
        frases.add("Obrigado!");

        // Nomes das cartas
        nomes.add("Saudação");
        nomes.add("Pergunta Simples");
        nomes.add("Ajuda");
        nomes.add("Gostar");
        nomes.add("Não Gostar");
        nomes.add("Fome");
        nomes.add("Sede");
        nomes.add("Cansaço");
        nomes.add("Espera");
        nomes.add("Agradecimento");

        Random r = new Random();

        int no = r.nextInt(10);
        Carta carta = new Carta(frases.get(no),nomes.get(no));

        System.out.println("VC ganho a carta "+carta);
        colecao.addCartas(carta);

    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }
}
