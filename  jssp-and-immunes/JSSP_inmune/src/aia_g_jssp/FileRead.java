package aia_g_jssp;
import java.io.*;
import java.util.StringTokenizer;

class FileRead 
{
 public static void main(String args[])
  {
  try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream("C:\\archivos nelson\\proyecto inmune\\JSSP_inmune\\src\\aia_g_jssp\\la01.txt");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line
  Object datos[]=new String[500];
  
  int c=0;

  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console

	  StringTokenizer str=new  StringTokenizer(strLine);
	  while(str.hasMoreElements()){
		  c=c+1;
		  datos[c]=str.nextElement();
		  System.out.println (datos[c]);
		  System.out.println ();
	  }
	  datos[c]=Integer.parseInt(strLine);
	  //System.out.println ("Datos ");
  
  }
  //Close the input stream
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
  }
}

