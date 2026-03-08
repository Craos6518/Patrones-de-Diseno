package Tarea.Clima.sensor;

import java.util.Random;

/**
 * Sensor de velocidad del viento que simula lecturas entre 0 y 120 km/h
 */
public class SensorViento extends Sensor {
    private Random random;

    public SensorViento() {
        super("Velocidad del Viento", "km/h");
        this.random = new Random();
    }

    @Override
    public float leerDato() {
        // Simula lecturas de velocidad del viento entre 0 y 120 km/h
        return random.nextFloat() * 120;
    }
}
