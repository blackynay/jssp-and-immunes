package definitivo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Resultados extends JFrame{
	private JFrame formulario2;
	private JPanel panel1,panel2;
	private JTabbedPane contenedor;
	private JButton b_salir;
	
	
	 
	 public void resultados(){
		 
		 formulario2 = new JFrame("Job Shop Scheduling");
			formulario2.setLayout(new BoxLayout(formulario2.getContentPane(), BoxLayout.Y_AXIS) );
			formulario2.setUndecorated(true);
			formulario2.setSize(900,500);
		    formulario2.setLocationRelativeTo(null);
		    formulario2.add(contenedor);//anade el metodo que construye el paneltab
		    formulario2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        formulario2.setVisible(true);
	        
	        b_salir = new JButton();
	        panel1.add(b_salir);
	        b_salir.setVisible(true);
	        b_salir.setBounds(100, 1000, 100, 30);
	        
	        b_salir.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				
    				formulario2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    				System.exit(0);
    			 		
    			}
    		});
	        
	        
	 }
	 
	 public void paneles(){
			//contenedor
			contenedor = new JTabbedPane();
			//paneles
			panel1 = new JPanel();
			panel2 = new JPanel();
			contenedor.add(panel1,"Calendario");
			contenedor.add(panel2,"Tabla de Resultados");
						
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
