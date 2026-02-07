# 🧪 Tests - Pruebas Unitarias

## 📌 Función

Contiene todas las pruebas unitarias del proyecto para validar el correcto funcionamiento de los patrones de diseño y la lógica del juego.

## 🎯 Framework de Testing

- **JUnit 5** (Jupiter) - Framework principal de testing
- **Mockito** - Mocking de dependencias
- **AssertJ** - Assertions más expresivas (opcional)

## 🗂️ Estructura

```
test/java/com/utp/auralis/
├── factory/          # Tests de Factory Method
├── builder/          # Tests de Builder
├── prototype/        # Tests de Prototype
├── composite/        # Tests de Composite
├── decorator/        # Tests de Decorator
├── command/          # Tests de Command
├── observer/         # Tests de Observer
└── combat/          # Tests del sistema de combate
```

## 📐 Convenciones de Nombres

### Clases de Test
```
NombreDeLaClaseTest.java

Ejemplos:
- EnemyFactoryTest.java
- PlayerBuilderTest.java
- AttackCommandTest.java
```

### Métodos de Test
```
@Test
public void debería_[acción]_cuando_[condición]() { }

Ejemplos:
- debería_crearGoblin_cuando_tipoEsGoblin()
- debería_construirGuerrero_cuando_claseEsWarrior()
- debería_ejecutarAtaque_cuando_comandoEsAtack()
```

## ✅ Ejemplo de Test con JUnit 5

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyFactoryTest {
    private EnemyFactory factory;
    
    @BeforeEach
    public void setUp() {
        factory = new EnemyFactory();
    }
    
    @Test
    public void debería_crearGoblin_cuando_tipoEsGoblin() {
        // Arrange (Preparar)
        String type = "goblin";
        int level = 1;
        
        // Act (Actuar)
        Enemy enemy = factory.createEnemy(type, level);
        
        // Assert (Afirmar)
        assertNotNull(enemy);
        assertEquals("Goblin", enemy.getName());
        assertEquals(1, enemy.getLevel());
        assertTrue(enemy.getHealth() > 0);
    }
    
    @Test
    public void debería_lanzarExcepción_cuando_tipoNoExiste() {
        // Assert que se lanza excepción
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createEnemy("invalid_type", 1);
        });
    }
}
```

## 🎭 Testing con Mockito

```java
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CombatFacadeTest {
    @Mock
    private DamageCalculator damageCalculator;
    
    @Mock
    private TurnManager turnManager;
    
    @Mock
    private GameEventManager eventManager;
    
    @InjectMocks
    private CombatFacade combatFacade;
    
    @Test
    public void debería_calcularDaño_cuando_seEjecutaAtaque() {
        // Arrange
        Player player = new Player("Test");
        Enemy enemy = new Enemy("Goblin");
        when(damageCalculator.calculateDamage(player, enemy)).thenReturn(15);
        
        // Act
        AttackCommand attack = new AttackCommand(player, enemy);
        combatFacade.executeTurn(attack);
        
        // Assert
        verify(damageCalculator).calculateDamage(player, enemy);
        verify(eventManager).notifyObservers(any(GameEvent.class));
    }
}
```

## 📊 Cobertura de Tests

### Objetivo
- **Código de producción:** > 80% de cobertura
- **Patrones críticos:** 100% de cobertura
- **UI Controllers:** > 60% (más difícil de testear)

### Herramientas
```xml
<!-- Maven JaCoCo plugin en pom.xml -->
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.10</version>
</plugin>
```

### Ejecutar Tests con Cobertura
```bash
# Maven
mvn test jacoco:report

# Ver reporte en:
# target/site/jacoco/index.html
```

## 🎯 Tests por Patrón

### Factory Method
```java
@Test
public void debería_crearEnemigoDiferente_paraCadaCreator() {
    GoblinCreator goblinCreator = new GoblinCreator();
    DragonCreator dragonCreator = new DragonCreator();
    
    Enemy goblin = goblinCreator.createEnemy(1);
    Enemy dragon = dragonCreator.createEnemy(1);
    
    assertNotEquals(goblin.getClass(), dragon.getClass());
}
```

### Builder
```java
@Test
public void debería_construirPersonajeCompleto_conBuilder() {
    Player player = new WarriorBuilder()
        .setName("Arthas")
        .setLevel(5)
        .setStrength(15)
        .build();
    
    assertEquals("Arthas", player.getName());
    assertEquals(5, player.getLevel());
    assertEquals(15, player.getStrength());
}
```

### Command
```java
@Test
public void debería_deshacerAcción_cuando_seInvocaUndo() {
    Player player = new Player("Test");
    Enemy enemy = new Enemy("Goblin");
    int initialHP = enemy.getHealth();
    
    AttackCommand attack = new AttackCommand(player, enemy);
    attack.execute();
    assertTrue(enemy.getHealth() < initialHP);
    
    attack.undo();
    assertEquals(initialHP, enemy.getHealth());
}
```

### Decorator
```java
@Test
public void debería_apilarEfectos_conDecorators() {
    Character character = new Player("Test");
    int baseAttack = character.getAttack();
    
    Character buffed = new BuffDecorator(character, BuffType.ATTACK);
    Character doubleBuffed = new BuffDecorator(buffed, BuffType.ATTACK);
    
    assertTrue(doubleBuffed.getAttack() > buffed.getAttack());
    assertTrue(buffed.getAttack() > baseAttack);
}
```

### Observer
```java
@Test
public void debería_notificarObservers_cuando_cambiaEstado() {
    GameEventManager manager = new GameEventManager();
    MockObserver observer = new MockObserver();
    manager.addObserver(observer);
    
    Player player = new Player("Test");
    manager.notifyHealthChange(player, 100, 80);
    
    assertTrue(observer.wasNotified());
    assertEquals(EventType.HEALTH_CHANGED, observer.getLastEventType());
}
```

## 🧰 Utilidades de Testing

```java
public class TestUtils {
    public static Player createTestPlayer() {
        return new PlayerBuilder()
            .setName("TestPlayer")
            .setLevel(1)
            .setStrength(10)
            .setDefense(8)
            .build();
    }
    
    public static Enemy createTestEnemy() {
        return new GoblinCreator().createEnemy(1);
    }
    
    public static void assertHealthInRange(Character character, int min, int max) {
        int health = character.getHealth();
        assertTrue(health >= min && health <= max,
            "Health " + health + " is not in range [" + min + ", " + max + "]");
    }
}
```

## 📋 Checklist de Tests

### Mínimo por Patrón
- ✅ Test de creación básica
- ✅ Test de funcionalidad principal
- ✅ Test de casos edge
- ✅ Test de manejo de errores

### Tests Completos
- ✅ Happy path (caso normal)
- ✅ Edge cases (límites)
- ✅ Error handling (excepciones)
- ✅ Integration tests (varios componentes)

## 🚀 Ejecutar Tests

```bash
# Todos los tests
mvn test

# Tests específicos
mvn test -Dtest=EnemyFactoryTest

# Tests de un paquete
mvn test -Dtest="com.utp.auralis.factory.*"

# Con verbose output
mvn test -X
```

---
**Ubicación:** `src/test/java/com/utp/auralis/`  
**Framework:** JUnit 5 + Mockito  
**Prioridad:** Alta
