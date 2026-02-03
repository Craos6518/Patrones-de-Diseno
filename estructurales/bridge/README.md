# 🧩 Patrón: Bridge

## 📌 Clasificación
- **Tipo:** Estructural
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Desacoplar una abstracción de su implementación, permitiendo que ambas varíen independientemente.

> Evita la creación de jerarquías complejas al separar la interfaz de la implementación.

---

## ❓ Problema

Cuando abstracción e implementación crecen en dimensiones independientes creando explosión de clases:

- Jerarquías de clases monolíticas difíciles de mantener
- Cambios en la implementación afectan la abstracción y viceversa
- Multiplicación de subclases (explosión de clases)
- Violación del principio de Responsabilidad Única
- Difícil extender abstracción e implementación independientemente

**Ejemplo:** Formas geométricas (círculo, cuadrado) que pueden dibujarse en diferentes APIs gráficas (OpenGL, DirectX) → sin Bridge: CirculoOpenGL, CirculoDirectX, CuadradoOpenGL, CuadradoDirectX...

---

## ✅ Solución

El patrón Bridge propone:

- **Separar abstracción de implementación:** Dos jerarquías independientes
- **Composición sobre herencia:** La abstracción contiene una referencia a la implementación
- **Puente:** Conexión flexible entre abstracción e implementación
- **Variación independiente:** Ambas jerarquías pueden evolucionar por separado
- **Combinaciones flexibles:** Mezclar abstracciones e implementaciones dinámicamente

**Beneficios:**
- Desacopla abstracción de implementación
- Reduce número de clases (evita explosión)
- Facilita extensión independiente
- Oculta detalles de implementación al cliente
- Permite cambiar implementación en tiempo de ejecución

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Abstraction (Abstracción):** 
  - Define interfaz de alto nivel para el cliente
  - Mantiene referencia a un objeto Implementor
  - Delega trabajo al Implementor
  
- **RefinedAbstraction (Abstracción Refinada):** 
  - Extiende la interfaz de Abstraction
  - Variantes de la abstracción
  
- **Implementor (Implementador - Interfaz):** 
  - Define interfaz para clases de implementación
  - No tiene que corresponder exactamente con Abstraction
  
- **ConcreteImplementor (Implementador Concreto):** 
  - Implementa la interfaz Implementor
  - Proporciona implementación concreta

**Relaciones:**
- Abstraction tiene un Implementor (composición)
- RefinedAbstraction hereda de Abstraction
- ConcreteImplementor implementa Implementor
- Las dos jerarquías varían independientemente

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
bridge/
├── context/
│   ├── Shape.java                    # Abstracción
│   ├── Circle.java                   # Abstracción refinada
│   ├── Rectangle.java                # Abstracción refinada
│   └── Triangle.java                 # Abstracción refinada
├── strategy/
│   └── DrawingAPI.java               # Implementador (interfaz)
├── impl/
│   ├── OpenGLDrawing.java            # Implementador: OpenGL
│   ├── DirectXDrawing.java           # Implementador: DirectX
│   └── SVGDrawing.java               # Implementador: SVG
└── Main.java                          # Demostración de combinaciones
