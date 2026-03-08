# Guía de Uso - Sistema de Control de Clima

## 🎯 Resumen del Sistema

El sistema implementa **5 patrones de diseño creacionales** del Gang of Four (GoF) para gestionar un sistema de control de clima completo en Java 17.

---

## 📦 Estructura de Archivos

```
Tarea/Clima/
│
├── 📄 Main.java                          ← Clase principal ejecutable
├── 📄 README.md                          ← Documentación completa
├── 📄 GUIA_USO.md                        ← Esta guía
├── 📄 DiagramaClaseGeneral.puml          ← Diagrama UML general
├── 📄 PatronesSeparados.puml             ← Diagramas por patrón
│
├── 📁 Core/
│   └── SistemaClima.java                 ← ⭐ SINGLETON
│
├── 📁 Estacion/
│   ├── EstacionClimatica.java            ← ⭐ PROTOTYPE
│   └── RegistroClimatico.java            ← Modelo de datos
│
├── 📁 sensor/
│   ├── Sensor.java                       ← Clase abstracta
│   ├── Sensortemperatura.java
│   ├── SensorHumedad.java
│   ├── SensorPresion.java
│   └── SensorViento.java
│
├── 📁 Factory/
│   ├── SensorFactory.java                ← ⭐ FACTORY METHOD
│   ├── EstacioFactory.java               ← ⭐ ABSTRACT FACTORY (interfaz)
│   ├── EstacionBasicafactory.java        ← Fábrica concreta básica
│   └── EstacionProfecionalFactory.java   ← Fábrica concreta profesional
│
├── 📁 Builder/
│   ├── Reporte.java                      ← Producto
│   ├── reporteBuilder.java               ← ⭐ BUILDER (interfaz)
│   ├── ReportePDFBuilder.java            ← Builder PDF
│   ├── ReporteExcelBuilder.java          ← Builder Excel
│   └── DirectorReporte.java              ← Director
│
└── 📁 Prototype/
    └── ClonableEstacion.java             ← Interfaz de clonación
```

---

## 🚀 Compilación y Ejecución

### Opción 1: Desde el directorio raíz del proyecto

```bash
# Navegar al directorio del proyecto
cd /path/to/Patrones-de-Diseno

# Compilar
javac Tarea/Clima/Main.java

# Ejecutar
java Tarea.Clima.Main
```

### Opción 2: Desde cualquier ubicación

```bash
# Compilar especificando el classpath
javac -cp . Tarea/Clima/Main.java

# Ejecutar
java -cp . Tarea.Clima.Main
```

---

## 🔍 Uso de los Patrones en el Código

### 1️⃣ SINGLETON - Sistema Central Único

```java
// Obtener la única instancia del sistema
SistemaClima sistema = SistemaClima.getInstancia();

// Intenta obtener otra instancia
SistemaClima sistema2 = SistemaClima.getInstancia();

// Verificar que son la misma instancia
System.out.println(sistema == sistema2); // true
```

**Ventajas:**
- ✅ Punto de acceso global
- ✅ Control centralizado
- ✅ Ahorro de recursos

---

### 2️⃣ FACTORY METHOD - Creación de Sensores

```java
// Crear sensores sin conocer las clases concretas
Sensor sensorTemp = SensorFactory.crearSensor("temperatura");
Sensor sensorHum = SensorFactory.crearSensor("humedad");
Sensor sensorPres = SensorFactory.crearSensor("presion");
Sensor sensorViento = SensorFactory.crearSensor("viento");

// Leer datos del sensor
float temperatura = sensorTemp.leerDato();
```

**Ventajas:**
- ✅ Desacoplamiento
- ✅ Extensibilidad
- ✅ Código más limpio

---

### 3️⃣ ABSTRACT FACTORY - Familias de Sensores

```java
// Crear estación con sensores básicos
EstacioFactory factoryBasica = new EstacionBasicafactory();
EstacionClimatica estacionBasica = new EstacionClimatica(1, "Lima Centro");
estacionBasica.configurarConFactory(factoryBasica);
// → Crea solo temperatura y humedad

// Crear estación con sensores profesionales
EstacioFactory factoryPro = new EstacionProfecionalFactory();
EstacionClimatica estacionPro = new EstacionClimatica(2, "Aeropuerto");
estacionPro.configurarConFactory(factoryPro);
// → Crea temperatura, humedad, presión y viento
```

**Ventajas:**
- ✅ Consistency en familias de productos
- ✅ Fácil cambio de familia completa
- ✅ Aislamiento de clases concretas

---

### 4️⃣ BUILDER - Construcción de Reportes Complejos

```java
// Construir reporte en PDF
reporteBuilder builder = new ReportePDFBuilder();
DirectorReporte director = new DirectorReporte(builder);

Reporte reporte = director.construirReporte(
    "Reporte Mensual",
    "Datos climáticos recopilados",
    "Sistema Clima v1.0"
);

reporte.mostrar();

// Cambiar a Excel sin cambiar el director
director.setBuilder(new ReporteExcelBuilder());
Reporte reporteExcel = director.construirReporte(...);
```

**Ventajas:**
- ✅ Construcción paso a paso
- ✅ Diferentes representaciones
- ✅ Control fino del proceso

---

### 5️⃣ PROTOTYPE - Clonación de Estaciones

```java
// Crear estación original
EstacioFactory factory = new EstacionProfecionalFactory();
EstacionClimatica original = new EstacionClimatica(1, "Estación Base");
original.configurarConFactory(factory);

// Clonar la estación
EstacionClimatica clon = original.clone();

// Modificar el clon sin afectar el original
clon.setId(2);
clon.setUbicacion("Estación Clonada");

// Verificar que son objetos diferentes
System.out.println(original == clon); // false
System.out.println(original.getUbicacion()); // "Estación Base"
System.out.println(clon.getUbicacion()); // "Estación Clonada"
```

**Ventajas:**
- ✅ Creación rápida de objetos similares
- ✅ Evita inicializaciones costosas
- ✅ Copia profunda de objetos complejos

---

## 📊 Flujo de Ejecución Típico

```
1. Sistema inicializa (SINGLETON)
   └─> SistemaClima.getInstancia()

2. Crear estaciones (ABSTRACT FACTORY)
   └─> EstacionBasicafactory o EstacionProfecionalFactory
       └─> Crea sensores automáticamente

3. Registrar estaciones
   └─> sistema.registrarEstacion(estacion)

4. Clonar estaciones (PROTOTYPE)
   └─> EstacionClimatica clon = original.clone()

5. Recolectar datos
   └─> estacion.obtenerDatos()
       └─> Cada sensor lee datos (FACTORY METHOD)
           └─> Registra en sistema

6. Generar reportes (BUILDER)
   └─> DirectorReporte construye reporte
       └─> ReportePDFBuilder o ReporteExcelBuilder

7. Consultar sistema
   └─> sistema.consultarClima()
   └─> sistema.generarReporte()
```

---

## 🎨 Personalización del Sistema

### Agregar un nuevo tipo de sensor

```java
// 1. Crear la clase del sensor
public class SensorVelocidadViento extends Sensor {
    public SensorVelocidadViento() {
        super("Velocidad del Viento", "km/h");
    }
    
    @Override
    public float leerDato() {
        // Implementación
        return random.nextFloat() * 100;
    }
}

// 2. Actualizar SensorFactory
public static Sensor crearSensor(String tipo) {
    return switch (tipo.toLowerCase()) {
        case "viento" -> new SensorVelocidadViento();
        // ... otros casos
    };
}
```

### Agregar un nuevo formato de reporte

```java
// 1. Crear el builder concreto
public class ReporteHTMLBuilder implements reporteBuilder {
    private Reporte reporte;
    
    public ReporteHTMLBuilder() {
        this.reporte = new Reporte();
        this.reporte.setFormato("HTML");
    }
    
    @Override
    public void buildEncabezado(String titulo, String fecha) {
        String encabezado = "<h1>" + titulo + "</h1>";
        reporte.setEncabezado(encabezado);
    }
    
    // ... implementar otros métodos
}

// 2. Usar el nuevo builder
reporteBuilder builderHTML = new ReporteHTMLBuilder();
DirectorReporte director = new DirectorReporte(builderHTML);
Reporte reporteHTML = director.construirReporte(...);
```

---

## 🧪 Pruebas y Verificación

### Verificar SINGLETON
```java
SistemaClima s1 = SistemaClima.getInstancia();
SistemaClima s2 = SistemaClima.getInstancia();
assert s1 == s2; // Debe ser true
```

### Verificar PROTOTYPE
```java
EstacionClimatica original = new EstacionClimatica(1, "Original");
EstacionClimatica clon = original.clone();
assert original != clon; // Debe ser true (objetos diferentes)
assert original.getUbicacion().equals(clon.getUbicacion()); // true (mismo valor)
```

---

## 🔧 Solución de Problemas

### Error: "ClassNotFoundException"
**Solución:** Asegúrate de estar en el directorio raíz del proyecto al compilar/ejecutar.

### Error: "Cannot find symbol"
**Solución:** Compila primero Main.java que automáticamente compilará todas las dependencias.

### Los sensores devuelven valores extraños
**Normal:** Los sensores simulan datos aleatorios. Es comportamiento esperado para la demostración.

---

## 📚 Referencias

- **Gang of Four (GoF):** Design Patterns: Elements of Reusable Object-Oriented Software
- **Java 17 Documentation:** https://docs.oracle.com/en/java/javase/17/
- **PlantUML:** https://plantuml.com/

---

## ✅ Checklist de Implementación

- [x] Singleton implementado correctamente
- [x] Factory Method para creación de sensores
- [x] Abstract Factory para familias de productos
- [x] Builder para construcción paso a paso
- [x] Prototype para clonación de objetos
- [x] Historias de Usuario documentadas
- [x] Requerimientos Funcionales (5+)
- [x] Requerimientos No Funcionales (5+)
- [x] Diagramas de clases en UML
- [x] Código compatible con Java 17
- [x] Documentación completa
- [x] Programa ejecutable y funcional

---

## 👨‍💻 Autor

Sistema desarrollado como ejemplo académico de implementación de patrones de diseño creacionales en Java 17.

**Fecha:** Marzo 2026  
**Versión:** 1.0  
**Java:** 17
