package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author mivap
 */
public class RegistroUsuarioAdministrador extends javax.swing.JFrame {

    private Socket socket;
    private InputStream input;
    private OutputStream output;
    private String respuestaServidor;
    private byte[] respuestaServidorByte;

    public RegistroUsuarioAdministrador() {
        initComponents();

        this.setTitle("Registro usuario Administrador");
        setSize(960, 540);
        this.setLocationRelativeTo(null);

        Properties properties = new Properties();
        try {
            String ip;
            int puerto;
            try (FileInputStream leerArchivo = new FileInputStream("src/aplicacion/Configuracion.properties")) {
                properties.load(leerArchivo);
                ip = properties.getProperty("ip");
                puerto = Integer.parseInt(properties.getProperty("puerto"));
            }
            socket = new Socket(ip, puerto);
            input = socket.getInputStream();
            output = socket.getOutputStream();

            while ((input.read(respuestaServidorByte = new byte[input.available()])) < 1) {
            }
            respuestaServidor = new String(respuestaServidorByte);

            output.write("ConectadoAppEscritorio||0||".getBytes());
            output.flush();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistroUsuarioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistroUsuarioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/setting.png"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_titulo = new javax.swing.JLabel();
        label_correo = new javax.swing.JLabel();
        text_contrasena = new javax.swing.JPasswordField();
        text_repetir_contrasena = new javax.swing.JPasswordField();
        label_contrasena = new javax.swing.JLabel();
        label_rep_contrasena = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_apellido = new javax.swing.JLabel();
        label_dni = new javax.swing.JLabel();
        label_tlf = new javax.swing.JLabel();
        text_correo = new javax.swing.JTextField();
        text_nombre = new javax.swing.JTextField();
        text_apellido = new javax.swing.JTextField();
        text_dni = new javax.swing.JTextField();
        text_tlf = new javax.swing.JTextField();
        boton_registrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        label_titulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        label_titulo.setText("Bienvenido a InciApp. LLeve a cabo el siguiente registro para poder usar la aplicación.");

        label_correo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_correo.setText("Correo: ");

        label_contrasena.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_contrasena.setText("Contraseña: ");

        label_rep_contrasena.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_rep_contrasena.setText("Rep Contraseña:");

        label_nombre.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_nombre.setText("Nombre: ");

        label_apellido.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_apellido.setText("Apellido: ");

        label_dni.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_dni.setText("DNI: ");

        label_tlf.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_tlf.setText("Teléfono:");

        boton_registrar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        boton_registrar.setText("REGISTRAR");
        boton_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_registrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(label_titulo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(boton_registrar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_contrasena)
                                .addComponent(label_correo)
                                .addComponent(label_rep_contrasena))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(text_contrasena)
                                .addComponent(text_correo)
                                .addComponent(text_repetir_contrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                            .addGap(93, 93, 93)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_apellido, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_dni, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_tlf, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(text_dni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(text_apellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(text_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(text_tlf)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(label_titulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label_nombre)
                                            .addComponent(text_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(label_apellido))
                                    .addComponent(text_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(label_dni))
                            .addComponent(text_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_tlf)
                            .addComponent(text_tlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(boton_registrar)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_correo)
                            .addComponent(text_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_contrasena)
                            .addComponent(text_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_rep_contrasena)
                            .addComponent(text_repetir_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_registrarMouseClicked

        boolean registrar_usuario = true;

        String correo = text_correo.getText();
        String contrasena = text_contrasena.getText();
        String rep_contrasena = text_repetir_contrasena.getText();
        String nombre = text_nombre.getText();
        String apellidos = text_apellido.getText();
        String dni = text_dni.getText();
        String tlf = text_tlf.getText();

        //comprobamos que el correo es correcto
        if (correo.equals("")) {
            registrar_usuario = false;
        } else {
            if (!comprobarCorreo(correo)) {
                registrar_usuario = false;
            }
        }

        //comprobamos la contraseña
        if (contrasena.equals("")) {
            registrar_usuario = false;
        }

        //comprobamos que repetir contraseña es la misma que ha introducido anteriormente
        if (rep_contrasena.equals("")) {
            registrar_usuario = false;
        } else {
            if (!contrasena.equals(rep_contrasena)) {
                registrar_usuario = false;
            }
        }

        //comprobamos el nombre, apellidos, dni y tlf
        if (nombre.equals("")) {
            registrar_usuario = false;
        }

        if (apellidos.equals("")) {
            registrar_usuario = false;
        }

        if (dni.equals("") || dni.length() != 9) {
            registrar_usuario = false;
        }

        if (tlf.equals("") || tlf.length() != 9) {
            registrar_usuario = false;
        }

        //si todo es correcto, registramos al usuario
        if (registrar_usuario) {
            SwingWorker worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    registrarUsuario(correo, contrasena, nombre, apellidos, dni, tlf, "NULL");
                    return null;
                }
            };
            worker.execute();
        } else {
            JOptionPane.showMessageDialog(RegistroUsuarioAdministrador.this, "Introduzca los datos correctamente.", "Message", 0);
        }

    }//GEN-LAST:event_boton_registrarMouseClicked

    //      METODOS
    protected boolean comprobarCorreo(String correo) {

        int n1 = correo.indexOf("@");
        int n2 = correo.indexOf(".");

        if (n1 < 0 || n2 < 0) {
            return false;
        }

        if (correo.substring(n2).equals(".es") || correo.substring(n2).equals(".com")) {
            return true;
        }

        return false;
    }

    protected void registrarUsuario(String correo, String contrasena, String nombre, String apellidos, String dni, String tlf, String departamento) {
        String mensaje = "1||" + correo + "||" + contrasena + "||" + nombre + "||" + apellidos + "||" + dni + "||" + tlf + "||" + departamento + "||" + 1 + "||";

        try {
            output.write(mensaje.getBytes());
            output.flush();

            int time = 0;
            while (input.available() < 1 && time < 15000) {
                try {
                    Thread.sleep(500);
                    time += 500;
                } catch (InterruptedException e) {
                }
            }
            if (time == 15000) {
                JOptionPane.showMessageDialog(RegistroUsuarioAdministrador.this, "Error en la comunicación. Vuelva a intentarlo de nuevo.", "Message", 1);
            }

            input.read(respuestaServidorByte = new byte[input.available()]);
            respuestaServidor = new String(respuestaServidorByte);

            String[] resServidor = respuestaServidor.split("\\|\\|");
            if (resServidor[0].equals("1") && resServidor[1].equals("registrarUsuarioOk")) {

                Properties propiedades = new Properties();
                Date fecha;
                try (FileInputStream leerArchivo = new FileInputStream("src/aplicacion/Configuracion.properties")) {
                    propiedades.load(leerArchivo);
                    propiedades.setProperty("correo", correo);
                    propiedades.setProperty("contrasena", contrasena);
                    fecha = new Date();
                    propiedades.store(new FileWriter("src/aplicacion/Configuracion.properties"), "Se actualizo la Configuracion   -   " + fecha);
                }
                
                Properties configuracion = new Properties();
                try (FileInputStream leerArchivoConfiguracion = new FileInputStream("src/aplicacion/Configuracion.inicio.properties")) {
                    configuracion.load(leerArchivoConfiguracion);
                    configuracion.setProperty("configuracionRegistroAdmin", "false");
                    configuracion.store(new FileWriter("src/aplicacion/Configuracion.inicio.properties"), "Se actualizo la configuracion     -   " + fecha);
                }
                
                input.close();
                output.close();
                socket.close();
                
                JOptionPane.showMessageDialog(RegistroUsuarioAdministrador.this, "Fin de la instalación.", "Message", 1);
                
                firePropertyChange("RegistroUsuarioAdministradorExit", null, null);                
                dispose();
            } else {
                JOptionPane.showMessageDialog(RegistroUsuarioAdministrador.this, "Usuario existente. Vuelva a intentarlo con otro correo", "Message", 0);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(RegistroUsuarioAdministrador.this, "Error en la comunicación. Vuelva a intentarlo de nuevo.", "Message", 1);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_registrar;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_contrasena;
    private javax.swing.JLabel label_correo;
    private javax.swing.JLabel label_dni;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_rep_contrasena;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_tlf;
    private javax.swing.JTextField text_apellido;
    private javax.swing.JPasswordField text_contrasena;
    private javax.swing.JTextField text_correo;
    private javax.swing.JTextField text_dni;
    private javax.swing.JTextField text_nombre;
    private javax.swing.JPasswordField text_repetir_contrasena;
    private javax.swing.JTextField text_tlf;
    // End of variables declaration//GEN-END:variables
}
