/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafodinamico;

import java.util.*;
/**
 *
 * @author erick
 */
public class Vertice implements Comparator<Vertice> {
    public String name;
    public LinkedList<Nodo> adjacentD; //lista para crear los nodos adyacentes a D
    public LinkedList<Vertice> adjacentT; //lista para crear los vertices o nodos adyacentes a T
    public int distance; // distancia entre cada nodo
    public Vertice previous; //vértice anterior en el camino más corto
    public boolean known; 
    public int defaultDis = Integer.MAX_VALUE;

    public Vertice() {
        //propiedades del vertice
        name = null;
        distance = defaultDis;
        previous = null;
        known = false;
    }

    public Vertice(String argName) {
        //propiedades del vertice con sus listas enlazadas para sus comparaciones entre cada 
        //diferente ruta a seguir
        this.name = argName;
        adjacentD = new LinkedList<Nodo>();
        adjacentT = new LinkedList<Vertice>();
        distance = defaultDis;
        previous = null;
        known = false;
    }

    //get y set para meter y sacar la distancia entre cada nodo ingresado
    public int getDistance() {
        return distance;
    }

    public void setDistance(int w) {
        distance = w;
    }

    //compara las distancias entre cada pais para verificar que ruta es las mas conveniente
    //o de menos coste para pasar por ahí y compara si el v1 es mayor al v2 regresa 1
    //si, v1 es menos al v2 regresa -1 y si no es ninguno, es decir, son iguales,
    //regresa un 0
    public int compare(Vertice v1, Vertice v2) {
        int w1 = v1.getDistance();
        int w2 = v2.getDistance();
        if (w1 > w2) {
            return 1;
        } else if (w1 < w2) {
            return -1;
        } else {
            return 0;
        }
    }
}
