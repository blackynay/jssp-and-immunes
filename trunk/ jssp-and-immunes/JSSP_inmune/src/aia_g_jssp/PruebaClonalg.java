package aia_g_jssp;

public class PruebaClonalg{
	public static void main (String[] args)
	{
		//@SuppressWarnings("unused")
		int tampob=100;
		Clonalg algclon=new Clonalg();
				String [] a=algclon.Crear_Poblacion(16.0,tampob);
				int [] adecode=algclon.decodificar(a);
				for(int i=0;i<adecode.length;i++)
				{
					System.out.println(a[i]);
					System.out.println(adecode[i]);
				}
		
			
	}
}


