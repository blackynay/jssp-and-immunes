package aia_g_jssp;

public class PruebaSarta {

	public static void main(String[] args) {
		Sarta S1 = new Sarta();
		int poblacion = 100;
		String[] pob = new String[poblacion];

		
		Clonalg algclon=new Clonalg();
		
        Leer_archivo inst=new Leer_archivo();
        int [][]instancia=inst.Leer_instancia();
        int []Tama=inst.Tamano_inst();
        
		int resp = S1.Calcular_cant_bits(Tama[0]);
		
		for (int i = 0; i < poblacion; i++) {
			int[] Ab = S1.Anticuerpo(Tama[0], Tama[1]);			// Anticuerpo sin barajar.
			int[] Abb = S1.Barajar(Ab);				// Anticuerpo barajado.
			pob[i] = S1.ToBinary2(Abb, Tama[0], Tama[1], resp);	// pob[i] representa cada individuo en String
			int[] Anticuerpo = S1.decodificar(pob[i], Tama[0], Tama[1], resp);// Vector entero de anticuerpo
			int [][][] calendario=algclon.veriRestric(Anticuerpo, instancia,Tama[0],Tama[1]);
			int Make_span=algclon.Makespan(calendario,Tama[0],Tama[1]);
			// System.out.println(pob[i]);
		}

		/*
		 * // Anticuerpo sin barajar.
		 * 
		 * int[] Ab = S1.Anticuerpo(J, M);
		 * 
		 * // Anticuerpo barajado.
		 * 
		 * int[] Abb = S1.Barajar(Ab);
		 * 
		 * // pob[i] representa cada individuo
		 * 
		 * pob[0] = S1.ToBinary2(Abb, J, M, resp);
		 * 
		 * // System.out.println(pob[i]);
		 * 
		 * System.out.print(pob[0]);
		 * 
		 * System.out.println();
		 * 
		 * for (int i = 0; i < J * M; i++) {
		 * 
		 * System.out.print(Abb[i]);
		 * 
		 * }System.out.println();
		 */
	}
}
