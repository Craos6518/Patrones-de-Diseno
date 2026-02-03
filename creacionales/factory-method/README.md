# 🧩 Patrón: Factory Method

## 📌 Clasificación
- **Tipo:** Creacional
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Crear objetos sin especificar sus clases concretas, delegando la creación a métodos definidos en interfaces o clases abstractas.

> Permite que las subclases decidan qué clase instanciar.

---

## ❓ Problema

Cuando la creación de objetos depende de condiciones o tipos específicos:

- Código cliente acoplado a clases concretas
- Condicionales para decidir qué clase instanciar
- Difícil agregar nuevos tipos de productos
- Violación del principio Abierto/Cerrado
- Lógica de creación mezclada con lógica de negocio

**Ejemplo:** Un sistema de notificaciones que debe crear diferentes tipos de notificadores (Email, SMS, Push) según la preferencia del usuario.

---

## ✅ Solución

El patrón Factory Method propone:

- **Método factory:** Define una interfaz para crear objetos
- **Delegación a subclases:** Las subclases deciden qué clase instanciar
- **Desacoplamiento:** El código cliente trabaja con interfaces, no con clases concretas
- **Extensibilidad:** Nuevos productos se agregan mediante nuevas subclases
- **Polimorfismo:** La creación usa el polimorfismo en lugar de condicionales

**Beneficios:**
- Elimina acoplamiento con clases concretas
- Facilita agregar nuevos tipos de productos
- Cumple con el principio Abierto/Cerrado
- Centraliza lógica de creación
- Soporta el principio de Inversión de Dependencias

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Product (Producto - Interfaz):** 
  - Define la interfaz de los objetos que crea el factory method
  
- **ConcreteProduct (Producto Concreto):** 
  - Implementa la interfaz Product
  - Son los objetos específicos creados por las factories concretas
  
- **Creator (Creador):** 
  - Declara el factory method que retorna un objeto Product
  - Puede proporcionar implementación por defecto
  - Usa el factory method para obtener productos
  
- **ConcreteCreator (Creador Concreto):** 
  - Sobrescribe el factory method para retornar ConcreteProduct
  - Decide qué clase de producto instanciar

**Relaciones:**
- ConcreteCreator crea ConcreteProduct
- Creator depende solo de la interfaz Product
- Client trabaja con Creator y Product (interfaces)

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
factory-method/
├── context/
│   ├── NotificationFactory.java      # Creador abstracto
│   ├── EmailNotificationFactory.java # Factory concreto: Email
│   ├── SMSNotificationFactory.java   # Factory concreto: SMS
│   └── PushNotificationFactory.java  # Factory concreto: Push
├── strategy/
│   └── Notification.java             # Interfaz del producto
├── impl/
│   ├── EmailNotification.java        # Producto concreto: Email
│   ├── SMSNotification.java          # Producto concreto: SMS
│   └── PushNotification.java         # Producto concreto: Push
└── Main.java                          # Demostración de uso
