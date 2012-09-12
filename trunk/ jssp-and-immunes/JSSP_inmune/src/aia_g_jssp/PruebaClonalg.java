package aia_g_jssp;
public class PruebaClonalg{
        public static void main (String[] args)
        {
                int tampob=100;
                Clonalg algclon=new Clonalg();
                                String [] a=algclon.Crear_Poblacion(16.0,tampob);
                                int [] adecode=algclon.decodificar(a);
                                double [] costo=algclon.Funcion_Objetivo(adecode);
                                
                                //int[] trabajos={0,1,3,2,2,1,3,0,0,1,3,2}; //Instancia LN
                                //int[] trabajos={0,2,1,3,0,2,1,1,3,2,3,0,};
                                int[] trabajos={3,8,6,9,4,1,5,7,3,4,2,0,6,8,5,1,9,2,7,0,3,4,1,7,8,6,5,9,2,0,7,1,3,9,8,6,5,4,0,2,1,8,3,7,6,9,5,4,2,0};
                                
                                Leer_archivo inst=new Leer_archivo();
                                int [][]instancia=inst.Leer_instancia();
                                int []Tama=inst.Tamano_inst();
                                //System.out.print(Tama[0]);
                                //System.out.print(Tama[1]);
                                //int[][]instancia={{0,10, 2, 25, 1, 4},{1, 5 ,2 ,25, 0, 8},{0, 23, 1, 13, 2, 7},{2, 8, 0 ,21, 1 ,5}}; //Instancia LN
                                //int[][]instancia={{0,2, 1, 3, 2, 4},{2, 4 ,1 ,4, 0, 1},{1, 2, 2, 2, 0, 1},{0, 3, 2 ,3, 1 ,1}};
                                
                               algclon.veriRestric(trabajos, instancia,Tama[0],Tama[1]);
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
