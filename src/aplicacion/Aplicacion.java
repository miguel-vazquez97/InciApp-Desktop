package aplicacion;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.misc.BASE64Decoder;
import ventanas.VentanaLog;

/**
 *
 * @author mivap
 */
public class Aplicacion {
    
    private static final String[] codigos={"0||sesionCaducada||",
                                       "7||listadoIncidenciasOk||"};
    
    private Socket socket;
    private InputStream leerServidor;
    private OutputStream enviarServidor;
    protected  DataInputStream dataInputStream;
    
    protected  String [] mensajeUsuario;
    protected String respuestaUsuario;   
    protected int time;
    
    protected String respuestaServidor;
    protected byte[] respuestaServidorByte;   
    protected String[] resServidor;
    
    protected byte[] arrayBytesBase64;
    protected String base64;
    protected String cadena;
    protected JSONParser parser;
    protected int size;
    
    
    static boolean transicionNula = false;
    private int state = INICIO;
    private static final int INICIO = 0;
    private static final int REGISTRAR_USUARIO = 1;    
    private static final int LOG_ADMIN = 2;
    private static final int LOG_OUT = 3;
    private static final int INCIDENCIAS_TABLA = 4;
    private static final int DATOS_INCIDENCIA = 5;
    private static final int ASIGNAR_INCIDENCIA_SUPERVISOR = 6;
    private static final int ASIGNAR_INCIDENCIA_EMPLEADO = 8;
    private static final int DATOS_INCIDENCIA_ARREGLADA = 9;
    private static final int SOLUCIONAR_INCIDENCIA = 10;
    private static final int DETALLES_HISTORIAL_INCIDENCIA = 11;
    private static final int DENEGAR_SOLUCION_INCIDENCIA = 12;
    private static final int LISTADO_DEPARTAMENTOS = 13;
    private static final int REGISTRAR_DEPARTAMENTO = 14;
    private static final int ELIMINAR_DEPARTAMENTO = 15;
    
    private static final int LISTADO_USUARIOS = 20;
    private static final int DETALLES_USUARIO = 21;
    private static final int MODIFICAR_USUARIO = 22;
    private static final int ELIMINAR_USUARIO = 23;
    
    BASE64Decoder decoder;
    
    private String correo;
    private String nombreAdmin;
    private boolean conectadoServidor;
    
    private ArrayList<RowTablaIncidencia> arrayIncidencias;

    public Aplicacion() {
        conectadoServidor=false;         
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }   

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public ArrayList<RowTablaIncidencia> getArrayIncidencias(){
        return arrayIncidencias;
    }    
    
    public boolean getConectadoServidor(){
        return conectadoServidor;
    }
    
    public boolean conectarConServidor(String ip, int puerto){    
        try {    
            socket = new Socket(ip,puerto);             
            enviarServidor = socket.getOutputStream();
            leerServidor = socket.getInputStream();  
            dataInputStream = new DataInputStream(socket.getInputStream());
            
            while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}
            respuestaServidor = new String(respuestaServidorByte);

            System.out.println(respuestaServidor);  
            conectadoServidor=true;
            
            enviarServidor.write("ConectadoAppEscritorio||0||".getBytes());
            enviarServidor.flush();
            
        } catch (ConnectException ce) {
            System.out.println("No se ha establecido conexión con el servidor.");
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void cerrarFlujos(){
        try {
            
            if(enviarServidor!=null)
                enviarServidor.close();
            
            if(leerServidor!=null)
                leerServidor.close();
            
            if(dataInputStream!=null)
                dataInputStream.close();
            
            if(socket!=null)
                socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(VentanaLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String protocoloMensajes(String mensaje){
       mensajeUsuario = mensaje.split("\\|\\|");
       respuestaUsuario = "";           
        
        try{
            
            //comprobamos si hemos recibido algun mensaje por parte del servidor
            //esto será por si enviamos algún mensaje y el servidor tardó más de 5s en respondernos            
            //ya que si tarda más de 5s informaremos al usuario que ha habido problemas con la comunicación            
            while(leerServidor.available()>0){
                leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]);
            }
            
            
            do{            
                switch(state){

                    case INICIO:

                        switch(mensajeUsuario[0]){

                            case "1":
                                state = REGISTRAR_USUARIO;
                                transicionNula=true;
                                break;

                            case "2":
                                state = LOG_ADMIN;
                                transicionNula=true;
                                break;
                                
                            case "3":
                                state = LOG_OUT;
                                transicionNula=true;
                                break;
                            
                            case "4":
                                state = INCIDENCIAS_TABLA;
                                transicionNula=true;
                                break;
                                
                            case "5":
                                state = DATOS_INCIDENCIA;
                                transicionNula=true;
                                break;
                                
                            case "6":
                                state = ASIGNAR_INCIDENCIA_SUPERVISOR;
                                transicionNula=true;
                                break;
                                
                            case "8":
                                state = ASIGNAR_INCIDENCIA_EMPLEADO;
                                transicionNula=true;
                                break;
                                
                            case "9":
                                state = DATOS_INCIDENCIA_ARREGLADA;
                                transicionNula=true;
                                break;
                                
                            case "10":
                                state = SOLUCIONAR_INCIDENCIA;
                                transicionNula=true;
                                break;
                                
                            case "11":
                                state = DETALLES_HISTORIAL_INCIDENCIA;
                                transicionNula=true;
                                break;
                                
                            case "12":
                                state = DENEGAR_SOLUCION_INCIDENCIA;
                                transicionNula=true;
                                break;
                                
                            case "13":
                                state = LISTADO_DEPARTAMENTOS;
                                transicionNula=true;
                                break;
                                
                            case "14":
                                state = REGISTRAR_DEPARTAMENTO;
                                transicionNula=true;
                                break;
                                
                            case "15":
                                state = ELIMINAR_DEPARTAMENTO;
                                transicionNula=true;
                                break;
                                
                            case "20":
                                state = LISTADO_USUARIOS;
                                transicionNula=true;
                                break;
                                
                            case "21":
                                state = DETALLES_USUARIO;
                                transicionNula=true;
                                break;
                                
                            case "22":
                                state = MODIFICAR_USUARIO;
                                transicionNula=true;
                                break;
                                
                            case "23":
                                state = ELIMINAR_USUARIO;
                                transicionNula=true;
                                break;
                        }                    
                        break;


                    case REGISTRAR_USUARIO:
                    case LOG_ADMIN:
                    case LOG_OUT:  
                    case DATOS_INCIDENCIA:
                    case ASIGNAR_INCIDENCIA_SUPERVISOR: 
                    case ASIGNAR_INCIDENCIA_EMPLEADO: 
                    case SOLUCIONAR_INCIDENCIA:   
                    case DENEGAR_SOLUCION_INCIDENCIA:
                    case REGISTRAR_DEPARTAMENTO:                        
                    case ELIMINAR_DEPARTAMENTO:
                    case MODIFICAR_USUARIO:                    
                    case ELIMINAR_USUARIO:    

                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        time=0;
                        while(leerServidor.available()<1 && time<5000){
                            try {
                                Thread.sleep(500);
                                time += 500;
                            } catch (InterruptedException e) {
                            }
                        }
                        if(time==5000){
                            state = INICIO;
                            transicionNula=false;
                            return null;
                        }
                        
                        leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]);
                        respuestaUsuario = new String(respuestaServidorByte);
                        
                        if(state==LOG_OUT)
                            cerrarFlujos();

                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case INCIDENCIAS_TABLA:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();

                        time=0;
                        while(leerServidor.available()<1 && time<5000){
                            try {
                                Thread.sleep(500);
                                time += 500;
                            } catch (InterruptedException e) {
                            }
                        }
                        if(time==5000){
                            state = INICIO;
                            transicionNula=false;
                            return null;
                        }
                    
                        size = dataInputStream.readInt();
                        
                        parser = new JSONParser();
                        arrayIncidencias = new ArrayList<>();
                                                
                        String object;                        
                        int id;
                        String cadena_id,estado,fech,tipo,descripcion,direccion;
                        Date fecha;
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        
                        for(int i = 0; i<size; i++){
                            object = dataInputStream.readUTF();
                            JSONObject obj = (JSONObject) parser.parse(object);
                            cadena_id = (String) obj.get("id").toString();
                            id = Integer.parseInt(cadena_id);
                            estado = (String) obj.get("estado").toString();
                            tipo = (String) obj.get("tipo").toString();
                            fech = (String) obj.get("fecha").toString();                      
                            fecha = formatter.parse(fech);        
                            descripcion = (String) obj.get("descripcion").toString();
                            direccion = (String) obj.get("direccion").toString();
                            RowTablaIncidencia incidencia = new RowTablaIncidencia(id, estado, fecha,tipo,descripcion,direccion);
                            arrayIncidencias.add(incidencia);
                        }
                        
                        respuestaUsuario=codigos[1];
                        
                        state = INICIO;
                        transicionNula=false;
                        break;

                        
                    case DATOS_INCIDENCIA_ARREGLADA:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        time=0;
                        while(leerServidor.available()<1 && time<5000){
                            try {
                                Thread.sleep(500);
                                time += 500;
                            } catch (InterruptedException e) {
                            }
                        }
                        if(time==5000){
                            state = INICIO;
                            transicionNula=false;
                            return null;
                        }
                        
                        size = dataInputStream.readInt();
                        base64="";
                        cadena="";
                        while(base64.length()<size){
                            arrayBytesBase64 = new byte[dataInputStream.available()];
                            dataInputStream.read(arrayBytesBase64);
                            cadena = new String(arrayBytesBase64);
                            base64 += cadena;
                        }

                        decoder = new BASE64Decoder();
                        byte[] arrayBytesArreglada = decoder.decodeBuffer(base64);
                        respuestaUsuario = new String(arrayBytesArreglada);

                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case DETALLES_HISTORIAL_INCIDENCIA:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();

                        time=0;
                        while(leerServidor.available()<1 && time<5000){
                            try {
                                Thread.sleep(500);
                                time += 500;
                            } catch (InterruptedException e) {
                            }
                        }
                        if(time==5000){
                            state = INICIO;
                            transicionNula=false;
                            return null;
                        }    
                        
                        //tamano que tendra nuestra cadena en base64
                        size = dataInputStream.readInt();

                        base64="";
                        cadena="";
                        while(base64.length()<size){
                            arrayBytesBase64 = new byte[dataInputStream.available()];
                            //recibimos bytes
                            dataInputStream.read(arrayBytesBase64);
                            //parseamos a cadena
                            cadena = new String(arrayBytesBase64);
                            //unimos a la cadena que formara nuestro Base64
                            base64 += cadena;
                        }
                        
                        //descodificamos a bytes
                        decoder = new BASE64Decoder();
                        byte[] arrayBytes = decoder.decodeBuffer(base64);
                        //creamos lo que será nuestro JSONArray en cadena
                        respuestaUsuario = new String(arrayBytes);
                        
                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case LISTADO_USUARIOS:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        time=0;
                        while(leerServidor.available()<1 && time<5000){
                            try {
                                Thread.sleep(500);
                                time += 500;
                            } catch (InterruptedException e) {
                            }
                        }
                        if(time==5000){
                            state = INICIO;
                            transicionNula=false;
                            return null;
                        }    
                    
                        size = dataInputStream.readInt();
                        base64="";
                        cadena="";
                        while(base64.length()<size){
                            arrayBytesBase64 = new byte[dataInputStream.available()];
                            dataInputStream.read(arrayBytesBase64);
                            cadena = new String(arrayBytesBase64);
                            base64 += cadena;
                        }
                        
                        respuestaUsuario = base64;
                        
                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case DETALLES_USUARIO:
                    case LISTADO_DEPARTAMENTOS:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        time=0;
                        while(leerServidor.available()<1 && time<5000){
                            try {
                                Thread.sleep(500);
                                time += 500;
                            } catch (InterruptedException e) {
                            }
                        }
                        if(time==5000){
                            state = INICIO;
                            transicionNula=false;
                            return null;
                        }
                        
                        respuestaUsuario = dataInputStream.readUTF();  
                        
                        state = INICIO;
                        transicionNula=false;
                        break;
     
                }            
            }while(transicionNula==true);
            
        }catch (SocketException es) {   
            //si entramos en la excepcion significa que el socket ha sido cerrado por parte del server
            //es decir, la sesion ha caducado
            respuestaUsuario=codigos[0];            
        }catch (IOException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            System.out.println("Error parsear JSONObject Protocolo Aplicacion");            
        } catch (java.text.ParseException ex) {
            System.out.println("Error parsear fecha Protocolo Aplicacion");       
        }
        System.out.println(respuestaUsuario);
        return respuestaUsuario;
    }
    
}
