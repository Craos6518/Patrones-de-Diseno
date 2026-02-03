# 🔒 proxies/

Implementación del Proxy pattern.

## 📝 Descripción

Proporciona un sustituto o marcador de posición para otro objeto para controlar el acceso a él.

## 🎯 Caso de Uso

Cache Proxy para evitar queries repetidas:

```typescript
class CacheProxy {
  async get<T>(key: string, fetcher: () => Promise<T>): Promise<T> {
    const cached = await this.redis.get(key);
    
    if (cached) {
      return JSON.parse(cached);
    }

    const data = await fetcher();
    await this.redis.setex(key, this.ttl, JSON.stringify(data));
    
    return data;
  }
}
```

## 📚 Referencias

- [Patrón Proxy](../../../../estructurales/proxy/)
