package aia_g_jssp;
public class PruebaSarta {

    public static void main(String[] args) {
        Sarta S1 = new Sarta();
        int J = 40;
        int M = 15;
        int poblacion = 100;
        String[] pob = new String[poblacion];
        int resp = S1.Calcular_cant_bits(J);
   
        for (int i = 0; i < poblacion; i++) {
            int[] Ab = S1.Anticuerpo(J, M);
            int[] Abb = S1.Barajar(Ab);
            pob[i] = S1.ToBinary2(Abb, J, M, resp);
            //System.out.println(pob[i]);     
        }
        S1.decodificar(pob, J, M,  resp);
    }
}
