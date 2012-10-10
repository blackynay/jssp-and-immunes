package aia_g_jssp;

import java.io.*;
import java.util.StringTokenizer;

public class Leer_archivo {
	String instan="la01.txt";
    public int[][] Leer_instancia() {
        
        try {
            // Open the file that is the first
            // command line parameter
            // FileInputStream fstream = new
            // FileInputStream("D:\\Datos\\Dropbox\\Implementación de un algoritmo inmune artificial aplicado en el  área  de planificación de recursos\\Software encontrado\\Instancias de Job shop scheduling\\la01.txt");

        	FileInputStream fstream = new FileInputStream(
                    "C:\\Documents and Settings\\Invitado\\Mis documentos\\Instancia\\"+instan);
            // Get the object of DataInputStream

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            // Read File Line By Line

            Object datos1[] = new Object[2];
            datos1[0] = 0;
            datos1[1] = 0;
            int c = 0;

            strLine = br.readLine();
            StringTokenizer str1 = new StringTokenizer(strLine);

            while (str1.hasMoreElements()) {
                datos1[c] = str1.nextElement();
                c = c + 1;
            }

            int J = Integer.parseInt((String) datos1[0]);
            int M = Integer.parseInt((String) datos1[1]);

            // System.out.println(J);
            // System.out.println(M);

            Object datos[][] = new Object[J][M * 2];

            int j = 0;
            int i = 0;

            while ((strLine = br.readLine()) != null) {

                StringTokenizer str = new StringTokenizer(strLine);
                while (str.hasMoreElements()) {
                    datos[j][i] = str.nextElement();
                    i = i + 1;
                }
                j = j + 1;
                i = 0;
            }

            // System.out.println(datos[c]);

            int vector[][] = new int[J][M * 2];
            for (int j1 = 0; j1 < J; j1++) {
                for (int i1 = 0; i1 < M * 2; i1++) {
                    vector[j1][i1] = Integer.parseInt((String) datos[j1][i1]);
                    // System.out.println(vector[j1][i1]);
                }
            }

            // Close the input stream
            in.close();
            return vector;
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());

        }
        return null;
    }

    public int[] Tamano_inst() {

        try {
            // Open the file that is the first
            // command line parameter
            // FileInputStream fstream = new
            // FileInputStream("D:\\Datos\\Dropbox\\Implementación de un algoritmo inmune artificial aplicado en el  área  de planificación de recursos\\Software encontrado\\Instancias de Job shop scheduling\\la01.txt");
            FileInputStream fstream = new FileInputStream(
                    "C:\\Documents and Settings\\Invitado\\Mis documentos\\Instancia\\"+instan);
            // Get the object of DataInputStream

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read File Line By Line

            Object datos1[] = new Object[2];
            datos1[0] = 0;
            datos1[1] = 0;
            int c = 0;

            strLine = br.readLine();
            StringTokenizer str1 = new StringTokenizer(strLine);

            while (str1.hasMoreElements()) {
                datos1[c] = str1.nextElement();
                c = c + 1;
            }

            int J = Integer.parseInt((String) datos1[0]);
            int M = Integer.parseInt((String) datos1[1]);
            int[] tama = new int[2];
            tama[0] = J;
            tama[1] = M;

            // Close the input stream
            in.close();
            return tama;
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());

        }
        return null;

    }
}


