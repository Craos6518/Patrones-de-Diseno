# 🏭 factories/

Implementación de Factory Method y Abstract Factory patterns.

## 📝 Descripción

Contiene la lógica para crear instancias de objetos sin especificar sus clases concretas.

## 🎯 Patrones

### Factory Method
```typescript
// ServiceFactory.ts
class ServiceFactory {
  static createService(type: string): Service {
    switch (type) {
      case 'user':
        return new UserService();
      case 'order':
        return new OrderService();
      default:
        throw new Error(`Service type ${type} not found`);
    }
  }
}
```

### Abstract Factory
```typescript
// AuthProviderFactory.ts
class AuthProviderFactory {
  static createProvider(type: 'local' | 'google' | 'github'): AuthProvider {
    switch (type) {
      case 'local':
        return new LocalAuthProvider();
      case 'google':
        return new GoogleAuthProvider();
      case 'github':
        return new GithubAuthProvider();
    }
  }
}
```

## 📚 Referencias

- [Patrón Factory](../../../../creacionales/factory-method/)
- [Patrón Abstract Factory](../../../../creacionales/abstract-factory/)
