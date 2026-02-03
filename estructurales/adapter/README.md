# 🧩 Patrón: Adapter

## 📌 Clasificación
- **Tipo:** Estructural
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Adaptar una interfaz existente a otra esperada por el cliente, permitiendo que clases incompatibles trabajen juntas.

> Transforma la interfaz de una clase en otra que el cliente espera, resolviendo incompatibilidades.

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
