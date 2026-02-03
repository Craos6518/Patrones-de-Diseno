# 🎨 patterns/

Implementación de patrones de diseño GoF en el backend.

## 📝 Descripción

Contiene la implementación de patrones de diseño organizados por categoría.

## 📂 Subcarpetas

- **factories/** - Factory Method y Abstract Factory
- **builders/** - Builder pattern
- **strategies/** - Strategy pattern
- **decorators/** - Decorator pattern
- **proxies/** - Proxy pattern
- **states/** - State pattern

## 🎯 Patrones Implementados

| Patrón | Archivo | Descripción |
|--------|---------|-------------|
| **Singleton** | `../config/database.ts` | Conexión DB única |
| **Factory Method** | `factories/ServiceFactory.ts` | Creación de servicios |
| **Abstract Factory** | `factories/AuthProviderFactory.ts` | Proveedores de auth |
| **Builder** | `builders/QueryBuilder.ts` | Queries complejas |
| **Repository** | `../repositories/BaseRepository.ts` | Acceso a datos |
| **Decorator** | `decorators/AuthDecorator.ts` | Middlewares auth |
| **Proxy** | `proxies/CacheProxy.ts` | Caché de datos |
| **Strategy** | `strategies/SortStrategy.ts` | Algoritmos |
| **State** | `states/OrderState.ts` | Máquina de estados |
| **Command** | `commands/ActionCommand.ts` | Acciones encapsuladas |
| **Observer** | `events/EventEmitter.ts` | Sistema de eventos |
| **Chain of Resp.** | `handlers/RequestHandler.ts` | Pipeline de procesamiento |
| **Template Method** | `templates/ProcessTemplate.ts` | Flujos de procesamiento |
| **Adapter** | `adapters/PaymentAdapter.ts` | Integración externa |

## 🚀 Cómo Usar

Importa los patrones según necesites:

```typescript
import ServiceFactory from '@/patterns/factories/ServiceFactory';
import QueryBuilder from '@/patterns/builders/QueryBuilder';
import CacheProxy from '@/patterns/proxies/CacheProxy';

const userService = ServiceFactory.createService('user');
const query = new QueryBuilder('user').select(['id', 'name']);
const cached = new CacheProxy().get('key', fetcher);
```

## 📚 Referencias

- [Patrones en el Proyecto Principal](../../../..)
- [Documentación GoF](../../../../docs/)
