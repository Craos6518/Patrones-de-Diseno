# 🎨 components/

Componentes React reutilizables.

## 📝 Descripción

Contiene componentes React organizados en subcarpetas según su nivel de abstracción.

## 📂 Subcarpetas

### ui/
Componentes base sin lógica de negocio:
- `Button.tsx` - Botón reutilizable
- `Input.tsx` - Input de formulario
- `Modal.tsx` - Modal
- `Card.tsx` - Card
- `Alert.tsx` - Alertas

### forms/
Componentes de formularios:
- `LoginForm.tsx` - Formulario de login
- `UserForm.tsx` - Formulario de usuarios
- `SearchForm.tsx` - Formulario de búsqueda

### layouts/
Componentes de layout:
- `Header.tsx` - Encabezado
- `Sidebar.tsx` - Barra lateral
- `Footer.tsx` - Pie de página
- `Container.tsx` - Contenedor principal

## 🎯 Propósito

- Reutilizar componentes
- Mantener consistencia visual
- Facilitar testing
- Separar responsabilidades

## 🏗️ Estructura de un Componente

```typescript
interface ButtonProps {
  children: React.ReactNode;
  onClick: () => void;
  variant?: 'primary' | 'secondary';
  disabled?: boolean;
}

export const Button: React.FC<ButtonProps> = ({
  children,
  onClick,
  variant = 'primary',
  disabled = false,
}) => {
  return (
    <button
      onClick={onClick}
      disabled={disabled}
      className={`btn btn-${variant}`}
    >
      {children}
    </button>
  );
};
```

## 📚 Referencias

- [React Components](https://react.dev/learn)
