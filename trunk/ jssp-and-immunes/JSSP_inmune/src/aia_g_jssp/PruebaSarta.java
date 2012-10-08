package aia_g_jssp;
import java.util.*;

public class PruebaSarta {
	public static void main(String[] args) {

		// Parametros algoritmo clonalg
		double factor_clonac = 0.2;
		double factor_mutacion = 4.5;
		int poblacion = 150;
		int rand_num = 8;
		int num_gen = 100;

		// Lectura de la instancia
		Leer_archivo inst = new Leer_archivo();
		int[][] instancia = inst.Leer_instancia();
		int[] Tama = inst.Tamano_inst();
		int lon_individuo = Tama[0] * Tama[1];

		// Variables del algoritmo
		int[][] pob = new int[poblacion][lon_individuo]; // Almacena la
															// poblacion
		int[][] pob_sort = new int[poblacion][lon_individuo];

		int[] Ab = new int[lon_individuo]; // Almacena el individuo o
											// anticuerpo.

		Clonalg algclon = new Clonalg();

		Integer[] Make_span = new Integer[poblacion];
		int[] M_span_sort = new int[poblacion];
		int[][][] calendario;

		int resp = algclon.Calcular_cant_bits(Tama[0]);
		for (int i = 0; i < poblacion; i++) {
			Ab = algclon.Anticuerpo(Tama[0], Tama[1]); // Anticuerpo sin
														// barajar.
			Ab = algclon.Barajar(Ab); // Anticuerpo barajado.
			calendario = algclon.veriRestric(Ab, instancia, Tama[0], Tama[1]);
			Make_span[i] = algclon.Makespan(calendario, Tama[0], Tama[1]);
			for (int j = 0; j < lon_individuo; j++) {
				pob[i][j] = Ab[j];
			}
		}
		// Ordenar
		ArrayIndexComparator comparator = new ArrayIndexComparator(Make_span);
		Integer[] indexes = comparator.createIndexArray();

		// Determinan los indices que muestra el orden del vector
		Arrays.sort(indexes, comparator);

		for (int i = 0; i < poblacion; i++) {
			for (int j = 0; j < lon_individuo; j++) {
				pob_sort[i][j] = pob[indexes[i]][j];
			}
			M_span_sort[i] = Make_span[indexes[i]];
		}

		for (int g = 0; g < num_gen; g++) {
			System.out.println("Generacion " + g + " " + M_span_sort[0]);
			// Afinidad de la poblacion inicial
			double[] Afinidad = algclon.Calcular_afinidad(M_span_sort);

			// Clonacion
			int nclones = algclon.num_clones(poblacion, factor_clonac);
			int pt_clones = poblacion * nclones; // poblacion total de clones
			int[][] clones = new int[nclones][lon_individuo]; // contiene
																// nclones
			int[][] popclones = new int[pt_clones][lon_individuo];
			int[][] popclones_sort = new int[pt_clones][lon_individuo];

			int c = 0;
			Integer[] Make_span_clon = new Integer[pt_clones];
			int[] Make_span_clon_sort = new int[pt_clones];

			for (int i = 0; i < poblacion; i++) {
				for (int j = 0; j < lon_individuo; j++) {
					Ab[j] = pob_sort[i][j];
				}
				clones = algclon.clonar_e_hipermutar(Ab, factor_clonac,
						poblacion, Afinidad[i], factor_mutacion);
				for (int k = 0; k < nclones; k++) {
					for (int l = 0; l < lon_individuo; l++) {
						popclones[k + c][l] = clones[k][l];
						Ab[l] = clones[k][l];
						// System.out.print(popclones[k+c][l]);
					}
					calendario = algclon.veriRestric(Ab, instancia, Tama[0],
							Tama[1]);
					Make_span_clon[k + c] = algclon.Makespan(calendario,
							Tama[0], Tama[1]);
					// System.out.println(Make_span_clon[k+c]);
					// System.out.println();
				}
				// System.out.println();
				c = c + nclones;
				// System.out.println(c);
			}
			for (Integer i = 0; i < pt_clones; i++) {
				// System.out.println(Make_span_clon[i]);
			}
			// Ordenar clones deacuerdo al Make_span
			ArrayIndexComparator comparator_clon = new ArrayIndexComparator(
					Make_span_clon);
			Integer[] indexes_clon = comparator_clon.createIndexArray();
			Arrays.sort(indexes_clon, comparator_clon);

			for (int i = 0; i < pt_clones; i++) {
				Make_span_clon_sort[i] = Make_span_clon[indexes_clon[i]];
				// System.out.println(Make_span_clon_sort[i]);
				for (int j = 0; j < lon_individuo; j++) {
					popclones_sort[i][j] = popclones[indexes_clon[i]][j];
					// System.out.print(popclones_sort[i][j]);
				}
				// System.out.println();
			}
			// Declaracion de variables
			int pop_y_clon = (pt_clones + poblacion);
			int[][] pop_pob_y_clon = new int[pop_y_clon][lon_individuo];
			Integer[] Make_span_pop_clon = new Integer[pop_y_clon];
			int c1 = 0;
			// Concatenar poblacion inicial y poblacion de clones
			for (int i = 0; i < pop_y_clon; i++) {
				if (i < poblacion) {
					Make_span_pop_clon[i] = M_span_sort[i];
					// System.out.println(i + " " +Make_span_pop_clon[i]);
					for (int j = 0; j < lon_individuo; j++) {
						pop_pob_y_clon[i][j] = pob_sort[i][j];
					}
				} else if (poblacion <= i && i < pop_y_clon) {
					Make_span_pop_clon[i] = Make_span_clon_sort[c1];
					// System.out.println(i + " " +Make_span_pop_clon[i]);
					for (int j = 0; j < lon_individuo; j++) {
						pop_pob_y_clon[i][j] = popclones_sort[c1][j];
					}
					c1 = c1 + 1;
				}
			}
			// System.out.println();
			// for (int i = 0; i < pop_y_clon; i++) {
			// System.out.println(i + " " + Make_span_pop_clon [i]);
			// }
			ArrayIndexComparator comparator_pop_clon = new ArrayIndexComparator(
					Make_span_pop_clon);
			Integer[] indexes_pop_clon = comparator_pop_clon.createIndexArray();
			Arrays.sort(indexes_pop_clon, comparator_pop_clon);

			// for (int i = 0; i < pop_y_clon; i++) {
			// System.out.println(Make_span_pop_clon[indexes_pop_clon[i]]);
			// }
			// Seleccion de los 100 individuos.
			for (int i = 0; i < poblacion; i++) {
				M_span_sort[i] = Make_span_pop_clon[indexes_pop_clon[i]];
				for (int j = 0; j < lon_individuo; j++) {
					pob_sort[i][j] = pop_pob_y_clon[indexes_pop_clon[i]][j];
					// System.out.print(pob_sort[i][j]);
				}
				// System.out.println();
			}
			// Se generan individuos aleatoreamente
			int[][] ind_random = new int[rand_num][lon_individuo];
			int[] Make_span_ind_random = new int[rand_num];
			int[] tem;
			for (int i = 0; i < rand_num; i++) {
				tem = algclon.Anticuerpo(Tama[0], Tama[1]);
				tem = algclon.Barajar(tem);
				calendario = algclon.veriRestric(tem, instancia, Tama[0],
						Tama[1]);
				Make_span_ind_random[i] = algclon.Makespan(calendario, Tama[0],
						Tama[1]);
				// System.out.println(Make_span_ind_random[i]);
				for (int j = 0; j < lon_individuo; j++) {
					ind_random[i][j] = tem[j];
					// System.out.print(ind_random[i][j]);
				}
				// System.out.println();
			}
			// Declaracion de variables
			int pop_rand_num = (poblacion + rand_num);
			int pop_rand_pop[][] = new int[pop_rand_num][lon_individuo];
			Integer Make_span_rand_pop[] = new Integer[pop_rand_num];

			// Concatenar individuos y bits generados aleatoriamente
			c1 = 0;
			for (int i = 0; i < pop_rand_num; i++) {
				if (i < poblacion) {
					Make_span_rand_pop[i] = M_span_sort[i];
					// System.out.println(i + " " +Make_span_rand_pop[i]);
					for (int j = 0; j < lon_individuo; j++) {
						pop_rand_pop[i][j] = pob_sort[i][j];
					}
				} else if (poblacion <= i && i < pop_rand_num) {
					Make_span_rand_pop[i] = Make_span_ind_random[c1];
					// System.out.println(i + " " +Make_span_rand_pop[i]);
					for (int j = 0; j < lon_individuo; j++) {
						pop_rand_pop[i][j] = ind_random[c1][j];
					}
					c1 = c1 + 1;
				}
			}
			ArrayIndexComparator comparator_pop_clon1 = new ArrayIndexComparator(
					Make_span_rand_pop);
			Integer[] indexes_pop_clon1 = comparator_pop_clon1
					.createIndexArray();
			Arrays.sort(indexes_pop_clon1, comparator_pop_clon1);

			// Seleccion de los 100 individuos.
			double prom=0;
			for (int i = 0; i < poblacion; i++) {
				M_span_sort[i] = Make_span_rand_pop[indexes_pop_clon1[i]];
				prom=(prom + M_span_sort[i]);
				for (int j = 0; j < lon_individuo; j++) {
					pob_sort[i][j] = pop_rand_pop[indexes_pop_clon1[i]][j];
					// System.out.print(pob_sort[i][j]);
				}
				// System.out.println();
			} prom=prom/poblacion; System.out.println("promedio " + prom); System.out.println("peor " + M_span_sort[poblacion-1]);
		}
		for (int i = 0; i < poblacion; i++) {
			//System.out.println(M_span_sort[i]);
			for (int j = 0; j < lon_individuo; j++) {
				// System.out.print(pob_sort[i][j]);
			}//System.out.println();
		}
	}
}
