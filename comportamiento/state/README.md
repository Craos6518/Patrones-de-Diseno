# 🧩 Patrón: State

## 📌 Clasificación
- **Tipo:** Comportamiento
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Permitir que un objeto altere su comportamiento cuando su estado interno cambia, pareciendo cambiar la clase del objeto.

> Encapsula los diferentes estados en objetos separados y permite cambiar dinámicamente entre ellos.

---

## ❓ Problema

Cuando el comportamiento de un objeto debe cambiar según su estado interno:

- Condicionales complejos (`if/else` o `switch`) basados en el estado
- Comportamiento distribuido en múltiples métodos
- Difícil agregar nuevos estados sin modificar todo el código
- Violación del principio de Responsabilidad Única
- Código difícil de mantener y entender

**Ejemplo:** Una máquina expendedora, un reproductor de música, o un proceso de pedido con estados (pendiente, procesando, enviado, entregado).

---

## ✅ Solución

El patrón State propone:

- **Encapsular estados:** Cada estado es una clase separada
- **Interfaz State:** Todos los estados implementan la misma interfaz
- **Delegación:** El contexto delega el comportamiento al estado actual
- **Transiciones:** Los estados pueden cambiar el estado del contexto
- **Eliminar condicionales:** El polimorfismo reemplaza los `if/switch`

**Beneficios:**
- Organiza código relacionado con estados específicos
- Facilita agregar nuevos estados
- Elimina condicionales complejos
- Hace explícitas las transiciones de estado
- Cumple con el principio Abierto/Cerrado

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Context (Contexto):** 
  - Mantiene una instancia del estado actual
  - Delega comportamiento al estado actual
  - Puede cambiar de estado
  
- **State (Estado - Interfaz):** 
  - Define una interfaz común para todos los estados
  - Cada método representa un comportamiento que varía según el estado
  
- **ConcreteState (Estado Concreto):** 
  - Implementa el comportamiento específico de un estado
  - Puede cambiar el estado del contexto

**Relaciones:**
- Context tiene un State actual
- ConcreteState implementa State
- Los estados pueden cambiar el estado del Context

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
state/
├── context/
│   └── Order.java                    # Contexto (pedido)
├── strategy/
│   └── OrderState.java               # Interfaz del estado
├── impl/
│   ├── PendingState.java             # Estado: pendiente
│   ├── ProcessingState.java          # Estado: procesando
│   ├── ShippedState.java             # Estado: enviado
│   ├── DeliveredState.java           # Estado: entregado
│   └── CancelledState.java           # Estado: cancelado
└── Main.java                          # Demostración de transiciones
