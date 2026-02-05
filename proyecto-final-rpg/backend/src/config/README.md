# 🔧 config/

Configuración general de la aplicación backend.

## 📝 Descripción

Contiene archivos de configuración y conexiones globales de la aplicación:

- **database.ts** - Singleton para la conexión a la base de datos (Prisma)
- **env.ts** - Validación y tipado de variables de entorno
- **constants.ts** - Constantes de la aplicación
- **logger.ts** - Configuración de logging

## 🎯 Propósito

- Centralizar todas las configuraciones de la aplicación
- Implementar el patrón **Singleton** para conexiones
- Garantizar una única instancia de recursos críticos
- Facilitar la inyección de dependencias

## 📦 Patrón Implementado

**Singleton** - Garantiza una única instancia de la conexión a la base de datos durante toda la vida de la aplicación.

## 🚀 Ejemplo de Uso

```typescript
import DatabaseConnection from '@/config/database';

const prisma = DatabaseConnection.getInstance().getClient();
const users = await prisma.user.findMany();
```

## 📚 Referencias

- [Patrón Singleton](../../comportamiento/singleton/)
