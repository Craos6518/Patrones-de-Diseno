# 🛡️ middleware/

Middlewares personalizados de la aplicación.

## 📝 Descripción

Middlewares que procesan solicitudes antes de llegar a los controladores.

Estructuras típicas:
- `AuthMiddleware.ts` - Validación de tokens JWT
- `ValidationMiddleware.ts` - Validación de datos
- `ErrorMiddleware.ts` - Manejo de errores
- `LoggerMiddleware.ts` - Logging de peticiones
- `CorsMiddleware.ts` - CORS y seguridad

## 🎯 Propósito

- Validar autenticación
- Transformar datos
- Manejar errores globales
- Logging y auditoría
- Seguridad (CORS, rate limiting)

## 🏗️ Estructura Típica

```typescript
import { Request, Response, NextFunction } from 'express';

// Middleware de autenticación
export const authMiddleware = (
  req: Request,
  res: Response,
  next: NextFunction
): void => {
  const token = req.headers.authorization?.split(' ')[1];

  if (!token) {
    res.status(401).json({ error: 'No token provided' });
    return;
  }

  try {
    const decoded = verifyToken(token);
    req.user = decoded;
    next();
  } catch (error) {
    res.status(401).json({ error: 'Invalid token' });
  }
};

// Middleware de validación
export const validateBody = (schema: ZodSchema) => {
  return (req: Request, res: Response, next: NextFunction): void => {
    try {
      const validated = schema.parse(req.body);
      req.body = validated;
      next();
    } catch (error) {
      res.status(400).json({ error: 'Validation failed' });
    }
  };
};

// Middleware de error
export const errorHandler = (
  err: Error,
  req: Request,
  res: Response,
  next: NextFunction
): void => {
  console.error(err);
  res.status(500).json({ error: 'Internal server error' });
};
```

## 🎨 Patrón Implementado

**Decorator Pattern** - Los middlewares actúan como decoradores que envuelven la funcionalidad.

## 🔗 Relaciones

- **Ejecutan antes que:** Controllers
- **Usan:** Utilities

## 📚 Referencias

- [Controllers](../controllers/)
- [Patterns - Decorator](../patterns/decorators/)
