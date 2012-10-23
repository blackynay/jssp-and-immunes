package aia_g_jssp;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.font.NumericShaper;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

//import sun.misc.Sort;

//import definitivo.Resultados;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.NumberFormatException;
import java.util.StringTokenizer;
import java.io.Reader;


public class VistaDefinitiva extends JFrame {


        private JFrame formulario;
        private JPanel norte,centro,contenedor,instancia;

        private JLabel lb_instancia,lb_parametro, lb_clonal, lb_grasp,lb_tam_pobla,lb_fac_mutac,lb_tas_clonac,lb_num_rand_cel, lb_umbral,lb_max_num_iter,lb_max_num_mej;
        private JTextField tf_tam_pobla,tf_fac_mutac,tf_tas_clonac,tf_num_rand_cel, tf_umbral,tf_max_num_iter,tf_max_num_mej ;
        private JTextArea fichero;
        private JButton b_ejecutar,b_borrar,b_salir;
        private JDialog dialogo;
        private JMenuBar menu;
        private JMenu menuArchivo;
        private JMenuItem elemento_Abrir, elemento_Salir;
        private JScrollPane sbrText;

        private String newline = "\n";
        private int mas,der;
        public JFileChooser filechooser;




        public VistaDefinitiva() {


                super("Formulario Basico");


                formulario = new JFrame();
                formulario.setSize(800,550);
                formulario.setVisible(true);
                contenedor = new JPanel();
                formulario.add(contenedor);
                formulario.setLocationRelativeTo(null);
                formulario.setLayout( new BorderLayout() );
                formulario.setResizable(false);


                //Crear Paneles
                norte = new JPanel();
                centro = new JPanel();
                instancia =new JPanel();

                //Ubicar Paneles
                formulario.add(norte, BorderLayout.NORTH );
                formulario.add(centro, BorderLayout.CENTER);

                norte.setVisible(true);
                norte.setLayout(new BorderLayout());
                centro.setVisible(true);
                centro.setLayout(null);

                //BARRA MENU
                menu = new JMenuBar();
                menuArchivo = new JMenu( "Archivo" );
                menuArchivo.setMnemonic('A');
                elemento_Abrir = new JMenuItem( "Abrir Instancias" );
                elemento_Abrir.setMnemonic('I');
                menuArchivo.add( elemento_Abrir );
                setJMenuBar(menu);
                menu.add(menuArchivo);
                norte.add(menu, BorderLayout.CENTER);


                //crear Label///
                lb_instancia = new JLabel("INSTANCIA");
                lb_parametro =new JLabel("PARAMETROS DE LOS ALGORITMOS");
                lb_tam_pobla = new JLabel("Tamaño de la Población");
                lb_fac_mutac = new JLabel("Factor de Mutación");
                lb_tas_clonac = new JLabel("Tasa de Clonación");
                lb_num_rand_cel = new JLabel("Número Randomico de Celulas");
                lb_umbral = new JLabel("Umbral alfa");
                lb_max_num_iter = new JLabel("Máximo Número de iteraciones");
                lb_max_num_mej = new JLabel("Máximo Número de No mejoramientos");
                lb_clonal = new JLabel("CLONAL");
                lb_grasp = new JLabel("GRASP");


                //crear campos de texto
                tf_tam_pobla = new JTextField("100",5);
                tf_fac_mutac = new JTextField("0.26",5);
                tf_tas_clonac = new JTextField("0.3",5);
                tf_num_rand_cel = new JTextField("10",5);
                tf_umbral = new JTextField("0.4",5);
                tf_max_num_iter= new JTextField("100",5);
                tf_max_num_mej= new JTextField("1900",5);

                //crear area de texto para cargar la instancia
                fichero = new JTextArea(21,31);

                sbrText = new JScrollPane(fichero);
                sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);



                //crear botones
                b_ejecutar= new JButton("Ejecutar");
                b_borrar = new JButton("Borrar Campos");
                b_salir = new JButton("Salir");

                //Factor de ordenamiento
                int mas = 10;
                int der = 430;
                int tam_camp = 80;

                //Posicionar Label
                lb_instancia.setBounds(195, 40, 200, 20);
                lb_parametro.setBounds(der+40, 40, 500, 20);
                lb_tam_pobla.setBounds(der, 100+mas, 200, 20);
                lb_fac_mutac.setBounds(der, 130+mas, 200, 20);
                lb_tas_clonac.setBounds(der, 160+mas, 200, 20);
                lb_num_rand_cel.setBounds(der, 190+mas, 200, 20);
                lb_umbral.setBounds(der, 330+mas, 200, 20);
                lb_max_num_iter.setBounds(der, 360+mas, 200, 20);
                lb_max_num_mej.setBounds(der, 390+mas, 200, 20);
                lb_clonal.setBounds(der, 70+mas, 300, 20);
                lb_grasp.setBounds(der, 300+mas, 300, 20);

                //Posicionar Campos de texto
                tf_tam_pobla.setBounds(der+220, 100+mas, tam_camp, 20);
                tf_fac_mutac.setBounds(der+220, 130+mas, tam_camp, 20);
                tf_tas_clonac.setBounds(der+220, 160+mas, tam_camp, 20);
                tf_num_rand_cel.setBounds(der+220, 190+mas, tam_camp, 20);
                tf_umbral.setBounds(der+220, 330+mas, tam_camp, 20);
                tf_max_num_iter.setBounds(der+220, 360+mas, tam_camp, 20);
                tf_max_num_mej.setBounds(der+220, 390+mas, tam_camp, 20);

                //Posicionar Botones
                b_borrar.setBounds(220, 450, 130, 30);
                b_ejecutar.setBounds(380, 450, 130, 30);
                b_salir.setBounds(610, 450, 130, 30);

                menu.setBounds(0, 0, 300, 50);

                //Posicionar TextArea y Panel del textArea

                instancia.setBounds(50,70,350,350);
                //                instancia.setBackground(Color.blue);


                //Agregar Label al formulario
                centro.add(lb_instancia);
                centro.add(lb_parametro);
                centro.add(lb_tam_pobla);
                centro.add(lb_fac_mutac);
                centro.add(lb_tas_clonac);
                centro.add(lb_num_rand_cel);
                centro.add(lb_umbral);
                centro.add(lb_max_num_iter);
                centro.add(lb_max_num_mej);
                centro.add(lb_clonal);
                centro.add(lb_grasp);

                //Agregar Campos de Texto al formulario
                centro.add(tf_tam_pobla);
                centro.add(tf_fac_mutac);
                centro.add(tf_tas_clonac);
                centro.add(tf_max_num_iter);
                centro.add(tf_max_num_mej);
                centro.add(tf_num_rand_cel);
                centro.add(tf_umbral);

                //Agregar TextArea

                instancia.add(sbrText);
                fichero.setVisible(true);
                fichero.setEditable(false);


                //Agregar Botones al formulario
                centro.add(b_ejecutar);
                centro.add(b_borrar);
                centro.add(b_salir);

                //Agregar Panel de la instacia
                centro.add(instancia);


                //Clic Abrir Instancia
                elemento_Abrir.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                try {
                                	filechooser=nombreArchivo();
                                	System.out.println(filechooser.getCurrentDirectory());
                                	PruebaGrasp pruebagrasp =new PruebaGrasp();
                                	//pruebagrasp.ejecutar_Grasp(filechooser.getCurrentDirectory());
                                	filechooser.
                                	String name=filechooser.getName();
                                	
									int matriz[][]= abrirArchivo(name);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								

                                // TODO Auto-generated method stub
                        }
                });


                //Boton Salir
                b_salir.addActionListener(
                                new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                // TODO Auto-generated method stub

                                                formulario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                                                System.exit(0);
                                                //      formulario.EXIT_ON_CLOSE
                                        }
                                });

                //Boton Borrar Campos
                b_borrar.addActionListener(
                                new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent a) {
                                                // TODO Auto-generated method stub
                                                borrarCampos();
                                        }
                                } );


                //Boton Ejecutar
                b_ejecutar.addActionListener(                        
                                new ActionListener() { // clase interna anÃ³nima

                                        public void actionPerformed( ActionEvent evento )
                                        {
                                                String accion = evento.getActionCommand();


                                                int tam_pobla,tam_proble,num_rand_cel;
                                                double tas_clonal=0.0;
                                                double umbral=0.0;
                                                double tam_selec=0.0;
                                                double fac_mutac=0.0;

                                                if(fichero.getText().equals("")){
                                                        //                         System.out.print("Seleccione una instancia");
                                                        JOptionPane.showMessageDialog(fichero, "Seleccione la Instancia");
                                                }
                                                else{
                                                        try{
                                                                tam_pobla = Integer.parseInt(tf_tam_pobla.getText());
                                                                try{
                                                                        fac_mutac = Double.parseDouble(tf_fac_mutac.getText());
                                                                        try{
                                                                                tas_clonal = Double.parseDouble(tf_tas_clonac.getText());                                  
                                                                                try{  
                                                                                        tam_proble = Integer.parseInt(tf_max_num_mej.getText());
                                                                                        try{
                                                                                                tam_selec = Integer.parseInt(tf_max_num_iter.getText());          
                                                                                                try{
                                                                                                        num_rand_cel = Integer.parseInt(tf_num_rand_cel.getText());
                                                                                                        try{
                                                                                                                umbral = Double.parseDouble(tf_umbral.getText());

                                                                                                                new Resultados();
                                                                                                                
                                                                                                                //                                                        formulario.setVisible(false);
                                                                                                                //                                                        dispose();

                                                                                                        } catch(NumberFormatException nfe)
                                                                                                        { JOptionPane.showMessageDialog(tf_umbral,"Verifique que el campo Umbral no se encuentre vacio. \n \n El campo solo admite valores enteros \n o decimales separados por punto (1.3)");
                                                                                                        }    
                                                                                                } catch(NumberFormatException nfe)
                                                                                                { JOptionPane.showMessageDialog(tf_num_rand_cel,"Verifique que el campo Numero Randomico de Celulas no se encuentre vacÃ­o. \n \n El campo solo admite valores enteros");
                                                                                                }    
                                                                                        }catch(NumberFormatException nfe)
                                                                                        {JOptionPane.showMessageDialog(tf_max_num_mej,"Verifique que el campo Max número de mejoramientos no se encuentre vacio. \n \n El campo solo admite valores enteros");
                                                                                        }
                                                                                }catch(NumberFormatException nfe)
                                                                                {JOptionPane.showMessageDialog(tf_max_num_iter,"Verifique que el campo Máximo número de iteraciones no se encuentre vacio. \n \n El campo solo admite valores enteros");
                                                                                }                                                  
                                                                        } catch(NumberFormatException nfe)
                                                                        {JOptionPane.showMessageDialog(tf_tas_clonac,"Verifique que el campo Tasa de Clonacion no se encuentre vacio. \n \n El campo solo admite valores enteros \n o decimales separados por punto (1.3)");
                                                                        }            
                                                                }catch(NumberFormatException nfe)
                                                                { JOptionPane.showMessageDialog(tf_fac_mutac,"Verifique que el campo Factor de Mutacion no se encuentre vacio. \n \n El campo solo admite valores enteros \n o decimales separados por punto (1.3)");
                                                                }
                                                        }  catch(NumberFormatException nfe)
                                                        {JOptionPane.showMessageDialog(tf_tam_pobla,"Verifique que el campo TamaÃ±o de la Poblacion no se encuentre vacio. \n \n El campo solo admite valores enteros");
                                                        }
                                                }
                                                
                                                /*




                                                 */
                                        } // fin ActionPerformed

                                } // fin ActionListener
                                

                                );//Fin Boton Ejecutar


                //Ventana DIALOGO de Validacion
                JButton ok = new JButton("OK");
                JLabel advertencia = new JLabel("Verifique que todos los campos contengan solo numeros");
                dialogo = new JDialog();
                dialogo.setTitle("Error");
                dialogo.setLayout(new FlowLayout());
                dialogo.setSize(400, 90);
                dialogo.setLocationRelativeTo(this.contenedor);
                dialogo.add(advertencia);
                //ok.setResizable(false);
                dialogo.setResizable(false);
                dialogo.add(ok);
                dialogo.setModal(true);  

                ok.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                                //dialogo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                                //System.exit(0);
                                dialogo.dispose();
                                //      
                        }
                });
                //Fin Ventana de Dialogo

        }
        //Fin de la Funcion VistaDefinitiva

        //Funcion Borrar Campos
        public void borrarCampos(){

                tf_tam_pobla.setText("");
                tf_fac_mutac.setText("");
                tf_tas_clonac.setText("");
                tf_max_num_mej.setText("");
                tf_max_num_iter.setText("");
                tf_num_rand_cel.setText("");
                tf_umbral.setText("");
        }


public JFileChooser nombreArchivo() throws IOException {
	
	boolean valido = false;
    
    // mostrar cuadro de diÃ¡logo para que el usuario pueda seleccionar el archivo
    JFileChooser selectorArchivo = new JFileChooser();
    selectorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );

    int resultado = selectorArchivo.showOpenDialog( this );

    // si el usuario hizo clic en el botÃ³n Cancelar del cuadro de dialogo, regresar
    if ( resultado == JFileChooser.CANCEL_OPTION ){
            valido = false;
    }
    else{
            // obtener el archivo seleccionado
            File archivo = null;
            archivo = selectorArchivo.getSelectedFile();
            
            
            //Leer nombre archivo*********************
           // String nombre_archivo;
                     
            //nombre_archivo = archivo.getName();
            //selectorArchivo.getCurrentDirectory();
            //nombre2 = nombre_archivo.replaceAll(".txt", "");
    }
   
	return selectorArchivo;

}

        //Funcion Abrir Archivo
        public int[][] abrirArchivo(String n) throws IOException
        {
                boolean valido = false;
                int prueba[][] = new int[0][0];
                // obtener el archivo seleccionado
                File archivo = new File("C:\\archivos nelson\\Instancia\\"+ n +".txt ");
                
                FileReader fr = null;

                try {
                        fr = new FileReader(archivo);
                } catch (FileNotFoundException e) {
                      
                        e.printStackTrace();
                }          
                BufferedReader br = new BufferedReader(fr);
              
                prueba = Convertir(br);
             
                for(int i=0;i<10;i++)
                {
                	for(int j=0;j<10;j++)
                	{
                System.out.print(prueba[i][j]+" ");
                }
                	System.out.println();
                	}

                //         Reader linea1;
                valido = true;
        
        if(valido){
                return prueba;
        }
        else{
                return null;
        }
                
        }

       
		private int [][] Convertir(BufferedReader br){
            try {
                
                fichero.setText(" ");
                String strLine;
                // Read File Line By Line

                Object datos1[] = new Object[2];
                datos1[0] = 0;
                datos1[1] = 0;
                int c = 0;

                strLine = br.readLine();
                StringTokenizer str1 = new StringTokenizer(strLine);

                while (str1.hasMoreElements()) {
                    datos1[c] = str1.nextElement();
                    c = c + 1;
                }

                int J = Integer.parseInt((String) datos1[0]);
                int M = Integer.parseInt((String) datos1[1]);

                
                Object datos[][] = new Object[J][M * 2];

                int j = 0;
                int i = 0;

                while ((strLine = br.readLine()) != null) {

                    StringTokenizer str = new StringTokenizer(strLine);
                    while (str.hasMoreElements()) {
                        datos[j][i] = str.nextElement();
                        i = i + 1;
                    }
                    j = j + 1;
                    i = 0;
                }

                // System.out.println(datos[c]);

                int vector[][] = new int[J][M * 2];
                for (int j1 = 0; j1 < J; j1++) {
                    for (int i1 = 0; i1 < M * 2; i1++) {
                        vector[j1][i1] = Integer.parseInt((String) datos[j1][i1]);
                         //System.out.println(vector[j1][i1]);
                        fichero.append(vector[j1][i1]+" ");
                    }
                    fichero.append(newline);
                }

                // Close the input stream
                //in.close();
                return vector;
            } catch (Exception e) {// Catch exception if any
                System.err.println("Error: " + e.getMessage());

            }
            return null;
        }
       
        public int[] Tamano_inst(BufferedReader br) {

            try {
                // Open the file that is the first
                // command line parameter
                // FileInputStream fstream = new

                String strLine;
                // Read File Line By Line

                Object datos1[] = new Object[2];
                datos1[0] = 0;
                datos1[1] = 0;
                int c = 0;

                strLine = br.readLine();
                StringTokenizer str1 = new StringTokenizer(strLine);

                while (str1.hasMoreElements()) {
                    datos1[c] = str1.nextElement();
                    c = c + 1;
                }

                int J = Integer.parseInt((String) datos1[0]);
                int M = Integer.parseInt((String) datos1[1]);
                int[] tama = new int[2];
                tama[0] = J;
                tama[1] = M;

                // Close the input stream
                //in.close();
                return tama;
            } catch (Exception e) {// Catch exception if any
                System.err.println("Error: " + e.getMessage());

            }
            return null;
        }
       
        public int [] crearVector(int [][]matriz,int t1,int t2)
        {
                int [] vector=new int [1+(t1*t2)];
                int k=0;
                for(int i=1;i<2*t2;i+=2)
                {
                        for(int j=0;j<t1;j++){
                                k=k+1;
                                vector[k]=matriz[j][i];
                                System.out.println(vector[k]);
                        }
                }

                return vector;
        }
        
        //***************************************************************************************
       

}