# ⚙️ Backend - API REST

Servidor backend que implementa patrones de diseño en la lógica de negocio y arquitectura.

---

## 🏗️ Estructura del Proyecto

```
backend/
├── src/
│   ├── config/          # Configuración
│   │   └── database.ts  # Singleton - Conexión DB
│   ├── controllers/     # Controladores (endpoints)
│   ├── services/        # Lógica de negocio
│   ├── repositories/    # Acceso a datos
│   ├── models/          # Modelos de datos
│   ├── middleware/      # Middlewares
│   ├── patterns/        # Implementación de patrones
│   │   ├── factories/
│   │   ├── builders/
│   │   ├── strategies/
│   │   ├── decorators/
│   │   ├── proxies/
│   │   └── states/
│   ├── utils/           # Utilidades
│   ├── types/           # TypeScript types
│   └── index.ts         # Entry point
├── tests/               # Tests
├── prisma/              # Schema Prisma (si se usa)
├── package.json
└── tsconfig.json
```

---

## 🎯 Patrones de Diseño Implementados

### 1. Singleton - Conexión a Base de Datos

**Archivo:** `config/database.ts`

```typescript
import { PrismaClient } from '@prisma/client';

class DatabaseConnection {
  private static instance: DatabaseConnection;
  private prisma: PrismaClient;

  private constructor() {
    this.prisma = new PrismaClient({
      log: ['query', 'error', 'warn'],
    });
  }

  public static getInstance(): DatabaseConnection {
    if (!DatabaseConnection.instance) {
      DatabaseConnection.instance = new DatabaseConnection();
    }
    return DatabaseConnection.instance;
  }

  public getClient(): PrismaClient {
    return this.prisma;
  }

  public async disconnect(): Promise<void> {
    await this.prisma.$disconnect();
  }
}

export default DatabaseConnection.getInstance();
```

---

### 2. Factory Method - Creación de Servicios

**Archivo:** `patterns/factories/ServiceFactory.ts`

```typescript
interface Service {
  execute(...args: any[]): Promise<any>;
}

class UserService implements Service {
  async execute(action: string, data: any) {
    // Lógica específica de usuarios
  }
}

class OrderService implements Service {
  async execute(action: string, data: any) {
    // Lógica específica de pedidos
  }
}

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

export default ServiceFactory;
```

---

### 3. Abstract Factory - Proveedores de Autenticación

**Archivo:** `patterns/factories/AuthProviderFactory.ts`

```typescript
// Productos abstractos
interface AuthProvider {
  authenticate(credentials: any): Promise<User>;
  validateToken(token: string): Promise<boolean>;
}

// Productos concretos
class LocalAuthProvider implements AuthProvider {
  async authenticate(credentials: { email: string; password: string }) {
    // Autenticación local
  }
  
  async validateToken(token: string) {
    // Validación JWT
  }
}

class GoogleAuthProvider implements AuthProvider {
  async authenticate(credentials: { token: string }) {
    // Autenticación con Google
  }
  
  async validateToken(token: string) {
    // Validación token Google
  }
}

class GithubAuthProvider implements AuthProvider {
  async authenticate(credentials: { code: string }) {
    // Autenticación con GitHub
  }
  
  async validateToken(token: string) {
    // Validación token GitHub
  }
}

// Factory abstracta
class AuthProviderFactory {
  static createProvider(type: 'local' | 'google' | 'github'): AuthProvider {
    switch (type) {
      case 'local':
        return new LocalAuthProvider();
      case 'google':
        return new GoogleAuthProvider();
      case 'github':
        return new GithubAuthProvider();
      default:
        throw new Error(`Auth provider ${type} not supported`);
    }
  }
}

export default AuthProviderFactory;
```

---

### 4. Builder - Constructor de Queries Complejas

**Archivo:** `patterns/builders/QueryBuilder.ts`

```typescript
class QueryBuilder {
  private query: any = {};
  private tableName: string = '';

  constructor(table: string) {
    this.tableName = table;
  }

  select(fields: string[]) {
    this.query.select = fields;
    return this;
  }

  where(conditions: Record<string, any>) {
    this.query.where = { ...this.query.where, ...conditions };
    return this;
  }

  orderBy(field: string, direction: 'asc' | 'desc' = 'asc') {
    this.query.orderBy = { [field]: direction };
    return this;
  }

  limit(count: number) {
    this.query.take = count;
    return this;
  }

  offset(count: number) {
    this.query.skip = count;
    return this;
  }

  include(relations: string[]) {
    this.query.include = relations.reduce((acc, rel) => {
      acc[rel] = true;
      return acc;
    }, {} as Record<string, boolean>);
    return this;
  }

  build() {
    return this.query;
  }

  async execute() {
    const prisma = DatabaseConnection.getInstance().getClient();
    return await (prisma as any)[this.tableName].findMany(this.query);
  }
}

// Uso
const users = await new QueryBuilder('user')
  .select(['id', 'name', 'email'])
  .where({ active: true })
  .orderBy('createdAt', 'desc')
  .limit(10)
  .include(['profile', 'orders'])
  .execute();
```

---

### 5. Repository Pattern

**Archivo:** `repositories/BaseRepository.ts`

```typescript
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
class UserRepository extends BaseRepository<User> {
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

---

### 6. Decorator - Middleware de Autenticación

**Archivo:** `patterns/decorators/AuthDecorator.ts`

```typescript
import { Request, Response, NextFunction } from 'express';

// Decorator base
interface RouteHandler {
  (req: Request, res: Response, next: NextFunction): Promise<void>;
}

class AuthDecorator {
  static withAuth(handler: RouteHandler): RouteHandler {
    return async (req: Request, res: Response, next: NextFunction) => {
      const token = req.headers.authorization?.split(' ')[1];
      
      if (!token) {
        res.status(401).json({ error: 'No token provided' });
        return;
      }

      try {
        const user = await verifyToken(token);
        req.user = user;
        await handler(req, res, next);
      } catch (error) {
        res.status(401).json({ error: 'Invalid token' });
      }
    };
  }

  static withRole(role: string) {
    return (handler: RouteHandler): RouteHandler => {
      return async (req: Request, res: Response, next: NextFunction) => {
        if (!req.user?.roles.includes(role)) {
          res.status(403).json({ error: 'Forbidden' });
          return;
        }
        await handler(req, res, next);
      };
    };
  }
}

// Uso
const getAdminData = AuthDecorator.withAuth(
  AuthDecorator.withRole('admin')(
    async (req, res) => {
      const data = await AdminService.getData();
      res.json(data);
    }
  )
);
```

---

### 7. Proxy - Caché de Datos

**Archivo:** `patterns/proxies/CacheProxy.ts`

```typescript
import Redis from 'ioredis';

class CacheProxy {
  private redis: Redis;
  private ttl: number = 3600; // 1 hora por defecto

  constructor() {
    this.redis = new Redis({
      host: process.env.REDIS_HOST,
      port: parseInt(process.env.REDIS_PORT || '6379'),
    });
  }

  async get<T>(key: string, fetcher: () => Promise<T>): Promise<T> {
    // Intentar obtener del caché
    const cached = await this.redis.get(key);
    
    if (cached) {
      return JSON.parse(cached) as T;
    }

    // Si no está en caché, ejecutar fetcher
    const data = await fetcher();
    
    // Guardar en caché
    await this.redis.setex(key, this.ttl, JSON.stringify(data));
    
    return data;
  }

  async invalidate(pattern: string): Promise<void> {
    const keys = await this.redis.keys(pattern);
    if (keys.length > 0) {
      await this.redis.del(...keys);
    }
  }

  setTTL(seconds: number): this {
    this.ttl = seconds;
    return this;
  }
}

// Uso
const cache = new CacheProxy();

async function getUser(id: string) {
  return await cache.get(
    `user:${id}`,
    () => userRepository.findById(id)
  );
}
```

---

### 8. Strategy - Algoritmos de Ordenamiento

**Archivo:** `patterns/strategies/SortStrategy.ts`

```typescript
interface SortStrategy<T> {
  sort(items: T[]): T[];
}

class DateSortStrategy implements SortStrategy<any> {
  constructor(private field: string, private order: 'asc' | 'desc' = 'asc') {}

  sort(items: any[]) {
    return items.sort((a, b) => {
      const dateA = new Date(a[this.field]).getTime();
      const dateB = new Date(b[this.field]).getTime();
      return this.order === 'asc' ? dateA - dateB : dateB - dateA;
    });
  }
}

class AlphabeticSortStrategy implements SortStrategy<any> {
  constructor(private field: string, private order: 'asc' | 'desc' = 'asc') {}

  sort(items: any[]) {
    return items.sort((a, b) => {
      const comparison = a[this.field].localeCompare(b[this.field]);
      return this.order === 'asc' ? comparison : -comparison;
    });
  }
}

class NumericSortStrategy implements SortStrategy<any> {
  constructor(private field: string, private order: 'asc' | 'desc' = 'asc') {}

  sort(items: any[]) {
    return items.sort((a, b) => {
      return this.order === 'asc' 
        ? a[this.field] - b[this.field]
        : b[this.field] - a[this.field];
    });
  }
}

// Context
class Sorter<T> {
  constructor(private strategy: SortStrategy<T>) {}

  setStrategy(strategy: SortStrategy<T>) {
    this.strategy = strategy;
  }

  sort(items: T[]): T[] {
    return this.strategy.sort(items);
  }
}

// Uso
const sorter = new Sorter(new DateSortStrategy('createdAt', 'desc'));
const sortedItems = sorter.sort(items);
```

---

### 9. State - Máquina de Estados para Pedidos

**Archivo:** `patterns/states/OrderState.ts`

```typescript
interface OrderState {
  next(order: Order): void;
  cancel(order: Order): void;
  getStatus(): string;
}

class PendingState implements OrderState {
  next(order: Order) {
    order.setState(new ProcessingState());
  }

  cancel(order: Order) {
    order.setState(new CancelledState());
  }

  getStatus() {
    return 'PENDING';
  }
}

class ProcessingState implements OrderState {
  next(order: Order) {
    order.setState(new ShippedState());
  }

  cancel(order: Order) {
    throw new Error('Cannot cancel order in processing');
  }

  getStatus() {
    return 'PROCESSING';
  }
}

class ShippedState implements OrderState {
  next(order: Order) {
    order.setState(new DeliveredState());
  }

  cancel(order: Order) {
    throw new Error('Cannot cancel shipped order');
  }

  getStatus() {
    return 'SHIPPED';
  }
}

class DeliveredState implements OrderState {
  next(order: Order) {
    throw new Error('Order already delivered');
  }

  cancel(order: Order) {
    throw new Error('Cannot cancel delivered order');
  }

  getStatus() {
    return 'DELIVERED';
  }
}

class CancelledState implements OrderState {
  next(order: Order) {
    throw new Error('Cannot proceed with cancelled order');
  }

  cancel(order: Order) {
    throw new Error('Order already cancelled');
  }

  getStatus() {
    return 'CANCELLED';
  }
}

// Context
class Order {
  private state: OrderState;

  constructor() {
    this.state = new PendingState();
  }

  setState(state: OrderState) {
    this.state = state;
  }

  nextState() {
    this.state.next(this);
  }

  cancel() {
    this.state.cancel(this);
  }

  getStatus() {
    return this.state.getStatus();
  }
}
```

---

## 🛠️ Tecnologías

- **Node.js 20+** / **TypeScript**
- **Express.js** - Framework web
- **Prisma** - ORM
- **PostgreSQL** - Base de datos
- **JWT** - Autenticación
- **Zod** - Validación
- **Jest** - Testing
- **Swagger** - Documentación API

---

## 📦 Scripts

```bash
npm run dev          # Desarrollo con hot reload
npm run build        # Build producción
npm run start        # Servidor producción
npm run migrate      # Migraciones DB
npm run seed         # Datos de prueba
npm test             # Tests
npm run lint         # Linter
```

---

## 🔗 Enlaces

- [Volver al Proyecto](../README.md)
- [Frontend](../frontend/README.md)
