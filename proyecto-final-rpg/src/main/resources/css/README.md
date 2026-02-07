# 🎨 CSS - Hojas de Estilo

## 📌 Función

Contiene las hojas de estilo CSS para personalizar la apariencia de la interfaz JavaFX.

## 🎯 ¿Por qué CSS en JavaFX?

JavaFX soporta CSS (similar a CSS web) para estilizar componentes sin modificar código Java.

**Ventajas:**
- ✅ Separación de diseño y lógica
- ✅ Cambios visuales sin recompilar
- ✅ Temas consistentes en toda la UI
- ✅ Fácil mantenimiento

## 📄 Archivo Principal: style.css

```css
/* ========== CONFIGURACIÓN GLOBAL ========== */
.root {
    -fx-background-color: #1a1a2e;
    -fx-font-family: "Consolas", "Courier New", monospace;
}

/* ========== PANTALLA DE COMBATE ========== */
.combat-view {
    -fx-background-image: url('../images/backgrounds/combat_bg.png');
    -fx-background-size: cover;
}

.player-panel {
    -fx-background-color: rgba(0, 50, 100, 0.8);
    -fx-padding: 20;
    -fx-spacing: 10;
    -fx-border-color: gold;
    -fx-border-width: 2;
}

.enemy-panel {
    -fx-background-color: rgba(100, 0, 0, 0.8);
    -fx-padding: 20;
    -fx-spacing: 10;
    -fx-border-color: red;
    -fx-border-width: 2;
}

/* ========== BARRAS DE VIDA/MANA ========== */
.health-bar {
    -fx-accent: #ff0000;
}

.health-bar .bar {
    -fx-background-color: 
        linear-gradient(to bottom, #ff4444, #cc0000);
    -fx-background-radius: 5;
}

.mana-bar {
    -fx-accent: #0066ff;
}

.mana-bar .bar {
    -fx-background-color: 
        linear-gradient(to bottom, #4444ff, #0000cc);
    -fx-background-radius: 5;
}

/* ========== BOTONES ========== */
.button {
    -fx-background-color: #e94560;
    -fx-text-fill: white;
    -fx-font-size: 14px;
    -fx-font-weight: bold;
    -fx-padding: 10 20 10 20;
    -fx-background-radius: 5;
    -fx-cursor: hand;
}

.button:hover {
    -fx-background-color: #ff6b6b;
    -fx-scale-x: 1.05;
    -fx-scale-y: 1.05;
}

.button:pressed {
    -fx-background-color: #c43548;
}

.attack-button {
    -fx-background-color: #e94560;
}

.defend-button {
    -fx-background-color: #4a90e2;
}

.skill-button {
    -fx-background-color: #9b59b6;
}

.item-button {
    -fx-background-color: #27ae60;
}

/* ========== LABELS ========== */
.player-name {
    -fx-font-size: 24px;
    -fx-text-fill: gold;
    -fx-font-weight: bold;
}

.enemy-name {
    -fx-font-size: 24px;
    -fx-text-fill: #ff6666;
    -fx-font-weight: bold;
}

.stat-label {
    -fx-font-size: 14px;
    -fx-text-fill: white;
}

/* ========== LOG DE COMBATE ========== */
.combat-log {
    -fx-background-color: rgba(0, 0, 0, 0.8);
    -fx-text-fill: #00ff00;
    -fx-font-family: monospace;
    -fx-font-size: 12px;
}

/* ========== MENÚ PRINCIPAL ========== */
.main-menu {
    -fx-background-image: url('../images/backgrounds/main_menu_bg.png');
    -fx-background-size: cover;
}

.title-label {
    -fx-font-size: 48px;
    -fx-text-fill: gold;
    -fx-effect: dropshadow(gaussian, black, 10, 0.5, 0, 0);
    -fx-font-weight: bold;
}

.menu-button {
    -fx-font-size: 18px;
    -fx-min-width: 200px;
    -fx-background-color: #2c3e50;
    -fx-text-fill: white;
}

.menu-button:hover {
    -fx-background-color: #34495e;
}

/* ========== INVENTARIO ========== */
.inventory-grid {
    -fx-background-color: rgba(0, 0, 0, 0.5);
    -fx-padding: 10;
    -fx-hgap: 10;
    -fx-vgap: 10;
}

.item-slot {
    -fx-background-color: #2c3e50;
    -fx-border-color: #34495e;
    -fx-border-width: 2;
    -fx-pref-width: 64;
    -fx-pref-height: 64;
}

.item-slot:hover {
    -fx-border-color: gold;
    -fx-cursor: hand;
}

/* ========== EFECTOS ESPECIALES ========== */
.glow-effect {
    -fx-effect: dropshadow(gaussian, gold, 20, 0.8, 0, 0);
}

.damage-text {
    -fx-font-size: 32px;
    -fx-text-fill: red;
    -fx-font-weight: bold;
    -fx-effect: dropshadow(gaussian, black, 5, 1.0, 0, 0);
}

.heal-text {
    -fx-font-size: 32px;
    -fx-text-fill: #00ff00;
    -fx-font-weight: bold;
    -fx-effect: dropshadow(gaussian, black, 5, 1.0, 0, 0);
}

/* ========== ANIMACIONES ========== */
@keyframes shake {
    0%, 100% { -fx-translate-x: 0; }
    25% { -fx-translate-x: -10; }
    75% { -fx-translate-x: 10; }
}

.shake {
    -fx-animation: shake 0.3s;
}
```

## 🎨 Aplicar CSS en JavaFX

### Desde FXML:
```xml
<BorderPane styleClass="combat-view">
    <Button text="Atacar" styleClass="attack-button"/>
</BorderPane>
```

### Desde Java:
```java
// Aplicar hoja de estilos
scene.getStylesheets().add(
    getClass().getResource("/css/style.css").toExternalForm()
);

// Aplicar clase CSS a componente
button.getStyleClass().add("attack-button");

// Estilo inline
label.setStyle("-fx-font-size: 24px; -fx-text-fill: gold;");
```

## 🎨 Propiedades CSS Comunes de JavaFX

```css
/* COLORES */
-fx-background-color: #hexcolor;
-fx-text-fill: color;
-fx-border-color: color;

/* TIPOGRAFÍA */
-fx-font-family: "Font Name";
-fx-font-size: 14px;
-fx-font-weight: bold;

/* ESPACIADO */
-fx-padding: 10;
-fx-spacing: 5;

/* BORDES */
-fx-border-width: 2;
-fx-border-radius: 5;
-fx-background-radius: 5;

/* EFECTOS */
-fx-effect: dropshadow(gaussian, color, radius, spread, offsetX, offsetY);
-fx-effect: innershadow(...);

/* TAMAÑO */
-fx-min-width: 200;
-fx-pref-width: 300;
-fx-max-width: 400;
```

## 🌈 Temas del Juego

Puedes crear múltiples archivos CSS para diferentes temas:

```
css/
├── style.css          # Tema por defecto (oscuro)
├── light_theme.css    # Tema claro
└── retro_theme.css    # Tema retro
```

**Cambiar tema en runtime:**
```java
scene.getStylesheets().clear();
scene.getStylesheets().add(
    getClass().getResource("/css/light_theme.css").toExternalForm()
);
```

---
**Ubicación:** `src/main/resources/css/`  
**Referencia:** [JavaFX CSS Reference](https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/doc-files/cssref.html)  
**Prioridad:** Alta
