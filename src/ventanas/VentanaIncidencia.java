package ventanas;

import aplicacion.Aplicacion;
import aplicacion.Incidencia;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class VentanaIncidencia extends javax.swing.JDialog {

    protected Aplicacion app;
    protected VentanaPrincipal vp;
    protected int idIncidencia;
    protected String estado;
    
    protected String respuestaServidor;
    protected String[] resServidor;    
    protected byte[] respuestaServidorByte;
    
    protected String[] nombreS, correoS, nombreE, correoE;

    public VentanaIncidencia(VentanaPrincipal vp, boolean modal, Aplicacion app, int idIncidencia, String estado) {
        super(vp, modal);     
        initComponents();
        
        this.vp=vp;
        this.app=app;
        this.idIncidencia=idIncidencia;
        this.estado = estado;
        
        setSize(1440, 810);
        setLocationRelativeTo(null);
        
        switch(estado){
            case "NuevaRegistrada":
                titulo_ventana.setText("InciApp  -  Nueva Incidencia");
                break;
            case "EnTramite":
                titulo_ventana.setText("InciApp  -  En Tramite");
                break;
            case "Validada":
                titulo_ventana.setText("InciApp  -  Validada");
                break;
            case "EnArreglo":
                titulo_ventana.setText("InciApp  -  En Arreglo");
                break;
            case "ValidarArreglo":
                titulo_ventana.setText("InciApp  -  Validar Arreglo");
                break;
            case "Arreglada":
                titulo_ventana.setText("InciApp  -  Arreglada");
                break;
        }
                                
        datosIncidencia();      
               
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        panelUp_ventana = new javax.swing.JPanel();
        boton_salir = new javax.swing.JButton();
        imagen_logo = new javax.swing.JLabel();
        titulo_ventana = new javax.swing.JLabel();
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
        jComboBoxSupervisores = new javax.swing.JComboBox<>();
        text_nombre_supervisor = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        jComboBoxEmpleados = new javax.swing.JComboBox<>();
        text_nombre_empleado = new javax.swing.JTextField();
        jLabelImagen = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        boton_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panel_principal.setBackground(new java.awt.Color(240, 239, 240));
        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panel_principal.setForeground(new java.awt.Color(60, 63, 65));
        panel_principal.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUp_ventana.setBackground(new java.awt.Color(26, 64, 95));
        panelUp_ventana.setForeground(new java.awt.Color(255, 255, 255));
        panelUp_ventana.setPreferredSize(new java.awt.Dimension(960, 70));
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

        imagen_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp_icono.jpg"))); // NOI18N

        titulo_ventana.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        titulo_ventana.setForeground(new java.awt.Color(255, 255, 255));
        titulo_ventana.setText("InciApp  -  Nueva Incidencia");

        javax.swing.GroupLayout panelUp_ventanaLayout = new javax.swing.GroupLayout(panelUp_ventana);
        panelUp_ventana.setLayout(panelUp_ventanaLayout);
        panelUp_ventanaLayout.setHorizontalGroup(
            panelUp_ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUp_ventanaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(imagen_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo_ventana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1017, Short.MAX_VALUE)
                .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelUp_ventanaLayout.setVerticalGroup(
            panelUp_ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUp_ventanaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelUp_ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagen_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo_ventana)
                    .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel_principal.add(panelUp_ventana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 70));

        jLabelNombreApellidos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelNombreApellidos.setForeground(new java.awt.Color(47, 47, 40));
        jLabelNombreApellidos.setText("Nombre y apellidos:");
        panel_principal.add(jLabelNombreApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 170, -1, -1));

        text_nombre_apellidos.setEditable(false);
        text_nombre_apellidos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_nombre_apellidos.setForeground(new java.awt.Color(60, 63, 65));
        text_nombre_apellidos.setBorder(null);
        panel_principal.add(text_nombre_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 168, 310, 25));

        jLabelCorreo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelCorreo.setText("Correo:");
        panel_principal.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 60, -1));

        text_correo.setEditable(false);
        text_correo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_correo.setForeground(new java.awt.Color(60, 63, 65));
        text_correo.setBorder(null);
        panel_principal.add(text_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 158, 310, 25));

        jLabelTipo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelTipo.setText("Tipo:");
        panel_principal.add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 240, -1, -1));

        text_tipo.setEditable(false);
        text_tipo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_tipo.setForeground(new java.awt.Color(60, 63, 65));
        text_tipo.setBorder(null);
        panel_principal.add(text_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 310, 25));

        jLabelFecha.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFecha.setText("Fecha:");
        panel_principal.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 240, -1, -1));

        text_fecha.setEditable(false);
        text_fecha.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fecha.setForeground(new java.awt.Color(60, 63, 65));
        text_fecha.setBorder(null);
        panel_principal.add(text_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 310, 25));

        jLabelDescripcion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDescripcion.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDescripcion.setText("Descripción:");
        panel_principal.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

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

        panel_principal.add(jScrollDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 310, 110));

        jLabelDireccion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDireccion.setText("Dirección:");
        panel_principal.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 445, -1, 50));

        text_direccion.setEditable(false);
        text_direccion.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_direccion.setForeground(new java.awt.Color(60, 63, 65));
        text_direccion.setBorder(null);
        panel_principal.add(text_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 310, 25));

        jLabelDepartamento.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDepartamento.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDepartamento.setText("Departamento:");
        panel_principal.add(jLabelDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 540, -1, -1));

        text_departamento.setEditable(false);
        text_departamento.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_departamento.setForeground(new java.awt.Color(60, 63, 65));
        text_departamento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        text_departamento.setBorder(null);
        panel_principal.add(text_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 538, 310, 25));

        jLabelSupervisor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSupervisor.setForeground(new java.awt.Color(47, 47, 40));
        jLabelSupervisor.setText("Supervisor:");
        panel_principal.add(jLabelSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 610, -1, -1));

        jComboBoxSupervisores.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        panel_principal.add(jComboBoxSupervisores, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 310, 30));

        text_nombre_supervisor.setEditable(false);
        text_nombre_supervisor.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_nombre_supervisor.setForeground(new java.awt.Color(60, 63, 65));
        text_nombre_supervisor.setBorder(null);
        panel_principal.add(text_nombre_supervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 310, 25));

        jLabelEmpleado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(47, 47, 40));
        jLabelEmpleado.setText("Empleado:");
        panel_principal.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 680, -1, -1));

        jComboBoxEmpleados.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        panel_principal.add(jComboBoxEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 680, 310, 30));

        text_nombre_empleado.setEditable(false);
        text_nombre_empleado.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_nombre_empleado.setForeground(new java.awt.Color(60, 63, 65));
        text_nombre_empleado.setBorder(null);
        panel_principal.add(text_nombre_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 680, 310, 25));

        jLabelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp.png"))); // NOI18N
        panel_principal.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, -1, -1));

        progressBar.setForeground(new java.awt.Color(26, 64, 95));
        panel_principal.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 785, 700, 10));

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
        panel_principal.add(boton_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 730, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    //     BOTON ACEPTAR 
    private void boton_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_aceptarMouseClicked

        //nos seguramos que tenemos seleccionado un supervisor de nuestro combobox
        if((jComboBoxSupervisores.getSelectedIndex() != -1 && estado.equals("NuevaRegistrada")) || (jComboBoxEmpleados.getSelectedIndex() != -1 && estado.equals("Validada"))){
        
            SwingWorker workerAceptarIncidencia = new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                    
                    switch(estado){
                        case "NuevaRegistrada":
                            respuestaServidor = app.protocoloMensajes("6||"+idIncidencia+"||"+app.getCorreo()+"||"+correoS[jComboBoxSupervisores.getSelectedIndex()]+"||");
                            if(respuestaServidor==null){
                                JOptionPane.showMessageDialog(VentanaIncidencia.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                                progressBar.setVisible(false);
                                return null;
                            }
                            resServidor = respuestaServidor.split("\\|\\|");                
                            if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                                JOptionPane.showMessageDialog(VentanaIncidencia.this, "Su sesión ha caducado", "Message", 0);
                                vp.setVisible(false);
                                dispose();
                                VentanaLog ventanaLog = new VentanaLog();
                            }else if(!resServidor[0].equals("9") && !resServidor[1].equals("supervisorAsignadoOk")){
                                JOptionPane.showMessageDialog(VentanaIncidencia.this, "Supervisor no asiganado. Recarge la tabla e intentelo de nuevo", "Message", 2);
                            }
                            
                            break;
                            
                        case "Validada":
                            respuestaServidor = app.protocoloMensajes("8||"+idIncidencia+"||"+correoE[jComboBoxEmpleados.getSelectedIndex()]+"||");
                            if(respuestaServidor==null){
                                JOptionPane.showMessageDialog(VentanaIncidencia.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                                progressBar.setVisible(false);
                                return null;
                            }
                            resServidor = respuestaServidor.split("\\|\\|");                            
                            if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                                JOptionPane.showMessageDialog(VentanaIncidencia.this, "Su sesión ha caducado", "Message", 0);
                                vp.setVisible(false);
                                dispose();
                                VentanaLog ventanaLog = new VentanaLog();
                            }else{ 
                                if(!resServidor[0].equals("11") && !resServidor[1].equals("empleadoAsignadoOk")){
                                    JOptionPane.showMessageDialog(VentanaIncidencia.this, "Empleado no asiganado. Recarge la tabla e intentelo de nuevo", "Message", 2);
                                }
                            }
                            
                            break;
                    }
                    
                    progressBar.setIndeterminate(false);
                    progressBar.setVisible(false);
                    dispose();
                    return null;
                }

            };

            workerAceptarIncidencia.execute();
        }
    }//GEN-LAST:event_boton_aceptarMouseClicked

    
    //      METODOS
    
    public void datosIncidencia(){
        
        SwingWorker workerDatos = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {    
                ocultarComponentes();
                progressBar.setVisible(true);
                progressBar.setIndeterminate(true);              

                JSONParser parser = new JSONParser();
                JSONArray jsonArray;
                JSONObject object;
                
                String incidenciaString = app.protocoloMensajes("5||"+idIncidencia+"||"+estado+"||");  
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaIncidencia.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }
                resServidor = incidenciaString.split("\\|\\|");              
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaIncidencia.this, "Su sesión ha caducado", "Message", 0);
                    vp.setVisible(false);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                }
                
                jsonArray = (JSONArray) parser.parse(incidenciaString);
                Incidencia incidencia = null;
                for(int z=0;z<jsonArray.size();z++){
                    object = (JSONObject) jsonArray.get(z);
                    switch(z){
                        case 0:
                            incidencia = new Incidencia(idIncidencia, object.get("nombreApellido").toString(), object.get("correo").toString(), object.get("tipo").toString(), object.get("fecha").toString(),  object.get("descripcion").toString(), object.get("direccion").toString(), object.get("departamento").toString(), null);
                            
                            break;                            
                        case 1:
                            
                            switch(estado){
                                case "NuevaRegistrada":
                                    String listaSupervisores = object.get("supervisores").toString();

                                    if(!listaSupervisores.equals("null")){
                                        String[] auxS;                            
                                        auxS = listaSupervisores.split(";");
                                        nombreS = new String[auxS.length];
                                        correoS = new String[auxS.length];
                                        String[] nombre_correo_sup;
                                        for(int i=0; i<auxS.length; i++){
                                            nombre_correo_sup = auxS[i].split(":");
                                            nombreS[i] = nombre_correo_sup[0];
                                            correoS[i] = nombre_correo_sup[1];
                                        }

                                        cargarComboBoxSupervisores();   
                                    }
                                    break;
                                   
                                case "EnTramite":
                                    text_nombre_supervisor.setText(object.get("supervisores").toString());
                                    break;
                                    
                                case "Validada":                                    
                                    text_nombre_supervisor.setText(object.get("supervisores").toString());
                                    
                                    String listaEmpleados = object.get("empleados").toString();
                                    System.out.println(listaEmpleados);
                                    if(!listaEmpleados.equals("null")){
                                        String[] auxE;
                                        auxE = listaEmpleados.split(";");
                                        nombreE = new String[auxE.length];
                                        correoE = new String[auxE.length];
                                        String[] nombre_correo_emp;
                                        for(int i=0; i<auxE.length; i++){
                                            nombre_correo_emp = auxE[i].split(":");
                                            nombreE[i] = nombre_correo_emp[0];
                                            correoE[i] = nombre_correo_emp[1];
                                        }
                                        cargarComboBoxEmpleados();                                        
                                    }
                                    break;
                                    
                                case "EnArreglo":
                                case "ValidarArreglo":
                                case "Arreglada":
                                    text_nombre_supervisor.setText(object.get("supervisores").toString());
                                    text_nombre_empleado.setText(object.get("empleados").toString());
                                    break;
                                
                            }

                            break;
                            
                        case 2:
                            String imagenBase64 = object.get("imagen").toString();
                            incidencia.setImagenBase64(imagenBase64);                                                       
                                                       
                            break;
                    }
                    
                }
                
                text_nombre_apellidos.setText( incidencia.getNombreCiudadano());
                text_correo.setText( incidencia.getCorreoCiudadano());
                text_fecha.setText( incidencia.getFecha());
                text_tipo.setText( incidencia.getTipo());
                text_descripcion.setText( incidencia.getDescripcion());
                text_direccion.setText( incidencia.getDireccion());
                text_departamento.setText( incidencia.getDepartamento());
                
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] imageByte = decoder.decodeBuffer(incidencia.getImagenBase64());

                ImageIcon ii = new ImageIcon(imageByte);
                jLabelImagen.setIcon(ii);

                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);    
                mostrarComponentes();
                
                switch(estado){
                    case "NuevaRegistrada":
                        jComboBoxSupervisores.setVisible(true);
                        boton_aceptar.setVisible(true);                        
                        break;
                        
                    case "Validada":
                        jLabelEmpleado.setVisible(true);
                        jComboBoxEmpleados.setVisible(true);
                        boton_aceptar.setVisible(true);
                    //no ponemos break para que muestro el nombre del supervisor
                    case "EnTramite":
                        text_nombre_supervisor.setVisible(true);
                        break;
                        
                    case "EnArreglo":
                    case "ValidarArreglo":
                    case "Arreglada":
                        jLabelSupervisor.setVisible(true);
                        jLabelEmpleado.setVisible(true);                                                                        
                        text_nombre_supervisor.setVisible(true);
                        text_nombre_empleado.setVisible(true);
                        break;
                }
                
                return null;
            }            
        };   
        
        workerDatos.execute();
    }
    
    public void cargarComboBoxSupervisores(){
        DefaultComboBoxModel modelSupervisores = new DefaultComboBoxModel(nombreS);
        jComboBoxSupervisores.setModel(modelSupervisores);
        jComboBoxSupervisores.setMaximumRowCount(nombreS.length);
        jComboBoxSupervisores.setEditable(true);  
    }
    
     public void cargarComboBoxEmpleados(){
        DefaultComboBoxModel modelEmpleados = new DefaultComboBoxModel(nombreE);
        jComboBoxEmpleados.setModel(modelEmpleados);
        jComboBoxEmpleados.setMaximumRowCount(nombreE.length);
        jComboBoxEmpleados.setEditable(true);   
    }
    
    public void ocultarComponentes(){
        jLabelNombreApellidos.setVisible(false);
        jLabelCorreo.setVisible(false);
        jLabelDepartamento.setVisible(false);
        jLabelDescripcion.setVisible(false);
        jLabelDireccion.setVisible(false);
        jLabelFecha.setVisible(false);
        jLabelImagen.setVisible(false);
        jLabelSupervisor.setVisible(false);
        jLabelEmpleado.setVisible(false);
        jLabelTipo.setVisible(false);
        
        jComboBoxSupervisores.setVisible(false);
        jComboBoxEmpleados.setVisible(false);
        boton_aceptar.setVisible(false);
        
        text_nombre_apellidos.setVisible(false);
        text_correo.setVisible(false);
        text_departamento.setVisible(false);
        jScrollDescripcion.setVisible(false);
        text_descripcion.setVisible(false);
        text_direccion.setVisible(false);
        text_fecha.setVisible(false);
        text_tipo.setVisible(false);    
        text_nombre_supervisor.setVisible(false);
        text_nombre_empleado.setVisible(false);
    }
    
    public void mostrarComponentes(){
        jLabelNombreApellidos.setVisible(true);
        jLabelCorreo.setVisible(true);
        jLabelDepartamento.setVisible(true);
        jLabelDescripcion.setVisible(true);
        jLabelDireccion.setVisible(true);
        jLabelFecha.setVisible(true);
        jLabelImagen.setVisible(true);
        jLabelSupervisor.setVisible(true);
        jLabelTipo.setVisible(true);        
        
        text_nombre_apellidos.setVisible(true);
        text_correo.setVisible(true);
        text_departamento.setVisible(true);
        jScrollDescripcion.setVisible(true);
        text_descripcion.setVisible(true);        
        text_direccion.setVisible(true);
        text_fecha.setVisible(true);
        text_tipo.setVisible(true);          
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JComboBox<String> jComboBoxEmpleados;
    private javax.swing.JComboBox<String> jComboBoxSupervisores;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDepartamento;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelNombreApellidos;
    private javax.swing.JLabel jLabelSupervisor;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JScrollPane jScrollDescripcion;
    private javax.swing.JPanel panelUp_ventana;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField text_correo;
    private javax.swing.JTextField text_departamento;
    private javax.swing.JTextArea text_descripcion;
    private javax.swing.JTextField text_direccion;
    private javax.swing.JTextField text_fecha;
    private javax.swing.JTextField text_nombre_apellidos;
    private javax.swing.JTextField text_nombre_empleado;
    private javax.swing.JTextField text_nombre_supervisor;
    private javax.swing.JTextField text_tipo;
    private javax.swing.JLabel titulo_ventana;
    // End of variables declaration//GEN-END:variables
}
