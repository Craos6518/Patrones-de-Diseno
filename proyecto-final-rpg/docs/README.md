# Documentación - Crónicas de Auralis

Documentación técnica y de usuario del proyecto.

## 📐 Diagramas UML

Los diagramas están en la carpeta `diagramas/`:

### 1. Diagrama de Clases Completo
**Archivo:** `clases_uml.png`

Muestra todas las clases del proyecto con:
- Atributos y métodos
- Relaciones (herencia, composición, agregación)
- Identificación de los 8 patrones GoF
- Interfaces y clases abstractas

### 2. Diagrama de Componentes
**Archivo:** `componentes.png`

Arquitectura de alto nivel:
```
UI (JavaFX)
  ├── GameController
  │     ├── CombatSystem (Facade)
  │     ├── DungeonGenerator (Composite)
  │     ├── EventManager (Observer)
  │     └── Persistence
```

### 3. Diagrama de Flujo - Combate
**Archivo:** `flujo_combate.png`

Flujo del sistema de combate por turnos:
1. Turno del jugador
2. Selección de acción (Command)
3. Ejecución via Facade
4. Cálculo de daño y efectos
5. Turno del enemigo
6. Verificación de victoria
7. Actualización UI (Observer)

### 4. Diagrama de Secuencia - Factory
**Archivo:** `secuencia_factory.png`

Interacción en la creación de enemigos:
```
GameController → EnemyFactory: createEnemy("dragon", 5)
EnemyFactory → DragonCreator: create()
DragonCreator → Enemy: new Enemy(stats)
Enemy → Prototype: clone()
```

### 5. Diagrama de Estructura - Composite
**Archivo:** `estructura_composite.png`

Jerarquía de mazmorras:
```
World
 ├── Zone (Dark Forest)
 │    ├── Room (Entrance)
 │    │    ├── Enemy (Goblin)
 │    │    └── Chest
 │    └── Room (Boss Room)
 │         └── Enemy (Dragon)
```

### 6. Diagrama ER (Opcional)
**Archivo:** `modelo_er.png`

Modelo de base de datos PostgreSQL:
- Player
- SaveGame
- Statistics
- Achievement

## 📚 Manuales

### Manual de Usuario
**Archivo:** `MANUAL_USUARIO.md`

Guía completa para jugadores:
- Tutorial de juego
- Controles
- Mecánicas
- Tips y estrategias

### Manual Técnico
**Archivo:** `MANUAL_TECNICO.md`

Documentación para desarrolladores:
- Arquitectura del sistema
- Explicación de patrones
- Guía de extensión
- API interna

## 🎯 Justificaciones de Patrones

Cada patrón tiene documentación detallada:

### Factory Method
- **Ubicación:** `src/main/java/com/utp/auralis/factory/README.md`
- **Justificación:** Creación dinámica de enemigos
- **Diagrama:** Incluido en clases_uml.png
- **Tests:** EnemyFactoryTest.java

### Builder
- **Ubicación:** `src/main/java/com/utp/auralis/builder/README.md`
- **Justificación:** Construcción compleja de personajes
- **Diagrama:** Incluido en clases_uml.png
- **Tests:** PlayerBuilderTest.java

### Prototype
- **Ubicación:** `src/main/java/com/utp/auralis/prototype/README.md`
- **Justificación:** Clonado eficiente para hordas
- **Diagrama:** Incluido en clases_uml.png
- **Tests:** En CombatSystemTest.java

### Composite
- **Ubicación:** `src/main/java/com/utp/auralis/composite/README.md`
- **Justificación:** Estructura jerárquica de mazmorras
- **Diagrama:** estructura_composite.png
- **Tests:** CompositeTest.java

### Decorator
- **Ubicación:** `src/main/java/com/utp/auralis/decorator/README.md`
- **Justificación:** Sistema de efectos apilables
- **Diagrama:** Incluido en clases_uml.png
- **Tests:** DecoratorTest.java

### Facade
- **Ubicación:** `src/main/java/com/utp/auralis/facade/README.md`
- **Justificación:** Simplificación del combate
- **Diagrama:** Incluido en clases_uml.png
- **Tests:** En CombatSystemTest.java

### Command
- **Ubicación:** `src/main/java/com/utp/auralis/command/README.md`
- **Justificación:** Sistema de turnos con undo
- **Diagrama:** Incluido en clases_uml.png
- **Tests:** CommandTest.java

### Observer
- **Ubicación:** `src/main/java/com/utp/auralis/observer/README.md`
- **Justificación:** UI reactiva en JavaFX
- **Diagrama:** Incluido en clases_uml.png
- **Tests:** ObserverTest.java

## 🔗 Referencias

- [JavaFX Documentation](https://openjfx.io/)
- [Design Patterns (Refactoring Guru)](https://refactoring.guru/design-patterns/java)
- [Game Programming Patterns](https://gameprogrammingpatterns.com/)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

## 📝 Notas de Desarrollo

- Todos los diagramas se pueden editar con Draw.io
- Mantener sincronizados con el código
- Actualizar después de cambios arquitectónicos
- Incluir fecha y versión en cada diagrama
