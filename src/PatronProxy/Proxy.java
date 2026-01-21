/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronProxy;

/**
 *
 * @author jdgal
 */
import PatronProxy.SolicitudAnulacion;
import java.util.Scanner;

public class Proxy implements AnularDescuento {
    private SolicitudAnulacion solicitudAnulacion;  // Referencia al objeto real
    private boolean permiso;  // Control de acceso o validación

    // Constructor del proxy con control de acceso
    public Proxy(boolean permiso) {
        this.permiso = permiso;
    }

    @Override
    public void solicitarAnulacion(double monto) {
        // Validar si el cliente tiene permiso para realizar la acción
        if (permiso) {
            if (solicitudAnulacion == null) {
                // Crear el objeto real solo cuando sea necesario (Proxy virtual)
                solicitudAnulacion = new SolicitudAnulacion();
            }
            // Delegar la llamada al objeto real
            solicitudAnulacion.solicitarAnulacion(monto);
        } else {
            System.out.println("Acceso denegado: No tiene permisos para anular el descuento.");
        }
    }
}
