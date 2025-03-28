import java.util.ArrayList;

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

    public void recibirFicha(Ficha ficha)
    {
        if (fichasJugadas.isEmpty())
        {
            fichasJugadas.add(ficha);
            System.out.println("Ficha recibida: " + ficha);
        }
        else if (ficha.getCara1() + getLadoIzquierdo() == 7)
        {
            ficha.girar180();
            fichasJugadas.add(0, ficha);
            System.out.println("Ficha recibida: " + ficha);
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
    
}
