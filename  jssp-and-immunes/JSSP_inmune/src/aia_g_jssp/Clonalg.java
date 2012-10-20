package aia_g_jssp;

import java.lang.Math;
import java.util.Random;

public class Clonalg extends Sarta {

        public double calcular_tasa_mutacion(double afinidad, double factor_mutacion) {
                return ((Math.exp(afinidad * factor_mutacion)));
                //return (1/factor_mutacion)*(1/(Math.exp(afinidad)));
        }

        public int num_clones(int tamano_pob, double factor_clonac) {
                return (int) Math.floor(tamano_pob * factor_clonac);
        }

        public double[] Calcular_afinidad(int[] Make_span) {
                int min_costo = 99999999;
                int max_costo = -99999999;
                for (int i = 0; i < Make_span.length; i++) {
                        max_costo = Math.max(max_costo, Make_span[i]);
                        min_costo = Math.min(min_costo, Make_span[i]);
                }
                double range = max_costo - min_costo;
                double[] afinidad = new double[Make_span.length];
                for (int i = 0; i < Make_span.length; i++) {
                        if (range == 0.0) {
                                afinidad[i] = 1.0;
                        } else {
                                afinidad[i] = 1.0 - (Make_span[i] / range);
                        }
                         //System.out.println(afinidad[i]);
                }
                return afinidad;
        }

        public int[] mutation(int Ab[], double Tasa_mutacion) {
                Random randomGenerator = new Random();
                int randomInt1;
                int randomInt2;
                int temp;
                for (int i = 0; i < Ab.length; i++) {
                        if (Math.random() < Tasa_mutacion) {
                               // randomInt1 = randomGenerator.nextInt(Ab.length);
                                randomInt1 = i;
                                randomInt2 = randomGenerator.nextInt(Ab.length);
                                temp = Ab[randomInt1];
                                Ab[randomInt1] = Ab[randomInt2];
                                Ab[randomInt2] = temp;
                        }
                }
                return Ab;
        }

        public int[][] clonar_e_hipermutar(int[] Ab, double factor_clonacion,
                        int poblacion, double Afinidad, double factor_mutacion) {
                int num_clones = num_clones(poblacion, factor_clonacion);
                int[][] clones = new int[num_clones][Ab.length];
                int[] clon = new int[Ab.length];
                double m_rate = calcular_tasa_mutacion(Afinidad, factor_mutacion);
                for (int i = 0; i < num_clones; i++) {
                        clon = mutation(Ab, m_rate);
                        for (int j = 0; j < Ab.length; j++) {
                                clones[i][j] = clon[j];
                        }
                }
                return clones;
        }

}

