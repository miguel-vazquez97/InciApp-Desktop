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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author mivap
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    protected Aplicacion app;
    protected Properties properties;
    protected InputStream leerArchivo;

    protected DefaultTableModel modelo;
    protected ArrayList<RowTablaIncidencia> arrayIncidencias;
    protected String[] nombreTipos;
    protected String[] nombreEstados;

    protected String respuestaServidor;
    protected String[] resServidor;

    private static final int INCIDENCIAS = 0;
    private static final int HISTORIAL_INCIDENCIAS = 1;
    private int stateIncidencias = INCIDENCIAS;

    private boolean salirPrograma = false;

    public VentanaPrincipal(Aplicacion app) {
        initComponents();

        setSize(1440, 810);
        setLocationRelativeTo(null);

        this.app = app;
        properties = new Properties();

        nombre_admin.setText(app.getNombreAdmin());

        titulo.setText("INCIDENCIAS");
        boton_refrescar.setBorder(new RoundedBorder(40));
        progressBar.setVisible(false);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        modelo.addColumn("Tipo");
        modelo.addColumn("Descripción");
        modelo.addColumn("Dirección");

        tabla_datos.setModel(modelo);
        tabla_datos.setRowHeight(30);
        JTableHeader header = tabla_datos.getTableHeader();
        header.setBackground(new java.awt.Color(26, 64, 95));
        header.setForeground(Color.white);
        header.setFont(new Font("Dialog", Font.BOLD, 20));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tabla_datos.setTableHeader(header);
        header.setCursor(new Cursor(HAND_CURSOR));
        tabla_datos.setAutoCreateRowSorter(true);

        tabla_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                //Point p = me.getPoint();
                //int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    int linea = table.getSelectedRow();
                    int idIncidencia = arrayIncidencias.get(linea).getId();
                    String estado = arrayIncidencias.get(linea).getEstado();
                    switch(stateIncidencias){
                        case 0:

                                switch(estado){
                                    case "Solucionada":
                                    case "Denegada":
                                        VentanaHistorialIncidencia ventanaHistorialIncidencia = new VentanaHistorialIncidencia(VentanaPrincipal.this, true, app, idIncidencia);
                                        ventanaHistorialIncidencia.setVisible(true);
                                        break;
                                        
                                    case "Arreglada":
                                        VentanaIncidenciaArreglada ventanaIncidenciaArreglada = new VentanaIncidenciaArreglada(VentanaPrincipal.this, true, app, idIncidencia);
                                        ventanaIncidenciaArreglada.setVisible(true);
                                        break;
                                        
                                    default:
                                        VentanaIncidencia ventanaI = new VentanaIncidencia(VentanaPrincipal.this, true, app, idIncidencia, estado);
                                        ventanaI.setVisible(true);
                                        break;
                                }                                
                            break;
                            
                        case 1:
                                if(estado.equals("NuevaRegistrada")){
                                    VentanaIncidencia ventanaI = new VentanaIncidencia(VentanaPrincipal.this, true, app, idIncidencia, estado);
                                    ventanaI.setVisible(true);
                                }else{
                                    VentanaHistorialIncidencia ventanaHistorialIncidencia = new VentanaHistorialIncidencia(VentanaPrincipal.this, true, app, idIncidencia);
                                    ventanaHistorialIncidencia.setVisible(true);
                                }
                            break;
                    }
                    //se estan en uno de estos dos estados significa que puede haber hecho una modificadion (asignar supervisor/empleado)
                    //refrescaremos la tabla de incidencias 
                    if(estado.equals("NuevaRegistrada") || estado.equals("Validada") || estado.equals("Arreglada")){
                        mostrarDatosTabla();
                    }
                }
            }
        });

        mostrarDatosTabla();

        nombreEstados = new String[9];
        nombreEstados[0] = "";
        nombreEstados[1] = "NuevaRegistrada";
        nombreEstados[2] = "EnTramite";
        nombreEstados[3] = "Validadas";
        nombreEstados[4] = "EnArreglo";
        nombreEstados[5] = "ValidarArreglo";
        nombreEstados[6] = "Arreglada";
        nombreEstados[7] = "Solucionada";
        nombreEstados[8] = "Denegadas";
        DefaultComboBoxModel modelEstados = new DefaultComboBoxModel(nombreEstados);
        jComboBoxEstados.setModel(modelEstados);
        jComboBoxEstados.setMaximumRowCount(nombreEstados.length);
        jComboBoxEstados.setEditable(true);
        jComboBoxEstados.setSelectedIndex(0);

        nombreTipos = new String[8];
        nombreTipos[0] = "";
        nombreTipos[1] = "Alumbrado";
        nombreTipos[2] = "Parques y Jardines";
        nombreTipos[3] = "Fuentes de Agua";
        nombreTipos[4] = "Alcantarillado";
        nombreTipos[5] = "Mobiliario Urbano";
        nombreTipos[6] = "Calzado y Acera";
        nombreTipos[7] = "Señales y Semáforos";
        DefaultComboBoxModel modelTipos = new DefaultComboBoxModel(nombreTipos);
        jComboBoxTipos.setModel(modelTipos);
        jComboBoxTipos.setMaximumRowCount(nombreTipos.length);
        jComboBoxTipos.setEditable(true);
        jComboBoxTipos.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ventanaPrincipal = new javax.swing.JPanel();
        panel_izquierda = new javax.swing.JPanel();
        imagen_logo = new javax.swing.JLabel();
        nombre_app = new javax.swing.JLabel();
        nombre_admin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panel_I = new javax.swing.JPanel();
        label_I = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panel_HI = new javax.swing.JPanel();
        label_HI = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        boton_salir = new javax.swing.JButton();
        boton_minimizar = new javax.swing.JButton();
        separador_titulo_up = new javax.swing.JSeparator();
        titulo = new javax.swing.JLabel();
        separador_titulo_down = new javax.swing.JSeparator();
        boton_refrescar = new javax.swing.JButton();
        progressBar = new rojerusan.componentes.RSProgressMaterial();
        scrollpane_tabla = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();
        jLabelEstados = new javax.swing.JLabel();
        jComboBoxEstados = new javax.swing.JComboBox<>();
        jLabelTipos = new javax.swing.JLabel();
        jComboBoxTipos = new javax.swing.JComboBox<>();
        jLabelFecha1 = new javax.swing.JLabel();
        text_fecha1 = new javax.swing.JTextField();
        jLabelFecha2 = new javax.swing.JLabel();
        text_fecha2 = new javax.swing.JTextField();
        boton_filtrar = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        gestion_menu = new javax.swing.JMenu();
        gestionar_administrador = new javax.swing.JMenuItem();
        registrar_supervisor = new javax.swing.JMenuItem();
        gestionar_supervisor = new javax.swing.JMenuItem();
        registrar_empleado = new javax.swing.JMenuItem();
        gestionar_empleado = new javax.swing.JMenuItem();
        gestionar_ciudadano = new javax.swing.JMenuItem();
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

        jSeparator1.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, 150, 2));

        panel_I.setBackground(new java.awt.Color(26, 64, 95));
        panel_I.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_IMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_IMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_IMouseExited(evt);
            }
        });

        label_I.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_I.setForeground(new java.awt.Color(255, 255, 255));
        label_I.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_I.setText("Incidencias");

        javax.swing.GroupLayout panel_ILayout = new javax.swing.GroupLayout(panel_I);
        panel_I.setLayout(panel_ILayout);
        panel_ILayout.setHorizontalGroup(
            panel_ILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_I, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        panel_ILayout.setVerticalGroup(
            panel_ILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ILayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(label_I)
                .addGap(15, 15, 15))
        );

        panel_izquierda.add(panel_I, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 274, 170, 60));

        jSeparator2.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 334, 150, 2));

        panel_HI.setBackground(new java.awt.Color(26, 64, 95));
        panel_HI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_HI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_HIMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_HIMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_HIMouseExited(evt);
            }
        });

        label_HI.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_HI.setForeground(new java.awt.Color(255, 255, 255));
        label_HI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_HI.setText("Historial");

        javax.swing.GroupLayout panel_HILayout = new javax.swing.GroupLayout(panel_HI);
        panel_HI.setLayout(panel_HILayout);
        panel_HILayout.setHorizontalGroup(
            panel_HILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_HI, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        panel_HILayout.setVerticalGroup(
            panel_HILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_HILayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(label_HI)
                .addGap(16, 16, 16))
        );

        panel_izquierda.add(panel_HI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 336, 170, 60));

        jSeparator3.setBackground(new java.awt.Color(46, 134, 193));
        panel_izquierda.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 396, 150, 2));

        panel_ventanaPrincipal.add(panel_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 810));

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
        panel_ventanaPrincipal.add(separador_titulo_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 55, 850, 3));

        titulo.setBackground(new java.awt.Color(26, 64, 95));
        titulo.setFont(new java.awt.Font("Dialog", 0, 50)); // NOI18N
        titulo.setForeground(new java.awt.Color(26, 64, 95));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("TITULO");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_ventanaPrincipal.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 60, 850, 80));

        separador_titulo_down.setBackground(new java.awt.Color(26, 64, 95));
        panel_ventanaPrincipal.add(separador_titulo_down, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 145, 850, 3));

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
        panel_ventanaPrincipal.add(boton_refrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 250, 35, 35));

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

        panel_ventanaPrincipal.add(scrollpane_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 1070, 500));

        jLabelEstados.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelEstados.setForeground(new java.awt.Color(47, 47, 40));
        jLabelEstados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEstados.setText("Estado:");
        panel_ventanaPrincipal.add(jLabelEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 150, 25));

        jComboBoxEstados.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        panel_ventanaPrincipal.add(jComboBoxEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 210, 25));

        jLabelTipos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelTipos.setForeground(new java.awt.Color(47, 47, 40));
        jLabelTipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTipos.setText("Tipo:");
        panel_ventanaPrincipal.add(jLabelTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 150, 25));

        jComboBoxTipos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        panel_ventanaPrincipal.add(jComboBoxTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 210, 25));

        jLabelFecha1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFecha1.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha1.setText("Desde:");
        panel_ventanaPrincipal.add(jLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 80, 25));

        text_fecha1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_fecha1.setForeground(new java.awt.Color(60, 63, 65));
        text_fecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_fecha1KeyTyped(evt);
            }
        });
        panel_ventanaPrincipal.add(text_fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 120, 25));

        jLabelFecha2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFecha2.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha2.setText("Hasta:");
        panel_ventanaPrincipal.add(jLabelFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 190, 80, 25));

        text_fecha2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text_fecha2.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, 120, 25));

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
        panel_ventanaPrincipal.add(boton_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 180, -1, 40));

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

        gestion_menu.setText("Gestión...");

        gestionar_administrador.setText("Gestionar Administrador");
        gestionar_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionar_administradorActionPerformed(evt);
            }
        });
        gestion_menu.add(gestionar_administrador);

        registrar_supervisor.setText("Registrar supervisor");
        registrar_supervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_supervisorActionPerformed(evt);
            }
        });
        gestion_menu.add(registrar_supervisor);

        gestionar_supervisor.setText("Gestionar supervisor");
        gestionar_supervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionar_supervisorActionPerformed(evt);
            }
        });
        gestion_menu.add(gestionar_supervisor);

        registrar_empleado.setText("Registrar empleado");
        registrar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_empleadoActionPerformed(evt);
            }
        });
        gestion_menu.add(registrar_empleado);

        gestionar_empleado.setText("Gestionar empleado");
        gestionar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionar_empleadoActionPerformed(evt);
            }
        });
        gestion_menu.add(gestionar_empleado);

        gestionar_ciudadano.setText("Gestionar ciudadano");
        gestionar_ciudadano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionar_ciudadanoActionPerformed(evt);
            }
        });
        gestion_menu.add(gestionar_ciudadano);

        menu.add(gestion_menu);

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
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_menuMousePressed

    private void menuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
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

    //      PANEL INCIDENCIAS
    private void panel_IMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_IMouseClicked
        stateIncidencias = INCIDENCIAS;
        titulo.setText("INCIDENCIAS");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_IMouseClicked

    private void panel_IMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_IMouseEntered
        panel_I.setBackground(new java.awt.Color(46, 134, 193));
    }//GEN-LAST:event_panel_IMouseEntered

    private void panel_IMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_IMouseExited
        panel_I.setBackground(new java.awt.Color(26, 64, 95));
    }//GEN-LAST:event_panel_IMouseExited

    //      PANEL HISTORIAL INCIDENCIAS
    private void panel_HIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_HIMouseClicked
        stateIncidencias = HISTORIAL_INCIDENCIAS;
        titulo.setText("HISTORIAL INCIDENCIAS");
        mostrarDatosTabla();
    }//GEN-LAST:event_panel_HIMouseClicked

    private void panel_HIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_HIMouseEntered
        panel_HI.setBackground(new java.awt.Color(46, 134, 193));
    }//GEN-LAST:event_panel_HIMouseEntered

    private void panel_HIMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_HIMouseExited
        panel_HI.setBackground(new java.awt.Color(26, 64, 95));
    }//GEN-LAST:event_panel_HIMouseExited

    //      BOTON REFRESCAR TABLA
    private void boton_refrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_refrescarMouseClicked
        jComboBoxTipos.setSelectedIndex(-1);
        jComboBoxEstados.setSelectedIndex(-1);
        text_fecha1.setText("");
        text_fecha2.setText("");
        mostrarDatosTabla();
    }//GEN-LAST:event_boton_refrescarMouseClicked

    //      BOTON FILTRAR TABLA INCIDENCIAS
    private void boton_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_filtrarActionPerformed
        int nEstado, nTipo;
        boolean filtrar = false;
        String estadoIncidencia, tipoIncidencia, fecha1, fecha2;

        ArrayList<RowTablaIncidencia> incidenciasFiltradas = new ArrayList<>();
        ArrayList<RowTablaIncidencia> incidenciasFiltradasAux;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        nEstado = jComboBoxEstados.getSelectedIndex();
        if (nEstado > 0) {
            filtrar = true;
            estadoIncidencia = nombreEstados[nEstado];

            for (RowTablaIncidencia inci : arrayIncidencias) {
                if (inci.getEstado().equals(estadoIncidencia)) {
                    incidenciasFiltradas.add(inci);
                }
            }
        }

        nTipo = jComboBoxTipos.getSelectedIndex();
        if (nTipo > 0) {            
            tipoIncidencia = nombreTipos[nTipo];
            //comprobamos si ya hemos filtrado anteriormente por estados
            //si esta vacia la coleccion significa que aún no hemos filtrado
            if (incidenciasFiltradas.isEmpty() && filtrar==false) {
                filtrar = true;
                for (RowTablaIncidencia inci : arrayIncidencias) {
                    if (inci.getTipo().equals(tipoIncidencia)) {
                        incidenciasFiltradas.add(inci);
                    }
                }
            } else {
                //creamos una coleccion auxiliar ya que hemos filtrado anteriormente por estado
                incidenciasFiltradasAux = new ArrayList<>();
                for (RowTablaIncidencia inci : incidenciasFiltradas) {
                    if (inci.getTipo().equals(tipoIncidencia)) {
                        incidenciasFiltradasAux.add(inci);
                    }
                }
                //eliminamos los elementos de nuestra coleccion anterior
                incidenciasFiltradas.clear();
                //añadimos los elementos filtrados
                incidenciasFiltradas.addAll(incidenciasFiltradasAux);
                incidenciasFiltradasAux.clear();
            }
        }

        int anno, mes, dia;
        LocalDate localDate1, localDate2;
        Date dateBefore, dateAfter;
        ZoneId defaultZoneId;

        fecha1 = text_fecha1.getText();
        fecha2 = text_fecha2.getText();

        if (!fecha1.isEmpty() && !fecha2.isEmpty()) {
            filtrar = false;
            //comprobamos que la fecha está en el formato correcto
            //convirtiendo la cadena en un objeto de fecha y luego volviendola a convertir en cadena
            //la cadena de fecha estará bien si ambas cadenas coinciden
            try {
                if ((sdf.format(sdf.parse(fecha1)).equals(fecha1))
                        && (sdf.format(sdf.parse(fecha2)).equals(fecha2))) {
                }
            } catch (java.text.ParseException ex) {
                JOptionPane.showMessageDialog(this, "Fecha debe tener formato yyyy-MM-dd", "Message", 1);
                return;
            }

            try {
                //separamos en año, mes y dia la fecha introducida por el usuario
                anno = Integer.parseInt(fecha1.substring(0, fecha1.indexOf("-")));
                fecha1 = fecha1.substring(fecha1.indexOf("-") + 1);
                mes = Integer.parseInt(fecha1.substring(0, fecha1.indexOf("-")));
                dia = Integer.parseInt(fecha1.substring(fecha1.indexOf("-") + 1));
                //creamos un objecto LocalDate a partir de la fecha proporcionada
                //si la fecha es erronea nos saltará a la excepción y no validaremos dicha fecha
                localDate1 = LocalDate.of(anno, mes, dia);

                anno = Integer.parseInt(fecha2.substring(0, fecha2.indexOf("-")));
                fecha2 = fecha2.substring(fecha2.indexOf("-") + 1);
                mes = Integer.parseInt(fecha2.substring(0, fecha2.indexOf("-")));
                dia = Integer.parseInt(fecha2.substring(fecha2.indexOf("-") + 1));

                localDate2 = LocalDate.of(anno, mes, dia);

                //por último comprobaremos que la primera fecha proporcionada es inferior o igual a la segunda
                if (localDate1.isBefore(localDate2) || localDate1.equals(localDate2)) {
                    //pasamos nuestros objetos LocalDate a Date para realizar la comparación de filtrado                    
                    defaultZoneId = ZoneId.systemDefault();
                    dateBefore = Date.from(localDate1.atStartOfDay(defaultZoneId).toInstant());
                    dateAfter = Date.from(localDate2.atStartOfDay(defaultZoneId).toInstant());

                    if (incidenciasFiltradas.isEmpty() && filtrar==false) {
                        filtrar = true;
                        
                        for (RowTablaIncidencia inci : arrayIncidencias) {
                            if ((inci.getFecha().after(dateBefore) || inci.getFecha().equals(dateBefore))
                                    && (inci.getFecha().before(dateAfter) || inci.getFecha().equals(dateAfter))) {
                                incidenciasFiltradas.add(inci);
                            }
                        }
                    } else {
                        //creamos una coleccion auxiliar ya que hemos filtrado anteriormente por estado || tipo || tipo y estado
                        incidenciasFiltradasAux = new ArrayList<>();
                        for (RowTablaIncidencia inci : incidenciasFiltradas) {
                            if ((inci.getFecha().after(dateBefore) || inci.getFecha().equals(dateBefore))
                                    && (inci.getFecha().before(dateAfter) || inci.getFecha().equals(dateAfter))) {
                                incidenciasFiltradasAux.add(inci);
                            }
                        }
                        //eliminamos los elementos de nuestra coleccion anterior
                        incidenciasFiltradas.clear();
                        //añadimos los elementos filtrados
                        incidenciasFiltradas.addAll(incidenciasFiltradasAux);
                        incidenciasFiltradasAux.clear();
                    }

                    

                } else {
                    JOptionPane.showMessageDialog(this, "La segunda fecha debe ser posterior a la primera", "Message", 1);
                }

            } catch (java.time.DateTimeException dte) {
                JOptionPane.showMessageDialog(this, "Introduzca fecha valida", "Message", 1);
            }
        }

        if (filtrar) 
            cargarTabla(incidenciasFiltradas);
        
        
        if(nEstado==0 && nTipo==00 & fecha1.isEmpty() && fecha2.isEmpty())
            cargarTabla(arrayIncidencias);
        
    }//GEN-LAST:event_boton_filtrarActionPerformed

    //      LIMITE CARACTERES FECHA
    private void text_fecha1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_fecha1KeyTyped
        if (text_fecha1.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_text_fecha1KeyTyped

    //      GESTIONAR ADMINISTRADOR
    private void gestionar_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionar_administradorActionPerformed
        VentanaModificarAdministrador ventanaModificarAdministrador = new VentanaModificarAdministrador(this, true, app);
        ventanaModificarAdministrador.setVisible(true);
        nombre_admin.setText(app.getNombreAdmin());
    }//GEN-LAST:event_gestionar_administradorActionPerformed

    //      REGISTRAR SUPERVISOR
    private void registrar_supervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_supervisorActionPerformed
        VentanaRegistrarUsuario ventanaRegistrar = new VentanaRegistrarUsuario(this, true, app, 2);
        ventanaRegistrar.setVisible(true);
    }//GEN-LAST:event_registrar_supervisorActionPerformed
    //      GESTIONAR SUPERVISOR
    private void gestionar_supervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionar_supervisorActionPerformed
        VentanaGestionarUsuario ventanaGestionarUsuario = new VentanaGestionarUsuario(this, true, app, 2);
        ventanaGestionarUsuario.setVisible(true);
    }//GEN-LAST:event_gestionar_supervisorActionPerformed

    //      REGISTRAR EMPLEADO
    private void registrar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_empleadoActionPerformed
        VentanaRegistrarUsuario ventanaRegistrar = new VentanaRegistrarUsuario(this, true, app, 3);
        ventanaRegistrar.setVisible(true);
    }//GEN-LAST:event_registrar_empleadoActionPerformed
    //      GESTIONAR EMPLEADO
    private void gestionar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionar_empleadoActionPerformed
       VentanaGestionarUsuario ventanaGestionarUsuario = new VentanaGestionarUsuario(this, true, app, 3);
        ventanaGestionarUsuario.setVisible(true);
    }//GEN-LAST:event_gestionar_empleadoActionPerformed

    //      GESTIONAR CIUDADANO
    private void gestionar_ciudadanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionar_ciudadanoActionPerformed
        VentanaGestionarUsuario ventanaGestionarUsuario = new VentanaGestionarUsuario(this, true, app, 4);
        ventanaGestionarUsuario.setVisible(true);
    }//GEN-LAST:event_gestionar_ciudadanoActionPerformed

    //      METODOS
    protected void logOut() {

        SwingWorker workerLogOut = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                respuestaServidor = app.protocoloMensajes("3||logOutAdministrador||");
                resServidor = respuestaServidor.split("\\|\\|");

                if ((resServidor[0].equals("6") && resServidor[1].equals("logOutAdminOk")) || (resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada"))) {
                    dispose();

                    if (!salirPrograma) {
                        VentanaLog ventanaLog = new VentanaLog();
                        ventanaLog.setVisible(true);
                    } else {
                        System.exit(0);
                    }
                }
                
                return null;
            }

        };

        workerLogOut.execute();
    }

    protected void mostrarDatosTabla() {

        SwingWorker workerDatosTabla = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                progressBar.setVisible(true);

                respuestaServidor = app.protocoloMensajes("4||" + app.getCorreo() + "||" + stateIncidencias + "||");
                
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }
                
                resServidor = respuestaServidor.split("\\|\\|");

                if (resServidor[0].equals("7") && resServidor[1].equals("listadoIncidenciasOk")) {
                    arrayIncidencias = app.getArrayIncidencias();
                    cargarTabla(arrayIncidencias);
                }

                if (resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Su sesión ha caducado", "Message", 0);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                    ventanaLog.setVisible(true);
                }

                progressBar.setVisible(false);
                return null;
            }

        };

        workerDatosTabla.execute();
    }

    protected void cargarTabla(ArrayList<RowTablaIncidencia> arrayIncidencias) {
        String[] datos = new String[5];

        int filas = tabla_datos.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }

        for (RowTablaIncidencia inci : arrayIncidencias) {
            datos[0] = new SimpleDateFormat("yyyy-MM-dd").format(inci.getFecha());
            datos[1] = inci.getEstado();
            datos[2] = inci.getTipo();
            datos[3] = inci.getDescripcion();
            datos[4] = inci.getDireccion();
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
    private javax.swing.JMenu gestion_menu;
    private javax.swing.JMenuItem gestionar_administrador;
    private javax.swing.JMenuItem gestionar_ciudadano;
    private javax.swing.JMenuItem gestionar_empleado;
    private javax.swing.JMenuItem gestionar_supervisor;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JComboBox<String> jComboBoxEstados;
    private javax.swing.JComboBox<String> jComboBoxTipos;
    private javax.swing.JLabel jLabelEstados;
    private javax.swing.JLabel jLabelFecha1;
    private javax.swing.JLabel jLabelFecha2;
    private javax.swing.JLabel jLabelTipos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel label_HI;
    private javax.swing.JLabel label_I;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel nombre_admin;
    private javax.swing.JLabel nombre_app;
    private javax.swing.JPanel panel_HI;
    private javax.swing.JPanel panel_I;
    private javax.swing.JPanel panel_izquierda;
    private javax.swing.JPanel panel_ventanaPrincipal;
    private rojerusan.componentes.RSProgressMaterial progressBar;
    private javax.swing.JMenuItem registrar_empleado;
    private javax.swing.JMenuItem registrar_supervisor;
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
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
