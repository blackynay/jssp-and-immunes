package aia_g_jssp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Sarta {
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
					System.out.print(b[cont]);
					temp = "";
					cont++;
				}
			}
		}
		System.out.print(temp);
		System.out.println();
		return b;
	}

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

	public String ToBinary2(int[] Abb, int J, int M, int cant_bits) {
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
				c = c + 1;
			}
			// System.out.print(Abb[i]);
			// System.out.println();
		}
		// System.out.println(Acumulador);
		// return vect_binario;
		return Acumulador;
	}
}
