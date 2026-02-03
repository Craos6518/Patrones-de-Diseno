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
