package ventanas;

import aplicacion.Aplicacion;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 * @author mivap
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private Aplicacion app;  
    
    public VentanaPrincipal(Aplicacion app) {
        initComponents();
        
        setSize(1440, 810);               
        setLocationRelativeTo(null);

        this.app=app;
        
        nombre_admin.setText(app.getNombreAdmin());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ventanaPrincipal = new javax.swing.JPanel();
        panel_izquierda = new javax.swing.JPanel();
        imagen_logo = new javax.swing.JLabel();
        nombre_app = new javax.swing.JLabel();
        nombre_admin = new javax.swing.JLabel();
        boton_salir = new javax.swing.JButton();
        boton_minimizar = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel_ventanaPrincipal.setBackground(new java.awt.Color(240, 239, 240));
        panel_ventanaPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panel_ventanaPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        panel_ventanaPrincipal.setMinimumSize(new java.awt.Dimension(1420, 810));
        panel_ventanaPrincipal.setPreferredSize(new java.awt.Dimension(1440, 810));
        panel_ventanaPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_izquierda.setBackground(new java.awt.Color(26, 64, 95));
        panel_izquierda.setMinimumSize(new java.awt.Dimension(210, 326));
        panel_izquierda.setPreferredSize(new java.awt.Dimension(210, 810));
        panel_izquierda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagen_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp_icono.jpg"))); // NOI18N
        panel_izquierda.add(imagen_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 31, 32));

        nombre_app.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        nombre_app.setForeground(new java.awt.Color(255, 255, 255));
        nombre_app.setText("InciApp");
        panel_izquierda.add(nombre_app, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 6, -1, -1));

        nombre_admin.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        nombre_admin.setForeground(new java.awt.Color(255, 255, 255));
        nombre_admin.setText("InciApp");
        panel_izquierda.add(nombre_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 35, -1, -1));

        panel_ventanaPrincipal.add(panel_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 810));

        boton_salir.setBackground(new java.awt.Color(0, 0, 51));
        boton_salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_salir.setForeground(new java.awt.Color(255, 255, 255));
        boton_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_cerrar_ventana.png"))); // NOI18N
        boton_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_salirMouseExited(evt);
            }
        });
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });
        panel_ventanaPrincipal.add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 10, 30, 30));

        boton_minimizar.setBackground(new java.awt.Color(0, 0, 51));
        boton_minimizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_minimizar.setForeground(new java.awt.Color(255, 255, 255));
        boton_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_minimizar_ventana.png"))); // NOI18N
        boton_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_minimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_minimizarMouseExited(evt);
            }
        });
        panel_ventanaPrincipal.add(boton_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, 30, 30));

        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.setPreferredSize(new java.awt.Dimension(1380, 30));
        menu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuMouseDragged(evt);
            }
        });
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuMousePressed(evt);
            }
        });
        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_ventanaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_ventanaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //      MOVER VENTANA
    int xx, xy;
    private void menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_menuMousePressed

    private void menuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_menuMouseDragged

    //      BOTON MINIMIZAR
    private void boton_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseExited
        Border border_boton = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        boton_minimizar.setBorder(border_boton);
    }//GEN-LAST:event_boton_minimizarMouseExited

    private void boton_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseEntered
        Border border_boton = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
        boton_minimizar.setBorder(border_boton);
    }//GEN-LAST:event_boton_minimizarMouseEntered

    private void boton_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_boton_minimizarMouseClicked

    //      BOTON SALIR
    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_boton_salirActionPerformed

    private void boton_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_salirMouseExited
        Border border_boton = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        boton_salir.setBorder(border_boton);
    }//GEN-LAST:event_boton_salirMouseExited

    private void boton_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_salirMouseEntered
        Border border_boton = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
        boton_salir.setBorder(border_boton);
    }//GEN-LAST:event_boton_salirMouseEntered


    //      METODOS

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_minimizar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel nombre_admin;
    private javax.swing.JLabel nombre_app;
    private javax.swing.JPanel panel_izquierda;
    private javax.swing.JPanel panel_ventanaPrincipal;
    // End of variables declaration//GEN-END:variables
}

