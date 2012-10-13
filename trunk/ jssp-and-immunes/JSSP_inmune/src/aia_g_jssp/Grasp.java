package aia_g_jssp;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Grasp extends Sarta{

    public void construct_randomized_greedy_solution(int J,int M){
        int [] allJobs=new int[J*M];
        int con = 0;
        int c = 0;
        int [][] opciones= new int[J][M];
        for(int i=0;i<J*M;i++){
            allJobs[i]=i;
            opciones[c][con]=c;
            System.out.print(opciones[c][con]);
               con++;
            if(con==M){
            	c++;
            	con=0;
                System.out.println();
            }
        }
        Random randomGenerator = new Random();

        List <Integer> candidato =new  ArrayList<Integer> ();
        List <Integer> candidates =new  ArrayList<Integer> ();
       
        candidato.add(randomGenerator.nextInt(J*M));
        while(candidato.size() < allJobs.length){
            for(int i=0;i<allJobs.length;i++){

            }
        }
           
    }
}