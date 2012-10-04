package aia_g_jssp;

import java.util.*;

public class PruebaSarta {

    public static void main(String[] args) {
            Sarta S1 = new Sarta();
            int poblacion = 100;
            String[] pob = new String[poblacion];
            int[] Abb= new int[poblacion];
            int[] Ab= new int[poblacion];
           
            Clonalg algclon=new Clonalg();
           
    Leer_archivo inst=new Leer_archivo();
    int [][]instancia=inst.Leer_instancia();
    int []Tama=inst.Tamano_inst();
    Integer [] Make_span= new Integer [poblacion];
 
    
            int resp = S1.Calcular_cant_bits(Tama[0]);
            for (int i = 0; i < poblacion; i++) {
                    Ab = S1.Anticuerpo(Tama[0], Tama[1]);                     // Anticuerpo sin barajar.
                    Abb = S1.Barajar(Ab);                             // Anticuerpo barajado.
                    pob[i] = S1.ToBinary2(Abb, Tama[0], Tama[1], resp);     // pob[i] representa cada individuo en String
                    int[] Anticuerpo = S1.decodificar(pob[i], Tama[0], Tama[1], resp);// Vector entero de anticuerpo
                    int [][][] calendario=algclon.veriRestric(Anticuerpo, instancia,Tama[0],Tama[1]);
                    Make_span[i]=algclon.Makespan(calendario,Tama[0],Tama[1]);
            }
            ArrayIndexComparator comparator = new ArrayIndexComparator(Make_span);
            Integer[] indexes = comparator.createIndexArray();
    		for(Integer i=0;i<indexes.length;i++){
    			System.out.print(indexes[i]+ " ");
    			}
    			System.out.println();
    			Arrays.sort(indexes, comparator);
    			for(Integer i=0;i<indexes.length;i++){
    			System.out.print(indexes[i]+ " ");
    			}
    			System.out.println();
    			
    			for(Integer i=0;i<indexes.length;i++){
    			System.out.println(pob[indexes[i]]+ " ");
    			System.out.println(Make_span[indexes[i]]+ " ");
    			}
    			System.out.println();

    }
}

