package aia_g_jssp;

import java.lang.Math;
import java.util.Random;

public class Clonalg extends Sarta {

	public double calcular_tasa_mutacion(double afinidad, double factor_mutacion) {
//		return ((Math.exp(afinidad * -factor_mutacion)));
		return (1/factor_mutacion)*(1/(Math.exp(afinidad)));
	}

	public int num_clones(int tamano_pob, double factor_clonac) {
		return (int) Math.floor(tamano_pob * factor_clonac);
	}

	public double[] Calcular_afinidad(int[] Make_span) {
		int min_costo = 99999999;
		int max_costo = -99999999;
		for (int i = 0; i < Make_span.length; i++) {
			max_costo = Math.max(max_costo, Make_span[i]);
			min_costo = Math.min(min_costo, Make_span[i]);
		}
		double range = max_costo - min_costo;
		double[] afinidad = new double[Make_span.length];
		for (int i = 0; i < Make_span.length; i++) {
			if (range == 0.0) {
				afinidad[i] = 1.0;
			} else {
				afinidad[i] = 1.0 - (Make_span[i] / range);
			}
			// System.out.println(afinidad[i]);
		}
		return afinidad;
	}

	public int[] mutation(int Ab[], double Tasa_mutacion) {
		Random randomGenerator = new Random();
		int randomInt1;
		int randomInt2;
		int temp;
		for (int i = 0; i < Ab.length; i++) {
			if (Math.random() < Tasa_mutacion) {
				randomInt1 = randomGenerator.nextInt(Ab.length);
				randomInt2 = randomGenerator.nextInt(Ab.length);
				temp = Ab[randomInt1];
				Ab[randomInt1] = Ab[randomInt2];
				Ab[randomInt2] = temp;
			}
		}
		return Ab;
	}

	public int[][] clonar_e_hipermutar(int[] Ab, double factor_clonacion,
			int poblacion, double Afinidad, double factor_mutacion) {
		int num_clones = num_clones(poblacion, factor_clonacion);
		int[][] clones = new int[num_clones][Ab.length];
		int[] clon = new int[Ab.length];
		double m_rate = calcular_tasa_mutacion(Afinidad, factor_mutacion);
		for (int i = 0; i < num_clones; i++) {
			clon = mutation(Ab, m_rate);
			for (int j = 0; j < Ab.length; j++) {
				clones[i][j] = clon[j];
			}
		}
		return clones;
	}

	public int[][][] veriRestric(int[] trabajos, int[][] inst, int J, int M) {

		// Declaracion de variables
		int maq;
		int time_mach;
		int t;
		int trab_actual[][] = new int[3][J];
		boolean ban_J_inst[][] = new boolean[J][M];
		boolean ban_Calen[][] = new boolean[M][J];
		int[][][] calen = new int[M][J][3];

		// Inicializacion de variables.

		for (int i = 0; i < M; i++) {
			for (int j1 = 0; j1 < J; j1++) {
				ban_J_inst[j1][i] = false; // Indica la posicion en la matriz de
				// instancia.
				ban_Calen[i][j1] = false;
				for (int k = 0; k < 3; k++) {
					trab_actual[k][j1] = 0; // Indica para el trabajo Jth la
					// maquina Mth y la duracion Dth.
					calen[i][j1][k] = 0;
					// System.out.println(ban_J_inst[j1][i]);
					// System.out.println(trab_actual[i][j1]);
					// System.out.println();
				}
			}
		}

		// Recorre la sarta para construir el calendario

		for (int i = 0; i < trabajos.length; i++) {
			t = trabajos[i];
			// System.out.print(t);
			int act = veri_ban_Oper(ban_J_inst, M, t);// Verifica las
			// operaciones de la
			// instancia

			// act = -1 Denota el fin de la instancia para el trabajo.
			if (act != -1) {
				time_mach = inst[t][((2 * act) + 1)]; // tiempo del trabajo t
				maq = inst[t][(2 * act)]; // maq correspondiente al trabajo t
				// (Es decir, operacion O[maq,t]conduracion time_mach)

				ban_J_inst[t][act] = true; // Bandera de la instancia
				int actCal = veri_Calen(ban_Calen, J, maq);
				if (actCal != -1) {
					calen[maq][actCal][2] = t;
					// int Max_ti_maq=Max_dur_maq(trab_actual,J,maq);
					int fin_time_mach = 0;
					if (actCal != 0) {
						fin_time_mach = calen[maq][actCal - 1][1];
					}

					if (trab_actual[2][t] == 0 && fin_time_mach == 0) {
						// t,maq,time_mach representan los nuevos valores para
						// trabajo,maquina,duracion.
						calen[maq][actCal][0] = trab_actual[2][t];
						// tiempo inicio de la operacion

						trab_actual[0][t] = t;
						trab_actual[1][t] = maq;
						trab_actual[2][t] = time_mach;

						calen[maq][actCal][1] = trab_actual[2][t];
						// tiempo finalizacion de la operacion
						calen[maq][actCal][2] = t;
						// trabajo al que pertenece la operacion

					} else {
						if (fin_time_mach >= trab_actual[2][t]) {// se verica el
							// tiempo para la operacion con
							// respecto al trabajo anterior
							calen[maq][actCal][0] = fin_time_mach;// tiempo
							// inicio de la operacion

							trab_actual[1][t] = maq; // se verica el tiempo para
							// la operacion con respecto a la maquina
							// anterior
							trab_actual[2][t] = fin_time_mach + time_mach;

							calen[maq][actCal][1] = trab_actual[2][t];// tiempo
							// finaliz
							// de la
							// operacion
							calen[maq][actCal][2] = t; // trabajo al que
							// pertenece la
							// operacion

						} else {
							calen[maq][actCal][0] = trab_actual[2][t];// tiempo
							// inicio
							// de la
							// operacion

							trab_actual[1][t] = maq;
							trab_actual[2][t] = trab_actual[2][t] + time_mach;

							calen[maq][actCal][1] = trab_actual[2][t];// tiempo
							// finaliz
							// de la
							// operacion
							calen[maq][actCal][2] = t; // trabajo al que
							// pertenece la
							// operacion

						}
					}
				}

				ban_Calen[maq][actCal] = true; // Bandera del calendario
				// System.out.println(calen[maq][actCal][2]);
				// calen[maq][actCal][3]=t;
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < J; j++) {
				if (j == J - 1) {
					// System.out.print("  " + calen[i][j][1]);
					// System.out.println();
				} else {
					// System.out.print("  " + calen[i][j][1]);
				}
			}
		}
		return calen;
	}

	public int Makespan(int calen[][][], int J, int M) {
		int maximo = -9999999;
		for (int i = 0; i < M; i++) {
			maximo = Math.max(maximo, calen[i][J - 1][1]);
		}
		// System.out.println(maximo);
		return maximo;
	}

	public int veri_ban_Oper(boolean ban[][], int M, int t) {
		int actual = 0;
		for (int i = 0; i < M; i++) {
			if (i != M) {

				if (ban[t][i] == true) {
					actual++;
				} else {
					return actual;
				}
			} else {
				if (ban[t][i] == true) {
					return actual = -1;
				} else {
					return actual;
				}
			}
		}
		return actual;
	}

	public int veri_Calen(boolean ban_Calen[][], int J, int maq) {
		int actual = 0;
		for (int i = 0; i < J; i++) {
			if (i != J) {

				if (ban_Calen[maq][i] == true) {
					actual++;
				} else {
					return actual;
				}
			} else {
				if (ban_Calen[maq][i] == true) {
					return actual = -1;
				} else {
					return actual;
				}
			}
		}
		return actual;
	}
}
