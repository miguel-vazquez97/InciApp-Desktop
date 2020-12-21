package ventanas;

import aplicacion.Aplicacion;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author mivap
 */
public class VentanaLog extends JFrame {

    protected Aplicacion app;
    protected Properties properties;
    protected InputStream leerArchivo;

    protected String respuestaServidor;
    protected String[] resServidor;

    protected VentanaPrincipal ventanaPrincipal;
    protected String correoAdmin, ip_properties;
    protected int puerto;

    public VentanaLog() {
        initComponents();

        app = new Aplicacion();

        Border border_boton = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        boton_minimizar.setBorder(border_boton);
        boton_salir.setBorder(border_boton);
        error_log.setVisible(false);
        error_log_sesion_inciada.setVisible(false);

        setSize(360, 450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        boton_login.setVisible(false);
        progressBar.setVisible(true);

        properties = new Properties();

        try {

            //abrimos el archivo
            leerArchivo =  new FileInputStream("Configuracion.properties");
            //leemos las propiedades
            properties.load(leerArchivo);

            //obtenemos las propiedades que queremos (IP y PUERTO)
            String correo_properties = properties.getProperty("correo");
            String contrasena_properties = properties.getProperty("contrasena");
            ip_properties = properties.getProperty("ip");
            String puerto_text_properties = properties.getProperty("puerto");            

            leerArchivo.close();

            //si teniamos introducida anteriormente correo y contraseña
            //lo recuperaremos del archivo properties e insertaremos en sus campos de la ventana de log
            if ((correo_properties != null && !correo_properties.equals("null")) && (contrasena_properties != null && !contrasena_properties.equals("null"))) {
                text_correo.setText(correo_properties);
                text_contrasena.setText(contrasena_properties);
                //guardaremos en nuestra clase Aplicacion el correo con el que se inicia sesion
                correoAdmin = correo_properties;
            }

            //probamos a conectarnos al servidor con la ip y el puerto introducidos en la anterior sesión si existe en nuestro properties
            if ((ip_properties != null && puerto_text_properties != null) && (!ip_properties.equals("null") && !puerto_text_properties.equals("null"))) {
                puerto = Integer.parseInt(puerto_text_properties);
                if(!app.conectarConServidor(ip_properties, puerto))
                     JOptionPane.showMessageDialog(VentanaLog.this, "No se puede establecer conexión con el servidor.", "Message", 0);
            }
            
            boton_login.setVisible(true);
            progressBar.setVisible(false);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("No se ha establecido conexión con el servidor. VentanaLog");
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_minimizar = new javax.swing.JButton();
        imagen_icono = new javax.swing.JLabel();
        label_correo = new javax.swing.JLabel();
        label_contrasena = new javax.swing.JLabel();
        text_correo = new javax.swing.JTextField();
        progressBar = new rojerusan.componentes.RSProgressMaterial();
        boton_login = new javax.swing.JButton();
        text_contrasena = new javax.swing.JPasswordField();
        boton_salir = new javax.swing.JButton();
        error_log = new javax.swing.JLabel();
        error_log_sesion_inciada = new javax.swing.JLabel();
        imagen_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(360, 450));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(boton_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 30, 30));

        imagen_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp.png"))); // NOI18N
        getContentPane().add(imagen_icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 40, 190, 180));

        label_correo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_correo.setForeground(new java.awt.Color(46, 134, 193));
        label_correo.setText("Correo : ");
        getContentPane().add(label_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 80, -1));

        label_contrasena.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_contrasena.setForeground(new java.awt.Color(46, 134, 193));
        label_contrasena.setText("Contraseña :");
        getContentPane().add(label_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 120, -1));

        text_correo.setBackground(new java.awt.Color(46, 134, 193));
        text_correo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_correo.setForeground(new java.awt.Color(255, 255, 255));
        text_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_correo.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(text_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 150, 30));

        progressBar.setForeground(new java.awt.Color(46, 134, 193));
        progressBar.setAnchoProgress(5);
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 40, 40));

        boton_login.setBackground(new java.awt.Color(127, 179, 213));
        boton_login.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_login.setForeground(new java.awt.Color(255, 255, 255));
        boton_login.setText("Iniciar Sesión");
        boton_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_loginMouseClicked(evt);
            }
        });
        getContentPane().add(boton_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 130, -1));

        text_contrasena.setBackground(new java.awt.Color(46, 134, 193));
        text_contrasena.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_contrasena.setForeground(new java.awt.Color(255, 255, 255));
        text_contrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_contrasena.setCaretColor(new java.awt.Color(255, 255, 255));
        text_contrasena.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        text_contrasena.setDisabledTextColor(new java.awt.Color(187, 187, 187));
        getContentPane().add(text_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 150, 30));

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
        getContentPane().add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 30, 30));

        error_log.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        error_log.setForeground(new java.awt.Color(153, 0, 51));
        error_log.setText("Correo o contraseña incorrecto.");
        getContentPane().add(error_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        error_log_sesion_inciada.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        error_log_sesion_inciada.setForeground(new java.awt.Color(153, 0, 51));
        error_log_sesion_inciada.setText("Ya se ha iniciado sesión con este correo");
        getContentPane().add(error_log_sesion_inciada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        imagen_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_ventanaPrincipal.jpg"))); // NOI18N
        imagen_fondo.setPreferredSize(new java.awt.Dimension(360, 450));
        imagen_fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                imagen_fondoMouseDragged(evt);
            }
        });
        imagen_fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imagen_fondoMousePressed(evt);
            }
        });
        getContentPane().add(imagen_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //      BOTON SALIR Y MINIMIZAR
    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        app.cerrarFlujos();
        System.exit(0);
    }//GEN-LAST:event_boton_salirActionPerformed

    private void boton_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseExited
        Border border_boton = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        boton_minimizar.setBorder(border_boton);
    }//GEN-LAST:event_boton_minimizarMouseExited

    private void boton_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_salirMouseExited
        Border border_boton = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        boton_salir.setBorder(border_boton);
    }//GEN-LAST:event_boton_salirMouseExited

    private void boton_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_salirMouseEntered
        Border border_boton = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
        boton_salir.setBorder(border_boton);
    }//GEN-LAST:event_boton_salirMouseEntered

    private void boton_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseEntered
        Border border_boton = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
        boton_minimizar.setBorder(border_boton);
    }//GEN-LAST:event_boton_minimizarMouseEntered

    private void boton_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_boton_minimizarMouseClicked

    //  MOVER VENTANA
    int xx, xy;
    private void imagen_fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagen_fondoMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_imagen_fondoMousePressed

    private void imagen_fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagen_fondoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_imagen_fondoMouseDragged

    //      BOTON LOGIN
    private void boton_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_loginMouseClicked

        SwingWorker worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                error_log.setVisible(false);
                error_log_sesion_inciada.setVisible(false);
                boton_login.setVisible(false);
                progressBar.setVisible(true);
                
                if(!app.getConectadoServidor()){
                    app.conectarConServidor(ip_properties, puerto);
                }

                if (app.getConectadoServidor()) {
                    

                    boolean log_admin = true;
                    Border border_boton_rojo = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red);

                    String correo = text_correo.getText();

                    //comprobamos que los campos correo y contrasena estan rellenos
                    if (correo.equals("")) {
                        text_correo.setBorder(border_boton_rojo);
                        error_log.setVisible(false);
                        log_admin = false;
                    } else {
                        text_correo.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                    }

                    String contrasena = null;
                    if (text_contrasena.getPassword().length < 1) {
                        text_contrasena.setBorder(border_boton_rojo);
                        error_log.setVisible(false);
                        log_admin = false;
                    } else {
                        text_contrasena.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));

                        //metodo getPassword() nos devuelve un array de char
                        contrasena = String.valueOf(text_contrasena.getPassword());
                    }

                    if (log_admin) {
                        correoAdmin = correo;
                        loggearAdministrador(correo, contrasena);
                    }

                } else {
                    JOptionPane.showMessageDialog(VentanaLog.this, "No se puede establecer conexión con el servidor.", "Message", 0);
                }

                boton_login.setVisible(true);
                progressBar.setVisible(false);

                return null;
            }

        };

        worker.execute();
    }//GEN-LAST:event_boton_loginMouseClicked

    //  METODOS    
    protected void loggearAdministrador(String correo, String contrasena) {

        try {

            respuestaServidor = app.protocoloMensajes("2||" + correo + "||" + contrasena + "||");
            resServidor = respuestaServidor.split("\\|\\|");

            if (resServidor[0].equals("3") && resServidor[1].equals("logAdminOk")) {

                app.setCorreo(correoAdmin);
                app.setNombreAdmin(resServidor[2]);

                //abrimos el archivo
                leerArchivo = new FileInputStream("Configuracion.properties");
                //leemos las propiedades
                properties.load(leerArchivo);
                //damos valor a las propiedades de nuestro archivo Configuracion
                properties.setProperty("correo", correo);
                properties.setProperty("contrasena", contrasena);
                //grabamos las modificaciones de las propiedades
                properties.store(new FileWriter("Configuracion.properties"), null);

                leerArchivo.close();

                ventanaPrincipal = new VentanaPrincipal(app);
                //Hacemos visible la ventana principal
                ventanaPrincipal.setVisible(true);
                //Cerramos la principal                
                dispose();

            } else {

                if (resServidor[0].equals("5") && resServidor[1].equals("sesionIniciadaOtroDispositivo")) {
                    error_log_sesion_inciada.setVisible(true);
                    error_log.setVisible(false);
                } else {
                    error_log.setVisible(true);
                    error_log_sesion_inciada.setVisible(false);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(VentanaRegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // MAIN    
/*
    public static void main(String args[]) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaLog ventanaLog = new VentanaLog();
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_login;
    private javax.swing.JButton boton_minimizar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel error_log;
    private javax.swing.JLabel error_log_sesion_inciada;
    private javax.swing.JLabel imagen_fondo;
    private javax.swing.JLabel imagen_icono;
    private javax.swing.JLabel label_contrasena;
    private javax.swing.JLabel label_correo;
    private rojerusan.componentes.RSProgressMaterial progressBar;
    private javax.swing.JPasswordField text_contrasena;
    private javax.swing.JTextField text_correo;
    // End of variables declaration//GEN-END:variables
}
