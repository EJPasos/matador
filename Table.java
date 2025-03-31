import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class Table here.
 *
 * @author J. Pasos
 * @version (a version number or a date)
 */
public class Table
{
    ArrayList<Ficha> fichasJugadas;

    public Table()
    {
    fichasJugadas = new ArrayList<>();
    }

    public void recibirFicha(Ficha ficha) {
        ficha.girar90();
        if (fichasJugadas.isEmpty())
        {
            fichasJugadas.add(ficha);
            System.out.println("Ficha recibida: " + ficha);
        }
        else if(ficha.esDoble()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Desea colocar la ficha " + ficha + " a la izquierda o a la derecha?");
            System.out.println("1. Izquierda");
            System.out.println("2. Derecha");
            int opcion = sc.nextInt();
            if (opcion == 1)
            {
                fichasJugadas.add(0, ficha);
                System.out.println("Ficha recibida: " + ficha);
            }
            else if (opcion == 2)
            {
                fichasJugadas.add(ficha);
                System.out.println("Ficha recibida: " + ficha);
            }
        }
        else if (ficha.getCara2() + getLadoIzquierdo() == 7)
        {
            fichasJugadas.add(0, ficha);
            System.out.println("Ficha recibida: " + ficha);
        }
        else if (ficha.getCara1() + getLadoDerecho() == 7)
        {
            fichasJugadas.add(ficha);
            System.out.println("Ficha recibida: " + ficha);
        }
        else if (ficha.getCara2() + getLadoDerecho() == 7)
        {
            ficha.girar180();
            fichasJugadas.add(ficha);
            System.out.println("Ficha recibida: " + ficha);
        }
        else if(ficha.getCara1() + getLadoIzquierdo() == 7)
        {
            ficha.girar180();
            fichasJugadas.add(0, ficha);
            System.out.println("Ficha recibida: " + ficha);
        }
        hacerVisible();
    }

    public boolean puedeColocarse(Ficha ficha)
    {
        if (fichasJugadas.isEmpty())
        {
            return true;
        }
        else if (ficha.getCara1() + getLadoIzquierdo() == 7 || ficha.getCara2() + getLadoIzquierdo() == 7) {
            return true;
        }
        else if (ficha.getCara1() + getLadoDerecho() == 7 || ficha.getCara2() + getLadoDerecho() == 7) {
            return true;
        }
        else if (ficha.esDoble()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void mostrarFichasJugadas() {
        for (Ficha ficha : fichasJugadas)
        {
            System.out.println(ficha.toString());
        }
    }

    public int getLadoIzquierdo()
    {
        return fichasJugadas.get(0).getCara1();
    }

    public int getLadoDerecho()
    {
        return fichasJugadas.get(fichasJugadas.size() - 1).getCara2();
    }
    public void acomodarFichas() {
        for (final Ficha ficha : fichasJugadas) {
            ficha.setHorizontal();
        }
        for (int i = 0; i < fichasJugadas.size(); i++) {
            if (i < 13) {
                fichasJugadas.get(i).mover(20 + i * 136, 20);
            } else if (i < 26) {
                fichasJugadas.get(i).mover(20 + (i - 13) * 136, 110);
            } else if (i <= 28) {

                fichasJugadas.get(i).mover(20 - (i - 26) * 136, 200);
            }
        }
    }

    public void hacerVisible() {
        hacerInvisible();
        acomodarFichas();
        for (Ficha ficha : fichasJugadas)
        {
            ficha.mostrar();
        }
    }

    public void hacerInvisible() {
        for (Ficha ficha : fichasJugadas)
        {
            ficha.ocultar();
        }
    }
    
}
