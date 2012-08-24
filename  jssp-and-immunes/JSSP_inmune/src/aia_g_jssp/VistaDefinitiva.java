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

import sun.misc.Sort;

//import definitivo.Resultados;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.io.Reader;


public class VistaDefinitiva extends JFrame {
                private JFrame formulario;
                private JPanel norte,centro,contenedor;
                
            private JLabel lb_instancia,lb_parametro, lb_clonal, lb_grasp,lb_tam_pobla,lb_fac_mutac,lb_tas_clonac,lb_tam_proble,lb_tam_seccio,lb_num_rand_cel, lb_umbral;
                private JTextField tf_tam_pobla,tf_fac_mutac,tf_tas_clonac,tf_tam_proble,tf_tam_selec,tf_num_rand_cel, tf_umbral;
                private JTextArea fichero;
                private JButton b_ejecutar,b_borrar,b_salir;
                private JDialog dialogo;
                private JMenuBar menu;
                private JMenu menuArchivo;
                private JMenuItem elemento_Abrir, elemento_Salir;
                
                private String newline = "\n";
                private int mas,der, tam_cam;
                
                
                
        
        
        public VistaDefinitiva() {
                
                super("Formulario Básico");
                
                
                formulario = new JFrame();
                formulario.setSize(800,550);
                formulario.setVisible(true);
                contenedor = new JPanel();
                formulario.add(contenedor);
                formulario.setLayout( new BorderLayout() );
                
                //Crear Paneles
                norte = new JPanel();
                centro = new JPanel();
                
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
                lb_tam_proble = new JLabel("Tamaño del Problema");
                lb_tam_seccio = new JLabel("Tamaño de la Selección");
                lb_num_rand_cel = new JLabel("Número Randomico de Células");
                lb_umbral = new JLabel("Umbral alfa");
                lb_clonal = new JLabel("CLONAL");
                lb_grasp = new JLabel("GRASP");
                
                
                //crear campos de texto
                tf_tam_pobla = new JTextField("100",5);
                tf_fac_mutac = new JTextField("-2.5",5);
                tf_tas_clonac = new JTextField("0.1",5);
                tf_tam_proble = new JTextField("2",5);
                tf_tam_selec = new JTextField("0.1",5);
                tf_num_rand_cel = new JTextField("2",5);
                tf_umbral = new JTextField("0.5",5);
                
                //crear área de texto para cargar la instancia
                fichero = new JTextArea( 100, 100);
                
               
                
                
                //crear botones
                b_ejecutar= new JButton("Ejecutar");
                b_borrar = new JButton("Borrar Campos");
                b_salir = new JButton("Salir");
                
                //Factor de ordenamiento
                int mas = 10;
                int der = 450;
                int tam_camp = 80;
                
                //Posicionar Label
                lb_instancia.setBounds(195, 40, 200, 20);
                lb_parametro.setBounds(der+40, 40, 500, 20);
                lb_tam_pobla.setBounds(der, 100+mas, 200, 20);
                lb_fac_mutac.setBounds(der, 130+mas, 200, 20);
                lb_tas_clonac.setBounds(der, 160+mas, 200, 20);
                lb_tam_proble.setBounds(der, 190+mas, 200, 20);
                lb_tam_seccio.setBounds(der, 220+mas, 200, 20);
                lb_num_rand_cel.setBounds(der, 250+mas, 200, 20); 
                lb_umbral.setBounds(der, 330+mas, 200, 20);
                lb_clonal.setBounds(der, 70+mas, 300, 20); 
                lb_grasp.setBounds(der, 300+mas, 300, 20); 
                                          
                //Posicionar Campos de texto
                tf_tam_pobla.setBounds(der+200, 100+mas, tam_camp, 20);
                tf_fac_mutac.setBounds(der+200, 130+mas, tam_camp, 20);
                tf_tas_clonac.setBounds(der+200, 160+mas, tam_camp, 20);
                tf_tam_proble.setBounds(der+200, 190+mas, tam_camp, 20);
                tf_tam_selec.setBounds(der+200, 220+mas, tam_camp, 20);
                tf_num_rand_cel.setBounds(der+200, 250+mas, tam_camp, 20);
                tf_umbral.setBounds(der+200, 330+mas, tam_camp, 20);
                      
                //Posicionar Botones
                b_borrar.setBounds(220, 450, 130, 30);
                b_ejecutar.setBounds(380, 450, 130, 30);
                b_salir.setBounds(610, 450, 130, 30);
                
                menu.setBounds(0, 0, 300, 50);
                
                //Posicionar TextArea
                fichero.setBounds(50,70,350,350);
                
                //Agregar Label al formulario
                centro.add(lb_instancia);
                centro.add(lb_parametro);
                centro.add(lb_tam_pobla);
                centro.add(lb_fac_mutac);
                centro.add(lb_tas_clonac);
                centro.add(lb_tam_proble);
                centro.add(lb_tam_seccio);
                centro.add(lb_num_rand_cel);
                centro.add(lb_umbral);
                centro.add(lb_clonal);
                centro.add(lb_grasp);
                               
                //Agregar Campos de Texto al formulario
                centro.add(tf_tam_pobla);
                centro.add(tf_fac_mutac);
                centro.add(tf_tas_clonac);
                centro.add(tf_tam_proble);
                centro.add(tf_tam_selec);
                centro.add(tf_num_rand_cel);
                centro.add(tf_umbral);
                
                //Agregar TextArea
                centro.add(fichero);
                fichero.setVisible(true);
                fichero.setEditable(false);
              
                
                //Agregar Botones al formulario
                centro.add(b_ejecutar);
                centro.add(b_borrar);
                centro.add(b_salir);
                        
               
                //Clic Abrir Instancia
                elemento_Abrir.addActionListener(new ActionListener() {
                                                                                @Override
                                        public void actionPerformed(ActionEvent e) {
                                                int matriz[][]=abrirArchivo();
                                              
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
                        new ActionListener() { // clase interna anónima
                           
                           public void actionPerformed( ActionEvent evento )
                           {
                              String accion = evento.getActionCommand();
                              
                             
                            int tam_pobla,tam_proble,num_rand_cel;
                            double tas_clonal=0.0;
                            double umbral=0.0;
                            double tam_selec=0.0;
                            double fac_mutac=0.0;
                                        
                                      
                           try{ 
                                   tam_pobla = Integer.parseInt(tf_tam_pobla.getText());
                                try{
                                   fac_mutac = Double.parseDouble(tf_fac_mutac.getText());
                                  try{
                                   tas_clonal = Double.parseDouble(tf_tas_clonac.getText());                                   
                                        try{  
                                                tam_proble = Integer.parseInt(tf_tam_proble.getText());
                                         try{
                                                tam_selec = Double.parseDouble(tf_tam_selec.getText());           
                                                try{
                                                   num_rand_cel = Integer.parseInt(tf_num_rand_cel.getText());
                                                  try{
                                                        umbral = Double.parseDouble(tf_umbral.getText()); 
                                                        new Resultados();
                                                        formulario.setVisible(false);     
                                                        } catch(NumberFormatException nfe)
                                                        { JOptionPane.showMessageDialog(tf_umbral,"Verifique que el campo Umbral no se encuentre vacío. \n \n El campo solo admite valores enteros \n o decimales separados por punto (1.3)");
                                                        }    
                                                        } catch(NumberFormatException nfe)
                                                        { JOptionPane.showMessageDialog(tf_num_rand_cel,"Verifique que el campo Número Ranomíco de Células no se encuentre vacío. \n \n El campo solo admite valores enteros");
                                                 }    
                                                        }catch(NumberFormatException nfe)
                                                                {JOptionPane.showMessageDialog(tf_tam_selec,"Verifique que el campo Tamaño de la Selección no se encuentre vacío. \n \n El campo solo admite valores enteros \n o decimales separados por punto (1.3)");
                                                                }
                                                }catch(NumberFormatException nfe)
                                                        {JOptionPane.showMessageDialog(tf_tam_proble,"Verifique que el campo Tamaño del Problema no se encuentre vacío. \n \n El campo solo admite valores enteros");
                                                        }                                                  
                                       } catch(NumberFormatException nfe)
                                          {JOptionPane.showMessageDialog(tf_tas_clonac,"Verifique que el campo Tasa de Clonación no se encuentre vacío. \n \n El campo solo admite valores enteros \n o decimales separados por punto (1.3)");
                                           }            
                                     }catch(NumberFormatException nfe)
                                            { JOptionPane.showMessageDialog(tf_fac_mutac,"Verifique que el campo Factor de Mutación no se encuentre vacío. \n \n El campo solo admite valores enteros \n o decimales separados por punto (1.3)");
                                                }
                                }  catch(NumberFormatException nfe)
                                       {JOptionPane.showMessageDialog(tf_tam_pobla,"Verifique que el campo Tamaño de la Población no se encuentre vacío. \n \n El campo solo admite valores enteros");
                                        }
                           /*
                           
                          
                          
                           
                          */
                           } // fin ActionPerformed
                           
                        } // fin ActionListener
                     
                     );//Fin Boton Ejecutar
                
                
                //Ventana DIALOGO de Validación
                JButton ok = new JButton("OK");
                        JLabel advertencia = new JLabel("Verifique que todos los campos contengan solo números");
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
                tf_tam_proble.setText("");
                tf_tam_selec.setText("");
                tf_num_rand_cel.setText("");
                tf_umbral.setText("");
        }
        
        
        //Funcion Abrir Archivo
        protected int[][] abrirArchivo()
        {
                boolean valido = false;
                int prueba[][] = new int[0][0];
           // mostrar cuadro de diálogo para que el usuario pueda seleccionar el archivo
           JFileChooser selectorArchivo = new JFileChooser();
           selectorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );

           int resultado = selectorArchivo.showOpenDialog( this );

           // si el usuario hizo clic en el botón Cancelar del cuadro de diálogo, regresar
           if ( resultado == JFileChooser.CANCEL_OPTION ){
                   valido = false;
           }
           else{
                   // obtener el archivo seleccionado
                   File archivo = null;
                   archivo = selectorArchivo.getSelectedFile(); 
                  
                  
                  FileReader fr = null;
               
                        try {
                                fr = new FileReader(archivo);
                        } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }           
                   BufferedReader br = new BufferedReader(fr);
                   prueba=Convertir(br);
                   
        //         Reader linea1; 
                   valido = true;
           }
           if(valido){
                   return prueba;
           }
           else{
                   return null;
           }
            
        }
        //Fin Funcion Abrir Archivo
        
       private int [][] Convertir(BufferedReader br){
           String linea=null;
           try {
               
               String primeraLinea = br.readLine();
               String[] temp = primeraLinea.split(" ");
               System.out.println("temporal 1 "+temp[1]); //dato uno
               System.out.println("temporal 2 "+temp[2]); // dato dos
               int t1=Integer.parseInt(temp[1]);
               int t2=Integer.parseInt(temp[2]);
               String instancia[][] = new String[Integer.valueOf(temp[1])][(Integer.valueOf(temp[2])*2)];
               String fila = " ";
               int prueba[][]=new int[Integer.parseInt(temp[1])][(Integer.parseInt(temp[2])*2)];
               int a= 0;
               while ((linea = br.readLine())!= null)
                       {
                                fila = linea;
                                String[] dato = fila.split(" ");
                                for (int i=0; i < dato.length  ; i++){
                                      instancia[a][i] = dato[i];
                                      prueba[a][i]= Integer.parseInt(instancia[a][i]); 
                                      fichero.append(instancia [a][i]+" ");
                                      System.out.print(prueba[a][i]+" ");
                                        }
                                fichero.append(newline);
                                System.out.println();
                                a=a+1;
                       }   
               int []vector= crearVector(prueba,t1,t2);
               return prueba;
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
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
}
