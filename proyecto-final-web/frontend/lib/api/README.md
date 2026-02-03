# 🌐 lib/api/

Cliente HTTP y servicios de API.

## 📝 Descripción

Contiene la configuración del cliente HTTP (Facade) para comunicación con el backend.

## 🎨 Patrón: Facade

El `ApiClient` simplifica el acceso a la API:

```typescript
class ApiClient {
  async get<T>(endpoint: string): Promise<T>
  async post<T>(endpoint: string, data: any): Promise<T>
  async put<T>(endpoint: string, data: any): Promise<T>
  async delete<T>(endpoint: string): Promise<T>
}

export default new ApiClient();
```

## 🏗️ Ejemplo

```typescript
import api from '@/lib/api/ApiClient';

// Uso simple
const users = await api.get<User[]>('/users');
const newUser = await api.post('/users', userData);
```

## 📋 Servicios

- `ApiClient.ts` - Cliente HTTP principal
- `userService.ts` - Servicio de usuarios
- `orderService.ts` - Servicio de pedidos
- `authService.ts` - Servicio de autenticación

## 📚 Referencias

- [Patrón Facade](../../../estructurales/facade/)
