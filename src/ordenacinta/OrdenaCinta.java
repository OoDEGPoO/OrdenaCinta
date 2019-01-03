/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacinta;

import java.util.Random;

/**
 *
 * @author diego
 */
public class OrdenaCinta {

    /**
     * @param args the command line arguments
     */
    
    //Funciones Auxiliares para la ejecución
    
    public static void imprimeCinta(int[] id, int[] l, int[] p){
        int i;
        
        System.out.println("-----------------------------------------------------------------");
        System.out.print("-\t");
        for (i = 0; i < id.length; i++){
            System.out.print(id[i] + "\t");
        }
        
        System.out.println("-");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("-\t");
        for (i = 0; i < l.length; i++){
            System.out.print(l[i] + "\t");
        }
        
        System.out.println("-");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("-\t");
        for (i = 0; i < p.length; i++){
            System.out.print(p[i] + "\t");
        }
        System.out.println("-");
        System.out.println("-----------------------------------------------------------------");

    }
    
    private static int[][] generaCinta(int n, int minl, int maxl, int minp, int maxp){
        int[][] out = {new int[n], new int[n], new int[n]};
        Random rand = new Random();
        
        for (int i = 0; i < n; i++){
            out[0][i] = i+1;
            out[1][i] = rand.nextInt(maxl-minl)+minl;
            out[2][i] = rand.nextInt(maxp-minp)+minp;
        }
        
        return out;
    }
    
    private static int[][] generaCintaStandart(){
        int[][] out = {{1, 2, 3, 4, 5, 6, 7}
               ,{4, 6, 3, 20, 6, 13, 1}
               ,{7, 10, 14, 4, 1, 3, 3}};
        
        return out;
    }
    
    //función ordenadora
    
    private static int[][] ordenaCinta(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int[] m = new int[id.length];
        int i, j;
        
        //obtenemos el producto para la ordenacion respecto a él
        for (i = 0; i<m.length; i++)    m[i] = l[i]*p[i];
        
        int[] outId = new int[id.length];
        int[] outL = new int[l.length];
        int[] outP = new int[p.length];
        int[] outM = new int[m.length];
        int auxId, auxL, auxP, auxM;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de productos m
        i = 1;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(m[j] > m[j+1]){
                    ord = false;
                    auxId = id[j];
                    id[j] = id[j+1];
                    id[j+1] = auxId;
                    
                    auxL = l[j];
                    l[j] = l[j+1];
                    l[j+1] = auxL;
                    
                    auxP = p[j];
                    p[j] = p[j+1];
                    p[j+1] = auxP;
                    
                    auxM = m[j];
                    m[j] = m[j+1];
                    m[j+1] = auxM;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    //Main del programa
    
    public static void main(String[] args) {
        
        int[][] aux = generaCintaStandart();
        //int[][] aux = generaCinta(7, 1, 20, 1, 15);
        int[] id = aux[0];
        int[] l = aux[1];
        int[] p = aux[2];
        
        imprimeCinta(id, l, p);
        
        aux = ordenaCinta(id, l, p);
        id = aux[0];
        l = aux[1];
        p = aux[2];
        
        imprimeCinta(id, l, p);
        
        //------------------- Comprobar!!!!!! --------------------------
    }
    
}
