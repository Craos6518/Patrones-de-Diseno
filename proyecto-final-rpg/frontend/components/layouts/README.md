# 🏗️ components/layouts/

Componentes de layout y estructura.

## 📝 Descripción

Componentes que definen la estructura y disposición de la aplicación.

## 📋 Componentes

- `Header.tsx` - Encabezado con navegación
- `Sidebar.tsx` - Barra lateral
- `Footer.tsx` - Pie de página
- `Container.tsx` - Contenedor principal
- `Grid.tsx` - Sistema de grid
- `Flex.tsx` - Flexbox wrapper

## 🎨 Patrón: Composite

Los layouts pueden componerse de otros layouts:

```typescript
export const AppLayout: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  return (
    <div className="app">
      <Header />
      <div className="main">
        <Sidebar />
        <Container>{children}</Container>
      </div>
      <Footer />
    </div>
  );
};
```

## 🏗️ Ejemplo

```typescript
export const Header: React.FC = () => {
  return (
    <header className="header">
      <div className="logo">App</div>
      <nav className="nav">
        <a href="/home">Home</a>
        <a href="/about">About</a>
      </nav>
    </header>
  );
};
```
