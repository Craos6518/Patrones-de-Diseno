# 📋 models/

Definiciones de tipos y esquemas de datos.

## 📝 Descripción

Contiene las definiciones de tipos TypeScript que corresponden a los modelos de la base de datos.

Estructuras típicas:
- `User.ts` - Interfaz/tipo de Usuario
- `Order.ts` - Interfaz/tipo de Pedido
- `Product.ts` - Interfaz/tipo de Producto
- `*.entity.ts` - Entidades con métodos

## 🎯 Propósito

- Definir tipos TypeScript para seguridad
- Documentar estructura de datos
- Facilitar validación
- Reutilizar tipos en toda la app

## 🏗️ Estructura Típica

```typescript
// models/User.ts
export interface User {
  id: string;
  email: string;
  name: string;
  password: string;
  active: boolean;
  createdAt: Date;
  updatedAt: Date;
}

export interface CreateUserDto {
  email: string;
  name: string;
  password: string;
}

export interface UpdateUserDto {
  name?: string;
  email?: string;
}

// Con métodos de negocio
export class UserEntity implements User {
  id: string;
  email: string;
  name: string;
  password: string;
  active: boolean;
  createdAt: Date;
  updatedAt: Date;

  isAdmin(): boolean {
    return this.roles?.includes('admin') || false;
  }

  hasPermission(permission: string): boolean {
    // lógica de permisos
    return true;
  }
}
```

## 📝 Tipos DTOs

```typescript
// DTO para crear
export class CreateUserDto {
  @IsEmail()
  email: string;

  @IsString()
  @MinLength(3)
  name: string;

  @IsString()
  @MinLength(8)
  password: string;
}

// DTO para actualizar
export class UpdateUserDto {
  @IsString()
  @MinLength(3)
  @IsOptional()
  name?: string;

  @IsEmail()
  @IsOptional()
  email?: string;
}
```

## 🔗 Relaciones

- **Usados por:** Services, Repositories, Controllers
- **Generados de:** Prisma Schema

## 📚 Referencias

- [Repositories](../repositories/)
- [Services](../services/)
