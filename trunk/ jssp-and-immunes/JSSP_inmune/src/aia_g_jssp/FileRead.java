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
  FileInputStream fstream = new FileInputStream("C:\\archivos nelson\\proyecto inmune\\JSSP_inmune\\src\\aia_g_jssp\\la12.txt");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line
  Object datos[]=new Object[500];
  
  int c=0;
  
  while ((strLine = br.readLine()) != null)   {
	  StringTokenizer str=new  StringTokenizer(strLine);
	  while(str.hasMoreElements()){
		  datos[c]=str.nextElement();
		  c=c+1;
		  }
		  
  		}
	  
  //System.out.println(datos[c]);
  
  int vector[]=new int [c];
  for (int i=0;i<c;i++){
	  vector[i]=Integer.parseInt((String)datos[i] );
	  System.out.println(vector[i]);
  }
  //Close the input stream
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
  }
}

