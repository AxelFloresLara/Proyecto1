package sockets.conexion;
import java.io.*;
import java.net.*;
        
public class Conexion {
    /* Se definen los objetos para completar establecer la conexion entre Cliente y Servidor */
    /* PUERTO: Aquí se le asgigna el puerto a utilizar en la conexión de los sockets*/ 
    /* HOST: Aquí se asigna la IP que va a utilizar la conexión para establecerse*/
    /* mensaje_servidor: Se define como variable String que será utilizado para comunicar el proceso en el que se encuentra el servidor */
    /* ss: Es el nombre del ServerSocket a utilizar en la conexion */
    /* cs: Es el nombre del Socket a utilizar en la conexion */
    /* salida_servidor y salida_cliente: Serán utilizados para comunicar el estado*/
    private final int PUERTO = 1200;
    private final String HOST = "127.0.0.1";
    protected String mensaje_servidor;
    protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salida_servidor, salida_cliente;
    
    public Conexion(String tipo) throws IOException{
        if(tipo.equalsIgnoreCase("servidor")){
            ss = new ServerSocket(PUERTO);
            cs = new Socket();
        }
        else{
            cs = new Socket(HOST, PUERTO);
        }                    
    }   
    
    
}
