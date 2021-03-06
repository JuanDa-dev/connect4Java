package lab3_datos2;

import javax.swing.JOptionPane;

public class VentanaAnimacion extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAnimacion
     */
    Animacion animacion;
    int[][] tablero;
    int filas;
    int columnas;
    int jugActivo;
    int turno;
    long tiempoI1;
    long tiempoF1;
    long tiempoI2;
    long tiempoF2;
    double totalT1;
    double totalT2;

    public VentanaAnimacion(int filas, int columnas) {
        initComponents();
        jugActivo = 1;
        jugActivoLabel.setText(jugActivo + "");
        turno = 1;
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new int[filas][columnas];
        this.llenarMatriz(tablero, filas, columnas);
        animacion = new Animacion(this, filas, columnas);
        animacion.setBounds(0, 0, this.getWidth() - 300, this.getHeight());
        this.add(animacion);
        contarTiempo(jugActivo, 0);
    }

    public int getTablero(int i, int j) {
        return tablero[i][j];
    }

    private void llenarMatriz(int[][] m, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                m[i][j] = 0;
            }
        }
    }

    private void agregarFicha(int j) {
        for (int i = filas - 1; i >= 0; i--) {
            if (tablero[i][j] == 0) {
                tablero[i][j] = jugActivo;
                break;
            }
        }
    }

    boolean buscarGanador() {
        //check for 4 across
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (tablero[i][j] == jugActivo
                        && tablero[i][j + 1] == jugActivo
                        && tablero[i][j + 2] == jugActivo
                        && tablero[i][j + 3] == jugActivo) {
                    return true;
                }
            }
        }
        //check for 4 up and down
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == jugActivo
                        && tablero[i + 1][j] == jugActivo
                        && tablero[i + 2][j] == jugActivo
                        && tablero[i + 3][j] == jugActivo) {
                    return true;
                }
            }
        }
        //check upward diagonal
        for (int i = 3; i < tablero.length; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (tablero[i][j] == jugActivo
                        && tablero[i - 1][j + 1] == jugActivo
                        && tablero[i - 2][j + 2] == jugActivo
                        && tablero[i - 3][j + 3] == jugActivo) {
                    return true;
                }
            }
        }
        //check downward diagonal
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 0; j < tablero[0].length - 3; j++) {
                if (tablero[i][j] == jugActivo
                        && tablero[i + 1][j + 1] == jugActivo
                        && tablero[i + 2][j + 2] == jugActivo
                        && tablero[i + 3][j + 3] == jugActivo) {
                    return true;
                }
            }
        }
        return false;
    }

    private void contarTiempo(int jugActivo, int i) {
        if (i == 0) {
            if (jugActivo == 1) {
                tiempoI1 = System.nanoTime();
            } else {
                tiempoI2 = System.nanoTime();
            }
        } else {
            if (jugActivo == 1) {
                tiempoF1 = System.nanoTime();
                totalT1 = (double) (tiempoF1 - tiempoI1) / 1_000_000_000;
                tiempo1Label.setText(totalT1 + "");
            } else {
                tiempoF2 = System.nanoTime();
                totalT2 = (double) (tiempoF2 - tiempoI2) / 1_000_000_000;
                tiempo2Label.setText(totalT2 + "");
                if (totalT1 > totalT2) {
                    jugMasRapidoLabel.setText("2");
                } else {
                    jugMasRapidoLabel.setText("1");
                }
            }
        }
    }

    private VentanaAnimacion() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FinJuego = new javax.swing.JDialog(this, true);
        jLabel3 = new javax.swing.JLabel();
        juegoTerminadoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jugActivoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jugMasRapidoLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tiempo1Label = new javax.swing.JLabel();
        tiempo2Label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        salirbtn = new javax.swing.JButton();

        FinJuego.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        FinJuego.setTitle("Fin del Juego");
        FinJuego.setLocation(new java.awt.Point(285, 50));
        FinJuego.setResizable(false);
        FinJuego.setSize(new java.awt.Dimension(500, 400));
        FinJuego.getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Juego terminado");
        FinJuego.getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 20, 330, 50);

        juegoTerminadoLabel.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        juegoTerminadoLabel.setForeground(new java.awt.Color(255, 255, 255));
        FinJuego.getContentPane().add(juegoTerminadoLabel);
        juegoTerminadoLabel.setBounds(40, 120, 410, 80);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Volver al men??");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        FinJuego.getContentPane().add(jButton1);
        jButton1.setBounds(150, 270, 182, 69);

        jPanel2.setBackground(new java.awt.Color(117, 28, 159));
        FinJuego.getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 490, 390);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 710));
        setPreferredSize(new java.awt.Dimension(1280, 710));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 700));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(117, 28, 159));

        jugActivoLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jugActivoLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jugador m??s rapido:");

        jugMasRapidoLabel.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jugMasRapidoLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tiempo Jugador 1");

        tiempo1Label.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        tiempo1Label.setForeground(new java.awt.Color(255, 255, 255));

        tiempo2Label.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        tiempo2Label.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tiempo Jugador 2:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jugador activo:");

        salirbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salirbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab3_datos2/Assets/icons8-exit-40.png"))); // NOI18N
        salirbtn.setText("Salir");
        salirbtn.setFocusable(false);
        salirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salirbtn)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(41, 41, 41))
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tiempo1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jugMasRapidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(tiempo2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jugActivoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jugActivoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jugMasRapidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(tiempo1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(tiempo2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(960, 0, 330, 690);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            if (evt.getX() < animacion.getWidth()) {
                for (int j = 0; j < columnas; j++) {
                    if (evt.getX() >= j * animacion.getAncho() && evt.getX() < (j + 1) * animacion.getAncho()) {
                        if (tablero[0][j] != 0) {
                            JOptionPane.showMessageDialog(null, "Columna llena!");
                        } else {
                            agregarFicha(j);
                            contarTiempo(jugActivo, 1);
                            if (!buscarGanador()) {
                                if (jugActivo == 1) {
                                    jugActivo = 2;
                                } else {
                                    jugActivo = 1;
                                }
                                jugActivoLabel.setText(jugActivo + "");
                                contarTiempo(jugActivo, 0);
                                turno++;
                                break;
                            } else {
                                juegoTerminadoLabel.setText("El jugador " + jugActivo + " gan??");
                                FinJuego.setVisible(true);
                            }
                        }
                    }
                }

            }
            if (turno == filas * columnas + 1) {
                juegoTerminadoLabel.setText("Hubo un empate");
                FinJuego.setVisible(true);
            }
        }
    }//GEN-LAST:event_formMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MenuInicial menuInicial = new MenuInicial();
        menuInicial.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void salirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirbtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MenuInicial menuInicial = new MenuInicial();
        menuInicial.setVisible(true);
    }//GEN-LAST:event_salirbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAnimacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog FinJuego;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel juegoTerminadoLabel;
    private javax.swing.JLabel jugActivoLabel;
    private javax.swing.JLabel jugMasRapidoLabel;
    private javax.swing.JButton salirbtn;
    private javax.swing.JLabel tiempo1Label;
    private javax.swing.JLabel tiempo2Label;
    // End of variables declaration//GEN-END:variables

}
