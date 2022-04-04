package sockets.cliente;
import java.io.*;
import sockets.conexion.Conexion;
import javax.swing.*;


public class Cliente extends Conexion{
    /* Objetos */
        public JFrame ventana_cliente = null; 
       
    public Cliente() throws IOException{super("cliente");}
    public void hacer_interfaz(){
        
        /* Creación de los objetos*/
        /* JFrame: Es utilizado para crear una nueva ventana, que funcionará posteriormente como contenedor del resto de la interfaz*/
        
        ventana_cliente = new JFrame("Cliente");
        ventana_cliente.setSize(600, 540);
        ventana_cliente.setVisible(true);
        ventana_cliente.setLocation(300, 100);
        ventana_cliente.setResizable(false);
        ventana_cliente.setLayout(null);
        ventana_cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}