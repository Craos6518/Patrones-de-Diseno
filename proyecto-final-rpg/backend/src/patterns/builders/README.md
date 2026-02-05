# 🏗️ builders/

Implementación del Builder pattern.

## 📝 Descripción

Permite construir objetos complejos paso a paso, separando la construcción de la representación.

## 🎯 Caso de Uso

QueryBuilder para construcción fluida de queries Prisma:

```typescript
const users = await new QueryBuilder('user')
  .select(['id', 'name', 'email'])
  .where({ active: true })
  .orderBy('createdAt', 'desc')
  .limit(10)
  .include(['profile', 'orders'])
  .execute();
```

## 📚 Referencias

- [Patrón Builder](../../../../creacionales/builder/)
