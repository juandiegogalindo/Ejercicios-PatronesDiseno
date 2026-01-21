/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronPlantillaMetodo;

/**
 *
 * @author jdgal
 */
public class PagoConVisa extends PagoConTarjeta {
    @Override
    protected void validarTarjeta() {
        System.out.println("Validando tarjeta Visa...");
        // Aquí irían las reglas específicas de validación para Visa
    }

    @Override
    protected void calcularCargosAdicionales() {
        cargosAdicionales = montoCompra * 0.02; // Aplicar un cargo del 2% para Visa
        System.out.println("Aplicando un cargo adicional del 2% para pagos en dólares con Visa...");
    }
}
