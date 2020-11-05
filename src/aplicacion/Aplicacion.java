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
    
    protected String respuestaServidor;
    protected byte[] respuestaServidorByte;   
    protected String[] resServidor;
    
    static boolean transicionNula = false;
    private int state = INICIO;
    private static final int INICIO = 0;
    private static final int REGISTRAR_USUARIO = 1;    
    private static final int LOG_ADMIN = 2;
    private static final int LOG_OUT = 3;
    private static final int INCIDENCIAS_TABLA = 4;
    private static final int DATOS_INCIDENCIA_NUEVA_REGISTRADA = 5;
    private static final int ASIGNAR_INCIDENCIA_SUPERVISOR = 6;
    private static final int LISTADO_EMPLEADOS = 7;
    private static final int ASIGNAR_INCIDENCIA_EMPLEADO = 8;
    private static final int DETALLES_HISTORIAL_INCIDENCIA = 11;
    
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
            
            //while(leerServidor.available()<1){}
            while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}
            //respuestaServidorByte = new byte[leerServidor.available()];
            //leerServidor.read(respuestaServidorByte);
            respuestaServidor = new String(respuestaServidorByte);

            System.out.println(respuestaServidor);  
            conectadoServidor=true;
            
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
            if(leerServidor.available()>0){
                leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]);
                respuestaUsuario = new String(respuestaServidorByte);
                resServidor = respuestaUsuario.split("\\|\\|");
                //si recibimos esta respuesta significará que la sesion en la que nos encontrabamos ha expirado
                if(resServidor[0].equals("0") && resServidor[1].equals("sesionCaducada")){                   
                    return respuestaUsuario;
                }
                respuestaUsuario = "";
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
                                state = DATOS_INCIDENCIA_NUEVA_REGISTRADA;
                                transicionNula=true;
                                break;
                                
                            case "6":
                                state = ASIGNAR_INCIDENCIA_SUPERVISOR;
                                transicionNula=true;
                                break;
                                
                            case "7":
                                state = LISTADO_EMPLEADOS;
                                transicionNula=true;
                                break;
                                
                            case "8":
                                state = ASIGNAR_INCIDENCIA_EMPLEADO;
                                transicionNula=true;
                                break;
                                
                            case "11":
                                state = DETALLES_HISTORIAL_INCIDENCIA;
                                transicionNula=true;
                                break;
                        }                    
                        break;

                    case REGISTRAR_USUARIO:

                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();

                        while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}                       
                        respuestaUsuario = new String(respuestaServidorByte);

                        state = INICIO;
                        transicionNula=false;
                        break;

                    case LOG_ADMIN:

                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();

                        while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}                       
                        respuestaUsuario = new String(respuestaServidorByte);

                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case LOG_OUT:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}                       
                        respuestaUsuario = new String(respuestaServidorByte);
                        
                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case INCIDENCIAS_TABLA:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                    
                        int size = dataInputStream.readInt();
                        
                        JSONParser parser = new JSONParser();
                        arrayIncidencias = new ArrayList<>();
                        
                        String object;                        
                        int id;
                        String cadena_id,fech,tipo,descripcion,direccion;
                        Date fecha;
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        
                        for(int i = 0; i<size; i++){
                            object = dataInputStream.readUTF();
                            JSONObject obj = (JSONObject) parser.parse(object);
                            cadena_id = (String) obj.get("id").toString();
                            id = Integer.parseInt(cadena_id);
                            tipo = (String) obj.get("tipo").toString();
                            fech = (String) obj.get("fecha").toString();                      
                            fecha = formatter.parse(fech);        
                            descripcion = (String) obj.get("descripcion").toString();
                            direccion = (String) obj.get("direccion").toString();
                            RowTablaIncidencia incidencia = new RowTablaIncidencia(id,fecha,tipo,descripcion,direccion);
                            //Incidencia incidencia = new RowTablaIncidencia( id,obj.get("tipo"),obj.get("descripcion"),obj.get("ubicacion"));
                            arrayIncidencias.add(incidencia);
                        }
                        
                        respuestaUsuario=codigos[1];
                        
                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case DATOS_INCIDENCIA_NUEVA_REGISTRADA:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}   
                        respuestaUsuario = new String(respuestaServidorByte);
                        
                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case ASIGNAR_INCIDENCIA_SUPERVISOR:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}   
                        respuestaUsuario = new String(respuestaServidorByte);
                        
                        state = INICIO; 
                        transicionNula=false;
                        break;
                        
                    case LISTADO_EMPLEADOS:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();   
                        
                        respuestaUsuario = dataInputStream.readUTF();

                        state = INICIO;
                        transicionNula=false;
                        break;
                        
                    case ASIGNAR_INCIDENCIA_EMPLEADO:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        while((leerServidor.read(respuestaServidorByte = new byte[leerServidor.available()]))<1){}   
                        respuestaUsuario = new String(respuestaServidorByte);                        
                        
                        state = INICIO; 
                        transicionNula=false;
                        break;
                        
                    case DETALLES_HISTORIAL_INCIDENCIA:
                        
                        enviarServidor.write(mensaje.getBytes());
                        enviarServidor.flush();
                        
                        //tamano que tendra nuestra cadena en base64
                        size = dataInputStream.readInt();

                        while(dataInputStream.available()<1){}

                        byte[] arrayBytesBase64;
                        String base64="", cadena;
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
                            
                }            
            }while(transicionNula==true);
            
        }catch (SocketException es) {   
            respuestaUsuario=codigos[0];            
        }catch (IOException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            System.out.println("Error parsear JSONObject Protocolo Aplicacion");            
        } catch (java.text.ParseException ex) {
            System.out.println("Error parsear fecha Protocolo Aplicacion");       
        }
        
        return respuestaUsuario;
    }
    
}
