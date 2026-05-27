package backend;

/**
 * comprador que paga por el producto de un expendedor, recibe el vuelto y prueba el sabor
 */
class Comprador {
    private String sabor;
    private int vuelto;
    /**
     * Crea un comprador que intenta comprar un producto en el expendedor.
     * Consume el producto si lo obtiene y acumula el vuelto moneda por moneda.
     * @param m moneda con la que se paga
     * @param tipo el iddentificador del producto que se busca comprar
     * @param exp expendedor del cual se compra
     */
    public Comprador(Moneda m, tipoProduct tipo, Expendedor exp)
         throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
            vuelto = 0;
            sabor = null;

            Producto p = exp.comprarProducto(m, tipo);
            sabor = p.Sabor();
        Moneda moneda;
        while ((moneda = exp.getVuelto()) != null) {
            vuelto += moneda.getValor();
        }
    }
     /**
      * retorna el total del vuelto
      * @return vuelto en pesos
      */
    public int cuantoVuelto() {
        return vuelto;
    }
    /**
     * retorna el sabor del producto
     * @return String con el tipo de producto
     */
    public String queBebiste() {
        return sabor;
    }
}
