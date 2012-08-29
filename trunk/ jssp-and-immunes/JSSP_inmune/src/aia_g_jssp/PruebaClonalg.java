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
				int[][]instancia={{0,10, 2, 25, 1, 4},{1, 5 ,2 ,25, 0, 8},{0, 23, 1, 13, 2, 7},{2, 8, 0 ,21, 1 ,5}};
				algclon.veriRestric(trabajos, instancia,4,3);
				for(int i=0;i<adecode.length;i++)
				{
					//int d=i+1;
					//boolean p=((i+1)%4==0);
					//System.out.println(p);
					//System.out.println(a[i]);
					//System.out.println(adecode[i]);
					//System.out.println(costo[i]);
				}
	}
}


