/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronObservador;

public class Gestor extends Subject {

    private double montoCompra;

    // Método para procesar el pago y notificar a los observadores
    public void procesarPago(double monto) {
        this.montoCompra = monto;
        System.out.println("Procesando pago de $" + monto + " dólares...");
        notificarObservadores(monto); // Notifica a todos los observadores del cambio
    }
}
