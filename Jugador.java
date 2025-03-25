import java.util.ArrayList;

/**
 * La clase jugador
 *
 * @author J. Pasos
 * @version (a version number or a date)
 */
public class Jugador {
    private ArrayList<Ficha> Mano;
    private int puntuacion;

    public Jugador() {
        Mano = new ArrayList<>();
        puntuacion = 0;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getPuntosEnMano() {
        int puntos = 0;
        for (int i = 0; i < Mano.size(); i++) {
            puntos = puntos + Mano.get(i).getPuntosTotales();
        }
        return puntos;
    }

    public int getNumDeFichas() {
        return Mano.size();
    }

    public void reiniciarPuntuacion() {
        puntuacion = 0;
    }

    public void sumarPuntosEnMano() {
        puntuacion = puntuacion + getPuntosEnMano();
    }

    public void recibirFichas(ArrayList<Ficha> fichasRecibidas) {
        for (int i = 0; i < fichasRecibidas.size(); i++) {
            Mano.add(fichasRecibidas.get(i));
        }

    }


    public void borrarMano() {
        Mano.clear();
    }

    public Ficha colocarFicha(int posicion) {
        return Mano.remove(posicion);
    }

}
