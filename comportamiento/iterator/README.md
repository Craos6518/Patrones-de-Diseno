# 🧩 Patrón: Iterator

## 📌 Clasificación
- **Tipo:** Comportamiento
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Proporcionar una forma de acceder secuencialmente a los elementos de una colección sin exponer su representación subyacente.

> Permite recorrer una colección sin conocer su estructura interna.

---

## ❓ Problema

Cuando necesitamos recorrer una colección sin exponer su estructura interna:

- Acceso directo a la estructura interna de la colección
- Múltiples formas de recorrer (secuencial, reversa, filtrada)
- Código de recorrido mezclado con la lógica de negocio
- Difícil cambiar la estructura interna sin afectar clientes
- Imposibilidad de múltiples recorridos simultáneos

**Ejemplo:** Recorrer una lista, árbol o grafo sin conocer su implementación interna.

---

## ✅ Solución

El patrón Iterator propone:

- **Encapsular el recorrido:** El iterador maneja la lógica de navegación
- **Interfaz uniforme:** Métodos estándar como `hasNext()`, `next()`
- **Ocultar estructura:** La colección no expone su representación interna
- **Múltiples iteradores:** Diferentes formas de recorrer la misma colección
- **Iteradores independientes:** Varios recorridos simultáneos posibles

**Beneficios:**
- Simplifica la interfaz de la colección
- Soporta múltiples tipos de recorrido
- Permite múltiples recorridos simultáneos
- Desacopla algoritmos de recorrido de la estructura
- Cumple con el principio de Responsabilidad Única

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Iterator (Iterador - Interfaz):** 
  - Define interfaz para acceder y recorrer elementos
  - Métodos típicos: `hasNext()`, `next()`, `remove()`
  
- **ConcreteIterator (Iterador Concreto):** 
  - Implementa la interfaz Iterator
  - Mantiene la posición actual en el recorrido
  
- **Aggregate (Agregado - Interfaz):** 
  - Define interfaz para crear un iterador
  - Método típico: `createIterator()`
  
- **ConcreteAggregate (Agregado Concreto):** 
  - Implementa la interfaz de creación de iterador
  - Retorna una instancia del iterador apropiado

**Relaciones:**
- ConcreteAggregate crea ConcreteIterator
- ConcreteIterator conoce la estructura de ConcreteAggregate
- Client usa Iterator para recorrer Aggregate

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
iterator/
├── context/
│   └── BookCollection.java           # Agregado concreto (colección)
├── strategy/
│   ├── Iterator.java                 # Interfaz del iterador
│   └── Collection.java               # Interfaz del agregado
├── impl/
│   ├── BookIterator.java             # Iterador secuencial
│   ├── ReverseBookIterator.java      # Iterador reverso
│   └── FilteredBookIterator.java     # Iterador con filtro
└── Main.java                          # Demostración de diferentes recorridos
