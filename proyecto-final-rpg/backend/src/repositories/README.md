# 📦 repositories/

Capa de acceso a datos de la aplicación.

## 📝 Descripción

Los repositorios abstraen la lógica de acceso a datos, permitiendo que el resto de la aplicación no dependa directamente de Prisma.

Estructuras típicas:
- `BaseRepository.ts` - Clase base con operaciones CRUD
- `UserRepository.ts` - Operaciones específicas de usuarios
- `OrderRepository.ts` - Operaciones específicas de pedidos

## 🎯 Propósito

- Abstraer acceso a la base de datos
- Centralizar queries
- Facilitar testing (mocks)
- Implementar patrón **Repository**

## 🏗️ Estructura Típica

```typescript
// Base repository
export abstract class BaseRepository<T> {
  protected model: any;

  constructor(modelName: string) {
    const prisma = DatabaseConnection.getInstance().getClient();
    this.model = (prisma as any)[modelName];
  }

  async findAll(): Promise<T[]> {
    return await this.model.findMany();
  }

  async findById(id: string): Promise<T | null> {
    return await this.model.findUnique({ where: { id } });
  }

  async create(data: Partial<T>): Promise<T> {
    return await this.model.create({ data });
  }

  async update(id: string, data: Partial<T>): Promise<T> {
    return await this.model.update({ where: { id }, data });
  }

  async delete(id: string): Promise<T> {
    return await this.model.delete({ where: { id } });
  }
}

// Implementación concreta
export class UserRepository extends BaseRepository<User> {
  constructor() {
    super('user');
  }

  async findByEmail(email: string): Promise<User | null> {
    return await this.model.findUnique({ where: { email } });
  }

  async findActive(): Promise<User[]> {
    return await this.model.findMany({ where: { active: true } });
  }
}
```

## 🎨 Patrones Utilizados

- **Repository Pattern** - Abstracción de datos
- **Factory** - Para crear repositorios

## 🔗 Relaciones

- **Reciben de:** Services
- **Acceden a:** Prisma/Base de Datos
- **Usan:** Models para tipado

## 📚 Referencias

- [Services](../services/)
- [Models](../models/)
