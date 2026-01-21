/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronObservador;

/**
 *
 * @author jdgal
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    // Lista de observadores que están suscritos al sujeto
    private List<Observer> observadores = new ArrayList<>();

    // Método para agregar un observador
    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    // Método para eliminar un observador
    public void eliminarObservador(Observer observador) {
        observadores.remove(observador);
    }

    // Método para notificar a todos los observadores cuando ocurra un cambio
    public void notificarObservadores(double monto) {
        for (Observer observador : observadores) {
            observador.actualizar(monto);
        }
    }
}
