import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Supervisor {
    private static String nome;
    private int senha = 12345;
    Scanner sc = new Scanner(System.in);



    public void criarM(Missao missao){
        missao.criarMissao();
    }

    public void verConversa(String nome){
        System.out.println();
        String c = nome+"conversa.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(c))){
            String linha;
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        }catch (Exception e){

        }
    }


    public String certa(int numeros){
        if(numeros == senha){
            return "A senha esta certa, acasse permitido";

        }else{
            return "senha errada";
        }
    }


    public void inventario(){

    }

    public void conversa(Perfil p){

        String conversa = p.getNome()+"conversa.txt";

        try(FileWriter fileWriter = new FileWriter(conversa)){
            while(true){
            System.out.println("Continuar ou Sair");
            String op = sc.nextLine();
            fileWriter.write(op+",");
            char primeira = op.toUpperCase().charAt(0);
            switch (primeira) {
                case 'S':
                    System.out.println("Saiu");
                break;
                
                case 'C':
                
                System.out.println("Quer Fazer Atividades?\nVer sua colocao?");
                String op1 = sc.nextLine();
                fileWriter.write(op1);
                char primeira1 = op1.toUpperCase().charAt(0);
                if (primeira1 == 'C' || primeira1 == 'V'){
                    p.getMissao().getColecao().cartinhas(p);
                    return;
                } else if (primeira1 == 'A' || primeira1 == 'F') {
                    System.out.println();
                    p.getMissao().fazerMissao();
                    p.armazenarcartas();
                    return;
                }return;
                default:
                System.out.println("Opcao invalida");
                    return;


            }
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //conversa com supervisor pra conseguir a fazer missao e ganhar boots






    }
}
