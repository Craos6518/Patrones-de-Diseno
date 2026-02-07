# 🎨 UI - Interfaz de Usuario

## 📌 Función

Contiene todas las vistas y controladores de la interfaz gráfica JavaFX.

## 🔧 Estructura

```
ui/
├── javafx/              # Vistas JavaFX
│   ├── MainMenuView.java
│   ├── GameView.java
│   ├── CombatView.java
│   ├── InventoryView.java
│   └── CharacterCreationView.java
└── controllers/         # Controladores FXML
    ├── MainMenuController.java
    ├── CombatController.java
    └── InventoryController.java
```

## 🎯 Responsabilidades

- Renderizar la interfaz gráfica del juego
- Capturar input del usuario (clicks, teclado)
- Actualizar la UI en respuesta a eventos (Observer)
- Conectar vistas FXML con lógica del juego
- Mostrar animaciones y efectos visuales

## 🖼️ Vistas Principales

### 1. MainMenuView
- Menú principal del juego
- Opciones: Nueva Partida, Cargar, Opciones, Salir
- Pantalla de créditos

### 2. CharacterCreationView
- Selección de clase (Guerrero, Mago, Explorador)
- Ingreso de nombre del personaje
- Distribución de puntos de habilidad
- Preview de stats

### 3. GameView
- Vista principal de exploración
- Mapa de la mazmorra actual
- Barra de stats del jugador (HP, Mana, XP)
- Botones de acción

### 4. CombatView
- Pantalla de combate por turnos
- Display de jugador y enemigos
- Botones de acción (Atacar, Defender, Habilidad, Item)
- Log de combate
- Animaciones de ataques

### 5. InventoryView
- Lista de items del jugador
- Equipamiento actual
- Opciones de usar/equipar/desechar items

## 📐 Arquitectura FXML + Controller

```
MainMenuView.java (código Java)
    ↓ carga
main_menu.fxml (diseño XML)
    ↓ vincula
MainMenuController.java (lógica)
    ↓ comunica con
GameController (core)
```

## 💡 Ejemplo de Vista JavaFX

```java
public class CombatView extends BorderPane implements GameObserver {
    private Label playerHealthLabel;
    private Label enemyHealthLabel;
    private TextArea combatLog;
    private Button attackButton;
    private Button defendButton;
    
    public CombatView() {
        initializeUI();
    }
    
    private void initializeUI() {
        // Crear componentes JavaFX
        playerHealthLabel = new Label("HP: 100/100");
        // ... más componentes
        
        // Configurar layout
        VBox playerPane = new VBox(playerHealthLabel);
        setLeft(playerPane);
    }
    
    @Override
    public void onGameEvent(GameEvent event) {
        // Observer Pattern: reaccionar a eventos
        if (event instanceof HealthChangedEvent) {
            updateHealthDisplay(event);
        }
    }
    
    private void updateHealthDisplay(GameEvent event) {
        Platform.runLater(() -> {
            playerHealthLabel.setText("HP: " + player.getHealth());
        });
    }
}
```

## 🎮 Controller FXML

```java
public class CombatController {
    @FXML private Label playerHealthLabel;
    @FXML private Button attackButton;
    @FXML private TextArea combatLog;
    
    private CombatFacade combat;
    
    @FXML
    public void onAttackButtonClicked() {
        TurnCommand attack = new AttackCommand(player, enemy);
        combat.executeTurn(attack);
    }
    
    @FXML
    public void onDefendButtonClicked() {
        TurnCommand defend = new DefendCommand(player);
        combat.executeTurn(defend);
    }
}
```

## 📄 Archivo FXML (main_menu.fxml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<VBox xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.utp.auralis.ui.controllers.MainMenuController"
      alignment="CENTER" spacing="20">
    
    <Label text="Crónicas de Auralis" style="-fx-font-size: 36;"/>
    
    <Button text="Nueva Partida" onAction="#onNewGameClicked"/>
    <Button text="Cargar Partida" onAction="#onLoadGameClicked"/>
    <Button text="Opciones" onAction="#onOptionsClicked"/>
    <Button text="Salir" onAction="#onExitClicked"/>
</VBox>
```

## 🎨 Estilos CSS

Los estilos se definen en `src/main/resources/css/style.css`:

```css
.combat-view {
    -fx-background-color: #1a1a2e;
}

.health-bar {
    -fx-background-color: #ff0000;
    -fx-pref-height: 20px;
}

.mana-bar {
    -fx-background-color: #0000ff;
    -fx-pref-height: 20px;
}

.attack-button {
    -fx-background-color: #e94560;
    -fx-text-fill: white;
    -fx-font-size: 14px;
}
```

## 🔗 Integración con Observer

Todas las vistas implementan `GameObserver` para reaccionar a eventos:

```java
// Registrar vista como observer
GameEventManager events = GameEventManager.getInstance();
events.addObserver(combatView);
events.addObserver(inventoryView);

// Cuando cambia la vida del jugador
player.takeDamage(20);
events.notifyObservers(new HealthChangedEvent(player));

// CombatView automáticamente actualiza la UI
```

## 🎯 Flujo de Interacción

```
1. Usuario hace click en "Atacar"
2. CombatController.onAttackButtonClicked()
3. Crea AttackCommand
4. CombatFacade.executeTurn(command)
5. GameEventManager notifica HealthChangedEvent
6. CombatView.onGameEvent() recibe notificación
7. CombatView actualiza barra de vida
```

## 🖼️ Assets Gráficos

Ubicados en `src/main/resources/images/`:
- `characters/` - Sprites de jugador
- `enemies/` - Sprites de enemigos
- `ui/` - Iconos, botones, fondos

---
**Patrón aplicado:** Observer (las vistas son observers)  
**Prioridad:** Alta
