package Tarea.Clima;

import Tarea.Clima.Builder.*;
import Tarea.Clima.Core.SistemaClima;
import Tarea.Clima.Estacion.EstacionClimatica;
import Tarea.Clima.Factory.*;
import Tarea.Clima.sensor.Sensor;

/**
 * Clase Principal - Demostración de Patrones Creacionales
 * Sistema de Control de Clima
 * 
 * Patrones implementados:
 * 1. SINGLETON - SistemaClima
 * 2. FACTORY METHOD - SensorFactory
 * 3. ABSTRACT FACTORY - EstacionFactory
 * 4. BUILDER - ReporteBuilder
 * 5. PROTOTYPE - EstacionClimatica
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE CONTROL DE CLIMA - JAVA 17          ║");
        System.out.println("║   Demostración de Patrones Creacionales          ║");
        System.out.println("╚═══════════════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════════
        // 1. PATRÓN SINGLETON - Sistema Central
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n┌─────────────────────────────────────────────┐");
        System.out.println("│  1️⃣  PATRÓN SINGLETON                       │");
        System.out.println("└─────────────────────────────────────────────┘");
        
        SistemaClima sistema = SistemaClima.getInstancia();
        SistemaClima sistema2 = SistemaClima.getInstancia();
        
        System.out.println("→ Verificando instancia única:");
        System.out.println("  ¿Son la misma instancia? " + (sistema == sistema2 ? "✓ SÍ" : "✗ NO"));

        // ═══════════════════════════════════════════════════════════════
        // 2. PATRÓN FACTORY METHOD - Creación de Sensores
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n\n┌─────────────────────────────────────────────┐");
        System.out.println("│  2️⃣  PATRÓN FACTORY METHOD                  │");
        System.out.println("└─────────────────────────────────────────────┘");
        
        Sensor sensorTemp = SensorFactory.crearSensor("temperatura");
        Sensor sensorHum = SensorFactory.crearSensor("humedad");
        Sensor sensorPres = SensorFactory.crearSensor("presion");
        
        System.out.println("\n→ Sensores creados:");
        System.out.println("  • " + sensorTemp);
        System.out.println("  • " + sensorHum);
        System.out.println("  • " + sensorPres);

        // ═══════════════════════════════════════════════════════════════
        // 3. PATRÓN ABSTRACT FACTORY - Creación de Estaciones
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n\n┌─────────────────────────────────────────────┐");
        System.out.println("│  3️⃣  PATRÓN ABSTRACT FACTORY                │");
        System.out.println("└─────────────────────────────────────────────┘");
        
        // Estación Básica
        EstacioFactory factoryBasica = new EstacionBasicafactory();
        EstacionClimatica estacionBasica = new EstacionClimatica(1, "Centro de Lima");
        estacionBasica.configurarConFactory(factoryBasica);
        sistema.registrarEstacion(estacionBasica);
        
        // Estación Profesional
        EstacioFactory factoryProfesional = new EstacionProfecionalFactory();
        EstacionClimatica estacionProfesional = new EstacionClimatica(2, "Aeropuerto Jorge Chávez");
        estacionProfesional.configurarConFactory(factoryProfesional);
        sistema.registrarEstacion(estacionProfesional);

        // ═══════════════════════════════════════════════════════════════
        // 4. PATRÓN PROTOTYPE - Clonación de Estaciones
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n\n┌─────────────────────────────────────────────┐");
        System.out.println("│  4️⃣  PATRÓN PROTOTYPE                       │");
        System.out.println("└─────────────────────────────────────────────┘");
        
        EstacionClimatica estacionClonada = estacionProfesional.clone();
        estacionClonada.setId(3);
        estacionClonada.setUbicacion("Costa Verde - Miraflores");
        sistema.registrarEstacion(estacionClonada);
        
        System.out.println("✓ Estación clonada creada exitosamente");
        System.out.println("\n→ Comparación:");
        System.out.println("  Original: " + estacionProfesional.getUbicacion());
        System.out.println("  Clonada:  " + estacionClonada.getUbicacion());
        System.out.println("  ¿Son el mismo objeto? " + 
            (estacionProfesional == estacionClonada ? "SÍ" : "✓ NO (clonación exitosa)"));

        // ═══════════════════════════════════════════════════════════════
        // Obtener datos climáticos de todas las estaciones
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n\n┌─────────────────────────────────────────────┐");
        System.out.println("│  📊 RECOLECCIÓN DE DATOS CLIMÁTICOS         │");
        System.out.println("└─────────────────────────────────────────────┘");
        
        sistema.consultarClima();

        // ═══════════════════════════════════════════════════════════════
        // 5. PATRÓN BUILDER - Generación de Reportes
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n\n┌─────────────────────────────────────────────┐");
        System.out.println("│  5️⃣  PATRÓN BUILDER                         │");
        System.out.println("└─────────────────────────────────────────────┘");
        
        // Reporte en PDF
        System.out.println("\n→ Construyendo Reporte PDF:");
        reporteBuilder builderPDF = new ReportePDFBuilder();
        DirectorReporte director = new DirectorReporte(builderPDF);
        Reporte reportePDF = director.construirReporte(
            "Reporte Mensual",
            "Datos climáticos de " + sistema.getHistorialClimatico().size() + " registros",
            "Sistema Clima v1.0"
        );
        reportePDF.mostrar();
        
        // Reporte en Excel
        System.out.println("\n→ Construyendo Reporte Excel:");
        reporteBuilder builderExcel = new ReporteExcelBuilder();
        director.setBuilder(builderExcel);
        Reporte reporteExcel = director.construirReporte(
            "Reporte Semanal",
            "Estadísticas de " + sistema.getEstaciones().size() + " estaciones",
            "Sistema Clima v1.0"
        );
        reporteExcel.mostrar();

        // ═══════════════════════════════════════════════════════════════
        // Reporte Final del Sistema
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║            REPORTE FINAL DEL SISTEMA              ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        sistema.generarReporte();

        // ═══════════════════════════════════════════════════════════════
        // Resumen de Patrones Utilizados
        // ═══════════════════════════════════════════════════════════════
        System.out.println("\n\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║        PATRONES CREACIONALES IMPLEMENTADOS        ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println("\n✓ SINGLETON       → SistemaClima (instancia única)");
        System.out.println("✓ FACTORY METHOD  → SensorFactory (crea sensores)");
        System.out.println("✓ ABSTRACT FACTORY→ EstacionFactory (familias de productos)");
        System.out.println("✓ BUILDER         → ReporteBuilder (construcción paso a paso)");
        System.out.println("✓ PROTOTYPE       → EstacionClimatica (clonación de objetos)");
        System.out.println("\n════════════════════════════════════════════════════\n");
    }
}
