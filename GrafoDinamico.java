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
public class GrafoDinamico {

    //creo las variables y objetos a utilizar en la clase
    String initial = null;
    Grafo graph = new Grafo();
    String current;
    Scanner input = new Scanner(System.in);

    
    //dentro de una matriz o arreglo cree los paises que son los vertices del grafo inicial
    String[] paises = {
        "MEXICO",       //pais 0
        "USA",          //pais 1
        "CANADA",       //pais 2
        "CHILE",        //pais 3
        "VENEZUELA",    //pais 4
        "SALVADOR",     //pais 5
        "ECUADOR",      //pais 6
        "BRASIL",       //pais 7
        "ALEMANIA",     //pais 8
        "FRANCIA",      //pais 9 
        "COLOMBIA",     //pais 10
    };

    
    //el constructor se iniciara en el momento que inicie la clase. este llenara el grafo con la informacion de los paises.
    
    //lleno mi grafo, el primer corchete es el numero del pais, el segundo tambien
    //lo que significa que esas paises o vertices estan conectadas entre si, el ultimo numero
    //es el valor de la arista o el coste que tiene por pasar por ahi entre cada pais
    public GrafoDinamico() {
        graph.addVertex(paises[0], paises[3], 2);
        graph.addVertex(paises[0], paises[1], 3);
        graph.addVertex(paises[1], paises[0], 3);
        graph.addVertex(paises[1], paises[2], 5);
        graph.addVertex(paises[2], paises[1], 5);
        graph.addVertex(paises[2], paises[5], 3);
        graph.addVertex(paises[3], paises[0], 2);
        graph.addVertex(paises[3], paises[4], 5);
        graph.addVertex(paises[3], paises[6], 8);
        graph.addVertex(paises[4], paises[3], 5);
        graph.addVertex(paises[4], paises[5], 4);
        graph.addVertex(paises[4], paises[6], 3);
        graph.addVertex(paises[5], paises[1], 2);
        graph.addVertex(paises[5], paises[2], 3);
        graph.addVertex(paises[5], paises[4], 4);
        graph.addVertex(paises[6], paises[3], 8);
        graph.addVertex(paises[6], paises[4], 3);
        graph.addVertex(paises[6], paises[7], 5);
        graph.addVertex(paises[6], paises[10],7);
        graph.addVertex(paises[7], paises[4], 6);
        graph.addVertex(paises[7], paises[6], 5);
        graph.addVertex(paises[7], paises[8], 8);
        graph.addVertex(paises[8], paises[5], 15);
        graph.addVertex(paises[8], paises[7], 8);
        graph.addVertex(paises[8], paises[9], 1);
        graph.addVertex(paises[9], paises[8], 1);
        graph.addVertex(paises[9], paises[10], 3);
        graph.addVertex(paises[10], paises[9], 3);
        graph.addVertex(paises[10], paises[6], 7);
        
    }

    //imprimo las uniones de los paises y su coste entre la distancia de ellas
    public void imprimirContenido() {
        System.out.println("\tContenido del grafo");
        System.out.println(paises[0] + " - " + paises[3] + " - " + 2);
        System.out.println(paises[0] + " - " + paises[1] + " - " + 3);
        System.out.println(paises[1] + " - " + paises[0] + " - " + 3);
        System.out.println(paises[1] + " - " + paises[2] + " - " + 5);
        System.out.println(paises[2] + " - " + paises[1] + " - " + 5);
        System.out.println(paises[2] + " - " + paises[5] + " - " + 3);
        System.out.println(paises[3] + " - " + paises[0] + " - " + 2);
        System.out.println(paises[3] + " - " + paises[4] + " - " + 5);
        System.out.println(paises[3] + " - " + paises[6] + " - " + 8);
        System.out.println(paises[4] + " - " + paises[3] + " - " + 5);
        System.out.println(paises[4] + " - " + paises[5] + " - " + 4);
        System.out.println(paises[4] + " - " + paises[6] + " - " + 3);
        System.out.println(paises[5] + " - " + paises[1] + " - " + 2);
        System.out.println(paises[5] + " - " + paises[2] + " - " + 3);
        System.out.println(paises[5] + " - " + paises[4] + " - " + 4);
        System.out.println(paises[6] + " - " + paises[3] + " - " + 8);
        System.out.println(paises[6] + " - " + paises[4] + " - " + 3);
        System.out.println(paises[6] + " - " + paises[7] + " - " + 5);
        System.out.println(paises[6] + " - " + paises[10] + " - " + 7);
        System.out.println(paises[7] + " - " + paises[4] + " - " + 6);
        System.out.println(paises[7] + " - " + paises[6] + " - " + 5);
        System.out.println(paises[7] + " - " + paises[8] + " - " + 8);
        System.out.println(paises[8] + " - " + paises[5] + " - " + 15);
        System.out.println(paises[8] + " - " + paises[7] + " - " + 8);
        System.out.println(paises[8] + " - " + paises[9] + " - " + 1);
        System.out.println(paises[9] + " - " + paises[8] + " - " + 1);
        System.out.println(paises[9] + " - " + paises[10] + " - " + 3);
        System.out.println(paises[10] + " - " + paises[9] + " - " + 3);
        System.out.println(paises[10] + " - " + paises[6] + " - " + 7);
    }
    
    //metodo de busqueda dijstrak
    // le digo al usuario que ingrese el pais de inicio y el final para saber su recorrido y llamo a mi metodo
    //dijkstra que esta instanciado con el objeto graph de mi clase grafo y le paso de parametro pais1 y 2 que 
    //son los parametros que necesita para hacer el recorrido
    public void busqueda(){
        System.out.println("INGRESA EL NOMBRE COMPLETO DE LOS PAISES Y EN MAYUSCULA.\n");
        System.out.print("Introduce el pais de donde vas a partir: ");
        String pais1 = this.input.next();
        System.out.println("");
        System.out.print("Introduce el pais a donde quieres llegar: ");
        String pais2 = this.input.next();
        graph.dijkstra(pais1, pais2);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        int eleccion = 0;
        int elegir;
        GrafoDinamico obj = new GrafoDinamico();
        while(eleccion != 100){
            System.out.print(" "
                    + "1.- Imprimir contenido del grafo\n"
                    + "2.- Buscar ruta\n"
                    + "3.- Salir\n"
                    + ">");
            eleccion= obj.input.nextInt();
            
            switch (eleccion){
                case 1:
                    obj.imprimirContenido();
                    break;
                case 2:
                    obj.busqueda();
                    System.exit(0);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            
        }
    }
    
}
