package Tarea.Clima.sensor;

import java.util.Random;

/**
 * Sensor de humedad que simula lecturas entre 0 y 100%
 */
public class SensorHumedad extends Sensor {
    private Random random;

    public SensorHumedad() {
        super("Humedad", "%");
        this.random = new Random();
    }

    @Override
    public float leerDato() {
        // Simula lecturas de humedad entre 0 y 100%
        return random.nextFloat() * 100;
    }
}
