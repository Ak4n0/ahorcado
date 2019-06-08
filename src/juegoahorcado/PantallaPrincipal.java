package juegoahorcado;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Miquel A. Fuster
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    ImageIcon[] imgIntentos = new ImageIcon[7];
    String[] titulosPelicula = { "alguien volo sobre el nido del cuco",
                                 "la caza del octubre rojo",
                                 "los diez mandamientos",
                                 "el bueno, el feo y el malo",
                                 "la vida de bryan",
                                 "los caballeros de la mesa cuadrada",
                                 "buscando a nemo",
                                 "el señor de los anillos",
                                 "pulp fiction",
                                 "la lista de schindler",
                                 "el nombre de la rosa",
                                 "la guerra de las galaxias",
                                 "el padrino",
                                 "lawrence de arabia",
                                 "con faldas y a lo loco",
                                 "centauros del desierto",
                                 "cantando bajo la lluvia",
                                 "la novia de frankenstein",
                                 "metropolis" };
    
    String[] listaEnJuego;
    int indiceActual;
    int indiceFinal;
                                 
    
    String textoOculto;
    String letrasIntroducidas;
    StringBuilder cadenaResultado;
    
    int fallos;
    
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        for(int i = 0; i < 7; ++i) {
            imgIntentos[i] = new ImageIcon("imagenes/imagen" + (i+1) + ".gif");
        }
        
        initComponents();
        reiniciarJuego(true);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        panelIzquierdo = new javax.swing.JPanel();
        panelDibujo = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        panelDerecho = new javax.swing.JPanel();
        lblInformacion = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();
        lblFraseOculta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego del ahorcado");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        panelBase.setLayout(new java.awt.GridLayout(1, 2));

        panelIzquierdo.setBackground(new java.awt.Color(255, 255, 255));
        panelIzquierdo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelIzquierdo.setLayout(new java.awt.BorderLayout());

        panelDibujo.setBackground(new java.awt.Color(255, 255, 255));
        panelDibujo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDibujo.setLayout(new java.awt.BorderLayout());

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(imgIntentos[0]);
        lblImagen.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelDibujo.add(lblImagen, java.awt.BorderLayout.CENTER);

        panelIzquierdo.add(panelDibujo, java.awt.BorderLayout.CENTER);

        panelBase.add(panelIzquierdo);

        panelDerecho.setBackground(new java.awt.Color(255, 255, 255));
        panelDerecho.setLayout(new java.awt.BorderLayout());

        lblInformacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblInformacion.setForeground(new java.awt.Color(0, 0, 255));
        lblInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInformacion.setText("Letras:");
        panelDerecho.add(lblInformacion, java.awt.BorderLayout.CENTER);

        panelBase.add(panelDerecho);

        getContentPane().add(panelBase, java.awt.BorderLayout.CENTER);

        panelInferior.setBackground(new java.awt.Color(255, 255, 255));
        panelInferior.setLayout(new java.awt.BorderLayout());

        lblFraseOculta.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblFraseOculta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFraseOculta.setText("jLabel1");
        lblFraseOculta.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelInferior.add(lblFraseOculta, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelInferior, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        char letra = evt.getKeyChar();
        letra = Character.toUpperCase(letra);
        
        // Si el carácter recibido no es letra no se contabiliza
        if(!Character.isLetter(letra))
            return;
        
        // Si el carácter ya ha sido introducido no se contabiliza
        
        if(letrasIntroducidas.indexOf(letra) != -1)
            return;
        
        // No se ha introducido...
        // Añadirla a la lista de letras introducidas
        letrasIntroducidas += letra;
        lblInformacion.setText(lblInformacion.getText() + " " + letra);
        
        boolean existeLetra = false;
        for(int i = 0; i < textoOculto.length(); ++i) {
            if(textoOculto.charAt(i) == letra) {
                existeLetra = true;
                cadenaResultado.setCharAt(i, letra);
            }
        }
        
        if(existeLetra) {
            actualizarLabelFraseOculta();
            comprobarSiGana();
        } else {
            ocurrioFallo();
        }
    }//GEN-LAST:event_formKeyTyped

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    private void reiniciarJuego(boolean reinicioCompleto) {
        if(reinicioCompleto) {
            listaEnJuego = titulosPelicula.clone();
            indiceFinal = listaEnJuego.length;
        }
        else {
            indiceFinal--;
            if(indiceFinal == 0) {
                int opcion = JOptionPane.showOptionDialog(null, "¡Enhorabuena! Ha acertado todas las películas. ¿Qué desea hacer?", "Fin de partida", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[] {"Jugar de nuevo", "Salir"}, null);
                if(opcion == 1)
                    System.exit(0);
                reiniciarJuego(true);
                return;
            }
            
            listaEnJuego[indiceActual] = listaEnJuego[indiceFinal];
        }
        
        indiceActual = (int)(Math.random() * indiceFinal);
        textoOculto = listaEnJuego[indiceActual].toUpperCase();
        letrasIntroducidas = "";
        
        lblInformacion.setText("Letras: ");
        lblImagen.setIcon(imgIntentos[0]);
        fallos = 0;
        
        reiniciarCadenaResultado();
    }
    
    private void reiniciarCadenaResultado() {
        cadenaResultado = new StringBuilder(textoOculto.length());
        for(int i = 0; i < textoOculto.length(); ++i) {
            cadenaResultado.append(Character.isLetter(textoOculto.charAt(i))? '_' : textoOculto.charAt(i));
        }
        
        actualizarLabelFraseOculta();
    }
    
    private void actualizarLabelFraseOculta() {
        String nuevaCadena = "";
        int i;
        for(i = 0; i < cadenaResultado.length()-1; ++i) {
            nuevaCadena += cadenaResultado.charAt(i) + " ";
        }
        nuevaCadena += cadenaResultado.charAt(i);
        
        lblFraseOculta.setText(nuevaCadena);
    }
    
    private void ocurrioFallo() {
        fallos++;
        if(fallos < 7)
            lblImagen.setIcon(imgIntentos[fallos]);
        if(fallos == 6) {
            JOptionPane.showMessageDialog(null, "Ha perdido", "Fin del juego", JOptionPane.ERROR_MESSAGE);
            reiniciarJuego(true);
        }
    }
    
    private void comprobarSiGana() {
        if(cadenaResultado.indexOf("_") == -1) {
            JOptionPane.showMessageDialog(null, "Ha ganado", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            reiniciarJuego(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblFraseOculta;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelDibujo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelIzquierdo;
    // End of variables declaration//GEN-END:variables
}
