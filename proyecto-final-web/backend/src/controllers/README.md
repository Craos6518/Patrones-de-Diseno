# 🎮 controllers/

Controladores que manejan las rutas HTTP de la API.

## 📝 Descripción

Los controladores son la capa que recibe las peticiones HTTP y delega la lógica de negocio a los servicios.

Estructuras típicas:
- `UserController.ts` - Endpoints de usuarios
- `OrderController.ts` - Endpoints de pedidos
- `ProductController.ts` - Endpoints de productos
- `AuthController.ts` - Endpoints de autenticación

## 🎯 Propósito

- Manejar solicitudes HTTP entrantes
- Validar parámetros y datos
- Delegar lógica a servicios
- Retornar respuestas formateadas

## 🏗️ Estructura Típica

```typescript
export class UserController {
  constructor(private userService: UserService) {}

  async getAll(req: Request, res: Response): Promise<void> {
    const users = await this.userService.findAll();
    res.json(users);
  }

  async getById(req: Request, res: Response): Promise<void> {
    const user = await this.userService.findById(req.params.id);
    res.json(user);
  }

  async create(req: Request, res: Response): Promise<void> {
    const user = await this.userService.create(req.body);
    res.status(201).json(user);
  }

  async update(req: Request, res: Response): Promise<void> {
    const user = await this.userService.update(req.params.id, req.body);
    res.json(user);
  }

  async delete(req: Request, res: Response): Promise<void> {
    await this.userService.delete(req.params.id);
    res.status(204).send();
  }
}
```

## 🔗 Relaciones

- **Reciben de:** Express Router
- **Delegan en:** Services
- **Usan:** Middleware para validación/autenticación

## 📚 Referencias

- [Services](../services/)
- [Middleware](../middleware/)
