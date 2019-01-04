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
    
    public static void imprimeCinta(int[] id, int[] l, int[] p, String titulo){
        int i;
        System.out.println("Tiempo de lectura: " + funcionTiempo(l,p));
        System.out.println(titulo);
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
    
    // Para obtener el tiempo total de lectura de la cinta con la ordenación dada
    private static int funcionTiempo(int[] l, int[] p){
        int out = 0;
        int i, j, s;
        
        for (i = 0; i < p.length; i++){
            s = 0;
            
            for (j = 0; j <= i; j++){
                s = s + l[j];
            }
            
            out = out + (p[i] * s);
        }
        
        return out;
    }
    
    //-----         funciones ordenadoras           -----
    
    // Por longitud de los ficheros (Creciente)
    private static int[][] ordenaCintaLongitudCrec(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int i, j;
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de longitudes l
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(l[j] > l[j+1]){//------------------ > para menor a mayor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    // Por longitud de los ficheros (Decreciente)
    private static int[][] ordenaCintaLongitudDecr(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int i, j;
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de longitudes l
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(l[j] < l[j+1]){//------------------ < para mayor a menor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    // Por nº de peticiones de los ficheros (Decreciente)
    private static int[][] ordenaCintaPeticionesDecr(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int i, j;
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de longitudes l
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(p[j] < p[j+1]){//------------------ < para mayor a menor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    // Por nº de peticiones de los ficheros (Creciente)
    private static int[][] ordenaCintaPeticionesCrec(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int i, j;
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de longitudes l
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(p[j] > p[j+1]){//------------------ > para menor a mayor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    // Por el producto del nº de peticiones y la longitud de los ficheros (Creciente)
    private static int[][] ordenaCintaProductoCrec(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int[] m = new int[id.length];
        int i, j;
        
        //obtenemos el producto para la ordenacion respecto a él
        for (i = 0; i<m.length; i++)    m[i] = l[i]*p[i];
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de productos m
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(m[j] > m[j+1]){//------------------ > para menor a mayor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                    
                    aux = m[j];
                    m[j] = m[j+1];
                    m[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    // Por el producto del nº de peticiones y la longitud de los ficheros (Decreciente)
    private static int[][] ordenaCintaProductoDecr(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int[] m = new int[id.length];
        int i, j;
        
        //obtenemos el producto para la ordenacion respecto a él
        for (i = 0; i<m.length; i++)    m[i] = l[i]*p[i];
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de productos m
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(m[j] < m[j+1]){//------------------ < para mayor a menor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                    
                    aux = m[j];
                    m[j] = m[j+1];
                    m[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    // Por la división del nº de peticiones y la longitud de los ficheros (Creciente)
    private static int[][] ordenaCintaDivisionCrec(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int[] c = new int[id.length];
        int i, j;
        
        //obtenemos el producto para la ordenacion respecto a él
        for (i = 0; i<c.length; i++)    c[i] = p[i]/l[i];
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de cocientes c
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(c[j] > c[j+1]){//------------------ > para menor a mayor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                    
                    aux = c[j];
                    c[j] = c[j+1];
                    c[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    // Por la división del nº de peticiones y la longitud de los ficheros (Decreciente)
    private static int[][] ordenaCintaDivisionDecr(int[] id, int[] l, int[] p){
        int[][] out = {new int[id.length], new int[l.length], new int[p.length]};
        int[] c = new int[id.length];
        int i, j;
        
        //obtenemos el producto para la ordenacion respecto a él
        for (i = 0; i<c.length; i++)    c[i] = p[i]/l[i];
        
        int aux;
        boolean ord = false;
        
        //ordenamos por burbuja respecto al array de cocientes c
        i = 0;
        while ((i < id.length) && (!ord)){
            i = i+1;
            ord = true;
            
            for (j = 0; j < (id.length-i); j++){
                if(c[j] < c[j+1]){//------------------ < para mayor a menor
                    ord = false;
                    aux = id[j];
                    id[j] = id[j+1];
                    id[j+1] = aux;
                    
                    aux = l[j];
                    l[j] = l[j+1];
                    l[j+1] = aux;
                    
                    aux = p[j];
                    p[j] = p[j+1];
                    p[j+1] = aux;
                    
                    aux = c[j];
                    c[j] = c[j+1];
                    c[j+1] = aux;
                }
            }
        }
        
        out[0] = id; out[1] = l; out[2] = p;
        
        return out;
    }
    
    //Main del programa
    
    public static void main(String[] args) {
        
        //Los aux son los que se modificarán durante la ejecución
        //int[][] aux = generaCintaStandart();
        int[][] aux = generaCinta(7, 1, 20, 1, 15);
        int[] id = aux[0];
        int[] idaux;
        int[] l = aux[1];
        int[] laux;
        int[] p = aux[2];
        int[] paux;
        
        imprimeCinta(id, l, p, "Sin ordenar");
        
        //Longitud creciente
        aux = ordenaCintaLongitudCrec(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de menor a mayor por longitud de los ficheros");
        
        //Longitud decreciente
        aux = ordenaCintaLongitudDecr(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de mayor a menor por longitud de los ficheros");
        
        //Peticiones decreciente
        aux = ordenaCintaPeticionesDecr(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de mayor a menor por nº de peticiones de los ficheros");
        
        //Peticiones Creciente
        aux = ordenaCintaPeticionesCrec(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de menor a mayor por nº de peticiones de los ficheros");
        
        //Producto de nº de peticiones y longitud Creciente
        aux = ordenaCintaProductoCrec(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de menor a mayor por Multiplicación de nº peticiones y longitud de los ficheros");
        
        //Producto de nº de peticiones y longitud Decreciente
        aux = ordenaCintaProductoDecr(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de mayor a menor por Multiplicación de nº peticiones y longitud de los ficheros");
        
        //Divisiones de nº de peticiones y longitud Creciente
        aux = ordenaCintaDivisionCrec(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de menor a mayor por la Division de nº peticiones y longitud de los ficheros");

        //Divisiones de nº de peticiones y longitud Decreciente
        aux = ordenaCintaDivisionDecr(id, l, p);
        idaux = aux[0];
        laux = aux[1];
        paux = aux[2];
        
        imprimeCinta(idaux, laux, paux, "Ordenado de mayor a menor por la Division de nº peticiones y longitud de los ficheros");
    }
    
}
