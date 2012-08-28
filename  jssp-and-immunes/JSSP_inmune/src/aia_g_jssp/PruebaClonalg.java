package aia_g_jssp;

public class PruebaClonalg{
	public static void main (String[] args)
	{
		int tampob=100;
		Clonalg algclon=new Clonalg();
				String [] a=algclon.Crear_Poblacion(16.0,tampob);
				int [] adecode=algclon.decodificar(a);
				double [] costo=algclon.Funcion_Objetivo(adecode);
				int[] trabajos={0,1,3,2,2,1,3,3,0,0,1,3,2};
				algclon.veriRestric(trabajos);
				for(int i=0;i<adecode.length;i++)
				{
					System.out.println(a[i]);
					System.out.println(adecode[i]);
					System.out.println(costo[i]);
				}
	}
}


