# ⚡ Decorator - Decorator Pattern

## 📌 Función

Implementa el patrón **Decorator** para añadir efectos temporales y estados dinámicos a personajes y enemigos.

## 🔧 Componentes Principales

- **CharacterDecorator.java** - Decorator base abstracto
- **BuffDecorator.java** - Buffs positivos (Ataque+, Defensa+, Velocidad+)
- **PoisonDecorator.java** - Veneno (daño por turno)
- **ShieldDecorator.java** - Escudo temporal (absorbe daño)
- **BurnDecorator.java** - Quemadura (daño por turno + reduce defensa)

## 🎯 Responsabilidades

- Añadir comportamientos dinámicamente sin modificar clases originales
- Permitir apilar múltiples efectos sobre un personaje
- Modificar stats temporalmente (daño, defensa, velocidad)
- Aplicar efectos de estado cada turno

## ✅ Ventajas del Patrón

- ✅ Añade funcionalidad sin modificar código existente
- ✅ Efectos apilables y combinables
- ✅ Fácil de extender con nuevos efectos
- ✅ Cumple el principio de responsabilidad única (SRP)
- ✅ Muy visual en diagramas UML para presentaciones

## 📐 Diagrama UML

```
<<interface>> Character
├── getAttack(): int
├── getDefense(): int
└── takeDamage(amount: int)

CharacterDecorator implements Character
├── wrappedCharacter: Character
└── delegates to wrappedCharacter

Implementaciones:
├── BuffDecorator
│   └── getAttack() { return wrappedCharacter.getAttack() + 5; }
├── PoisonDecorator
│   └── onTurnEnd() { takeDamage(3); }
├── ShieldDecorator
│   └── takeDamage(amount) { absorbed = min(amount, shield); ... }
└── BurnDecorator
    └── getDefense() { return wrappedCharacter.getDefense() - 2; }
```

## 💡 Ejemplo de Uso

```java
// Personaje base
Character player = new Player("Héroe");

// Aplicar escudo
Character shieldedPlayer = new ShieldDecorator(player, 50);

// Aplicar buff de ataque
Character buffedPlayer = new BuffDecorator(shieldedPlayer, BuffType.ATTACK);

// Aplicar veneno
Character poisonedPlayer = new PoisonDecorator(buffedPlayer, 3);

// Ahora el jugador tiene: escudo + buff de ataque + veneno
int attack = poisonedPlayer.getAttack(); // Ataque base + buff
```

## 🎮 Efectos Implementados

### 🟢 Buffs Positivos
- **Ataque+:** Incrementa daño
- **Defensa+:** Reduce daño recibido
- **Velocidad+:** Aumenta prioridad de turno
- **Escudo:** Absorbe X puntos de daño

### 🔴 Debuffs Negativos
- **Veneno:** Daño por turno
- **Quemadura:** Daño por turno + reduce defensa
- **Congelado:** Reduce velocidad, puede saltar turno
- **Maldición:** Reduce todas las stats

---
**Patrón:** Decorator (Estructural)  
**Prioridad:** Alta
