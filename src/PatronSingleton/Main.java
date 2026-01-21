package PatronSingleton;

import java.util.Scanner;

/**
 * @author Juan Coronado
 */

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Pedimos al usuario que ingrese el monto en dólares
        System.out.print("Ingrese el monto de la compra en dolares: ");
        double monto = scanner.nextDouble();

        // Obtenemos la instancia del gestor (Singleton)
        Gestor gestor = Gestor.getInstancia();

        // Procesamos el pago con el monto proporcionado
        gestor.procesarPago(monto);
        
        // Comprobamos si efectivamente se trata de una única instancia
        Gestor gestor2 = Gestor.getInstancia();
        if (gestor == gestor2) {
            System.out.println("El patron Singleton funciona. Ambas referencias apuntan a la misma instancia.");
        } else {
            System.out.println("Error: Hay más de una instancia de Gestor.");
        }

        scanner.close();
    }
}