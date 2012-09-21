package aia_g_jssp;

public class Sarta {
	
	public int Calcular_cant_bits(int J){
		int cant_bits =(int)Math.ceil(log2(J));
		return cant_bits;
	}
	
	public static double log2(double num)
	{
	return (Math.log(num)/Math.log(2));
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
	public int[] decodificar(String[] pop,int J,int M, int cant_bits) {
		int[] b = new int[J*M*cant_bits];
		for (int i = 0; i < pop.length; i++) {
			int numero = Integer.parseInt(pop[i], 2);
			b[i] = numero;
		}
		return b;
	}

}
