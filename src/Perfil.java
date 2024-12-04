import java.io.*;
import java.util.Scanner;

public class Perfil {
    private String nome;
    Scanner sc = new Scanner(System.in);
    private Missao missao;
    private boolean sup = false;
    private boolean alu = false;
    private Supervisor Supervisor;
    private String nomeArquivo;
    public int getNomeArquivo;

    public Perfil(){
        this.missao = new Missao();
        this.Supervisor = new Supervisor();
    }
    

    public void criarPerfil(String nomeAlo) {
        setAlu(true);
        this.nome = nomeAlo;
        this.nomeArquivo = nomeAlo + ".txt";
        File arquivo = new File(nomeArquivo);
        
        
        //verificando se o arquivo conta existe
        if (arquivo.exists()) {
            System.out.println(nomeAlo + " entrou na Conta");
        } else {
            
            
            try (FileWriter fw = new FileWriter(nomeArquivo,false)) {
                System.out.println("Perfil criado: " + nomeArquivo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            CriarAquivoATA(nomeAlo);
        }
        return;
                
        }
    
    private void CriarAquivoATA(String nomeAlo) {
        String nomeArquivo = nomeAlo + "ATA.txt";
        File file = new File(nomeAlo);
        if(file.exists()){
            
        }else{
            try (FileWriter fw = new FileWriter(nomeArquivo)){
            } catch (Exception e) {
            System.out.println(e.getMessage());}
            }
        
    }

    

    
    public void armazenarcartas() {
        try (BufferedReader br = new BufferedReader(new FileReader(nome+"ATA.txt"))) {
            String linha;
            String nomeArquivo = getNome() + ".txt";

            if((linha = br.readLine()) != null){
                try (FileWriter fw = new FileWriter(nomeArquivo,true)) {
                    fw.write(missao.getColecao().getCarta().getNome());
                    fw.write("\n");
                } catch (IOException e) {
                    System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }}


        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }


    public void editarPerfil(String nome) {
        String nomeAtA = nome +"ATA.txt";
        File arquivoNovo = new File(nomeAtA);
        File arquivoAntigo = new File(getNome()+ "ATA.txt");


        File fileAntigo = new File(getNome()+".txt");
        setNome(nome);
        File fileNovo = new File(getNome()+".txt");
        fileAntigo.renameTo(fileNovo);
        arquivoAntigo.renameTo(arquivoNovo);
        return;
    }
    


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }


    public boolean isSup() {
        return sup;
    }


    public void setSup(boolean sup) {
        this.sup = sup;
    }


    public boolean isAlu() {
        return alu;
    }


    public void setAlu(boolean alu) {
        this.alu = alu;
    }


    public Supervisor getSupervisor() {
        return Supervisor;
    }


    public void setSupervisor(Supervisor supervisor) {
        Supervisor = supervisor;
    }
    
    
}
