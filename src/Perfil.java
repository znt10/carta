import java.io.*;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Perfil {
    private String nome;
    Scanner sc = new Scanner(System.in);
    private Missao missao;


    private String nomedoA() {
        System.out.println("Qual nome do Aluno ou Aluna?");
        return this.nome = sc.nextLine();

    }


    public void criarPerfil(Supervisor s) {
        this.missao = new Missao();
        nomedoA();

        switch (AouS()) {
            case "ALUNO":
                String nomeArquivo = nome + ".txt";
                File arquivo = new File(nomeArquivo);

                if (arquivo.exists()) {
                    System.out.println("O " + getNome() + " possui cartinhas");
                

                } else {
                    // Criação de uma nova conta
                    try (FileWriter fw = new FileWriter(nomeArquivo)) {
            
                        System.out.println("Perfil criado: " + nomeArquivo);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                s.conversa(this);
                return;

            case "SUPERVISOR":
                System.out.println("Qual senha?");
                System.out.println(s.certa(sc.nextInt()));
                sc.nextLine();
                System.out.println("CRIAR MISSAO\nINVENTARIO\nVER CONVERSA");
                switch (CouVouI()){
                    case "CRIAR" -> s.criarM(missao);
                    case "VER" -> s.verConversa(nome);
                    case "INVENTARIO" -> s.inventario();
                }
                break;
        }


    }

    private String CouVouI(){
       String op = sc.nextLine();
       char pri = op.toUpperCase().charAt(0);
        return switch (pri) {
            case 'C' -> "CRIAR";
            case 'V' -> "VER";
            case 'I' -> "INVENTARIO";
            default -> "";
        };
    }
    public void armazenarcartas() {
        String nomeArquivo = getNome() + ".txt";

        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(missao.getColecao().getCarta().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void acessarPerfil() {
        // Mostra os dados do perfil com uma interface simples
        System.out.println("O meu nome é " + getNome());
        editarPerfil();
    }

    private void editarPerfil() {
        System.out.println("Deseja editar algo?");
        System.out.println("NOME\nSAIR");
        String op = sc.nextLine();

        switch (op.toUpperCase()) {
            case "NOME":
                System.out.println("Mudando o NOME do perfil");
                setNome(sc.nextLine());
                System.out.println("O nome foi alterado para " + getNome());
                break;
            case "SAIR":
                break;
            default:
                System.out.println("Opção inválida.");
                editarPerfil();  // Chama novamente para opção correta
        }
    }

    private String AouS() {
        System.out.println("ALUNO ou SUPERVISOR");
        String op = sc.nextLine();
        char primeira = op.toUpperCase().charAt(0);
        return switch (primeira) {
            case 'A' -> "ALUNO";
            case 'S' -> "SUPERVISOR";
            default -> "";
        };
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }
}
