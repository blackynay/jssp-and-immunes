package definitivo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.category.IntervalCategoryDataset;

public class Resultados extends JFrame{
	private JFrame formulario2;
	private JPanel panel1,panel2,panel3, panel4, cont1, cont2, cont3, cont4;
	private JTabbedPane contenedor;
	private JButton b_salir1,b_salir2,b_salir3,b_salir4, b_regresar1, b_regresar2, b_regresar3, b_regresar4;
	
	
	 
	 public void resultados(){
		 formulario2 = new JFrame("Job Shop Scheduling");
			formulario2.setSize(900,550);
		    formulario2.setLocationRelativeTo(null);
		    formulario2.setLayout( new BorderLayout() );
		    formulario2.add(contenedor);//anade el metodo que construye el paneltab
	        formulario2.setVisible(true);
	        formulario2.setResizable(false);
	        
	  }
	 
	 
	 public void paneles(){
			//contenedor *********************************
			contenedor = new JTabbedPane();
			
			//paneles*************************************
			panel1 = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			panel4 = new JPanel();
			cont1 = new JPanel();
			cont2 = new JPanel();
			cont3 = new JPanel();
			cont4 = new JPanel();
			
			//Botones *************************************
			b_salir1 = new JButton("Salir");
			b_salir2 = new JButton("Salir");
			b_salir3 = new JButton("Salir");
			b_salir4 = new JButton("Salir");
			b_regresar1 = new JButton("Regresar");
			b_regresar2 = new JButton("Regresar");
			b_regresar3 = new JButton("Regresar");
			b_regresar4 = new JButton("Regresar");
			
			//Añadir Paneles *******************************
			contenedor.add(panel1,"Calendario No Optimizado");
			contenedor.add(panel2,"Calendario ClonalG");
			contenedor.add(panel3,"Calendario GRASP");
			contenedor.add(panel4,"Tabla de Resultados");
			
			//Panel 1***************************************
			panel1.setLayout(new BorderLayout());
			panel1.add(cont1, BorderLayout.CENTER);
			cont1.setBackground(Color.blue);
			cont1.setLayout(null);
			
	        cont1.add(b_salir1);
	        cont1.add(b_regresar1);
			b_salir1.setBounds(800, 450, 70, 30);
			b_salir1.setVisible(true);
			b_regresar1.setBounds(700, 450, 90, 30);
	        b_regresar1.setVisible(true);
	        
	        //Panel 2***************************************
	        panel2.setLayout(new BorderLayout());
			panel2.add(cont2, BorderLayout.CENTER);
			cont2.setBackground(Color.blue);
			cont2.setLayout(null);
			
	        cont2.add(b_salir2);
	        cont2.add(b_regresar2);
			b_salir2.setBounds(800, 450, 70, 30);
	        b_salir2.setVisible(true);
	        b_regresar2.setBounds(700, 450, 90, 30);
	        b_regresar2.setVisible(true);
	        
	        //Panel 3***************************************
	        panel3.setLayout(new BorderLayout());
			panel3.add(cont3, BorderLayout.CENTER);
			cont3.setBackground(Color.blue);
			cont3.setLayout(null);
			
	        cont3.add(b_salir3);
	        cont3.add(b_regresar3);
			b_salir3.setBounds(800, 450, 70, 30);
	        b_salir3.setVisible(true);
	        b_regresar3.setBounds(700, 450, 90, 30);
	        b_regresar3.setVisible(true);
	        
	        //Panel 4***************************************
	        panel4.setLayout(new BorderLayout());
			panel4.add(cont4, BorderLayout.CENTER);
			cont4.setBackground(Color.blue);
			cont4.setLayout(null);
			
			cont4.add(b_salir4);
			cont4.add(b_regresar4);
			b_salir4.setBounds(800, 450, 70, 30);
	        b_salir4.setVisible(true);
	        b_regresar4.setBounds(700, 450, 90, 30);
	        b_regresar4.setVisible(true);
	    
	       
	        //Cerrar Formulario 2 ************************************
	        b_salir1.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				salir();
    		}});
	        
	        b_salir2.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				salir();
    		}});
	        
	        b_salir3.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				salir();
    		}});
	        
	        b_salir4.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				salir();
    		}});
	      			
	        //**********************************************************
	
	        //Regresar *************************************************
	        b_regresar1.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				regresar();
    		}});
	        b_regresar2.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				regresar();
    		}});
	        b_regresar3.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				regresar();
    		}});
	        b_regresar4.addActionListener(new ActionListener() {@Override
    			public void actionPerformed(ActionEvent e) {    				
    				regresar();
    		}});
	        //***********************************************************
	 }
	 
	 
	 public void salir(){
		 formulario2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			System.exit(0);		 
	 }
	 
	 public void regresar(){
		 formulario2.setVisible(false);
	 }
	 
	 
	 public Resultados(){  
			
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
				;
				}
				catch(Exception e) {
				e.printStackTrace();
				}
			
			paneles();
			resultados();
	  }

}
