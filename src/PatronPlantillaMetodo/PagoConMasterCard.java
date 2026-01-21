/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronPlantillaMetodo;

/**
 *
 * @author jdgal
 */
public class PagoConMasterCard extends PagoConTarjeta {
    @Override
    protected void validarTarjeta() {
        System.out.println("Validando tarjeta MasterCard...");
        // Aquí irían las reglas específicas de validación para MasterCard
    }

    @Override
    protected void calcularCargosAdicionales() {
        cargosAdicionales = montoCompra * 0.015; // Aplicar un cargo del 1.5% para MasterCard
        System.out.println("Aplicando un cargo adicional del 1.5% para pagos en dólares con MasterCard...");
    }
}