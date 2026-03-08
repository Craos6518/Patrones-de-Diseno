package Tarea.Clima.Prototype;

import Tarea.Clima.Estacion.EstacionClimatica;

/**
 * Patrón PROTOTYPE - Interfaz de Clonación
 * Define el método para clonar estaciones
 */
public interface ClonableEstacion {
    EstacionClimatica clone();
}
