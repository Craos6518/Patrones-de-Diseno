# 🎮 Command - Command Pattern

## 📌 Función

Implementa el patrón **Command** para encapsular acciones del combate como objetos, permitiendo undo/redo y cola de comandos.

## 🔧 Componentes Principales

- **TurnCommand.java** - Interfaz o clase abstracta del comando
- **AttackCommand.java** - Comando de ataque básico
- **DefendCommand.java** - Comando de defensa (bloqueo)
- **UseItemCommand.java** - Comando para usar items (poción, etc.)
- **SkillCommand.java** - Comando para habilidades especiales
- **CommandInvoker.java** - Gestor que ejecuta y almacena comandos

## 🎯 Responsabilidades

- Encapsular cada acción del combate como un objeto
- Permitir deshacer (undo) y rehacer (redo) acciones
- Mantener historial de comandos ejecutados
- Implementar cola de turnos para combate por turnos
- Facilitar logging de acciones para debugging

## ✅ Ventajas del Patrón

- ✅ Desacopla el invocador del ejecutor
- ✅ Permite undo/redo de forma natural
- ✅ Facilita implementar macros o combos
- ✅ Historial de combate para replay
- ✅ Fundamental para sistemas por turnos
- ✅ Fácil de extender con nuevas acciones

## 📐 Diagrama UML

```
<<interface>> TurnCommand
├── execute(): void
└── undo(): void

Implementaciones:
├── AttackCommand
│   ├── attacker: Character
│   ├── target: Character
│   ├── execute() { target.takeDamage(attacker.getAttack()); }
│   └── undo() { target.restoreHealth(damageDealt); }
├── DefendCommand
│   ├── defender: Character
│   ├── execute() { defender.setDefending(true); }
│   └── undo() { defender.setDefending(false); }
├── UseItemCommand
│   ├── user: Character
│   ├── item: Item
│   └── execute() { item.use(user); }
└── SkillCommand
    ├── caster: Character
    ├── skill: Skill
    └── execute() { skill.cast(caster, targets); }

CommandInvoker
├── commandHistory: Stack<TurnCommand>
├── executeCommand(cmd: TurnCommand)
├── undo()
└── redo()
```

## 💡 Ejemplo de Uso

```java
// Crear comandos
TurnCommand attack = new AttackCommand(player, enemy);
TurnCommand usePotion = new UseItemCommand(player, healthPotion);

// Invoker ejecuta comandos
CommandInvoker invoker = new CommandInvoker();
invoker.executeCommand(attack); // Ejecuta ataque

// Deshacer última acción
invoker.undo(); // Revierte el ataque
```

## 🎮 Flujo de Combate

```
1. Jugador selecciona acción → Crea Command
2. CommandInvoker ejecuta el comando
3. Comando modifica estado del juego
4. Comando se guarda en historial
5. Si jugador presiona CTRL+Z → undo()
6. Turno del enemigo (también usa Commands)
```

## 🔄 Sistema de Turnos

```java
Queue<TurnCommand> turnQueue = new LinkedList<>();

// Turno del jugador
turnQueue.add(new AttackCommand(player, enemy));

// Turno del enemigo
turnQueue.add(new AttackCommand(enemy, player));

// Ejecutar turnos
while (!turnQueue.isEmpty()) {
    TurnCommand cmd = turnQueue.poll();
    invoker.executeCommand(cmd);
}
```

---
**Patrón:** Command (Comportamiento)  
**Prioridad:** Alta
