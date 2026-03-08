package Tarea.Clima.Factory;

import Tarea.Clima.sensor.*;

/**
 * Patrón ABSTRACT FACTORY - Fábrica de Estación Profesional
 * Crea sensores avanzados (todos los tipos)
 */
public class EstacionProfecionalFactory implements EstacioFactory {
    
    @Override
    public Sensor crearSensorTemperatura() {
        System.out.println("  → AbstractFactory (Profesional): Creando sensor de temperatura de precisión");
        return new Sensortemperatura();
    }
    
    @Override
    public Sensor crearSensorHumedad() {
        System.out.println("  → AbstractFactory (Profesional): Creando sensor de humedad de precisión");
        return new SensorHumedad();
    }
    
    @Override
    public Sensor crearSensorPresion() {
        System.out.println("  → AbstractFactory (Profesional): Creando sensor de presión barométrica");
        return new SensorPresion();
    }
    
    @Override
    public Sensor crearSensorViento() {
        System.out.println("  → AbstractFactory (Profesional): Creando anemómetro");
        return new SensorViento();
    }
    
    @Override
    public String getTipoEstacion() {
        return "Estación Profesional";
    }
}
