# 🧩 Patrón: Proxy

## 📌 Clasificación
- **Tipo:** Estructural
- **Catálogo:** Gang of Four (GoF)

---

## 🎯 Intención

Proporcionar un sustituto o marcador de posición para controlar el acceso a otro objeto.

> Permite controlar el acceso, crear instancias bajo demanda, registrar accesos o implementar permisos.

---

## ❓ Problema

Cuando necesitamos controlar el acceso a un objeto o agregar funcionalidad adicional:

- Acceso no controlado a objetos costosos o sensibles
- Objeto real consume muchos recursos (crear siempre es ineficiente)
- Necesidad de funcionalidad adicional (logging, caché, validación)
- Objeto real está en ubicación remota
- Control de acceso y permisos requeridos

**Ejemplo:** Lazy loading de imágenes grandes, control de acceso a documentos sensibles, proxy remoto para servicios web, caché de resultados costosos.

---

## ✅ Solución

El patrón Proxy propone:

- **Sustituto controlado:** El proxy actúa como representante del objeto real
- **Misma interfaz:** Proxy y objeto real implementan la misma interfaz
- **Control de acceso:** El proxy controla cuándo y cómo acceder al objeto real
- **Funcionalidad adicional:** Puede agregar caché, logging, validación, etc.
- **Transparencia:** El cliente no distingue entre proxy y objeto real

**Tipos de Proxy:**
- **Virtual Proxy:** Lazy loading de objetos costosos
- **Protection Proxy:** Control de acceso y permisos
- **Remote Proxy:** Representante local de objeto remoto
- **Smart Proxy:** Funcionalidad adicional (caché, conteo de referencias)

**Beneficios:**
- Controla acceso al objeto real
- Optimiza rendimiento (lazy loading, caché)
- Agrega funcionalidad sin modificar objeto real
- Desacopla cliente del objeto real
- Cumple principio Abierto/Cerrado

---

## 🧠 Estructura (Conceptual)

Roles principales del patrón:

- **Subject (Sujeto - Interfaz):** 
  - Define interfaz común para RealSubject y Proxy
  - Permite usar Proxy donde se espera RealSubject
  
- **RealSubject (Sujeto Real):** 
  - Objeto real que el proxy representa
  - Contiene la lógica de negocio real
  - Puede ser costoso de crear o acceder
  
- **Proxy (Proxy):** 
  - Mantiene referencia al RealSubject
  - Implementa la misma interfaz que RealSubject
  - Controla acceso al RealSubject
  - Puede crear el RealSubject bajo demanda
  - Agrega funcionalidad adicional (logging, caché, etc.)
  
- **Client (Cliente):** 
  - Trabaja con Subject (interfaz)
  - No distingue entre Proxy y RealSubject

**Relaciones:**
- Proxy tiene/conoce RealSubject
- Ambos implementan Subject
- Client usa Subject (transparente)

---

## ☕ Implementación en Java

### 📁 Estructura de Carpetas

```text
proxy/
├── context/
│   ├── Image.java                    # Sujeto (interfaz)
│   ├── RealImage.java                # Sujeto real: imagen costosa
│   └── ImageProxy.java               # Proxy: lazy loading
├── strategy/
│   └── Document.java                 # Interfaz para documentos
├── impl/
│   ├── RealDocument.java             # Documento real
│   ├── ProtectionProxy.java          # Proxy: control de acceso
│   ├── CacheProxy.java               # Proxy: caché de resultados
│   ├── LoggingProxy.java             # Proxy: registro de accesos
│   └── RemoteProxy.java              # Proxy: objeto remoto
└── Main.java                          # Demostración de diferentes proxies
