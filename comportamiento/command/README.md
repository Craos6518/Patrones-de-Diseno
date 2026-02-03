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

Cuando necesitamos parametrizar objetos con operaciones, encolar solicitudes o implementar deshacer/rehacer:

- Acoplamiento directo entre el invocador y el receptor de la acción
- Imposibilidad de deshacer operaciones
- Difícil registrar o encolar solicitudes
- No se pueden parametrizar objetos con acciones
- Complejo implementar transacciones o macros

**Ejemplo:** Un editor de texto que necesita deshacer/rehacer acciones, o un control remoto universal.

---

## ✅ Solución

El patrón Command propone:

- **Encapsular solicitudes:** Cada solicitud es un objeto con toda la información necesaria
- **Interfaz Command:** Define un método `execute()` común
- **Desacoplamiento:** El invocador no conoce al receptor
- **Historial:** Los comandos pueden almacenarse para deshacer/rehacer
- **Composición:** Los comandos pueden combinarse en macros

**Beneficios:**
- Desacopla el objeto que invoca la operación del que la ejecuta
- Permite deshacer/rehacer operaciones
- Facilita encolar y programar solicitudes
- Soporta registro de cambios (logging)
- Permite crear comandos compuestos

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Command (Comando - Interfaz):** 
  - Declara una interfaz para ejecutar operaciones
  - Típicamente tiene método `execute()` y opcionalmente `undo()`
  
- **ConcreteCommand (Comando Concreto):** 
  - Implementa `execute()` invocando operaciones en el Receiver
  - Almacena el estado necesario para deshacer la operación
  
- **Invoker (Invocador):** 
  - Solicita al comando que ejecute la petición
  - No conoce cómo se implementa el comando
  
- **Receiver (Receptor):** 
  - Sabe cómo realizar las operaciones necesarias
  - Es quien realmente ejecuta la lógica de negocio

**Relaciones:**
- Invoker usa Command
- ConcreteCommand conoce a Receiver
- Client crea ConcreteCommand y lo asocia con Receiver

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
command/
├── context/
│   ├── TextEditor.java               # Receptor (realiza las acciones)
│   └── EditorInvoker.java            # Invocador (ejecuta comandos)
├── strategy/
│   └── Command.java                  # Interfaz del comando
├── impl/
│   ├── WriteCommand.java             # Comando: escribir texto
│   ├── DeleteCommand.java            # Comando: borrar texto
│   ├── CopyCommand.java              # Comando: copiar
│   └── PasteCommand.java             # Comando: pegar
└── Main.java                          # Demostración con undo/redo
