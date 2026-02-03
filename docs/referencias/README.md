# 📖 Material de Referencia

Esta carpeta contiene bibliografía, artículos y recursos complementarios sobre patrones de diseño.

---

## 📚 Organización del Material

```
referencias/
├── libros/              # PDFs de libros (uso educativo)
├── articulos/           # Papers y artículos académicos
├── tutoriales/          # Guías y tutoriales
├── cheatsheets/         # Hojas de referencia rápida
└── ejemplos/            # Código de ejemplo de referencia
```

---

## 📕 Bibliografía Fundamental

### Libros Clásicos (Gang of Four y más)

#### 1. Design Patterns: Elements of Reusable Object-Oriented Software
**Autores:** Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides (GoF)  
**Año:** 1994  
**ISBN:** 978-0201633610

**Contenido:**
- Los 23 patrones de diseño clásicos
- Categorización: Creacionales, Estructurales, Comportamiento
- Casos de uso y ejemplos en C++ y Smalltalk

**Por qué es importante:**
- El libro que definió el campo de los patrones de diseño
- Vocabulario común para desarrolladores
- Base teórica sólida

---

#### 2. Head First Design Patterns
**Autores:** Eric Freeman, Elisabeth Robson  
**Año:** 2004 (2ª Ed: 2020)  
**ISBN:** 978-0596007126

**Contenido:**
- Patrones GoF explicados de forma visual
- Enfoque pedagógico y práctico
- Ejemplos en Java
- Ejercicios interactivos

**Por qué es importante:**
- Excelente para principiantes
- Metodología de aprendizaje efectiva
- Explicaciones con humor y analogías

---

#### 3. Patterns of Enterprise Application Architecture
**Autor:** Martin Fowler  
**Año:** 2002  
**ISBN:** 978-0321127420

**Contenido:**
- Patrones para aplicaciones empresariales
- Arquitectura en capas
- Patrones de acceso a datos
- Patrones de lógica de negocio

**Por qué es importante:**
- Complementa GoF para aplicaciones empresariales
- Patrones específicos para sistemas grandes
- Autor reconocido en la industria

---

#### 4. Clean Code: A Handbook of Agile Software Craftsmanship
**Autor:** Robert C. Martin (Uncle Bob)  
**Año:** 2008  
**ISBN:** 978-0132350884

**Contenido:**
- Principios de código limpio
- Nombres, funciones, comentarios
- Manejo de errores
- Pruebas unitarias

**Por qué es importante:**
- Fundamentos para escribir buen código
- Complementa patrones con buenas prácticas
- Filosofía de artesanía del software

---

#### 5. Refactoring: Improving the Design of Existing Code
**Autor:** Martin Fowler  
**Año:** 1999 (2ª Ed: 2018)  
**ISBN:** 978-0134757599

**Contenido:**
- Catálogo de refactorizaciones
- Técnicas para mejorar código existente
- Code smells
- Relación con patrones de diseño

---

### Libros en Español

#### Patrones de Diseño
**Autor:** Joaquín Peña  
**Editorial:** RA-MA  
**ISBN:** 978-8478978847

#### UML y Patrones
**Autor:** Craig Larman  
**ISBN:** 978-8420540672

---

## 🌐 Recursos en Línea

### Sitios Web de Referencia

| Sitio | URL | Descripción |
|-------|-----|-------------|
| **Refactoring.Guru** | https://refactoring.guru | Patrones explicados con diagramas y ejemplos |
| **SourceMaking** | https://sourcemaking.com | Patrones, antipatrones, refactoring |
| **Java Design Patterns** | https://java-design-patterns.com | Implementaciones en Java |
| **Baeldung** | https://www.baeldung.com | Tutoriales Java y Spring |
| **DZone Refcardz** | https://dzone.com/refcardz | Cheat sheets técnicos |

### Canales de YouTube

- **Derek Banas** - Design Patterns Tutorial
- **Christopher Okhravi** - Design Patterns (muy detallado)
- **kudvenkat** - Design pattern tutorial for beginners
- **Programming with Mosh** - Design Patterns

---

## 📄 Artículos Académicos

### Papers Fundamentales

1. **A Pattern Language** (Christopher Alexander, 1977)
   - Origen del concepto de patrones
   - Aplicado originalmente a arquitectura
   - Base filosófica de los patrones de diseño

2. **Design Patterns: Abstraction and Reuse** (Gamma et al., 1993)
   - Paper precursor del libro GoF
   - ECOOP '93

3. **Documenting Frameworks using Patterns** (Ralph Johnson, 1992)
   - Uso de patrones para documentar frameworks
   - Relación entre patrones y frameworks

### Artículos de Martin Fowler

- "Inversion of Control Containers and the Dependency Injection pattern"
- "Patterns of Enterprise Application Architecture"
- Blog: https://martinfowler.com/

---

## 🎓 Material Académico UTP

### Presentaciones
- Slides de clase sobre patrones de diseño
- Diapositivas de ejemplos prácticos

### Talleres
- Ejercicios resueltos
- Casos de estudio
- Proyectos de ejemplo

### Evaluaciones
- Exámenes pasados (con permiso)
- Rúbricas de evaluación
- Guías de estudio

---

## 📋 Cheat Sheets

### Patrones GoF Quick Reference

**Creacionales:**
```
Singleton      → Una única instancia
Factory Method → Delegar creación a subclases
Abstract Fact. → Familias de objetos relacionados
Builder        → Construcción paso a paso
Prototype      → Clonación de objetos
```

**Estructurales:**
```
Adapter     → Adaptar interfaces incompatibles
Bridge      → Separar abstracción de implementación
Composite   → Árbol de objetos parte-todo
Decorator   → Agregar responsabilidades dinámicamente
Facade      → Interfaz simplificada
Proxy       → Sustituto controlado
```

**Comportamiento:**
```
Strategy        → Familia de algoritmos intercambiables
Observer        → Notificación automática de cambios
Command         → Encapsular solicitudes como objetos
State           → Comportamiento según estado
Iterator        → Recorrer colecciones
Template Method → Esqueleto de algoritmo
```

### Cuándo Usar Cada Patrón

| Problema | Patrón Recomendado |
|----------|-------------------|
| Necesito una sola instancia | Singleton |
| Debo crear objetos sin conocer sus clases | Factory Method |
| Debo soportar múltiples plataformas | Abstract Factory |
| Constructor con muchos parámetros | Builder |
| Crear objetos es costoso | Prototype |
| Interfaces incompatibles | Adapter |
| Jerarquías en dos dimensiones | Bridge |
| Estructura de árbol | Composite |
| Agregar funcionalidades dinámicas | Decorator |
| Sistema complejo | Facade |
| Control de acceso | Proxy |
| Cambiar algoritmos en runtime | Strategy |
| Notificaciones 1-a-muchos | Observer |
| Deshacer/rehacer | Command |
| Comportamiento según estado | State |
| Recorrer sin exponer estructura | Iterator |
| Pasos fijos, detalles variables | Template Method |

---

## 🔍 Cómo Usar Este Material

### Para Estudiar
1. Comienza con "Head First Design Patterns"
2. Profundiza con el libro GoF
3. Practica con los ejemplos del repositorio
4. Consulta recursos online para casos específicos

### Para Implementar
1. Identifica el problema
2. Consulta el cheat sheet
3. Revisa el ejemplo en el repositorio
4. Adapta a tu caso específico

### Para Enseñar
1. Usa los diagramas visuales
2. Referencia ejemplos del mundo real
3. Muestra código antes/después
4. Relaciona con principios SOLID

---

## ⚖️ Derechos de Autor

**Importante:** Todo el material aquí referenciado o almacenado es exclusivamente para uso educativo en el contexto académico de la Universidad Tecnológica de Pereira (UTP).

- Respetar derechos de autor de los libros
- No distribuir material con copyright
- Citar fuentes correctamente
- Usar licencias Creative Commons cuando esté disponible

---

## 🔗 Enlaces Relacionados

- [Volver a Documentación](../README.md)
- [Diagramas UML](../diagramas/)
- [README Principal](../../README.md)
- [Proyecto Final](../../proyecto-final-web/)

---

## 📝 Contribuir

Si encuentras material útil:
- Agrega la referencia aquí
- Incluye descripción breve
- Especifica licencia/copyright
- Mantén la organización

---

> **Nota de Estudio:** Los patrones no son recetas mágicas. Úsalos cuando aporten valor real, no por moda. La sobreingeniería es tan mala como la falta de diseño.
