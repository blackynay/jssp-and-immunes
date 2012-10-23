package aia_g_jssp;
import java.io.*;



import java.util.StringTokenizer;


public class Formato{
	
	public void formato(int [] tamano, int [][] matriz, int [][][] calen) throws IOException{
		
		System.out.print("entreeee");
		
		
		
	String nombre2= "la26";

	
	//::::::::::::::::::::::::::::::::::
	File f =new File("C:\\archivos nelson\\archivos lekin\\"+nombre2+".seq");
	f.delete();

	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), "UTF8"));

	out.write("Schedule:           General SB Routine / Cmax");
	out.write("\n");
	out.write("  RGB:                233;225;186");
	out.write("\n");
	out.write("  Time:               1");
	out.write("\n");
	for(int i=0; i<tamano[1];i++)
	{
		out.write("   Machine:            M"+i);
		out.write("\n");	
		for(int j=0; j<tamano[0];j++)
		{
			out.write("    Oper:               J"+calen[i][j][2]);
//			System.out.print(calen[i][j][2]);
					
			out.write("\n");
		}
	}
	out.close();
	

    //::::::::::::::::::::::::::::::::::::
	
	
	File f2 =new File("C:\\archivos nelson\\archivos lekin\\"+nombre2+".mch");
	
	f2.delete();
	
	

	BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2, true), "UTF8"));

	out2.write("Ordinary:");
	out2.write("\n");

	for(int i=0; i<tamano[1];i++)
	{
		out2.write("Workcenter:         M"+i);
		out2.write("\n");	
		out2.write("  RGB:                3;3;3");
		out2.write("\n");
		out2.write("  Release:            0");
		out2.write("\n");
		out2.write("  Status:             A");
		out2.write("\n");
		
	}
	out2.close();
	//::::::::::::::::::::::::::::::::::
	
	FileInputStream fstream = new FileInputStream("C:\\archivos nelson\\proyecto inmune\\JSSP_inmune\\src\\aia_g_jssp\\color.txt");
	DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    Object datos1[] = new Object[30];
    int c = 0;
    
    

    while ((strLine = br.readLine()) != null) {
    
    StringTokenizer str1 = new StringTokenizer(strLine);

    while (str1.hasMoreElements()) {
        datos1[c] = str1.nextElement();
        c = c + 1;
    }
   }
//    System.out.print(datos1[29]);
    String[] tama = new String[2];
       
    
	
	//:::::::::::::::::::::::::::::::::::
	
	File f3 =new File("C:\\archivos nelson\\archivos lekin\\"+nombre2+".job");
	f3.delete();

	BufferedWriter out3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f3, true), "UTF8"));

	out3.write("Shop:               Job");
	out3.write("\n");
	
		for(int j=0; j<tamano[0];j++)
		{
			out3.write("Job:                J"+j);
			out3.write("\n");
			out3.write("  RGB:                "+datos1[j]);
			out3.write("\n");
			out3.write("  Release:            0");
			out3.write("\n");
			out3.write("  Due:                4");
			out3.write("\n");
			out3.write("  Weight:             14");
			out3.write("\n");
			for(int k=0; k < ( tamano[1]*2);k=k+2){
			out3.write("  Oper:               M"+matriz[j][k]+";"+matriz[j][k+1]+";A");
			out3.write("\n");
			}
			out3.write("\n");
			
			
		}
	
	out3.close();
	//:::::::::::::::::::::::::
		
	
	
	
	}
		public static void main(String[] args) throws IOException{
			
			  Formato format = new Formato();
			  Leer_archivo instancia = new Leer_archivo();
			  int [][]matriz = instancia.Leer_instancia();
			  int [] tamano = instancia.Tamano_inst();
			  
			  Clonalg calendario =new Clonalg();
//			  int[] trabajos={0,1,3,2,2,1,3,0,0,1,3,2};
//			  int[] trabajos={3,8,6,9,4,1,5,7,3,4,2,0,6,8,5,1,9,2,7,0,3,4,1,7,8,6,5,9,2,0,7,1,3,9,8,6,5,4,0,2,1,8,3,7,6,9,5,4,2,0}; //la01-la05
			 /* int[] trabajos={3,10,13,8,14,6,9,11,4,1,13,5,10,7,3,4,12,2,0,13,6,11,8,5,1,9,2,10,7,0,14,12,3,4,1,13,11,7,8,6,14,5,12,
			  9,2,0,10,7,1,3,11,9,12,8,13,6,5,14,4,0,2,1,8,3,11,10,7,12,6,9,5,4,14,2,0};//la06-la10
			  */
			 /* int[] trabajos={12,16,15,8,9,7,6,3,18,14,11,17,4,13,12,16,15,8,9,7,6,3,18,14,11,17,4,13,
                      0,19,10,2,1,5,0,19,10,2,1,5,12,12,16,15,8,9,7,6,3,18,12,16,15,8,9,7,6,3,18,14,11,17,4,13,
                      0,19,10,2,1,5,14,11,17,4,13,0,19,10,2,1,5,16,15,8,9,7,6,3,18,14,11,17,4,13,0,19,10,2,1,5};//la11-la15*/
			  /*int[] trabajos={3,8,6,9,4,1,5,7,3,4,2,0,6,8,5,1,9,2,7,0,3,4,1,7,8,6,5,9,2,0,7,1,3,9,8,6,5,4,
                      0,2,1,8,3,7,6,9,5,4,2,0,3,8,6,9,4,1,5,7,3,4,2,0,6,8,5,1,9,2,7,0,3,4,1,7,8,6,5,9,2,0,7,1,3,9,8,6,
                     5,4,0,2,1,8,3,7,6,9,5,4,2,0};//la16-la20
			 */
			 /* int[] trabajos={0,1,2,3,4,5,0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7,8,9,10,11,12,0,1,2,3,4,5,6,
      				7,8,9,10,11,12,13,14,13,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,14,0,1,2,3,4,
      				5,6,7,8,9,10,11,12,13,14,0,1,2,3,4,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,5,
      				0,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,1,2,3,4,5,6,7,8,9,10,11,12,13,14,6,
      				7,8,9,10,11,12,13,14,8,9,10,11,12,13,14,6,7,8,9,10,11,12,13,14,}; // instancias la21-la25
			  */
			  int[] trabajos={0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,0,1,2,3,4,5,6,7,8,9,10,
					  11,12,13,14,15,16,17,18,19,5,6,7,8,9,10,11,12,
					  0,1,2,3,4,5,6,7,8,9,10,0,1,2,3,4,5,6,7,8,9,10,11,
					  12,13,14,15,16,17,18,19,11,12,0,1,2,3,4,5,6,7,8,9,10,
					  11,12,13,14,15,16,17,18,19,13,14,15,16,17,18,19,
					  13,14,15,16,17,18,19,10,11,12,13,14,15,16,17,18,19,
					  0,1,2,3,4,5,6,7,8,9,10,11,0,1,2,3,4,5,6,7,8,9,10,11,
					  12,13,14,15,16,17,18,19,12,13,14,15,16,17,18,19,
					  0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,0,1,2,3,
					  4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,17,18,19,};//instancia la26-la30
			  
			  int[][][] calen = calendario.veriRestric(trabajos, matriz, tamano[0], tamano[1]);
			  
			  format.formato(tamano,matriz,calen);
		}
}	

