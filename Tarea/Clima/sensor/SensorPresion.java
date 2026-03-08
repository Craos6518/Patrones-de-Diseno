package Tarea.Clima.sensor;

import java.util.Random;

/**
 * Sensor de presión atmosférica que simula lecturas entre 950 y 1050 hPa
 */
public class SensorPresion extends Sensor {
    private Random random;

    public SensorPresion() {
        super("Presión", "hPa");
        this.random = new Random();
    }

    @Override
    public float leerDato() {
        // Simula lecturas de presión entre 950 y 1050 hPa
        return 950 + random.nextFloat() * 100;
    }
}
