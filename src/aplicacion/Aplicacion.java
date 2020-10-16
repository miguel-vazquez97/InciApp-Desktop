/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.net.Socket;

/**
 *
 * @author mivap
 */
public class Aplicacion {
    
    private Socket socket;

    public Aplicacion() {
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }   
    
}
