/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronDecorador;

/**
 *
 * @author jdgal
 */
// Decorador para agregar una tarifa por transacción
public class TarifaTransaccion extends PagoDecorator {
    private double tarifa;

    public TarifaTransaccion(Pago pago, double tarifa) {
        super(pago);
        this.tarifa = tarifa;
    }

    @Override
    public double costo() {
        return super.costo() + tarifa; // Añade la tarifa al costo total
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", incluyendo tarifa de transacción de $" + tarifa;
    }
}
