package sockets.cliente;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import sockets.conexion.Conexion;
import javax.swing.*;


public class Cliente extends Conexion{
    /* Objetos */
        public JFrame ventana_cliente = null; 
        public JTextField ingresar_nombre1 = null;
        public JTextField ingresar_nombre2 = null;
        public JRadioButton elegir_contexto = null; 
        public JRadioButton elegir_contexto2 = null;
        public JRadioButton elegir_contexto3 = null;
        public JFrame ventana_jugar = null;
        public JLabel nombre1 = null;
        public JLabel nombre2 = null;
        public JButton boton_validar = null; 
        
        
    public Cliente() throws IOException{super("cliente");}
    public void hacer_interfaz(){
        
        /* Creación de los objetos*/
        /* JFrame: Es utilizado para crear una nueva ventana, que funcionará posteriormente como contenedor del resto de la interfaz*/
        /* JTextField: Son utilizados como almacenadores de texto, en ese caso serán empleados para ingresar los nombres de usuarios */
        /* JRadioButton: Son botones de selección, serán implementados para elegir las cartas con las qué se quiere jugar */
        /* .setSize: Es utilizado para definir el tamaño del objeto que se está creando*/
        /* .setVisible: Es utilizado para definir si el objeto aparecerá o no */
        /* .setLocation: Es utilizado para configurar la ubicación de aparición del objeto, según las coordenadas que se decidan */
        /* .setResizable: Se le define a la ventana principal si tiene la posibilidad de modificar su tamaño original o no. */
        /* .setLayout: Es definido como null para así facilitar el acomodo de los demás componentes graficos */
        /* .setDefaultCloseOperation: Con esta definición hacemos que una vez la ventana se cierre, el programa acabe con la ejecución */
        /* add: para añadir a una ventana en especifico un widget*/
        /* ActionListener: para manejar y detectar eventos de accion en los botones*/
        
        ventana_cliente = new JFrame("Cliente");
        ventana_cliente.setSize(600, 540);
        ventana_cliente.setVisible(true);
        ventana_cliente.setLocation(300, 100);
        ventana_cliente.setResizable(false);
        ventana_cliente.setLayout(null);
        ventana_cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ingresar_nombre1 = new JTextField(10);
        ventana_cliente.add(ingresar_nombre1);
        ingresar_nombre1.setBounds(160, 200, 120, 25);
        ingresar_nombre1.setFont(new Font("Arial", Font.ROMAN_BASELINE, 18));  
        
        ingresar_nombre2 = new JTextField(10);
        ventana_cliente.add(ingresar_nombre2);
        ingresar_nombre2.setSize(120, 25);
        ingresar_nombre2.setLocation(320, 200);
        ingresar_nombre2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 18));
        
        elegir_contexto = new JRadioButton("Categoría 1", true);
        ventana_cliente.add(elegir_contexto);
        elegir_contexto.setBounds(125, 300, 100, 20);
        elegir_contexto.setVisible(true);       
        ActionListener oir_contexto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(true);
                elegir_contexto2.setSelected(false);
                elegir_contexto3.setSelected(false);                         
            }
        };
        elegir_contexto.addActionListener(oir_contexto);            
        
        elegir_contexto2 = new JRadioButton("Categoría 2");
        ventana_cliente.add(elegir_contexto2);
        elegir_contexto2.setBounds(250, 300, 100, 20);
        elegir_contexto2.setVisible(true);       
        ActionListener oir_contexto2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(false);
                elegir_contexto2.setSelected(true);
                elegir_contexto3.setSelected(false);           
            }
        };
        elegir_contexto2.addActionListener(oir_contexto2);
          
        elegir_contexto3 = new JRadioButton("Categoría 3");
        ventana_cliente.add(elegir_contexto3);
        elegir_contexto3.setBounds(375, 300, 130, 20);
        elegir_contexto3.setVisible(true);
        ActionListener oir_contexto3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(false);
                elegir_contexto2.setSelected(false);
                elegir_contexto3.setSelected(true);                         
            }
        };
        elegir_contexto3.addActionListener(oir_contexto3); 
        
        ventana_jugar = new JFrame("JUEGA!");
        ventana_jugar.setSize(600, 540);
        ventana_jugar.setLocation(300, 100);
        ventana_jugar.setVisible(false);
        ventana_jugar.setResizable(false);
        ventana_jugar.setLayout(null);
        ventana_jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
        nombre1 = new JLabel("");
        ventana_jugar.add(nombre1);
        nombre1.setLocation(5, 2);
        nombre1.setSize(150, 30);
        
        nombre2 = new JLabel("");
        ventana_jugar.add(nombre2);
        nombre2.setLocation(5, 25);
        nombre2.setSize(150, 30);
        
        boton_validar = new JButton("Jugar");  
        ventana_cliente.add(boton_validar);
        boton_validar.setSize(140, 50);
        boton_validar.setBackground(Color.LIGHT_GRAY);
        boton_validar.setLocation(230, 240);   
        boton_validar.setFont(new Font("Arial", Font.ROMAN_BASELINE, 18));
        ActionListener oir_validar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(ingresar_nombre1.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Ingrese el nombre del usuario 1");
               }
               if(ingresar_nombre2.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Ingrese el nombre del usuario 2");
               }
               else{
                    ventana_cliente.setVisible(false);
                    ventana_jugar.setVisible(true);
                    nombre1.setText("Usuario 1: "+ingresar_nombre1.getText());
                    nombre2.setText("Usuario 2: "+ingresar_nombre2.getText());                   
                
               }
            }
        };
        boton_validar.addActionListener(oir_validar);
        
        
    }
}