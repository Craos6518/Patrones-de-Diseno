# 🔊 Sounds - Efectos de Sonido

## 📌 Función

Contiene todos los efectos de sonido (SFX) del juego para mejorar la experiencia inmersiva.

## 🎯 Categorías de Sonidos

### ⚔️ Combate
- `attack.wav` - Ataque físico básico
- `hit.wav` - Impacto de golpe
- `critical.wav` - Golpe crítico (más impactante)
- `miss.wav` - Ataque fallido
- `block.wav` - Bloqueo/defensa exitosa
- `spell_cast.wav` - Lanzamiento de hechizo
- `magic_hit.wav` - Impacto mágico

### 💔 Daño y Muerte
- `player_hurt.wav` - Jugador recibe daño
- `enemy_hurt.wav` - Enemigo recibe daño
- `player_death.wav` - Muerte del jugador
- `enemy_death.wav` - Muerte de enemigo

### ⚡ Efectos y Buffs
- `buff.wav` - Aplicación de buff positivo
- `debuff.wav` - Aplicación de debuff negativo
- `poison.wav` - Efecto de veneno
- `heal.wav` - Curación
- `shield.wav` - Escudo activado

### 🎒 Items e Inventario
- `potion_drink.wav` - Beber poción
- `item_pickup.wav` - Recoger item
- `item_equip.wav` - Equipar arma/armadura
- `chest_open.wav` - Abrir cofre
- `coins.wav` - Obtener oro/monedas

### ⬆️ Progresión
- `level_up.wav` - Subir de nivel
- `experience_gain.wav` - Ganar experiencia
- `skill_learned.wav` - Aprender nueva habilidad
- `achievement.wav` - Logro desbloqueado

### 🎮 UI y Menú
- `menu_select.wav` - Selección de menú
- `menu_back.wav` - Retroceder en menú
- `button_click.wav` - Click en botón
- `menu_open.wav` - Abrir menú/inventario
- `menu_close.wav` - Cerrar menú

### 🏰 Ambiente
- `footsteps.wav` - Pasos del jugador
- `door_open.wav` - Abrir puerta
- `stairs.wav` - Subir/bajar escaleras

## 📐 Especificaciones Técnicas

### Formato
- **Preferido:** WAV (sin compresión)
- **Alternativo:** MP3, OGG
- **Sample Rate:** 44.1 kHz
- **Bit Depth:** 16-bit

### Duración
- **Efectos cortos:** 0.1 - 0.5 segundos (golpe, click)
- **Efectos medios:** 0.5 - 2 segundos (hechizo, curación)
- **Efectos largos:** 2 - 5 segundos (level up, logro)

### Tamaño
- **Optimizado:** < 100 KB por efecto
- **Compresión:** Si usas MP3, ~128 kbps

## 💡 Implementación en JavaFX

### Cargar y Reproducir Sonido

```java
import javafx.scene.media.AudioClip;

public class SoundManager {
    private Map<String, AudioClip> soundCache;
    
    public SoundManager() {
        soundCache = new HashMap<>();
        loadSounds();
    }
    
    private void loadSounds() {
        soundCache.put("attack", new AudioClip(
            getClass().getResource("/sounds/attack.wav").toExternalForm()
        ));
        soundCache.put("heal", new AudioClip(
            getClass().getResource("/sounds/heal.wav").toExternalForm()
        ));
        // ... más sonidos
    }
    
    public void playSound(String soundName) {
        AudioClip sound = soundCache.get(soundName);
        if (sound != null) {
            sound.play();
        }
    }
    
    public void playSound(String soundName, double volume) {
        AudioClip sound = soundCache.get(soundName);
        if (sound != null) {
            sound.play(volume); // 0.0 a 1.0
        }
    }
}
```

### Integración con Observer Pattern

```java
public class SoundObserver implements GameObserver {
    private SoundManager soundManager;
    
    public SoundObserver(SoundManager soundManager) {
        this.soundManager = soundManager;
    }
    
    @Override
    public void onGameEvent(GameEvent event) {
        switch (event.getType()) {
            case DAMAGE_DEALT:
                soundManager.playSound("hit");
                break;
            case HEALTH_CHANGED:
                if (event.getNewValue() > event.getOldValue()) {
                    soundManager.playSound("heal");
                } else {
                    soundManager.playSound("player_hurt");
                }
                break;
            case LEVEL_UP:
                soundManager.playSound("level_up");
                break;
            case ITEM_OBTAINED:
                soundManager.playSound("item_pickup");
                break;
        }
    }
}
```

### Control de Volumen

```java
public class SoundManager {
    private double masterVolume = 1.0;
    private double sfxVolume = 0.8;
    
    public void setMasterVolume(double volume) {
        this.masterVolume = Math.max(0.0, Math.min(1.0, volume));
    }
    
    public void playSound(String soundName) {
        AudioClip sound = soundCache.get(soundName);
        if (sound != null) {
            sound.play(masterVolume * sfxVolume);
        }
    }
}
```

## 🎨 Efectos Especiales

### Reproducir con Delay
```java
PauseTransition pause = new PauseTransition(Duration.millis(500));
pause.setOnFinished(e -> soundManager.playSound("delayed_sound"));
pause.play();
```

### Sonido en Loop (ambiente)
```java
AudioClip ambientSound = new AudioClip(
    getClass().getResource("/sounds/ambient_forest.wav").toExternalForm()
);
ambientSound.setCycleCount(AudioClip.INDEFINITE);
ambientSound.play();
```

### Fade Out
```java
Timeline fadeOut = new Timeline();
for (int i = 10; i >= 0; i--) {
    final double volume = i / 10.0;
    fadeOut.getKeyFrames().add(
        new KeyFrame(Duration.millis(i * 100), 
            e -> sound.setVolume(volume))
    );
}
fadeOut.play();
```

## 🔗 Fuentes de Sonidos Gratuitos

- **Freesound.org** - Comunidad de sonidos gratuitos
- **OpenGameArt.org** - Assets de juegos (audio incluido)
- **Sonniss.com** - GDC Audio bundles gratis
- **Zapsplat.com** - Efectos de sonido gratuitos
- **jsfxr.com** - Generador de sonidos retro

## 📋 Checklist de Sonidos

### Mínimo Viable
- ✅ attack.wav
- ✅ hit.wav
- ✅ heal.wav
- ✅ level_up.wav
- ✅ menu_select.wav

### Completo
- ✅ Todos los sonidos de combate
- ✅ Efectos de buffs/debuffs
- ✅ Sonidos de UI
- ✅ Sonidos de items
- ✅ Sonidos de ambiente

---
**Ubicación:** `src/main/resources/sounds/`  
**Formato:** WAV, MP3, OGG  
**Prioridad:** Media
