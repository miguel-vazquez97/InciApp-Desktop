package ventanas;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mivap
 */
public class InciAppAplication {
    
    public static void main(String args[]){
        
        Properties configuracionInicio = new Properties(); 
        
        try (FileInputStream leerArchivo = new FileInputStream("Configuracion.inicio.properties")) {
            configuracionInicio.load(leerArchivo);

            String configuracionPuertoIP = configuracionInicio.getProperty("configuracionPuertoIp");
            String configuracionRegistroAdmin = configuracionInicio.getProperty("configuracionRegistroAdmin");

            if(configuracionPuertoIP.equals("true")){
                ConfiguracionPuertoIP configuracionPuertoIp = new ConfiguracionPuertoIP();
                configuracionPuertoIp.setVisible(true); 
                configuracionPuertoIp.addPropertyChangeListener(new CerrarVentanaListener());
            }else if(configuracionRegistroAdmin.equals("true")){
                RegistroUsuarioAdministrador registroUsuarioAdministrador = new RegistroUsuarioAdministrador();
                registroUsuarioAdministrador.setVisible(true);
                registroUsuarioAdministrador.addPropertyChangeListener(new CerrarVentanaListener());
            }else{
                VentanaLog ventanaLog = new VentanaLog();
                ventanaLog.setVisible(true);
            }

        } catch (IOException ex) {
            Logger.getLogger(InciAppAplication.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}

class CerrarVentanaListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        switch(evt.getPropertyName()){
            case "ConfiguracionPuertpIPExit":
                RegistroUsuarioAdministrador registroUsuarioAdministrador = new RegistroUsuarioAdministrador();
                registroUsuarioAdministrador.setVisible(true);
                registroUsuarioAdministrador.addPropertyChangeListener(new CerrarVentanaListener());
                break;
                
            case "RegistroUsuarioAdministradorExit":                
                VentanaLog ventanaLog = new VentanaLog();
                ventanaLog.setVisible(true);
                break;
        }        
    }
}
