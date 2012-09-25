package aia_g_jssp;

public class PruebaSarta {

    public static void main (String[] args){
        Sarta S1=new Sarta();
        int resp=S1.Calcular_cant_bits(10);
        int [] Ab=S1.Anticuerpo(10, 5);
        int [] Abb=S1.Barajar(Ab);
        //S1.ToBinary(Abb, 10, 5, resp);
        System.out.println(1/2);
        System.out.println(0/2);
        //System.out.println(1%2);
        //System.out.println(0%2);
    }
}