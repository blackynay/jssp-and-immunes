package aia_g_jssp;
public class Clonalg
{
        /* configuración del problema */
        private double tamaño_problema = 2.0;
        // configuracion del algoritmo
        private int gen_max =100;
        private int tamano_pob =100;
        private double factor_clonac = 0.1;
        private int numero_alet = 2;
        private double factor_mutacion=-2.5;
       
        public double calcular_tasa_mutacion( /* falta anticuerpo*/)
        {
                return factor_mutacion;
        }
       
        public double num_clones(double tamano_pob ,double factor_clonac)
        {
                return Math.floor(tamano_pob*factor_clonac);
        }
       
        public String string_aleatorios(double numero_bits)
        {
                String s="";
                for(int i=0;i<numero_bits;i++)
                {
                        if(Math.random()<0.5)
                        s=s+"1";
                        else s=s+"0";
                }
                return s;
        }
       
        public String[] Crear_Poblacion(double numero_bits, int tampob)
        {
                 String [] pop=new String [tampob];
                for(int i=0;i<pop.length;i++)
                {
                        pop[i]=string_aleatorios(numero_bits);
                                       
                }
        return pop;    
        }
       
        public int[] decodificar(String[] pop)
        {
                int []b= new int [pop.length];
                for (int i=0;i<pop.length;i++){
            int numero = Integer.parseInt(pop[i],2);
            b[i]= numero;
                }
                return b;
               
        }
       
        public double[] Funcion_Objetivo(int[] adecode)
        {
                double[]costo=new double[adecode.length];
                for(int i=0;i<adecode.length;i++){
               
                                costo[i]=(double)Math.pow(adecode[i],2);
                       
                }
                return costo;
        }
        public int[][] recibeMatriz(int matriz[][]){
                return matriz;
        }
       
        public int [][][] veriRestric(int[] trabajos, int[][] inst, int J, int M) {
            int j = 0;
            int time[] = new int[trabajos.length];
            int trab_actual[][] = new int[M][J];
            Calendario[][] calendario = new  Calendario[M][J];
            boolean ban_J_inst[][] = new boolean[J][M];
    		int [][][]calen=new int[3][4][3];
    		for (int i = 0; i < M; i++) {
    			for (int j1 = 0; j1 < J; j1++) {
    				for (int k= 0; k < 3; k++) {
    					
    					trab_actual[i][j1] = 0;
                        ban_J_inst[j1][i] = false;
                        // System.out.println(ban_J_inst[j1][i]);
                        // System.out.println(trab_actual[i][j1]);
                        //   System.out.println();
    				}
    			}
    		}

            int t;
           
            for (int i = 0; i < trabajos.length; i++) {
                t = trabajos[i];
               
                int act = veri_ban_J(ban_J_inst, M, t);
                //System.out.println(act);
                //System.out.println();
                //System.out.println(t);
                if(act!=-1){
                    trab_actual[act][t] = inst[t][((2 * act) + 1)];
                    System.out.println(inst[t][(2 * act) + 1]);
                    ban_J_inst[t][act] = true;
                }

                time[i]= inst[t][((j*2)+1)];
                 //System.out.println(time[i]);
               
                // System.out.println(trab_actual[t][act]);
                if (i % J == J - 1) {
                    j = j + 1;
                    // System.out.println(i);
                }
            }
           
            return calen;
        }

        public int veri_ban_J(boolean ban[][], int M, int t) {
            int actual = 0;
            for (int i = 0; i < M; i++) {
                if (i != M) {

                    if (ban[t][i] == true) {
                        actual++;
                    } else {
                        return actual;
                    }
                } else {
                    if(ban[t][i] == true){
                        return actual=-1;
                    }else{
                        return actual;
                    }
                   
                }
            }
            return actual;
        }
       

       
}

