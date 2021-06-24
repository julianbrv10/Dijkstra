package grafodinamico;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erick
 */
public class Grafo {
    
    //las librerias hashMap y Map se usan para crear las variables o el nodo con un valor clave
    //para identificarlos y llamarlos de una forma ordenada 
    private Map<String, Vertice> vertices = new HashMap<String, Vertice>();
    
    //el priorityQueue se utiliza para hacer una cola de prioridad, pero a diferencia de la cola normal (First in- first out)
    //las de piroridad tienen una prioridad asignada, por lo cual se iran desencolando de mayor a menor prioridad
    public PriorityQueue<Vertice> pq = new PriorityQueue<Vertice>(200, new Vertice());

    public void addVertex(String source, String dest, int weight) {
        Vertice v = getVertex(source);
        Vertice w = getVertex(dest);
        v.adjacentD.add(new Nodo(w, weight));
        w.adjacentD.add(new Nodo(v, weight));
    }

    //sirve para obtener el valor del vertice solamente que sea igual a null y agregara 
    //el vertice nuevo 
    private Vertice getVertex(String name) {
        Vertice v = (Vertice) vertices.get(name);
        if (v == null) {
            v = new Vertice(name);
            vertices.put(name, v);
        }
        return v;
    }

    public void dijkstra(String init, String ciudadO) {
        Vertice actual;
        Vertice start = (Vertice) vertices.get(init);
        start.setDistance(0);
        pq.add(start);
        int cont = 0;
        while (cont < vertices.size()) {
            actual = pq.poll();
            //peso asociado con el vértice actual
            int vertWeight = actual.getDistance();
            if (actual.known == false) {
                cont++;
                actual.known = true;
                compAdjEdges(actual, vertWeight);
                if (actual.name.equals(ciudadO)) {
                    //System.out.format("%-15s", actual.name);
                    System.out.println("Ruta Optima: ");
                    printPath(actual);
                    System.out.println("");
                    System.out.format("Kilometros: %-8d", (int) actual.distance);
                    System.out.println();
                }
            }
        }
    }
    
    //declaro el tamaño de los vertices como iny y pongo la distancia temporal 
    //y la original para hacer las comparaciones
    public void compAdjEdges(Vertice s, int w) {
        Vertice source = s;
        int vertWeight = w;
        int tempDist;
        int origDist;
        
        /*Cada arista adyacente al Vertice de origen, 
        (si aún no se ha manejado) tiene un peso que se agrega 
        al pathWeight actual. Si este pathWeight es menor que 
        el asociado con el vértice del borde dado 
        (destination.getDistance()), la distancia del vértice 
        se actualiza y esta ruta se agrega a la cola de prioridad*/
         
        for (Nodo e : source.adjacentD) {
            Nodo curEdge = e;
            Vertice curVer = e.getDestination();
            origDist = curVer.getDistance();
            if (curVer.known == false) {
                tempDist = curEdge.getWeight();
                tempDist = tempDist + vertWeight;
                if (tempDist < origDist) {
                    curVer.setDistance(tempDist);
                    curVer.previous = source;
                    pq.add(curVer);
                }
            }
        }
    }

    /*
    imprimo la ruta mas rapida para llegar al destino
    llamando al actual.previous que es el pais inicial
    despues le concateno una flecha para indicar quien es
    el siguiente concatenandole el actual.name que es el pais siguiente
    
    esto se cicla hasta que el pais siguiente o el actual.name sea igual al pais 
    que se puso como destino, por lo que el siguiente se pondra como null y se acabara 
    la condicional
    */
    public void printPath(Vertice c) {
        Vertice actual = c;
        if (actual.previous != null) {
            printPath(actual.previous);
            System.out.print(" --> ");
            System.out.print(actual.name);
        }
        if (actual.previous == null) {
            System.out.print(actual.name);
        }
    }
}
