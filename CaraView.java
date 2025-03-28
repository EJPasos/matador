
/**
 * Write a description of class DadoView here.
 *
 * @author Julian Pasos
 * @version 2020.09.01
 */
public class CaraView {
    private int valor;
    private int coordenadaX;
    private int coordenadaY;
    private Square Fondo, Contorno;
    private Circle punto1, punto2, punto3, punto4, punto5, punto6, punto7, punto8, punto9;
    private int size;
    private boolean faceUp, rotated;

    public CaraView() {
        faceUp = true;
        rotated = false;
        valor = 6;
        coordenadaX = 50;
        coordenadaY = 50;
        size = 70;
        Fondo = new Square(size - 8, coordenadaX + 4, coordenadaY + 4, "white");
        Contorno = new Square(size, coordenadaX, coordenadaY, "black");

        crearPuntos();

        dibujar();
    }

    public CaraView(int coordenadaX, int coordenadaY, int valor) {
        faceUp = true;
        rotated = false;
        this.valor = valor;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.size = 70;

        Fondo = new Square(size - 8, coordenadaX + 4, coordenadaY + 4, "white");
        Contorno = new Square(size, coordenadaX, coordenadaY, "black");

        crearPuntos();
    }

    public void crearPuntos() {
        int dotSize = size / 8;
        punto1 = new Circle(dotSize, coordenadaX + (size / 9), coordenadaY + (size / 9));
        punto2 = new Circle(dotSize, coordenadaX + (size / 9), coordenadaY + (4 * size / 9));
        punto3 = new Circle(dotSize, coordenadaX + (size / 9), coordenadaY + (7 * size / 9));
        punto4 = new Circle(dotSize, coordenadaX + (4 * size / 9), coordenadaY + (4 * size / 9));
        punto5 = new Circle(dotSize, coordenadaX + (7 * size / 9), coordenadaY + (size / 9));
        punto6 = new Circle(dotSize, coordenadaX + (7 * size / 9), coordenadaY + (4 * size / 9));
        punto7 = new Circle(dotSize, coordenadaX + (7 * size / 9), coordenadaY + (7 * size / 9));
        punto8 = new Circle(dotSize, coordenadaX + (4 * size / 9), coordenadaY + (size / 9));
        punto9 = new Circle(dotSize, coordenadaX + (4 * size / 9), coordenadaY + (7 * size / 9));
        cambiarColorPuntos();
    }

    public String colorString() {
        String color = "";
        switch (valor) {
            case 1:
                color = "black";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "blue";
                break;
            case 4:
                color = "yellow";
                break;
            case 5:
                color = "green";
                break;
            case 6:
                color = "magenta";
                break;
            case 7:
                color = "orange";
                break;
            case 8:
                color = "cyan";
                break;
            case 9:
                color = "pink";
                break;
        }
        return color;
    }

    public int getValor() {
        return valor;
    }

    public void cambiarColorPuntos() {
        punto1.changeColor(colorString());
        punto2.changeColor(colorString());
        punto3.changeColor(colorString());
        punto4.changeColor(colorString());
        punto5.changeColor(colorString());
        punto6.changeColor(colorString());
        punto7.changeColor(colorString());
        punto8.changeColor(colorString());
        punto9.changeColor(colorString());
    }

    public void setValor(int valor) {
        this.valor = valor;
        cambiarColorPuntos();
    }

    public void dibujar() {
        Contorno.makeVisible();
        if (faceUp) {
            Fondo.makeVisible();
        } else {
            Fondo.makeInvisible();
        }
        mostrarPuntos();
    }


    public void rotar() {
        rotated = !rotated;
        dibujar();
    }

    public void mostrarPuntos() {
        punto1.makeInvisible();
        punto2.makeInvisible();
        punto3.makeInvisible();
        punto4.makeInvisible();
        punto5.makeInvisible();
        punto6.makeInvisible();
        punto7.makeInvisible();
        punto8.makeInvisible();
        punto9.makeInvisible();
        if (faceUp) {

            switch (valor) {

                case 0:

                    break;
                case 1:

                    punto4.makeVisible();

                    break;
                case 2:

                    if (!rotated) {
                        punto1.makeVisible();

                        punto7.makeVisible();

                    } else {

                        punto3.makeVisible();

                        punto5.makeVisible();

                    }

                    break;
                case 3:

                    if (!rotated) {
                        punto1.makeVisible();

                        punto4.makeVisible();

                        punto7.makeVisible();

                    } else {

                        punto3.makeVisible();
                        punto4.makeVisible();
                        punto5.makeVisible();

                    }
                    break;
                case 4:

                    punto1.makeVisible();

                    punto3.makeVisible();

                    punto5.makeVisible();

                    punto7.makeVisible();

                    break;
                case 5:
                    punto1.makeVisible();

                    punto3.makeVisible();
                    punto4.makeVisible();
                    punto5.makeVisible();

                    punto7.makeVisible();

                    break;
                case 6:


                    if (!rotated) {
                        punto1.makeVisible();
                        punto2.makeVisible();
                        punto3.makeVisible();

                        punto5.makeVisible();
                        punto6.makeVisible();
                        punto7.makeVisible();

                    } else {
                        punto1.makeVisible();

                        punto3.makeVisible();

                        punto5.makeVisible();

                        punto7.makeVisible();
                        punto8.makeVisible();
                        punto9.makeVisible();
                    }
                    break;
                case 7:


                    if (!rotated) {
                        punto1.makeVisible();
                        punto2.makeVisible();
                        punto3.makeVisible();
                        punto4.makeVisible();
                        punto5.makeVisible();
                        punto6.makeVisible();
                        punto7.makeVisible();

                    } else {
                        punto1.makeVisible();

                        punto3.makeVisible();
                        punto4.makeVisible();
                        punto5.makeVisible();

                        punto7.makeVisible();
                        punto8.makeVisible();
                        punto9.makeVisible();
                    }
                    break;
                case 8:

                    punto1.makeVisible();
                    punto2.makeVisible();
                    punto3.makeVisible();

                    punto5.makeVisible();
                    punto6.makeVisible();
                    punto7.makeVisible();
                    punto8.makeVisible();
                    punto9.makeVisible();
                    break;
                case 9:

                    punto1.makeVisible();
                    punto2.makeVisible();
                    punto3.makeVisible();
                    punto4.makeVisible();
                    punto5.makeVisible();
                    punto6.makeVisible();
                    punto7.makeVisible();
                    punto8.makeVisible();
                    punto9.makeVisible();
                    break;
            }
        }
    }

    public void move(int X, int Y) {
        this.coordenadaX = X;
        this.coordenadaY = Y;

        // Mover el contorno y el fondo del dado
        Contorno.setPosition(coordenadaX, coordenadaY);
        Fondo.setPosition(coordenadaX + 4, coordenadaY + 4);

        // Mover los puntos (círculos) del dado
        punto1.setPosition(coordenadaX + (size / 9), coordenadaY + (size / 9));
        punto2.setPosition(coordenadaX + (size / 9), coordenadaY + (4 * size / 9));
        punto3.setPosition(coordenadaX + (size / 9), coordenadaY + (7 * size / 9));
        punto4.setPosition(coordenadaX + (4 * size / 9), coordenadaY + (4 * size / 9));
        punto5.setPosition(coordenadaX + (7 * size / 9), coordenadaY + (size / 9));
        punto6.setPosition(coordenadaX + (7 * size / 9), coordenadaY + (4 * size / 9));
        punto7.setPosition(coordenadaX + (7 * size / 9), coordenadaY + (7 * size / 9));
        punto8.setPosition(coordenadaX + (4 * size / 9), coordenadaY + (size / 9));
        punto9.setPosition(coordenadaX + (4 * size / 9), coordenadaY + (7 * size / 9));

        // Redibujar el dado
        dibujar();
    }

    public void changeSize(int newSize) {
        size = newSize;

        int dotSize = size / 8;
        Contorno.setSize(size);
        Fondo.setSize(size - 8);

        //debemos cambiar la posicion de los puntos porque esta basada el tamano
        punto1.setPosition(coordenadaX + (size / 9), coordenadaY + (size / 9));
        punto2.setPosition(coordenadaX + (size / 9), coordenadaY + (4 * size / 9));
        punto3.setPosition(coordenadaX + (size / 9), coordenadaY + (7 * size / 9));
        punto4.setPosition(coordenadaX + (4 * size / 9), coordenadaY + (4 * size / 9));
        punto5.setPosition(coordenadaX + (7 * size / 9), coordenadaY + (size / 9));
        punto6.setPosition(coordenadaX + (7 * size / 9), coordenadaY + (4 * size / 9));
        punto7.setPosition(coordenadaX + (7 * size / 9), coordenadaY + (7 * size / 9));

        punto1.setDiameter(dotSize);
        punto2.setDiameter(dotSize);
        punto3.setDiameter(dotSize);
        punto4.setDiameter(dotSize);
        punto5.setDiameter(dotSize);
        punto6.setDiameter(dotSize);
        punto7.setDiameter(dotSize);
        punto8.setDiameter(dotSize);
        punto9.setDiameter(dotSize);

        dibujar();
    }

    public void erase() {
        Contorno.makeInvisible();
        Fondo.makeInvisible();
        punto1.makeInvisible();
        punto2.makeInvisible();
        punto3.makeInvisible();
        punto4.makeInvisible();
        punto5.makeInvisible();
        punto6.makeInvisible();
        punto7.makeInvisible();
        punto8.makeInvisible();
        punto9.makeInvisible();
    }

    public void flip() {
        faceUp = !faceUp;
        dibujar();
    }


}
