# 🎮 Core - Núcleo del Juego

## 📌 Función

Contiene las clases fundamentales del juego que coordinan toda la aplicación.

## 🔧 Componentes Principales

- **GameController.java** - Controlador principal que coordina todos los subsistemas
- **GameConfig.java** - Configuración global del juego (constantes, parámetros)

## 🎯 Responsabilidades

- Inicialización del juego
- Coordinación entre subsistemas (combate, UI, eventos)
- Gestión del ciclo de vida de la aplicación
- Manejo de estados del juego (menú, exploración, combate)

## 🔗 Interacciones

- Utiliza **CombatFacade** para gestionar combates
- Utiliza **GameEventManager** (Observer) para eventos
- Conecta la UI con la lógica del juego
- Coordina **DungeonGenerator** (Composite) para mazmorras

## 📐 Diagrama UML

```
GameController
├── startGame()
├── loadGame()
├── saveGame()
└── changeGameState()
```

---
**Patrón aplicado:** Ninguno específico (es el coordinador central)
