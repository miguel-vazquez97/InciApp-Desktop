package ventanas;

import aplicacion.Aplicacion;
import aplicacion.Usuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sun.misc.BASE64Decoder;

/**
 *
 * @author mivap
 */
public class VentanaGestionarUsuario extends javax.swing.JDialog {
        
    protected Aplicacion app;
    protected VentanaPrincipal vp;
    protected int tipoUsuario;
    protected HashMap<String, Integer> departamento_id;
    protected String[] nombresDep;
    protected Usuario usuarioSeleccionado;   
    protected String correoUsuarioSeleccionado;
    protected DefaultTableModel modelo;
    protected ArrayList<Usuario> listaUsuarios;
    
    protected JSONParser parser;
    protected String respuestaServidor;
    protected String[] resServidor;

    public VentanaGestionarUsuario(VentanaPrincipal vp, boolean modal, Aplicacion app, int tipoUsuario) {
        super(vp, modal);
        this.vp=vp;
        initComponents();
        
        setSize(1440, 810);               
        setLocationRelativeTo(null);
        
        this.app=app;
        this.tipoUsuario=tipoUsuario;
        
        switch(tipoUsuario){
            case 2:
                jLabelTitulo.setText("Gestionar Supervisor");
                break;
            case 3:
                jLabelTitulo.setText("Gestionar Empleado");
                break;
            case 4:
                jLabelTitulo.setText("Gestionar Ciudadano");
        }
                
        progressBar.setVisible(false);
        
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };     
        modelo.addColumn("Nombre");
        modelo.addColumn("DNI");
        
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
            if (me.getClickCount() == 2) {
                int linea = table.getSelectedRow();
                correoUsuarioSeleccionado = listaUsuarios.get(linea).getCorreo();              
                mostrarDatosUsuario(correoUsuarioSeleccionado);
             }
         }
        });
        
        ocultarComponentes();
        mostrarDatosTabla(); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ventanaPrincipal = new javax.swing.JPanel();
        panelUp_ventanaRegistro = new javax.swing.JPanel();
        boton_salir = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelFiltrarNombre = new javax.swing.JLabel();
        text_filtro_nombre = new javax.swing.JTextField();
        boton_filtrar = new javax.swing.JButton();
        progressBar = new rojerusan.componentes.RSProgressMaterial();
        scrollpane_tabla = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();
        separador_titulo_down = new javax.swing.JSeparator();
        progressBar2 = new rojerusan.componentes.RSProgressMaterial();
        jLabelNombre = new javax.swing.JLabel();
        text_nombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        text_apellidos = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        text_dni = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        text_correo = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        text_telefono = new javax.swing.JTextField();
        jLabelDepartamento = new javax.swing.JLabel();
        jComboBoxDepartamento = new javax.swing.JComboBox<>();
        jLabelFiltrarDni = new javax.swing.JLabel();
        text_filtro_dni = new javax.swing.JTextField();
        boton_eliminar = new javax.swing.JButton();
        boton_modificar = new javax.swing.JButton();
        error_registro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panel_ventanaPrincipal.setBackground(new java.awt.Color(240, 239, 240));
        panel_ventanaPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 64, 95)));
        panel_ventanaPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        panel_ventanaPrincipal.setPreferredSize(new java.awt.Dimension(1440, 810));
        panel_ventanaPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabelTitulo.setText("Gestionar Usuario");

        javax.swing.GroupLayout panelUp_ventanaRegistroLayout = new javax.swing.GroupLayout(panelUp_ventanaRegistro);
        panelUp_ventanaRegistro.setLayout(panelUp_ventanaRegistroLayout);
        panelUp_ventanaRegistroLayout.setHorizontalGroup(
            panelUp_ventanaRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUp_ventanaRegistroLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1153, Short.MAX_VALUE)
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

        panel_ventanaPrincipal.add(panelUp_ventanaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 70));

        jLabelFiltrarNombre.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFiltrarNombre.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFiltrarNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltrarNombre.setText("Nombre:");
        panel_ventanaPrincipal.add(jLabelFiltrarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 25));

        text_filtro_nombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_filtro_nombre.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_filtro_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 230, 25));

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
        panel_ventanaPrincipal.add(boton_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, 40));

        progressBar.setBackground(new java.awt.Color(255, 255, 255));
        progressBar.setForeground(new java.awt.Color(46, 134, 193));
        panel_ventanaPrincipal.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 416, 40, 40));

        tabla_datos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_datos.setRowHeight(20);
        scrollpane_tabla.setViewportView(tabla_datos);

        panel_ventanaPrincipal.add(scrollpane_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 390, 610));

        separador_titulo_down.setBackground(new java.awt.Color(26, 64, 95));
        separador_titulo_down.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel_ventanaPrincipal.add(separador_titulo_down, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 10, 500));

        progressBar2.setBackground(new java.awt.Color(255, 255, 255));
        progressBar2.setForeground(new java.awt.Color(46, 134, 193));
        panel_ventanaPrincipal.add(progressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 416, 40, 40));

        jLabelNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(47, 47, 40));
        jLabelNombre.setText("Nombre:");
        panel_ventanaPrincipal.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));

        text_nombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_nombre.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 230, 25));

        jLabelApellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(47, 47, 40));
        jLabelApellido.setText("Apellidos:");
        panel_ventanaPrincipal.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, -1, -1));

        text_apellidos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_apellidos.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 270, 230, 25));

        jLabelDni.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelDni.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDni.setText("DNI:");
        panel_ventanaPrincipal.add(jLabelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        text_dni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_dni.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 230, 25));

        jLabelCorreo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(47, 47, 40));
        jLabelCorreo.setText("Correo:");
        panel_ventanaPrincipal.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 370, -1, 20));

        text_correo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_correo.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 370, 230, 25));

        jLabelTelefono.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(47, 47, 40));
        jLabelTelefono.setText("Teléfono:");
        panel_ventanaPrincipal.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        text_telefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_telefono.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 230, 25));

        jLabelDepartamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelDepartamento.setForeground(new java.awt.Color(47, 47, 40));
        jLabelDepartamento.setText("Departamento:");
        panel_ventanaPrincipal.add(jLabelDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 470, -1, -1));

        jComboBoxDepartamento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        panel_ventanaPrincipal.add(jComboBoxDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 470, 230, 25));

        jLabelFiltrarDni.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelFiltrarDni.setForeground(new java.awt.Color(47, 47, 40));
        jLabelFiltrarDni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltrarDni.setText("DNI:");
        panel_ventanaPrincipal.add(jLabelFiltrarDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 25));

        text_filtro_dni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_filtro_dni.setForeground(new java.awt.Color(60, 63, 65));
        panel_ventanaPrincipal.add(text_filtro_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 230, 25));

        boton_eliminar.setBackground(new java.awt.Color(236, 112, 99));
        boton_eliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton_eliminar.setForeground(new java.awt.Color(240, 239, 240));
        boton_eliminar.setText("Eliminar");
        boton_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_eliminarMouseClicked(evt);
            }
        });
        panel_ventanaPrincipal.add(boton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 750, -1, 40));

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
        panel_ventanaPrincipal.add(boton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 750, -1, 40));

        error_registro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        error_registro.setForeground(new java.awt.Color(153, 0, 51));
        error_registro.setText("Error en el registro. Vuelva a intentarlo más tarde.");
        panel_ventanaPrincipal.add(error_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 760, -1, -1));

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
    private void panelUp_ventanaRegistroMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaRegistroMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_panelUp_ventanaRegistroMouseDragged

    private void panelUp_ventanaRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUp_ventanaRegistroMousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_panelUp_ventanaRegistroMousePressed

    //      BOTON FILTRAR
    private void boton_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_filtrarActionPerformed
        
        boolean filtrar = false;
        String filtroNombre, filtroDni;

        ArrayList<Usuario> usuariosFiltrados = new ArrayList<>();
        ArrayList<Usuario> usuariosFiltradosAux;
        
        filtroNombre = text_filtro_nombre.getText();        
        System.out.println(filtroNombre);
        if(!filtroNombre.equals("")){
            filtrar = true;
            
            for(Usuario usu : listaUsuarios){
                String nombreCompleto = usu.getNombre()+" "+usu.getApellido();
                int n = nombreCompleto.indexOf(filtroNombre);
                if(n!=-1)
                    usuariosFiltrados.add(usu);
            }
        }
        
        filtroDni = text_filtro_dni.getText();      
        if(!filtroDni.equals("")){
            int z;
            if(usuariosFiltrados.isEmpty() && filtrar==false){
                filtrar = true;
                
                for(Usuario usu : listaUsuarios){
                    z = usu.getDni().indexOf(filtroDni);
                    if(z!=-1)
                        usuariosFiltrados.add(usu);
                }
            }else{
                usuariosFiltradosAux = new ArrayList<>();
                for(Usuario usu : usuariosFiltrados){
                    z = usu.getDni().indexOf(filtroDni);
                    if(z!=-1)
                        usuariosFiltradosAux.add(usu);
                }
                usuariosFiltrados.clear();
                usuariosFiltrados.addAll(usuariosFiltradosAux);
                usuariosFiltradosAux.clear();
            }
        }
        
        if (filtrar) 
            cargarTabla(usuariosFiltrados);
        
        
        if(filtroNombre.equals("") && filtroDni.equals(""))
            cargarTabla(listaUsuarios);
        
    }//GEN-LAST:event_boton_filtrarActionPerformed

    //      BOTON ELIMINAR
    private void boton_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminarMouseClicked

        if(correoUsuarioSeleccionado==null || usuarioSeleccionado==null)
            return;
        
        SwingWorker workerEliminarUsuario = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                progressBar2.setVisible(true);
                error_registro.setVisible(false);
                
                respuestaServidor = app.protocoloMensajes("23||"+correoUsuarioSeleccionado+"||");
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }
                resServidor = respuestaServidor.split("\\|\\|");
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Su sesión ha caducado", "Message", 0);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                    ventanaLog.setVisible(true);
                }

                if(resServidor[0].equals("24") && resServidor[1].equals("eliminarUsuarioOk")){                    
                    mostrarDatosTabla();
                    ocultarComponentes();
                }else{
                    error_registro.setVisible(true);
                }

                progressBar2.setVisible(false);

                return null;
            }

        };

        workerEliminarUsuario.execute();
    }//GEN-LAST:event_boton_eliminarMouseClicked

    //      BOTON MODIFICAR
    private void boton_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_modificarMouseClicked

        if(correoUsuarioSeleccionado==null || usuarioSeleccionado==null)
            return;
        
        SwingWorker worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                progressBar2.setVisible(true);
                error_registro.setVisible(false);

                boolean registrar_usuario = true;
                Border border_boton_rojo = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red);

                String nombre = text_nombre.getText();
                String apellidos = text_apellidos.getText();
                String dni = text_dni.getText();
                String tlf = text_telefono.getText();   
                String idDepartamento = null;
                
                if(nombre.equals("")){
                    text_nombre.setBorder(border_boton_rojo);
                    registrar_usuario = false;
                }else{
                    text_nombre.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(apellidos.equals("")){
                    text_apellidos.setBorder(border_boton_rojo);
                    registrar_usuario = false;
                }else{
                    text_apellidos.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(dni.equals("") || dni.length()!=9){
                    text_dni.setBorder(border_boton_rojo);
                    registrar_usuario = false;
                }else{
                    text_dni.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }

                if(tlf.equals("") || tlf.length()!=9){
                    text_telefono.setBorder(border_boton_rojo);
                    registrar_usuario = false;
                }else{
                    text_telefono.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                }
   
                if(registrar_usuario){
                    
                    Usuario usuarioModificar;
                    if(tipoUsuario==4){
                        usuarioModificar = new Usuario(correoUsuarioSeleccionado, nombre, apellidos, dni, Integer.parseInt(tlf), "NULL");
                    }else{
                        idDepartamento = Integer.toString(departamento_id.get(nombresDep[jComboBoxDepartamento.getSelectedIndex()]));                    
                        usuarioModificar = new Usuario(correoUsuarioSeleccionado, nombre, apellidos, dni, Integer.parseInt(tlf), nombresDep[jComboBoxDepartamento.getSelectedIndex()]);
                    }
                    
                    if(usuarioModificar.compareTo(usuarioSeleccionado)==1){
                        if(tipoUsuario==4){
                            respuestaServidor = app.protocoloMensajes("22||"+correoUsuarioSeleccionado+"||"+nombre+"||"+apellidos+"||"+dni+"||"+tlf+"||"+"NULL||");
                        }else{                        
                            respuestaServidor = app.protocoloMensajes("22||"+correoUsuarioSeleccionado+"||"+nombre+"||"+apellidos+"||"+dni+"||"+tlf+"||"+idDepartamento+"||");
                        }
                        
                        if(respuestaServidor==null){
                            JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                            progressBar.setVisible(false);
                            return null;
                        }
                        resServidor = respuestaServidor.split("\\|\\|");
                        if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                            JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Su sesión ha caducado", "Message", 0);
                            dispose();
                            VentanaLog ventanaLog = new VentanaLog();
                            ventanaLog.setVisible(true);
                        }

                        if(resServidor[0].equals("22") && resServidor[1].equals("modificarUsuarioOk")){
                            usuarioSeleccionado = usuarioModificar;                             
                            mostrarComponentes(usuarioSeleccionado);
                            mostrarDatosTabla();
                        }else{
                            error_registro.setVisible(true);
                        }
                    }                    
                }

                progressBar2.setVisible(false);

                return null;
            }

        };

        worker.execute();

    }//GEN-LAST:event_boton_modificarMouseClicked
    
    //      METODOS
    
    protected void mostrarDatosTabla() {

        SwingWorker workerDatosTabla = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                
                progressBar.setVisible(true);

                respuestaServidor = app.protocoloMensajes("20||"+tipoUsuario+"||");

                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar.setVisible(false);
                    return null;
                }                
                resServidor = respuestaServidor.split("\\|\\|");                
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Su sesión ha caducado", "Message", 0);
                    vp.setVisible(false);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                    ventanaLog.setVisible(true);
                }
                
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] arrayBytes = decoder.decodeBuffer(respuestaServidor);
                String cadenaJson = new String(arrayBytes);
                parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(cadenaJson);                
                JSONObject object;
                Usuario usuario;
                String correo, nombre, apellido, dni;
                
                listaUsuarios = new ArrayList<>();
                for(int z=0;z<jsonArray.size();z++){
                    object = (JSONObject) jsonArray.get(z);
                    correo = (String) object.get("correo").toString();
                    nombre = (String) object.get("nombre").toString();
                    apellido = (String) object.get("apellido").toString();
                    dni = (String) object.get("dni").toString();
                    
                    usuario = new Usuario(correo,nombre,apellido,dni);
                    listaUsuarios.add(usuario);
                }
                
                cargarTabla(listaUsuarios);

                progressBar.setVisible(false);
                return null;
            }

        };

        workerDatosTabla.execute();
    }
    
    protected void cargarTabla(ArrayList<Usuario> usuarios) {
        String[] datos = new String[2];

        int filas = tabla_datos.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }

        for (Usuario usu : usuarios) {
            datos[0] = usu.getNombre()+" "+usu.getApellido();
            datos[1] = usu.getDni();
            modelo.addRow(datos);
        }
    }
    
    protected void mostrarDatosUsuario(String correoUsuario){
        SwingWorker workerDatosUsuario = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                ocultarComponentes();
                progressBar2.setVisible(true);

                respuestaServidor = app.protocoloMensajes("21||"+correoUsuario+"||");
                if(respuestaServidor==null){
                    JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                    progressBar2.setVisible(false);
                    return null;
                }
                resServidor = respuestaServidor.split("\\|\\|");
                
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                    JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Su sesión ha caducado", "Message", 0);
                    vp.setVisible(false);
                    dispose();
                    VentanaLog ventanaLog = new VentanaLog();
                    ventanaLog.setVisible(true);
                }
                

                JSONObject objectUsuario = (JSONObject) parser.parse(respuestaServidor);
                String correo, nombre, apellido, dni, departamento;
                int tlf;
                
                correo = (String) objectUsuario.get("correo").toString();
                nombre = (String) objectUsuario.get("nombre").toString();
                apellido = (String) objectUsuario.get("apellido").toString();
                dni = (String) objectUsuario.get("dni").toString();
                tlf = Integer.parseInt(objectUsuario.get("tlf").toString());
                if(tipoUsuario==2 || tipoUsuario==3){
                    departamento = (String) objectUsuario.get("departamento").toString();
                }else{
                    departamento = "NULL";
                }
                
                Usuario usuario = new Usuario(correo,nombre,apellido,dni,tlf, departamento);
                
                if(tipoUsuario==2 || tipoUsuario==3){
                    //si nuestro HashMap es null significa que no hemos cargado el comboBox anteriormente
                    //por lo que pediremos al servidor que nos provea los departamentos
                    if(departamento_id==null){
                        respuestaServidor = app.protocoloMensajes("13||listado_departamentos||");
                        
                        if(respuestaServidor==null){
                            JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Error en la comunicación. Vuelva a intentarlo más tarde.", "Message", 1);
                            progressBar.setVisible(false);
                            return null;
                        }
                        resServidor = respuestaServidor.split("\\|\\|");
                        if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){
                            JOptionPane.showMessageDialog(VentanaGestionarUsuario.this, "Su sesión ha caducado", "Message", 0);
                            dispose();
                            VentanaLog ventanaLog = new VentanaLog();
                            ventanaLog.setVisible(true);
                        }

                        JSONParser parser = new JSONParser();
                        JSONObject object = (JSONObject) parser.parse(respuestaServidor);

                        String listaEmpleados = object.get("departamentos").toString();
                        String[] aux;                            
                        aux = listaEmpleados.split(";");

                        departamento_id = new HashMap<>();

                        String[] nombre_id;
                        nombresDep = new String[aux.length];

                        for(int i=0; i<aux.length; i++){
                            nombre_id = aux[i].split(":");
                            nombresDep[i]=nombre_id[0];
                            departamento_id.put(nombre_id[0], Integer.parseInt(nombre_id[1]));
                        }
                    }
                    
                    cargarComboBoxDepartamentos(departamento);

                }
                
                mostrarComponentes(usuario);
                usuarioSeleccionado = usuario;
                progressBar2.setVisible(false);
                return null;
            }

        };

        workerDatosUsuario.execute();
    }
    
    public void cargarComboBoxDepartamentos(String departamento){
        DefaultComboBoxModel model = new DefaultComboBoxModel(nombresDep);
        jComboBoxDepartamento.setModel(model);
        jComboBoxDepartamento.setMaximumRowCount(nombresDep.length);
        jComboBoxDepartamento.setEditable(true);
        jComboBoxDepartamento.setSelectedItem(departamento);
    }
    
    protected void ocultarComponentes(){
        jLabelNombre.setVisible(false);
        jLabelApellido.setVisible(false);
        jLabelDni.setVisible(false);
        jLabelCorreo.setVisible(false);
        jLabelTelefono.setVisible(false);
        jLabelDepartamento.setVisible(false);
        
        text_nombre.setVisible(false);
        text_apellidos.setVisible(false);
        text_dni.setVisible(false);
        text_correo.setVisible(false);
        text_telefono.setVisible(false);
        jComboBoxDepartamento.setVisible(false);
        
        progressBar2.setVisible(false);  
        error_registro.setVisible(false);
    }
    
    protected void mostrarComponentes(Usuario usuario){
        jLabelNombre.setVisible(true);
        jLabelApellido.setVisible(true);
        jLabelDni.setVisible(true);
        jLabelCorreo.setVisible(true);
        jLabelTelefono.setVisible(true);        
        
        text_nombre.setText(usuario.getNombre());
        text_nombre.setVisible(true);
        text_apellidos.setText(usuario.getApellido());
        text_apellidos.setVisible(true);
        text_dni.setText(usuario.getDni());
        text_dni.setVisible(true);
        text_correo.setText(usuario.getCorreo());
        text_correo.setEditable(false);
        text_correo.setVisible(true);
        text_telefono.setText(Integer.toString(usuario.getTlf()));
        text_telefono.setVisible(true);   
        
        if(tipoUsuario==2 || tipoUsuario==3){
            jLabelDepartamento.setVisible(true);
            jComboBoxDepartamento.setVisible(true);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_filtrar;
    private javax.swing.JButton boton_modificar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JLabel error_registro;
    private javax.swing.JComboBox<String> jComboBoxDepartamento;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDepartamento;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelFiltrarDni;
    private javax.swing.JLabel jLabelFiltrarNombre;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel panelUp_ventanaRegistro;
    private javax.swing.JPanel panel_ventanaPrincipal;
    private rojerusan.componentes.RSProgressMaterial progressBar;
    private rojerusan.componentes.RSProgressMaterial progressBar2;
    private javax.swing.JScrollPane scrollpane_tabla;
    private javax.swing.JSeparator separador_titulo_down;
    private javax.swing.JTable tabla_datos;
    private javax.swing.JTextField text_apellidos;
    private javax.swing.JTextField text_correo;
    private javax.swing.JTextField text_dni;
    private javax.swing.JTextField text_filtro_dni;
    private javax.swing.JTextField text_filtro_nombre;
    private javax.swing.JTextField text_nombre;
    private javax.swing.JTextField text_telefono;
    // End of variables declaration//GEN-END:variables
}
