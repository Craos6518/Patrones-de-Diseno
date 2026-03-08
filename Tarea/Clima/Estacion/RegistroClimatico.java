package Tarea.Clima.Estacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un registro climático
 * Almacena temperatura, humedad, presión y velocidad del viento
 */
public class RegistroClimatico {
    private float temperatura;
    private float humedad;
    private float presion;
    private float velocidadViento;
    private LocalDateTime fechaHora;

    public RegistroClimatico(float temperatura, float humedad, float presion, float velocidadViento) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
        this.velocidadViento = velocidadViento;
        this.fechaHora = LocalDateTime.now();
    }

    // Getters
    public float getTemperatura() {
        return temperatura;
    }

    public float getHumedad() {
        return humedad;
    }

    public float getPresion() {
        return presion;
    }

    public float getVelocidadViento() {
        return velocidadViento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format(
            "Registro Climático [%s]\n" +
            "  Temperatura: %.2f°C\n" +
            "  Humedad: %.2f%%\n" +
            "  Presión: %.2f hPa\n" +
            "  Velocidad del Viento: %.2f km/h",
            fechaHora.format(formatter),
            temperatura,
            humedad,
            presion,
            velocidadViento
        );
    }
}
