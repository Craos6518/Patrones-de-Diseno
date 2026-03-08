package Tarea.Clima.sensor;

/**
 * Clase abstracta base para todos los sensores
 */
public abstract class Sensor {
    protected String tipoSensor;
    protected String unidad;

    public Sensor(String tipoSensor, String unidad) {
        this.tipoSensor = tipoSensor;
        this.unidad = unidad;
    }

    /**
     * Método abstracto para leer datos del sensor
     * @return valor leído del sensor
     */
    public abstract float leerDato();

    public String getTipoSensor() {
        return tipoSensor;
    }

    public String getUnidad() {
        return unidad;
    }

    @Override
    public String toString() {
        return String.format("Sensor: %s [%s]", tipoSensor, unidad);
    }
}
