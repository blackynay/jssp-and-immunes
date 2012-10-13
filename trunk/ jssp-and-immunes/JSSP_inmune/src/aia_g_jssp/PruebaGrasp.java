package aia_g_jssp;


public class PruebaGrasp {
     public static void main(String[] args) {
        // Parametros algoritmo clonalg
         double alpha = 0.3;
          int max_iter = 50;
          int max_no_improv = 50;
         
         // Lectura de la instancia
         Leer_archivo inst = new Leer_archivo();
         int[][] instancia = inst.Leer_instancia();
         int[] Tama = inst.Tamano_inst();
         int lon_individuo = Tama[0] * Tama[1];
        
         Grasp grasp =new Grasp();
         int allJobs [] = grasp.Anticuerpo(Tama[0], Tama[1]);
         grasp.construct_randomized_greedy_solution(Tama[0],Tama[1]);
        
         //
     }
}

