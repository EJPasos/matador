import java.util.ArrayList;

/**
 * Write a description of class Matador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Matador {
    private BarajaDeFichas boneyard;
    private ArrayList<Jugador> jugadores;
    private Table table;

    public Matador(int numJugadores) {
        jugadores = new ArrayList<>(numJugadores);
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(new Jugador());
        }
        table = new Table();


    }

    //si numero de jugadores = 2 o 3, repartir 7 fichas a cada jugador
    //si numero de jugadores = 4, repartir 5 fichas a cada jugador
    public void repartirFichas() {
        boneyard.barajar();
        int fichas = 0;
        if (jugadores.size() == 2 || jugadores.size() == 3) {
            fichas = 7;
        } else if (jugadores.size() == 4) {
            fichas = 5;
        }
        for (Jugador jugadores : jugadores) {
            jugadores.recibirFichas(boneyard.repartirFichas(fichas));
        }
    }

    public int getJugadorConMulaMayor() {
        int mulaMayor = 0;
        int jugador = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getPuntosEnMano() > mulaMayor) {
                mulaMayor = jugadores.get(i).getPuntosEnMano();
                jugador = i;
            }
        }
        return jugador;
    }

    public boolean unJugadorTiene0Fichas() {
        for (Jugador jugadores : jugadores) {
            if (jugadores.getNumDeFichas() == 0) {
                return true;
            }
        }
        return false;
    }

    public void ronda() {
        boneyard = new BarajaDeFichas(6);
        repartirFichas();

        int turnoDeJugador = getJugadorConMulaMayor();
        do {


        if (turnoDeJugador < jugadores.size()){
            turnoDeJugador++;
        } else {
            turnoDeJugador = 0;
        }
        } while (unJugadorTiene0Fichas());

        for (Jugador jugadores : jugadores) {
            jugadores.sumarPuntosEnMano();
        }

        for (Jugador jugadores : jugadores) {
            jugadores.borrarMano();
        }
    }
}



