# 🎭 Facade - Facade Pattern

## 📌 Función

Implementa el patrón **Facade** para simplificar la interfaz del complejo sistema de combate.

## 🔧 Componentes Principales

- **CombatFacade.java** - Fachada que simplifica el sistema de combate

### Subsistemas que oculta la Fachada:
- **DamageCalculator** - Cálculo complejo de daño (críticos, resistencias)
- **TurnManager** - Gestión del orden de turnos
- **EffectManager** - Aplicación de efectos y estados
- **AIController** - Inteligencia artificial de enemigos
- **CombatLogger** - Registro detallado del combate

## 🎯 Responsabilidades

- Proporcionar interfaz simple para operaciones de combate complejas
- Ocultar la complejidad de múltiples subsistemas
- Coordinar interacciones entre sistemas internos
- Facilitar el uso del sistema de combate desde GameController

## ✅ Ventajas del Patrón

- ✅ Reduce complejidad para el código cliente
- ✅ Desacopla cliente de subsistemas internos
- ✅ Facilita testing (se puede mockear la fachada)
- ✅ Mejora mantenibilidad del código
- ✅ Centraliza lógica de combate

## 📐 Diagrama UML

```
CombatFacade
├── startCombat(player: Player, enemies: List<Enemy>)
├── executeTurn(command: TurnCommand)
├── endTurn()
├── checkVictoryCondition(): boolean
└── getCombatReport(): CombatReport

Subsistemas internos (ocultos):
├── DamageCalculator
│   ├── calculatePhysicalDamage()
│   ├── calculateMagicalDamage()
│   └── applyCritical()
├── TurnManager
│   ├── determineTurnOrder()
│   └── getNextTurn()
├── EffectManager
│   ├── applyBuffs()
│   └── applyDebuffs()
└── AIController
    └── selectEnemyAction()
```

## 💡 Ejemplo de Uso

### Sin Facade (complejo):
```java
// Cliente tiene que conocer todos los subsistemas
DamageCalculator damageCalc = new DamageCalculator();
TurnManager turnMgr = new TurnManager();
EffectManager effectMgr = new EffectManager();

int damage = damageCalc.calculatePhysicalDamage(attacker, defender);
damage = effectMgr.applyBuffs(damage, attacker);
damage = effectMgr.applyDebuffs(damage, defender);
defender.takeDamage(damage);
effectMgr.processTurnEffects(defender);
turnMgr.nextTurn();
// ... código complejo
```

### Con Facade (simple):
```java
// Cliente usa interfaz simple
CombatFacade combat = new CombatFacade();
combat.startCombat(player, List.of(enemy1, enemy2));

TurnCommand attack = new AttackCommand(player, enemy1);
combat.executeTurn(attack); // Toda la complejidad está oculta

if (combat.checkVictoryCondition()) {
    combat.endCombat();
}
```

## 🎮 Flujo de Combate Simplificado

```
GameController
     │
     ├──► CombatFacade.startCombat()
     │         │
     │         ├──► TurnManager.initialize()
     │         ├──► EffectManager.reset()
     │         └──► AIController.setup()
     │
     ├──► CombatFacade.executeTurn(command)
     │         │
     │         ├──► DamageCalculator.calculate()
     │         ├──► EffectManager.apply()
     │         ├──► TurnManager.nextTurn()
     │         └──► GameEventManager.notify()
     │
     └──► CombatFacade.checkVictoryCondition()
               │
               └──► return (allEnemiesDead || playerDead)
```

## 🔧 Métodos de la Fachada

```java
public class CombatFacade {
    // Iniciar combate
    public void startCombat(Player player, List<Enemy> enemies) {
        // Configura todos los subsistemas
    }
    
    // Ejecutar turno completo
    public void executeTurn(TurnCommand command) {
        // 1. Ejecuta comando
        // 2. Calcula daño
        // 3. Aplica efectos
        // 4. Verifica condiciones
        // 5. Turno enemigo (IA)
        // 6. Actualiza UI vía Observer
    }
    
    // Finalizar turno
    public void endTurn() {
        // Aplica efectos de fin de turno
        // Regeneración, veneno, etc.
    }
    
    // Verificar victoria/derrota
    public boolean checkVictoryCondition() {
        return allEnemiesDead() || playerIsDead();
    }
    
    // Obtener reporte
    public CombatReport getCombatReport() {
        return new CombatReport(
            damageDealt,
            damageTaken,
            turnsElapsed,
            experienceGained
        );
    }
}
```

## 🎯 Beneficios para el Proyecto

- **GameController** no necesita conocer DamageCalculator, TurnManager, etc.
- **Testing** más fácil (mock CombatFacade en lugar de 5 subsistemas)
- **Mantenibilidad** alta (cambios internos no afectan al cliente)
- **Código limpio** en presentaciones académicas

---
**Patrón:** Facade (Estructural)  
**Prioridad:** Media
