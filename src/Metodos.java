import java.util.Scanner;

public class Metodos {
    private static final Scanner lectura = new Scanner(System.in);
    private static final ConsultaModena consulta = new ConsultaModena();

    public static void ejecutarConversor() {
        int opcion;

        do {
            System.out.println("""
                    ********************************************
                    Sea bienvenido/a al conversor de moneda =]
                    
                    1) Dolar => Peso argentino
                    2) Peso argentino => Dolar
                    3) Dolar => Real brasileno
                    4) Real brasileno => Dolar
                    5) Dolar => Peso Colombiano
                    6) Peso Colombiano => Dolar
                    7) Salir
                    
                    Elija una opcion valida:
                    ********************************************
                    """);

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> realizarConversion("USD", "ARS");
                case 2 -> realizarConversion("ARS", "USD");
                case 3 -> realizarConversion("USD", "BRL");
                case 4 -> realizarConversion("BRL", "USD");
                case 5 -> realizarConversion("USD", "COP");
                case 6 -> realizarConversion("COP", "USD");
                case 7 -> System.out.println("Gracias por utilizar el conversor de monedas. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);
    }

    private static void realizarConversion(String monedaOrigen, String monedaDestino) {
        try {
            System.out.printf("Ingrese la cantidad de %s a convertir: ", monedaOrigen);
            double cantidad = leerCantidadPositiva();

            MonedaAPI monedaApi = consulta.buscaMoneda(monedaOrigen, monedaDestino);

            System.out.printf("%.2f %s corresponde a %.2f %s%n",
                    cantidad,
                    monedaOrigen,
                    cantidad * monedaApi.conversion_rate(),
                    monedaDestino);

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }

    private static double leerCantidadPositiva() {
        double cantidad;
        do {
            while (!lectura.hasNextDouble()) {
                System.out.println("Por favor, ingrese un número válido:");
                lectura.next();
            }
            cantidad = lectura.nextDouble();
            if (cantidad < 0) {
                System.out.println("Por favor, ingrese un valor positivo.");
            }
        } while (cantidad < 0);
        return cantidad;
    }

    private static int leerEntero() {
        while (!lectura.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido:");
            lectura.next();
        }
        return lectura.nextInt();
    }
}
