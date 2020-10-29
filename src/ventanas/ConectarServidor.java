package ventanas;

import aplicacion.Aplicacion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mivap
 */
public class ConectarServidor extends javax.swing.JDialog {
   
    protected Aplicacion app;
    protected String ip, puerto_texto;
    protected int puerto;
    //protected Socket socket;
    protected Properties properties;
    protected InputStream leerArchivo;
    
    public ConectarServidor(java.awt.Frame parent, boolean modal, Aplicacion app) {
        super(parent, modal);
        initComponents();
        
        this.app = app;
        
        setTitle("Conectar con Servidor");
        setSize(380,216);
        setLocationRelativeTo(null);
        this.setResizable(false);
        
        //quitamos el icono que viene por defecto creando un icono transparente de 1x1
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        this.setIconImage(icon);
        
        properties = new Properties();
        try {
            //abrimos el archivo
            leerArchivo = new FileInputStream("src/aplicacion/Configuracion.properties");
            //leemos las propiedades
            properties.load(leerArchivo);
            //obtenemos las propiedades que queremos
            ip = properties.getProperty("ip");
            puerto_texto = properties.getProperty("puerto");
            //si no es null rellenamos los campos con los valores
            if((ip!=null && puerto_text!=null) && (!ip.equals("null") && !puerto_text.equals("null"))){
                ip_text.setText(ip);
                puerto_text.setText(puerto_texto);
            }
            
            leerArchivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConectarServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {        
            Logger.getLogger(ConectarServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       error_label.setVisible(false);
       error_conectar_label.setVisible(false);
    }

    ConectarServidor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_conectar_servidor = new javax.swing.JPanel();
        ip_label = new javax.swing.JLabel();
        puerto_label = new javax.swing.JLabel();
        ip_text = new javax.swing.JTextField();
        puerto_text = new javax.swing.JTextField();
        conectar_boton = new javax.swing.JButton();
        error_label = new javax.swing.JLabel();
        error_conectar_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(280, 155));

        panel_conectar_servidor.setBackground(new java.awt.Color(240, 239, 240));
        panel_conectar_servidor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panel_conectar_servidor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ip_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ip_label.setForeground(new java.awt.Color(47, 47, 40));
        ip_label.setText("IP :");
        panel_conectar_servidor.add(ip_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        puerto_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        puerto_label.setForeground(new java.awt.Color(47, 47, 40));
        puerto_label.setText("Puerto :");
        panel_conectar_servidor.add(puerto_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        ip_text.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ip_text.setForeground(new java.awt.Color(60, 63, 65));
        panel_conectar_servidor.add(ip_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 30, 140, -1));

        puerto_text.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        puerto_text.setForeground(new java.awt.Color(60, 63, 65));
        panel_conectar_servidor.add(puerto_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 70, 140, -1));

        conectar_boton.setBackground(new java.awt.Color(26, 64, 95));
        conectar_boton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        conectar_boton.setForeground(new java.awt.Color(240, 239, 240));
        conectar_boton.setText("Conectar");
        conectar_boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conectar_boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conectar_botonMouseClicked(evt);
            }
        });
        panel_conectar_servidor.add(conectar_boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 140, -1, -1));

        error_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        error_label.setForeground(new java.awt.Color(153, 0, 51));
        error_label.setText("Debe rellenar todos los campos");
        panel_conectar_servidor.add(error_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        error_conectar_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        error_conectar_label.setForeground(new java.awt.Color(153, 0, 51));
        error_conectar_label.setText("No se ha podido conectar al servidor");
        panel_conectar_servidor.add(error_conectar_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_conectar_servidor, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_conectar_servidor, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectar_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conectar_botonMouseClicked
        error_label.setVisible(false);
        error_conectar_label.setVisible(false);

        ip = ip_text.getText();
        puerto_texto = puerto_text.getText();

        if(ip.length()<1 || puerto_texto.length()<1){
            error_label.setVisible(true);
        }else{
            puerto = Integer.parseInt(puerto_texto);

            try {
                if(app.conectarConServidor(ip,puerto)){
                    properties = new Properties();
                
                    //abrimos el archivo
                    leerArchivo = new FileInputStream("src/aplicacion/Configuracion.properties");
                    //leemos las propiedades
                    properties.load(leerArchivo);
                    //damos valor a las propiedades de nuestro archivo Configuracion
                    properties.setProperty("ip", ip);
                    properties.setProperty("puerto", puerto_texto);
                    //grabamos las modificaciones de las propiedades
                    Date fecha = new Date();
                    properties.store(new FileWriter("src/aplicacion/Configuracion.properties"),"Se actualizo la Configuracion   -   "+fecha);

                    leerArchivo.close();

                    dispose();
                }else{
                    error_conectar_label.setVisible(true);
                    System.out.println("No se ha establecido conexión con el servidor. VentanaLog");
                }

            } catch (IOException ex) {                
                Logger.getLogger(ConectarServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_conectar_botonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conectar_boton;
    private javax.swing.JLabel error_conectar_label;
    private javax.swing.JLabel error_label;
    private javax.swing.JLabel ip_label;
    private javax.swing.JTextField ip_text;
    private javax.swing.JPanel panel_conectar_servidor;
    private javax.swing.JLabel puerto_label;
    private javax.swing.JTextField puerto_text;
    // End of variables declaration//GEN-END:variables
}
