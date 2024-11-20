import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CriarM {
Scanner sc = new Scanner(System.in);

public void jogoDaMemeria(){
    try{
    List<String> cartas = new ArrayList<>();
    Collections.addAll(cartas, "🐱", "🐶", "🐱", "🐵", "🐶", "🐵", "🐸", "🐸");
    List<String> cartasEncontradas = new ArrayList<>(Collections.nCopies(cartas.size(), "?"));
    int cont = 0;
    while (cartasEncontradas.contains("?")){
        System.out.println("Cartas: " +cartasEncontradas);
        for (int i = 0; i < cartasEncontradas.size(); i++) {
            System.out.print(i + " - " + cartasEncontradas.get(i) + "  ");
        }
        System.out.println();
        System.out.println("Escolha a primeira carta");
        int escolha1 = sc.nextInt();
        System.out.println("Escolha a segunda carta");
        int escolha2 = sc.nextInt();

        
        if(escolha1 == escolha2){
            System.out.println("Você não pode escolher a mesma carta duas vezes");
            continue;
        }
        if(cartas.get(escolha1).equals(cartas.get(escolha2))){
            cartasEncontradas.set(escolha1, cartas.get(escolha1));
            cartasEncontradas.set(escolha2, cartas.get(escolha2));
            System.out.println("Par encontrado");
        }else{
            System.out.println("Tente novamendo");
        }
        cont++;
    }
    System.out.println(cartasEncontradas);
    System.out.println("Parabens você encontrou todas as cartas com " + cont + " tentativas");
}catch(Exception e){
    System.out.println("Erro: " +e);
}


}
}