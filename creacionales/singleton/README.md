# 🧩 Patrón: Singleton

## 📌 Clasificación
- **Tipo:** Creacional
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Garantizar que una clase tenga una única instancia en toda la aplicación y proporcionar un punto de acceso global a esa instancia.

> El patrón asegura la creación de una sola instancia de una clase y previene la creación de duplicados.

---

## ❓ Problema

Cuando necesitamos exactamente una instancia de una clase en toda la aplicación:

- Múltiples instancias de clases que deben ser únicas (configuración, logger, pool de conexiones)
- Acceso no controlado a recursos compartidos
- Estado inconsistente entre diferentes instancias
- Desperdicio de memoria con instancias duplicadas
- Difícil garantizar una única instancia mediante convención

**Ejemplo:** Un sistema de configuración, un manejador de logs, o un gestor de caché global.

---

## ✅ Solución

El patrón Singleton propone:

- **Constructor privado:** Previene la instanciación externa
- **Instancia estática:** La clase mantiene su única instancia
- **Método de acceso estático:** `getInstance()` proporciona acceso global
- **Lazy initialization:** La instancia se crea solo cuando es necesaria
- **Thread-safety:** Garantiza una sola instancia incluso en entornos multihilo

**Beneficios:**
- Garantiza una única instancia
- Punto de acceso global controlado
- Inicialización perezosa (ahorro de recursos)
- Puede extenderse mediante herencia (variantes)
- Facilita control de acceso a recursos compartidos

**Consideraciones:**
- Dificulta pruebas unitarias
- Puede introducir acoplamiento global
- Viola el principio de Responsabilidad Única (gestiona creación y lógica)

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Singleton:** 
  - Declara método estático `getInstance()` que retorna la única instancia
  - Constructor privado para prevenir instanciación externa
  - Variable estática privada que almacena la única instancia
  - Puede incluir lógica de negocio adicional

**Variantes:**
- **Eager initialization:** Instancia creada al cargar la clase
- **Lazy initialization:** Instancia creada cuando se solicita por primera vez
- **Thread-safe:** Con sincronización o double-checked locking
- **Enum Singleton:** Usando enum (más seguro en Java)

**Relaciones:**
- Client accede a Singleton solo mediante `getInstance()`
- Singleton controla su propia creación

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
singleton/
├── impl/
│   ├── ConfigurationManager.java     # Singleton: configuración global
│   ├── Logger.java                   # Singleton thread-safe: logger
│   ├── DatabaseConnection.java       # Singleton lazy: conexión DB
│   └── CacheManager.java             # Singleton eager: caché
└── Main.java                          # Demostración de acceso único
