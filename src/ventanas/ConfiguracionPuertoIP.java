package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author mivap
 */
public class ConfiguracionPuertoIP extends javax.swing.JFrame {

    public ConfiguracionPuertoIP() {
        initComponents();
        
        this.setTitle("Configuracion Puerto/IP");
        setSize(360, 450);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_ventana = new javax.swing.JLabel();
        titulo_ventana2 = new javax.swing.JLabel();
        label_ip = new javax.swing.JLabel();
        text_ip = new javax.swing.JTextField();
        label_puerto = new javax.swing.JLabel();
        text_puerto = new javax.swing.JTextField();
        boton_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        titulo_ventana.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        titulo_ventana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_ventana.setText("INTRODUZCA IP Y PUERTO");
        titulo_ventana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        titulo_ventana2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        titulo_ventana2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_ventana2.setText("DEL SERVIDOR");
        titulo_ventana2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        label_ip.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_ip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_ip.setText("IP :");

        text_ip.setFont(new java.awt.Font("Microsoft JhengHei", 0, 16)); // NOI18N
        text_ip.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        label_puerto.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        label_puerto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_puerto.setText("PUERTO :");

        text_puerto.setFont(new java.awt.Font("Microsoft JhengHei", 0, 16)); // NOI18N
        text_puerto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        boton_aceptar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        boton_aceptar.setText("ACEPTAR");
        boton_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_aceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo_ventana)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(titulo_ventana2)
                                .addGap(54, 54, 54)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boton_aceptar)
                        .addGap(128, 128, 128))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_puerto)
                        .addGap(18, 18, 18)
                        .addComponent(text_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(label_ip)
                        .addGap(18, 18, 18)
                        .addComponent(text_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titulo_ventana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo_ventana2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_ip)
                    .addComponent(text_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_puerto)
                    .addComponent(text_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addComponent(boton_aceptar)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_aceptarMouseClicked
        String ip = text_ip.getText();
        String puerto_txt = text_puerto.getText();

        if(ip.length()>1 && puerto_txt.length()>1){

            try {
                int puerto = Integer.parseInt(puerto_txt);

                try (Socket socket = new Socket(ip,puerto)) {
                    Properties propiedades = new Properties();
                    Date fecha;
                    try (FileInputStream leerArchivo = new FileInputStream("src/aplicacion/Configuracion.properties")) {
                        propiedades.load(leerArchivo);
                        propiedades.setProperty("ip", ip);
                        propiedades.setProperty("puerto", puerto_txt);
                        fecha = new Date();
                        propiedades.store(new FileWriter("src/aplicacion/Configuracion.properties"),"Se actualizo la Configuracion   -   "+fecha);
                    }
                    Properties configuracion = new Properties();
                    try (FileInputStream leerArchivoConfiguracion = new FileInputStream("src/aplicacion/Configuracion.inicio.properties")) {
                        configuracion.load(leerArchivoConfiguracion);
                        configuracion.setProperty("configuracionPuertoIp", "false");
                        configuracion.store(new FileWriter("src/aplicacion/Configuracion.inicio.properties"),"Se actualizo la configuracion     -   "+fecha);
                    }

                    socket.close();
                }
                firePropertyChange("ConfiguracionPuertpIPExit", null, null);
                dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(ConfiguracionPuertoIP.this, "Introduzca de nuevo Puero e IP.", "Message", 0);
                text_ip.setText("");
                text_puerto.setText("");
            }
        }
    }//GEN-LAST:event_boton_aceptarMouseClicked

    @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().
             getImage(ClassLoader.getSystemResource("imagenes/setting.png"));


       return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JLabel label_ip;
    private javax.swing.JLabel label_puerto;
    private javax.swing.JTextField text_ip;
    private javax.swing.JTextField text_puerto;
    private javax.swing.JLabel titulo_ventana;
    private javax.swing.JLabel titulo_ventana2;
    // End of variables declaration//GEN-END:variables
}
