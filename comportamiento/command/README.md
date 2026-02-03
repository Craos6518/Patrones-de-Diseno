# 🧩 Patrón: Command

## 📌 Clasificación
- **Tipo:** Comportamiento
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Encapsular una solicitud como un objeto, permitiendo parametrizar clientes con diferentes solicitudes, encolar solicitudes y registrar solicitudes.

> Desacopla el objeto que invoca una operación del objeto que la ejecuta.

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
