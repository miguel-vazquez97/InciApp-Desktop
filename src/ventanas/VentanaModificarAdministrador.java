package ventanas;

import aplicacion.Aplicacion;
import aplicacion.Usuario;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.Border;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author mivap
 */
public class VentanaModificarAdministrador extends javax.swing.JDialog {

    protected Aplicacion app;
    protected Usuario usuarioAdministrador; 
    protected String respuestaServidor;
    protected String[] resServidor;
    protected VentanaPrincipal vp;
    
    public VentanaModificarAdministrador(VentanaPrincipal vp, boolean modal, Aplicacion app) {
        super(vp, modal);               
        initComponents();
        
        this.vp = vp; 
        
        setSize(960, 540);               
        setLocationRelativeTo(null);
        
        this.app=app;

        ocultarComponentes();
        mostrarDatosAdministrador(app.getCorreo()); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_VentanaRegistro = new javax.swing.JPanel();
        panelUp_ventanaRegistro = new javax.swing.JPanel();
        boton_salir = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        text_nombre = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        text_correo = new javax.swing.JTextField();
        jLabelContrasena = new javax.swing.JLabel();
        text_contrasena = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        text_apellidos = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        text_dni = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        text_telefono = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();
        boton_modificar = new javax.swing.JButton();
        error_registro = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panel_VentanaRegistro.setBackground(new java.awt.Color(240, 239, 240));
        panel_VentanaRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panel_VentanaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        panel_VentanaRegistro.setPreferredSize(new java.awt.Dimension(960, 540));
        panel_VentanaRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUp_ventanaRegistro.setBackground(new java.awt.Color(26, 64, 95));
        panelUp_ventanaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        panelUp_ventanaRegistro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelUp_ventanaRegistroMouseDragged(evt);
            }
        });
        panelUp_ventanaRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelUp_ventanaRegistroMousePressed(evt);
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

        jLabelTitulo.setBackground(new java.awt.Color(240, 239, 240));
        jLabelTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(240, 239, 240));
        jLabelTitulo.setText("Modificar Administrador");

        javax.swing.GroupLayout panelUp_ventanaRegistroLayout = new javax.swing.GroupLayout(panelUp_ventanaRegistro);
        panelUp_ventanaRegistro.setLayout(panelUp_ventanaRegistroLayout);
        panelUp_ventanaRegistroLayout.setHorizontalGroup(
            panelUp_ventanaRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUp_ventanaRegistroLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 602, Short.MAX_VALUE)
                .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panelUp_ventanaRegistroLayout.setVerticalGroup(
            panelUp_ventanaRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUp_ventanaRegistroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelUp_ventanaRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panel_VentanaRegistro.add(panelUp_ventanaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        jLabelNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(47, 47, 40));
        jLabelNombre.setText("Nombre:");
        panel_VentanaRegistro.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        text_nombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_nombre.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 250, 25));

        jLabelCorreo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelCorreo.setText("Correo:");
        panel_VentanaRegistro.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        text_correo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_correo.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 250, 25));

        jLabelContrasena.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelContrasena.setForeground(new java.awt.Color(47, 47, 40));
        jLabelContrasena.setText("Contraseña:");
        panel_VentanaRegistro.add(jLabelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, -1, -1));

        text_contrasena.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_contrasena.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 250, 25));

        jLabelApellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(47, 47, 40));
        jLabelApellido.setText("Apellidos:");
        panel_VentanaRegistro.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        text_apellidos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_apellidos.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 250, 25));

        jLabelDni.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelDni.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDni.setText("DNI:");
        panel_VentanaRegistro.add(jLabelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        text_dni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_dni.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 250, 25));

        jLabelTelefono.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(47, 47, 40));
        jLabelTelefono.setText("Teléfono:");
        panel_VentanaRegistro.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        text_telefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_telefono.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 250, 25));

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel_VentanaRegistro.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, 240));

        boton_modificar.setBackground(new java.awt.Color(93, 173, 226));
        boton_modificar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_modificar.setForeground(new java.awt.Color(240, 239, 240));
        boton_modificar.setText("Modificar");
        boton_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_modificarMouseClicked(evt);
            }
        });
        panel_VentanaRegistro.add(boton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, -1, 40));

        error_registro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        error_registro.setForeground(new java.awt.Color(153, 0, 51));
        error_registro.setText("Error en el registro. Vuelva a intentarlo más tarde.");
        panel_VentanaRegistro.add(error_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, -1, -1));

        progressBar.setForeground(new java.awt.Color(26, 64, 95));
        panel_VentanaRegistro.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 500, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_VentanaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_VentanaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    //      VENTANA MODIFICAR
    int xx,xy;
    private void panelUp_ventanaRegistroMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaRegistroMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_panelUp_ventanaRegistroMouseDragged

    private void panelUp_ventanaRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaRegistroMousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_panelUp_ventanaRegistroMousePressed

    //      BOTON MODIFICAR
    private void boton_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_modificarMouseClicked

        SwingWorker worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                progressBar.setVisible(true);
                progressBar.setIndeterminate(true);
                error_registro.setVisible(false);

                boolean modificar_admin = true;
                Border border_boton_rojo = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red);

                String correo = text_correo.getText();
                String contrasena = text_contrasena.getText();
                String nombre = text_nombre.getText();
                String apellidos = text_apellidos.getText();
                String dni = text_dni.getText();
                String tlf = text_telefono.getText();


                if(nombre.equals("")){
                    text_nombre.setBorder(border_boton_rojo);
                    modificar_admin = false;
                }else{
                    text_nombre.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(apellidos.equals("")){
                    text_apellidos.setBorder(border_boton_rojo);
                    modificar_admin = false;
                }else{
                    text_apellidos.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(dni.equals("") || dni.length()!=9){
                    text_dni.setBorder(border_boton_rojo);
                    modificar_admin = false;
                }else{
                    text_dni.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(tlf.equals("") || tlf.length()!=9){
                    text_telefono.setBorder(border_boton_rojo);
                    modificar_admin = false;
                }else{
                    text_telefono.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }
                
                if(modificar_admin){
                    Usuario administradorModificar = new Usuario(correo,contrasena,nombre,apellidos,dni,Integer.parseInt(tlf),"NULL");
                    if(administradorModificar.compareTo(usuarioAdministrador)==1){
                        respuestaServidor = app.protocoloMensajes("22||"+app.getCorreo()+"||"+nombre+"||"+apellidos+"||"+dni+"||"+tlf+"||"+"NULL||");
                        
                        if(respuestaServidor==null){
                            JOptionPane.showMessageDialog(VentanaModificarAdministrador.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                            progressBar.setVisible(false);
                            return null;
                        }
                        resServidor = respuestaServidor.split("\\|\\|");    
                        if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                            JOptionPane.showMessageDialog(VentanaModificarAdministrador.this, "Su sesión ha caducado", "Message", 0);
                            vp.setVisible(false);
                            dispose();
                            VentanaLog ventanaLog = new VentanaLog();
                            ventanaLog.setVisible(true);
                        }

                        if(resServidor[0].equals("22") && resServidor[1].equals("modificarUsuarioOk")){
                            usuarioAdministrador = administradorModificar;  
                            app.setNombreAdmin(usuarioAdministrador.getNombre()+" "+usuarioAdministrador.getApellido());
                            
                            mostrarComponentes();
                        }else{
                            error_registro.setVisible(true);
                        }
                        
                        
                    }
                }


                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);

                return null;
            }

        };

        worker.execute();

    }//GEN-LAST:event_boton_modificarMouseClicked

    //      METODOS
    
    protected void mostrarDatosAdministrador(String correoUsuario){
        SwingWorker workerDatosUsuario = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                progressBar.setIndeterminate(true);
                progressBar.setVisible(true);

                respuestaServidor = app.protocoloMensajes("21||"+correoUsuario+"||");
                
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaModificarAdministrador.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }
                resServidor = respuestaServidor.split("\\|\\|");                
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaModificarAdministrador.this, "Su sesión ha caducado", "Message", 0);
                    vp.setVisible(false);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                    ventanaLog.setVisible(true);
                }
                
                JSONParser parser = new JSONParser();
                JSONObject objectUsuario = (JSONObject) parser.parse(respuestaServidor);
                String correo, nombre, apellido, dni, contrasena;
                int tlf;
                
                correo = (String) objectUsuario.get("correo").toString();
                contrasena = (String) objectUsuario.get("contrasena").toString();
                nombre = (String) objectUsuario.get("nombre").toString();
                apellido = (String) objectUsuario.get("apellido").toString();
                dni = (String) objectUsuario.get("dni").toString();
                tlf = Integer.parseInt(objectUsuario.get("tlf").toString());                

                usuarioAdministrador = new Usuario(correo,contrasena,nombre,apellido,dni,tlf,"NULL");
                mostrarComponentes();
                
                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);
                return null;
            }

        };

        workerDatosUsuario.execute();
    }
    
    protected void ocultarComponentes(){
        jLabelNombre.setVisible(false);
        jLabelApellido.setVisible(false);
        jLabelDni.setVisible(false);
        jLabelCorreo.setVisible(false);
        jLabelTelefono.setVisible(false);
        jLabelContrasena.setVisible(false);
        
        text_nombre.setVisible(false);
        text_apellidos.setVisible(false);
        text_dni.setVisible(false);
        text_correo.setVisible(false);
        text_telefono.setVisible(false);
        text_contrasena.setVisible(false);
        
        separator.setVisible(false);
        progressBar.setIndeterminate(false);
        progressBar.setVisible(false);  
        error_registro.setVisible(false);
    }
    
    protected void mostrarComponentes(){
        jLabelNombre.setVisible(true);
        jLabelApellido.setVisible(true);
        jLabelDni.setVisible(true);
        jLabelCorreo.setVisible(true);
        jLabelContrasena.setVisible(true);
        jLabelTelefono.setVisible(true);        
        
        text_nombre.setText(usuarioAdministrador.getNombre());
        text_nombre.setVisible(true);
        text_apellidos.setText(usuarioAdministrador.getApellido());
        text_apellidos.setVisible(true);
        text_dni.setText(usuarioAdministrador.getDni());
        text_dni.setVisible(true);
        text_correo.setText(usuarioAdministrador.getCorreo());
        text_correo.setEditable(false);
        text_correo.setVisible(true);
        text_contrasena.setText(usuarioAdministrador.getContrasena());
        text_contrasena.setEditable(false);
        text_contrasena.setVisible(true);
        text_telefono.setText(Integer.toString(usuarioAdministrador.getTlf()));
        text_telefono.setVisible(true);   
                
        separator.setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_modificar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel error_registro;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel panelUp_ventanaRegistro;
    private javax.swing.JPanel panel_VentanaRegistro;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField text_apellidos;
    private javax.swing.JTextField text_contrasena;
    private javax.swing.JTextField text_correo;
    private javax.swing.JTextField text_dni;
    private javax.swing.JTextField text_nombre;
    private javax.swing.JTextField text_telefono;
    // End of variables declaration//GEN-END:variables
}
