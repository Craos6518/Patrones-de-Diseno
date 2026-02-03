# ⚙️ services/

Capa de lógica de negocio de la aplicación.

## 📝 Descripción

Los servicios contienen la lógica de negocio principal. Son llamados por los controladores y utilizan los repositorios para acceder a datos.

Estructuras típicas:
- `UserService.ts` - Lógica de usuarios
- `OrderService.ts` - Lógica de pedidos
- `ProductService.ts` - Lógica de productos
- `AuthService.ts` - Lógica de autenticación

## 🎯 Propósito

- Encapsular lógica de negocio
- Ejecutar validaciones complejas
- Orquestar operaciones multi-paso
- Mantener independencia de la API

## 🏗️ Estructura Típica

```typescript
export class UserService {
  constructor(private userRepository: UserRepository) {}

  async findAll(): Promise<User[]> {
    return await this.userRepository.findAll();
  }

  async findById(id: string): Promise<User> {
    const user = await this.userRepository.findById(id);
    if (!user) throw new NotFoundException('Usuario no encontrado');
    return user;
  }

  async create(data: CreateUserDto): Promise<User> {
    // Validaciones
    const existingUser = await this.userRepository.findByEmail(data.email);
    if (existingUser) throw new ConflictException('Email ya registrado');

    // Hash de contraseña
    const hashedPassword = await hashPassword(data.password);

    // Crear
    return await this.userRepository.create({
      ...data,
      password: hashedPassword
    });
  }

  async update(id: string, data: UpdateUserDto): Promise<User> {
    const user = await this.findById(id);
    return await this.userRepository.update(id, data);
  }

  async delete(id: string): Promise<void> {
    await this.findById(id);
    await this.userRepository.delete(id);
  }
}
```

## 🎨 Patrones Utilizados

- **Factory Pattern** - Para crear instancias de servicios
- **Singleton** - Para servicios globales
- **Strategy** - Para algoritmos intercambiables

## 🔗 Relaciones

- **Reciben de:** Controllers
- **Delegan en:** Repositories
- **Usan:** Utils y helpers

## 📚 Referencias

- [Repositories](../repositories/)
- [Controllers](../controllers/)
