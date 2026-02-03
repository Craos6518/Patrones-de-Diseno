# 🧩 Patrón: Abstract Factory

## 📌 Clasificación
- **Tipo:** Creacional
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Crear familias de objetos relacionados sin especificar sus clases concretas, proporcionando interfaces para crear conjuntos de objetos coherentes.

> Permite el cambio de familias de productos sin alterar el código cliente.

---

## ❓ Problema

Cuando necesitamos crear familias de objetos relacionados sin especificar sus clases concretas:

- Código acoplado a familias específicas de productos
- Difícil cambiar entre familias de productos completas
- Inconsistencias al mezclar productos de diferentes familias
- Violación del principio de Inversión de Dependencias
- Lógica de creación dispersa y duplicada

**Ejemplo:** Un sistema de UI multiplataforma (Windows, Mac, Linux) donde cada plataforma tiene su propia familia de componentes (botones, menús, ventanas).

---

## ✅ Solución

El patrón Abstract Factory propone:

- **Familia de factories:** Una factory abstracta para cada familia de productos
- **Productos relacionados:** Cada factory crea un conjunto coherente de productos
- **Interfaz común:** Todas las factories implementan la misma interfaz
- **Consistencia:** Garantiza que los productos de una familia sean compatibles
- **Intercambiabilidad:** Fácil cambio entre familias completas

**Beneficios:**
- Aísla clases concretas del cliente
- Facilita intercambio de familias de productos
- Promueve consistencia entre productos
- Cumple principio Abierto/Cerrado para nuevas familias
- Centraliza creación de productos relacionados

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **AbstractFactory (Factory Abstracta):** 
  - Declara interfaz para crear cada producto de la familia
  - Métodos factory para cada tipo de producto
  
- **ConcreteFactory (Factory Concreta):** 
  - Implementa las operaciones para crear productos concretos
  - Cada factory concreta corresponde a una familia de productos
  
- **AbstractProduct (Producto Abstracto):** 
  - Declara interfaz para un tipo de producto
  - Hay una interfaz por cada tipo de producto en la familia
  
- **ConcreteProduct (Producto Concreto):** 
  - Define un producto creado por la factory concreta correspondiente
  - Implementa la interfaz AbstractProduct

**Relaciones:**
- ConcreteFactory crea productos de la misma familia
- Client usa AbstractFactory y AbstractProduct (interfaces)
- Los productos de una familia están diseñados para trabajar juntos

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
abstract-factory/
├── context/
│   ├── UIFactory.java                # Factory abstracta
│   ├── WindowsUIFactory.java         # Factory: familia Windows
│   ├── MacUIFactory.java             # Factory: familia Mac
│   └── LinuxUIFactory.java           # Factory: familia Linux
├── strategy/
│   ├── Button.java                   # Producto abstracto: botón
│   ├── Menu.java                     # Producto abstracto: menú
│   └── Window.java                   # Producto abstracto: ventana
├── impl/
│   ├── WindowsButton.java            # Botón Windows
│   ├── WindowsMenu.java              # Menú Windows
│   ├── WindowsWindow.java            # Ventana Windows
│   ├── MacButton.java                # Botón Mac
│   ├── MacMenu.java                  # Menú Mac
│   ├── MacWindow.java                # Ventana Mac
│   ├── LinuxButton.java              # Botón Linux
│   ├── LinuxMenu.java                # Menú Linux
│   └── LinuxWindow.java              # Ventana Linux
└── Main.java                          # Demostración con diferentes familias
