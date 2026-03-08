package Tarea.Clima.Builder;

/**
 * Patrón BUILDER - Producto: Reporte Climático
 * Representa el objeto complejo que se construirá
 */
public class Reporte {
    private String encabezado;
    private String datos;
    private String pie;
    private String formato;

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void mostrar() {
        System.out.println("\n╭───────────────────────────────────────╮");
        System.out.println("│    REPORTE CLIMÁTICO - " + formato + "    │");
        System.out.println("╰───────────────────────────────────────╯");
        System.out.println("\n" + encabezado);
        System.out.println("\n" + datos);
        System.out.println("\n" + pie);
        System.out.println("\n───────────────────────────────────────\n");
    }

    @Override
    public String toString() {
        return String.format(
            "Reporte [%s]\n%s\n%s\n%s",
            formato, encabezado, datos, pie
        );
    }
}
