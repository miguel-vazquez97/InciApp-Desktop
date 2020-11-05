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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
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
    private static final int INCIDENCIAS_EN_VALIDACION = 1;
    private static final int INCIDENCIAS_VALIDADAS = 2;
    private static final int INCIDENCIAS_ARREGLADAS = 3;
    private static final int INCIDENCIAS_DENEGADAS = 4;
    private static final int HISTORIAL_INCIDENCIAS = 5;
    private int stateIncidencias = INCIDENCIAS_NUEVAS;
    
    private boolean salirPrograma = false;
    
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
                        VentanaIncidencia ventanaNI = new VentanaIncidencia(VentanaPrincipal.this, true, app, idIncidencia, "NuevaRegistrada");
                        ventanaNI.setVisible(true);                        
                        break;
                        
                    case 1:
                        VentanaIncidencia ventanaET = new VentanaIncidencia(VentanaPrincipal.this, true, app, idIncidencia, "EnTramite");
                        ventanaET.setVisible(true);
                        break; 
                        
                    case 2:
                        VentanaIncidencia ventanaV = new VentanaIncidencia(VentanaPrincipal.this, true, app, idIncidencia, "Validada");
                        ventanaV.setVisible(true);
                        break;
                        
                    case 3:
                        System.out.println("Incidencias Arregladas");
                        break;
                        
                    case 4:
                        System.out.println("Incidencias denegadas");
                        break;
                        
                    case 5:
                        VentanaHistorialIncidencia ventanaH = new VentanaHistorialIncidencia(VentanaPrincipal.this, true, app, idIncidencia);
                        ventanaH.setVisible(true);
                        break;
                }
                mostrarDatosTabla();
             }
         }
        });

        mostrarDatosTabla();  
        
        // comboBox para filtrar nuestrar incidencias
        String[] tipoFiltro = new String[3];
        tipoFiltro[0] = "";
        tipoFiltro[1] = "Tipo incidencia";
        tipoFiltro[2] = "Fecha incidencia";
        DefaultComboBoxModel modelFiltros = new DefaultComboBoxModel(tipoFiltro);
        jComboBoxFiltro.setModel(modelFiltros);
        jComboBoxFiltro.setMaximumRowCount(tipoFiltro.length);
        jComboBoxFiltro.setEditable(true);   
        
        jComboBoxFiltro.addActionListener(new ActionListener() {
            int item;
            @Override
            public void actionPerformed(ActionEvent e){
                item = jComboBoxFiltro.getSelectedIndex();
                
                switch(item){
                    case 0:
                        jLabelTipos.setVisible(false);
                        jComboBoxTipos.setVisible(false);
                        jLabelFecha1.setVisible(false);
                        jLabelFecha2.setVisible(false);
                        text_fecha1.setVisible(false);
                        text_fecha2.setVisible(false);
                        break;
                    case 1:
                        jLabelTipos.setVisible(true);
                        jComboBoxTipos.setVisible(true);
                        jLabelFecha1.setVisible(false);
                        jLabelFecha2.setVisible(false);
                        text_fecha1.setVisible(false);
                        text_fecha2.setVisible(false);
                        break;
                    case 2:
                        jLabelTipos.setVisible(false);
                        jComboBoxTipos.setVisible(false);
                        jLabelFecha1.setVisible(true);
                        jLabelFecha2.setVisible(true);
                        text_fecha1.setVisible(true);
                        text_fecha2.setVisible(true);
                        break;
                }
            }
        });
        
        nombreTipos = new String[7];
        nombreTipos[0] = "Alumbrado";
        nombreTipos[1] = "Parques y Jardines";
        nombreTipos[2] = "Fuentes de Agua";
        nombreTipos[3] = "Alcantarillado";
        nombreTipos[4] = "Mobiliario Urbano";
        nombreTipos[5] = "Calzado y Acera";
        nombreTipos[6] = "Señales y Semáforos";
        DefaultComboBoxModel modelTipos = new DefaultComboBoxModel(nombreTipos);
        jComboBoxTipos.setModel(modelTipos);
        jComboBoxTipos.setMaximumRowCount(tipoFiltro.length);
        jComboBoxTipos.setEditable(true);   
        
        jComboBoxTipos.addActionListener(new ActionListener() {
            int item;
            public void actionPerformed(ActionEvent e){
                item = jComboBoxTipos.getSelectedIndex();
            }
        });
        jLabelTipos.setVisible(false);
        jComboBoxTipos.setVisible(false);
        jLabelFecha1.setVisible(false);
        jLabelFecha2.setVisible(false);
        text_fecha1.setVisible(false);
        text_fecha2.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ventanaPrincipal = new javax.swing.JPanel();
        panel_izquierda = new javax.swing.JPanel();
        imagen_logo = new javax.swing.JLabel();
        nombre_app = new javax.swing.JLabel();
        nombre_admin = new javax.swing.JLabel();
        panel_NI = new javax.swing.JPanel();
        label_NR = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panel_EV = new javax.swing.JPanel();
        label_EV = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panel_V = new javax.swing.JPanel();
        label_V = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        panel_A = new javax.swing.JPanel();
        label_A = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        panel_D = new javax.swing.JPanel();
        label_D = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
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
        jLabelFiltrar = new javax.swing.JLabel();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jLabelTipos = new javax.swing.JLabel();
        jComboBoxTipos = new javax.swing.JComboBox<>();
        jLabelFecha1 = new javax.swing.JLabel();
        text_fecha1 = new javax.swing.JTextField();
        jLabelFecha2 = new javax.swing.JLabel();
        text_fecha2 = new javax.swing.JTextField();
        boton_filtrar = new javax.swing.JButton();
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

        jSeparator1.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 190, 2));

        panel_EV.setBackground(new java.awt.Color(26, 64, 95));
        panel_EV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_EV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_EVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_EVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_EVMouseExited(evt);
            }
        });

        label_EV.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_EV.setForeground(new java.awt.Color(255, 255, 255));
        label_EV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_EV.setText("En validación");

        javax.swing.GroupLayout panel_EVLayout = new javax.swing.GroupLayout(panel_EV);
        panel_EV.setLayout(panel_EVLayout);
        panel_EVLayout.setHorizontalGroup(
            panel_EVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_EV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        panel_EVLayout.setVerticalGroup(
            panel_EVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_EVLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(label_EV)
                .addGap(15, 15, 15))
        );

        panel_izquierda.add(panel_EV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 212, 210, 60));

        jSeparator2.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, 190, 2));

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

        panel_izquierda.add(panel_V, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 274, 210, 60));

        jSeparator3.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 334, 190, 2));

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

        panel_izquierda.add(panel_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 336, 210, 60));

        jSeparator4.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 396, 190, 2));

        panel_D.setBackground(new java.awt.Color(26, 64, 95));
        panel_D.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_DMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_DMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_DMouseExited(evt);
            }
        });

        label_D.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_D.setForeground(new java.awt.Color(255, 255, 255));
        label_D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_D.setText("Denegadas");

        javax.swing.GroupLayout panel_DLayout = new javax.swing.GroupLayout(panel_D);
        panel_D.setLayout(panel_DLayout);
        panel_DLayout.setHorizontalGroup(
            panel_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_D, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        panel_DLayout.setVerticalGroup(
            panel_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_DLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(label_D)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel_izquierda.add(panel_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 398, 210, 60));

        jSeparator5.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 458, 190, 2));

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

        panel_izquierda.add(panel_H, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 210, 60));

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

        jLabelFiltrar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFiltrar.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltrar.setText("Filtrar:");
        panel_ventanaPrincipal.add(jLabelFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 70, 25));

        jComboBoxFiltro.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel_ventanaPrincipal.add(jComboBoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 210, 25));

        jLabelTipos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelTipos.setForeground(new java.awt.Color(47, 47, 40));
        jLabelTipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTipos.setText("Tipos incidencia:");
        panel_ventanaPrincipal.add(jLabelTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 150, 25));

        jComboBoxTipos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBoxTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel_ventanaPrincipal.add(jComboBoxTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, 210, 25));

        jLabelFecha1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFecha1.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha1.setText("Desde:");
        panel_ventanaPrincipal.add(jLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 80, 25));

        text_fecha1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_fecha1.setForeground(new java.awt.Color(60, 63, 65));
        text_fecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_fecha1KeyTyped(evt);
            }
        });
        panel_ventanaPrincipal.add(text_fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 190, 120, 25));

        jLabelFecha2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFecha2.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha2.setText("Hasta:");
        panel_ventanaPrincipal.add(jLabelFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, 80, 25));

        text_fecha2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_fecha2.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 190, 120, 25));

        boton_filtrar.setBackground(new java.awt.Color(26, 64, 95));
        boton_filtrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_filtrar.setForeground(new java.awt.Color(240, 239, 240));
        boton_filtrar.setText("Filtrar");
        boton_filtrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_filtrarActionPerformed(evt);
            }
        });
        panel_ventanaPrincipal.add(boton_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 180, -1, 40));

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
        salirPrograma = true;
        logOut();        
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

    //      BOTON FILTRAR TABLA INCIDENCIAS
    private void boton_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_filtrarActionPerformed
        int item, nTipo;
        item = jComboBoxFiltro.getSelectedIndex();
        boolean filtrar = true;
        String tipoIncidencia,fecha1,fecha2;

        ArrayList<RowTablaIncidencia> incidenciasFiltradas;
        Border border_boton_rojo = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        switch(item){
            case 0:
                JOptionPane.showMessageDialog(this, "Debe seleccionar un filtro", "Message", 1);
                break;
                
            case 1:
                nTipo = jComboBoxTipos.getSelectedIndex();
                tipoIncidencia = nombreTipos[nTipo];
                incidenciasFiltradas = new ArrayList<>();
                for(RowTablaIncidencia inci : arrayIncidencias){
                    if(inci.getTipo().equals(tipoIncidencia)){
                        incidenciasFiltradas.add(inci);
                    }
                }
                cargarTabla(incidenciasFiltradas);
                break;
            
            case 2:
                int anno, mes, dia;
                LocalDate localDate1,localDate2;
                Date dateBefore, dateAfter;
                ZoneId defaultZoneId;

                fecha1 = text_fecha1.getText();
                fecha2 = text_fecha2.getText();

                if(fecha1.isEmpty()){
                    text_fecha1.setBorder(border_boton_rojo);
                    filtrar = false;
                }else{
                    text_fecha1.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }
                if(fecha2.isEmpty()){
                    text_fecha2.setBorder(border_boton_rojo);
                    filtrar = false;
                }else{
                    text_fecha2.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }
                //si hay algun textField en blanco, dejamos de seguir comprobando las fechas
                if(!filtrar)
                return;

                //comprobamos que la fecha está en el formato correcto
                //convirtiendo la cadena en un objeto de fecha y luego volviendola a convertir en cadena
                //la cadena de fecha estará bien si ambas cadenas coinciden
                try{
                    if (( sdf.format(sdf.parse(fecha1)).equals(fecha1))
                        && (sdf.format(sdf.parse(fecha2)).equals(fecha2))){}

                } catch (java.text.ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Fecha debe tener formato yyyy-MM-dd", "Message", 1);
                    return;
                }

                try{
                    //separamos en año, mes y dia la fecha introducida por el usuario
                    anno = Integer.parseInt(fecha1.substring(0, fecha1.indexOf("-")));
                    fecha1 = fecha1.substring(fecha1.indexOf("-")+1);
                    mes = Integer.parseInt(fecha1.substring(0, fecha1.indexOf("-")));
                    dia = Integer.parseInt(fecha1.substring(fecha1.indexOf("-")+1));
                    //creamos un objecto LocalDate a partir de la fecha proporcionada
                    //si la fecha es erronea nos saltará a la excepción y no validaremos dicha fecha
                    localDate1 = LocalDate.of(anno,mes,dia);

                    anno = Integer.parseInt(fecha2.substring(0, fecha2.indexOf("-")));
                    fecha2 = fecha2.substring(fecha2.indexOf("-")+1);
                    mes = Integer.parseInt(fecha2.substring(0, fecha2.indexOf("-")));
                    dia = Integer.parseInt(fecha2.substring(fecha2.indexOf("-")+1));

                    localDate2 = LocalDate.of(anno,mes,dia);

                    //por último comprobaremos que la primera fecha proporcionada es inferior o igual a la segunda
                    if(localDate1.isBefore(localDate2) || localDate1.equals(localDate2)){
                        //pasamos nuestros objetos LocalDate a Date para realizar la comparación de filtrado
                        defaultZoneId = ZoneId.systemDefault();
                        dateBefore = Date.from(localDate1.atStartOfDay(defaultZoneId).toInstant());
                        dateAfter = Date.from(localDate2.atStartOfDay(defaultZoneId).toInstant());

                        incidenciasFiltradas = new ArrayList<>();
                        for(RowTablaIncidencia inci : arrayIncidencias){

                            if((inci.getFecha().after(dateBefore) || inci.getFecha().equals(dateBefore))
                                && (inci.getFecha().before(dateAfter) || inci.getFecha().equals(dateAfter))){

                                incidenciasFiltradas.add(inci);
                            }
                        }

                        cargarTabla(incidenciasFiltradas);

                    }else{
                        JOptionPane.showMessageDialog(this, "La segunda fecha debe ser posterior a la primera", "Message", 1);
                    }

                }catch (java.time.DateTimeException dte){
                    JOptionPane.showMessageDialog(this, "Introduzca fecha valida", "Message", 1);
                }
                break;
        }
    }//GEN-LAST:event_boton_filtrarActionPerformed

    //      LIMITE CARACTERES FECHA
    private void text_fecha1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_fecha1KeyTyped
        if(text_fecha1.getText().length() == 10)
           evt.consume();
    }//GEN-LAST:event_text_fecha1KeyTyped

    
    //      PANEL EN VALIDACION
    private void panel_EVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_EVMouseClicked
        stateIncidencias = INCIDENCIAS_EN_VALIDACION;
        titulo.setText("EN VALIDACIÓN");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_EVMouseClicked

    private void panel_EVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_EVMouseEntered
        panel_EV.setBackground(new java.awt.Color(46,134,193));
    }//GEN-LAST:event_panel_EVMouseEntered

    private void panel_EVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_EVMouseExited
         panel_EV.setBackground(new java.awt.Color(26,64,95));
    }//GEN-LAST:event_panel_EVMouseExited

    
    //      PANEL INCIDENCIAS DENEGADAS
    private void panel_DMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_DMouseClicked
        stateIncidencias = INCIDENCIAS_DENEGADAS;
        titulo.setText("DENEGADAS");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_DMouseClicked

    private void panel_DMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_DMouseEntered
         panel_D.setBackground(new java.awt.Color(46,134,193));
    }//GEN-LAST:event_panel_DMouseEntered

    private void panel_DMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_DMouseExited
        panel_D.setBackground(new java.awt.Color(26,64,95));
    }//GEN-LAST:event_panel_DMouseExited


    //      METODOS
    
    protected void logOut(){
        
        SwingWorker workerLogOut = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {            

                respuestaServidor = app.protocoloMensajes("3||logOutAdministrador||");
                resServidor = respuestaServidor.split("\\|\\|");
                          
                if(resServidor[0].equals("6") && resServidor[1].equals("logOutAdminOk")){
                    dispose();
                    
                    if(!salirPrograma){
                        VentanaLog ventanaLog = new VentanaLog();
                    }else{
                        System.exit(0);
                    }
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
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Su sesión ha caducado", "Message", 0);
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
    private javax.swing.JButton boton_filtrar;
    private javax.swing.JButton boton_minimizar;
    private javax.swing.JButton boton_refrescar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JMenu cerrarsesion_menu;
    private javax.swing.JMenuItem cerrarsesion_opciones;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JComboBox<String> jComboBoxTipos;
    private javax.swing.JLabel jLabelFecha1;
    private javax.swing.JLabel jLabelFecha2;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JLabel jLabelTipos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel label_A;
    private javax.swing.JLabel label_D;
    private javax.swing.JLabel label_EV;
    private javax.swing.JLabel label_H;
    private javax.swing.JLabel label_NR;
    private javax.swing.JLabel label_V;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel nombre_admin;
    private javax.swing.JLabel nombre_app;
    private javax.swing.JPanel panel_A;
    private javax.swing.JPanel panel_D;
    private javax.swing.JPanel panel_EV;
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
    private javax.swing.JTextField text_fecha1;
    private javax.swing.JTextField text_fecha2;
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

