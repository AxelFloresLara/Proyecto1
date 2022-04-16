import java.awt.*;

import java.net.Socket;

import javax.swing.*;

public class Cliente {
    
        JFrame ventana_cliente, ventana_jugar, ventana_creditos, ventana_reglas, ventana_info1, ventana_info2, ventana_info3 = null; 
        JTextField ingresar_nombre1, ingresar_nombre2 = null;
        JRadioButton elegir_contexto, elegir_contexto2, elegir_contexto3, tamaño1, tamaño2, tamaño3  = null; 
        JLabel nombre1, nombre2, titulo_primero, titulo_segundo, cronometro, actual_1, matriz [][], cr_cart1, cr_cart2, cr_cart3, cr_cart4, cr_cart5, cr_cart6, cr_cart7, cr_cart8, cr_cart9, cr_cart10, po_cart1, po_cart2, po_cart3, po_cart4, po_cart5, po_cart6, po_cart7, po_cart8, po_cart9, po_cart10,nt_cart1, nt_cart2, nt_cart3, nt_cart4, nt_cart5, nt_cart6, nt_cart7, nt_cart8, nt_cart9, nt_cart10, titulo_info = null;
        JButton boton_validar, boton_creditos, boton_volver2, boton_reglas, boton_volver1, info_cartas1, info_cartas2, info_cartas3, boton_volver, boton_volver3, boton_volver4 = null; 
        JTextArea creditos, reglas = null;
        Timer tiempo = null;
        int seg, min, aleatorio = 0;
        int mat [][] = new int[4][5];
        int mat2 [][] = new int[4][5];
        Socket client = null;
        
        public Cliente(){
            MakeInterface();
    }
        public void MakeInterface(){

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
        elegir_contexto.setBounds(100, 300, 100, 20);
        elegir_contexto.setVisible(true);                  
        
        elegir_contexto2 = new JRadioButton("Categoría 2");
        ventana_cliente.add(elegir_contexto2);
        elegir_contexto2.setBounds(250, 300, 100, 20);
        elegir_contexto2.setVisible(true);       
          
        elegir_contexto3 = new JRadioButton("Categoría 3");
        ventana_cliente.add(elegir_contexto3);
        elegir_contexto3.setBounds(400, 300, 130, 20);
        elegir_contexto3.setVisible(true);
        
        ventana_jugar = new JFrame("JUEGA!");
        ventana_jugar.setSize(600, 540);
        ventana_jugar.setLocation(300, 100);
        ventana_jugar.setVisible(false);
        ventana_jugar.setResizable(false);
        ventana_jugar.setLayout(null);
        ventana_jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
        actual_1 = new JLabel("");
        ventana_jugar.add(actual_1);
        actual_1.setLocation(400, 2);
        actual_1.setSize(150, 30);
        actual_1.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        
        nombre1 = new JLabel("");
        ventana_jugar.add(nombre1);
        nombre1.setLocation(5, 2);
        nombre1.setSize(150, 30);
        nombre1.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        
        nombre2 = new JLabel("");
        ventana_jugar.add(nombre2);
        nombre2.setLocation(5, 25);
        nombre2.setSize(150, 30);
        nombre2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        
        boton_validar = new JButton("Jugar");  
        ventana_cliente.add(boton_validar);
        boton_validar.setSize(140, 50);
        boton_validar.setBackground(Color.LIGHT_GRAY);
        boton_validar.setLocation(230, 240);   
        boton_validar.setFont(new Font("Arial", Font.ROMAN_BASELINE, 18));
        
        ventana_creditos = new JFrame("creditos");
        ventana_creditos.setSize(600, 540);
        ventana_creditos.setResizable(false);
        ventana_creditos.setLocation(300, 100);
        ventana_creditos.setVisible(false);
        ventana_creditos.setLayout(null);
        
        boton_creditos = new JButton("Creditos");
        ventana_cliente.add(boton_creditos);
        boton_creditos.setLocation(0, 450);
        boton_creditos.setBackground(Color.LIGHT_GRAY);
        boton_creditos.setSize(120, 30);
        
        creditos = new JTextArea("Aquí va mi nombre \n\nAquí va mi carné \n\nAquí va la insitución \n\nAquí va la fecha de entrega");
        ventana_creditos.add(creditos);
        creditos.setLocation(100, 50);
        creditos.setSize(375, 275);
        creditos.setEditable(false);
        creditos.setBackground(Color.LIGHT_GRAY);
        creditos.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
        
        boton_volver2 = new JButton("Volver");
        ventana_creditos.add(boton_volver2);
        boton_volver2.setLocation(0,0);
        boton_volver2.setBackground(Color.LIGHT_GRAY);
        boton_volver2.setSize(80, 30);      
        
        /**/
        boton_reglas = new JButton("Como jugar");
        ventana_cliente.add(boton_reglas);
        boton_reglas.setLocation(464, 450);
        boton_reglas.setBackground(Color.LIGHT_GRAY);
        boton_reglas.setSize(120, 30);
              
        /**/
        ventana_reglas = new JFrame("COMO JUGAR");
        ventana_reglas.setSize(600, 540);
        ventana_reglas.setVisible(false);
        ventana_reglas.setLocation(300, 100);
        ventana_reglas.setResizable(false);
        ventana_reglas.setLayout(null);
        ventana_reglas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        reglas = new JTextArea("Aquí va la regla numero 1 \n\nAquí va la regla numero 2 \n\nEspecificación de carta 1 \n\n Especificación carta 2 \n\nEspecificacion carta 3");
        ventana_reglas.add(reglas);
        reglas.setLocation(100, 50);
        reglas.setSize(375, 275);
        reglas.setEditable(false);
        reglas.setBackground(Color.GRAY);
        reglas.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
        /**/
        
        
        /**/
        boton_volver1 = new JButton("Volver");
        ventana_reglas.add(boton_volver1);
        boton_volver1.setVisible(true);
        boton_volver1.setLocation(0,0);
        boton_volver1.setSize(80, 30);
        boton_volver1.setBackground(Color.LIGHT_GRAY);
        /**/
        
        /**/
        titulo_primero = new JLabel("Nombre 1");
        ventana_cliente.add(titulo_primero);
        titulo_primero.setLocation(160, 170);
        titulo_primero.setSize(100, 40);
        titulo_primero.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        
        titulo_segundo = new JLabel("Nombre 2");
        ventana_cliente.add(titulo_segundo);
        titulo_segundo.setLocation(320, 170);
        titulo_segundo.setSize(100, 40); 
        titulo_segundo.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        /**/
        
        
        /**/
        cronometro = new JLabel();
        cronometro.setBounds(540,5,150,40);
        cronometro.setVisible(true);
        ventana_jugar.add(cronometro);
        cronometro.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));       
        /**/
        
        
        /**/
        tamaño1 = new JRadioButton("Tamaño 1", true);
        ventana_cliente.add(tamaño1);
        tamaño1.setBounds(125, 330, 100, 20);
        tamaño1.setVisible(true);                  
        
        tamaño2 = new JRadioButton("Tamaño 2");
        ventana_cliente.add(tamaño2);
        tamaño2.setBounds(250, 330, 100, 20);
        tamaño2.setVisible(true);       
          
        tamaño3 = new JRadioButton("Tamaño 3");
        ventana_cliente.add(tamaño3);
        tamaño3.setBounds(375, 330, 130, 20);
        tamaño3.setVisible(true);
        /**/
        
        /**/
        info_cartas1 = new JButton("info");
        ventana_cliente.add(info_cartas1);
        info_cartas1.setLocation(70, 305);
        info_cartas1.setSize(30, 15);
        /**/
        
        
        /**/
        info_cartas2 = new JButton("info");
        ventana_cliente.add(info_cartas2);
        info_cartas2.setLocation(220, 305);
        info_cartas2.setSize(30, 15);

        /**/
        
        
        /**/
        info_cartas3 = new JButton("info");
        ventana_cliente.add(info_cartas3);
        info_cartas3.setLocation(370, 305);
        info_cartas3.setSize(30, 15);
        /**/
        
        /**/
        ventana_info1 = new JFrame("JUEGA!");
        ventana_info1.setSize(600, 540);
        ventana_info1.setLocation(300, 100);
        ventana_info1.setVisible(false);
        ventana_info1.setResizable(false);
        ventana_info1.setLayout(null);
        ventana_info1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        titulo_info = new JLabel("Baraja Contenida");
        ventana_info1.add(titulo_info);
        titulo_info.setLocation(230, 50);
        titulo_info.setSize(180, 30);
        titulo_info.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        boton_volver = new JButton("Volver");
        ventana_info1.add(boton_volver);
        boton_volver.setVisible(true);
        boton_volver.setLocation(0,0);
        boton_volver.setSize(80, 30);
        boton_volver.setBackground(Color.LIGHT_GRAY);

        /**/
        
        /**/
        ventana_info2 = new JFrame("JUEGA!");
        ventana_info2.setSize(600, 540);
        ventana_info2.setLocation(300, 100);
        ventana_info2.setVisible(false);
        ventana_info2.setResizable(false);
        ventana_info2.setLayout(null);
        ventana_info2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        titulo_info = new JLabel("Baraja Contenida");
        ventana_info2.add(titulo_info);
        titulo_info.setLocation(230, 50);
        titulo_info.setSize(180, 30);
        titulo_info.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        boton_volver3 = new JButton("Volver");
        ventana_info2.add(boton_volver3);
        boton_volver3.setVisible(true);
        boton_volver3.setLocation(0,0);
        boton_volver3.setSize(80, 30);
        boton_volver3.setBackground(Color.LIGHT_GRAY);
        /**/
        
        /**/
        ventana_info3 = new JFrame("JUEGA!");
        ventana_info3.setSize(600, 540);
        ventana_info3.setLocation(300, 100);
        ventana_info3.setVisible(false);
        ventana_info3.setResizable(false);
        ventana_info3.setLayout(null);
        ventana_info3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        titulo_info = new JLabel("Baraja Contenida");
        ventana_info3.add(titulo_info);
        titulo_info.setLocation(230, 50);
        titulo_info.setSize(180, 30);
        titulo_info.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        boton_volver4 = new JButton("Volver");
        ventana_info3.add(boton_volver4);
        boton_volver4.setVisible(true);
        boton_volver4.setLocation(0,0);
        boton_volver4.setSize(80, 30);
        boton_volver4.setBackground(Color.LIGHT_GRAY);

        /**/ 
        
        /**/
        cr_cart1 = new JLabel(new ImageIcon("src/imagenes/1.png"));
        ventana_info1.add(cr_cart1);
        cr_cart1.setBounds(10,150,100,120);
        cr_cart1.setVisible(true);
        
        cr_cart2 = new JLabel(new ImageIcon("src/imagenes/2.png"));
        ventana_info1.add(cr_cart2);
        cr_cart2.setBounds(120,150,100,120);
        cr_cart2.setVisible(true);
        
        cr_cart3 = new JLabel(new ImageIcon("src/imagenes/3.png"));
        ventana_info1.add(cr_cart3);
        cr_cart3.setBounds(240,150,100,120);
        cr_cart3.setVisible(true);
        
        cr_cart4 = new JLabel(new ImageIcon("src/imagenes/4.png"));
        ventana_info1.add(cr_cart4);
        cr_cart4.setBounds(360,150,100,120);
        cr_cart4.setVisible(true);
        
        cr_cart5 = new JLabel(new ImageIcon("src/imagenes/5.png"));
        ventana_info1.add(cr_cart5);
        cr_cart5.setBounds(480,150,100,120);
        cr_cart5.setVisible(true);
        
        cr_cart6 = new JLabel(new ImageIcon("src/imagenes/6.png"));
        ventana_info1.add(cr_cart6);
        cr_cart6.setBounds(10,300,100,120);
        cr_cart6.setVisible(true);
        
        cr_cart7 = new JLabel(new ImageIcon("src/imagenes/7.png"));
        ventana_info1.add(cr_cart7);
        cr_cart7.setBounds(120,300,100,120);
        cr_cart7.setVisible(true);
        
        cr_cart8 = new JLabel(new ImageIcon("src/imagenes/8.png"));
        ventana_info1.add(cr_cart8);
        cr_cart8.setBounds(240,300,100,120);
        cr_cart8.setVisible(true);
        
        cr_cart9 = new JLabel(new ImageIcon("src/imagenes/9.png"));
        ventana_info1.add(cr_cart9);
        cr_cart9.setBounds(360,300,100,120);
        cr_cart9.setVisible(true);
        
        cr_cart10 = new JLabel(new ImageIcon("src/imagenes/10.png"));
        ventana_info1.add(cr_cart10);
        cr_cart10.setBounds(480,300,100,120);
        cr_cart10.setVisible(true);
        /**/
        
        /**/
        po_cart1 = new JLabel(new ImageIcon("src/imagenes2/1.png"));
        ventana_info2.add(po_cart1);
        po_cart1.setBounds(10,150,100,120);
        po_cart1.setVisible(true);
        
        po_cart2 = new JLabel(new ImageIcon("src/imagenes2/2.png"));
        ventana_info2.add(po_cart2);
        po_cart2.setBounds(120,150,100,120);
        po_cart2.setVisible(true);
        
        po_cart3 = new JLabel(new ImageIcon("src/imagenes2/3.png"));
        ventana_info2.add(po_cart3);
        po_cart3.setBounds(240,150,100,120);
        po_cart3.setVisible(true);
        
        po_cart4 = new JLabel(new ImageIcon("src/imagenes2/4.png"));
        ventana_info2.add(po_cart4);
        po_cart4.setBounds(360,150,100,120);
        po_cart4.setVisible(true);
        
        po_cart5 = new JLabel(new ImageIcon("src/imagenes2/5.png"));
        ventana_info2.add(po_cart5);
        po_cart5.setBounds(480,150,100,120);
        po_cart5.setVisible(true);
        
        po_cart6 = new JLabel(new ImageIcon("src/imagenes2/6.png"));
        ventana_info2.add(po_cart6);
        po_cart6.setBounds(10,300,100,120);
        po_cart6.setVisible(true);
        
        po_cart7 = new JLabel(new ImageIcon("src/imagenes2/7.png"));
        ventana_info2.add(po_cart7);
        po_cart7.setBounds(120,300,100,120);
        po_cart7.setVisible(true);
        
        po_cart8 = new JLabel(new ImageIcon("src/imagenes2/8.png"));
        ventana_info2.add(po_cart8);
        po_cart8.setBounds(240,300,100,120);
        po_cart8.setVisible(true);
        
        po_cart9 = new JLabel(new ImageIcon("src/imagenes2/9.png"));
        ventana_info2.add(po_cart9);
        po_cart9.setBounds(360,300,100,120);
        po_cart9.setVisible(true);
        
        po_cart10 = new JLabel(new ImageIcon("src/imagenes2/10.png"));
        ventana_info2.add(po_cart10);
        po_cart10.setBounds(480,300,100,120);
        po_cart10.setVisible(true);
        /**/
        
        /**/
        nt_cart1 = new JLabel(new ImageIcon("src/imagenes3/1.png"));
        ventana_info3.add(nt_cart1);
        nt_cart1.setBounds(10,150,100,120);
        nt_cart1.setVisible(true);
        
        nt_cart2 = new JLabel(new ImageIcon("src/imagenes3/2.png"));
        ventana_info3.add(nt_cart2);
        nt_cart2.setBounds(120,150,100,120);
        nt_cart2.setVisible(true);
        
        nt_cart3 = new JLabel(new ImageIcon("src/imagenes3/3.png"));
        ventana_info3.add(nt_cart3);
        nt_cart3.setBounds(240,150,100,120);
        nt_cart3.setVisible(true);
        
        nt_cart4 = new JLabel(new ImageIcon("src/imagenes3/4.png"));
        ventana_info3.add(nt_cart4);
        nt_cart4.setBounds(360,150,100,120);
        nt_cart4.setVisible(true);
        
        nt_cart5 = new JLabel(new ImageIcon("src/imagenes3/5.png"));
        ventana_info3.add(nt_cart5);
        nt_cart5.setBounds(480,150,100,120);
        nt_cart5.setVisible(true);
        
        nt_cart6 = new JLabel(new ImageIcon("src/imagenes3/6.png"));
        ventana_info3.add(nt_cart6);
        nt_cart6.setBounds(10,300,100,120);
        nt_cart6.setVisible(true);
        
        nt_cart7 = new JLabel(new ImageIcon("src/imagenes3/7.png"));
        ventana_info3.add(nt_cart7);
        nt_cart7.setBounds(120,300,100,120);
        nt_cart7.setVisible(true);
        
        nt_cart8 = new JLabel(new ImageIcon("src/imagenes3/8.png"));
        ventana_info3.add(nt_cart8);
        nt_cart8.setBounds(240,300,100,120);
        nt_cart8.setVisible(true);
        
        nt_cart9 = new JLabel(new ImageIcon("src/imagenes3/9.png"));
        ventana_info3.add(nt_cart9);
        nt_cart9.setBounds(360,300,100,120);
        nt_cart9.setVisible(true);
        
        nt_cart10 = new JLabel(new ImageIcon("src/imagenes3/10.png"));
        ventana_info3.add(nt_cart10);
        nt_cart10.setBounds(480,300,100,120);
        nt_cart10.setVisible(true);
        /**/
        
        Thread principal = new Thread(new Runnable(){
           public void run(){
               
                try{
                    /* se define la ip local y el mismo puerto asignado al servidor */
                client = new Socket("127.0.0.1", 1200);       
                
                }catch(Exception ex){
                    System.out.println("Se dió la excepción");
            }    }
        });
        principal.start();  
        
        }
        
    public static void main(String [] args){
        /* clase cliente tiene al constructor new Cliente que está en Public Cliente y contiene a MakeInterface, makeinterface hace la interfaz, pone a trabajar los metodos y conecta el socket mediante un thread con ciclo infinito*/
        new Cliente();

    }    
    
}