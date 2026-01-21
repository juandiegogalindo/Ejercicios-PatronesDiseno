/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronProxy;

/**
 *
 * @author jdgal
 */
public class SolicitudAnulacion implements AnularDescuento {
    @Override
    public void solicitarAnulacion(double monto) {
        // Simulación de la anulación del descuento
        System.out.println("Se ha anulado un descuento de $" + monto);
    }
}
