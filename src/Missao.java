import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

import Jogos.JogoDaAdivinhacao;
import Jogos.JogoDaCor;
import Jogos.JogoDaMemoria;
public class Missao {
    private ArrayList<String> frases = new ArrayList<>();
    private ArrayList<String> nomes = new ArrayList<>();
    Colecao colecao = new Colecao();
    private String nomeAt;

    public void criarMissao(String nome,Perfil p){
        this.nomeAt = escolherM(nome);

        //verificando o arquivos de ativida
        String nomeArquivo = p.getNome() + "ATA.txt";
        try (FileWriter fw = new FileWriter(nomeArquivo,false)){
            fw.write(nomeAt);
        } catch (Exception e) {
            System.out.println(e.getMessage());}
        
    }

    private String escolherM(String escolha){

        
        char escolhaChar = escolha.toUpperCase().charAt(8);
        if(escolhaChar =='M'){
            return "Memoria";
        }else if(escolhaChar =='C'){
            return "Cores";
        }else if(escolhaChar =='A')
            return "Adivinhacao";
        return"";
    }

    
    public void fazerMissao(Perfil p){
        try(BufferedReader br = new BufferedReader(new FileReader(p.getNome()+"ATA.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if(linha.equals("Memoria")){
                    JogoDaMemoria jogo = new JogoDaMemoria();
                    jogo.jogarDaMemoria();
                    System.out.println();
                }else if(linha.equals("Cores")){
                    JogoDaCor jogoDaCor = new JogoDaCor();
                    jogoDaCor.jogoDeCores();
                    System.out.println();
                    
                }else if(linha.equals("Adivinhacao")){
                    JogoDaAdivinhacao jogoDaAdivinhacao = new JogoDaAdivinhacao();
                    jogoDaAdivinhacao.jogoDeAdivinhacao();
                    System.out.println();
                }

                ganharBoosters();
                p.armazenarcartas(); }
            } catch (Exception e) {
                System.out.println("ERRO"+ e.getLocalizedMessage());
        }
    }

    public void ganharBoosters(){
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
