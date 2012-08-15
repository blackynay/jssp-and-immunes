
package aia_g_jssp;
import java.lang.Math;

public class Clonalg
{
	/* configuración del problema */
	private double tamaño_problema = 2.0;
	// configuracion del algoritmo
	private int gen_max =100;
	private int tamano_pob =100;
	private double factor_clonac = 0.1;
	private int numero_alet = 2;
	private double factor_mutacion=-2.5;
	
	public double calcular_tasa_mutacion( /* falta anticuerpo*/)
	{
		return factor_mutacion;
	}
	
	public double num_clones(double tamano_pob ,double factor_clonac)
	{
		return Math.floor(tamano_pob*factor_clonac);
	}
	
	public String string_aleatorios(double numero_bits)
	{
		String s="";
		for(int i=0;i<numero_bits;i++)
		{
			if(Math.random()<0.5)
			s=s+"1";
			else s=s+"0";
		}
		return s;
	}
	
	public String[] Crear_Poblacion(double numero_bits, int tampob)
	{
		 String [] pop=new String [tampob];
		for(int i=0;i<pop.length;i++)
		{
			pop[i]=string_aleatorios(numero_bits);
					
		}
	return pop;	
	}
	
	public int[] decodificar(String[] pop)
	{
		int []b= new int [pop.length];
		for (int i=0;i<pop.length;i++){
            int numero = Integer.parseInt(pop[i],2);
            b[i]= numero;
		}
		return b;
		
	}
}