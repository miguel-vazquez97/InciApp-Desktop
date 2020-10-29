package ventanas;

import aplicacion.Aplicacion;
import aplicacion.RowTablaIncidencia;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author mivap
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private Aplicacion app;  
    protected Properties properties;
    protected InputStream leerArchivo;
    
    protected DefaultTableModel modelo;
    protected ArrayList<RowTablaIncidencia> arrayIncidencias;
    protected String[] nombreTipos;
    
    protected String respuestaServidor;
    protected String[] resServidor; 
    
    private static final int INCIDENCIAS_NUEVAS = 0;
    private static final int INCIDENCIAS_VALIDADAS = 1;
    private static final int INCIDENCIAS_ARREGLADAS = 2;
    private static final int HISTORIAL_INCIDENCIAS = 3;
    private int stateIncidencias = INCIDENCIAS_NUEVAS;
    
    public VentanaPrincipal(Aplicacion app) {
        initComponents();
        
        setSize(1440, 810);               
        setLocationRelativeTo(null);
        
        this.app=app;
        properties = new Properties();
        
        nombre_admin.setText(app.getNombreAdmin());
        
        titulo.setText("NUEVAS INCIDENCIAS");
        boton_refrescar.setBorder(new RoundedBorder(40)); 
        progressBar.setVisible(false);
        
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };     
        modelo.addColumn("Fecha");
        modelo.addColumn("Tipo");
        modelo.addColumn("Descripción");
        modelo.addColumn("Dirección");
        
        //tabla_datos.setRowSelectionAllowed(true);
        //tabla_datos.setColumnSelectionAllowed(false);
        
        tabla_datos.setModel(modelo);
        tabla_datos.setRowHeight(30);
        JTableHeader header = tabla_datos.getTableHeader();
        header.setBackground(new java.awt.Color(26,64,95));
        header.setForeground(Color.white);
        header.setFont(new Font("Dialog", Font.BOLD, 20));
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tabla_datos.setTableHeader(header);        
        header.setCursor(new Cursor(HAND_CURSOR));
        tabla_datos.setAutoCreateRowSorter(true);
        
        tabla_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
            JTable table =(JTable) me.getSource();
            //Point p = me.getPoint();
            //int row = table.rowAtPoint(p);
            if (me.getClickCount() == 2) {
                int linea = table.getSelectedRow();
                int idIncidencia = arrayIncidencias.get(linea).getId();                
                //String codigo = table.getValueAt(linea, 0).toString();
                //System.out.println(codigo);
                //Llamamos a la ventana que nos traera el los detalles de la incidencia
                switch(stateIncidencias){
                    case 0:
                        VentanaNuevasIncidencias ventanaNI = new VentanaNuevasIncidencias(VentanaPrincipal.this, true, app, idIncidencia);
                        ventanaNI.setVisible(true);
                        break;
                        
                    case 1:
                        System.out.println("Incidencia Validada");
                        break; 
                        
                    case 2:
                        System.out.println("Incidencia Arreglada");
                        break;
                        
                    case 3:
                        System.out.println("Hisotiral Incidencias");
                        break;
                }
             }
         }
        });

        mostrarDatosTabla();  

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ventanaPrincipal = new javax.swing.JPanel();
        panel_izquierda = new javax.swing.JPanel();
        imagen_logo = new javax.swing.JLabel();
        nombre_app = new javax.swing.JLabel();
        nombre_admin = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        panel_NI = new javax.swing.JPanel();
        label_NR = new javax.swing.JLabel();
        panel_V = new javax.swing.JPanel();
        label_V = new javax.swing.JLabel();
        panel_A = new javax.swing.JPanel();
        label_A = new javax.swing.JLabel();
        panel_H = new javax.swing.JPanel();
        label_H = new javax.swing.JLabel();
        boton_salir = new javax.swing.JButton();
        boton_minimizar = new javax.swing.JButton();
        separador_titulo_up = new javax.swing.JSeparator();
        titulo = new javax.swing.JLabel();
        separador_titulo_down = new javax.swing.JSeparator();
        boton_refrescar = new javax.swing.JButton();
        progressBar = new rojerusan.componentes.RSProgressMaterial();
        scrollpane_tabla = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();
        menu = new javax.swing.JMenuBar();
        cerrarsesion_menu = new javax.swing.JMenu();
        cerrarsesion_opciones = new javax.swing.JMenuItem();

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

        jSeparator2.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, 190, 2));

        jSeparator1.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 190, 2));

        jSeparator3.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 334, 190, 2));

        panel_NI.setBackground(new java.awt.Color(26, 64, 95));
        panel_NI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_NI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_NIMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_NIMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_NIMouseExited(evt);
            }
        });

        label_NR.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_NR.setForeground(new java.awt.Color(255, 255, 255));
        label_NR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_NR.setText("Nuevas incidencias");
        label_NR.setMinimumSize(new java.awt.Dimension(207, 26));
        label_NR.setPreferredSize(new java.awt.Dimension(207, 26));

        javax.swing.GroupLayout panel_NILayout = new javax.swing.GroupLayout(panel_NI);
        panel_NI.setLayout(panel_NILayout);
        panel_NILayout.setHorizontalGroup(
            panel_NILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_NILayout.createSequentialGroup()
                .addComponent(label_NR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        panel_NILayout.setVerticalGroup(
            panel_NILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_NILayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(label_NR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panel_izquierda.add(panel_NI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 210, 60));

        panel_V.setBackground(new java.awt.Color(26, 64, 95));
        panel_V.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_VMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_VMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_VMouseExited(evt);
            }
        });

        label_V.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_V.setForeground(new java.awt.Color(255, 255, 255));
        label_V.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_V.setText("Validadas");

        javax.swing.GroupLayout panel_VLayout = new javax.swing.GroupLayout(panel_V);
        panel_V.setLayout(panel_VLayout);
        panel_VLayout.setHorizontalGroup(
            panel_VLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_V, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        panel_VLayout.setVerticalGroup(
            panel_VLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_VLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(label_V)
                .addGap(15, 15, 15))
        );

        panel_izquierda.add(panel_V, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 212, 210, 60));

        panel_A.setBackground(new java.awt.Color(26, 64, 95));
        panel_A.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_AMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_AMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_AMouseExited(evt);
            }
        });

        label_A.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_A.setForeground(new java.awt.Color(255, 255, 255));
        label_A.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_A.setText("Arregladas");

        javax.swing.GroupLayout panel_ALayout = new javax.swing.GroupLayout(panel_A);
        panel_A.setLayout(panel_ALayout);
        panel_ALayout.setHorizontalGroup(
            panel_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_A, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        panel_ALayout.setVerticalGroup(
            panel_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ALayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(label_A)
                .addGap(16, 16, 16))
        );

        panel_izquierda.add(panel_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 274, 210, 60));

        panel_H.setBackground(new java.awt.Color(26, 64, 95));
        panel_H.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_HMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_HMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_HMouseExited(evt);
            }
        });

        label_H.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_H.setForeground(new java.awt.Color(255, 255, 255));
        label_H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_H.setText("Historial incidencias");

        javax.swing.GroupLayout panel_HLayout = new javax.swing.GroupLayout(panel_H);
        panel_H.setLayout(panel_HLayout);
        panel_HLayout.setHorizontalGroup(
            panel_HLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_H, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        panel_HLayout.setVerticalGroup(
            panel_HLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_HLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(label_H)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel_izquierda.add(panel_H, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 336, 210, 60));

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

        separador_titulo_up.setBackground(new java.awt.Color(26, 64, 95));
        panel_ventanaPrincipal.add(separador_titulo_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 55, 850, 3));

        titulo.setBackground(new java.awt.Color(26, 64, 95));
        titulo.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        titulo.setForeground(new java.awt.Color(26, 64, 95));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("TITULO");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_ventanaPrincipal.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 60, 850, 80));

        separador_titulo_down.setBackground(new java.awt.Color(26, 64, 95));
        panel_ventanaPrincipal.add(separador_titulo_down, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 145, 850, 3));

        boton_refrescar.setBackground(new java.awt.Color(240, 239, 240));
        boton_refrescar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_refrescar.setForeground(new java.awt.Color(255, 255, 255));
        boton_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh_.png"))); // NOI18N
        boton_refrescar.setBorder(null);
        boton_refrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_refrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_refrescarMouseClicked(evt);
            }
        });
        panel_ventanaPrincipal.add(boton_refrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 250, 35, 35));

        progressBar.setBackground(new java.awt.Color(255, 255, 255));
        progressBar.setForeground(new java.awt.Color(46, 134, 193));
        panel_ventanaPrincipal.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 416, 40, 40));

        tabla_datos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_datos.setRowHeight(20);
        scrollpane_tabla.setViewportView(tabla_datos);

        panel_ventanaPrincipal.add(scrollpane_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 261, 850, 450));

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

        cerrarsesion_menu.setText("Opciones");

        cerrarsesion_opciones.setText("Cerrar sesión");
        cerrarsesion_opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesion_opcionesActionPerformed(evt);
            }
        });
        cerrarsesion_menu.add(cerrarsesion_opciones);

        menu.add(cerrarsesion_menu);

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

    //      BOTON CERRAR SESION
    private void cerrarsesion_opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesion_opcionesActionPerformed
        logOut();
    }//GEN-LAST:event_cerrarsesion_opcionesActionPerformed

    //      PANEL NUEVA INCIDENCIA
    private void panel_NIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_NIMouseClicked
        stateIncidencias = INCIDENCIAS_NUEVAS;
        titulo.setText("NUEVAS INCIDENCIAS");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_NIMouseClicked

    private void panel_NIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_NIMouseEntered
        panel_NI.setBackground(new java.awt.Color(46,134,193));
    }//GEN-LAST:event_panel_NIMouseEntered

    private void panel_NIMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_NIMouseExited
        panel_NI.setBackground(new java.awt.Color(26,64,95));
    }//GEN-LAST:event_panel_NIMouseExited

    //      PANEL INCIDENCIA VALIDADA
    private void panel_VMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_VMouseClicked
        stateIncidencias = INCIDENCIAS_VALIDADAS;
        titulo.setText("INCIDENCIAS VALIDADAS");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_VMouseClicked

    private void panel_VMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_VMouseEntered
        panel_V.setBackground(new java.awt.Color(46,134,193));
    }//GEN-LAST:event_panel_VMouseEntered

    private void panel_VMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_VMouseExited
        panel_V.setBackground(new java.awt.Color(26,64,95));
    }//GEN-LAST:event_panel_VMouseExited

    //      PANEL INCIDENCIA ARREGLADA
    private void panel_AMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_AMouseClicked
        stateIncidencias = INCIDENCIAS_ARREGLADAS;
        titulo.setText("INCIDENCIAS ARREGLADAS");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_AMouseClicked

    private void panel_AMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_AMouseEntered
        panel_A.setBackground(new java.awt.Color(46,134,193));
    }//GEN-LAST:event_panel_AMouseEntered

    private void panel_AMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_AMouseExited
        panel_A.setBackground(new java.awt.Color(26,64,95));
    }//GEN-LAST:event_panel_AMouseExited

    //      PANEL HISTORIAL INCIDENCIAS
    private void panel_HMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_HMouseClicked
        stateIncidencias = HISTORIAL_INCIDENCIAS;
        titulo.setText("HISTORIAL INCIDENCIAS");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_HMouseClicked

    private void panel_HMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_HMouseEntered
        panel_H.setBackground(new java.awt.Color(46,134,193));
    }//GEN-LAST:event_panel_HMouseEntered

    private void panel_HMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_HMouseExited
        panel_H.setBackground(new java.awt.Color(26,64,95));
    }//GEN-LAST:event_panel_HMouseExited

    //      BOTON REFRESCAR TABLA
    private void boton_refrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_refrescarMouseClicked
        mostrarDatosTabla();
    }//GEN-LAST:event_boton_refrescarMouseClicked


    //      METODOS
    
    protected void logOut(){
        
        SwingWorker workerLogOut = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {            

                respuestaServidor = app.protocoloMensajes("3||logOutAdministrador||");
                resServidor = respuestaServidor.split("\\|\\|");
                          
                if(resServidor[0].equals("6") && resServidor[1].equals("logOutAdminOk")){
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                }

                return null;
            }
            
        };   
        
        workerLogOut.execute();           
    }
    
    protected void mostrarDatosTabla(){
            
        SwingWorker workerDatosTabla = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                progressBar.setVisible(true);                

                respuestaServidor = app.protocoloMensajes("4||"+app.getCorreo()+"||"+stateIncidencias+"||");
                resServidor = respuestaServidor.split("\\|\\|");
                          
                if(resServidor[0].equals("7") && resServidor[1].equals("listadoIncidenciasOk")){                    
                    arrayIncidencias = app.getArrayIncidencias();
                    cargarTabla(arrayIncidencias);
                }
                
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Su sesión ha caducado", "¡Sesion finalizada!", 0);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                }
  
                progressBar.setVisible(false);
                return null;
            }
            
        };   
        
        workerDatosTabla.execute();
    }
    
    protected void cargarTabla(ArrayList<RowTablaIncidencia> arrayIncidencias){
        String []datos = new String[4];
        
        int filas = tabla_datos.getRowCount();
        for(int i= 0; i<filas; i++){
            modelo.removeRow(0);
        }
        
        for(RowTablaIncidencia inci : arrayIncidencias){
            datos[0] = new SimpleDateFormat("yyyy-MM-dd").format(inci.getFecha());
            datos[1] = inci.getTipo();
            datos[2] = inci.getDescripcion();
            datos[3] = inci.getDireccion();
            modelo.addRow(datos);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_minimizar;
    private javax.swing.JButton boton_refrescar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JMenu cerrarsesion_menu;
    private javax.swing.JMenuItem cerrarsesion_opciones;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel label_A;
    private javax.swing.JLabel label_H;
    private javax.swing.JLabel label_NR;
    private javax.swing.JLabel label_V;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel nombre_admin;
    private javax.swing.JLabel nombre_app;
    private javax.swing.JPanel panel_A;
    private javax.swing.JPanel panel_H;
    private javax.swing.JPanel panel_NI;
    private javax.swing.JPanel panel_V;
    private javax.swing.JPanel panel_izquierda;
    private javax.swing.JPanel panel_ventanaPrincipal;
    private rojerusan.componentes.RSProgressMaterial progressBar;
    private javax.swing.JScrollPane scrollpane_tabla;
    private javax.swing.JSeparator separador_titulo_down;
    private javax.swing.JSeparator separador_titulo_up;
    private javax.swing.JTable tabla_datos;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}

