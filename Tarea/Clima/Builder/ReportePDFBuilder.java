package Tarea.Clima.Builder;

/**
 * Patrón BUILDER - Constructor Concreto para PDF
 * Implementa la construcción de reportes en formato PDF
 */
public class ReportePDFBuilder implements reporteBuilder {
    private Reporte reporte;

    public ReportePDFBuilder() {
        this.reporte = new Reporte();
        this.reporte.setFormato("PDF");
    }

    @Override
    public void buildEncabezado(String titulo, String fecha) {
        String encabezado = String.format(
            "╭──────────── PDF ────────────╮\n" +
            "│  %s  │\n" +
            "│  Fecha: %s           │\n" +
            "╰──────────────────────────────╯",
            titulo, fecha
        );
        reporte.setEncabezado(encabezado);
        System.out.println("✓ Builder PDF: Encabezado construido");
    }

    @Override
    public void buildDatos(String contenido) {
        String datos = "╭─ CONTENIDO ────────────────╮\n" +
                      "│ " + contenido + "    │\n" +
                      "╰───────────────────────────╯";
        reporte.setDatos(datos);
        System.out.println("✓ Builder PDF: Datos incorporados");
    }

    @Override
    public void buildPie(String firma) {
        String pie = "[PDF] Generado por: " + firma + " | Formato: Adobe PDF";
        reporte.setPie(pie);
        System.out.println("✓ Builder PDF: Pie de página agregado");
    }

    @Override
    public Reporte getReporte() {
        return this.reporte;
    }
}
