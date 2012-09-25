package aia_g_jssp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Sarta {

	public int Calcular_cant_bits(int J) {
		int cant_bits = (int) Math.ceil(log2(J));
		System.out.println(cant_bits);
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

	public int[] decodificar(String[] pop, int J, int M, int cant_bits) {
		int[] b = new int[J * M * cant_bits];
		for (int i = 0; i < pop.length; i++) {
			int numero = Integer.parseInt(pop[i], 2);
			b[i] = numero;
		}
		return b;
	}

	public int[] Anticuerpo(int J, int M) {
		int cont = 0, cont2 = 0;
		int[] Ab = new int[J * M];
		for (int i = 0; i < M * J; i++) {
			cont++;
			Ab[i] = cont2;
			// System.out.println(Ab[i]);
			if (cont == 5) {
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
			//System.out.println(vector[cont]);
			cont = cont + 1;
		}
		return Ab;
	}

	public int[] ToBinary(int[] Ab, int J, int M, int cant_bits) {
		int[] vect_binario = new int[J * M * cant_bits];
		int[] temp = new int[cant_bits];
		int c = 0;
		for (int i = 0; i < cant_bits; i++) {
			temp[i] = 0;
		}
		for (int i = 0; i < J * M * cant_bits; i++) {
			vect_binario[i] = 0;
		}
		for (int i = 0; i < J * M; i++) {
			int cont = 0;
			while (cont < cant_bits) {
				int res = Ab[i] % 2;
				if (res == 0) {
					temp[i] = res;
					int coc = Ab[i] / 2;
					if (coc == 0 || coc==1) {
						cont = 9999;
					}
				} else if (res == 1) {
					temp[i] = res;
					int coc = Ab[i] - 1 / 2;
					if (coc == 1) {
						cont = 9999;
					}
				} //System.out.println(res);
			}

			for (int j = cant_bits - 1; j >= 0; j--) {
				vect_binario[c] = temp[j];
				System.out.println(vect_binario[c]);
				c = c + 1;
			}
		}

		return vect_binario;
	}
}

