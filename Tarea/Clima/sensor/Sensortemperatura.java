package Tarea.Clima.sensor;

import java.util.Random;

/**
 * Sensor de temperatura que simula lecturas entre -10 y 40 grados Celsius
 */
public class Sensortemperatura extends Sensor {
    private Random random;

    public Sensortemperatura() {
        super("Temperatura", "°C");
        this.random = new Random();
    }

    @Override
    public float leerDato() {
        // Simula lecturas de temperatura entre -10 y 40 grados
        return -10 + random.nextFloat() * 50;
    }
}
