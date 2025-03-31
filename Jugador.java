import java.util.ArrayList;
import java.util.Collection;

/**
 * La clase jugador
 *
 * @author J. Pasos
 * @version (a version number or a date)
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;
    private int puntuacion;

    public Jugador(String nombre) {
        mano = new ArrayList<>();
        puntuacion = 0;
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosEnMano() {
        int puntos = 0;
        for (int i = 0; i < mano.size(); i++) {
            puntos = puntos + mano.get(i).getPuntosTotales();
        }
        return puntos;
    }

    public boolean tieneFichas() {
        return !mano.isEmpty();
    }


    public void sumarPuntosEnMano() {
        puntuacion = puntuacion + getPuntosEnMano();
    }

    public void recibirFichas(ArrayList<Ficha> fichasRecibidas) {
        for (int i = 0; i < fichasRecibidas.size(); i++) {
            mano.add(fichasRecibidas.get(i));
        }
        hacerInvisible();
        acomodarFichas();
        hacerVisible();

    }

    public void borrarMano() {
        mano.clear();
    }

    public Ficha colocarFicha(int posicion) {
        return mano.remove(posicion);
    }

    public boolean tieneDobleSeis() {
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).getCara1() == 6 && mano.get(i).getCara2() == 6) {
                return true;
            }
        }
        return false;
    }

    public int getDobleMasAlto() {
        int dobleMasAlto = 0;
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).esDoble()) {
                if (mano.get(i).getCara1() > dobleMasAlto) {
                    dobleMasAlto = mano.get(i).getCara1();
                }
            }
        }
        return dobleMasAlto;
    }

    public boolean tieneDoble(){
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).esDoble()) {
                return true;
            }
        }
        return false;
    }

    public int getValorDeFichaMasAlta() {
        int valorMasAlto = 0;
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).getPuntosTotales() > valorMasAlto) {
                valorMasAlto = mano.get(i).getPuntosTotales();
            }

        }
        return valorMasAlto;
    }

    public void imprimirMano() {
        acomodarFichas();
        hacerVisible();
        for (int i = 0; i < mano.size(); i++) {
            System.out.println(mano.get(i).toString());
        }
    }

    public Ficha colocarFichaInicial(){
        Ficha ficha = null;
        boolean encontrado = false;
        int dobleMasAlta = 0;
        if(tieneDobleSeis()){
            for (int i = 0; i < mano.size(); i++) {
                if (mano.get(i).getCara1() == 6 && mano.get(i).getCara2() == 6) {
                    ficha = mano.remove(i);
                    encontrado = true;
                }
            }
        }
        else if(tieneDoble() && !encontrado){
            for (int i = 0; i < mano.size(); i++) {
                if (mano.get(i).esDoble() && mano.get(i).getCara1() > dobleMasAlta) {
                    dobleMasAlta = mano.get(i).getCara1();
                    ficha = mano.remove(i);
                    encontrado = true;
                }
            }
        }
        else if (!encontrado){
            for (int i = 0; i < mano.size(); i++) {
                if (dobleMasAlta == mano.get(i).getPuntosTotales()) {
                    ficha = mano.remove(i);
                    encontrado = true;
                }
            }
        }
    return ficha;
    }


    public Ficha getFicha(int ficha) {
        return mano.get(ficha);
    }

    public int getManoSize() {
        return mano.size();
    }

    public void acomodarFichas() {
        for (int i = 0; i < mano.size(); i++) {
            mano.get(i).mover(20 + (i * 75), 370);
        }
    }

    public void hacerVisible() {
        for (int i = 0; i < mano.size(); i++) {
            mano.get(i).mostrar();
        }
    }

    public void hacerInvisible() {
        for (int i = 0; i < mano.size(); i++) {
            mano.get(i).ocultar();
        }
    }

}
