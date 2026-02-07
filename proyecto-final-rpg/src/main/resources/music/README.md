# 🎵 Music - Música de Fondo

## 📌 Función

Contiene las pistas de música de fondo (BGM - Background Music) para diferentes zonas y situaciones del juego.

## 🎯 Tipos de Música

### 🎮 Menús
- `menu_theme.mp3` - Tema del menú principal
- `character_creation.mp3` - Música para creación de personaje
- `game_over.mp3` - Música de derrota

### 🏰 Zonas/Mazmorras
- `forest_theme.mp3` - Bosque inicial (tranquilo)
- `cave_theme.mp3` - Cuevas oscuras (misterioso)
- `mountain_theme.mp3` - Montañas (épico)
- `dungeon_theme.mp3` - Mazmorra (tenso)
- `castle_theme.mp3` - Castillo final (grandioso)

### ⚔️ Combate
- `combat_normal.mp3` - Combate normal (energético)
- `combat_boss.mp3` - Combate contra jefe (épico intenso)
- `victory.mp3` - Victoria en combate (triunfante, corto)

### 🎊 Eventos Especiales
- `level_up_fanfare.mp3` - Fanfarria de subida de nivel (corta)
- `quest_complete.mp3` - Misión completada
- `credits.mp3` - Créditos finales

## 📐 Especificaciones Técnicas

### Formato
- **Preferido:** MP3 (buena compresión)
- **Alternativo:** OGG, WAV (sin compresión)
- **Bitrate:** 128-192 kbps (calidad media)
- **Sample Rate:** 44.1 kHz

### Duración
- **Temas de zona:** 2-4 minutos (loop perfecto)
- **Combate:** 2-3 minutos (loop)
- **Eventos:** 5-15 segundos (fanfarrias)
- **Menú:** 2-3 minutos (loop tranquilo)

### Loop
- **Crear loops perfectos:** Asegurar que el final conecte con el inicio sin cortes
- **Fade in/out:** Opcional para transiciones suaves

### Tamaño
- **Objetivo:** < 5 MB por pista
- **Compresión:** 128 kbps es suficiente para la mayoría

## 💡 Implementación en JavaFX

### Reproductor de Música

```java
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicManager {
    private MediaPlayer currentPlayer;
    private Map<String, Media> musicCache;
    private double volume = 0.5;
    
    public MusicManager() {
        musicCache = new HashMap<>();
        loadMusic();
    }
    
    private void loadMusic() {
        musicCache.put("menu", new Media(
            getClass().getResource("/music/menu_theme.mp3").toExternalForm()
        ));
        musicCache.put("forest", new Media(
            getClass().getResource("/music/forest_theme.mp3").toExternalForm()
        ));
        musicCache.put("combat", new Media(
            getClass().getResource("/music/combat_normal.mp3").toExternalForm()
        ));
        // ... más música
    }
    
    public void playMusic(String trackName) {
        stopMusic(); // Detener música actual
        
        Media media = musicCache.get(trackName);
        if (media != null) {
            currentPlayer = new MediaPlayer(media);
            currentPlayer.setVolume(volume);
            currentPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop infinito
            currentPlayer.play();
        }
    }
    
    public void stopMusic() {
        if (currentPlayer != null) {
            currentPlayer.stop();
            currentPlayer.dispose();
            currentPlayer = null;
        }
    }
    
    public void pauseMusic() {
        if (currentPlayer != null) {
            currentPlayer.pause();
        }
    }
    
    public void resumeMusic() {
        if (currentPlayer != null) {
            currentPlayer.play();
        }
    }
    
    public void setVolume(double volume) {
        this.volume = Math.max(0.0, Math.min(1.0, volume));
        if (currentPlayer != null) {
            currentPlayer.setVolume(this.volume);
        }
    }
}
```

### Transiciones Suaves

```java
public void fadeOutAndPlay(String newTrack) {
    if (currentPlayer != null) {
        Timeline fadeOut = new Timeline();
        for (int i = 10; i >= 0; i--) {
            final double vol = (i / 10.0) * volume;
            fadeOut.getKeyFrames().add(
                new KeyFrame(Duration.millis(i * 100), 
                    e -> currentPlayer.setVolume(vol))
            );
        }
        fadeOut.setOnFinished(e -> {
            stopMusic();
            playMusic(newTrack);
            fadeIn();
        });
        fadeOut.play();
    } else {
        playMusic(newTrack);
        fadeIn();
    }
}

private void fadeIn() {
    if (currentPlayer != null) {
        Timeline fadeIn = new Timeline();
        for (int i = 0; i <= 10; i++) {
            final double vol = (i / 10.0) * volume;
            fadeIn.getKeyFrames().add(
                new KeyFrame(Duration.millis(i * 100), 
                    e -> currentPlayer.setVolume(vol))
            );
        }
        fadeIn.play();
    }
}
```

### Integración con Game State

```java
public class GameController {
    private MusicManager musicManager;
    
    public void changeGameState(GameState newState) {
        switch (newState) {
            case MAIN_MENU:
                musicManager.fadeOutAndPlay("menu");
                break;
            case EXPLORATION:
                musicManager.fadeOutAndPlay(getCurrentZoneMusic());
                break;
            case COMBAT:
                if (isBossFight()) {
                    musicManager.fadeOutAndPlay("combat_boss");
                } else {
                    musicManager.fadeOutAndPlay("combat");
                }
                break;
            case GAME_OVER:
                musicManager.fadeOutAndPlay("game_over");
                break;
        }
    }
    
    private String getCurrentZoneMusic() {
        return switch (currentZone.getName()) {
            case "Dark Forest" -> "forest";
            case "Crystal Caves" -> "cave";
            case "Dragon Mountain" -> "mountain";
            default -> "dungeon";
        };
    }
}
```

### Reproductorde Fanfarrias (Eventos Cortos)

```java
public void playFanfare(String fanfareName) {
    // Pausar música actual temporalmente
    pauseMusic();
    
    Media fanfare = musicCache.get(fanfareName);
    MediaPlayer fanfarePlayer = new MediaPlayer(fanfare);
    fanfarePlayer.setVolume(volume);
    fanfarePlayer.setOnEndOfMedia(() -> {
        fanfarePlayer.dispose();
        resumeMusic(); // Reanudar música de fondo
    });
    fanfarePlayer.play();
}

// Uso:
musicManager.playFanfare("level_up"); // Toca fanfarria, luego vuelve a música normal
```

## 📋 Integración con Observer

```java
public class MusicObserver implements GameObserver {
    private MusicManager musicManager;
    
    @Override
    public void onGameEvent(GameEvent event) {
        switch (event.getType()) {
            case ZONE_CHANGED:
                String zoneName = ((ZoneChangedEvent) event).getZoneName();
                musicManager.fadeOutAndPlay(getZoneMusic(zoneName));
                break;
            case COMBAT_STARTED:
                musicManager.fadeOutAndPlay("combat");
                break;
            case COMBAT_ENDED:
                musicManager.fadeOutAndPlay(getCurrentZoneMusic());
                break;
            case LEVEL_UP:
                musicManager.playFanfare("level_up");
                break;
        }
    }
}
```

## 🎨 Mapa de Música por Estado

| Estado del Juego | Pista de Música | Loop | Mood |
|------------------|-----------------|------|------|
| Menú Principal | menu_theme.mp3 | ✅ | Épico, acogedor |
| Creación de Personaje | character_creation.mp3 | ✅ | Inspirador |
| Bosque Inicial | forest_theme.mp3 | ✅ | Tranquilo, aventurero |
| Cuevas | cave_theme.mp3 | ✅ | Misterioso, tenso |
| Combate Normal | combat_normal.mp3 | ✅ | Energético, rápido |
| Combate Jefe | combat_boss.mp3 | ✅ | Épico, intenso |
| Victoria | victory.mp3 | ❌ | Triunfante (5-10s) |
| Level Up | level_up_fanfare.mp3 | ❌ | Fanfarria (3-5s) |
| Game Over | game_over.mp3 | ❌ | Sombrío, melancólico |

## 🔗 Fuentes de Música Gratuita

- **Incompetech.com** - Kevin MacLeod (libre con atribución)
- **OpenGameArt.org** - Música para juegos (varias licencias)
- **FreePD.com** - Dominio público
- **YouTube Audio Library** - Música libre de derechos
- **Bensound.com** - Música gratuita (con atribución)
- **Purple Planet Music** - Música gratuita para juegos

## ⚙️ Configuración de Audio

```java
public class AudioSettings {
    private double masterVolume = 1.0;
    private double musicVolume = 0.7;
    private double sfxVolume = 0.8;
    private boolean musicEnabled = true;
    
    public void applySettings() {
        double finalVolume = masterVolume * musicVolume;
        musicManager.setVolume(musicEnabled ? finalVolume : 0.0);
    }
}
```

---
**Ubicación:** `src/main/resources/music/`  
**Formato:** MP3 (recomendado), OGG  
**Prioridad:** Media
