package Tarea.Clima.Core;

import Tarea.Clima.Estacion.EstacionClimatica;
import Tarea.Clima.Estacion.RegistroClimatico;
import java.util.ArrayList;
import java.util.List;

/**
 * Patrón SINGLETON - Sistema Central de Control de Clima
 * Garantiza una única instancia del sistema
 */
public class SistemaClima {
    private static SistemaClima instancia;
    private List<EstacionClimatica> estaciones;
    private List<RegistroClimatico> historialClimatico;

    /**
     * Constructor privado para evitar instanciación externa
     */
    private SistemaClima() {
        this.estaciones = new ArrayList<>();
        this.historialClimatico = new ArrayList<>();
        System.out.println("✓ Sistema de Clima inicializado (Singleton)");
    }

    /**
     * Método para obtener la única instancia del sistema
     * @return instancia única de SistemaClima
     */
    public static synchronized SistemaClima getInstancia() {
        if (instancia == null) {
            instancia = new SistemaClima();
        }
        return instancia;
    }

    /**
     * Registra una estación climática en el sistema
     */
    public void registrarEstacion(EstacionClimatica estacion) {
        estaciones.add(estacion);
        System.out.println("✓ Estación registrada: " + estacion.getUbicacion());
    }

    /**
     * Registra un dato climático en el historial
     */
    public void registrarDato(RegistroClimatico registro) {
        historialClimatico.add(registro);
        System.out.println("✓ Dato climático registrado");
    }

    /**
     * Consulta el clima actual de todas las estaciones
     */
    public void consultarClima() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("      CONSULTA DE CLIMA ACTUAL");
        System.out.println("═══════════════════════════════════════");
        
        if (estaciones.isEmpty()) {
            System.out.println("No hay estaciones registradas");
            return;
        }

        for (EstacionClimatica estacion : estaciones) {
            estacion.obtenerDatos();
        }
    }

    /**
     * Genera un reporte climático
     */
    public void generarReporte() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("      REPORTE CLIMÁTICO GENERAL");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Total de estaciones: " + estaciones.size());
        System.out.println("Total de registros históricos: " + historialClimatico.size());
        
        if (!historialClimatico.isEmpty()) {
            System.out.println("\nÚltimos registros:");
            int limite = Math.min(3, historialClimatico.size());
            for (int i = historialClimatico.size() - limite; i < historialClimatico.size(); i++) {
                System.out.println("\n" + historialClimatico.get(i));
            }
        }
    }

    public List<EstacionClimatica> getEstaciones() {
        return new ArrayList<>(estaciones);
    }

    public List<RegistroClimatico> getHistorialClimatico() {
        return new ArrayList<>(historialClimatico);
    }
}
