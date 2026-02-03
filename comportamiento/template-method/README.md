# 🧩 Patrón: Template Method

## 📌 Clasificación
- **Tipo:** Comportamiento
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Definir el esqueleto de un algoritmo en una clase base, dejando que las subclases implementen los pasos específicos sin cambiar la estructura del algoritmo.

> Promueve la reutilización de código al definir el flujo general en la clase base.

---

## ❓ Problema

Cuando varios algoritmos comparten estructura pero difieren en algunos pasos:

- Código duplicado en algoritmos similares
- Difícil mantener consistencia en la estructura del algoritmo
- Violación del principio DRY (Don't Repeat Yourself)
- Cambios en el flujo requieren modificar múltiples clases
- No hay garantía de que los pasos se ejecuten en el orden correcto

**Ejemplo:** Procesos de generación de reportes (PDF, Excel, HTML) que siguen los mismos pasos pero con implementaciones diferentes.

---

## ✅ Solución

El patrón Template Method propone:

- **Definir esqueleto:** El algoritmo se define en la clase base
- **Métodos abstractos:** Los pasos variables son métodos abstractos
- **Métodos hook:** Métodos opcionales que las subclases pueden sobrescribir
- **Control centralizado:** La clase base controla el flujo del algoritmo
- **Reutilización:** La estructura común se reutiliza

**Beneficios:**
- Reutiliza código común en la clase base
- Controla qué pasos pueden variar
- Invierte el control (Hollywood Principle)
- Facilita mantenimiento del algoritmo
- Garantiza que los pasos se ejecuten en orden correcto

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **AbstractClass (Clase Abstracta):** 
  - Define el método template que establece el esqueleto del algoritmo
  - Declara métodos abstractos para pasos variables
  - Puede incluir métodos hook con implementación por defecto
  - Contiene pasos comunes implementados
  
- **ConcreteClass (Clase Concreta):** 
  - Implementa los pasos abstractos del algoritmo
  - Opcionalmente sobrescribe los métodos hook
  - Hereda el método template y la estructura del algoritmo

**Relaciones:**
- ConcreteClass hereda de AbstractClass
- AbstractClass define el flujo y delega pasos específicos
- Client invoca el método template en instancias de ConcreteClass

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
template-method/
├── context/
│   └── ReportGenerator.java          # Clase abstracta con template method
├── impl/
│   ├── PDFReportGenerator.java       # Generador de reportes PDF
│   ├── ExcelReportGenerator.java     # Generador de reportes Excel
│   └── HTMLReportGenerator.java      # Generador de reportes HTML
└── Main.java                          # Demostración de generación de reportes
