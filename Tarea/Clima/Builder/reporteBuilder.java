package Tarea.Clima.Builder;

/**
 * Patrón BUILDER - Interfaz Builder
 * Define los pasos para construir un reporte
 */
public interface reporteBuilder {
    void buildEncabezado(String titulo, String fecha);
    void buildDatos(String contenido);
    void buildPie(String firma);
    Reporte getReporte();
}
