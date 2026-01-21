/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PatronPlantillaMetodo;

import java.util.Scanner;

/**
 *
 * @author jdgal
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese el tipo de tarjeta
        System.out.println("Ingrese el tipo de tarjeta (Visa o MasterCard): ");
        String tipoTarjeta = scanner.nextLine().toLowerCase();

        // Pedir el monto de la compra
        System.out.println("Ingrese el monto de la compra en dólares: ");
        double montoCompra = scanner.nextDouble();

        // Pedir el saldo disponible en la cuenta del usuario
        System.out.println("Ingrese el saldo disponible en su cuenta: ");
        double saldoDisponible = scanner.nextDouble();

        // Crear la instancia correspondiente según el tipo de tarjeta
        PagoConTarjeta pago = null;
        if (tipoTarjeta.equals("visa")) {
            pago = new PagoConVisa();
        } else if (tipoTarjeta.equals("mastercard")) {
            pago = new PagoConMasterCard();
        } else {
            System.out.println("Tipo de tarjeta no válido.");
            scanner.close();
            return;
        }

        // Asignar el monto de la compra y el saldo disponible al objeto de pago
        pago.montoCompra = montoCompra;
        pago.saldoDisponible = saldoDisponible;

        // Calcular cargos adicionales
        pago.calcularCargosAdicionales();

        // Procesar el pago utilizando el método plantilla
        System.out.println("\nProcesando pago...");
        pago.procesarPago();

        // Cerrar el scanner
        scanner.close();
    }
}