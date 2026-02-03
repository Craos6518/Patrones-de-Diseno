# 🧩 Patrón: Composite

## 📌 Clasificación
- **Tipo:** Estructural
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Componer objetos en estructuras de árbol para representar jerarquías parte-todo, permitiendo que los clientes traten objetos individuales y composiciones uniformemente.

> Facilita la creación de estructuras recursivas como árboles donde cada nodo puede ser una rama o una hoja.

---

## ❓ Problema

Explica el problema típico que aparece cuando **NO** se usa el patrón.

- Código rígido
- Muchas condiciones (`if / switch`)
- Dificultad para extender
- Alto acoplamiento

---

## ✅ Solución

Describe cómo el patrón propone resolver el problema:

- Qué clases / interfaces introduce
- Cómo se distribuyen las responsabilidades
- Qué se desacopla

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Contexto:**
- **Interfaz:**
- **Implementaciones concretas:**

_(Puedes acompañar esta sección con un diagrama UML en `/docs/diagramas`)_

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
nombre-del-patron/
├── context/
├── strategy/
├── impl/
└── Main.java
