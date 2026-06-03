package backend;

/**
 * expendedor de bebidas y dulces
 * hace el proceso de compra, pago y devolucion de dinero
 */
public class Expendedor {
    private Deposito<Producto> depositoCoca;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoSuper8;
    private Deposito<Moneda> depositoVuelto;
    private Deposito<Moneda> depositoCompra;
    private Producto RetiroProducto;
    public static int Contador;
    /**
     * crea los expendedores y llena a todos con la misma cantidad
     * Contador es usado para la serializacion unica de cada producto y moneda
     * @param numProductos cantidad de productos para cada tipo
     */
    public Expendedor(int numProductos) {
        depositoCoca = new Deposito<Producto>();
        depositoSprite = new Deposito<Producto>();
        depositoFanta = new Deposito<Producto>();
        depositoSnickers = new Deposito<Producto>();
        depositoSuper8 = new Deposito<Producto>();
        depositoVuelto = new Deposito<Moneda>();
        depositoCompra= new Deposito<Moneda>();
        Contador=1;
        /**se llenan todos magicamente por igual
        * se suma uno al contador para que cada uno tenga una serie distinta
        */
        for (int i = 0; i < numProductos; i++){
            depositoCoca.add(new CocaCola(i+Contador));
            Contador+=1;
            depositoSprite.add(new Sprite(i+Contador));
            Contador+=1;
            depositoFanta.add(new Fanta(i+Contador));
            Contador+=1;
            depositoSnickers.add(new Snickers(i+Contador));
            Contador+=1;
            depositoSuper8.add(new Super8(i+Contador));
        }
    }

    /**
     * retorna el deposito segun el tipo de producto
     * @param tipo el tipoProduct solicitado
     * @return el deposito del producto, o null si no existe
     */
    private Deposito<Producto> getDeposito(tipoProduct tipo) {
        if (tipo == tipoProduct.COCA) {
            return depositoCoca;
        }
        if (tipo == tipoProduct.SPRITE) {
            return depositoSprite;
        }
        if (tipo == tipoProduct.FANTA) {
            return depositoFanta;
        }
        if (tipo == tipoProduct.SNICKERS) {
            return depositoSnickers;
        }
        if (tipo == tipoProduct.SUPER8) {
            return depositoSuper8;
        }
        return null;
    }
    /**
     * accion de comprar un producto de el expendedor
     * El producto se guarda en el contenedor para su retiro
     * @param m  moneda con la que paga
     * @param cualProducto el identificador del producto
     * @throws PagoIncorrectoException si moneda es null
     * @throws NoHayProductoException si el deposito esta vacio
     * @throws PagoInsuficienteException si la moneda es menor al precio del producto
     */
    public void comprarProducto(Moneda m, tipoProduct cualProducto)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        // Verificar en caso que la moneda sea nula
        if (m == null) {
            throw new PagoIncorrectoException("Sin moneda para comprar.");
        }

        // Seleccionar el deposito correcto
        Deposito<Producto> dep = getDeposito(cualProducto);

        // Verificar que el deposito exista
        if (dep == null) {
            depositoVuelto.add(m); // En caso que no existe se devuelve la moenda
            throw new NoHayProductoException("El producto solicitado no existe.");
        }

        // Verificar que el monto de dinero sea suficiente
        if (m.getValor() < cualProducto.getPrecio()) {
            depositoVuelto.add(m); // Devolvemos la moneda en caso que no sea suficiente el monto
            throw new PagoInsuficienteException("Pago insuficiente.");
        }

        // Sacar el producto del deposito
        Producto p = dep.get();
        if (p == null){
            depositoVuelto.add(m); // Devolvemos la moneda en caso que no haya stock
            throw new NoHayProductoException("No hay producto en el deposito.");
        }
        // Se añade el dinero al deposito
        depositoCompra.add(m);
        // Calcular el vuelto con monedas de a 1000, 500 y 100
        int diferencia = m.getValor() - cualProducto.getPrecio();
        while (diferencia >= 100){
            if(diferencia>=1000) {
                depositoVuelto.add(new Moneda1000());
                diferencia -= 1000;
            }
            else if(diferencia>=500) {
                depositoVuelto.add(new Moneda500());
                diferencia -= 500;
            }
            else if(diferencia>=100) {
                depositoVuelto.add(new Moneda100());
                diferencia -= 100;
            }
        }

        RetiroProducto =p;
    }

    /**
     * *Retorna el Producto seleccionado o null en caso de que este vacio
     * @return null
     * @return P
     */
    public Producto getProducto(){
        if(RetiroProducto==null){
            return null;
            }
        else{
            Producto P=RetiroProducto;
            RetiroProducto=null;
            return (P);
        }
    }
    /**
     * retorna una moneda de vuelto por llamada
     * @return el vuelto como moneda o null si no hay vuelto
     */
    public Moneda getVuelto(){
        return depositoVuelto.get();
    }
}