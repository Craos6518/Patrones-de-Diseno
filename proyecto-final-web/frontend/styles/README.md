# 🎨 styles/

Estilos globales de la aplicación.

## 📝 Descripción

Contiene estilos CSS/SCSS globales:

- `globals.css` - Estilos globales
- `variables.css` - Variables CSS
- `tailwind.css` - Configuración Tailwind

## 🎨 Aproximación

La aplicación usa **Tailwind CSS** para estilos, con archivos CSS globales para configuración.

## 🏗️ Ejemplo

```css
/* globals.css */
@layer base {
  html {
    @apply scroll-smooth;
  }

  body {
    @apply bg-white text-gray-900 dark:bg-gray-900 dark:text-white;
  }
}

@layer components {
  .btn {
    @apply px-4 py-2 rounded font-medium transition-colors;
  }

  .btn-primary {
    @apply bg-blue-600 text-white hover:bg-blue-700;
  }

  .btn-secondary {
    @apply bg-gray-200 text-gray-900 hover:bg-gray-300;
  }
}
```

## 📚 Referencias

- [Tailwind CSS](https://tailwindcss.com/)
