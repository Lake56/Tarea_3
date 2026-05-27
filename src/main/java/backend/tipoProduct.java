package backend;

/**
 * Se crea la clase enum que contiene los valores y codigos verificadores de producto
 * Ademas retornar uno de estos parametros para su uso en el codigo
 */
public enum tipoProduct  {
    COCA(500, "CocaCola", 1),
    SPRITE(500, "Sprite", 2),
    FANTA(500, "Fanta", 3),
    SNICKERS(400, "Snickers", 4),
    SUPER8(300, "Super8", 5);
    private int precio;
    private String nombre;
    private int identificador;

    /**
     * Se asigna valor al precio e identificador del producot
     * @param precio del producto
     * @param nombre del producto
     * @param identificador del producto
     */
    private tipoProduct(int precio, String nombre, int identificador) {
        this.precio = precio;
        this.nombre = nombre;
        this.identificador = identificador;
    }

    /**
     * @return el valor del producto
     */
    public int getPrecio() {
        return precio;
    }
    /**
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @return el numero verificador del producto
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Entrega el producto dependiendo su identificador
     * @param identificador del producto
     */
    public static tipoProduct getProducto(int identificador) {
        if (identificador == COCA.identificador){
            return COCA;
        }
        if (identificador == SPRITE.identificador){
            return SPRITE;
        }
        if (identificador == FANTA.identificador){
            return FANTA;
        }
        if (identificador == SNICKERS.identificador){
            return SNICKERS;
        }
        if (identificador == SUPER8.identificador){
            return SUPER8;
        }
        return null;
    }
}