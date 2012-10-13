package aia_g_jssp;

public class PruebaClonalg {
	public static void main(String[] args) {
		int tampob = 100;
		Clonalg algclon = new Clonalg();

		// int[] trabajos={0,1,3,2,2,1,3,0,0,1,3,2}; //Instancia LN
		// int[] trabajos={0,2,1,3,0,2,1,1,3,2,3,0,};
		//int[] trabajos = { 3, 8, 6, 9, 4, 1, 5, 7, 3, 4, 2, 0, 6, 8, 5, 1, 9,
		//		2, 7, 0, 3, 4, 1, 7, 8, 6, 5, 9, 2, 0, 7, 1, 3, 9, 8, 6, 5, 4,
		//		0, 2, 1, 8, 3, 7, 6, 9, 5, 4, 2, 0 };// instancias la01-la05
		int[] trabajos = {9,4,3,8,6,1,7,5,5,0,1,7,4,6,5,3,4,1,8,1};
		
		// int[]
		// trabajos={3,10,13,8,14,6,9,11,4,1,13,5,10,7,3,4,12,2,0,13,6,11,8,5,1,9,2,10,7,0,14,12,3,4,1,13,11,7,8,6,14,5,12,9,2,0,10,7,1,3,11,9,12,8,13,6,5,14,4,0,2,1,8,3,11,10,7,12,6,9,5,4,14,2,0};
		// instancias la05-la010
		Leer_archivo inst = new Leer_archivo();
		int[][] instancia = inst.Leer_instancia();
		int[] Tama = inst.Tamano_inst();
		// System.out.print(Tama[0]);
		// System.out.print(Tama[1]);
		// int[][]instancia={{0,10, 2, 25, 1, 4},{1, 5 ,2 ,25, 0, 8},{0, 23, 1,
		// 13, 2, 7},{2, 8, 0 ,21, 1 ,5}}; //Instancia LN
		// int[][]instancia={{0,2, 1, 3, 2, 4},{2, 4 ,1 ,4, 0, 1},{1, 2, 2, 2,
		// 0, 1},{0, 3, 2 ,3, 1 ,1}};

		int[][][] calendario = algclon.veriRestric(trabajos, instancia,
				Tama[0], Tama[1]);

		int Make_span = algclon.Makespan(calendario, Tama[0], Tama[1]);
		System.out.print(Make_span);

	}
}
