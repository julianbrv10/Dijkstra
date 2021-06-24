/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafodinamico;

/**
 *
 * @author erick
 */
public class Nodo {
    
    public Vertice destination;
    public int weight;

    public Nodo() {
        destination = null;
        weight = 1;
    }

    public Nodo(Vertice d, int w) {
        destination = d;
        weight = w;
    }

    public int getWeight() {
        return weight;
    }

    public Vertice getDestination() {
        return destination;
    }
}
