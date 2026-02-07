# 👁️ Observer - Observer Pattern

## 📌 Función

Implementa el patrón **Observer** para notificar cambios de estado del juego a múltiples componentes (UI, logging, sonido).

## 🔧 Componentes Principales

- **GameEventManager.java** - Subject (gestor de eventos)
- **GameObserver.java** - Interfaz Observer
- **UIObserver.java** - Actualiza la interfaz gráfica
- **LogObserver.java** - Registra eventos en logs
- **SoundObserver.java** - Reproduce efectos de sonido
- **AnimationObserver.java** - Trigger animaciones visuales

## 🎯 Responsabilidades

- Notificar a múltiples observers cuando cambia el estado del juego
- Desacoplar la lógica del juego de la presentación (UI)
- Permitir agregar/remover observers dinámicamente
- Implementar sistema de eventos reactivo

## ✅ Ventajas del Patrón

- ✅ Imprescindible para JavaFX (UI reactiva)
- ✅ Desacopla lógica de presentación
- ✅ Múltiples componentes reaccionan a un evento
- ✅ Facilita debugging con LogObserver
- ✅ Escalable para nuevos observers
- ✅ Perfecto para arquitecturas event-driven

## 📐 Diagrama UML

```
<<interface>> GameObserver
└── onGameEvent(event: GameEvent): void

GameEventManager (Subject)
├── observers: List<GameObserver>
├── addObserver(observer: GameObserver)
├── removeObserver(observer: GameObserver)
└── notifyObservers(event: GameEvent)

Implementaciones de GameObserver:
├── UIObserver
│   └── onGameEvent() { updateHealthBar(); updateManaBar(); }
├── LogObserver
│   └── onGameEvent() { logger.info(event.toString()); }
├── SoundObserver
│   └── onGameEvent() { playSound(event.type); }
└── AnimationObserver
    └── onGameEvent() { triggerAnimation(event.type); }
```

## 💡 Ejemplo de Uso

```java
// Crear event manager
GameEventManager eventManager = new GameEventManager();

// Registrar observers
eventManager.addObserver(new UIObserver(gameView));
eventManager.addObserver(new LogObserver());
eventManager.addObserver(new SoundObserver());

// Cuando cambia la vida del jugador
player.takeDamage(20);
eventManager.notifyObservers(new HealthChangedEvent(player, 80, 60));

// Todos los observers reaccionan:
// - UIObserver: Actualiza barra de vida
// - LogObserver: "Player health: 80 -> 60"
// - SoundObserver: Reproduce sonido de daño
```

## 🎮 Eventos del Juego

### 💔 Eventos de Combate
- **HealthChangedEvent:** Vida cambia → UI actualiza barra
- **ManaChangedEvent:** Mana cambia → UI actualiza barra
- **DamageDealtEvent:** Se inflinge daño → animación + sonido
- **CharacterDefeatedEvent:** Personaje muere → animación + loot

### ⬆️ Eventos de Progresión
- **LevelUpEvent:** Sube nivel → animación + sonido + UI
- **ExperienceGainedEvent:** Gana XP → UI actualiza barra
- **ItemObtainedEvent:** Obtiene item → inventario se actualiza
- **SkillLearnedEvent:** Aprende habilidad → notificación

### 🎯 Eventos de Sistema
- **GameStateChangedEvent:** Cambio de estado (menú, combate, exploración)
- **SaveGameEvent:** Partida guardada → notificación
- **ErrorEvent:** Error en el sistema → log + notificación

## 🔄 Flujo de Eventos

```
1. Acción ocurre en el juego (player.takeDamage())
2. GameEventManager crea evento (HealthChangedEvent)
3. notifyObservers() llama a todos los observers
4. Cada observer reacciona según su responsabilidad:
   - UIObserver → Actualiza pantalla
   - LogObserver → Escribe en log
   - SoundObserver → Reproduce audio
```

## 🎨 Integración con JavaFX

```java
public class UIObserver implements GameObserver {
    private GameView view;
    
    @Override
    public void onGameEvent(GameEvent event) {
        Platform.runLater(() -> {
            if (event instanceof HealthChangedEvent) {
                view.updateHealthBar(event.getNewValue());
            } else if (event instanceof LevelUpEvent) {
                view.showLevelUpAnimation();
            }
        });
    }
}
```

---
**Patrón:** Observer (Comportamiento)  
**Prioridad:** Alta
