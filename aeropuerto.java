import java.util.*;

public class MinimoTransbordos {

    // Clase que representa un nodo (aeropuerto) con su distancia
    static class Nodo {
        String aeropuerto;
        int distancia;
        
        Nodo(String aeropuerto, int distancia) {
            this.aeropuerto = aeropuerto;
            this.distancia = distancia;
        }
    }

    // Método para calcular el número mínimo de transbordos
    public static int calcularMinimoTransbordos(Map<String, List<String>> grafo, String inicio, String destino) {
        // Se inicializa un mapa para almacenar las distancias mínimas a cada aeropuerto
        Map<String, Integer> distancias = new HashMap<>();
        for (String aeropuerto : grafo.keySet()) {
            distancias.put(aeropuerto, Integer.MAX_VALUE); // Se asigna infinito inicialmente
        }
        distancias.put(inicio, 0); // La distancia al aeropuerto de inicio es 0

        // Se crea una cola de prioridad para procesar los aeropuertos por su distancia
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));
        cola.add(new Nodo(inicio, 0)); // Se agrega el aeropuerto de inicio a la cola

        // Mientras haya elementos en la cola, se sigue procesando
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll(); // Se obtiene el aeropuerto con la menor distancia

            // Si se ha llegado al destino, se retorna la distancia
            if (actual.aeropuerto.equals(destino)) {
                return actual.distancia;
            }

            // Se revisan los aeropuertos conectados al actual
            for (String vecino : grafo.get(actual.aeropuerto)) {
                int nuevaDistancia = actual.distancia + 1; // Cada conexión es un transbordo

                // Si se encuentra un camino más corto, se actualiza la distancia
                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    cola.add(new Nodo(vecino, nuevaDistancia)); // Se agrega el vecino a la cola
                }
            }
        }

        // Si no se puede llegar al destino, se retorna -1
        return -1;
    }

    public static void main(String[] args) {
        // Se define el grafo de aeropuertos y sus conexiones
        Map<String, List<String>> grafo = new HashMap<>();
        grafo.put("A", Arrays.asList("B", "C"));
        grafo.put("B", Arrays.asList("A", "D", "E"));
        grafo.put("C", Arrays.asList("A", "F"));
        grafo.put("D", Arrays.asList("B"));
        grafo.put("E", Arrays.asList("B", "F"));
        grafo.put("F", Arrays.asList("C", "E"));

        String inicio = "A";
        String destino = "F";

        // Se llama al método para obtener el número mínimo de transbordos
        int resultado = calcularMinimoTransbordos(grafo, inicio, destino);
        
        // Se muestra el resultado
        System.out.println("El número mínimo de transbordos de " + inicio + " a " + destino + " es: " + resultado);
    }
}
