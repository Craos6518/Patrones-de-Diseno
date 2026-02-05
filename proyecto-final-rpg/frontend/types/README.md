# 📝 types/

Definiciones de tipos TypeScript.

## 📝 Descripción

Contiene interfaces y tipos para type safety:

- `index.ts` - Tipos comunes
- `api.ts` - Respuestas API
- `user.ts` - Tipos de usuario
- `entities.ts` - Entidades

## 🏗️ Ejemplo

```typescript
// types/user.ts
export interface User {
  id: string;
  name: string;
  email: string;
  roles: string[];
  createdAt: Date;
  updatedAt: Date;
}

export interface CreateUserDto {
  name: string;
  email: string;
  password: string;
}

// types/api.ts
export interface ApiResponse<T> {
  success: boolean;
  data?: T;
  error?: string;
}

export interface PaginatedResponse<T> {
  items: T[];
  total: number;
  page: number;
  limit: number;
}
```

## 📚 Referencias

- [TypeScript](https://www.typescriptlang.org/)
