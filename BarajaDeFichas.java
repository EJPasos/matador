import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class BarajaDeFichas here.
 *
 * @author J. Pasos
 * @version 1.0
 */
public class BarajaDeFichas {
    private ArrayList<Ficha> baraja;
    private int numFichas;
    private int dobleMaximo;

    public BarajaDeFichas(int dobleMaximo) {
        this.dobleMaximo = dobleMaximo;
        this.numFichas = (dobleMaximo + 1) * (dobleMaximo + 2) / 2;
        baraja = new ArrayList<>(numFichas);
        for (int i = 0; i <= dobleMaximo; i++) {
            for (int j = i; j <= dobleMaximo; j++) {
                baraja.add(new Ficha(i, j));
            }
        }
        girarFichas();
    }

    public void girarFichas() {
        for (int i = 0; i < numFichas; i++) {
            baraja.get(i).girar180();
        }
    }

    public void barajar() {
        Random random = new Random();
        for (int i = 0; i < numFichas; i++) {
            int posAleatoria = random.nextInt(numFichas);
            Ficha temp = baraja.get(i);
            baraja.set(i, baraja.get(posAleatoria));
            baraja.set(posAleatoria, temp);
        }
    }

    public ArrayList<Ficha> repartirFichas(int numFichas) {
        ArrayList<Ficha> fichasRepartidas = new ArrayList<>(numFichas);
        for (int i = 0; i < numFichas; i++) {
            fichasRepartidas.add(baraja.remove(0));
        }
        this.numFichas -= numFichas;
        return fichasRepartidas;
    }

    public int getNumFichas() {
        System.out.println(numFichas);
        return numFichas;
    }

    public void imprimirBaraja() {
        for (int i = 0; i < numFichas; i++) {
            System.out.println(baraja.get(i).toString());
        }
    }


}
