package aia_g_jssp;

public class PruebaClonalg{
	public static void main (String[] args)
	{
		//@SuppressWarnings("unused")
		int numpob=100;
		Clonalg algclon=new Clonalg();
		String []a =new String [numpob];
				a=algclon.Crear_Poblacion(16.0);
				int [] adecode=algclon.decodificar(a);
				for(int i=0;i<adecode.length;i++)
				{
					System.out.println(a[i]);
					System.out.println(adecode[i]);
				}
		//System.out.println();
		
			
	}
}
/*package aia_g_jssp;


public class PruebaClonalg{
        public static void main (String[] args)
        {
                //@SuppressWarnings("unused")
                Clonalg algclon=new Clonalg();
                String []a =new String [100];
                String []b =new String [100];
                int i=0;
                                a=algclon.Crear_Poblacion(16.0);
                                for(i=0;i<a.length;i++)
                                {
                                     System.out.println(a[i]);
                                                                        
                                }
                                
                                System.out.println( );
                                System.out.println( );
                                
                              for (i=0;i<a.length;i++){
                             int numero = Integer.parseInt(a[i],2);
                             b[i]= Integer.toString(numero) ;
                             System.out.println(b[i]);
                                                         	                           
                              }
                              
                              
                                
                //System.out.println();
                
                        
        }
}*/

