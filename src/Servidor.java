//importar bibliotecas 

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
        
    /* Constructor de los metodos */
        MakeInterfacee();
        aleatorio();
        cambiar_turno1();
        cambiar_turno2();
    }
    /* Metodo para interfaz */
    public void MakeInterfacee(){
        /*CREACIONES DE LOS OBJETOS*/
           
        /* Acción de Botones de seleccion que permiten al usuario elegir el tipo de cartas con las que quiere jugar */
        
        ActionListener oir_contexto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(true);
                elegir_contexto2.setSelected(false);
                elegir_contexto3.setSelected(false);                         
            }
        };
        elegir_contexto.addActionListener(oir_contexto); 
        
        // creacion de la interfaz sencilla del servidor 
        datos = new JFrame("DATOS");
        datos.setSize(1000, 720);
        datos.setLocation(150, 0);
        datos.setVisible(false);
        datos.setResizable(false);
        datos.setLayout(null);
        datos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        //acción para el radiobutton elegir_contexto2
        ActionListener oir_contexto2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(false);
                elegir_contexto2.setSelected(true);
                elegir_contexto3.setSelected(false);           
            }
        };
        elegir_contexto2.addActionListener(oir_contexto2);
        
        //acción para el radiobutton llamado elegir_contexto3
        ActionListener oir_contexto3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegir_contexto.setSelected(false);
                elegir_contexto2.setSelected(false);
                elegir_contexto3.setSelected(true);                         
            }
        };
        elegir_contexto3.addActionListener(oir_contexto3); 
        
        // acción para el botón que nos lleva a la pantalla de juego
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
                    datos.setVisible(true);
                    ventana_cliente.setVisible(false);
                    ventana_jugar.setVisible(true);
                    nombre1.setText("Usuario 1: "+ingresar_nombre1.getText());
                    nombre2.setText("Usuario 2: "+ingresar_nombre2.getText());                  
                    tiempo.start();
                    aleatorio = (int) (Math.random() * 2);
                    if(aleatorio == 0){
                        actual_1.setText("Turno actual: "+ingresar_nombre1.getText());
                    }
                    if(aleatorio == 1){
                        actual_1.setText("Turno actual: "+ingresar_nombre2.getText());
                    }
                    
               }
            }
        };
        boton_validar.addActionListener(oir_validar);
        
        //acción para el botón que nos lleva a la pantalla de creditos 
        ActionListener oir_creditos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_cliente.setVisible(false);
                ventana_creditos.setVisible(true);
           
            }
        };      
        boton_creditos.addActionListener(oir_creditos);
        
        //acción para el botón_volver2
        ActionListener oir_volver_creditos = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_creditos.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver2.addActionListener(oir_volver_creditos);
        
        //acción para el botón que nos muestra la pantalla de reglas 
        ActionListener oir_reglas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_cliente.setVisible(false);
                ventana_reglas.setVisible(true);
                reglas.setVisible(true);
            }
        };
        boton_reglas.addActionListener(oir_reglas);
        
        //accion para el botón_volver1    
        ActionListener oir_volver_reglas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_reglas.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver1.addActionListener(oir_volver_reglas);
        
        
        //logica del temporizador
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
        
        //tamaños: al elegir un tamaño, los otros 2 radiobuttons se desactivarán para así permitir al usuario una unica selección 
        //acción del radiobutton para elegir tamaño llamado tamaño1
        ActionListener oir_tamaño = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamaño1.setSelected(true);
                tamaño2.setSelected(false);
                tamaño3.setSelected(false);                         
            }
        };
        tamaño1.addActionListener(oir_tamaño);
        
        
        //acción del radiobutton para elegir el tamaño llamado tamaño2
        ActionListener oir_tamaño2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamaño1.setSelected(false);
                tamaño2.setSelected(true);
                tamaño3.setSelected(false);           
            }
        };
        tamaño2.addActionListener(oir_tamaño2);
        
        //acción del radiobutton para elegir tamaño llamado tamaño3
        ActionListener oir_tamaño3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tamaño1.setSelected(false);
                tamaño2.setSelected(false);
                tamaño3.setSelected(true);                         
            }
        };
        tamaño3.addActionListener(oir_tamaño3); 
        
        // acción para el botón info_cartas1
        ActionListener oir_info1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info1.setVisible(true);
                ventana_cliente.setVisible(false);
            }
        };
        info_cartas1.addActionListener(oir_info1); 
        
        
        // acción para el botón info_cartas2
        ActionListener oir_info2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info2.setVisible(true);
                ventana_cliente.setVisible(false);
            }
        };
        info_cartas2.addActionListener(oir_info2); 
        
        // acción para el botón info_cartas3
        ActionListener oir_info3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info3.setVisible(true);
                ventana_cliente.setVisible(false);
            }
        };
        info_cartas3.addActionListener(oir_info3); 
        
        //acción para el botón_volver 
        ActionListener oir_volver_info1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info1.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver.addActionListener(oir_volver_info1);
        
        // acción para el botón_volver3
        ActionListener oir_volver_info2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info2.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver3.addActionListener(oir_volver_info2);
        
        // acción para el botón_volver4
        ActionListener oir_volver_info3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_info3.dispose();
                ventana_cliente.setVisible(true);
            }
        };
        boton_volver4.addActionListener(oir_volver_info3);
        
        //sew crea un nuevo timer de espera, el cual será utilizado para definir el tiempo de muestra de la carta 
        consegund = 0;
        esperar = new Timer (1000, new ActionListener()
        {
          
        public void actionPerformed(ActionEvent e) 
            {
                consegund++;
            }});
        esperar.start();
        esperar.stop();
        consegund = 0;
        ban=0;
        ban1=0;
        
        
        //añadir la matriz principal de juego 
        tablero = new JLabel[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = new JLabel();
                tablero[i][j].setSize(tablero[i][j].getWidth(), tablero[i][j].getHeight());
                //espacios a la imagenes para que no salgan pegadas 
                tablero[i][j].setBounds(175+(j*125),30+(i*156), 125, 156);
                //declaramos la imagenes 
                tablero[i][j].setIcon(new ImageIcon("src/imagenes/"+mat1[i][j]+".PNG"));
                //tablero en pantalla
                tablero[i][j].setVisible(true);
                //aqui se añaden
                ventana_jugar.add(tablero[i][j],0);               
            } 
            
        }
        
        //Se añade la matriz con las cartas volteadas en la interfaz del servidor 
        tablero2 = new JLabel[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                tablero2[i][j] = new JLabel();
                tablero2[i][j].setSize(tablero2[i][j].getWidth(), tablero2[i][j].getHeight());
                //se definen posiciones de las cartas 
                tablero2[i][j].setBounds(175+(j*125),30+(i*156), 125, 156);
                //definmos la imagenes 
                tablero2[i][j].setIcon(new ImageIcon("src/imagenes/"+mat1[i][j]+".PNG"));
                //hacemos la matriz visible
                tablero2[i][j].setVisible(true);
                //se añaden a la pantalla datos
                datos.add(tablero2[i][j], 0);               
            } 
            
        }
             
        contador = 0;
        //delimitaciones con indices
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                //nueva accion definida para la matriz
                tablero[i][j].addMouseListener(new MouseAdapter(){
                    //acción al momento de clickear alguna carta 
                    public void mousePressed(MouseEvent e){
                        //manejo de indices 
                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 5; l++) {
                                if(e.getSource() == tablero[k][l]){
                                   //voltear carta al seleccionar
                                   if(mat1[k][l] == 0 && contador !=2){
                                       mat1[k][l] = mat[k][l];
                                       //if para decidir que cartas mostrar segun la eleccion del usuario 
                                       //mostrar cartas de la primer seleccion disponible
                                       if(elegir_contexto.isSelected()){
                                       tablero[k][l].setIcon(new ImageIcon("src/imagenes/"+mat1[k][l]+".PNG"));
                                       }
                                       //mostrar cartas de la segunda seleccion disponible
                                       if(elegir_contexto2.isSelected()){
                                       tablero[k][l].setIcon(new ImageIcon("src/imagenes2/"+mat1[k][l]+".PNG"));
                                       }
                                       //mostrar cartas de la tercer categoria disponible
                                       if(elegir_contexto3.isSelected()){
                                       tablero[k][l].setIcon(new ImageIcon("src/imagenes3/"+mat1[k][l]+".PNG"));    
                                       }
                                       contador++;
                                       acnum = mat[k][l];
                                       posinx = k;
                                       acposy = l;  
                                       //cartas de la matriz en la interfaz sencilla del servidor
                                       tablero2[k][l].setIcon(new ImageIcon("src/imagenes/"+mat1[k][l]+".PNG"));
                                       if(contador == 1){
                                       annum = mat[k][l];
                                       anposx = k;
                                       anposy = l;                                        

                                       //tiempo con la carta mostrada
                                       esperar2 = new Timer (500, new ActionListener()                                              
                                       {
          
                                        public void actionPerformed(ActionEvent e) {

                                        if(contador == 2 && ban1 == 0){
                                        esperar.restart();
                                        ban1=1;
                                        }
                                        if(contador == 2 && consegund == 2){
                                        esperar.stop();
                                        consegund = 0;
                                                
                                        //quitar las cartas que se van encontrando 
                                        if(mat1[posinx][acposy]==mat1[anposx][anposy]){
                                        mat1[posinx][acposy] = -1;
                                        mat1[anposx][anposy] = -1;
                                        tablero[posinx][acposy].setIcon(new ImageIcon("src/imagenes/"+mat1[posinx][acposy]+".PNG"));
                                        tablero[anposx][anposy].setIcon(new ImageIcon("src/imagenes/"+mat1[anposx][anposy]+".PNG"));
                                        contador=0; 
                                        
                                        
                                        //codigo por si saca par
                                        int acum = 0;
                                        for (int m = 0; m < 4; m++) {
                                        for (int n = 0; n < 5; n++) {
                                        if (mat1[m][n] == -1)
                                        acum++;
                                        //aleatorio();
                                        if(actual_1.getText().equals("Turno actual: "+ingresar_nombre1.getText())){
                                           
                                        puntos += 1;
                                        puntos2 += 1;
                                        puntuacion.setText("P1: "+puntos);
                                        }
                                        if(actual_1.getText().equals("Turno actual: "+ingresar_nombre2.getText())){                                           
                                            puntuacion2.setText("P2: "+puntos2);
                                            puntos2+=1;
                                            puntos-=1;
                                        }
                                        cambiar_turno2();
                                        }                                                     
                                        }

                                        //mensaje y puntuación al terminar de jugar 
                                        if(acum == 20){
                                        JOptionPane.showMessageDialog(ventana_jugar, " FELICIDADES GANASTE \n Tu puntuación "+puntos);
                                        System.exit(0);
                                        }
                                        }
                                        
                                        //codigo por si saca cartas diferentes
                                        for (int m = 0; m < 4; m++) {
                                         for (int n = 0; n < 5; n++) {
                                        //se coloca el valor -1 a las cartas pares
                                        if(mat1[m][n]!=0 && mat1[m][n]!=-1){
                                        mat1[m][n] = 0;
                                        tablero[m][n].setIcon(new ImageIcon("src/imagenes/"+mat1[m][n]+".PNG"));
                                        contador=0;
                                        
                                        cambiar_turno1();                                                                               
                                        }
                                            }
                                        
                                            }
                                                ban1=0;
                                            }
                                        
                                        }});
                                       //inicio y reinicio del segundo timer
                                        if(ban == 0)
                                           esperar2.start();
                                           ban = 1;
                                        if(contador == 2)
                                           esperar2.restart();
                                        
                                        //cerrar los corchetes que quedan aún abiertos
                                       }
                                   }
                                }
                            }
                        }
                    }
                
                });
            }
        }
    

         
    //conexión de parte del servidor mediante un hilo 
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
        //arranque del hilo 
        principal1.start();
    }   
      
    //generar cartas aleatorias al inicio de cada juego
    private void aleatorio(){
        int acumulador = 0;
         for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 5; j++){
                mat[i][j] = 0;                            
            }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = ran.nextInt(10)+1;            
                do{
                    acumulador = 0;
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 5; l++) {
                             if(mat[i][j]== mat[k][l]){
                                acumulador +=1;
                            }
                        }
                    }
                //esto se coloca para que solo se duplique dos veces la carta
                if(acumulador == 3){
                    mat[i][j] = ran.nextInt(10)+1;                  
                }
                }while(acumulador == 3); 
            }   
        }    
        //acción del botón para salir 
           ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        btn.addActionListener(salir);
    }
    // cambiar el turno actual 
    public void cambiar_turno1(){
            if(actual_1.getText().equals("Turno actual: "+ingresar_nombre1.getText())){
                actual_1.setText("Turno actual: "+ingresar_nombre2.getText());
            }
            if(actual_1.getText().equals("Turno actual: "+ingresar_nombre1.getText())){
                actual_1.setText("Turno actual: "+ingresar_nombre2.getText());
            }
        }
    
    private void cambiar_turno2(){
            if(actual_1.getText().equals("Turno actual: "+ingresar_nombre2.getText())){
                actual_1.setText("Turno actual: "+ingresar_nombre1.getText());
            }
            if(actual_1.getText().equals("Turno actual: "+ingresar_nombre2.getText())){
                actual_1.setText("Turno actual: "+ingresar_nombre1.getText());
            }
    }
    // main del programa serrvidor
        public static void main(String [] args){
        new Servidor();
        }  
}