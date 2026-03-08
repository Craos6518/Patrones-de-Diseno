package Tarea.Clima.Builder;

/**
 * Patrón BUILDER - Constructor Concreto para Excel
 * Implementa la construcción de reportes en formato Excel
 */
public class ReporteExcelBuilder implements reporteBuilder {
    private Reporte reporte;

    public ReporteExcelBuilder() {
        this.reporte = new Reporte();
        this.reporte.setFormato("EXCEL");
    }

    @Override
    public void buildEncabezado(String titulo, String fecha) {
        String encabezado = String.format(
            "╔═══════════ EXCEL ══════════╗\n" +
            "║  %s  ║\n" +
            "║  Fecha: %s           ║\n" +
            "╚════════════════════════════╝",
            titulo, fecha
        );
        reporte.setEncabezado(encabezado);
        System.out.println("✓ Builder Excel: Encabezado construido");
    }

    @Override
    public void buildDatos(String contenido) {
        String datos = "╔═ HOJA DE CÁLCULO ═════════╗\n" +
                      "║ " + contenido + "    ║\n" +
                      "╚════════════════════════════╝";
        reporte.setDatos(datos);
        System.out.println("✓ Builder Excel: Datos en celdas");
    }

    @Override
    public void buildPie(String firma) {
        String pie = "[EXCEL] Generado por: " + firma + " | Formato: Microsoft Excel (.xlsx)";
        reporte.setPie(pie);
        System.out.println("✓ Builder Excel: Pie de página agregado");
    }

    @Override
    public Reporte getReporte() {
        return this.reporte;
    }
}
