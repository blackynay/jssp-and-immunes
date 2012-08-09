
package aia_g_jssp;
import java.lang.Math;

public class Clonalg
{
	/* configuraci�n del problema */
	private double tama�o_problema = 2.0;
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
	
	public String[] Crear_Poblacion(double numero_bits)
	{
		 String [] pop=new String [tamano_pob];
		for(int i=0;i<pop.length;i++)
		{
			pop[i]=string_aleatorios(numero_bits);
			//System.out.println(pop[i]);
					
		}
	return pop;	
	}
}