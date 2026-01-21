/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PatronDecorador;

/**
 *
 * @author jdgal
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Pedimos al usuario que ingrese el monto de la compra
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto de la compra en dólares: ");
        double monto = scanner.nextDouble();

        // Creamos un pago básico
        Pago pago = new PagoBasico(monto);
        System.out.println(pago.descripcion() + " - Costo total: $" + pago.costo());

        // Agregamos una tarifa de transacción
        double tarifaTransaccion = 2.0; // Ejemplo de tarifa
        pago = new TarifaTransaccion(pago, tarifaTransaccion);
        System.out.println(pago.descripcion() + " - Costo total: $" + pago.costo());

        // Agregamos una tarifa de conversión
        double tarifaConversion = 1.5; // Ejemplo de tarifa
        pago = new TarifaConversion(pago, tarifaConversion);
        System.out.println(pago.descripcion() + " - Costo total: $" + pago.costo());

        scanner.close();
    }
}
