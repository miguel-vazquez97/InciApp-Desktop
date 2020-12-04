package ventanas;

import aplicacion.Aplicacion;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sun.misc.BASE64Decoder;

/**
 *
 * @author mivap
 */
public class VentanaIncidenciaArreglada extends javax.swing.JDialog {
    
    protected Aplicacion app;
    protected VentanaPrincipal vp;
    protected int idIncidencia;
    
    protected String respuestaServidor;
    protected String[] resServidor;    
    protected byte[] respuestaServidorByte;
    
    public VentanaIncidenciaArreglada(VentanaPrincipal vp, boolean modal, Aplicacion app, int idIncidencia) {
        super(vp, modal);
        initComponents();
        
        this.vp=vp;
        this.app=app;
        this.idIncidencia=idIncidencia;
        
        setSize(1440, 810);
        setLocationRelativeTo(null);
        
        datosIncidencia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUp_ventana = new javax.swing.JPanel();
        boton_salir = new javax.swing.JButton();
        imagen_logo = new javax.swing.JLabel();
        nombre_app = new javax.swing.JLabel();
        scrollpanel = new javax.swing.JScrollPane();
        panel_principal = new javax.swing.JPanel();
        jLabelDetallesIncidencia = new javax.swing.JLabel();
        jLabelNombreApellidos = new javax.swing.JLabel();
        text_nombre_apellidos = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        text_correo = new javax.swing.JTextField();
        jLabelTipo = new javax.swing.JLabel();
        text_tipo = new javax.swing.JTextField();
        jLabelFecha = new javax.swing.JLabel();
        text_fecha = new javax.swing.JTextField();
        jLabelDescripcion = new javax.swing.JLabel();
        jScrollDescripcion = new javax.swing.JScrollPane();
        text_descripcion = new javax.swing.JTextArea();
        jLabelDireccion = new javax.swing.JLabel();
        text_direccion = new javax.swing.JTextField();
        jLabelDepartamento = new javax.swing.JLabel();
        text_departamento = new javax.swing.JTextField();
        jLabelSupervisor = new javax.swing.JLabel();
        text_supervisor = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        text_empleado = new javax.swing.JTextField();
        jLabelImagen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelArreglo = new javax.swing.JLabel();
        jLabelFechaArreglo = new javax.swing.JLabel();
        text_fecha_arreglo = new javax.swing.JTextField();
        jLabelDescripcionArreglo = new javax.swing.JLabel();
        jScrollDescripcionArreglo = new javax.swing.JScrollPane();
        text_descripcion_arreglo = new javax.swing.JTextArea();
        jLabelImagenArreglo = new javax.swing.JLabel();
        progressBar = new rojerusan.componentes.RSProgressMaterial();
        boton_aceptar = new javax.swing.JButton();
        boton_denegar = new javax.swing.JButton();
        progressBar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelUp_ventana.setBackground(new java.awt.Color(26, 64, 95));
        panelUp_ventana.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panelUp_ventana.setForeground(new java.awt.Color(255, 255, 255));
        panelUp_ventana.setPreferredSize(new java.awt.Dimension(1440, 70));
        panelUp_ventana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelUp_ventanaMouseDragged(evt);
            }
        });
        panelUp_ventana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelUp_ventanaMousePressed(evt);
            }
        });
        panelUp_ventana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelUp_ventana.add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 15, 30, 30));

        imagen_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp_icono.jpg"))); // NOI18N
        panelUp_ventana.add(imagen_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, 31, 32));

        nombre_app.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        nombre_app.setForeground(new java.awt.Color(255, 255, 255));
        nombre_app.setText("InciApp  -  Incidencia Arreglada");
        panelUp_ventana.add(nombre_app, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, -1, -1));

        scrollpanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpanel.setPreferredSize(new java.awt.Dimension(1440, 810));

        panel_principal.setBackground(new java.awt.Color(240, 239, 240));
        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panel_principal.setForeground(new java.awt.Color(60, 63, 65));
        panel_principal.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        panel_principal.setMinimumSize(new java.awt.Dimension(1440, 1800));
        panel_principal.setPreferredSize(new java.awt.Dimension(1440, 1630));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDetallesIncidencia.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelDetallesIncidencia.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDetallesIncidencia.setText("Detalles Incidencia");
        panel_principal.add(jLabelDetallesIncidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jLabelNombreApellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelNombreApellidos.setForeground(new java.awt.Color(47, 47, 40));
        jLabelNombreApellidos.setText("Nombre y apellidos:");
        panel_principal.add(jLabelNombreApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        text_nombre_apellidos.setEditable(false);
        text_nombre_apellidos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_nombre_apellidos.setForeground(new java.awt.Color(60, 63, 65));
        text_nombre_apellidos.setBorder(null);
        panel_principal.add(text_nombre_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 310, 25));

        jLabelCorreo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelCorreo.setText("Correo:");
        panel_principal.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 60, -1));

        text_correo.setEditable(false);
        text_correo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_correo.setForeground(new java.awt.Color(60, 63, 65));
        text_correo.setBorder(null);
        panel_principal.add(text_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 310, 25));

        jLabelTipo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelTipo.setText("Tipo:");
        panel_principal.add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        text_tipo.setEditable(false);
        text_tipo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_tipo.setForeground(new java.awt.Color(60, 63, 65));
        text_tipo.setBorder(null);
        panel_principal.add(text_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 310, 25));

        jLabelFecha.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFecha.setText("Fecha:");
        panel_principal.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, -1, -1));

        text_fecha.setEditable(false);
        text_fecha.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fecha.setForeground(new java.awt.Color(60, 63, 65));
        text_fecha.setBorder(null);
        panel_principal.add(text_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, 310, 25));

        jLabelDescripcion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDescripcion.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDescripcion.setText("Descripción:");
        panel_principal.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        jScrollDescripcion.setBackground(new java.awt.Color(240, 239, 240));
        jScrollDescripcion.setForeground(new java.awt.Color(60, 63, 65));
        jScrollDescripcion.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        text_descripcion.setEditable(false);
        text_descripcion.setBackground(new java.awt.Color(240, 239, 240));
        text_descripcion.setColumns(20);
        text_descripcion.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_descripcion.setForeground(new java.awt.Color(60, 63, 65));
        text_descripcion.setLineWrap(true);
        text_descripcion.setRows(10);
        text_descripcion.setWrapStyleWord(true);
        text_descripcion.setBorder(null);
        text_descripcion.setDisabledTextColor(new java.awt.Color(60, 63, 65));
        jScrollDescripcion.setViewportView(text_descripcion);

        panel_principal.add(jScrollDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 310, 110));

        jLabelDireccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDireccion.setText("Dirección:");
        panel_principal.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, 50));

        text_direccion.setEditable(false);
        text_direccion.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_direccion.setForeground(new java.awt.Color(60, 63, 65));
        text_direccion.setBorder(null);
        panel_principal.add(text_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 310, 25));

        jLabelDepartamento.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDepartamento.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDepartamento.setText("Departamento:");
        panel_principal.add(jLabelDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, -1, -1));

        text_departamento.setEditable(false);
        text_departamento.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_departamento.setForeground(new java.awt.Color(60, 63, 65));
        text_departamento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        text_departamento.setBorder(null);
        panel_principal.add(text_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 310, 25));

        jLabelSupervisor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSupervisor.setForeground(new java.awt.Color(47, 47, 40));
        jLabelSupervisor.setText("Supervisor:");
        panel_principal.add(jLabelSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, -1, -1));

        text_supervisor.setEditable(false);
        text_supervisor.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_supervisor.setForeground(new java.awt.Color(60, 63, 65));
        text_supervisor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        text_supervisor.setBorder(null);
        panel_principal.add(text_supervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 600, 310, 25));

        jLabelEmpleado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(47, 47, 40));
        jLabelEmpleado.setText("Empleado:");
        panel_principal.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 670, -1, -1));

        text_empleado.setEditable(false);
        text_empleado.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_empleado.setForeground(new java.awt.Color(60, 63, 65));
        text_empleado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        text_empleado.setBorder(null);
        panel_principal.add(text_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 310, 25));

        jLabelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp.png"))); // NOI18N
        panel_principal.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 400, 500));

        jSeparator1.setBackground(new java.awt.Color(26, 64, 95));
        panel_principal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 880, 940, -1));

        jLabelArreglo.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelArreglo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelArreglo.setText("Arreglo Incidencia");
        panel_principal.add(jLabelArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 920, -1, -1));

        jLabelFechaArreglo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaArreglo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaArreglo.setText("Fecha:");
        panel_principal.add(jLabelFechaArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 1020, -1, -1));

        text_fecha_arreglo.setEditable(false);
        text_fecha_arreglo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fecha_arreglo.setForeground(new java.awt.Color(60, 63, 65));
        text_fecha_arreglo.setBorder(null);
        panel_principal.add(text_fecha_arreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1020, 310, 25));

        jLabelDescripcionArreglo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDescripcionArreglo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDescripcionArreglo.setText("Descripción:");
        panel_principal.add(jLabelDescripcionArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1100, -1, -1));

        jScrollDescripcionArreglo.setBackground(new java.awt.Color(240, 239, 240));
        jScrollDescripcionArreglo.setForeground(new java.awt.Color(60, 63, 65));
        jScrollDescripcionArreglo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        text_descripcion_arreglo.setEditable(false);
        text_descripcion_arreglo.setBackground(new java.awt.Color(240, 239, 240));
        text_descripcion_arreglo.setColumns(20);
        text_descripcion_arreglo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_descripcion_arreglo.setForeground(new java.awt.Color(60, 63, 65));
        text_descripcion_arreglo.setLineWrap(true);
        text_descripcion_arreglo.setRows(10);
        text_descripcion_arreglo.setWrapStyleWord(true);
        text_descripcion_arreglo.setBorder(null);
        text_descripcion_arreglo.setDisabledTextColor(new java.awt.Color(60, 63, 65));
        jScrollDescripcionArreglo.setViewportView(text_descripcion_arreglo);

        panel_principal.add(jScrollDescripcionArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1100, 310, 110));

        jLabelImagenArreglo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenArreglo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp.png"))); // NOI18N
        panel_principal.add(jLabelImagenArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 1030, 400, 500));

        progressBar.setForeground(new java.awt.Color(26, 64, 95));
        panel_principal.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 100, 100));

        boton_aceptar.setBackground(new java.awt.Color(26, 188, 156));
        boton_aceptar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_aceptar.setForeground(new java.awt.Color(240, 239, 240));
        boton_aceptar.setText("Aceptar");
        boton_aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_aceptarMouseClicked(evt);
            }
        });
        panel_principal.add(boton_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 1570, -1, 40));

        boton_denegar.setBackground(new java.awt.Color(255, 102, 102));
        boton_denegar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_denegar.setForeground(new java.awt.Color(240, 239, 240));
        boton_denegar.setText("Denegar");
        boton_denegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_denegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_denegarMouseClicked(evt);
            }
        });
        panel_principal.add(boton_denegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 1570, -1, 40));

        progressBar2.setForeground(new java.awt.Color(26, 64, 95));
        panel_principal.add(progressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 1615, 700, 10));

        scrollpanel.setViewportView(panel_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUp_ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelUp_ventana, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
//      BOTON SALIR
    private void boton_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_salirMouseEntered
        Border border_boton = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
        boton_salir.setBorder(border_boton);
    }//GEN-LAST:event_boton_salirMouseEntered

    private void boton_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_salirMouseExited
        Border border_boton = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        boton_salir.setBorder(border_boton);
    }//GEN-LAST:event_boton_salirMouseExited

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

    //      MOVER VENTANA
    int xx, xy;
    private void panelUp_ventanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_panelUp_ventanaMouseDragged

    private void panelUp_ventanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaMousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_panelUp_ventanaMousePressed

    //      BOTON ACEPTAR
    private void boton_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_aceptarMouseClicked

        SwingWorker workerAceptarIncidencia = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                progressBar2.setVisible(true);
                progressBar2.setIndeterminate(true);
                
                respuestaServidor = app.protocoloMensajes("10||"+idIncidencia+"||");
                
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaIncidenciaArreglada.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }
                resServidor = respuestaServidor.split("\\|\\|");
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaIncidenciaArreglada.this, "Su sesión ha caducado", "Message", 0);
                    vp.setVisible(false);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                    ventanaLog.setVisible(true);
                }else if(resServidor[0].equals("13") && resServidor[1].equals("incidenciaSolucionadaOk")){
                    dispose();
                }

                progressBar2.setIndeterminate(false);
                progressBar2.setVisible(false);

                return null;
            }

        };

        workerAceptarIncidencia.execute();

    }//GEN-LAST:event_boton_aceptarMouseClicked
    //      BOTON DENEGAR
    private void boton_denegarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_denegarMouseClicked
        SwingWorker workerAceptarIncidencia = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                
                JPanel panel = new JPanel();
                panel.add(new JLabel("Introduzca motivos de la denegación:"));
                String detallesDenegacion = JOptionPane.showInputDialog(VentanaIncidenciaArreglada.this, panel, "Message", 1);        
                if(detallesDenegacion!=null){                    
                    progressBar2.setVisible(true);
                    progressBar2.setIndeterminate(true);                    

                    respuestaServidor = app.protocoloMensajes("12||"+idIncidencia+"||"+detallesDenegacion+"||");
                    
                    if(respuestaServidor==null){
                        JOptionPane.showMessageDialog(VentanaIncidenciaArreglada.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                        progressBar.setVisible(false);
                        return null;
                    }
                    resServidor = respuestaServidor.split("\\|\\|");
                    if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                        JOptionPane.showMessageDialog(VentanaIncidenciaArreglada.this, "Su sesión ha caducado", "Message", 0);
                        vp.setVisible(false);
                        dispose();
                        VentanaLog ventanaLog = new VentanaLog();
                        ventanaLog.setVisible(true);
                    }else if(resServidor[0].equals("15") && resServidor[1].equals("incidenciaDenegadaSolucionOk")){
                        dispose();
                    }

                    progressBar2.setIndeterminate(false);
                    progressBar2.setVisible(false);
                } 
                return null;
            }
        };

        workerAceptarIncidencia.execute();
    }//GEN-LAST:event_boton_denegarMouseClicked

    //      METODOS
    
    public void datosIncidencia(){
        
        SwingWorker workerDatos = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {    
                ocultarComponentes();
                progressBar.setVisible(true);

                JSONParser parser = new JSONParser();
                JSONArray jsonArray;
                JSONObject object;
                
                String incidenciaString = app.protocoloMensajes("9||"+idIncidencia+"||");
                
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaIncidenciaArreglada.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }
                resServidor = incidenciaString.split("\\|\\|");                
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaIncidenciaArreglada.this, "Su sesión ha caducado", "Message", 0);
                    vp.setVisible(false);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                    ventanaLog.setVisible(true);
                }
                
                jsonArray = (JSONArray) parser.parse(incidenciaString);
                BASE64Decoder decoder = new BASE64Decoder();
                for(int z=0;z<jsonArray.size();z++){
                    object = (JSONObject) jsonArray.get(z);
                    switch(z){
                        case 0:
                            text_nombre_apellidos.setText( object.get("nombreApellido").toString());
                            text_correo.setText( object.get("correo").toString());
                            text_fecha.setText( object.get("fecha").toString());
                            text_tipo.setText( object.get("tipo").toString());
                            text_descripcion.setText( object.get("descripcion").toString());
                            text_direccion.setText( object.get("direccion").toString());
                            text_departamento.setText( object.get("departamento").toString());
                            text_supervisor.setText( object.get("supervisor").toString());
                            text_empleado.setText( object.get("empleado").toString());                            
                            
                            break;
                            
                        case 1:
                            String imagenBase64 = object.get("imagen").toString();                            
                            byte[] imageByte = decoder.decodeBuffer(imagenBase64);                                                    
                            ImageIcon ii = new ImageIcon(imageByte);
                            jLabelImagen.setIcon(ii);
                                                       
                            break;
                        
                        case 2:                            
                            text_fecha_arreglo.setText( object.get("fechaArreglo").toString());
                            text_descripcion_arreglo.setText( object.get("descripcionArreglo").toString());                            
                            break;  
                            
                        case 3:
                            String imagenArregloBase64 = object.get("imagenArreglo").toString();
                            byte[] imageArregloByte = decoder.decodeBuffer(imagenArregloBase64);
                                                    
                            ImageIcon iiArreglo = new ImageIcon(imageArregloByte);
                            jLabelImagenArreglo.setIcon(iiArreglo);
                                                       
                            break;
                    }
                    
                }
                
                progressBar.setVisible(false);    
                mostrarComponentes();
                return null;
            }            
        };   
        
        workerDatos.execute();
    }
    
    public void ocultarComponentes(){
        jLabelDetallesIncidencia.setVisible(false);
        jLabelNombreApellidos.setVisible(false);
        jLabelCorreo.setVisible(false);
        jLabelTipo.setVisible(false);
        jLabelFecha.setVisible(false);
        jLabelDescripcion.setVisible(false);
        jLabelDireccion.setVisible(false);
        jLabelDepartamento.setVisible(false);
        jLabelSupervisor.setVisible(false);
        jLabelEmpleado.setVisible(false);
        jLabelImagen.setVisible(false);
        jLabelArreglo.setVisible(false);
        jLabelFechaArreglo.setVisible(false);
        jLabelDescripcionArreglo.setVisible(false);
        jLabelImagenArreglo.setVisible(false);

        boton_aceptar.setVisible(false);
        jSeparator1.setVisible(false);
        progressBar2.setVisible(false);
        
        text_nombre_apellidos.setVisible(false);
        text_correo.setVisible(false);
        text_tipo.setVisible(false);
        text_fecha.setVisible(false);
        jScrollDescripcion.setVisible(false);
        text_descripcion.setVisible(false);
        text_direccion.setVisible(false);
        text_departamento.setVisible(false);
        text_supervisor.setVisible(false);
        text_empleado.setVisible(false);
        text_fecha_arreglo.setVisible(false);
        jScrollDescripcionArreglo.setVisible(false);
        text_descripcion_arreglo.setVisible(false);
    }
    
    public void mostrarComponentes(){
        jLabelDetallesIncidencia.setVisible(true);
        jLabelNombreApellidos.setVisible(true);
        jLabelCorreo.setVisible(true);
        jLabelTipo.setVisible(true);
        jLabelFecha.setVisible(true);
        jLabelDescripcion.setVisible(true);
        jLabelDireccion.setVisible(true);
        jLabelDepartamento.setVisible(true);
        jLabelSupervisor.setVisible(true);
        jLabelEmpleado.setVisible(true);
        jLabelImagen.setVisible(true);
        jLabelArreglo.setVisible(true);
        jLabelFechaArreglo.setVisible(true);
        jLabelDescripcionArreglo.setVisible(true);
        jLabelImagenArreglo.setVisible(true);

        boton_aceptar.setVisible(true);
        jSeparator1.setVisible(true);
        
        text_nombre_apellidos.setVisible(true);
        text_correo.setVisible(true);
        text_tipo.setVisible(true);
        text_fecha.setVisible(true);
        jScrollDescripcion.setVisible(true);
        text_descripcion.setVisible(true);
        text_direccion.setVisible(true);
        text_departamento.setVisible(true);
        text_supervisor.setVisible(true);
        text_empleado.setVisible(true);
        text_fecha_arreglo.setVisible(true);
        jScrollDescripcionArreglo.setVisible(true);
        text_descripcion_arreglo.setVisible(true);       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_denegar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JLabel jLabelArreglo;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDepartamento;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcionArreglo;
    private javax.swing.JLabel jLabelDetallesIncidencia;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechaArreglo;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelImagenArreglo;
    private javax.swing.JLabel jLabelNombreApellidos;
    private javax.swing.JLabel jLabelSupervisor;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JScrollPane jScrollDescripcion;
    private javax.swing.JScrollPane jScrollDescripcionArreglo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nombre_app;
    private javax.swing.JPanel panelUp_ventana;
    private javax.swing.JPanel panel_principal;
    private rojerusan.componentes.RSProgressMaterial progressBar;
    private javax.swing.JProgressBar progressBar2;
    private javax.swing.JScrollPane scrollpanel;
    private javax.swing.JTextField text_correo;
    private javax.swing.JTextField text_departamento;
    private javax.swing.JTextArea text_descripcion;
    private javax.swing.JTextArea text_descripcion_arreglo;
    private javax.swing.JTextField text_direccion;
    private javax.swing.JTextField text_empleado;
    private javax.swing.JTextField text_fecha;
    private javax.swing.JTextField text_fecha_arreglo;
    private javax.swing.JTextField text_nombre_apellidos;
    private javax.swing.JTextField text_supervisor;
    private javax.swing.JTextField text_tipo;
    // End of variables declaration//GEN-END:variables
}
