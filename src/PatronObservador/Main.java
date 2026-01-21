/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PatronObservador;

/**
 *
 * @author jdgal
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Creamos el gestor (sujeto) y los observadores (clientes)
        Gestor gestor = new Gestor();
        Cliente cliente1 = new Cliente("Juan");
        Cliente cliente2 = new Cliente("Diego");

        // Registramos los observadores al gestor
        gestor.agregarObservador(cliente1);
        gestor.agregarObservador(cliente2);

        // Pedimos al usuario que ingrese el monto de la compra
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto de la compra en dólares: ");
        double monto = scanner.nextDouble();

        // Procesamos el pago, lo que notificará a todos los observadores
        gestor.procesarPago(monto);

        scanner.close();
    }
}
