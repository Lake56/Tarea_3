package backend;

import java.util.ArrayList;
/**
 * Se crea la clase deposito, que sera un arraylist generico para todos los productos
 * @param <T> se utiliza para validar el tipo de datos que contendra el arraylist
 */
public class Deposito<T> {
    private ArrayList<T> lista;

    /**
     * se inicializa el Arraylist
     */
    public Deposito() {
        lista = new ArrayList<T>();
    }

    /**
     * se le añaden objetos en medida que quede atras del anterior
     * @param obj con el que se llena el ArrayList
     */
    public void add(T obj) {
        lista.add(obj);
    }
    /**
     * Metodo para devoler el producto que escoje el usuario con verificacion
     * @return producto siempre y cuando el arraylist no este vacio
     */
    public T get() {
        if (lista.size() == 0) {
            return null;
        }else {
            return lista.remove(0);
        }
    }

    /**
     * verifica que el arraylist no este vacio
     * @return True si es que esta vacio, en caso contrario retorna false
     */
    public boolean isEmpty() {
        return lista.size() == 0;
    }
}

