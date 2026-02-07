# 🧬 Prototype - Prototype Pattern

## 📌 Función

Implementa el patrón **Prototype** para clonar enemigos base y crear variaciones eficientemente.

## 🔧 Componentes Principales

- **Cloneable.java** - Interfaz personalizada para clonación
- **EnemyPrototype.java** - Implementación del prototipo para enemigos

## 🎯 Responsabilidades

- Clonar enemigos existentes en lugar de crearlos desde cero
- Permitir variaciones de un enemigo base (ajustar nivel, stats)
- Optimizar la creación de hordas de enemigos similares
- Facilitar la creación de bosses con múltiples fases

## ✅ Ventajas del Patrón

- ✅ Evita el costo de crear objetos complejos desde cero
- ✅ Ideal para generar múltiples enemigos similares
- ✅ Permite variaciones personalizadas del clon
- ✅ Útil para enemigos con configuraciones costosas

## 📐 Diagrama UML

```
<<interface>> Cloneable
└── clone(): Enemy

Enemy implements Cloneable
├── attributes: Stats
├── skills: List<Skill>
└── clone(): Enemy
     ├── Clona stats base
     ├── Ajusta nivel
     └── Escala daño/vida
```

## 💡 Ejemplo de Uso

```java
// Crear un enemigo plantilla
Enemy dragonTemplate = new Dragon(/* configuración compleja */);

// Clonar y ajustar para diferentes niveles
Enemy dragon1 = dragonTemplate.clone();
dragon1.setLevel(5);

Enemy dragon2 = dragonTemplate.clone();
dragon2.setLevel(10);
dragon2.applyBossModifiers(); // Boss más poderoso
```

## 🎮 Casos de Uso

- **Hordas:** Generar múltiples enemigos del mismo tipo
- **Bosses con fases:** Clonar y modificar stats entre fases
- **Variaciones de zona:** Mismo enemigo con stats escalados por zona
- **Optimización:** Evitar recrear enemigos complejos

---
**Patrón:** Prototype (Creacional)  
**Prioridad:** Media
