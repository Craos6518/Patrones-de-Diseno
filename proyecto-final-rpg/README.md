# 🗡️ Dungeon Quest RPG - Proyecto Final UTP

Juego RPG roguelike por turnos que integra múltiples patrones de diseño GoF en una implementación clara y práctica, desarrollado como proyecto integrador del curso de Patrones de Diseño de Software.

---

## 📋 Tabla de Contenidos
- [🎯 Objetivo del Proyecto](#-objetivo-del-proyecto)
- [📖 Descripción General](#-descripción-general)
- [✨ Características Principales](#-características-principales)
- [🛠️ Tecnologías Utilizadas](#️-tecnologías-utilizadas)
- [🎨 Patrones de Diseño Implementados](#-patrones-de-diseño-implementados)
- [🏗️ Arquitectura del Sistema](#️-arquitectura-del-sistema)
- [👥 Historias de Usuario](#-historias-de-usuario)
- [📊 Diagramas](#-diagramas)
- [🎮 Características del Juego](#-características-del-juego)
- [📦 Instalación y Configuración](#-instalación-y-configuración)
- [🎯 Uso del Juego](#-uso-del-juego)
- [📁 Estructura del Proyecto](#-estructura-del-proyecto)
- [🧪 Testing](#-testing)
- [📋 Roadmap de Desarrollo](#-roadmap-de-desarrollo)
- [📚 Documentación](#-documentación)
- [🤝 Contribución](#-contribución)
- [📄 Licencia](#-licencia)

---

## 🎯 Objetivo del Proyecto

Demostrar la aplicación práctica de **8+ patrones de diseño clásicos (GoF)** en el desarrollo de un videojuego, implementando soluciones elegantes a problemas comunes de desarrollo, con código mantenible, escalable y bien documentado.

Este proyecto busca:
- ✅ Aplicar patrones GoF en contexto real orientado a objetos
- ✅ Desarrollar arquitectura de software escalable y mantenible
- ✅ Implementar buenas prácticas de diseño (SOLID, DRY, KISS)
- ✅ Documentar decisiones de diseño con diagramas UML
- ✅ Crear código testeable y de alta calidad

---

## 📖 Descripción General

**Dungeon Quest RPG** es un roguelike de mazmorras por turnos donde el jugador explora dungeons generados proceduralmente, combate enemigos con IA adaptativa, gestiona inventario y progresa a través de niveles cada vez más desafiantes.

### Stack Tecnológico
- **Lenguaje:** Python 3.10+
- **Framework de Juego:** Pygame 2.5+
- **Base de Datos:** PostgreSQL (opcional para estadísticas)
- **Arquitectura:** Orientada a Objetos con Patrones GoF
- **Testing:** pytest
- **Calidad de Código:** pylint, black, mypy

---

## ✨ Características Principales

- 🎲 **Generación Procedural**: Mazmorras únicas en cada partida mediante Factory Method
- ⚔️ **Sistema de Combate por Turnos**: Combate estratégico con múltiples acciones
- 🧠 **IA Adaptativa**: Enemigos con diferentes estrategias (agresiva, defensiva, táctica)
- 🎒 **Sistema de Inventario**: Gestión jerárquica de items y equipamiento (Composite)
- ⚡ **Buffs y Debuffs**: Sistema de modificadores apilables (Decorator)
- 🎯 **Sistema de Clases**: Guerrero, Mago, Arquero con estadísticas únicas
- 💾 **Guardado/Carga**: Persistencia de progreso del jugador
- 🎵 **Audio Manager**: Música y efectos de sonido adaptativos (Singleton)
- 📊 **Sistema de Eventos**: Notificaciones reactivas (Observer)
- 🏆 **Deshacer/Rehacer**: Sistema de comandos reversibles (Command)

---

## 🛠️ Tecnologías Utilizadas

### 🐍 Lenguaje Principal
**Python 3.11+**
- Lenguaje de programación orientado a objetos
- Excelente para implementar patrones de diseño
- Sintaxis clara y legible
- Comunidad amplia y bibliotecas robustas

### 🎮 Motor de Juego y Gráficos
**Pygame 2.5.0**
- Framework de desarrollo de videojuegos 2D
- Manejo de sprites, colisiones y animaciones
- Sistema de eventos y loop de juego
- Renderizado de gráficos y texto
- Gestión de audio (música y efectos de sonido)

### 💾 Base de Datos
**PostgreSQL 14+**
- Sistema de gestión de base de datos relacional
- Almacenamiento de partidas guardadas
- Registro de estadísticas y logros
- Gestión de perfiles de jugador

**SQLAlchemy 2.0+**
- ORM (Object-Relational Mapping)
- Abstracción de consultas SQL
- Migraciones de base de datos
- Manejo de sesiones y transacciones

### 🔧 Herramientas de Desarrollo

#### Control de Versiones
- **Git** - Control de versiones distribuido
- **GitHub** - Repositorio remoto y gestión de proyectos

#### Entorno de Desarrollo
- **Visual Studio Code** - IDE principal
- Extensiones: Python, Pylance, GitLens, Pytest Explorer

#### Calidad de Código
- **Pylint 3.0+** - Análisis estático y verificación PEP 8
- **Black** - Formateador automático de código
- **isort** - Organización automática de imports

#### Testing
- **Pytest 7.4+** - Framework de testing
- **pytest-cov** - Análisis de cobertura de código
- **unittest.mock** - Mocking para pruebas unitarias

### 📦 Librerías y Dependencias Adicionales

#### Gestión de Configuración
- **python-dotenv** - Manejo de variables de entorno

#### Serialización de Datos
- **JSON (built-in)** - Almacenamiento de configuraciones y datos

#### Utilidades de Código
- **typing (built-in)** - Type hints para mejor mantenibilidad
- **dataclasses (built-in)** - Definición de clases de datos
- **enum (built-in)** - Enumeraciones para estados y tipos

### 🎨 Assets y Recursos

#### Gráficos
- Pixel Art (Sprites y Tiles)
- Herramientas: Aseprite, Piskel (creación de sprites)
- Herramientas: Tiled (diseño de mapas)

#### Audio
- Formatos: .ogg (música), .wav (efectos de sonido)
- Herramientas: Audacity (edición), Bfxr (generación)

#### Fuentes
- Formatos: .ttf, .otf
- Fuentes pixel art para UI retro

### 📐 Diagramas y Documentación

- **Draw.io / Lucidchart** - Diagramas UML e componentes
- **PlantUML** - Generación de diagramas desde código
- **dbdiagram.io** - Diseño del modelo entidad-relación
- **Markdown** - Documentación del proyecto

### 🌐 Opcionales / Futuras Implementaciones
- Redis (caché de datos)
- Docker (containerización)
- GitHub Actions (CI/CD)
- Sphinx (documentación automática)

---

## 🏗️ Arquitectura General

```
rpg_game/
├── main.py                    # Punto de entrada del juego
├── managers/                  # Gestión central del juego
│   ├── game_manager.py       # Singleton - Gestión del juego
│   ├── audio_manager.py      # Singleton - Gestión de audio
│   └── save_manager.py       # Gestión de guardado/carga
├── factories/                 # Patrones Factory
│   ├── enemy_factory.py      # Factory Method - Creación enemigos
│   ├── item_factory.py       # Factory Method - Creación items
│   └── room_factory.py       # Factory Method - Generación mazmorras
├── entities/                  # Entidades del juego
│   ├── character.py          # Personaje jugador
│   ├── enemy.py              # Enemigos (Strategy para IA)
│   └── item.py               # Items y equipamiento
├── commands/                  # Patrón Command
│   └── combat_commands.py    # Comandos de combate
├── decorators/                # Patrón Decorator
│   └── stat_modifiers.py     # Modificadores de stats
├── observers/                 # Patrón Observer
│   └── event_system.py       # Sistema de eventos
├── states/                    # Patrón State
│   └── game_states.py        # Estados del juego
├── strategies/                # Patrón Strategy
│   └── ai_strategies.py      # Estrategias de IA
├── assets/                    # Recursos del juego
│   ├── sprites/              # Gráficos
│   ├── sounds/               # Audio
│   └── data/                 # Datos (JSON)
└── tests/                     # Tests unitarios
    └── test_patterns.py
```

---

## 🎨 Patrones de Diseño Implementados

### 🏆 Patrones Principales (8+)

| Patrón | Categoría | Aplicación en el Juego | Ubicación |
|--------|-----------|----------------------|-----------|
| **Singleton** | Creacional | Gestión única del juego y audio | `managers/game_manager.py` |
| **Factory Method** | Creacional | Creación dinámica de enemigos/items/salas | `factories/enemy_factory.py` |
| **Command** | Comportamiento | Sistema de acciones de combate | `commands/combat_commands.py` |
| **Strategy** | Comportamiento | IA de enemigos (agresivo, defensivo, etc.) | `strategies/ai_strategies.py` |
| **Observer** | Comportamiento | Sistema de eventos del juego | `observers/event_system.py` |
| **Decorator** | Estructural | Modificadores de stats (buffs/debuffs) | `decorators/stat_modifiers.py` |
| **State** | Comportamiento | Estados del juego (menú, combate, inventario) | `states/game_states.py` |
| **Composite** | Estructural | Gestión de inventario y equipamiento | `entities/inventory.py` |

### 📊 Detalles de Implementación

#### Singleton - Game Manager
- **Uso:** Una única instancia que controla el loop principal, estado global
- **Beneficio:** Acceso global controlado, evita duplicación de gestión

#### Factory Method - Creación de Entidades
- **Uso:** Generación procedural de enemigos según nivel/dungeon
- **Beneficio:** Escalabilidad, fácil agregar nuevos tipos

#### Command - Sistema de Combate
- **Uso:** Encapsula acciones (atacar, defender, usar item)
- **Beneficio:** Deshacer/rehacer, sistema de turnos flexible

#### Strategy - IA de Enemigos
- **Uso:** Diferentes comportamientos según tipo enemigo
- **Beneficio:** Variedad en combate, fácil balance

#### Observer - Sistema de Eventos
- **Uso:** Notificar cambios (daño, muerte, level up)
- **Beneficio:** Desacoplamiento, UI reactiva

#### Decorator - Modificadores
- **Uso:** Buffs/Debuffs apilables para personajes
- **Beneficio:** Combinaciones flexibles de efectos

#### State - Estados del Juego
- **Uso:** Transiciones entre menú, exploración, combate
- **Beneficio:** Código organizado, transiciones claras

#### Composite - Inventario
- **Uso:** Estructura jerárquica de items y equipamiento
- **Beneficio:** Gestión uniforme de objetos simples/compuestos

---

## 📐 Arquitectura del Sistema

```
┌─────────────────────────────────────────────────────────┐
│              GameManager (Singleton)                     │
│           Orquestador Principal del Juego                │
└────────────┬────────────────────────────────────────────┘
             │
    ┌────────┴────────┐
    │                 │
┌───▼────┐      ┌────▼─────┐       ┌──────────┐
│ Combat │      │ Dungeon  │       │  Audio   │
│ System │      │Generator │       │ Manager  │
└───┬────┘      └────┬─────┘       └──────────┘
    │                │
    │                │
┌───▼────────────────▼─────┐
│   Entity Management      │
│ (Factories & Builders)   │
│  - EnemyFactory          │
│  - ItemFactory           │
│  - RoomFactory           │
└──────────────────────────┘
            │
            ▼
┌──────────────────────────┐
│   Pattern Layers         │
│  • Command: Acciones     │
│  • Strategy: IA          │
│  • Observer: Eventos     │
│  • Decorator: Buffs      │
│  • Composite: Inventario │
└──────────────────────────┘
```

---

## 👥 Historias de Usuario

### 📝 Historia 1: Inicio de Aventura
**Como** jugador nuevo  
**Quiero** crear un personaje eligiendo clase y nombre  
**Para** comenzar mi aventura en la mazmorra  

**Criterios de Aceptación:**
- ✅ Puedo elegir entre 3 clases diferentes (Guerrero, Mago, Arquero)
- ✅ Cada clase tiene estadísticas y habilidades únicas
- ✅ Puedo ingresar un nombre personalizado
- ✅ Se genera automáticamente la primera mazmorra

**Patrones Aplicados:** Factory Method, Builder  
**Estimación:** 5 puntos | **Prioridad:** Alta

---

### ⚔️ Historia 2: Combate Táctico
**Como** jugador  
**Quiero** combatir enemigos por turnos con múltiples opciones  
**Para** derrotarlos estratégicamente y ganar experiencia  

**Criterios de Aceptación:**
- ✅ Sistema de turnos claro (jugador → enemigos)
- ✅ Múltiples opciones: Atacar, Defender, Habilidad, Item
- ✅ Feedback visual del daño causado/recibido
- ✅ Sistema de experiencia y level up al ganar
- ✅ Posibilidad de deshacer última acción

**Patrones Aplicados:** Command, Strategy, Observer  
**Estimación:** 8 puntos | **Prioridad:** Alta

---

### 🎒 Historia 3: Gestión de Inventario
**Como** jugador  
**Quiero** gestionar mi inventario de items y equipamiento  
**Para** optimizar mis estadísticas y usar consumibles estratégicamente  

**Criterios de Aceptación:**
- ✅ Ver todos los items recolectados organizadamente
- ✅ Equipar/desequipar armas, armaduras y accesorios
- ✅ Usar pociones y consumibles en combate
- ✅ Descartar items innecesarios
- ✅ Ver efecto de items en estadísticas

**Patrones Aplicados:** Composite, Decorator  
**Estimación:** 5 puntos | **Prioridad:** Media

---

### 🏰 Historia 4: Exploración de Mazmorra
**Como** jugador  
**Quiero** explorar mazmorras generadas aleatoriamente  
**Para** descubrir tesoros, combatir enemigos y progresar  

**Criterios de Aceptación:**
- ✅ Cada mazmorra es única (generación procedural)
- ✅ Habitaciones con diferentes eventos (tesoro, enemigo, descanso, boss)
- ✅ Mapa visible mostrando habitaciones exploradas
- ✅ Salida al siguiente nivel al completar mazmorra
- ✅ Dificultad incrementa con cada nivel

**Patrones Aplicados:** Factory Method, State  
**Estimación:** 13 puntos | **Prioridad:** Alta

---

### 💾 Historia 5: Guardado de Progreso
**Como** jugador  
**Quiero** guardar mi partida en cualquier momento  
**Para** continuar mi aventura después sin perder progreso  

**Criterios de Aceptación:**
- ✅ Guardar estado completo del personaje (stats, nivel, clase)
- ✅ Guardar inventario completo con todos los items
- ✅ Guardar posición actual en mazmorra
- ✅ Cargar partidas guardadas desde el menú principal
- ✅ Múltiples slots de guardado

**Patrones Aplicados:** Singleton, Memento  
**Estimación:** 8 puntos | **Prioridad:** Media

---

## 📊 Diagramas

### 📐 Diagrama de Clases Principal
**Ubicación:** `docs/diagramas/clases_uml.png`  
**Descripción:** Diagrama UML completo mostrando todas las clases principales y sus relaciones, con énfasis en los patrones de diseño implementados.

### 🏗️ Diagrama de Componentes
**Ubicación:** `docs/diagramas/componentes.png`  
**Descripción:** Arquitectura de alto nivel mostrando la separación de responsabilidades entre módulos.

### ⚔️ Diagrama de Flujo - Sistema de Combate
**Ubicación:** `docs/diagramas/flujo_combate.png`  
**Descripción:** Flujo detallado del sistema de combate por turnos, incluyendo decisiones de IA.

### 🗂️ Diagrama de Secuencia - Creación de Enemigos
**Ubicación:** `docs/diagramas/secuencia_factory.png`  
**Descripción:** Interacción entre Factory Method y la creación dinámica de entidades.

### 🗄️ Modelo Entidad-Relación (Opcional)
**Ubicación:** `docs/diagramas/modelo_er.png`  
**Descripción:** Estructura de base de datos para estadísticas persistentes (si se implementa PostgreSQL).

---

## 🎯 Uso del Juego

### Controles
- **↑↓←→**: Movimiento en mazmorra
- **ENTER**: Confirmar/Interactuar
- **ESC**: Menú de pausa
- **I**: Abrir inventario
- **C**: Ver estadísticas de personaje
- **M**: Ver mapa de mazmorra

### Combate
- **1**: Ataque básico
- **2**: Defender (reduce daño recibido)
- **3**: Usar habilidad especial
- **4**: Usar item del inventario
- **U**: Deshacer última acción (Command Pattern)

### Menú Principal
- **Nueva Partida**: Crear nuevo personaje
- **Cargar Partida**: Continuar desde guardado
- **Opciones**: Configurar audio y controles
- **Créditos**: Información del proyecto
- **Salir**: Cerrar el juego

---

## � Instalación y Configuración

### Prerequisitos
- Python 3.10 o superior
- pip (gestor de paquetes de Python)
- Git
- Editor de código (VS Code recomendado)

### Pasos de Instalación

**1. Clonar el repositorio:**
```bash
git clone https://github.com/Craos6518/Patrones-de-Diseno.git
cd Patrones-de-Diseno/proyecto-final-rpg
```

**2. Crear entorno virtual:**
```bash
# Linux/Mac
python3 -m venv venv
source venv/bin/activate

# Windows
python -m venv venv
venv\Scripts\activate
```

**3. Instalar dependencias:**
```bash
pip install -r requirements.txt
```

**4. Configurar base de datos (opcional para estadísticas):**
```bash
# Si deseas usar PostgreSQL para guardar estadísticas
python scripts/setup_database.py
```

**5. Ejecutar el juego:**
```bash
python main.py
```

### Comandos de Desarrollo

```bash
# Ejecutar con modo debug
python main.py --debug

# Ejecutar tests
pytest tests/ -v

# Verificar calidad de código
pylint src/
black src/

# Generar documentación
python scripts/generate_docs.py
```

---

## �📁 Estructura del Proyecto

```
dungeon-quest-rpg/
│
├── main.py                      # Punto de entrada
├── requirements.txt             # Dependencias Python
├── README.md                    # Este archivo
├── .gitignore                   # Archivos ignorados por Git
│
├── src/                         # Código fuente
│   ├── __init__.py
│   │
│   ├── managers/                # Singletons
│   │   ├── __init__.py
│   │   ├── game_manager.py      # Singleton - Control del juego
│   │   ├── audio_manager.py     # Singleton - Gestión de audio
│   │   └── save_manager.py      # Guardado/carga de partidas
│   │
│   ├── factories/               # Factory Method
│   │   ├── __init__.py
│   │   ├── enemy_factory.py     # Creación de enemigos
│   │   ├── item_factory.py      # Creación de items
│   │   └── room_factory.py      # Generación de salas
│   │
│   ├── builders/                # Builder Pattern
│   │   ├── __init__.py
│   │   ├── dungeon_builder.py   # Construcción de mazmorras
│   │   └── character_builder.py # Construcción de personajes
│   │
│   ├── entities/                # Entidades del juego
│   │   ├── __init__.py
│   │   ├── character.py         # Personaje jugador
│   │   ├── enemy.py             # Enemigos con IA
│   │   ├── item.py              # Items y equipamiento
│   │   ├── room.py              # Habitaciones de mazmorra
│   │   └── inventory.py         # Sistema de inventario
│   │
│   ├── commands/                # Command Pattern
│   │   ├── __init__.py
│   │   ├── base_command.py      # Comando base
│   │   ├── attack_command.py    # Comando de ataque
│   │   ├── defend_command.py    # Comando de defensa
│   │   ├── use_item_command.py  # Comando usar item
│   │   └── command_manager.py   # Gestor de comandos (undo/redo)
│   │
│   ├── strategies/              # Strategy Pattern
│   │   ├── __init__.py
│   │   ├── ai_strategy.py       # Estrategia base de IA
│   │   ├── aggressive_ai.py     # IA agresiva
│   │   ├── defensive_ai.py      # IA defensiva
│   │   └── tactical_ai.py       # IA táctica
│   │
│   ├── decorators/              # Decorator Pattern
│   │   ├── __init__.py
│   │   ├── stat_modifier.py     # Modificador de stats base
│   │   ├── buff_decorator.py    # Buffs (mejoras temporales)
│   │   └── debuff_decorator.py  # Debuffs (penalizaciones)
│   │
│   ├── observers/               # Observer Pattern
│   │   ├── __init__.py
│   │   ├── event_system.py      # Sistema de eventos central
│   │   ├── ui_observer.py       # Observador de interfaz
│   │   └── stats_observer.py    # Observador de estadísticas
│   │
│   ├── states/                  # State Pattern
│   │   ├── __init__.py
│   │   ├── game_state.py        # Estado base
│   │   ├── menu_state.py        # Estado de menú
│   │   ├── explore_state.py     # Estado de exploración
│   │   ├── combat_state.py      # Estado de combate
│   │   └── inventory_state.py   # Estado de inventario
│   │
│   ├── composite/               # Composite Pattern
│   │   ├── __init__.py
│   │   ├── inventory_component.py # Componente base
│   │   ├── item_leaf.py          # Item individual
│   │   └── container_composite.py # Contenedor de items
│   │
│   ├── systems/                 # Sistemas del juego
│   │   ├── __init__.py
│   │   ├── combat_system.py     # Lógica de combate
│   │   ├── inventory_system.py  # Gestión de inventario
│   │   └── progression_system.py # Sistema de niveles
│   │
│   ├── ui/                      # Interfaz de usuario
│   │   ├── __init__.py
│   │   ├── menu.py              # Menús del juego
│   │   ├── hud.py               # HUD en pantalla
│   │   └── dialogs.py           # Diálogos y notificaciones
│   │
│   └── utils/                   # Utilidades
│       ├── __init__.py
│       ├── constants.py         # Constantes del juego
│       ├── helpers.py           # Funciones auxiliares
│       └── config.py            # Configuración
│
├── assets/                      # Recursos del juego
│   ├── sprites/                 # Gráficos
│   │   ├── characters/
│   │   ├── enemies/
│   │   ├── items/
│   │   └── ui/
│   ├── sounds/                  # Efectos de sonido
│   ├── music/                   # Música de fondo
│   └── fonts/                   # Fuentes
│
├── data/                        # Datos de configuración
│   ├── enemies.json             # Definición de enemigos
│   ├── items.json               # Definición de items
│   ├── rooms.json               # Tipos de habitaciones
│   └── classes.json             # Clases de personaje
│
├── tests/                       # Tests unitarios
│   ├── __init__.py
│   ├── test_factories.py        # Tests de Factory
│   ├── test_commands.py         # Tests de Command
│   ├── test_strategies.py       # Tests de Strategy
│   ├── test_observers.py        # Tests de Observer
│   ├── test_decorators.py       # Tests de Decorator
│   ├── test_composite.py        # Tests de Composite
│   └── test_combat.py           # Tests de combate
│
├── docs/                        # Documentación
│   ├── diagramas/               # Diagramas UML
│   │   ├── clases_uml.png
│   │   ├── componentes.png
│   │   ├── flujo_combate.png
│   │   ├── secuencia_factory.png
│   │   └── modelo_er.png
│   ├── MANUAL_USUARIO.md        # Manual para jugadores
│   ├── MANUAL_TECNICO.md        # Documentación técnica
│   └── DECISIONES_DISENO.md    # Decisiones arquitectónicas
│
├── saves/                       # Partidas guardadas (generado)
│
└── scripts/                     # Scripts de utilidad
    ├── setup_database.py        # Configuración de BD (opcional)
    └── generate_docs.py         # Generación de documentación
```

---

## 🧪 Testing

### Ejecutar Tests
```bash
# Todos los tests
pytest tests/ -v

# Tests con cobertura
pytest --cov=src tests/

# Tests específicos de patrones
pytest tests/test_patterns.py -v

# Tests con output detallado
pytest -vv

# Generar reporte HTML de cobertura
pytest --cov=src --cov-report=html tests/
```

### Tests de Patrones

**Singleton:**
```python
# Verificar que solo existe una instancia
def test_singleton_unique_instance():
    manager1 = GameManager.get_instance()
    manager2 = GameManager.get_instance()
    assert manager1 is manager2
```

**Factory Method:**
```python
# Verificar creación correcta de enemigos
def test_enemy_factory():
    factory = EnemyFactory()
    goblin = factory.create_enemy("goblin", level=1)
    assert goblin.type == "goblin"
    assert goblin.health > 0
```

**Command:**
```python
# Verificar undo/redo
def test_command_undo():
    attack = AttackCommand(player, enemy)
    initial_hp = enemy.health
    attack.execute()
    attack.undo()
    assert enemy.health == initial_hp
```

**Strategy:**
```python
# Verificar cambio dinámico de estrategia
def test_ai_strategy():
    enemy = Enemy()
    enemy.set_strategy(AggressiveAI())
    action1 = enemy.decide_action()
    enemy.set_strategy(DefensiveAI())
    action2 = enemy.decide_action()
    assert action1 != action2
```

---

## 📚 Documentación

- [Diagramas UML de Patrones](./docs/diagramas/)
- [Manual de Usuario](./docs/MANUAL_USUARIO.md)
- [Documentación Técnica](./docs/MANUAL_TECNICO.md)
- [Decisiones de Diseño](./docs/DECISIONES_DISENO.md)

## 📋 Roadmap de Desarrollo

###  Sprint 1: Sistema Básico + Singleton + Factory (Semanas 1-2)
**Objetivo:** Base funcional del juego con patrones creacionales

- [ ] Setup del proyecto y estructura base
- [ ] **Singleton:** GameManager y AudioManager
- [ ] **Factory Method:** EnemyFactory básica (3 tipos enemigos)
- [ ] Loop principal del juego con Pygame
- [ ] Sistema básico de renderizado
- [ ] Personaje jugador con stats básicos
- **Entregable:** Juego ejecutable con menú básico y generación de enemigos

### ⚔️ Sprint 2: Combate + Command + Strategy (Semanas 3-4)
**Objetivo:** Sistema de combate funcional con IA

- [ ] **Command:** Sistema de comandos de combate (Attack, Defend, UseItem)
- [ ] **Strategy:** IA de enemigos (3 estrategias diferentes)
- [ ] Sistema de turnos jugador/enemigos
- [ ] Acciones: Atacar, Defender, Habilidad, Usar Item
- [ ] UI de combate con feedback visual
- [ ] Sistema de experiencia y level up
- **Entregable:** Combate jugable por turnos contra enemigos con IA

### 🎯 Sprint 3: Eventos + Observer + Decorator (Semanas 5-6)
**Objetivo:** Sistemas de eventos y modificadores

- [ ] **Observer:** Sistema de eventos del juego
- [ ] **Decorator:** Buffs/Debuffs apilables para personajes
- [ ] Sistema de notificaciones visuales
- [ ] Items consumibles (pociones, scrolls)
- [ ] Efectos de estado (veneno, regeneración, escudo)
- [ ] Animaciones de combate básicas
- **Entregable:** Combate con efectos visuales y modificadores temporales

### 🏰 Sprint 4: Estados + State + Composite (Semanas 7-8)
**Objetivo:** Exploración de mazmorras y progresión

- [ ] **State:** Estados del juego (Menú, Exploración, Combate, Inventario)
- [ ] **Composite:** Sistema de inventario jerárquico
- [ ] RoomFactory para generación procedural de mazmorras
- [ ] Sistema de exploración con mapa
- [ ] Progresión de niveles y dificultad
- [ ] Sistema de guardado/carga básico
- **Entregable:** Juego completocon exploración de mazmorras

### 🎨 Sprint 5: Pulido + Documentación UML (Semanas 9-10)
**Objetivo:** Refinamiento y documentación completa

- [ ] Testing completo con pytest (cobertura >80%)
- [ ] Diagramas UML de todos los patrones implementados
- [ ] Documentación técnica exhaustiva
- [ ] Balance de juego y ajuste de dificultad
- [ ] Optimización de rendimiento
- [ ] Audio completo y sprites finales
- [ ] Manual de usuario y técnico
- **Entregable:** Proyecto finalizado con documentación completa

---

## 🤝 Contribución

### Para Estudiantes de la UTP

Este es un proyecto académico, pero puedes contribuir:

1. **Fork del repositorio**
2. **Crear rama feature:** `git checkout -b feature/patron-nombre`
3. **Implementar** siguiendo las guías del proyecto
4. **Documentar** decisiones de diseño
5. **Agregar tests** para nuevo código
6. **Pull Request** con descripción detallada

### Guías de Contribución
- Seguir PEP 8 para estilo de código Python
- Documentar todas las clases y funciones con docstrings
- Incluir tests unitarios para patrones nuevos
- Actualizar diagramas UML si es necesario
- Explicar justificación de patrones aplicados

---

## 🎓 Enfoque Académico

Este proyecto sirve como:

1. **Caso de Estudio** - Aplicación real de patrones GoF en videojuegos
2. **Referencia** - Implementaciones concretas para aprender
3. **Portfolio** - Proyecto demostrable para estudiantes
4. **Base** - Para trabajos finales y proyectos de grado

### Objetivos de Aprendizaje

- ✅ Aplicar 8+ patrones GoF en contexto orientado a objetos
- ✅ Diseñar arquitectura escalable y mantenible
- ✅ Implementar principios SOLID en código real
- ✅ Desarrollar sistema de juego completo y jugable
- ✅ Escribir tests automatizados para patrones
- ✅ Documentar decisiones de diseño con UML
- ✅ Crear código legible y bien estructurado

---

## 🎯 Ventajas de Este Enfoque

### ✅ Técnicas
- **Python puro:** Lenguaje conocido, enfoque en diseño no en sintaxis
- **Pygame simple:** Framework maduro pero no invasivo
- **OOP claro:** Implementación directa de patrones GoF
- **Incremental:** Cada sprint suma funcionalidad verificable

### ✅ Académicas
- **8+ patrones** implementados de forma natural
- **Diagramas UML** fáciles de generar y explicar
- **Código legible** perfecto para documentación
- **Tests claros** para validar cada patrón

### ✅ Prácticas
- **Portfolio sólido:** Proyecto demostrable
- **Código reutilizable:** Cada patrón es un ejemplo de referencia
- **Documentación clara:** Explicación de decisiones de diseño
- **Escalable:** Fácil agregar nuevas features sin romper lo existente

---

## 🔗 Enlaces Útiles

- [Volver al README Principal](../README.md)
- [Documentación de Patrones](../docs/)
- [Patrones de Comportamiento](../comportamiento/)
- [Patrones Creacionales](../creacionales/)
- [Patrones Estructurales](../estructurales/)
- [Pygame Documentation](https://www.pygame.org/docs/)
- [Python Design Patterns](https://refactoring.guru/design-patterns/python)
- [Game Programming Patterns](https://gameprogrammingpatterns.com/)

---

## 📄 Licencia

Este proyecto es material académico para la **Universidad Tecnológica de Pereira (UTP)**.  
Curso: **Patrones de Diseño de Software**

---

## 👥 Autores

- **Estudiantes UTP** - Desarrollo del proyecto
- **Docentes** - Guía y supervisión técnica

---

> **Nota para Estudiantes:** Este proyecto demuestra que los patrones de diseño GoF son aplicables en cualquier contexto orientado a objetos, no solo en aplicaciones empresariales. El enfoque en Python y un videojuego permite concentrarse en el diseño sin distracciones tecnológicas.

---

⭐ **Si este proyecto te fue útil para aprender patrones de diseño, dale una estrella!**
