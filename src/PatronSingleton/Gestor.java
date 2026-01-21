package PatronSingleton;

/**
 * @author Juan Coronado
 */

import java.util.Scanner;

public class Gestor {

    // 1. Atributo estático privado de la única instancia
    private static Gestor instanciaUnica;

    // 2. Constructor privado para evitar la creación de objetos externos
    private Gestor() {
        // Inicializaciones necesarias
    }

    // 3. Método estático para devolver la única instancia
    public static Gestor getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Gestor();
        }
        return instanciaUnica;
    }

    // Método para procesar el pago en dólares
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " dolares...");
        // Simulamos el procesamiento del pago
        System.out.println("Pago procesado exitosamente.");
    }
}