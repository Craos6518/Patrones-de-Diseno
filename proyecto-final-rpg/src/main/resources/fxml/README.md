# 📄 FXML - Archivos de Diseño de UI

## 📌 Función

Contiene los archivos FXML que definen la estructura visual de las vistas de JavaFX.

## 🎯 ¿Qué es FXML?

FXML es un formato XML para definir interfaces de usuario en JavaFX, similar a HTML para web.

**Ventajas:**
- ✅ Separa diseño de lógica
- ✅ Se puede editar con Scene Builder (visual)
- ✅ Fácil de mantener y modificar
- ✅ Soporte para binding de datos

## 📄 Archivos Esperados

### 1. main_menu.fxml
Menú principal del juego.

**Contenido:**
- Título del juego
- Botones: Nueva Partida, Cargar, Opciones, Salir
- Fondo animado (opcional)

### 2. character_creation.fxml
Pantalla de creación de personaje.

**Contenido:**
- Campo de texto para nombre
- Botones de selección de clase (Guerrero, Mago, Explorador)
- Preview de stats
- Botón confirmar/cancelar

### 3. game_view.fxml
Vista principal de exploración.

**Contenido:**
- Mapa de la mazmorra
- Panel de stats del jugador
- Inventario rápido
- Botones de acción

### 4. combat_view.fxml
Pantalla de combate por turnos.

**Contenido:**
- Display del jugador (izquierda)
- Display de enemigos (derecha)
- Botones de acción (Atacar, Defender, Habilidad, Item)
- Log de combate
- Barras de HP/Mana

### 5. inventory_view.fxml
Vista de inventario detallado.

**Contenido:**
- Grid de items
- Equipamiento actual
- Estadísticas del personaje
- Botones usar/equipar/desechar

## 💡 Ejemplo: combat_view.fxml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<BorderPane xmlns:fx="http://javafx.com/fxml"
            fx:controller="com.utp.auralis.ui.controllers.CombatController"
            prefHeight="600" prefWidth="800"
            styleClass="combat-view">
    
    <!-- Panel Izquierdo: Jugador -->
    <left>
        <VBox spacing="10" styleClass="player-panel">
            <Label fx:id="playerNameLabel" text="Player" styleClass="player-name"/>
            <ProgressBar fx:id="playerHealthBar" progress="1.0" styleClass="health-bar"/>
            <Label fx:id="playerHealthLabel" text="HP: 100/100"/>
            <ProgressBar fx:id="playerManaBar" progress="1.0" styleClass="mana-bar"/>
            <Label fx:id="playerManaLabel" text="MP: 50/50"/>
        </VBox>
    </left>
    
    <!-- Panel Derecho: Enemigo -->
    <right>
        <VBox spacing="10" styleClass="enemy-panel">
            <Label fx:id="enemyNameLabel" text="Goblin" styleClass="enemy-name"/>
            <ProgressBar fx:id="enemyHealthBar" progress="1.0" styleClass="health-bar"/>
            <Label fx:id="enemyHealthLabel" text="HP: 60/60"/>
        </VBox>
    </right>
    
    <!-- Panel Central: Sprites -->
    <center>
        <StackPane>
            <ImageView fx:id="playerSprite"/>
            <ImageView fx:id="enemySprite"/>
        </StackPane>
    </center>
    
    <!-- Panel Inferior: Acciones y Log -->
    <bottom>
        <VBox spacing="10">
            <!-- Botones de acción -->
            <HBox spacing="10" alignment="CENTER">
                <Button fx:id="attackButton" text="Atacar" 
                        onAction="#onAttackClicked" styleClass="attack-button"/>
                <Button fx:id="defendButton" text="Defender" 
                        onAction="#onDefendClicked" styleClass="defend-button"/>
                <Button fx:id="skillButton" text="Habilidad" 
                        onAction="#onSkillClicked" styleClass="skill-button"/>
                <Button fx:id="itemButton" text="Item" 
                        onAction="#onItemClicked" styleClass="item-button"/>
            </HBox>
            
            <!-- Log de combate -->
            <TextArea fx:id="combatLog" editable="false" 
                      prefHeight="100" styleClass="combat-log"/>
        </VBox>
    </bottom>
</BorderPane>
```

## 🎨 Vinculación con CSS

```xml
<!-- Aplicar clase CSS -->
<Button text="Atacar" styleClass="attack-button"/>

<!-- Estilo inline -->
<Label text="Player" style="-fx-font-size: 24px; -fx-text-fill: gold;"/>
```

## 🔗 Vinculación con Controller

```xml
<!-- Controller asociado -->
fx:controller="com.utp.auralis.ui.controllers.CombatController"

<!-- ID de componente (accesible desde controller) -->
<Label fx:id="playerHealthLabel"/>

<!-- Evento de acción -->
<Button onAction="#onAttackClicked"/>
```

## 🛠️ Scene Builder

**Scene Builder** es una herramienta visual para diseñar FXML sin escribir XML manualmente.

**Descarga:** https://gluonhq.com/products/scene-builder/

**Workflow:**
1. Abrir Scene Builder
2. Diseñar interfaz visualmente (drag & drop)
3. Asignar IDs y eventos
4. Exportar a archivo .fxml
5. Vincular con controller en código

## 📐 Cargar FXML en Java

```java
public class CombatView extends BorderPane {
    public CombatView() {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/combat_view.fxml")
            );
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

---
**Ubicación:** `src/main/resources/fxml/`  
**Herramienta:** Scene Builder  
**Prioridad:** Alta
