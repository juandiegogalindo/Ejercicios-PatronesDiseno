/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronDecorador;

/**
 *
 * @author jdgal
 */
// Clase que representa un pago básico
public class PagoBasico implements Pago {
    private double monto;

    public PagoBasico(double monto) {
        this.monto = monto;
    }

    @Override
    public double costo() {
        return monto; // El costo es el monto total de la compra
    }

    @Override
    public String descripcion() {
        return "Pago de $" + monto; // Descripción básica del pago
    }
}
