# 🎯 strategies/

Implementación del Strategy pattern.

## 📝 Descripción

Define una familia de algoritmos, los encapsula y los hace intercambiables.

## 🎯 Caso de Uso

Diferentes estrategias de ordenamiento:

```typescript
interface SortStrategy<T> {
  sort(items: T[]): T[];
}

class DateSortStrategy implements SortStrategy<any> { }
class AlphabeticSortStrategy implements SortStrategy<any> { }
class NumericSortStrategy implements SortStrategy<any> { }

const sorter = new Sorter(new DateSortStrategy('createdAt', 'desc'));
const sorted = sorter.sort(items);
```

## 📚 Referencias

- [Patrón Strategy](../../../../comportamiento/strategy/)
