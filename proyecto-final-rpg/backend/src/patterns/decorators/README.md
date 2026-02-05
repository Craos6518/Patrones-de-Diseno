# 🎀 decorators/

Implementación del Decorator pattern.

## 📝 Descripción

Agrega dinámicamente responsabilidades a objetos, proporcionando una alternativa flexible a la herencia.

## 🎯 Caso de Uso

Middlewares de autenticación y autorización:

```typescript
class AuthDecorator {
  static withAuth(handler: RouteHandler): RouteHandler {
    return async (req, res, next) => {
      const token = req.headers.authorization?.split(' ')[1];
      // validar token
      await handler(req, res, next);
    };
  }

  static withRole(role: string) {
    return (handler: RouteHandler): RouteHandler => {
      return async (req, res, next) => {
        if (!req.user?.roles.includes(role)) {
          res.status(403).json({ error: 'Forbidden' });
          return;
        }
        await handler(req, res, next);
      };
    };
  }
}
```

## 📚 Referencias

- [Patrón Decorator](../../../../estructurales/decorator/)
