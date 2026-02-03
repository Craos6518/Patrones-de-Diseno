# 🧩 Patrón: Facade

## 📌 Clasificación
- **Tipo:** Estructural
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Proporcionar una interfaz unificada y simplificada para acceder a un conjunto complejo de subsistemas.

> Oculta la complejidad del sistema, permitiendo que los clientes interactúen con una interfaz simple.

---

## ❓ Problema

Cuando un sistema tiene muchos subsistemas interdependientes con interfaces complejas:

- Clientes acoplados a múltiples subsistemas
- Uso complicado que requiere conocer muchos detalles internos
- Difícil de usar y entender para nuevos desarrolladores
- Cambios en subsistemas afectan a muchos clientes
- Dependencias complejas entre cliente y subsistemas

**Ejemplo:** Inicializar un sistema de video juego (gráficos, sonido, física, red), configurar un framework complejo, o interactuar con una librería con muchas clases.

---

## ✅ Solución

El patrón Facade propone:

- **Interfaz unificada:** Una sola clase facade simplifica el acceso
- **Ocultar complejidad:** Encapsula la interacción con subsistemas
- **Punto de entrada único:** Operaciones de alto nivel para tareas comunes
- **Desacoplamiento:** Los clientes no dependen directamente de subsistemas
- **Acceso directo opcional:** Los clientes avanzados aún pueden acceder a subsistemas

**Beneficios:**
- Simplifica el uso de sistemas complejos
- Reduce dependencias entre clientes y subsistemas
- Promueve acoplamiento débil
- Facilita testing (se puede mockear el facade)
- No limita el acceso para usuarios avanzados

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Facade (Fachada):** 
  - Proporciona interfaz simplificada a un conjunto de subsistemas
  - Conoce qué subsistemas son responsables de cada solicitud
  - Delega peticiones del cliente a subsistemas apropiados
  - Puede realizar trabajo adicional de coordinación
  
- **Subsystems (Subsistemas):** 
  - Implementan funcionalidad específica del sistema
  - Manejan trabajo asignado por el Facade
  - No tienen conocimiento del Facade
  - Pueden ser usados directamente por clientes avanzados
  
- **Client (Cliente):** 
  - Usa el Facade en lugar de interactuar directamente con subsistemas
  - Código más simple y desacoplado

**Relaciones:**
- Facade conoce y coordina Subsystems
- Subsystems no conocen al Facade
- Client usa Facade (opcionalmente puede usar Subsystems directamente)

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
facade/
├── context/
│   └── HomeTheaterFacade.java        # Facade principal
├── impl/
│   ├── Amplifier.java                # Subsistema: amplificador
│   ├── DVDPlayer.java                # Subsistema: reproductor DVD
│   ├── Projector.java                # Subsistema: proyector
│   ├── Lights.java                   # Subsistema: luces
│   ├── Screen.java                   # Subsistema: pantalla
│   └── PopcornMaker.java             # Subsistema: palomitero
└── Main.java                          # Demostración de uso simplificado
