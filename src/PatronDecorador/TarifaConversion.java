/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronDecorador;

/**
 *
 * @author jdgal
 */

// Decorador para agregar una tarifa de conversión
public class TarifaConversion extends PagoDecorator {
    private double tarifa;

    public TarifaConversion(Pago pago, double tarifa) {
        super(pago);
        this.tarifa = tarifa;
    }

    @Override
    public double costo() {
        return super.costo() + tarifa; // Añade la tarifa de conversión al costo total
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", incluyendo tarifa de conversión de $" + tarifa;
    }
}
