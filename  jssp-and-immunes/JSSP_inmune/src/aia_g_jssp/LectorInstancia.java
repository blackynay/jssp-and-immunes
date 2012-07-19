package aia_g_jssp;
import java.io.*;
import java.util.Scanner;

public class LectorInstancia
{
	  private Scanner input;

	   // enable user to open file
	   public void openFile()
	   {
	      try
	      {
	         input = new Scanner( new File( "clients.txt" ) );
	      } // end try
	      catch ( FileNotFoundException fileNotFoundException )
	      {
	         System.err.println( "Error opening file." );
	         System.exit( 1 );
	      } // end catch
	   } // end method openFile
	   public int crearEntrada(int le){
		   
	   }
}