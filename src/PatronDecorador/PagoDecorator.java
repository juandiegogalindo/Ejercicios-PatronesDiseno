/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronDecorador;

/**
 *
 * @author jdgal
 */
// Clase abstracta que implementa la interfaz Pago
public abstract class PagoDecorator implements Pago {
    protected Pago pago;

    public PagoDecorator(Pago pago) {
        this.pago = pago;
    }

    @Override
    public double costo() {
        return pago.costo(); // Delegación al pago existente
    }

    @Override
    public String descripcion() {
        return pago.descripcion(); // Delegación a la descripción del pago existente
    }
}
