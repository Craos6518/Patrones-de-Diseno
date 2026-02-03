# 📝 types/

Definiciones de tipos TypeScript globales.

## 📝 Descripción

Contiene interfaces y tipos que se reutilizan en toda la aplicación:

- `index.ts` - Tipos comunes
- `express.d.ts` - Extensión de tipos Express
- `environment.ts` - Variables de entorno tipadas
- `api.ts` - Tipos para respuestas API

## 🎯 Propósito

- Type safety en toda la aplicación
- Autocompletado en el IDE
- Documentación del contrato de datos

## 🏗️ Ejemplo

```typescript
// types/express.d.ts
declare global {
  namespace Express {
    interface Request {
      user?: {
        id: string;
        email: string;
        roles: string[];
      };
    }
  }
}

// types/api.ts
export interface ApiResponse<T> {
  success: boolean;
  data?: T;
  error?: string;
  timestamp: Date;
}
```

## 📚 Referencias

- [Models](../models/)
