# Contribución a Crónicas de Auralis

Gracias por tu interés en contribuir al proyecto! 🎮

## Cómo Contribuir

### 1. Fork del Repositorio

```bash
git clone https://github.com/tu-usuario/Patrones-de-Diseno.git
cd Patrones-de-Diseno/proyecto-final-rpg
```

### 2. Crear Rama de Feature

```bash
git checkout -b feature/nueva-funcionalidad
```

Nomenclatura de ramas:
- `feature/nombre` - Nueva funcionalidad
- `bugfix/nombre` - Corrección de bug
- `pattern/nombre` - Implementación de patrón
- `docs/nombre` - Documentación

### 3. Realizar Cambios

#### Código
- Seguir Google Java Style Guide
- Documentar con JavaDoc
- Nombres descriptivos en español
- Mantener principios SOLID

#### Tests
- Mínimo 80% de cobertura
- Tests unitarios con JUnit 5
- Usar Mockito para mocks

#### Commits
Formato:
```
tipo(ámbito): descripción breve

Descripción detallada si es necesario
```

Tipos:
- `feat`: Nueva funcionalidad
- `fix`: Corrección de bug
- `docs`: Documentación
- `test`: Tests
- `refactor`: Refactorización
- `style`: Formato de código

### 4. Ejecutar Tests

```bash
mvn test
# o
gradle test
```

### 5. Crear Pull Request

1. Push a tu fork
2. Abrir PR en GitHub
3. Describir cambios claramente
4. Vincular issues relacionados
5. Esperar revisión

## Guía de Estilo

### Java
```java
/**
 * Descripción de la clase.
 * Incluir propósito y patrón de diseño si aplica.
 *
 * @author Tu Nombre
 */
public class MiClase {
    
    /**
     * Descripción del método.
     *
     * @param parametro Descripción del parámetro
     * @return Descripción del retorno
     */
    public TipoRetorno miMetodo(TipoParam parametro) {
        // Implementación
    }
}
```

### Patrones de Diseño

Al implementar un patrón:
1. Crear diagrama UML
2. Documentar justificación
3. Incluir ejemplo de uso
4. Agregar tests completos
5. Actualizar README del paquete

## Revisión de Código

Checklist antes de PR:
- [ ] Código compila sin errores
- [ ] Tests pasan (>80% cobertura)
- [ ] JavaDoc completo
- [ ] Sin warnings del compilador
- [ ] Código formateado correctamente
- [ ] README actualizado si es necesario

## Reportar Issues

Template para bugs:
```markdown
## Descripción
¿Qué está fallando?

## Pasos para Reproducir
1. Paso 1
2. Paso 2
3. ...

## Comportamiento Esperado
¿Qué debería pasar?

## Comportamiento Actual
¿Qué está pasando?

## Entorno
- OS: 
- Java: 
- Maven/Gradle: 
```

## Preguntas

Para dudas o consultas, abrir un issue con etiqueta `question`.

## Código de Conducta

- Ser respetuoso
- Constructivo en reviews
- Enfocado en el aprendizaje
- Seguir buenas prácticas

---

¡Gracias por contribuir! 🚀
