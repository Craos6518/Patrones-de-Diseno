# 💾 Persistence - Sistema de Guardado/Carga

## 📌 Función

Implementa el sistema de persistencia para guardar y cargar el estado completo del juego.

## 🔧 Componentes Principales

- **SaveManager.java** - Gestor principal de guardado/carga
- **GameState.java** - Clase que encapsula todo el estado del juego
- **JsonSerializer.java** - Serializador JSON (usando Gson)
- **SaveSlot.java** - Representa un slot de guardado

## 🎯 Responsabilidades

- Guardar estado completo del juego en archivos
- Cargar partidas guardadas
- Gestionar múltiples slots de guardado (3 slots)
- Serializar/deserializar objetos Java a JSON
- Validar integridad de archivos guardados

## 💾 GameState - Estado del Juego

```java
public class GameState implements Serializable {
    private Player player;
    private List<Enemy> currentEnemies;
    private Zone currentZone;
    private Room currentRoom;
    private List<Item> worldItems;
    private long playTime;
    private LocalDateTime saveDate;
    
    // Getters y setters
}
```

## 📂 SaveManager - Gestor de Guardado

```java
public class SaveManager {
    private static final String SAVE_DIR = "saves/";
    private static final int MAX_SLOTS = 3;
    private Gson gson;
    
    public SaveManager() {
        this.gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    }
    
    public void saveGame(GameState state, int slot) {
        String filename = SAVE_DIR + "slot_" + slot + ".json";
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(state, writer);
            System.out.println("Partida guardada en slot " + slot);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
    
    public GameState loadGame(int slot) {
        String filename = SAVE_DIR + "slot_" + slot + ".json";
        try (FileReader reader = new FileReader(filename)) {
            GameState state = gson.fromJson(reader, GameState.class);
            System.out.println("Partida cargada desde slot " + slot);
            return state;
        } catch (IOException e) {
            System.err.println("Error al cargar: " + e.getMessage());
            return null;
        }
    }
    
    public boolean saveExists(int slot) {
        File file = new File(SAVE_DIR + "slot_" + slot + ".json");
        return file.exists();
    }
    
    public void deleteSave(int slot) {
        File file = new File(SAVE_DIR + "slot_" + slot + ".json");
        if (file.delete()) {
            System.out.println("Guardado eliminado: slot " + slot);
        }
    }
    
    public SaveSlot[] getAllSaveSlots() {
        SaveSlot[] slots = new SaveSlot[MAX_SLOTS];
        for (int i = 0; i < MAX_SLOTS; i++) {
            if (saveExists(i)) {
                slots[i] = loadSaveSlotInfo(i);
            } else {
                slots[i] = new SaveSlot(i, null, "Vacío");
            }
        }
        return slots;
    }
}
```

## 📋 SaveSlot - Información de Slot

```java
public class SaveSlot {
    private int slotNumber;
    private LocalDateTime saveDate;
    private String playerName;
    private int playerLevel;
    private String currentZone;
    private long playTime;
    
    public String getDisplayInfo() {
        if (isEmpty()) {
            return "Slot " + slotNumber + ": Vacío";
        }
        return String.format(
            "Slot %d: %s - Nivel %d - %s - %s",
            slotNumber, playerName, playerLevel, 
            currentZone, formatPlayTime()
        );
    }
}
```

## 💡 Ejemplo de Uso

```java
// Guardar partida
SaveManager saveManager = new SaveManager();
GameState currentState = new GameState(player, enemies, zone);
saveManager.saveGame(currentState, 0); // Guardar en slot 0

// Cargar partida
GameState loadedState = saveManager.loadGame(0);
if (loadedState != null) {
    player = loadedState.getPlayer();
    currentZone = loadedState.getCurrentZone();
    // Restaurar estado completo
}

// Ver slots disponibles
SaveSlot[] slots = saveManager.getAllSaveSlots();
for (SaveSlot slot : slots) {
    System.out.println(slot.getDisplayInfo());
}
```

## 📄 Formato JSON del Guardado

```json
{
  "player": {
    "name": "Arthas",
    "level": 5,
    "experience": 450,
    "characterClass": "WARRIOR",
    "stats": {
      "strength": 15,
      "intelligence": 8,
      "defense": 12,
      "speed": 10
    },
    "health": 95,
    "maxHealth": 120,
    "inventory": [
      {
        "name": "Poción",
        "type": "POTION",
        "value": 30
      }
    ]
  },
  "currentZone": {
    "name": "Bosque Oscuro",
    "level": 2
  },
  "currentRoom": {
    "name": "Claro del Bosque",
    "visited": true
  },
  "playTime": 3600,
  "saveDate": "2026-02-07T10:30:00"
}
```

## 🔒 Validación de Guardado

```java
public boolean validateSaveFile(String filename) {
    try {
        File file = new File(filename);
        if (!file.exists()) return false;
        
        // Verificar que se puede deserializar
        GameState state = loadGame(filename);
        if (state == null) return false;
        
        // Verificar integridad básica
        if (state.getPlayer() == null) return false;
        
        return true;
    } catch (Exception e) {
        return false;
    }
}
```

## 🎮 Integración con el Juego

```java
public class GameController {
    private SaveManager saveManager;
    private GameState currentState;
    
    public void saveCurrentGame(int slot) {
        // Capturar estado actual
        GameState state = new GameState(
            player,
            getCurrentEnemies(),
            currentZone,
            currentRoom,
            getPlayTime()
        );
        
        // Guardar
        saveManager.saveGame(state, slot);
        
        // Notificar via Observer
        eventManager.notifyObservers(new GameSavedEvent(slot));
    }
    
    public void loadGame(int slot) {
        GameState state = saveManager.loadGame(slot);
        if (state != null) {
            // Restaurar estado
            this.player = state.getPlayer();
            this.currentZone = state.getCurrentZone();
            // ... restaurar todo
            
            // Notificar
            eventManager.notifyObservers(new GameLoadedEvent());
        }
    }
}
```

## 📁 Estructura de Archivos

```
saves/
├── slot_0.json    # Partida 1
├── slot_1.json    # Partida 2
└── slot_2.json    # Partida 3
```

## 🔗 Relación con Patrones

- **Prototype:** Podría usarse para clonar GameState antes de guardar
- **Observer:** Notifica cuando se guarda/carga una partida
- **Builder:** Podría construir GameState complejo paso a paso

## ⚠️ Consideraciones

- ✅ Usar JSON para legibilidad y debugging
- ✅ Validar archivos antes de cargar
- ✅ Mantener compatibilidad entre versiones
- ✅ Hacer backups automáticos
- ❌ Evitar guardar durante combates
- ❌ No guardar referencias circulares

---
**Patrón aplicado:** Ninguno específico (podría aplicarse Memento)  
**Prioridad:** Media
