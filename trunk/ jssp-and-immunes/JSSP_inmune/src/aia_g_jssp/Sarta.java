package aia_g_jssp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Sarta {
	

	public int[] Anticuerpo(int J, int M) {
		int cont = 0, cont2 = 0;
		int[] Ab = new int[J * M];
		for (int i = 0; i < M * J; i++) {
			cont++;
			Ab[i] = cont2;
			// System.out.println(Ab[i]);
			if (cont == M) {
				cont2++;
				cont = 0;
			}
		}
		return Ab;
	}

	public int[] Barajar(int[] Ab) {
		// Create a list
		ArrayList list = new ArrayList();
		// Add elements to list
		for (int i = 0; i < Ab.length; i++) {
			list.add(Ab[i]);
		}
		// Shuffle the elements in the list
		Collections.shuffle(list);
		// Collections.shuffle(Arrays.asList(Ab));
		Iterator itr = list.iterator();
		int[] vector = new int[Ab.length];
		int cont = 0;
		while (itr.hasNext()) {
			vector[cont] = (Integer) itr.next();
			// System.out.print(vector[cont]);
			cont = cont + 1;
		}
		// System.out.println();
		return vector;
	}
	
	public int Makespan(int calen[][][], int J, int M) {
		int maximo = -9999999;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < J; j++) {
				maximo = Math.max(maximo, calen[i][j][1]);
			}
		}
		// System.out.println(maximo);
		return maximo;
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
					//System.out.print("  " + calen[i][j][1]);
					//System.out.println();
				} else {
					//System.out.print("  " + calen[i][j][1]);
				}
			}
		}
		return calen;
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
	
	/*public String ToBinary2(int[] Abb, int J, int M, int cant_bits) {
	// Anticuerpo en String
	String[] AB = new String[J * M];
	String numCadena = "";
	String Acumulador = "";
	// Vector binario
	int[] vect_binario = new int[J * M * cant_bits];
	int[] temp = new int[cant_bits];
	int cont = 0;
	int c = 0;
	for (int i = 0; i < J * M * cant_bits; i++) {
		vect_binario[i] = 0;
	}
	for (int i = 0; i < J * M; i++) {
		AB[i] = Integer.toString(Abb[i]);
		String bin = Integer.toString(Integer.parseInt(AB[i], 10), 2);
		char[] carac = bin.toCharArray();
		for (int k = 0; k < cant_bits; k++) {
			temp[k] = 0;
		}
		int cor = cant_bits - carac.length;
		cont = 0;

		for (int j = 0; j < carac.length; j++) {
			temp[j + cor] = Integer.parseInt(Character.toString(carac[j]));
			cont++;
		}
		for (int j = 0; j < cant_bits; j++) {
			vect_binario[c] = temp[j];
			// System.out.print(vect_binario[c]);
			numCadena = Integer.toString(vect_binario[c]);
			Acumulador = Acumulador + numCadena;
			// System.out.print(temp[j] + " ");
			c++;
		}
		// System.out.print(Abb[i]);
		// System.out.println();
	}
	// System.out.println(Acumulador);
	// return vect_binario;
	return Acumulador;
}
	
	public int Calcular_cant_bits(int J) {
	int cant_bits = (int) Math.ceil(log2(J));
	// System.out.println(cant_bits);
	return cant_bits;
}

public static double log2(double num) {
	return (Math.log(num) / Math.log(2));
}

public String sarta_aleatorios(double numero_bits) {
	String s = "";
	for (int i = 0; i < numero_bits; i++) {
		if (Math.random() < 0.5)
			s = s + "1";
		else
			s = s + "0";
	}
	return s;
}

public int[] decodificar(String pop, int J, int M, int cant_bits) {
	// Inicializacion de variables
	int[] b = new int[J * M];
	String ind[] = new String[J * M * cant_bits];
	char[] individuo = pop.toCharArray();
	int con = 0;
	String temp = "";
	int cont = 0;
	for (int i = 0; i < individuo.length; i++) {
		ind[i] = Character.toString(individuo[i]);
		if (con < cant_bits) {
			temp = (temp + ind[i]);
			con++;
			if (con == cant_bits) {
				// System.out.print(temp);
				con = 0;
				int numero = Integer.parseInt(temp, 2);
				b[cont] = numero;
				// System.out.print(b[cont]);
				temp = "";
				cont++;
			}
		}
	}
	System.out.print(temp);
	System.out.println();
	return b;
}*/
}
