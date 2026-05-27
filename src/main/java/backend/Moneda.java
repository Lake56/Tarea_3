package backend;

/**
 * clase abstracta de una moneda para pagar
 * implementa Comparable para ordenar por sus valores
 */
public abstract class Moneda implements Comparable<Moneda>{
    /**
     * crea una moneda
     */
    public Moneda() {}
    /**
     * retorna un numero de serie para la moneda
     * @return this
     */
    public Moneda getSerie() {
        return this;
    }
    /**
     * retorna el valor de la moneda
     * debe implementarse por sus subclases retornando su valor
     * @return valor
     */
    public abstract int getValor();

    /**
     * compara esta moneda con otra por su valor
     * @param otra moneda a comparar
     * @return negativo si esta es menor, positivo si es mayor y 0 si son iguales
     */
    public int compareTo(Moneda otra) {
        return this.getValor()-otra.getValor();
    }
    /**
     * retorna un texto con el número de serie y valor de la moneda
     * @return string con la serie y el valor
     */
    public String toString() {
        return "moneda: serie=" + hashCode() + ", valor=" + getValor() + "]";
    }
}