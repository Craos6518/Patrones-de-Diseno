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

Cuando necesitamos usar una clase existente pero su interfaz no coincide con lo que necesitamos:

- Incompatibilidad entre interfaces de sistemas diferentes
- No podemos modificar la clase existente (librería externa, legacy code)
- Queremos reutilizar clases existentes con interfaces incompatibles
- Necesitamos integrar componentes de terceros
- Múltiples clases con funcionalidad similar pero interfaces diferentes

**Ejemplo:** Integrar un sistema de pagos de terceros con interfaz diferente a la esperada, o conectar una aplicación que espera XML con un servicio que retorna JSON.

---

## ✅ Solución

El patrón Adapter propone:

- **Clase Adapter:** Actúa como intermediario entre dos interfaces incompatibles
- **Traducción de interfaz:** Convierte la interfaz de una clase en otra esperada
- **Dos variantes:** Adapter de clase (herencia) y Adapter de objeto (composición)
- **Reutilización:** Permite usar clases existentes sin modificarlas
- **Desacoplamiento:** El cliente no conoce la clase adaptada

**Beneficios:**
- Reutiliza código existente sin modificarlo
- Desacopla cliente de implementaciones específicas
- Cumple principio Abierto/Cerrado
- Facilita integración de componentes de terceros
- Un adapter puede trabajar con múltiples adaptados

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Target (Objetivo - Interfaz):** 
  - Define la interfaz que el cliente espera
  - Es la interfaz que el cliente usa
  
- **Adapter (Adaptador):** 
  - Adapta la interfaz de Adaptee a la interfaz Target
  - Traduce las llamadas del cliente al Adaptee
  - Puede ser de clase (herencia) u objeto (composición)
  
- **Adaptee (Adaptado):** 
  - Clase existente con interfaz incompatible
  - Necesita ser adaptada para ser utilizada
  - No puede o no debe modificarse
  
- **Client (Cliente):** 
  - Trabaja con objetos que conforman la interfaz Target
  - No conoce al Adaptee directamente

**Variantes:**
- **Object Adapter:** Usa composición (más flexible)
- **Class Adapter:** Usa herencia múltiple (limitado en Java)

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
adapter/
├── context/
│   ├── ModernPaymentProcessor.java   # Sistema moderno (Target)
│   └── LegacyPaymentSystem.java      # Sistema legacy (Adaptee)
├── strategy/
│   └── PaymentProcessor.java         # Interfaz objetivo
├── impl/
│   ├── PaymentAdapter.java           # Adapter: legacy → moderno
│   ├── JsonToXmlAdapter.java         # Adapter: JSON → XML
│   └── MetricToImperialAdapter.java  # Adapter: métricas → imperiales
└── Main.java                          # Demostración de adaptación
