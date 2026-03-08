package Tarea.Clima.Factory;

import Tarea.Clima.sensor.*;

/**
 * Patrón FACTORY METHOD - Fábrica de Sensores
 * Crea diferentes tipos de sensores según el tipo solicitado
 */
public class SensorFactory {
    
    /**
     * Crea un sensor del tipo especificado
     * @param tipo "temperatura", "humedad" o "presion"
     * @return instancia del sensor solicitado
     */
    public static Sensor crearSensor(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo de sensor no puede ser nulo o vacío");
        }
        
        return switch (tipo.toLowerCase()) {
            case "temperatura" -> {
                System.out.println("→ Factory: Creando sensor de temperatura");
                yield new Sensortemperatura();
            }
            case "humedad" -> {
                System.out.println("→ Factory: Creando sensor de humedad");
                yield new SensorHumedad();
            }
            case "presion" -> {
                System.out.println("→ Factory: Creando sensor de presión");
                yield new SensorPresion();
            }
            default -> throw new IllegalArgumentException(
                "Tipo de sensor desconocido: " + tipo + ". " +
                "Tipos válidos: temperatura, humedad, presion"
            );
        };
    }
}
