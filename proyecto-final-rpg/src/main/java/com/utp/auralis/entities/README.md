# 👥 Entities - Entidades del Juego

## 📌 Función

Contiene las clases de entidades fundamentales del juego (personajes, items, habilidades).

## 🔧 Componentes Principales

- **Character.java** - Clase base abstracta para todos los personajes
- **Player.java** - Jugador controlado por el usuario
- **Enemy.java** - Enemigos del juego
- **Item.java** - Items, pociones, equipamiento
- **Skill.java** - Habilidades y ataques especiales
- **Stats.java** - Clase que encapsula estadísticas

## 🎯 Responsabilidades

- Definir estructura de datos de entidades
- Implementar comportamientos básicos (takeDamage, heal, etc.)
- Mantener estado de personajes (vida, mana, stats)
- Proveer interfaz para patrones (Decorator, Prototype, etc.)

## 📐 Jerarquía de Clases

```
<<abstract>> Character
├── name: String
├── stats: Stats
├── health: int
├── mana: int
├── level: int
├── effects: List<Effect>
├── takeDamage(amount: int)
├── heal(amount: int)
├── isAlive(): boolean
└── getStats(): Stats

Player extends Character
├── experience: int
├── inventory: List<Item>
├── equippedWeapon: Item
├── equippedArmor: Item
├── characterClass: CharacterClass
└── gainExperience(amount: int)

Enemy extends Character
├── enemyType: EnemyType
├── lootTable: List<Item>
├── experienceReward: int
└── clone(): Enemy (Prototype)
```

## 🎮 Stats - Estadísticas

```java
public class Stats {
    private int strength;      // Daño físico
    private int intelligence;  // Daño mágico
    private int defense;       // Reduce daño físico
    private int resistance;    // Reduce daño mágico
    private int speed;         // Orden de turnos
    private int luck;          // % crítico
    
    // Constructor, getters, setters
}
```

## 👤 Player - Jugador

```java
public class Player extends Character {
    private CharacterClass characterClass;
    private int experience;
    private int experienceToNextLevel;
    private List<Item> inventory;
    
    public void gainExperience(int amount) {
        experience += amount;
        if (experience >= experienceToNextLevel) {
            levelUp();
        }
    }
    
    public void levelUp() {
        level++;
        stats.increaseByClass(characterClass);
        // Notificar via Observer
    }
}
```

## 👹 Enemy - Enemigo

```java
public class Enemy extends Character implements Cloneable {
    private EnemyType type;
    private int experienceReward;
    private List<Item> lootTable;
    
    @Override
    public Enemy clone() {
        try {
            Enemy cloned = (Enemy) super.clone();
            cloned.stats = this.stats.copy();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

## 🎒 Item - Items

```java
public class Item {
    private String name;
    private ItemType type; // POTION, WEAPON, ARMOR, KEY
    private int value;
    
    public void use(Character target) {
        switch (type) {
            case POTION:
                target.heal(value);
                break;
            case WEAPON:
                target.equipWeapon(this);
                break;
            // ...
        }
    }
}
```

## ⚡ Skill - Habilidades

```java
public class Skill {
    private String name;
    private int manaCost;
    private int power;
    private SkillType type; // PHYSICAL, MAGICAL, BUFF, DEBUFF
    private int cooldown;
    
    public void cast(Character caster, Character target) {
        if (caster.getMana() >= manaCost) {
            caster.consumeMana(manaCost);
            applyEffect(caster, target);
        }
    }
}
```

## 🎭 Enumeraciones

```java
public enum CharacterClass {
    WARRIOR,    // Alto HP, defensa, daño físico
    MAGE,       // Alto mana, inteligencia, daño mágico
    SCOUT       // Alta velocidad, evasión, críticos
}

public enum EnemyType {
    GOBLIN,
    SLIME,
    DRAGON,
    SKELETON,
    BOSS
}

public enum ItemType {
    POTION,
    WEAPON,
    ARMOR,
    KEY,
    CONSUMABLE
}
```

## 🔗 Interacción con Patrones

- **Builder:** Construye instancias de Player
- **Factory Method:** Crea instancias de Enemy
- **Prototype:** Enemy.clone() para clonar enemigos
- **Decorator:** Character es decorado con efectos
- **Command:** Character ejecuta TurnCommands
- **Observer:** Character notifica cambios de estado

## 💡 Ejemplo de Uso

```java
// Crear jugador con Builder
Player player = new WarriorBuilder()
    .setName("Arthas")
    .setLevel(1)
    .build();

// Crear enemigo con Factory
EnemyFactory factory = new GoblinCreator();
Enemy goblin = factory.createEnemy(3); // Goblin nivel 3

// Aplicar daño
player.takeDamage(15);

// Ganar experiencia
player.gainExperience(50);

// Usar item
Item potion = new Item("Poción", ItemType.POTION, 30);
potion.use(player);
```

---
**Patrón aplicado:** Ninguno específico (son las entidades base del juego)  
**Prioridad:** Alta
