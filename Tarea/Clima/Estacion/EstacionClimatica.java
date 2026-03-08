package Tarea.Clima.Estacion;

import Tarea.Clima.Factory.EstacioFactory;
import Tarea.Clima.Prototype.ClonableEstacion;
import Tarea.Clima.sensor.Sensor;
import Tarea.Clima.Core.SistemaClima;

import java.util.ArrayList;
import java.util.List;

/**
 * Patrón PROTOTYPE - Estación Climática Clonable
 * Representa una estación meteorológica que puede ser clonada
 */
public class EstacionClimatica implements ClonableEstacion {
    private int id;
    private String ubicacion;
    private List<Sensor> sensores;
    private String tipoEstacion;

    public EstacionClimatica(int id, String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.sensores = new ArrayList<>();
        this.tipoEstacion = "Genérica";
    }

    /**
     * Constructor privado para clonación
     */
    private EstacionClimatica(int id, String ubicacion, List<Sensor> sensores, String tipoEstacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.sensores = new ArrayList<>(sensores);
        this.tipoEstacion = tipoEstacion;
    }

    /**
     * Configura la estación usando Abstract Factory
     */
    public void configurarConFactory(EstacioFactory factory) {
        System.out.println("\n╭──────────────────────────────────╮");
        System.out.println("│  Configurando: " + ubicacion);
        System.out.println("╰──────────────────────────────────╯");
        
        this.tipoEstacion = factory.getTipoEstacion();
        
        Sensor temp = factory.crearSensorTemperatura();
        if (temp != null) sensores.add(temp);
        
        Sensor hum = factory.crearSensorHumedad();
        if (hum != null) sensores.add(hum);
        
        Sensor pres = factory.crearSensorPresion();
        if (pres != null) sensores.add(pres);
        
        Sensor viento = factory.crearSensorViento();
        if (viento != null) sensores.add(viento);
        
        System.out.println("✓ Configuración completada: " + sensores.size() + " sensores activos\n");
    }

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    /**
     * Obtiene datos de todos los sensores y crea un registro climático
     */
    public RegistroClimatico obtenerDatos() {
        System.out.println("\n┌──────────────────────────────────┐");
        System.out.println("│ Estación: " + ubicacion);
        System.out.println("│ Tipo: " + tipoEstacion);
        System.out.println("└──────────────────────────────────┘");
        
        float temperatura = 0, humedad = 0, presion = 1013, velocidadViento = 0;
        
        for (Sensor sensor : sensores) {
            float valor = sensor.leerDato();
            System.out.printf("  %s: %.2f %s%n", 
                sensor.getTipoSensor(), valor, sensor.getUnidad());
            
            switch (sensor.getTipoSensor()) {
                case "Temperatura" -> temperatura = valor;
                case "Humedad" -> humedad = valor;
                case "Presión" -> presion = valor;
                case "Velocidad del Viento" -> velocidadViento = valor;
            }
        }
        
        RegistroClimatico registro = new RegistroClimatico(
            temperatura, humedad, presion, velocidadViento
        );
        
        // Registrar en el sistema
        SistemaClima.getInstancia().registrarDato(registro);
        
        return registro;
    }

    /**
     * Patrón PROTOTYPE - Método de clonación
     * Crea una copia profunda de la estación
     */
    @Override
    public EstacionClimatica clone() {
        System.out.println("→ Prototype: Clonando estación '" + ubicacion + "'...");
        return new EstacionClimatica(this.id, this.ubicacion, this.sensores, this.tipoEstacion);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoEstacion() {
        return tipoEstacion;
    }

    @Override
    public String toString() {
        return String.format(
            "Estación #%d [%s]\n  Ubicación: %s\n  Sensores: %d",
            id, tipoEstacion, ubicacion, sensores.size()
        );
    }
}
