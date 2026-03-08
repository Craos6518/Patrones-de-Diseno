# Sistema de Control de Clima ☁️🌡️

## Descripción
Sistema de control de clima implementado en **Java 17** que utiliza los **5 patrones de diseño creacionales** del Gang of Four (GoF): Singleton, Factory Method, Abstract Factory, Builder y Prototype.

---

## 📋 Historias de Usuario (HU)

### HU1 – Registro de datos climáticos
Como operador del sistema quiero registrar temperatura, humedad, presión y viento para mantener historial climático actualizado.

### HU2 – Consulta de clima actual
Como usuario quiero consultar el clima actual para conocer las condiciones ambientales en tiempo real.

### HU3 – Visualización histórica
Como analista quiero consultar registros históricos del clima para analizar patrones climáticos.

### HU4 – Generación de reportes
Como administrador quiero generar reportes climáticos para evaluar tendencias y tomar decisiones.

### HU5 – Integración con sensores
Como técnico quiero integrar sensores meteorológicos para automatizar la captura de datos climáticos.

---

## ⚙️ Requerimientos Funcionales (RF)

| ID | Descripción |
|----|-------------|
| RF1 | El sistema debe permitir registrar datos climáticos (temperatura, humedad, presión atmosférica, velocidad del viento) |
| RF2 | El sistema debe permitir consultar datos climáticos actuales |
| RF3 | El sistema debe almacenar el historial climático |
| RF4 | El sistema debe generar reportes climáticos en diferentes formatos |
| RF5 | El sistema debe integrarse con sensores meteorológicos externos |

---

## 🔧 Requerimientos No Funcionales (RNF)

| ID | Tipo | Descripción |
|----|------|-------------|
| RNF1 | Disponibilidad | El sistema debe tener disponibilidad del 99% |
| RNF2 | Rendimiento | Las consultas climáticas deben responder en menos de 2 segundos |
| RNF3 | Escalabilidad | El sistema debe soportar múltiples estaciones meteorológicas |
| RNF4 | Seguridad | El sistema debe permitir control de acceso por roles |
| RNF5 | Mantenibilidad | El sistema debe ser modular para facilitar mantenimiento y extensiones futuras |

---

## 🎨 Patrones de Diseño Implementados

### 1️⃣ SINGLETON - `SistemaClima`
**Propósito:** Garantizar una única instancia del sistema de clima.

**Implementación:**
- Constructor privado
- Instancia estática
- Método `getInstancia()` sincronizado

**Ubicación:** [Core/SistemaClima.java](Core/SistemaClima.java)

```java
SistemaClima sistema = SistemaClima.getInstancia();
```

---

### 2️⃣ FACTORY METHOD - `SensorFactory`
**Propósito:** Crear diferentes tipos de sensores sin exponer la lógica de creación.

**Tipos de sensores:**
- `Sensortemperatura`
- `SensorHumedad`
- `SensorPresion`
- `SensorViento`

**Ubicación:** [Factory/SensorFactory.java](Factory/SensorFactory.java)

```java
Sensor sensor = SensorFactory.crearSensor("temperatura");
```

---

### 3️⃣ ABSTRACT FACTORY - `EstacionFactory`
**Propósito:** Crear familias de sensores para diferentes tipos de estaciones.

**Fábricas concretas:**
- `EstacionBasicafactory` → Sensores básicos (temperatura, humedad)
- `EstacionProfecionalFactory` → Sensores completos (todos los tipos)

**Ubicación:** [Factory/EstacioFactory.java](Factory/EstacioFactory.java)

```java
EstacioFactory factory = new EstacionProfecionalFactory();
EstacionClimatica estacion = new EstacionClimatica(1, "Lima");
estacion.configurarConFactory(factory);
```

---

### 4️⃣ BUILDER - `ReporteBuilder`
**Propósito:** Construir reportes complejos paso a paso.

**Componentes:**
- `Reporte` → Producto final
- `reporteBuilder` → Interfaz builder
- `ReportePDFBuilder` → Constructor concreto PDF
- `ReporteExcelBuilder` → Constructor concreto Excel
- `DirectorReporte` → Orquesta la construcción

**Ubicación:** [Builder/](Builder/)

```java
reporteBuilder builder = new ReportePDFBuilder();
DirectorReporte director = new DirectorReporte(builder);
Reporte reporte = director.construirReporte("Título", "Contenido", "Firma");
```

---

### 5️⃣ PROTOTYPE - `EstacionClimatica`
**Propósito:** Clonar estaciones existentes para crear nuevas instancias.

**Implementación:**
- Interfaz `ClonableEstacion`
- Método `clone()` que crea copia profunda

**Ubicación:** [Estacion/EstacionClimatica.java](Estacion/EstacionClimatica.java)

```java
EstacionClimatica clon = estacionOriginal.clone();
clon.setUbicacion("Nueva Ubicación");
```

---

## 📁 Estructura del Proyecto

```
Tarea/Clima/
├── Main.java                          # Clase principal con demostración
├── Core/
│   └── SistemaClima.java             # SINGLETON
├── Estacion/
│   ├── EstacionClimatica.java        # PROTOTYPE
│   └── RegistroClimatico.java        # Modelo de datos
├── sensor/
│   ├── Sensor.java                   # Clase abstracta base
│   ├── Sensortemperatura.java
│   ├── SensorHumedad.java
│   ├── SensorPresion.java
│   └── SensorViento.java
├── Factory/
│   ├── SensorFactory.java            # FACTORY METHOD
│   ├── EstacioFactory.java           # ABSTRACT FACTORY (interfaz)
│   ├── EstacionBasicafactory.java    # Factory concreta
│   └── EstacionProfecionalFactory.java
├── Builder/
│   ├── Reporte.java                  # Producto
│   ├── reporteBuilder.java           # Interfaz builder
│   ├── ReportePDFBuilder.java        # Builder concreto
│   ├── ReporteExcelBuilder.java      # Builder concreto
│   └── DirectorReporte.java          # Director
└── Prototype/
    └── ClonableEstacion.java         # Interfaz de clonación
```

---

## 🚀 Ejecución

### Compilar
```bash
javac Tarea/Clima/Main.java
```

### Ejecutar
```bash
java Tarea.Clima.Main
```

---

## 💡 Características Implementadas

✅ **Singleton** - Sistema centralizado con instancia única  
✅ **Factory Method** - Creación flexible de sensores  
✅ **Abstract Factory** - Familias de productos (estaciones básicas vs profesionales)  
✅ **Builder** - Construcción de reportes en múltiples formatos  
✅ **Prototype** - Clonación eficiente de estaciones  
✅ **Simulación de sensores** - Generación automática de datos climáticos  
✅ **Historial de registros** - Almacenamiento de datos históricos  
✅ **Múltiples estaciones** - Soporte para varias estaciones simultáneas  
✅ **Reportes formateados** - Salida visual con caracteres UTF-8  

---

## 📊 Diagrama de Clases Principal

```
SistemaClima (Singleton)
    ↓ administra
EstacionClimatica (Prototype)
    ↓ contiene
Sensor (Factory Method)
    ├── Sensortemperatura
    ├── SensorHumedad
    ├── SensorPresion
    └── SensorViento
```

---

## 🧪 Ejemplo de Salida

```
╔═══════════════════════════════════════════════════╗
║   SISTEMA DE CONTROL DE CLIMA - JAVA 17          ║
║   Demostración de Patrones Creacionales          ║
╚═══════════════════════════════════════════════════╝

✓ Sistema de Clima inicializado (Singleton)
→ Verificando instancia única: ✓ SÍ

→ Factory: Creando sensor de temperatura
→ Factory: Creando sensor de humedad
→ Factory: Creando sensor de presión

╭──────────────────────────────────╮
│  Configurando: Centro de Lima    
╰──────────────────────────────────╯
  → AbstractFactory (Básica): Creando sensor de temperatura
  → AbstractFactory (Básica): Creando sensor de humedad
✓ Configuración completada: 2 sensores activos
```

---

## 🔍 Verificaciones

El sistema demuestra cada patrón con:
- ✓ Mensajes de trazabilidad
- ✓ Verificación de instancia única (Singleton)
- ✓ Comparación de objetos originales vs clonados (Prototype)
- ✓ Diferenciación entre estaciones básicas y profesionales (Abstract Factory)
- ✓ Construcción paso a paso de reportes (Builder)

---

## 👨‍💻 Tecnologías

- **Java 17**
- **Pattern-Oriented Design**
- **Clean Code Principles**
- **UpperCamelCase Naming Convention**

---

## 📝 Autor

Sistema desarrollado como ejemplo académico de implementación de patrones de diseño creacionales en Java 17.

---

## 📄 Licencia

Este proyecto es de código abierto con fines educativos.
