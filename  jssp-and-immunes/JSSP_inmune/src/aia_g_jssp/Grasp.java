package aia_g_jssp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.List;

public class Grasp extends Sarta {
	public int[] construct_randomized_greedy_solution(int[][] inst, int J,
			int M, double alpha) {
		int con = 0;
		int c = 0;
		int[][] opciones = new int[J][M];
		for (int i = 0; i < J * M; i++) {
			opciones[c][con] = c;
			// System.out.print(opciones[c][con]);
			con++;
			if (con == M) {
				c++;
				con = 0;
				// System.out.println();
			}
		}
		// Inicializacion de variables.
		Random randomGenerator = new Random();
		List<Integer> candidato = new ArrayList<Integer>();
		// ArrayList que almacena el candidato de la construccion
		List<Integer> candidates = new ArrayList<Integer>();
		List<Integer> job1 = new ArrayList<Integer>();
		// ArrayList que contiene los candidatos a ser evaluados
		int[] permutacion = new int[J * M];
		int inicial = randomGenerator.nextInt(J);
		permutacion[0] = inicial;
		opciones[inicial][0] = -1;
		candidato.add(0, inicial);
		Sarta sarta = new Sarta();
		int[][][] calen;
		int mincosto = 999999999;
		int maxcosto = -999999999;
		for (int ii = 0; ii < (J * M) - 1; ii++) {
			// opciones etiqueta los valores ya escogidos.
			c = 0;
			for (int j = 0; j < J; j++) {
				if (opciones[j][M - 1] != -1) {
					candidates.add(c, opciones[j][M - 1]);
					c++;
				}
			}
			//
			Iterator<Integer> itr = candidates.iterator();
			int[] vector = new int[candidato.size() + 1];
			// System.out.println(candidato.size()+1);
			int[] costo = new int[candidates.size()];
			Iterator<Integer> itr2 = candidato.iterator();
			c = 0;
			while (itr2.hasNext()) {
				vector[c] = (Integer) itr2.next();
				c++;
			}// System.out.println();
			// System.out.println(candidato.size());
			int cont = 0;
			int Job = 0;
			while (itr.hasNext()) {
				vector[candidato.size()] = (Integer) itr.next();
				for (int i = 0; i < candidato.size() + 1; i++) {
					// System.out.print(vector[i]);
				}
				// System.out.println();
				calen = sarta.veriRestric(vector, inst, J, M);
				// System.out.println(cont);
				costo[cont] = sarta.Makespan(calen, J, M);
				if (costo[cont] < mincosto) {
					mincosto = costo[cont];
					if (costo[cont] > maxcosto) {
						maxcosto = costo[cont];
					}
				}
				// System.out.println();
				// System.out.println(mincosto);
				// System.out.println(maxcosto);
				cont++;
			}
			mincosto = 99999999;
			c = 0;
			for (int i = 0; i < costo.length; i++) {
				if (costo[i] <= (mincosto + (alpha * (maxcosto - mincosto)))) {
					job1.add(c, candidates.get(i));
					c++;
				}
			}
			c = randomGenerator.nextInt(job1.size());
			Job = job1.get(c);
			// System.out.println();
			// System.out.println(Job);
			// System.out.println();
			job1.clear();
			permutacion[ii + 1] = Job;
			candidato.add(candidato.size(), Job);
			int it = 0;
			while (it < M && opciones[Job][it] == -1) {
				it++;
			}
			if (it < M) {
				opciones[Job][it] = -1;
			}
			// if (ii == (J * M) - 2){
			// for (int j = 0; j < J*M; j++) {
			// System.out.println(permutacion[j]);
			// }
			// }
			candidates.clear();
		}
		return permutacion;
	}

	public int[] local_search(int[] best, int[][] inst, int max_no_improv,
			int J, int M) {
		int count = 0;
		int costo_candidate;
		int costo_best;
		Sarta sarta2 = new Sarta();
		Sarta sarta1 = new Sarta();
		int[][][] calen_best;
		int[][][] calen_candidate;
		int[] candidate;
		calen_best = sarta2.veriRestric(best, inst, J, M);
		costo_best = sarta2.Makespan(calen_best, J, M);
		while (count < max_no_improv) {
			candidate = stochastic_two_opt(best);
			// for(int
			// i=0;i<candidate.length;i++){System.out.print(candidate[i]);}
			calen_candidate = sarta1.veriRestric(candidate, inst, J, M);
			costo_candidate = sarta1.Makespan(calen_candidate, J, M);
			//System.out.println("EL costo mejor " + costo_best);
			// System.out.println("EL costo candidato"+ costo_candidate);
			//System.out.println("count antes de entrar" + count);
			if (costo_candidate < costo_best) {
				count = 0;
				// System.out.println("EL costo mejor dentro FOR "+costo_best);
				//
				// System.out.println("EL costo candidato dentro FOR"+
				// costo_candidate);
				calen_best = calen_candidate;
				costo_best = costo_candidate;
				for (int i = 0; i < candidate.length; i++) {
					best[i] = candidate[i];
				}
				// calen_best = sarta2.veriRestric(best, inst, J, M);
				// costo_best = sarta2.Makespan(calen_best, J, M);
				//
				// System.out.println("EL costo nuevo mejor"+costo_best);
			} else {
				count++;
				// System.out.println("entre al else" +count);
				// System.out.println("costo del mejor dentro ELSE"
				// +costo_best);
				// calen_best=calen_best;
			}
			// System.out.println(count);
		}
		return best;
	}

	public int[] stochastic_two_opt(int[] perm) {
		Random randomGenerator = new Random();
		List<Integer> permute = new ArrayList<Integer>();
		List<Integer> orden = new ArrayList<Integer>();
		// Iterator<Integer> itr = exclude.iterator();
		int[] exclude = new int[3];
		int t1 = randomGenerator.nextInt(perm.length);
		int t2 = randomGenerator.nextInt(perm.length);
		// exclude.add(t1);
		exclude[0] = t1;
		if (t1 == 0) {
			exclude[1] = perm.length - 1;
		} else {
			exclude[1] = t1 - 1;
		}
		if (t1 == perm.length - 1) {
			exclude[2] = 0;
		} else {
			exclude[2] = t1 + 1;
		}
		int value1;
		for (int i = 0; i < exclude.length; i++) {
			value1 = exclude[i];
			if (value1 == t2) {
				t2 = randomGenerator.nextInt(perm.length);
			}
		}
		if (t2 < t1) {
			t1 = t2;
			t2 = t1;
		}
		// System.out.println(t1);
		// System.out.println(t2);
		int c = 0;
		for (int i = t1; i < t2; i++) {
			permute.add(c, perm[i]);
			c++;
		}
		List<Integer> inverso = reverseElements(permute, orden);
		Iterator<Integer> itr = inverso.iterator();
		int[] vector = new int[inverso.size()];
		c = 0;
		while (itr.hasNext()) {
			vector[c] = (Integer) itr.next();
			c++;
		}
		c = 0;
		for (int i = t1; i < t2; i++) {
			perm[i] = vector[c];
			// System.out.print(perm[c]);
			c++;
		}// System.out.println();
		return perm;
	}

	public List<Integer> reverseElements(List<Integer> permute,
			List<Integer> orden) {
		for (int i = permute.size() - 1; i >= 0; --i) {
			orden.add(permute.get(i));
		}
		return orden;
	}
}
