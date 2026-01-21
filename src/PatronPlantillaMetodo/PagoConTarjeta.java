/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronPlantillaMetodo;

/**
 *
 * @author jdgal
 */
abstract class PagoConTarjeta {
    protected double montoCompra; // Monto total de la compra
    protected double saldoDisponible; // Saldo del usuario
    protected double cargosAdicionales = 0; // Cargos adicionales específicos

    // Método plantilla que define el proceso de pago
    public final void procesarPago() {
        validarTarjeta();
        verificarFondos();
        if (saldoDisponible >= (montoCompra + cargosAdicionales)) {
            realizarCobro();
            confirmarTransaccion();
        } else {
            System.out.println("Fondos insuficientes para realizar el pago.");
        }
    }

    // Pasos comunes implementados en la clase base
    protected void verificarFondos() {
        System.out.println("Verificando fondos en la cuenta...");
        System.out.println("Saldo disponible: $" + saldoDisponible);
        System.out.println("Cargos adicionales: $" + cargosAdicionales);
        System.out.println("Monto total a cobrar (incluyendo cargos): $" + (montoCompra + cargosAdicionales));
    }

    protected void realizarCobro() {
        System.out.println("Realizando cobro de $" + (montoCompra + cargosAdicionales) + " a la tarjeta de crédito...");
        saldoDisponible -= (montoCompra + cargosAdicionales); // Actualiza saldo
    }

    protected void confirmarTransaccion() {
        System.out.println("Transacción confirmada. Nuevo saldo: $" + saldoDisponible);
    }

    // Métodos abstractos que deben ser implementados por las subclases
    protected abstract void validarTarjeta();

    // Método gancho que puede ser opcionalmente sobrescrito
    protected void calcularCargosAdicionales() {
        // En el caso base no hay cargos adicionales
    }
}