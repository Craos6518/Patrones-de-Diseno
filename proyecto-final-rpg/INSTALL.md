# Crónicas de Auralis - Guía de Instalación

## Requisitos Previos

- Java JDK 17 o superior
- Maven 3.8+ o Gradle 8.0+
- JavaFX SDK (se descarga automáticamente)
- Git (opcional)

## Instalación

### 1. Clonar el Repositorio

```bash
git clone https://github.com/Craos6518/Patrones-de-Diseno.git
cd Patrones-de-Diseno/proyecto-final-rpg
```

### 2. Compilar con Maven

```bash
mvn clean install
```

### 2. Alternativa: Compilar con Gradle

```bash
gradle build
```

### 3. Ejecutar el Juego

**Con Maven:**
```bash
mvn javafx:run
```

**Con Gradle:**
```bash
gradle run
```

## Crear JAR Ejecutable

**Con Maven:**
```bash
mvn package
java -jar target/cronicas-de-auralis-1.0.jar
```

**Con Gradle:**
```bash
gradle jar
java -jar build/libs/cronicas-de-auralis-1.0.jar
```

## Configuración de IDE

### IntelliJ IDEA
1. Abrir como proyecto Maven/Gradle
2. Esperar a que se descarguen dependencias
3. Ejecutar clase `Main.java`

### Eclipse
1. Import → Existing Maven/Gradle Project
2. Seleccionar carpeta del proyecto
3. Run as Java Application → Main

### VS Code
1. Abrir carpeta del proyecto
2. Instalar extensiones: Java Extension Pack, JavaFX
3. F5 para ejecutar

## Solución de Problemas

### JavaFX no se encuentra
Verificar que Maven/Gradle está descargando las dependencias correctamente.

### Error de versión de Java
Verificar que Java 17+ está instalado: `java -version`

## Base de Datos Opcional

Si deseas usar PostgreSQL para estadísticas:

```bash
psql -U postgres
CREATE DATABASE auralis_db;
```

Configurar en `application.properties`:
```properties
db.url=jdbc:postgresql://localhost:5432/auralis_db
db.user=postgres
db.password=tu_password
```
