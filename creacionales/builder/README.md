# 🧩 Patrón: Builder

## 📌 Clasificación
- **Tipo:** Creacional
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Separar la construcción de un objeto complejo de su representación, permitiendo que el mismo proceso de construcción pueda crear diferentes representaciones.

> Facilita la creación de objetos complejos con muchos parámetros opcionales.

---

## ❓ Problema

Cuando necesitamos construir objetos complejos con muchos parámetros opcionales:

- Constructores telescópicos (múltiples sobrecargas)
- Objetos parcialmente construidos (estado inconsistente)
- Difícil de leer: `new Casa(4, 2, true, false, 2, 1, true, false)`
- Parámetros opcionales requieren valores por defecto o null
- Proceso de construcción complejo con múltiples pasos

**Ejemplo:** Construir objetos complejos como documentos, configuraciones, menús de restaurante, o casas con múltiples características opcionales.

---

## ✅ Solución

El patrón Builder propone:

- **Separar construcción de representación:** El builder maneja la construcción paso a paso
- **Interfaz fluida:** Métodos encadenables para configurar el objeto
- **Construcción paso a paso:** Permite construir el objeto gradualmente
- **Director (opcional):** Controla el orden de construcción
- **Productos variados:** El mismo proceso puede crear diferentes representaciones

**Beneficios:**
- Código más legible y mantenible
- Control sobre el proceso de construcción
- Permite construir objetos inmutables
- Aísla código de construcción de la representación
- Facilita crear diferentes representaciones del mismo objeto

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Builder (Constructor - Interfaz):** 
  - Declara interfaz para construir partes del producto
  - Métodos para configurar cada parte del objeto
  
- **ConcreteBuilder (Constructor Concreto):** 
  - Implementa los pasos de construcción
  - Mantiene el producto que está siendo construido
  - Proporciona método para obtener el resultado
  
- **Product (Producto):** 
  - Representa el objeto complejo siendo construido
  - Puede tener estructura interna compleja
  
- **Director (Director - Opcional):** 
  - Construye el objeto usando la interfaz Builder
  - Define el orden en que se ejecutan los pasos de construcción
  - Reutiliza secuencias de construcción específicas

**Relaciones:**
- Director usa Builder para construir Product
- ConcreteBuilder crea y ensambla partes del Product
- Client obtiene el Product del ConcreteBuilder

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
builder/
├── context/
│   ├── HouseDirector.java            # Director (opcional)
│   └── House.java                    # Producto complejo
├── strategy/
│   └── HouseBuilder.java             # Interfaz del builder
├── impl/
│   ├── ModernHouseBuilder.java       # Builder: casa moderna
│   ├── ClassicHouseBuilder.java      # Builder: casa clásica
│   └── CabinHouseBuilder.java        # Builder: cabaña
└── Main.java                          # Demostración de construcción paso a paso
