package aia_g_jssp;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LectorInstanciaPrueba{
	public static void main( String[] args )
	{
		//LectorInstancia lector = new LectorInstancia();
		//System.out.printf(lector);
		//lector.openFile();
		int c=8;
		double[] array;
		array = new double[c]; 
		
	
		//String input1 = "1 2 3 4 5 6 7 8";
		//Scanner input = new Scanner(input1);
		try
		{
		Scanner input = new Scanner( new File( "la01.txt" ) );
		int s=0;
		while(input.hasNext())
		{
			array[s]=input.nextInt(); 
			s++;
		}
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println( "File cannot be found." );
			System.exit( 1 );
		}
		int s=0;
		
		
		for(int i=0;i<array.length;i++)
			System.out.printf("%5d%8d\n", i, array[ i ]);
	}
	
}