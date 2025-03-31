import java.util.ArrayList;
import java.util.Scanner;

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
    private int jugadorEnTurno;
    private int puntuacionMaxima;
    private int jugadoresSinMovimientos;

    public Matador(int numJugadores, int puntuacionMaxima) {
        jugadoresSinMovimientos = 0;
        jugadores = new ArrayList<>(numJugadores);
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(new Jugador("Jugador " + (i + 1)));
        }
        this.puntuacionMaxima = puntuacionMaxima;
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

    public int getJugadorInicial() {
        int jugadorInicial = 0;
        int mulaAlta = 0;
        int valorDeFichaMasAlta = 0;
        boolean hayMulas = false;
        boolean hayDobleSeis = false;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).tieneDobleSeis()) {
                hayDobleSeis = true;
                jugadorInicial = i;
            }
            else if (jugadores.get(i).tieneDoble() && !hayDobleSeis) {
                hayMulas = true;
                if (jugadores.get(i).getDobleMasAlto() > mulaAlta){
                    mulaAlta = jugadores.get(i).getDobleMasAlto();
                    jugadorInicial = i;
                }
            }
            else if (!hayMulas && !hayDobleSeis) {
                if (jugadores.get(i).getValorDeFichaMasAlta() > valorDeFichaMasAlta) {
                    valorDeFichaMasAlta = jugadores.get(i).getValorDeFichaMasAlta();
                    jugadorInicial = i;
                }
            }

        }
        return jugadorInicial;
    }

    public boolean jugadorLlegoAPuntuacionMaxima(){
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntuacion() >= puntuacionMaxima) {
                return true;
            }
        }
        return false;
    }

    public void iniciarRonda(){
        boneyard = new BarajaDeFichas(6);
        boneyard.barajar();
        table = new Table();
        for (Jugador jugador : jugadores) {
            jugador.borrarMano();
        }
        repartirFichas();
        jugadorEnTurno = getJugadorInicial();
        System.out.println("Jugador inicial: " + jugadores.get(jugadorEnTurno).getNombre() + " Con la mano:");
        jugadores.get(jugadorEnTurno).imprimirMano();
        table.recibirFicha(jugadores.get(jugadorEnTurno).colocarFichaInicial());
        table.mostrarFichasJugadas();
        acabarTurno();

    }


    public void jugarTurno(){
        int ficha = -1;
        Scanner sc = new Scanner(System.in);
        boolean fichaValida = false;
        boolean manoValida = false;
        boolean turnoAcabado = false;

        // Verificar si el jugador ya no tiene fichas
        if (jugadores.get(jugadorEnTurno).getManoSize() == 0) {
            System.out.println(jugadores.get(jugadorEnTurno).getNombre() + " se ha quedado sin fichas!");
            turnoAcabado = true;
            return;
        }

        System.out.println("Jugador " + jugadores.get(jugadorEnTurno).getNombre() + " con la mano:");
        jugadores.get(jugadorEnTurno).imprimirMano();

        while (!manoValida && !turnoAcabado) {
            for (int i = 0; i < jugadores.get(jugadorEnTurno).getManoSize(); i++) {
                if (table.puedeColocarse(jugadores.get(jugadorEnTurno).getFicha(i))) {
                    manoValida = true;
                    break;
                }
            }

            if (!manoValida) {
                System.out.println("No puede colocar ninguna ficha, robando ficha");
                if (boneyard.getNumFichas() > 0) {
                    ArrayList<Ficha> fichaRobada = boneyard.repartirFichas(1);
                    jugadores.get(jugadorEnTurno).recibirFichas(fichaRobada);
                    System.out.println("Ficha Robada: " + fichaRobada.get(0).toString());

                    // Verificar si la ficha robada puede colocarse
                    if (table.puedeColocarse(fichaRobada.get(0))) {
                        System.out.println("La ficha robada puede colocarse!");
                        table.recibirFicha(jugadores.get(jugadorEnTurno).colocarFicha(jugadores.get(jugadorEnTurno).getManoSize()-1));
                        table.mostrarFichasJugadas();
                        turnoAcabado = true;
                        break;
                    }
                } else {
                    System.out.println("No hay más fichas en el boneyard, pasamos turno");
                    jugadoresSinMovimientos++;
                    turnoAcabado = true;
                    break;
                }
            }
        }

        if (!turnoAcabado && jugadores.get(jugadorEnTurno).getManoSize() > 0) {
            while (!fichaValida && !turnoAcabado) {
                jugadoresSinMovimientos = 0;
                System.out.println("Que ficha desea colocar?\n");
                ficha = sc.nextInt() - 1;
                if (ficha < jugadores.get(jugadorEnTurno).getManoSize() && ficha >= 0) {
                    if (table.puedeColocarse(jugadores.get(jugadorEnTurno).getFicha(ficha))) {
                        fichaValida = true;
                    } else {
                        System.out.println("La ficha: " + jugadores.get(jugadorEnTurno).getFicha(ficha).toString() + " no puede colocarse");
                    }
                } else {
                    System.out.println("Ficha no válida, intente de nuevo");
                }
            }
            if (fichaValida) {
                table.recibirFicha(jugadores.get(jugadorEnTurno).colocarFicha(ficha));
                table.mostrarFichasJugadas();
                turnoAcabado = true;
            }
        }
        jugadores.get(jugadorEnTurno).hacerInvisible();
    }

    public void acabarTurno() {
        jugadorEnTurno++;
        if (jugadorEnTurno == jugadores.size()) {
            jugadorEnTurno = 0;
        }
    }

    public boolean jugadorTieneFichas(){
        return jugadores.get(jugadorEnTurno).tieneFichas();
    }

    public void terminarRonda(){
        table.hacerInvisible();
        for (Jugador jugador : jugadores) {
            jugador.sumarPuntosEnMano();
        }
        System.out.println("Ronda terminada");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " tiene " + jugador.getPuntuacion() + " puntos");
        }

    }

    public boolean hayUnJugadorSinFichas(){
        for (Jugador jugador : jugadores) {
            if (jugador.getManoSize() == 0) {
                return true;
            }
        }
        return false;
    }

    // main
    public static void main(String[] args){
            Matador matador = new Matador(4, 100);
            while (!matador.jugadorLlegoAPuntuacionMaxima()) {
                matador.iniciarRonda();

                while (!matador.hayUnJugadorSinFichas() && matador.jugadoresSinMovimientos < matador.jugadores.size()) {
                    matador.jugarTurno();
                    matador.acabarTurno();
                }
                matador.terminarRonda();

            }

    }
}



