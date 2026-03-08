package Tarea.Clima.Builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Patrón BUILDER - Director
 * Orquesta la construcción de reportes usando el builder
 */
public class DirectorReporte {
    private reporteBuilder builder;

    public DirectorReporte(reporteBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(reporteBuilder builder) {
        this.builder = builder;
    }

    /**
     * Construye un reporte climático completo
     */
    public Reporte construirReporte(String titulo, String contenido, String firma) {
        System.out.println("\n→ Director: Iniciando construcción de reporte...");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fecha = LocalDateTime.now().format(formatter);
        
        builder.buildEncabezado(titulo, fecha);
        builder.buildDatos(contenido);
        builder.buildPie(firma);
        
        System.out.println("✓ Director: Reporte construido exitosamente\n");
        return builder.getReporte();
    }

    /**
     * Construye un reporte rápido solo con datos esenciales
     */
    public Reporte construirReporteRapido(String contenido) {
        System.out.println("\n→ Director: Construcción rápida...");
        
        builder.buildEncabezado("Reporte Rápido", "Ahora");
        builder.buildDatos(contenido);
        
        System.out.println("✓ Director: Reporte rápido completado\n");
        return builder.getReporte();
    }
}
