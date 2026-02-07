# 🌳 Composite - Composite Pattern

## 📌 Función

Implementa el patrón **Composite** para representar la estructura jerárquica de mazmorras y zonas del juego.

## 🔧 Componentes Principales

- **GameComponent.java** - Componente base (interfaz o clase abstracta)
- **Zone.java** - Composite que contiene salas (Composite)
- **Room.java** - Composite que contiene entidades (Composite)
- **Entity.java** - Leaf (enemigos, cofres, NPCs)

## 🎯 Responsabilidades

- Representar estructuras de árbol (mundo → zonas → salas → entidades)
- Tratar objetos individuales y compuestos uniformemente
- Facilitar la navegación recursiva por la estructura
- Permitir operaciones sobre toda la jerarquía

## ✅ Ventajas del Patrón

- ✅ Representa estructuras jerárquicas complejas
- ✅ Trata hojas y compuestos de manera uniforme
- ✅ Facilita agregar nuevos tipos de componentes
- ✅ Simplifica el código cliente (no diferencia entre hoja y compuesto)
- ✅ Muy visual y claro en diagramas UML

## 📐 Diagrama UML

```
<<interface>> GameComponent
├── render()
├── update()
├── add(component: GameComponent)
└── remove(component: GameComponent)

Implementaciones:
├── Zone (Composite)
│   └── rooms: List<Room>
├── Room (Composite)
│   └── entities: List<Entity>
└── Entity (Leaf)
    ├── Enemy
    ├── Chest
    └── NPC
```

## 💡 Ejemplo de Uso

```java
// Crear zona
Zone darkForest = new Zone("Bosque Oscuro");

// Crear salas
Room entrance = new Room("Entrada");
entrance.add(new Enemy("Goblin"));
entrance.add(new Chest("Poción"));

Room bossRoom = new Room("Sala del Jefe");
bossRoom.add(new Enemy("Dragón Negro"));

// Construir jerarquía
darkForest.add(entrance);
darkForest.add(bossRoom);

// Operación recursiva
darkForest.render(); // Renderiza toda la zona
```

## 🎮 Estructura del Mundo

```
World (Composite)
 ├── Zone 1: "Bosque Inicial" (Composite)
 │    ├── Room 1: "Campo abierto" (Composite)
 │    │    ├── Enemy: "Slime" (Leaf)
 │    │    └── Chest: "Poción" (Leaf)
 │    └── Room 2: "Cueva oscura" (Composite)
 │         └── Enemy: "Goblin" (Leaf)
 └── Zone 2: "Montañas" (Composite)
      └── Room: "Cumbre" (Composite)
           └── Enemy: "Dragón" (Leaf)
```

---
**Patrón:** Composite (Estructural)  
**Prioridad:** Alta
