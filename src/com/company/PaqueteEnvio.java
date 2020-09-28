package com.company;

import java.io.*;

public class PaqueteEnvio implements Serializable { //Serializar: Se convierten los datos en bytes

    private String nick, ip, mensaje;

    /***
     * Retorna el nombre indicaco por el usuario
     * @return  retorna el nombre de usuario
     */
    public String getNick() {
        return nick;
    }

    /***
     * Se establece el nombre idicado por el usaurio
     * @param nick recibe el nombre indicado por el usuario
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /***
     * Retorna el ip indicado
     * @return retorna el ip indicado
     */
    public String getIp() {
        return ip;
    }

    /***
     * Se establece el ip por el ip indicado
     * @param ip recibe el ip indicado
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /***
     * Retorna el mensaje idicado por el usuario
     * @return retorna el mensaje idicado
     */
    public String getMensaje() {
        return mensaje;
    }

    /***
     * Se establece el mensaje idicado por el usuario
     * @param mensaje recibe el mensaje idicado por el usuario
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
