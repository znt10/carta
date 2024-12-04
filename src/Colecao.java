
import java.util.ArrayList;

public class Colecao {
    ArrayList<Carta> cartas = new ArrayList<>();
    private Carta carta;

    public void addCartas(Carta c){
        cartas.add(c);
        this.carta = c;


    }

    public void cartinhas(Perfil p){
    JanelaCarta j = new JanelaCarta();
    j.exibeCarta(p);


    }



    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }}
