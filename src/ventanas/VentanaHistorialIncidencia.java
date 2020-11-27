package ventanas;

import aplicacion.Aplicacion;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
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
public class VentanaHistorialIncidencia extends javax.swing.JDialog {
    
    protected Aplicacion app;
    protected VentanaPrincipal vp;
    protected int idIncidencia;
    
    protected String respuestaServidor;
    protected String[] resServidor; 
    protected BASE64Decoder decoder;

    public VentanaHistorialIncidencia(VentanaPrincipal vp, boolean modal, Aplicacion app, int idIncidencia) {
        super(vp, modal);
        initComponents();
        
        this.vp=vp;
        this.app=app;
        this.idIncidencia=idIncidencia;
        
        setSize(1440, 810);               
        setLocationRelativeTo(null);   
        
        progressBar.setVisible(false);
        
        panel_principal.setPreferredSize(new Dimension(1440,1800));
        scrollpanel.setViewportView(panel_principal);
        add(scrollpanel);
        
        detallesIncidencia();
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
        jLabelNuevaRegistrada = new javax.swing.JLabel();
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
        jLabelAdministrador = new javax.swing.JLabel();
        text_administrador = new javax.swing.JTextField();
        jLabelDepartamento = new javax.swing.JLabel();
        text_departamento = new javax.swing.JTextField();
        jLabelSupervisor = new javax.swing.JLabel();
        text_supervisor = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        text_empleado = new javax.swing.JTextField();
        jLabelImagen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelEnTramite = new javax.swing.JLabel();
        jLabelFechaET = new javax.swing.JLabel();
        text_fechaET = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelValidada = new javax.swing.JLabel();
        jLabelFechaV = new javax.swing.JLabel();
        text_fechaV = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelEnArreglo = new javax.swing.JLabel();
        jLabelFechaEA = new javax.swing.JLabel();
        text_fechaEA = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelValidarArreglo = new javax.swing.JLabel();
        jLabelFechaVA = new javax.swing.JLabel();
        text_fechaVA = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelArreglada = new javax.swing.JLabel();
        jLabelFechaA = new javax.swing.JLabel();
        text_fechaA = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabelSolucionada = new javax.swing.JLabel();
        jLabelFechaS = new javax.swing.JLabel();
        text_fechaS = new javax.swing.JTextField();
        jLabelDescripcionS = new javax.swing.JLabel();
        jScrollDescripcionS = new javax.swing.JScrollPane();
        text_descripcionS = new javax.swing.JTextArea();
        jLabelImagenS = new javax.swing.JLabel();
        jLabelDenegada = new javax.swing.JLabel();
        jLabelFechaD = new javax.swing.JLabel();
        text_fechaD = new javax.swing.JTextField();
        jLabelDescripcionD = new javax.swing.JLabel();
        jScrollDescripcionD = new javax.swing.JScrollPane();
        text_descripcionD = new javax.swing.JTextArea();
        progressBar = new rojerusan.componentes.RSProgressMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelUp_ventana.setBackground(new java.awt.Color(26, 64, 95));
        panelUp_ventana.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
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
        panelUp_ventana.add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 15, 30, 30));

        imagen_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp_icono.jpg"))); // NOI18N
        panelUp_ventana.add(imagen_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, 31, 32));

        nombre_app.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        nombre_app.setForeground(new java.awt.Color(255, 255, 255));
        nombre_app.setText("InciApp  -  Historial Incidencia");
        panelUp_ventana.add(nombre_app, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, -1, -1));

        scrollpanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpanel.setPreferredSize(new java.awt.Dimension(1440, 810));

        panel_principal.setBackground(new java.awt.Color(240, 239, 240));
        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panel_principal.setForeground(new java.awt.Color(60, 63, 65));
        panel_principal.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        panel_principal.setMinimumSize(new java.awt.Dimension(1440, 1900));
        panel_principal.setPreferredSize(new java.awt.Dimension(1440, 1900));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNuevaRegistrada.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelNuevaRegistrada.setForeground(new java.awt.Color(47, 47, 40));
        jLabelNuevaRegistrada.setText("Registro Incidencia");
        panel_principal.add(jLabelNuevaRegistrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

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
        panel_principal.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, 50));

        text_direccion.setEditable(false);
        text_direccion.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_direccion.setForeground(new java.awt.Color(60, 63, 65));
        text_direccion.setBorder(null);
        panel_principal.add(text_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 310, 25));

        jLabelAdministrador.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelAdministrador.setForeground(new java.awt.Color(47, 47, 40));
        jLabelAdministrador.setText("Administrador:");
        panel_principal.add(jLabelAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, -1, 50));

        text_administrador.setEditable(false);
        text_administrador.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_administrador.setForeground(new java.awt.Color(60, 63, 65));
        text_administrador.setBorder(null);
        panel_principal.add(text_administrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 504, 310, 25));

        jLabelDepartamento.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDepartamento.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDepartamento.setText("Departamento:");
        panel_principal.add(jLabelDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, -1));

        text_departamento.setEditable(false);
        text_departamento.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_departamento.setForeground(new java.awt.Color(60, 63, 65));
        text_departamento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        text_departamento.setBorder(null);
        panel_principal.add(text_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 310, 25));

        jLabelSupervisor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelSupervisor.setForeground(new java.awt.Color(47, 47, 40));
        jLabelSupervisor.setText("Supervisor:");
        panel_principal.add(jLabelSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, -1, -1));

        text_supervisor.setEditable(false);
        text_supervisor.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_supervisor.setForeground(new java.awt.Color(60, 63, 65));
        text_supervisor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        text_supervisor.setBorder(null);
        panel_principal.add(text_supervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 630, 310, 25));

        jLabelEmpleado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(47, 47, 40));
        jLabelEmpleado.setText("Empleado:");
        panel_principal.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 700, -1, -1));

        text_empleado.setEditable(false);
        text_empleado.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_empleado.setForeground(new java.awt.Color(60, 63, 65));
        text_empleado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        text_empleado.setBorder(null);
        panel_principal.add(text_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 700, 310, 25));

        jLabelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp.png"))); // NOI18N
        panel_principal.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 390, 450));

        jSeparator1.setBackground(new java.awt.Color(26, 64, 95));
        panel_principal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 770, 940, -1));

        jLabelEnTramite.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelEnTramite.setForeground(new java.awt.Color(47, 47, 40));
        jLabelEnTramite.setText("En Tramite");
        panel_principal.add(jLabelEnTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 790, -1, -1));

        jLabelFechaET.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaET.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaET.setText("Fecha:");
        panel_principal.add(jLabelFechaET, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 800, -1, -1));

        text_fechaET.setEditable(false);
        text_fechaET.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fechaET.setForeground(new java.awt.Color(60, 63, 65));
        text_fechaET.setBorder(null);
        panel_principal.add(text_fechaET, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 800, 310, 25));

        jSeparator2.setBackground(new java.awt.Color(26, 64, 95));
        panel_principal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 870, 940, -1));

        jLabelValidada.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelValidada.setForeground(new java.awt.Color(47, 47, 40));
        jLabelValidada.setText("Validada");
        panel_principal.add(jLabelValidada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 890, -1, -1));

        jLabelFechaV.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaV.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaV.setText("Fecha:");
        panel_principal.add(jLabelFechaV, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 900, -1, -1));

        text_fechaV.setEditable(false);
        text_fechaV.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fechaV.setForeground(new java.awt.Color(60, 63, 65));
        text_fechaV.setBorder(null);
        panel_principal.add(text_fechaV, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 900, 310, 25));

        jSeparator3.setBackground(new java.awt.Color(26, 64, 95));
        panel_principal.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 970, 970, -1));

        jLabelEnArreglo.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelEnArreglo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelEnArreglo.setText("En Arreglo");
        panel_principal.add(jLabelEnArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 990, -1, -1));

        jLabelFechaEA.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaEA.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaEA.setText("Fecha:");
        panel_principal.add(jLabelFechaEA, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 1000, -1, -1));

        text_fechaEA.setEditable(false);
        text_fechaEA.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fechaEA.setForeground(new java.awt.Color(60, 63, 65));
        text_fechaEA.setBorder(null);
        panel_principal.add(text_fechaEA, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1000, 310, 25));

        jSeparator4.setBackground(new java.awt.Color(26, 64, 95));
        panel_principal.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1070, 970, -1));

        jLabelValidarArreglo.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelValidarArreglo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelValidarArreglo.setText("Validación arreglo");
        panel_principal.add(jLabelValidarArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1090, -1, -1));

        jLabelFechaVA.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaVA.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaVA.setText("Fecha:");
        panel_principal.add(jLabelFechaVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 1100, -1, -1));

        text_fechaVA.setEditable(false);
        text_fechaVA.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fechaVA.setForeground(new java.awt.Color(60, 63, 65));
        text_fechaVA.setBorder(null);
        panel_principal.add(text_fechaVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1100, 310, 25));

        jSeparator5.setBackground(new java.awt.Color(26, 64, 95));
        panel_principal.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1170, 970, -1));

        jLabelArreglada.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelArreglada.setForeground(new java.awt.Color(47, 47, 40));
        jLabelArreglada.setText("Arreglada");
        panel_principal.add(jLabelArreglada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1190, -1, -1));

        jLabelFechaA.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaA.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaA.setText("Fecha:");
        panel_principal.add(jLabelFechaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 1200, -1, -1));

        text_fechaA.setEditable(false);
        text_fechaA.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fechaA.setForeground(new java.awt.Color(60, 63, 65));
        text_fechaA.setBorder(null);
        panel_principal.add(text_fechaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1200, 310, 25));

        jSeparator6.setBackground(new java.awt.Color(26, 64, 95));
        panel_principal.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1270, 970, -1));

        jLabelSolucionada.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelSolucionada.setForeground(new java.awt.Color(47, 47, 40));
        jLabelSolucionada.setText("Solucionada");
        panel_principal.add(jLabelSolucionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1290, -1, -1));

        jLabelFechaS.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaS.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaS.setText("Fecha:");
        panel_principal.add(jLabelFechaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 1350, -1, -1));

        text_fechaS.setEditable(false);
        text_fechaS.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fechaS.setForeground(new java.awt.Color(60, 63, 65));
        text_fechaS.setBorder(null);
        panel_principal.add(text_fechaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1350, 310, 25));

        jLabelDescripcionS.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDescripcionS.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDescripcionS.setText("Descripción:");
        panel_principal.add(jLabelDescripcionS, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1410, -1, -1));

        jScrollDescripcionS.setBackground(new java.awt.Color(240, 239, 240));
        jScrollDescripcionS.setForeground(new java.awt.Color(60, 63, 65));
        jScrollDescripcionS.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        text_descripcionS.setEditable(false);
        text_descripcionS.setBackground(new java.awt.Color(240, 239, 240));
        text_descripcionS.setColumns(20);
        text_descripcionS.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_descripcionS.setForeground(new java.awt.Color(60, 63, 65));
        text_descripcionS.setLineWrap(true);
        text_descripcionS.setRows(10);
        text_descripcionS.setWrapStyleWord(true);
        text_descripcionS.setBorder(null);
        text_descripcionS.setDisabledTextColor(new java.awt.Color(60, 63, 65));
        jScrollDescripcionS.setViewportView(text_descripcionS);

        panel_principal.add(jScrollDescripcionS, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1410, 310, 110));

        jLabelImagenS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagenS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_inciapp.png"))); // NOI18N
        panel_principal.add(jLabelImagenS, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 1350, 400, 500));

        jLabelDenegada.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabelDenegada.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDenegada.setText("Denegada");
        panel_principal.add(jLabelDenegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 840, -1, -1));

        jLabelFechaD.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFechaD.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFechaD.setText("Fecha:");
        panel_principal.add(jLabelFechaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 930, -1, -1));

        text_fechaD.setEditable(false);
        text_fechaD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_fechaD.setForeground(new java.awt.Color(60, 63, 65));
        text_fechaD.setBorder(null);
        panel_principal.add(text_fechaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 930, 310, 25));

        jLabelDescripcionD.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelDescripcionD.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDescripcionD.setText("Descripción:");
        panel_principal.add(jLabelDescripcionD, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 930, -1, -1));

        jScrollDescripcionD.setBackground(new java.awt.Color(240, 239, 240));
        jScrollDescripcionD.setForeground(new java.awt.Color(60, 63, 65));
        jScrollDescripcionD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        text_descripcionD.setEditable(false);
        text_descripcionD.setBackground(new java.awt.Color(240, 239, 240));
        text_descripcionD.setColumns(20);
        text_descripcionD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        text_descripcionD.setForeground(new java.awt.Color(60, 63, 65));
        text_descripcionD.setLineWrap(true);
        text_descripcionD.setRows(10);
        text_descripcionD.setWrapStyleWord(true);
        text_descripcionD.setBorder(null);
        text_descripcionD.setDisabledTextColor(new java.awt.Color(60, 63, 65));
        jScrollDescripcionD.setViewportView(text_descripcionD);

        panel_principal.add(jScrollDescripcionD, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 930, 310, 110));

        progressBar.setForeground(new java.awt.Color(26, 64, 95));
        panel_principal.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 100, 100));

        scrollpanel.setViewportView(panel_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUp_ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1442, Short.MAX_VALUE)
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
    int xx,xy;
    private void panelUp_ventanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_panelUp_ventanaMouseDragged

    private void panelUp_ventanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaMousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_panelUp_ventanaMousePressed

    
    //      METODOS
    
    public void ocultarComponentes(){
        jLabelNuevaRegistrada.setVisible(false);
        jLabelNombreApellidos.setVisible(false);
        text_nombre_apellidos.setVisible(false);
        jLabelCorreo.setVisible(false);
        text_correo.setVisible(false);
        jLabelTipo.setVisible(false);
        text_tipo.setVisible(false);     
        jLabelFecha.setVisible(false);
        text_fecha.setVisible(false);        
        jLabelDescripcionS.setVisible(false);
        jScrollDescripcion.setVisible(false);
        text_descripcion.setVisible(false);
        jLabelDireccion.setVisible(false);
        text_direccion.setVisible(false);
        jLabelAdministrador.setVisible(false);
        text_administrador.setVisible(false);
        jLabelDepartamento.setVisible(false);
        text_departamento.setVisible(false);
        jLabelSupervisor.setVisible(false);
        text_supervisor.setVisible(false);
        jLabelEmpleado.setVisible(false);
        text_empleado.setVisible(false);        
        jLabelImagen.setVisible(false);
        
        
        jSeparator1.setVisible(false);
        
        jLabelEnTramite.setVisible(false);
        jLabelFechaET.setVisible(false);
        text_fechaET.setVisible(false);
        
        jSeparator2.setVisible(false);
        
        jLabelValidada.setVisible(false);
        jLabelFechaV.setVisible(false);
        text_fechaV.setVisible(false);
        
        jSeparator3.setVisible(false);
        
        jLabelEnArreglo.setVisible(false);
        jLabelFechaEA.setVisible(false);
        text_fechaEA.setVisible(false);
        
        jSeparator4.setVisible(false);
        
        jLabelValidarArreglo.setVisible(false);
        jLabelFechaVA.setVisible(false);
        text_fechaVA.setVisible(false);
        
        jSeparator5.setVisible(false);
        
        jLabelArreglada.setVisible(false);
        jLabelFechaA.setVisible(false);
        text_fechaA.setVisible(false);
        
        jSeparator6.setVisible(false);
        
        jLabelSolucionada.setVisible(false);
        jLabelFechaS.setVisible(false);
        text_fechaS.setVisible(false);
        jLabelDescripcion.setVisible(false);
        jScrollDescripcionS.setVisible(false);
        text_descripcionS.setVisible(false);
        jLabelImagenS.setVisible(false);  
        
        
        jLabelDenegada.setVisible(false);
        jLabelFechaD.setVisible(false);
        text_fechaD.setVisible(false);
        jLabelDescripcionD.setVisible(false);
        jScrollDescripcionD.setVisible(false);
        text_descripcionD.setVisible(false);
    }   
    
    public void mostrarComponentes(){
        jLabelNuevaRegistrada.setVisible(true);
        jLabelNombreApellidos.setVisible(true);
        text_nombre_apellidos.setVisible(true);
        jLabelCorreo.setVisible(true);
        text_correo.setVisible(true);
        jLabelTipo.setVisible(true);
        text_tipo.setVisible(true);     
        jLabelFecha.setVisible(true);
        text_fecha.setVisible(true);        
        jScrollDescripcion.setVisible(true);
        text_descripcion.setVisible(true);
        jLabelDireccion.setVisible(true);
        text_direccion.setVisible(true);
        jLabelAdministrador.setVisible(true);
        text_administrador.setVisible(true);
        jLabelDepartamento.setVisible(true);
        text_departamento.setVisible(true);
        jLabelSupervisor.setVisible(true);
        text_supervisor.setVisible(true);
        jLabelEmpleado.setVisible(true);
        text_empleado.setVisible(true);        
        jLabelImagen.setVisible(true);
    
    }   
    
    public void detallesIncidencia(){
        
        SwingWorker workerDetalles = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {    
                ocultarComponentes();
                progressBar.setVisible(true);  
                
                decoder = new BASE64Decoder();

                respuestaServidor = app.protocoloMensajes("11||"+idIncidencia+"||");
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaHistorialIncidencia.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }
                resServidor = respuestaServidor.split("\\|\\|");
                
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaHistorialIncidencia.this, "Su sesión ha caducado", "Message", 0);
                    vp.setVisible(false);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                }

                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(respuestaServidor);
                
                String estadoIncidencia, imagenBase64;
                
                byte[] imageByte;
                ImageIcon ii;
                JSONObject object;
                for(int z=0;z<jsonArray.size();z++){
                    object = (JSONObject) jsonArray.get(z);
                    estadoIncidencia = object.get("estadoIncidencia").toString();
                    switch(estadoIncidencia){
                        case "NuevaRegistrada":
                            
                            text_nombre_apellidos.setText( object.get("usuario").toString());
                            text_correo.setText( object.get("correoUsuario").toString());
                            text_tipo.setText( object.get("tipo").toString());
                            text_fecha.setText( object.get("fecha").toString());
                            text_descripcion.setText( object.get("descripcion").toString());
                            text_direccion.setText( object.get("direccion").toString());
                            text_administrador.setText( object.get("administrador").toString());
                            text_departamento.setText( object.get("departamento").toString());
                            text_supervisor.setText( object.get("supervisor").toString());
                            text_empleado.setText( object.get("empleado").toString());
                            
                            imagenBase64 = object.get("imagen").toString();
                            imageByte = decoder.decodeBuffer(imagenBase64);
                                                    
                            ii = new ImageIcon(imageByte);
                            jLabelImagen.setIcon(ii);
                            
                            mostrarComponentes();
                            break;                            
                        case  "EnTramite":                            
                            text_fechaET.setText( object.get("fecha").toString());
                            
                            jSeparator1.setVisible(true);
        
                            jLabelEnTramite.setVisible(true);
                            jLabelFechaET.setVisible(true);
                            text_fechaET.setVisible(true);
                            
                            panel_principal.setPreferredSize(new Dimension(1440,900));
                            break;
                            
                        case "Validada":                            
                            text_fechaV.setText( object.get("fecha").toString());
                            
                            jSeparator2.setVisible(true);
        
                            jLabelValidada.setVisible(true);
                            jLabelFechaV.setVisible(true);
                            text_fechaV.setVisible(true);
                            
                            panel_principal.setPreferredSize(new Dimension(1440,1000));
                            break;
                            
                        case  "EnArreglo":
                            
                            text_fechaEA.setText( object.get("fecha").toString());   
                            
                            jSeparator3.setVisible(true);
        
                            jLabelEnArreglo.setVisible(true);
                            jLabelFechaEA.setVisible(true);
                            text_fechaEA.setVisible(true);
                            
                            panel_principal.setPreferredSize(new Dimension(1440,1100));
                            break;
                            
                        case "ValidarArreglo":
                            
                            text_fechaVA.setText( object.get("fecha").toString());
                            
                            jSeparator4.setVisible(true);
        
                            jLabelValidarArreglo.setVisible(true);
                            jLabelFechaVA.setVisible(true);
                            text_fechaVA.setVisible(true);
                            
                            panel_principal.setPreferredSize(new Dimension(1440,1200));
                            break;
                            
                        case "Arreglada":
                            
                            text_fechaA.setText( object.get("fecha").toString());
                            
                            jSeparator5.setVisible(true);
        
                            jLabelArreglada.setVisible(true);
                            jLabelFechaA.setVisible(true);
                            text_fechaA.setVisible(true);
                            
                            panel_principal.setPreferredSize(new Dimension(1440,1300));
                            break;
                            
                        case "Solucionada":

                            text_fechaS.setText( object.get("fecha").toString());
                            text_descripcionS.setText( object.get("descripcion").toString());
                            
                            imagenBase64 = object.get("imagen").toString();                            
                            imageByte = decoder.decodeBuffer(imagenBase64);
                                                    
                            ii = new ImageIcon(imageByte);
                            jLabelImagenS.setIcon(ii);      
                            
                            jSeparator6.setVisible(true);
        
                            jLabelSolucionada.setVisible(true);
                            jLabelFechaS.setVisible(true);
                            text_fechaS.setVisible(true);
                            jLabelDescripcion.setVisible(true);
                            jScrollDescripcionS.setVisible(true);
                            text_descripcionS.setVisible(true);
                            jLabelImagenS.setVisible(true); 
                            
                            panel_principal.setPreferredSize(new Dimension(1440,1900));
                            break;
                            
                        case "Denegada":
                            text_fechaD.setText( object.get("fecha").toString());
                            text_descripcionD.setText( object.get("descripcion").toString());
                            
                            //metodo para mostrar solo los componentes cuando la incidencia ha sido denegada
                            
                            jSeparator1.setVisible(true);
        
                            jLabelDenegada.setVisible(true);
                            jLabelFechaD.setVisible(true);
                            text_fechaD.setVisible(true);
                            jLabelDescripcionD.setVisible(true);
                            jScrollDescripcionD.setVisible(true);
                            text_descripcionD.setVisible(true);
                            
                            panel_principal.setPreferredSize(new Dimension(1440,1080));
                            break;
                    }
                    
                }
                
                progressBar.setVisible(false); 
                return null;
            }            
        };   
        
        workerDetalles.execute();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel imagen_logo;
    private javax.swing.JLabel jLabelAdministrador;
    private javax.swing.JLabel jLabelArreglada;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDenegada;
    private javax.swing.JLabel jLabelDepartamento;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcionD;
    private javax.swing.JLabel jLabelDescripcionS;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEnArreglo;
    private javax.swing.JLabel jLabelEnTramite;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechaA;
    private javax.swing.JLabel jLabelFechaD;
    private javax.swing.JLabel jLabelFechaEA;
    private javax.swing.JLabel jLabelFechaET;
    private javax.swing.JLabel jLabelFechaS;
    private javax.swing.JLabel jLabelFechaV;
    private javax.swing.JLabel jLabelFechaVA;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelImagenS;
    private javax.swing.JLabel jLabelNombreApellidos;
    private javax.swing.JLabel jLabelNuevaRegistrada;
    private javax.swing.JLabel jLabelSolucionada;
    private javax.swing.JLabel jLabelSupervisor;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelValidada;
    private javax.swing.JLabel jLabelValidarArreglo;
    private javax.swing.JScrollPane jScrollDescripcion;
    private javax.swing.JScrollPane jScrollDescripcionD;
    private javax.swing.JScrollPane jScrollDescripcionS;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel nombre_app;
    private javax.swing.JPanel panelUp_ventana;
    private javax.swing.JPanel panel_principal;
    private rojerusan.componentes.RSProgressMaterial progressBar;
    private javax.swing.JScrollPane scrollpanel;
    private javax.swing.JTextField text_administrador;
    private javax.swing.JTextField text_correo;
    private javax.swing.JTextField text_departamento;
    private javax.swing.JTextArea text_descripcion;
    private javax.swing.JTextArea text_descripcionD;
    private javax.swing.JTextArea text_descripcionS;
    private javax.swing.JTextField text_direccion;
    private javax.swing.JTextField text_empleado;
    private javax.swing.JTextField text_fecha;
    private javax.swing.JTextField text_fechaA;
    private javax.swing.JTextField text_fechaD;
    private javax.swing.JTextField text_fechaEA;
    private javax.swing.JTextField text_fechaET;
    private javax.swing.JTextField text_fechaS;
    private javax.swing.JTextField text_fechaV;
    private javax.swing.JTextField text_fechaVA;
    private javax.swing.JTextField text_nombre_apellidos;
    private javax.swing.JTextField text_supervisor;
    private javax.swing.JTextField text_tipo;
    // End of variables declaration//GEN-END:variables
}
