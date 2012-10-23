package aia_g_jssp;

import java.io.FileInputStream;

public class PruebaGrasp {

	//public static void main(String[] args) {
	public Integer ejecutar_Grasp(FileInputStream fstream){
		// Parametros algoritmo clonalg
		double alpha = 0.95;
		int max_iter = 400;
		int max_no_improv = 100;

		//for (int i1 = 0; i1 < 10; i1++) {
			// Lectura de la instancia
			Integer best = null;
			Leer_archivo inst = new Leer_archivo();
			int[][] instancia = inst.Leer_instancia(fstream);
			int[] Tama = inst.Tamano_inst(fstream);
			Grasp grasp = new Grasp();
			int[][][] calendario_mejor;
			int costo;

			int[] permutation_best = new int[Tama[0] * Tama[1]];
			for (int i = 0; i < max_iter; i++) {
				int[] permutacion = grasp.construct_randomized_greedy_solution(
						instancia, Tama[0], Tama[1], alpha);
				// for (int j = 0; j < Tama[0]*Tama[1]; j++) {
				// System.out.print(permutacion[j]);
				// } System.out.println();
				permutacion = grasp.local_search(permutacion, instancia,
						max_no_improv, Tama[0], Tama[1]);
				// for (int j = 0; j < Tama[0]*Tama[1]; j++) {
				// System.out.print(permutacion[j]);
				// }System.out.println();
				calendario_mejor = grasp.veriRestric(permutacion, instancia,
						Tama[0], Tama[1]);
				costo = grasp.Makespan(calendario_mejor, Tama[0], Tama[1]);
				if (best == null) {
					for (int j = 0; j < permutacion.length; j++) {
						permutation_best[j] = permutacion[j];
					}
					best = costo;
				} else {
					if (costo < best) {
						for (int j = 0; j < permutacion.length; j++) {
							permutation_best[j] = permutacion[j];
						}
						best = costo;
					}
				}
				// System.out.println(best);
			}
			System.out.println( best);
			//max_no_improv = max_no_improv + 200;
			/*
			 * for (int j = 0; j < permutation_best.length; j++) {
			 * System.out.print(permutation_best[j]); }
			 */
		//}
	//}
			return best;
		}
}