# 🧩 components/ui/

Componentes de interfaz de usuario base.

## 📝 Descripción

Componentes atómicos sin lógica de negocio, reutilizables en toda la aplicación.

## 📋 Componentes

- `Button.tsx` - Botón con variantes
- `Input.tsx` - Input de texto
- `Select.tsx` - Selector
- `Modal.tsx` - Modal/Dialog
- `Card.tsx` - Card/Panel
- `Alert.tsx` - Alertas
- `Badge.tsx` - Insignias
- `Spinner.tsx` - Loader

## 🎨 Patrón: Factory

Se puede usar Factory Pattern para crear componentes dinámicamente:

```typescript
export const componentFactory = (
  type: 'button' | 'input' | 'card',
  props: any
) => {
  switch (type) {
    case 'button':
      return <Button {...props} />;
    case 'input':
      return <Input {...props} />;
    case 'card':
      return <Card {...props} />;
  }
};
```
