# 🔨 Builder - Builder Pattern

## 📌 Función

Implementa el patrón **Builder** para la construcción compleja y flexible de personajes jugables.

## 🔧 Componentes Principales

- **PlayerBuilder.java** - Builder abstracto o interfaz
- **WarriorBuilder.java** - Builder concreto para Guerreros
- **MageBuilder.java** - Builder concreto para Magos
- **ScoutBuilder.java** - Builder concreto para Exploradores

## 🎯 Responsabilidades

- Construir objetos Player complejos paso a paso
- Separar la construcción de la representación
- Permitir diferentes configuraciones del mismo tipo de objeto
- Validar que el personaje creado sea consistente

## ✅ Ventajas del Patrón

- ✅ Proceso de construcción claro y legible
- ✅ Permite crear diferentes representaciones del mismo objeto
- ✅ Código más mantenible que constructores con muchos parámetros
- ✅ Excelente para diagramas UML académicos

## 📐 Diagrama UML

```
PlayerBuilder
├── setName(name: String)
├── setClass(class: CharacterClass)
├── setStrength(str: int)
├── setIntelligence(int: int)
├── setAgility(agi: int)
├── setSkills(skills: List<Skill>)
└── build(): Player

Implementaciones:
├── WarriorBuilder
├── MageBuilder
└── ScoutBuilder
```

## 💡 Ejemplo de Uso

```java
Player warrior = new WarriorBuilder()
    .setName("Arthas")
    .setStrength(15)
    .setDefense(12)
    .setSkills(List.of(new Skill("Golpe Poderoso")))
    .build();
```

## 🎮 Clases de Personaje

- **🗡️ Guerrero:** Alta Defensa, Daño Físico, Resistencia
- **🧙 Mago:** Alto Daño Mágico, Baja Defensa, Mana elevado
- **🏹 Explorador:** Velocidad alta, Críticos, Evasión

---
**Patrón:** Builder (Creacional)  
**Prioridad:** Alta
