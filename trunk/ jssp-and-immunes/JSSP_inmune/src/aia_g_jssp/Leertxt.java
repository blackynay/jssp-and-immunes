package aia_g_jssp;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Leertxt{
public static void main (String[] args)
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

int datos[]=new int[150];
int c=0;

while ((strLine = br.readLine()) != null)   {
// Print the content on the console
	  c=c+1;

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