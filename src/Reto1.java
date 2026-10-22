package src;

/**
 * Lista Simple: Catálogo de libros
 * @author Jesús Manuel y Oscar Mauel
 * @date 22 octubre 2026
 */
class Nodo {
    String libro;
    Nodo siguiente;

    Nodo(String libro) { this.libro = libro; }

    public String getLibro() { return libro; }
    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}

class ListaSimple {
    private Nodo cabeza;

    // Inserta un libro al final de la lista
    public void insertarFinal(String libro) {
        Nodo nuevo = new Nodo(libro);
        if (cabeza == null) {
            // TODO 1: lista vacía → el nuevo nodo es la cabeza
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            // TODO 2: detenerse en el ÚLTIMO nodo
            while (actual.getSiguiente() != null) {
                actual = actual.siguiente;
            }
            // TODO 3: enlazar el nuevo nodo al final
            actual.setSiguiente(nuevo);
        }
    }

    // Devuelve true si el libro existe
    public boolean buscar(String libro) {
        Nodo actual = cabeza;
        while (actual != null) {
            // TODO 4: comparar con equals y retornar true si coincide
            if (actual.getLibro().equals(libro)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Elimina la primera aparición del libro
    public boolean eliminar(String libro) {
        if (cabeza == null) return false;

        if (cabeza.libro.equals(libro)) {
            // TODO 5: eliminar la cabeza
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            // TODO 6: ¿el siguiente nodo es el que busco?
            if (actual.getSiguiente().getLibro().equals(libro)) {
                // TODO 7: saltar el nodo a eliminar
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.libro + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

public class Reto1 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        // Datos propios
        lista.insertarFinal("Gran Hasbic");
        lista.insertarFinal("Hasbic");
        lista.insertarFinal("El nunca visto");
        lista.insertarFinal("Incurcion");
        lista.insertarFinal("Estraccion");

        System.out.println("Lista inicial:");
        lista.mostrar();

        System.out.println("\nBuscar 'Incurcion' (existe): " + lista.buscar("Incurcion"));
        System.out.println("Buscar 'Ficciones' (no existe): " + lista.buscar("Ficciones"));

        System.out.println("\nEliminar la cabeza ('Gran Hasbic'): " + lista.eliminar("Gran Hasic"));
        lista.mostrar();

        System.out.println("\nEliminar un nodo intermedio ('El nunca visto'): " + lista.eliminar("El nunca visto"));
        lista.mostrar();

        System.out.println("\nEliminar el último ('Estraccion'): " + lista.eliminar("Estraccion"));
        lista.mostrar();

        System.out.println("\nEliminar uno inexistente ('Ficciones'): " + lista.eliminar("Ficciones"));
        lista.mostrar();
    }
}