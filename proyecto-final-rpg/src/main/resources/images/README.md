# 🖼️ Images - Assets Gráficos

## 📌 Función

Contiene todos los sprites, iconos, fondos y elementos visuales del juego.

## 🗂️ Estructura

```
images/
├── characters/     # Sprites de personajes jugables
├── enemies/        # Sprites de enemigos
└── ui/             # Elementos de interfaz
```

## 🎮 Characters - Personajes

Sprites de las clases jugables y sus variaciones.

### Archivos esperados:
```
characters/
├── warrior.png         # Guerrero base
├── warrior_attack.png  # Animación de ataque
├── mage.png           # Mago base
├── mage_cast.png      # Animación de hechizo
├── scout.png          # Explorador base
└── scout_shoot.png    # Animación de disparo
```

### Especificaciones:
- **Formato:** PNG con transparencia
- **Tamaño:** 64x64 píxeles (o 128x128 para alta resolución)
- **Estilo:** Pixel Art o 2D sprites
- **Spritesheet:** Opcional (múltiples frames en una imagen)

## 👹 Enemies - Enemigos

Sprites de todos los enemigos del juego.

### Archivos esperados:
```
enemies/
├── goblin.png
├── goblin_attack.png
├── slime.png
├── dragon.png
├── dragon_fire.png
├── skeleton.png
└── boss_dragon.png    # Versión especial del jefe
```

### Categorías:
- **Comunes:** Goblin, Slime, Skeleton
- **Medios:** Orc, Troll, Ghost
- **Jefes:** Dragon, Dark Lord

### Especificaciones:
- **Formato:** PNG con fondo transparente
- **Tamaño:** Variable según enemigo
  - Pequeños (Slime): 32x32
  - Medianos (Goblin): 64x64
  - Grandes (Dragon): 128x128 o mayor
- **Estados:** Normal, Atacando, Herido, Muerto (opcional)

## 🎨 UI - Interfaz de Usuario

Elementos visuales de la interfaz.

### Estructura:
```
ui/
├── icons/          # Iconos pequeños
│   ├── sword.png
│   ├── shield.png
│   ├── potion.png
│   ├── spell.png
│   └── heart.png
├── backgrounds/    # Fondos de pantalla
│   ├── main_menu_bg.png
│   ├── combat_bg.png
│   └── forest_bg.png
└── buttons/        # Texturas de botones (opcional)
    ├── button_normal.png
    ├── button_hover.png
    └── button_pressed.png
```

### Iconos
- **Tamaño:** 32x32 o 48x48
- **Uso:** Inventario, habilidades, efectos de estado
- **Ejemplos:**
  - `sword.png` - Arma equipada
  - `shield.png` - Defensa
  - `potion.png` - Poción de vida
  - `buff.png` - Efecto positivo
  - `debuff.png` - Efecto negativo

### Fondos
- **Tamaño:** 800x600 o superior
- **Formato:** PNG o JPG
- **Ejemplos:**
  - `main_menu_bg.png` - Fondo del menú
  - `combat_bg.png` - Fondo de combate
  - `forest_bg.png` - Bosque
  - `cave_bg.png` - Cueva

## 💡 Cargar Imágenes en JavaFX

```java
// Cargar imagen simple
Image image = new Image(
    getClass().getResourceAsStream("/images/characters/warrior.png")
);

// Mostrar en ImageView
ImageView imageView = new ImageView(image);
imageView.setFitWidth(64);
imageView.setFitHeight(64);

// Cargar spritesheet
Image spritesheet = new Image("/images/characters/warrior_sheet.png");
ImageView view = new ImageView(spritesheet);
view.setViewport(new Rectangle2D(0, 0, 64, 64)); // Frame 1
```

## 🎬 Animaciones con Sprites

```java
public class SpriteAnimation {
    private ImageView imageView;
    private Image spritesheet;
    private int frameCount;
    private int currentFrame;
    
    public void playAnimation() {
        Timeline timeline = new Timeline();
        for (int i = 0; i < frameCount; i++) {
            final int frame = i;
            KeyFrame keyFrame = new KeyFrame(
                Duration.millis(i * 100),
                e -> updateFrame(frame)
            );
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }
    
    private void updateFrame(int frame) {
        int x = (frame % 4) * 64;  // 4 frames por fila
        int y = (frame / 4) * 64;
        imageView.setViewport(new Rectangle2D(x, y, 64, 64));
    }
}
```

## 🎨 Recomendaciones de Arte

### Estilo Visual
- **Pixel Art:** Estilo retro, fácil de crear
- **2D Sprites:** Arte más detallado
- **Consistente:** Mismo estilo en todo el juego

### Paleta de Colores
- **Jugador:** Tonos heroicos (azul, dorado)
- **Enemigos:** Tonos oscuros (rojo, verde oscuro)
- **UI:** Contraste alto para legibilidad

### Fuentes de Assets Gratuitos
- OpenGameArt.org
- Itch.io (sección de assets)
- Kenney.nl (assets gratuitos)
- Craftpix.net

## 📐 Tamaños Recomendados

| Tipo | Tamaño | Uso |
|------|--------|-----|
| Icono pequeño | 32x32 | Inventario, buffs |
| Sprite normal | 64x64 | Personajes, enemigos |
| Sprite grande | 128x128 | Jefes, elementos importantes |
| Fondo | 800x600+ | Fondos de pantalla |
| UI Button | Variable | Elementos de interfaz |

---
**Ubicación:** `src/main/resources/images/`  
**Formato:** PNG (recomendado)  
**Prioridad:** Alta
