package lab3_datos2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Animacion extends JPanel {

    VentanaAnimacion ventana;
    int filas;
    int columnas;
    int ancho;
    int alto;

    public Animacion(VentanaAnimacion ventana, int filas, int columnas) {
        this.ventana = ventana;
        this.filas = filas;
        this.columnas = columnas;
        this.ancho = 980 / columnas - 4;
        this.alto = 680 / filas - 6;
        this.setBackground(Color.blue);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (ventana.getTablero(i, j) == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                } else if (ventana.getTablero(i, j) == 1) {
                    g.setColor(Color.red);
                } else if (ventana.getTablero(i, j) == 2) {
                    g.setColor(Color.yellow);
                }

                g.fillOval(j * ancho, 20 + i * alto, ancho - 5, alto - 7);
            }
        }
        repaint();
    }

    int getAncho() {
        return ancho;
    }
}
