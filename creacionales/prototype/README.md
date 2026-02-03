# 🧩 Patrón: Prototype

## 📌 Clasificación
- **Tipo:** Creacional
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Crear nuevos objetos copiando un objeto existente (prototipo) en lugar de crear instancias desde cero.

> Permite clonar objetos sin conocer sus detalles de implementación, mejorando el desempeño.

---

## ❓ Problema

Cuando crear objetos desde cero es costoso o complejo:

- Creación costosa (consultas a BD, cálculos intensivos, lectura de archivos)
- Objetos con configuración compleja que debe replicarse
- Clases desconocidas en tiempo de compilación
- Reducción de subclases de factories
- Estado complejo que debe preservarse

**Ejemplo:** Clonar objetos gráficos en un editor, crear copias de documentos con formato, o duplicar configuraciones complejas.

---

## ✅ Solución

El patrón Prototype propone:

- **Clonación en lugar de creación:** Copiar objetos existentes
- **Interfaz de clonación:** Método `clone()` o `copy()`
- **Clonación profunda vs superficial:** Controlar el nivel de copia
- **Registro de prototipos:** Manager que mantiene prototipos disponibles
- **Configuración por copia:** Evitar reconfiguración desde cero

**Beneficios:**
- Reduce costos de creación de objetos
- Evita subclases de creadores
- Agrega y elimina productos en tiempo de ejecución
- Configura aplicación con clases dinámicamente
- Reduce necesidad de subclases

**Consideraciones:**
- Clonar objetos con referencias circulares puede ser complejo
- Deep clone vs shallow clone debe definirse claramente

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Prototype (Prototipo - Interfaz):** 
  - Declara interfaz para clonarse a sí mismo
  - Típicamente método `clone()` o `copy()`
  
- **ConcretePrototype (Prototipo Concreto):** 
  - Implementa operación de clonación
  - Retorna una copia de sí mismo
  - Maneja la clonación profunda si es necesario
  
- **Client (Cliente):** 
  - Crea nuevos objetos solicitando a un prototipo que se clone
  - No conoce las clases concretas de los objetos
  
- **PrototypeRegistry (Registro - Opcional):** 
  - Mantiene un registro de prototipos disponibles
  - Proporciona acceso a prototipos por nombre o tipo

**Relaciones:**
- Client usa Prototype para obtener copias
- ConcretePrototype se clona a sí mismo
- PrototypeRegistry almacena y gestiona prototipos

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
prototype/
├── context/
│   └── PrototypeRegistry.java        # Registro de prototipos
├── strategy/
│   └── Cloneable.java                # Interfaz de clonación
├── impl/
│   ├── Circle.java                   # Prototipo: círculo
│   ├── Rectangle.java                # Prototipo: rectángulo
│   ├── ComplexShape.java             # Prototipo con clonación profunda
│   └── Document.java                 # Prototipo: documento
└── Main.java                          # Demostración de clonación
