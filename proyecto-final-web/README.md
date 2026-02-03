# 🚀 Proyecto Final Web - Aplicación de Patrones de Diseño

Aplicación web full-stack que integra múltiples patrones de diseño en un caso práctico real.

---

## 🎯 Objetivo del Proyecto

Demostrar la aplicación práctica de patrones de diseño clásicos (GoF) en el desarrollo de una aplicación web moderna, mostrando cómo los conceptos orientados a objetos se trasladan a arquitecturas web actuales.

---

## 📋 Descripción General

Este proyecto integrador implementa un **Sistema de Gestión [definir dominio]** utilizando:

- **Frontend:** React + Next.js
- **Backend:** Node.js / Java (definir según decisión final)
- **Base de Datos:** PostgreSQL con Supabase
- **Patrones:** Múltiples patrones GoF aplicados estratégicamente

---

## 🏗️ Arquitectura General

```
proyecto-final-web/
├── frontend/           # Aplicación React/Next.js
│   ├── components/    # Componentes reutilizables
│   ├── pages/        # Páginas de la aplicación
│   ├── services/     # Servicios (consumo de API)
│   ├── hooks/        # Custom hooks de React
│   ├── context/      # Context API
│   ├── utils/        # Utilidades
│   └── patterns/     # Implementación de patrones en frontend
│
├── backend/           # API REST / GraphQL
│   ├── controllers/  # Controladores (endpoints)
│   ├── services/     # Lógica de negocio
│   ├── models/       # Modelos de datos
│   ├── repositories/ # Acceso a datos
│   ├── patterns/     # Implementación de patrones en backend
│   ├── middleware/   # Middlewares
│   └── config/       # Configuración
│
└── README.md         # Este archivo
```

---

## 🎨 Patrones de Diseño Implementados

### Frontend (React/Next.js)

| Patrón | Aplicación | Ubicación |
|--------|-----------|-----------|
| **Singleton** | Gestión de configuración global | `services/ConfigManager.js` |
| **Factory** | Creación de componentes dinámicos | `factories/ComponentFactory.jsx` |
| **Observer** | Sistema de notificaciones (toasts) | `context/NotificationContext.jsx` |
| **Strategy** | Validación de formularios | `validators/ValidationStrategy.js` |
| **Decorator** | HOCs para autenticación/autorización | `hoc/withAuth.jsx` |
| **Facade** | API client simplificado | `services/ApiClient.js` |
| **Proxy** | Lazy loading de componentes | `components/LazyLoader.jsx` |

### Backend (Node.js/Java)

| Patrón | Aplicación | Ubicación |
|--------|-----------|-----------|
| **Singleton** | Conexión a base de datos | `config/DatabaseConnection` |
| **Factory Method** | Creación de servicios | `factories/ServiceFactory` |
| **Abstract Factory** | Proveedores de autenticación | `auth/AuthProviderFactory` |
| **Builder** | Construcción de queries complejas | `builders/QueryBuilder` |
| **Prototype** | Clonación de configuraciones | `prototypes/ConfigPrototype` |
| **Adapter** | Integración con APIs externas | `adapters/PaymentAdapter` |
| **Decorator** | Middlewares de autenticación | `middleware/AuthDecorator` |
| **Facade** | Fachada de servicios externos | `facades/EmailServiceFacade` |
| **Proxy** | Caché de datos | `proxies/CacheProxy` |
| **Chain of Resp.** | Pipeline de procesamiento | `handlers/RequestHandler` |
| **Command** | Sistema de acciones/eventos | `commands/ActionCommand` |
| **Template Method** | Flujos de procesamiento | `templates/ProcessTemplate` |
| **Strategy** | Algoritmos de ordenamiento/filtrado | `strategies/SortStrategy` |
| **Observer** | Sistema de eventos | `events/EventEmitter` |
| **State** | Máquina de estados para procesos | `states/OrderState` |

---

## 🛠️ Stack Tecnológico

### Frontend
```json
{
  "framework": "Next.js 14+",
  "ui-library": "React 18+",
  "styling": "Tailwind CSS",
  "state-management": "Context API / Zustand",
  "http-client": "Axios",
  "forms": "React Hook Form",
  "validation": "Zod / Yup",
  "testing": "Jest + React Testing Library"
}
```

### Backend
```json
{
  "runtime": "Node.js 20+ / Java 17+",
  "framework": "Express.js / Spring Boot",
  "orm": "Prisma / TypeORM / JPA",
  "validation": "Joi / Bean Validation",
  "auth": "JWT + OAuth2",
  "testing": "Jest / JUnit + Mockito",
  "documentation": "Swagger/OpenAPI"
}
```

### Base de Datos
```json
{
  "database": "PostgreSQL 15+",
  "platform": "Supabase",
  "features": [
    "Auth integrado",
    "Real-time subscriptions",
    "Storage de archivos",
    "Edge Functions"
  ]
}
```

---

## 🚦 Casos de Uso del Sistema

### Módulos Principales

1. **Autenticación y Autorización**
   - Registro de usuarios
   - Login con múltiples proveedores (Local, Google, GitHub)
   - Gestión de roles y permisos
   - **Patrones:** Factory (proveedores), Strategy (métodos auth), Decorator (permisos)

2. **Gestión de Entidades [Definir según dominio]**
   - CRUD completo
   - Búsqueda y filtrado
   - Exportación de datos
   - **Patrones:** Repository, Builder (queries), Template Method (CRUD)

3. **Sistema de Notificaciones**
   - Notificaciones en tiempo real
   - Email notifications
   - Push notifications
   - **Patrones:** Observer, Factory (tipos de notificación), Facade (servicios externos)

4. **Procesamiento de Transacciones**
   - Flujo de aprobación
   - Estados de transacción
   - Historial de cambios
   - **Patrones:** State, Command, Chain of Responsibility

5. **Reportes y Analytics**
   - Generación de reportes (PDF, Excel, CSV)
   - Dashboard con métricas
   - Filtros y ordenamiento
   - **Patrones:** Strategy (formatos), Builder (queries complejas), Decorator (permisos)

---

## 📦 Instalación y Configuración

### Prerequisitos

- Node.js 20+
- PostgreSQL 15+ (o cuenta en Supabase)
- Git
- npm / yarn / pnpm

### Configuración Inicial

1. **Clonar el repositorio:**
```bash
git clone https://github.com/Craos6518/Patrones-de-Diseno.git
cd Patrones-de-Diseno/proyecto-final-web
```

2. **Backend:**
```bash
cd backend
npm install
cp .env.example .env
# Configurar variables de entorno
npm run dev
```

3. **Frontend:**
```bash
cd frontend
npm install
cp .env.local.example .env.local
# Configurar variables de entorno
npm run dev
```

4. **Base de Datos:**
```bash
# Ejecutar migraciones
npm run migrate

# Seeders (datos de prueba)
npm run seed
```

---

## 🧪 Testing

### Frontend
```bash
cd frontend
npm test                 # Tests unitarios
npm run test:coverage    # Cobertura
npm run test:e2e        # Tests E2E (Cypress/Playwright)
```

### Backend
```bash
cd backend
npm test                 # Tests unitarios
npm run test:integration # Tests de integración
npm run test:coverage    # Cobertura
```

---

## 📚 Documentación

- [Frontend - Guía de Desarrollo](./frontend/README.md)
- [Backend - API Documentation](./backend/README.md)
- [Patrones Implementados - Detalle](./PATTERNS.md)
- [Arquitectura del Sistema](./ARCHITECTURE.md)

---

## 🎓 Enfoque Académico

Este proyecto sirve como:

1. **Caso de Estudio** - Aplicación real de patrones de diseño
2. **Referencia** - Implementaciones concretas para aprender
3. **Portfolio** - Proyecto demostrable para estudiantes
4. **Base** - Para trabajos finales y proyectos de grado

### Objetivos de Aprendizaje

- ✅ Aplicar patrones GoF en contexto web moderno
- ✅ Diseñar arquitectura escalable y mantenible
- ✅ Integrar frontend y backend con buenas prácticas
- ✅ Implementar autenticación y autorización robusta
- ✅ Desarrollar API RESTful bien diseñada
- ✅ Aplicar principios SOLID en código real
- ✅ Escribir tests automatizados
- ✅ Documentar decisiones de diseño

---

## 🤝 Contribución

### Para Estudiantes de la UTP

1. Fork del repositorio
2. Crear rama con tu patrón/feature: `git checkout -b feature/nombre-patron`
3. Implementar siguiendo las guías del proyecto
4. Documentar decisiones de diseño
5. Agregar tests
6. Pull Request con descripción detallada

---

## 📋 Roadmap

### Fase 1: Fundamentos (En Progreso)
- [x] Definir arquitectura general
- [x] Configurar proyecto base
- [ ] Implementar autenticación básica
- [ ] CRUD de entidades principales

### Fase 2: Patrones Básicos
- [ ] Singleton (Configuración, DB)
- [ ] Factory (Componentes, Servicios)
- [ ] Observer (Notificaciones)
- [ ] Strategy (Validaciones, Ordenamiento)

### Fase 3: Patrones Avanzados
- [ ] Decorator (Permisos, Middlewares)
- [ ] Proxy (Caché)
- [ ] Command (Sistema de acciones)
- [ ] State (Flujos de estado)

### Fase 4: Refinamiento
- [ ] Testing completo
- [ ] Optimización de rendimiento
- [ ] Documentación exhaustiva
- [ ] Deploy

---

## 🔗 Enlaces Útiles

- [Volver al README Principal](../README.md)
- [Documentación](../docs/)
- [Patrones Implementados](../comportamiento/)
- [Supabase Docs](https://supabase.com/docs)
- [Next.js Docs](https://nextjs.org/docs)
- [React Patterns](https://reactpatterns.com/)

---

## 📄 Licencia

Este proyecto es material académico para la Universidad Tecnológica de Pereira (UTP).

---

## 👥 Autores

- **Estudiantes UTP** - Desarrollo del proyecto
- **Docentes** - Guía y supervisión

---

> **Nota para Estudiantes:** Este proyecto integra todo lo aprendido en el curso. No se trata solo de hacer que funcione, sino de hacerlo bien, aplicando los principios y patrones de forma consciente y justificada.
