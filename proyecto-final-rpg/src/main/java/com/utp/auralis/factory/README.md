# 🏭 Factory - Factory Method Pattern

## 📌 Función

Implementa el patrón **Factory Method** para la creación dinámica de enemigos según zona y nivel.

## 🔧 Componentes Principales

- **EnemyFactory.java** - Interfaz o clase abstracta del factory
- **GoblinCreator.java** - Creador concreto de Goblins
- **SlimeCreator.java** - Creador concreto de Slimes
- **DragonCreator.java** - Creador concreto de Dragones

## 🎯 Responsabilidades

- Encapsular la lógica de creación de enemigos
- Desacoplar la creación de objetos de su uso
- Facilitar la adición de nuevos tipos de enemigos sin modificar código existente
- Generar enemigos con estadísticas apropiadas según nivel/zona

## ✅ Ventajas del Patrón

- ✅ Cumple el principio **Open/Closed** (SOLID)
- ✅ Evita acoplamiento entre lógica del juego y creación de entidades
- ✅ Facilita testing (se pueden mockear factories)
- ✅ Escalable para nuevos tipos de enemigos

## 📐 Diagrama UML

```
<<interface>> EnemyFactory
├── createEnemy(level: int): Enemy
│
├── GoblinCreator implements EnemyFactory
├── SlimeCreator implements EnemyFactory
└── DragonCreator implements EnemyFactory
```

## 💡 Ejemplo de Uso

```java
EnemyFactory factory = new GoblinCreator();
Enemy goblin = factory.createEnemy(5); // Goblin nivel 5
```

---
**Patrón:** Factory Method (Creacional)  
**Prioridad:** Alta
