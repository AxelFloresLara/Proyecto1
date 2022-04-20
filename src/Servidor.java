import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.*;
import javax.swing.*;

public class Servidor extends Cliente {   
    /* ServerSocket: Nos permite manipular la conxexion desde el servidor */
    ServerSocket server = null; 
    
    /* Socket: Nos permite implementar la conexión por parte del cliente*/
    Socket client = null;
    
    
    public Servidor(){
        
    /* Constructor del metodo MakeInterface*/
        MakeInterfacee();
        numaleatorios();
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
            cronometro.setText("Tiempo "+min+":"+seg); 
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
        
        
        
        consegund = 0;
        espera = new Timer (1000, new ActionListener()
        {
          
        public void actionPerformed(ActionEvent e) 
            {
                consegund++;
            }});
        espera.start();
        espera.stop();
        consegund = 0;
        ban=0;
        ban1=0;
               
        matriz = new JLabel[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = new JLabel();
                matriz[i][j].setSize(matriz[i][j].getWidth(), matriz[i][j].getHeight());
                //aqui la demas espacios a la imagenes para que no salgan pegadas 
                matriz[i][j].setBounds(175+(j*125),30+(i*156), 125, 156);
                //declaramos la imagenes que tiene el los nombres de 1 a 10
                matriz[i][j].setIcon(new ImageIcon("src/imagenes/"+mat1[i][j]+".PNG"));
                //colocamos que la matriz se muestre en pantalla
                matriz[i][j].setVisible(true);
                //aqui se añaden junto con la 0
                ventana_jugar.add(matriz[i][j],0);             
            } 
            
        }
        
        contador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 5; l++) {
                                if(e.getSource() == matriz[k][l]){
                                   
                                   //cuando se da click a la carta esta se volteara
                                   if(mat1[k][l] == 0 && contador !=2){
                                       mat1[k][l] = matrx[k][l];
                                       matriz[k][l].setIcon(new ImageIcon("src/imagenes/"+mat1[k][l]+".PNG"));
                                       contador++;
                                       acnum = matrx[k][l];
                                       acposx = k;
                                       acposy = l;
                                       if(contador == 1){
                                            annum = matrx[k][l];
                                            anposx = k;
                                            anposy = l;
                                       if(contador == 1){
                                            annum = matrx[k][l];
                                            anposx = k;
                                            anposy = l;

                                       }
                                       
                                       //tiempo que se tarda en dar vuelta
                                       espera2 = new Timer (500, new ActionListener()
                                       {
          
                                        public void actionPerformed(ActionEvent e) {

                                           if(contador == 2 && ban1 == 0){
                                               espera.restart();
                                               ban1=1;
                                            }
                                            if(contador == 2 && consegund == 2){
                                                espera.stop();
                                                consegund = 0;
                                                
                                                //Desaparecen las cartas que son iguales y deja las que aun no se encuentran
                                                if(mat1[acposx][acposy]==mat1[anposx][anposy]){
                                                    mat1[acposx][acposy] = -1;
                                                    mat1[anposx][anposy] = -1;
                                                    matriz[acposx][acposy].setIcon(new ImageIcon("src/imagenes/"+mat1[acposx][acposy]+".PNG"));
                                                    matriz[anposx][anposy].setIcon(new ImageIcon("src/imagenes/"+mat1[anposx][anposy]+".PNG"));
                                                    contador=0;
                                                    //gano si toda la mat2 es -1
                                                    int acum = 0;
                                                    for (int m = 0; m < 4; m++) {
                                                       for (int n = 0; n < 5; n++) {
                                                          if (mat1[m][n] == -1)
                                                              acum++;
                                                              numaleatorios();
                                                              puntos++;
                                                              puntuacion.setText("P1 "+puntos);
                                                          }
                                                    }
                                                    //cuando no se encuentre ninguna para entonces aparecera
                                                    //un mensaje diciendo que gano y ejecutando automaticamente
                                                    //la ventana Recordjugador
                                                       if(acum == 20){
                                                           System.out.println("coso");
                                                           
                                                       }
                                                }
                                                for (int m = 0; m < 4; m++) {
                                                    for (int n = 0; n < 5; n++) {
                                                        //se coloca el valor -1 a las cartas pares
                                                        if(mat1[m][n]!=0 && mat1[m][n]!=-1){
                                                            mat1[m][n] = 0;
                                                            matriz[m][n].setIcon(new ImageIcon("src/imagenes/"+mat1[m][n]+".PNG"));
                                                            contador=0;
                                                        }
                                                        System.out.println("...");

                                                    }

                                                }
                                                ban1=0;
                                            }
                                        }});
                                       if(ban == 0)
                                           espera2.start();
                                           ban = 1;
                                       if(contador == 2)
                                           espera2.restart();
                                   }    
  
                                }
                                
                            }
                            
                        }
                    }

                    }
                    
                });
                
            }
            
        }     
        
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
    private void numaleatorios(){
        int acumulador = 0;
         for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 5; j++){
                matrx[i][j] = 0;
              //  mat2[i][j] = 0;
                
            }    
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matrx[i][j] = ran.nextInt(10)+1;
                
                do{
                    acumulador = 0;
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 5; l++) {
                             if(matrx[i][j]== matrx[k][l]){
                                acumulador +=1;
                            }
                        }
                    }
                //esto se coloca para que solo se duplique dos veces la carta
                if(acumulador == 3){
                    matrx[i][j] = ran.nextInt(10)+1;
                }
                }while(acumulador == 3); 
            }   
        }                                
    }
        public static void main(String [] args){
        new Servidor();
        
    }    
} 