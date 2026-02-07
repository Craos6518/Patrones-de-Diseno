# 🗂️ Estructura del Proyecto - Crónicas de Auralis

## ✅ Estructura Actualizada a Java

El proyecto ha sido completamente actualizado a Java 17+ con JavaFX.

```
proyecto-final-rpg/
│
├── 📄 pom.xml                              # Configuración Maven
├── 📄 build.gradle                         # Configuración Gradle (alternativa)
├── 📄 .gitignore                           # Archivos ignorados (Java/Maven/Gradle)
├── 📄 README.md                            # Documentación principal
├── 📄 INSTALL.md                           # Guía de instalación
├── 📄 CHANGELOG.md                         # Historial de cambios
├── 📄 CONTRIBUTING.md                      # Guía de contribución
│
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/com/utp/auralis/
│   │   │   ├── 📄 README.md               # Punto de entrada
│   │   │   │
│   │   │   ├── 📁 core/                    # ⚙️ Núcleo del juego
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── GameController.java
│   │   │   │   └── GameConfig.java
│   │   │   │
│   │   │   ├── 📁 factory/                 # 🏭 Factory Method Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── EnemyFactory.java
│   │   │   │   ├── GoblinCreator.java
│   │   │   │   ├── SlimeCreator.java
│   │   │   │   └── DragonCreator.java
│   │   │   │
│   │   │   ├── 📁 builder/                 # 🔨 Builder Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── PlayerBuilder.java
│   │   │   │   ├── WarriorBuilder.java
│   │   │   │   ├── MageBuilder.java
│   │   │   │   └── ScoutBuilder.java
│   │   │   │
│   │   │   ├── 📁 prototype/               # 🧬 Prototype Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── Cloneable.java
│   │   │   │   └── EnemyPrototype.java
│   │   │   │
│   │   │   ├── 📁 composite/               # 📦 Composite Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── GameComponent.java
│   │   │   │   ├── Zone.java
│   │   │   │   ├── Room.java
│   │   │   │   └── Entity.java
│   │   │   │
│   │   │   ├── 📁 decorator/               # ⭐ Decorator Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── CharacterDecorator.java
│   │   │   │   ├── BuffDecorator.java
│   │   │   │   ├── PoisonDecorator.java
│   │   │   │   ├── ShieldDecorator.java
│   │   │   │   └── BurnDecorator.java
│   │   │   │
│   │   │   ├── 📁 command/                 # 🎮 Command Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── TurnCommand.java
│   │   │   │   ├── AttackCommand.java
│   │   │   │   ├── DefendCommand.java
│   │   │   │   ├── UseItemCommand.java
│   │   │   │   ├── SkillCommand.java
│   │   │   │   └── CommandInvoker.java
│   │   │   │
│   │   │   ├── 📁 observer/                # 👁️ Observer Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── GameEventManager.java
│   │   │   │   ├── GameObserver.java
│   │   │   │   ├── UIObserver.java
│   │   │   │   ├── LogObserver.java
│   │   │   │   └── SoundObserver.java
│   │   │   │
│   │   │   ├── 📁 facade/                  # 🎭 Facade Pattern
│   │   │   │   ├── 📄 README.md
│   │   │   │   └── CombatFacade.java
│   │   │   │
│   │   │   ├── 📁 combat/                  # ⚔️ Sistema de Combate
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── CombatSystem.java
│   │   │   │   ├── DamageCalculator.java
│   │   │   │   └── TurnManager.java
│   │   │   │
│   │   │   ├── 📁 entities/                # 👤 Entidades
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── Character.java
│   │   │   │   ├── Player.java
│   │   │   │   ├── Enemy.java
│   │   │   │   ├── Item.java
│   │   │   │   └── Skill.java
│   │   │   │
│   │   │   ├── 📁 ui/                      # 🖥️ Interfaz JavaFX
│   │   │   │   ├── 📄 README.md
│   │   │   │   ├── 📁 javafx/
│   │   │   │   │   ├── MainMenuView.java
│   │   │   │   │   ├── GameView.java
│   │   │   │   │   ├── CombatView.java
│   │   │   │   │   ├── InventoryView.java
│   │   │   │   │   └── CharacterCreationView.java
│   │   │   │   └── 📁 controllers/
│   │   │   │       ├── MainMenuController.java
│   │   │   │       └── CombatController.java
│   │   │   │
│   │   │   └── 📁 persistence/             # 💾 Guardado/Carga
│   │   │       ├── 📄 README.md
│   │   │       ├── SaveManager.java
│   │   │       └── GameState.java
│   │   │
│   │   └── 📁 resources/
│   │       ├── 📄 application.properties   # Configuración
│   │       ├── 📁 fxml/                    # Archivos FXML
│   │       │   ├── 📄 README.md
│   │       │   ├── main_menu.fxml
│   │       │   ├── game_view.fxml
│   │       │   └── combat_view.fxml
│   │       ├── 📁 css/                     # Estilos CSS
│   │       │   ├── 📄 README.md
│   │       │   └── style.css
│   │       ├── 📁 images/                  # Sprites
│   │       │   ├── 📄 README.md
│   │       │   ├── 📁 characters/
│   │       │   ├── 📁 enemies/
│   │       │   ├── 📁 items/
│   │       │   └── 📁 ui/
│   │       ├── 📁 sounds/                  # Efectos de sonido
│   │       │   └── 📄 README.md
│   │       └── 📁 music/                   # Música de fondo
│   │           └── 📄 README.md
│   │
│   └── 📁 test/java/com/utp/auralis/
│       ├── 📁 factory/                     # Tests Factory Method
│       │   └── 📄 README.md
│       ├── 📁 builder/                     # Tests Builder
│       │   └── 📄 README.md
│       ├── 📁 command/                     # Tests Command
│       │   └── 📄 README.md
│       ├── 📁 decorator/                   # Tests Decorator
│       │   └── 📄 README.md
│       ├── 📁 composite/                   # Tests Composite
│       │   └── 📄 README.md
│       ├── 📁 observer/                    # Tests Observer
│       │   └── 📄 README.md
│       └── 📁 combat/                      # Tests Combat System
│           └── 📄 README.md
│
├── 📁 docs/                                # 📚 Documentación
│   ├── 📄 README.md                        # Índice de documentación
│   ├── 📁 diagramas/
│   │   ├── clases_uml.png
│   │   ├── componentes.png
│   │   ├── flujo_combate.png
│   │   ├── secuencia_factory.png
│   │   ├── estructura_composite.png
│   │   └── modelo_er.png
│   ├── MANUAL_USUARIO.md
│   └── MANUAL_TECNICO.md
│
├── 📁 saves/                               # Partidas guardadas (generado)
│
└── 📁 target/ (o build/)                   # Compilados (generado)
```

## 🎯 Patrones de Diseño Organizados

La estructura está organizada por patrón de diseño:

### 🔨 Creacionales
1. ✅ **Factory Method** → `src/main/java/com/utp/auralis/factory/`
2. ✅ **Builder** → `src/main/java/com/utp/auralis/builder/`
3. ✅ **Prototype** → `src/main/java/com/utp/auralis/prototype/`

### 🧱 Estructurales
4. ✅ **Composite** → `src/main/java/com/utp/auralis/composite/`
5. ✅ **Decorator** → `src/main/java/com/utp/auralis/decorator/`
6. ✅ **Facade** → `src/main/java/com/utp/auralis/facade/`

### 🔄 Comportamiento
7. ✅ **Command** → `src/main/java/com/utp/auralis/command/`
8. ✅ **Observer** → `src/main/java/com/utp/auralis/observer/`

## 🚀 Siguiente Paso

Ejecutar el proyecto:

```bash
# Con Maven
mvn javafx:run

# Con Gradle
gradle run
```

## 📝 Notas

- ✅ Estructura profesional de Java
- ✅ Separación clara por patrones
- ✅ README en cada paquete
- ✅ Tests organizados
- ✅ Recursos separados
- ✅ Documentación completa
- ✅ Configuración Maven y Gradle

---

**Proyecto listo para desarrollo!** 🎮
