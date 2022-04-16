import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Servidor extends Cliente {   
    /* ServerSocket: Nos permite manipular la conxexion desde el servidor */
    ServerSocket server = null; 
    
    /* Socket: Nos permite implementar la conexión por parte del cliente*/
    Socket client = null;
    
    
    public Servidor(){
        
    /* Constructor del metodo MakeInterface*/
        MakeInterfacee();
    }
    /* Metodo para interfaz */
    public void MakeInterfacee(){
        /*CREACIONES DE LOS OBJETOS*/
        
        /* Acción de Botones*/
        ActionListener oir_contexto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(true);
                elegir_contexto2.setSelected(false);
                elegir_contexto3.setSelected(false);                         
            }
        };
        elegir_contexto.addActionListener(oir_contexto); 
        
        
        ActionListener oir_contexto2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(false);
                elegir_contexto2.setSelected(true);
                elegir_contexto3.setSelected(false);           
            }
        };
        elegir_contexto2.addActionListener(oir_contexto2);
        
        
        ActionListener oir_contexto3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(false);
                elegir_contexto2.setSelected(false);
                elegir_contexto3.setSelected(true);                         
            }
        };
        elegir_contexto3.addActionListener(oir_contexto3); 
        
        
        ActionListener oir_validar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
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
                    tiempo.start();
                    aleatorio = (int) (Math.random() * 2);
                    if(aleatorio == 0){
                        actual_1.setText("Turno actual: "+ ingresar_nombre1.getText());
                    }
                    if(aleatorio == 1){
                        actual_1.setText("Turno actual: "+ ingresar_nombre2.getText());
                    }
                    
               }
            }
        };
        boton_validar.addActionListener(oir_validar);
        
        
        ActionListener oir_creditos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_cliente.setVisible(false);
                ventana_creditos.setVisible(true);
           
            }
        };      
        boton_creditos.addActionListener(oir_creditos);
        
        
        ActionListener oir_volver_creditos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_creditos.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver2.addActionListener(oir_volver_creditos);
        
        
        ActionListener oir_reglas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_cliente.setVisible(false);
                ventana_reglas.setVisible(true);
                reglas.setVisible(true);
            }
        };
        boton_reglas.addActionListener(oir_reglas);
        
            
        ActionListener oir_volver_reglas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_reglas.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver1.addActionListener(oir_volver_reglas);
        
        
        tiempo = new Timer (1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {           
                seg++;
                if(seg == 60){
                    min++;
                    seg=0;
                }        
            //declaramos en una variable cronometro el tiempo que transcurre
            cronometro.setText(min+":"+seg); 
            }});
        
        ActionListener oir_tamaño = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamaño1.setSelected(true);
                tamaño2.setSelected(false);
                tamaño3.setSelected(false);                         
            }
        };
        tamaño1.addActionListener(oir_tamaño);
        
        
        
        ActionListener oir_tamaño2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamaño1.setSelected(false);
                tamaño2.setSelected(true);
                tamaño3.setSelected(false);           
            }
        };
        tamaño2.addActionListener(oir_tamaño2);
        
        
        ActionListener oir_tamaño3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamaño1.setSelected(false);
                tamaño2.setSelected(false);
                tamaño3.setSelected(true);                         
            }
        };
        tamaño3.addActionListener(oir_tamaño3); 
        
        
        ActionListener oir_info1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info1.setVisible(true);
                ventana_cliente.setVisible(false);
            }
        };
        info_cartas1.addActionListener(oir_info1); 
        
        
        ActionListener oir_info2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info2.setVisible(true);
                ventana_cliente.setVisible(false);
            }
        };
        info_cartas2.addActionListener(oir_info2); 
        
        
        ActionListener oir_info3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info3.setVisible(true);
                ventana_cliente.setVisible(false);
            }
        };
        info_cartas3.addActionListener(oir_info3); 
        
        
        ActionListener oir_volver_info1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info1.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver.addActionListener(oir_volver_info1);
        
        
        ActionListener oir_volver_info2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info2.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver3.addActionListener(oir_volver_info2);
        
        
        ActionListener oir_volver_info3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info3.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver4.addActionListener(oir_volver_info3);
        
        
    /**/
        Thread principal1 = new Thread(new Runnable(){
            public void run(){
                try{
                    /* se define el puerto del servidor, uno alto para asegurar que esté libre*/
                server = new ServerSocket(1200);
                    System.out.println("Servidor Iniciado");
                    while(true){
                        /* siempre va a aceptar las conexiones que vengan a este puerto*/
                        client = server.accept();
                        System.out.println("Cliente Iniciado");
                        /* metodos para intercambio de mensajes */
                    }
                }catch(Exception ex){
                    System.out.println("servidor ya iniciado");
                }         
            }
        });
        principal1.start();
    }
     
        public static void main(String [] args){
        new Servidor();
        
    }    
} 