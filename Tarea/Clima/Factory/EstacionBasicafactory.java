package Tarea.Clima.Factory;

import Tarea.Clima.sensor.*;

/**
 * Patrón ABSTRACT FACTORY - Fábrica de Estación Básica
 * Crea sensores estándar (temperatura y humedad)
 */
public class EstacionBasicafactory implements EstacioFactory {
    
    @Override
    public Sensor crearSensorTemperatura() {
        System.out.println("  → AbstractFactory (Básica): Creando sensor de temperatura");
        return new Sensortemperatura();
    }
    
    @Override
    public Sensor crearSensorHumedad() {
        System.out.println("  → AbstractFactory (Básica): Creando sensor de humedad");
        return new SensorHumedad();
    }
    
    @Override
    public Sensor crearSensorPresion() {
        // Las estaciones básicas no tienen sensor de presión
        System.out.println("  ➔ AbstractFactory (Básica): Sensor de presión NO disponible");
        return null;
    }
    
    @Override
    public Sensor crearSensorViento() {
        // Las estaciones básicas no tienen sensor de viento
        System.out.println("  ➔ AbstractFactory (Básica): Sensor de viento NO disponible");
        return null;
    }
    
    @Override
    public String getTipoEstacion() {
        return "Estación Básica";
    }
}
