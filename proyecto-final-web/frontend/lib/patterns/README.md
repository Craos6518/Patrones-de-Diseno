# 🎨 lib/patterns/

Implementación de patrones de diseño en el frontend.

## 📝 Descripción

Contiene la implementación de patrones GoF para React.

## 🎯 Patrones Implementados

| Patrón | Archivo | Descripción |
|--------|---------|-------------|
| **Singleton** | `ConfigManager.ts` | Configuración global |
| **Factory** | `ComponentFactory.tsx` | Crear componentes dinámicamente |
| **Observer** | `../context/` | Context API |
| **Strategy** | `validators/` | Validaciones intercambiables |
| **Decorator** | `hoc/withAuth.tsx` | HOCs para composición |
| **Facade** | `../api/ApiClient.ts` | Cliente API simplificado |
| **Proxy** | `LazyLoader.tsx` | Lazy loading dinámico |

## 📚 Referencias

- [Patrones Backend](../../backend/src/patterns/)
- [Documentación GoF](../../../docs/)
