# 🧩 Patrón: Observer

## 📌 Clasificación
- **Tipo:** Comportamiento
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Definir una dependencia uno-a-muchos entre objetos de forma que cuando un objeto cambia de estado, todos sus dependientes sean notificados automáticamente.

> Crea un sistema flexible de notificaciones entre objetos desacoplados.

---

## ❓ Problema

Cuando múltiples objetos necesitan estar sincronizados con el estado de otro objeto:

- Acoplamiento fuerte entre el objeto observado y los observadores
- Código rígido que especifica qué objetos deben ser notificados
- Difícil agregar o quitar observadores sin modificar el sujeto
- Notificaciones manuales propensas a errores (olvidar notificar)
- Imposibilidad de suscripción/cancelación dinámica

**Ejemplo:** Un sistema de noticias donde múltiples pantallas deben actualizarse cuando llega una nueva noticia.

---

## ✅ Solución

El patrón Observer propone:

- **Sujeto (Subject):** Mantiene una lista de observadores y los notifica automáticamente
- **Observadores:** Se suscriben al sujeto para recibir actualizaciones
- **Notificación automática:** Cuando el sujeto cambia, notifica a todos sus observadores
- **Acoplamiento débil:** El sujeto solo conoce la interfaz del observador
- **Suscripción dinámica:** Los observadores pueden agregarse/eliminarse en tiempo de ejecución

**Beneficios:**
- Bajo acoplamiento entre sujeto y observadores
- Relación uno-a-muchos flexible
- Soporte para broadcast de comunicación
- Cumple con el principio Abierto/Cerrado

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Subject (Sujeto):** 
  - Conoce a sus observadores (lista)
  - Proporciona métodos para agregar/eliminar observadores
  - Notifica a los observadores cuando cambia su estado
  
- **Observer (Observador - Interfaz):** 
  - Define una interfaz de actualización para objetos que deben ser notificados
  
- **ConcreteSubject (Sujeto Concreto):** 
  - Almacena el estado de interés para los observadores
  - Envía notificaciones cuando su estado cambia
  
- **ConcreteObserver (Observador Concreto):** 
  - Mantiene una referencia al ConcreteSubject
  - Implementa la interfaz de actualización para mantener su estado consistente

**Relaciones:**
- Subject tiene muchos Observers (uno-a-muchos)
- ConcreteObserver conoce a ConcreteSubject
- Observer es notificado por Subject

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
observer/
├── context/
│   └── NewsPublisher.java            # Sujeto concreto (publicador)
├── strategy/
│   └── NewsObserver.java             # Interfaz del observador
├── impl/
│   ├── EmailSubscriber.java          # Observador: notifica por email
│   ├── MobileAppSubscriber.java      # Observador: notifica en app móvil
│   └── WebDashboardSubscriber.java   # Observador: actualiza dashboard web
└── Main.java                          # Demostración del patrón
