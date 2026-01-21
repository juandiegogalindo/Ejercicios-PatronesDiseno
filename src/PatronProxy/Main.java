/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PatronProxy;

/**
 *
 * @author jdgal
 */
import PatronProxy.Proxy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario si tiene permisos o no
        System.out.println("¿Tiene permisos para anular descuentos? (si/no): ");
        String respuestaPermiso = scanner.nextLine();
        boolean tienePermiso = respuestaPermiso.equalsIgnoreCase("si");

        // Crear el proxy basado en si el usuario tiene permisos o no
        AnularDescuento proxy = new Proxy(tienePermiso);

        // Iniciar el proceso de solicitud de anulación
        System.out.println("Desea solicitar la anulación de un descuento? (si/no): ");
        String respuestaSolicitud = scanner.nextLine();

        if (respuestaSolicitud.equalsIgnoreCase("si")) {
            // Solicitar el monto del descuento
            System.out.println("Ingrese el monto del descuento a anular: ");
            double montoDescuento = scanner.nextDouble();

            // Intentar procesar la anulación a través del proxy
            proxy.solicitarAnulacion(montoDescuento);
        } else {
            System.out.println("No se ha solicitado la anulación.");
        }

        scanner.close();
    }
}
