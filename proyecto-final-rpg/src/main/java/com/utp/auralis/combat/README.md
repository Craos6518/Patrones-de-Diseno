# ⚔️ Combat - Sistema de Combate

## 📌 Función

Contiene la lógica interna del sistema de combate por turnos, trabajando como subsistemas detrás de **CombatFacade**.

## 🔧 Componentes Principales

- **CombatSystem.java** - Sistema principal de combate
- **DamageCalculator.java** - Cálculo de daño con fórmulas complejas
- **TurnManager.java** - Gestión del orden y flujo de turnos
- **EffectManager.java** - Aplicación de buffs/debuffs
- **AIController.java** - Inteligencia artificial de enemigos

## 🎯 Responsabilidades

- Implementar mecánicas de combate por turnos
- Calcular daño considerando stats, críticos, resistencias
- Gestionar orden de turnos según velocidad
- Aplicar efectos de estado cada turno
- Controlar comportamiento de enemigos (IA básica)

## 🔧 DamageCalculator - Cálculo de Daño

```java
public class DamageCalculator {
    public int calculatePhysicalDamage(Character attacker, Character defender) {
        int baseDamage = attacker.getAttack();
        int defense = defender.getDefense();
        
        // Fórmula base
        int damage = Math.max(1, baseDamage - defense / 2);
        
        // Crítico (15% probabilidad)
        if (isCritical(attacker.getLuck())) {
            damage *= 2;
        }
        
        // Variación aleatoria (90%-110%)
        damage *= (0.9 + Math.random() * 0.2);
        
        return damage;
    }
    
    public int calculateMagicalDamage(Character attacker, Character defender) {
        // Similar pero usa Intelligence y Resistance
    }
}
```

## 🔄 TurnManager - Gestión de Turnos

```java
public class TurnManager {
    private Queue<Character> turnOrder;
    
    public void initializeCombat(Player player, List<Enemy> enemies) {
        // Ordenar por velocidad (Speed stat)
        turnOrder = new PriorityQueue<>(
            Comparator.comparingInt(Character::getSpeed).reversed()
        );
        
        turnOrder.add(player);
        turnOrder.addAll(enemies);
    }
    
    public Character getNextTurn() {
        Character current = turnOrder.poll();
        turnOrder.add(current); // Re-agregar al final
        return current;
    }
}
```

## ⚡ EffectManager - Gestión de Efectos

```java
public class EffectManager {
    public void processEndOfTurnEffects(Character character) {
        // Procesar veneno
        if (character.hasEffect(EffectType.POISON)) {
            character.takeDamage(3);
        }
        
        // Procesar regeneración
        if (character.hasEffect(EffectType.REGEN)) {
            character.heal(5);
        }
        
        // Decrementar duración de efectos
        character.decrementEffectDurations();
    }
    
    public int applyBuffsToAttack(int baseDamage, Character attacker) {
        if (attacker.hasEffect(EffectType.ATTACK_BUFF)) {
            return baseDamage + 5;
        }
        return baseDamage;
    }
}
```

## 🤖 AIController - Inteligencia Artificial

```java
public class AIController {
    public TurnCommand selectAction(Enemy enemy, Player player) {
        // IA simple basada en estados
        
        // Si la vida es baja, usar poción
        if (enemy.getHealthPercent() < 30 && enemy.hasItem("Poción")) {
            return new UseItemCommand(enemy, enemy.getItem("Poción"));
        }
        
        // Si el jugador tiene poca vida, atacar
        if (player.getHealthPercent() < 40) {
            return new AttackCommand(enemy, player);
        }
        
        // Si tiene habilidad disponible, usarla
        if (enemy.hasSkillReady()) {
            return new SkillCommand(enemy, enemy.getBestSkill(), player);
        }
        
        // Por defecto, atacar
        return new AttackCommand(enemy, player);
    }
}
```

## 🎮 Flujo Completo de un Turno

```
1. TurnManager determina quién actúa
2. Si es jugador: espera input
   Si es enemigo: AIController decide acción
3. Se crea un TurnCommand
4. DamageCalculator calcula daño
5. EffectManager aplica buffs/debuffs
6. Daño se aplica al objetivo
7. GameEventManager notifica observers
8. EffectManager procesa efectos de fin de turno
9. TurnManager pasa al siguiente turno
```

## 📐 Fórmulas de Combate

### Daño Físico
```
baseDamage = attacker.attack
damage = baseDamage - (defender.defense / 2)
if (critical) damage *= 2
damage *= randomFactor(0.9, 1.1)
```

### Daño Mágico
```
baseDamage = attacker.intelligence * skillPower
damage = baseDamage - (defender.resistance / 3)
damage *= elementalMultiplier
```

### Orden de Turnos
```
turnOrder = sortedBy(characters, speed, descending)
```

## 🔗 Interacción con Otros Patrones

- **Command:** Ejecuta TurnCommands
- **Decorator:** Aplica efectos que modifican stats
- **Observer:** Notifica cambios de estado
- **Facade:** CombatFacade coordina todos estos subsistemas

---
**Patrón aplicado:** Ninguno específico (son subsistemas coordinados por Facade)  
**Prioridad:** Alta
