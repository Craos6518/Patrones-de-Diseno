# 🛠️ lib/utils/

Funciones auxiliares reutilizables.

## 📝 Descripción

Contiene utilidades compartidas del frontend:

- `format.ts` - Formateo de datos
- `validate.ts` - Validaciones
- `helpers.ts` - Funciones auxiliares
- `constants.ts` - Constantes

## 🎯 Propósito

- Reducir duplicación
- Facilitar mantenimiento
- Reutilizar lógica común

## 🏗️ Ejemplo

```typescript
// format.ts
export const formatDate = (date: Date): string => {
  return new Intl.DateTimeFormat('es-ES').format(date);
};

export const formatCurrency = (amount: number): string => {
  return new Intl.NumberFormat('es-ES', {
    style: 'currency',
    currency: 'EUR'
  }).format(amount);
};

// helpers.ts
export const cn = (...classes: string[]): string => {
  return classes.filter(Boolean).join(' ');
};
```
