/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronObservador;

/**
 *
 * @author jdgal
 */
public class Cliente implements Observer {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    // Implementa el método para recibir actualizaciones
    @Override
    public void actualizar(double monto) {
        System.out.println(nombre + " ha sido notificado del pago de $" + monto + " dólares.");
    }
}
