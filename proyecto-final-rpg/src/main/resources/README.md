# 📦 Resources - Recursos del Juego

## 📌 Función

Contiene todos los recursos no-código del juego (archivos FXML, CSS, imágenes, sonidos, música).

## 🗂️ Estructura

```
resources/
├── fxml/          # Archivos FXML de diseño de UI
├── css/           # Hojas de estilo CSS
├── images/        # Sprites y gráficos
│   ├── characters/
│   ├── enemies/
│   └── ui/
├── sounds/        # Efectos de sonido
└── music/         # Música de fondo
```

## 🎯 Responsabilidades

- Almacenar archivos de interfaz FXML
- Almacenar estilos CSS para JavaFX
- Almacenar assets gráficos (sprites, iconos, fondos)
- Almacenar audio (efectos de sonido y música)

## 📄 FXML Files

Los archivos FXML definen la estructura visual de las vistas JavaFX. Son similares a HTML pero para JavaFX.

### Archivos esperados:
- `main_menu.fxml` - Menú principal
- `character_creation.fxml` - Creación de personaje
- `game_view.fxml` - Vista de exploración
- `combat_view.fxml` - Vista de combate
- `inventory_view.fxml` - Vista de inventario

## 🎨 CSS Styles

Los estilos CSS personalizan la apariencia de la UI de JavaFX.

### style.css
```css
/* Tema oscuro para el juego */
.root {
    -fx-background-color: #1a1a2e;
}

.button {
    -fx-background-color: #e94560;
    -fx-text-fill: white;
    -fx-font-size: 14px;
}

.button:hover {
    -fx-background-color: #ff6b6b;
}
```

## 🖼️ Images

### Estructura de imágenes:
```
images/
├── characters/
│   ├── warrior.png
│   ├── mage.png
│   └── scout.png
├── enemies/
│   ├── goblin.png
│   ├── slime.png
│   └── dragon.png
└── ui/
    ├── icons/
    ├── backgrounds/
    └── buttons/
```

### Formato recomendado:
- PNG con transparencia
- Pixel Art 32x32, 64x64
- Spritesheet para animaciones

## 🔊 Sounds

Efectos de sonido para acciones del juego.

### Esperados:
- `attack.wav` - Sonido de ataque
- `hit.wav` - Sonido de impacto
- `heal.wav` - Sonido de curación
- `level_up.wav` - Sonido de subida de nivel
- `menu_select.wav` - Selección de menú

### Formato:
- WAV o MP3
- Duración corta (< 3 segundos)
- Tamaño optimizado

## 🎵 Music

Música de fondo para diferentes zonas/situaciones.

### Esperadas:
- `menu_theme.mp3` - Tema del menú
- `forest_theme.mp3` - Música del bosque
- `combat_theme.mp3` - Música de combate
- `boss_theme.mp3` - Música de jefe

### Formato:
- MP3 (calidad media, ~128kbps)
- Loop sin cortes perceptibles

## 💡 Cómo Cargar Recursos

```java
// Cargar imagen
Image image = new Image(
    getClass().getResourceAsStream("/images/characters/warrior.png")
);

// Cargar FXML
FXMLLoader loader = new FXMLLoader(
    getClass().getResource("/fxml/combat_view.fxml")
);

// Cargar CSS
scene.getStylesheets().add(
    getClass().getResource("/css/style.css").toExternalForm()
);

// Cargar sonido
AudioClip sound = new AudioClip(
    getClass().getResource("/sounds/attack.wav").toExternalForm()
);
sound.play();
```

## 📁 Referencias en el Proyecto

- **UI Views:** Cargan archivos FXML desde esta carpeta
- **Controllers:** Acceden a imágenes y sonidos
- **Observer:** SoundObserver reproduce audio de aquí

---
**Ubicación:** `src/main/resources/`  
**Prioridad:** Alta
