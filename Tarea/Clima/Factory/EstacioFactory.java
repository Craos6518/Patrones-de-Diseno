package Tarea.Clima.Factory;

import Tarea.Clima.sensor.*;

/**
 * Patrón ABSTRACT FACTORY - Interfaz de Fábrica de Estaciones
 * Define métodos para crear familias de sensores
 */
public interface EstacioFactory {
    Sensor crearSensorTemperatura();
    Sensor crearSensorHumedad();
    Sensor crearSensorPresion();
    Sensor crearSensorViento();
    String getTipoEstacion();
}
