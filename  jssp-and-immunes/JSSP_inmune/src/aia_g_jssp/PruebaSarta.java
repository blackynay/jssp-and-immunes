package aia_g_jssp;
public class PruebaSarta {

    public static void main (String[] args){
        Sarta S1=new Sarta();
        int J=20;
        int M=5;
        int resp=S1.Calcular_cant_bits(J);
        int [] Ab=S1.Anticuerpo(J, M);
        int [] Abb=S1.Barajar(Ab);
        //S1.ToBinary(Abb, 10, 5, resp);
        S1.ToBinary2(Abb, J, M, resp);
        //String bin = Integer.toString(Integer.parseInt("9", 10), 2);
        //System.out.println(bin);
        //System.out.println(1/2);
        //System.out.println(0/2);
        //System.out.println(1%2);
        //System.out.println(0%2);
    }
}