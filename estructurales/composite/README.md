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

Cuando necesitamos representar jerarquías de objetos parte-todo y tratarlos uniformemente:

- Diferenciación compleja entre objetos simples y compuestos
- Código cliente lleno de condicionales para distinguir tipos
- Difícil agregar nuevos tipos de componentes
- Operaciones recursivas en estructuras de árbol son complejas
- Violación del principio Abierto/Cerrado

**Ejemplo:** Sistema de archivos (archivos y carpetas), estructuras organizacionales (empleados y departamentos), interfaces gráficas (componentes simples y contenedores).

---

## ✅ Solución

El patrón Composite propone:

- **Interfaz única:** Tanto objetos simples como compuestos implementan la misma interfaz
- **Estructura de árbol:** Los compuestos contienen componentes (simples u otros compuestos)
- **Tratamiento uniforme:** El cliente trata hojas y compuestos de la misma manera
- **Recursividad:** Las operaciones se propagan recursivamente en la estructura
- **Transparencia:** El cliente no necesita distinguir entre tipos

**Beneficios:**
- Simplifica código cliente (trata todo uniformemente)
- Facilita agregar nuevos tipos de componentes
- Estructura jerárquica natural y flexible
- Operaciones recursivas simplificadas
- Cumple principio Abierto/Cerrado

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Component (Componente - Interfaz):** 
  - Declara interfaz común para objetos simples y compuestos
  - Implementa comportamiento por defecto cuando aplica
  - Declara métodos para gestionar hijos (opcional)
  
- **Leaf (Hoja):** 
  - Representa objetos terminales (sin hijos)
  - Implementa comportamiento para objetos primitivos
  - No puede tener componentes hijos
  
- **Composite (Compuesto):** 
  - Representa componentes que pueden tener hijos
  - Almacena componentes hijos (hojas u otros compuestos)
  - Implementa operaciones para manipular hijos
  - Delega operaciones a sus hijos
  
- **Client (Cliente):** 
  - Manipula objetos de la composición a través de Component
  - No distingue entre Leaf y Composite

**Relaciones:**
- Composite contiene Components (puede ser Leaf u otros Composite)
- Client usa Component (interfaz común)
- Las operaciones se propagan recursivamente

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
composite/
├── context/
│   ├── FileSystemComponent.java      # Componente base
│   ├── File.java                     # Hoja: archivo
│   └── Directory.java                # Compuesto: directorio
├── impl/
│   ├── Department.java               # Compuesto: departamento
│   ├── Employee.java                 # Hoja: empleado
│   ├── GraphicObject.java            # Componente gráfico
│   └── GraphicGroup.java             # Grupo de gráficos
└── Main.java                          # Demostración de estructura jerárquica
