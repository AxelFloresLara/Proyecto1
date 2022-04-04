package sockets.servidor;
import sockets.conexion.Conexion;
import java.io.*;

public class Servidor extends Conexion {
    public Servidor() throws IOException{super("servidor");}
    public void startServer(){
        try{
            System.out.println("Esperando la conexion...");
            cs = ss.accept();
            System.out.println("Cliente en linea");           
            salida_cliente = new DataOutputStream(cs.getOutputStream());            
            salida_cliente.writeUTF("Peticion recibida y aceptada");          
        }    
        catch (IOException e){
            System.out.println("Se dió la excepcion");  
        }
    
    }
}
