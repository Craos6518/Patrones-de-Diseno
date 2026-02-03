# 🧩 Patrón: Decorator

## 📌 Clasificación
- **Tipo:** Estructural
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Agregar dinámicamente nuevas responsabilidades a un objeto, proporcionando una alternativa flexible a la herencia para extender funcionalidades.

> Permite envolver un objeto con nuevas capacidades sin modificar su código original.

---

## ❓ Problema

Cuando necesitamos agregar responsabilidades a objetos de forma dinámica y flexible:

- Herencia estática inflexible (no se puede cambiar en tiempo de ejecución)
- Explosión de subclases para cada combinación de funcionalidades
- Modificar la clase original no es posible o deseable
- Funcionalidades opcionales que se combinan de múltiples formas
- Violación del principio de Responsabilidad Única

**Ejemplo:** Agregar funcionalidades a flujos de datos (compresión, encriptación, buffering), decorar componentes de UI, añadir características a bebidas en una cafetería.

---

## ✅ Solución

El patrón Decorator propone:

- **Envolver objetos:** El decorator envuelve el componente original
- **Misma interfaz:** Decorator implementa la misma interfaz que el componente
- **Delegación + extensión:** Delega al componente y agrega funcionalidad
- **Composición dinámica:** Los decorators pueden apilarse en tiempo de ejecución
- **Transparencia:** El cliente no distingue entre componente decorado y sin decorar

**Beneficios:**
- Más flexible que la herencia estática
- Evita clases sobrecargadas con muchas características
- Responsabilidades pueden agregarse/quitarse dinámicamente
- Funcionalidades se pueden combinar de múltiples formas
- Cumple principio Abierto/Cerrado

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Component (Componente - Interfaz):** 
  - Define interfaz común para objetos que pueden ser decorados
  - Pueden ser componentes concretos o decorators
  
- **ConcreteComponent (Componente Concreto):** 
  - Define un objeto al que se le pueden agregar responsabilidades
  - Implementación base sin decoraciones
  
- **Decorator (Decorador Abstracto):** 
  - Mantiene referencia a un objeto Component
  - Implementa la misma interfaz que Component
  - Delega operaciones al componente envuelto
  
- **ConcreteDecorator (Decorador Concreto):** 
  - Agrega responsabilidades específicas al componente
  - Puede agregar estado y comportamiento
  - Llama al método del componente y agrega funcionalidad

**Relaciones:**
- Decorator envuelve un Component
- ConcreteDecorator extiende Decorator
- Los decorators pueden apilarse (un decorator envuelve otro decorator)
- Client usa Component (interfaz común)

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
decorator/
├── context/
│   └── Coffee.java                   # Componente base
├── strategy/
│   ├── Beverage.java                 # Interfaz componente
│   └── BeverageDecorator.java        # Decorator abstracto
├── impl/
│   ├── SimpleCoffee.java             # Componente concreto
│   ├── Espresso.java                 # Componente concreto
│   ├── MilkDecorator.java            # Decorator: leche
│   ├── SugarDecorator.java           # Decorator: azúcar
│   ├── WhipCreamDecorator.java       # Decorator: crema
│   └── CaramelDecorator.java         # Decorator: caramelo
└── Main.java                          # Demostración de combinaciones
