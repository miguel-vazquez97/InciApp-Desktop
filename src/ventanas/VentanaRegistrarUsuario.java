package ventanas;

import aplicacion.Aplicacion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author mivap
 */
public class VentanaRegistrarUsuario extends javax.swing.JDialog {
    protected Aplicacion app;
    
    Socket socket;
    OutputStream enviarServidor = null;
    InputStream input = null;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    
    String respuestaServidor;
    String[] resServidor;
    String envioServidor;
    byte[] respuestaServidorByte;
    
    protected int tipoUsuario;
    protected HashMap<String, Integer> departamento_id;
    protected String[] nombresDep;
        
    public VentanaRegistrarUsuario(java.awt.Frame parent, boolean modal, Aplicacion app, int tipoUsuario) {
        super(parent, modal);
        initComponents();
        
        this.app=app;
        this.tipoUsuario=tipoUsuario;

        progressBar.setVisible(false);
        error_registro.setVisible(false);       
        
        setSize(960, 540);
        Toolkit mipantalla=Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla=mipantalla.getScreenSize();
        setLocation(tamanoPantalla.width/4, tamanoPantalla.height/4);
        //setLocationRelativeTo(null);

        try {
            socket = app.getSocket();
            
            enviarServidor = socket.getOutputStream();
            input = socket.getInputStream();
            
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(VentanaLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_VentanaRegistro = new javax.swing.JPanel();
        panelUp_ventanaRegistro = new javax.swing.JPanel();
        boton_salir = new javax.swing.JButton();
        boton_minimizar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        text_correo = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        text_nombre = new javax.swing.JTextField();
        jLabelContrasena = new javax.swing.JLabel();
        text_contrasena = new javax.swing.JPasswordField();
        jLabelApellido = new javax.swing.JLabel();
        text_apellidos = new javax.swing.JTextField();
        jLabelRepContrasena = new javax.swing.JLabel();
        text_rep_contrasena = new javax.swing.JPasswordField();
        jLabelDni = new javax.swing.JLabel();
        text_dni = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        text_telefono = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();
        boton_registrar = new javax.swing.JButton();
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
        panelUp_ventanaRegistro.setPreferredSize(new java.awt.Dimension(0, 0));
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

        jLabelTitulo.setBackground(new java.awt.Color(240, 239, 240));
        jLabelTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(240, 239, 240));
        jLabelTitulo.setText("Registrar Administrador");

        javax.swing.GroupLayout panelUp_ventanaRegistroLayout = new javax.swing.GroupLayout(panelUp_ventanaRegistro);
        panelUp_ventanaRegistro.setLayout(panelUp_ventanaRegistroLayout);
        panelUp_ventanaRegistroLayout.setHorizontalGroup(
            panelUp_ventanaRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUp_ventanaRegistroLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
                .addComponent(boton_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panelUp_ventanaRegistroLayout.setVerticalGroup(
            panelUp_ventanaRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUp_ventanaRegistroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelUp_ventanaRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addComponent(boton_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_VentanaRegistro.add(panelUp_ventanaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));
        panelUp_ventanaRegistro.getAccessibleContext().setAccessibleName("");

        jLabelCorreo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelCorreo.setText("Correo:");
        panel_VentanaRegistro.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        text_correo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_correo.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 180, 25));

        jLabelNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(47, 47, 40));
        jLabelNombre.setText("Nombre:");
        panel_VentanaRegistro.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, -1, -1));

        text_nombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_nombre.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 180, 25));

        jLabelContrasena.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelContrasena.setForeground(new java.awt.Color(47, 47, 40));
        jLabelContrasena.setText("Contraseña:");
        panel_VentanaRegistro.add(jLabelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));
        panel_VentanaRegistro.add(text_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 180, 25));

        jLabelApellido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(47, 47, 40));
        jLabelApellido.setText("Apellidos:");
        panel_VentanaRegistro.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        text_apellidos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_apellidos.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 180, 25));

        jLabelRepContrasena.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelRepContrasena.setForeground(new java.awt.Color(47, 47, 40));
        jLabelRepContrasena.setText("Repita contraseña:");
        panel_VentanaRegistro.add(jLabelRepContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));
        panel_VentanaRegistro.add(text_rep_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 180, 25));

        jLabelDni.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelDni.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDni.setText("DNI:");
        panel_VentanaRegistro.add(jLabelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        text_dni.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_dni.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 180, 25));

        jLabelTelefono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(47, 47, 40));
        jLabelTelefono.setText("Teléfono:");
        panel_VentanaRegistro.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        text_telefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_telefono.setForeground(new java.awt.Color(60, 63, 65));
        panel_VentanaRegistro.add(text_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 180, 25));

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel_VentanaRegistro.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, 240));

        boton_registrar.setBackground(new java.awt.Color(26, 64, 95));
        boton_registrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_registrar.setForeground(new java.awt.Color(240, 239, 240));
        boton_registrar.setText("Registrarme");
        boton_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_registrarMouseClicked(evt);
            }
        });
        panel_VentanaRegistro.add(boton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, 40));

        error_registro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        error_registro.setForeground(new java.awt.Color(153, 0, 51));
        error_registro.setText("Error en el registro");
        panel_VentanaRegistro.add(error_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 450, -1, -1));

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
    
    //      BOTON MINIMIZAR
    private void boton_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseClicked
        //this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_boton_minimizarMouseClicked

    private void boton_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseEntered
        Border border_boton = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
        boton_minimizar.setBorder(border_boton);
    }//GEN-LAST:event_boton_minimizarMouseEntered

    private void boton_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseExited
        Border border_boton = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        boton_minimizar.setBorder(border_boton);
    }//GEN-LAST:event_boton_minimizarMouseExited

    //      BOTON REGISTRAR
    private void boton_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_registrarMouseClicked

        SwingWorker worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                progressBar.setVisible(true);
                progressBar.setIndeterminate(true);
                error_registro.setVisible(false);
                
                boolean registrar_usu = true;
                Border border_boton_rojo = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red);

                String correo = text_correo.getText();
                String contrasena = text_contrasena.getText();
                String contra_val = text_rep_contrasena.getText();
                String nombre = text_nombre.getText();
                String apellidos = text_apellidos.getText();
                String dni = text_dni.getText();
                String tlf = text_telefono.getText();
                
                //comprobamos que el correo es correcto
                if(correo.equals("")){
                    text_correo.setBorder(border_boton_rojo);
                    registrar_usu = false;
                }else{
                    if(!comprobarCorreo(correo)){
                        text_correo.setBorder(border_boton_rojo);
                        registrar_usu = false;

                    }else{
                        text_correo.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                    }
                }
                
                //comprobamos la contraseña
                if(contrasena.equals("")){
                    text_contrasena.setBorder(border_boton_rojo);
                    registrar_usu = false;
                }else{
                    text_contrasena.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }
                
                //comprobamos que repetir contraseña es la misma que ha introducido anteriormente
                if(contra_val.equals("")){
                    text_rep_contrasena.setBorder(border_boton_rojo);
                    registrar_usu = false;
                }else{
                    if(!contrasena.equals(contra_val)){
                        text_rep_contrasena.setBorder(border_boton_rojo);
                        registrar_usu = false;
                    }else{
                        text_rep_contrasena.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                    }
                }
                
                //comprobamos el nombre, apellidos, dni y tlf
                
                if(nombre.equals("")){
                    text_nombre.setBorder(border_boton_rojo);
                    registrar_usu = false;
                }else{
                    text_nombre.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(apellidos.equals("")){
                    text_apellidos.setBorder(border_boton_rojo);
                    registrar_usu = false;
                }else{
                    text_apellidos.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(dni.equals("") || dni.length()!=9){
                    text_dni.setBorder(border_boton_rojo);
                    registrar_usu = false;
                }else{
                    text_dni.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(tlf.equals("") || tlf.length()!=9){
                    text_telefono.setBorder(border_boton_rojo);
                    registrar_usu = false;
                }else{
                    text_telefono.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }
                
                //si todo es correcto, registramos al usuario
                if(registrar_usu){
                    registrarUsuario(correo,contrasena,nombre,apellidos,dni,tlf,"NULL");                        
                }

                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);               
                
                return null;
            }

        };
        
        worker.execute();
    }//GEN-LAST:event_boton_registrarMouseClicked

    //      MOVER VENTANA
    int xx, xy;
    private void panelUp_ventanaRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaRegistroMousePressed
       xx=evt.getX();
       xy=evt.getY();  
    }//GEN-LAST:event_panelUp_ventanaRegistroMousePressed

    private void panelUp_ventanaRegistroMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaRegistroMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_panelUp_ventanaRegistroMouseDragged

    //  METODOS    
    protected boolean comprobarCorreo(String correo){
        
        int n1 = correo.indexOf("@");
        int n2 = correo.indexOf(".");

        
        if(n1<0 || n2 <0 )
            return false;
        
        
        if(correo.substring(n2).equals(".es") || correo.substring(n2).equals(".com"))
            return true;
        
        return false;
    }

    protected void registrarUsuario(String correo, String contrasena, String nombre, String apellidos, String dni, String tlf, String departamento){
        envioServidor = "1||"+correo+"||"+contrasena+"||"+nombre+"||"+apellidos+"||"+dni+"||"+tlf+"||"+departamento+"||"+tipoUsuario+"||";
        
        try {
            
            enviarServidor.write(envioServidor.getBytes());

            respuestaServidorByte = new byte[1024];
            input.read(respuestaServidorByte);
            respuestaServidor = new String(respuestaServidorByte);          
            
            resServidor = respuestaServidor.split("\\|\\|");
            
            if(resServidor[0].equals("1") && resServidor[1].equals("registrarUsuarioOk")){            
                dispose();
            }else{
                error_registro.setVisible(true);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(VentanaRegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_minimizar;
    private javax.swing.JButton boton_registrar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel error_registro;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRepContrasena;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel panelUp_ventanaRegistro;
    private javax.swing.JPanel panel_VentanaRegistro;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField text_apellidos;
    private javax.swing.JPasswordField text_contrasena;
    private javax.swing.JTextField text_correo;
    private javax.swing.JTextField text_dni;
    private javax.swing.JTextField text_nombre;
    private javax.swing.JPasswordField text_rep_contrasena;
    private javax.swing.JTextField text_telefono;
    // End of variables declaration//GEN-END:variables
}
