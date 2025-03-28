
/**
 * Write a description of class Ficha here.
 *
 * @author Julian Pasos
 * @version 1
 */
public class Ficha {
    private boolean esHorizontal;
    private boolean caraArriba;
    private CaraView caraView1, caraView2;
    private int xPosition, yPosition;

    // Constructor para inicializar la ficha con dos valores
    public Ficha(int cara1, int cara2) {
        esHorizontal = false;
        caraArriba = true;  // Por defecto, la ficha está cara arriba
        this.xPosition = 20;
        this.yPosition = 20;
        caraView1 = new CaraView(xPosition, yPosition, cara1);
        caraView2 = new CaraView(xPosition + 70, yPosition, cara2);


    }

    public int getCara1() {
        return caraView1.getValor();
    }

    public int getCara2() {
        return caraView2.getValor();
    }

    public void mostrar() {
        if (esHorizontal) {
            caraView1.move(xPosition, yPosition);
            caraView2.move(xPosition + 70, yPosition);
        } else {
            caraView1.move(xPosition, yPosition);
            caraView2.move(xPosition, yPosition + 70);
        }
    }

    public void ocultar() {
        caraView1.erase();
        caraView2.erase();
    }

    public void girar180() {
        int temp = caraView1.getValor();
        caraView1.setValor(caraView2.getValor());
        caraView2.setValor(temp);
    }

    public void girar90() {
        esHorizontal = !esHorizontal;
    }

    public void setVertical() {
        esHorizontal = false;
    }

    public void voltear() {
        caraArriba = !caraArriba;
        caraView1.flip();
        caraView2.flip();
    }

    public boolean esDoble() {
        return caraView1.getValor() == caraView2.getValor();
    }

    public void mover(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        mostrar();
    }

    public int getPuntosTotales() {
        return caraView1.getValor() + caraView2.getValor();
    }

    public String toString() {
        return "[" + caraView1.getValor() + "|" + caraView2.getValor() + "]";
    }


    public void setHorizontal() {
        esHorizontal = true;
    }
}