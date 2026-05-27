package backend;

import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializar Scanner
        Expendedor expendedor = new Expendedor(5); // Inicializar expendedor

        boolean salir = false;

        System.out.println("Maquina Expendedora");

        // Loop de seleccion de opcion
        while(!salir) {
            System.out.println("Elija una opcion");
            System.out.println("1. Comprar productos");
            System.out.println("2. Salir");

            // Se le pide al usuario la opcion
            String opcion = scanner.nextLine();

            // Se selecciona la opcion correspondiente del usuario
            switch(opcion) {
                case "1":
                    producto(scanner, expendedor);
                    break;
                case "2":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }

        // Se cierra el scanner
        scanner.close();
    }

    /**
     *
     * @param scanner El objeto scanner para leer la entrada por parte del usuario
     * @param expendedor El expendedor donde se comprara el producto
     */
    private static void producto(Scanner scanner, Expendedor expendedor) {
        // Inicializacion de variables
        int seleccion = 0;
        Moneda moneda = null;

        System.out.println("Catalogo de Productos");

        // Iterar todos los productos del enum tipoProduct
        for(tipoProduct producto : tipoProduct.values()) {
            System.out.println(producto.getIdentificador() + ". " + producto.getNombre());
        }

        System.out.println("Ingrese el numero del producto que desea: ");

        // Intentar convertir la seleccion del usuario a tipo int
        try {
            seleccion = Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException e) { // En caso que el usuario haya introducido una opcion que no sea un numero
            System.out.println("El producto ingresado no existe");
            return;
        }

        // Seleccionamos el producto en base a la opcion del usuario
        tipoProduct productoSelec = tipoProduct.getProducto(seleccion);

        // Verificamos que el producto exista
        if(productoSelec == null) {
            System.out.println("El numero del producto no existe");
            return;
        }

        System.out.println("Ingrese el numero de la moneda con que pagara");
        System.out.println("1. Moneda de $100");
        System.out.println("2. Moneda de $500");
        System.out.println("3. Moneda de $1000");

        // Pedimos al usuario la moneda a utilizar
        String seleccionMon = scanner.nextLine();

        // Se selecciona la moneda correspondiente al usuario
        switch(seleccionMon) {
            case "1":
                moneda = new Moneda100();
                break;
            case "2":
                moneda = new Moneda500();
                break;
            case "3":
                moneda = new Moneda1000();
                break;
            default:
                System.out.println("Moneda invalida");
                return;
        }

        // Se intenta comprar el producto
        try {
            Comprador comprador = new Comprador(moneda, productoSelec, expendedor);

            System.out.println("Su producto es: " + comprador.queBebiste());
            System.out.println("Su vuelto es: " + comprador.cuantoVuelto());
        } catch (PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e) {
            System.out.println("No se ha podido realizar la compra");
            System.out.println(e.getMessage());
        }
    }
}
