# 🧩 Patrón: Strategy

## 📌 Clasificación
- **Tipo:** Comportamiento
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Definir una familia de algoritmos, encapsularlos y hacerlos intercambiables, permitiendo que el algoritmo varíe independientemente del cliente que lo utiliza.

> Separa el comportamiento que varía del que permanece estable.

---

## ❓ Problema

Cuando tenemos múltiples algoritmos o comportamientos y necesitamos seleccionar uno dinámicamente:

- Código repleto de condicionales (`if/else` o `switch`) para seleccionar el algoritmo
- Difícil agregar nuevos algoritmos sin modificar código existente
- Violación del principio Abierto/Cerrado (OCP)
- Lógica de negocio mezclada con la selección de algoritmos
- Código duplicado cuando varios contextos usan algoritmos similares

**Ejemplo:** Un sistema de envíos con diferentes métodos de cálculo (terrestre, aéreo, marítimo) implementado con múltiples `if/else`.

---

## ✅ Solución

El patrón Strategy propone:

- **Definir una familia de algoritmos:** Cada algoritmo es encapsulado en su propia clase
- **Interfaz común:** Todos los algoritmos implementan la misma interfaz
- **Composición sobre condicionales:** El contexto delega en la estrategia seleccionada
- **Intercambiabilidad:** Las estrategias pueden cambiarse en tiempo de ejecución
- **Desacoplamiento:** El contexto no conoce los detalles de implementación de las estrategias

**Beneficios:**
- Facilita agregar nuevas estrategias sin modificar código existente
- Elimina condicionales complejos
- Cada estrategia se puede probar de forma independiente
- Cumple con el principio de Responsabilidad Única (SRP)

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Context (Contexto):** 
  - Mantiene una referencia a un objeto Strategy
  - Puede definir una interfaz para que Strategy acceda a sus datos
  - Delega el trabajo al objeto Strategy actual
  
- **Strategy (Estrategia - Interfaz):** 
  - Define una interfaz común para todos los algoritmos
  - El contexto usa esta interfaz para invocar el algoritmo
  
- **ConcreteStrategy (Estrategia Concreta):** 
  - Implementa el algoritmo usando la interfaz Strategy
  - Cada clase concreta representa una variante del algoritmo

**Relaciones:**
- Context tiene una Strategy (composición)
- ConcreteStrategy implementa Strategy
- El cliente configura Context con una ConcreteStrategy específica

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
strategy/
├── context/
│   └── ShippingContext.java          # Contexto que usa la estrategia
├── strategy/
│   └── ShippingStrategy.java         # Interfaz de la estrategia
├── impl/
│   ├── AirShippingStrategy.java      # Estrategia concreta: envío aéreo
│   ├── GroundShippingStrategy.java   # Estrategia concreta: envío terrestre
│   └── SeaShippingStrategy.java      # Estrategia concreta: envío marítimo
└── Main.java                          # Demostración del patrón
