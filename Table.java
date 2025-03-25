import java.util.ArrayList;

/**
 * Write a description of class Table here.
 *
 * @author J. Pasos
 * @version (a version number or a date)
 */
public class Table
{
    ArrayList<Ficha> fichasJugadas = new ArrayList<>();

    public Table()
    {

    }

    public void recibirFicha(Ficha ficha)
    {
        fichasJugadas.add(ficha);
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
