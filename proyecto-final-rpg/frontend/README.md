# 🎨 Frontend - React + Next.js

Aplicación web moderna que implementa patrones de diseño en el lado del cliente.

---

## 🏗️ Estructura del Proyecto

```
frontend/
├── public/              # Archivos estáticos
├── src/
│   ├── app/            # App Router de Next.js 14+
│   │   ├── layout.tsx  # Layout principal
│   │   ├── page.tsx    # Página home
│   │   └── api/        # API Routes
│   ├── components/     # Componentes React
│   │   ├── ui/         # Componentes de UI base
│   │   ├── forms/      # Formularios
│   │   └── layouts/    # Layouts
│   ├── lib/            # Utilidades y configuración
│   │   ├── patterns/   # Implementación de patrones
│   │   ├── api/        # Cliente API
│   │   └── utils/      # Funciones útiles
│   ├── hooks/          # Custom React hooks
│   ├── context/        # Context API providers
│   ├── types/          # TypeScript types
│   └── styles/         # Estilos globales
├── package.json
├── tsconfig.json
├── tailwind.config.js
└── next.config.js
```

---

## 🎯 Patrones de Diseño Implementados

### 1. Singleton - Gestión de Configuración

**Archivo:** `lib/patterns/ConfigManager.ts`

```typescript
class ConfigManager {
  private static instance: ConfigManager;
  private config: Record<string, any>;

  private constructor() {
    this.config = {
      apiUrl: process.env.NEXT_PUBLIC_API_URL,
      appName: process.env.NEXT_PUBLIC_APP_NAME,
      // ... más configuraciones
    };
  }

  public static getInstance(): ConfigManager {
    if (!ConfigManager.instance) {
      ConfigManager.instance = new ConfigManager();
    }
    return ConfigManager.instance;
  }

  public get(key: string): any {
    return this.config[key];
  }
}

export default ConfigManager.getInstance();
```

**Uso:**
```typescript
import config from '@/lib/patterns/ConfigManager';

const apiUrl = config.get('apiUrl');
```

---

### 2. Factory - Creación de Componentes Dinámicos

**Archivo:** `lib/patterns/ComponentFactory.tsx`

```typescript
interface ComponentFactoryProps {
  type: 'button' | 'input' | 'card' | 'modal';
  props: any;
}

export const ComponentFactory: React.FC<ComponentFactoryProps> = ({ type, props }) => {
  switch (type) {
    case 'button':
      return <Button {...props} />;
    case 'input':
      return <Input {...props} />;
    case 'card':
      return <Card {...props} />;
    case 'modal':
      return <Modal {...props} />;
    default:
      throw new Error(`Unknown component type: ${type}`);
  }
};
```

---

### 3. Observer - Sistema de Notificaciones

**Archivo:** `context/NotificationContext.tsx`

```typescript
interface Notification {
  id: string;
  type: 'success' | 'error' | 'warning' | 'info';
  message: string;
}

const NotificationContext = createContext<{
  notifications: Notification[];
  addNotification: (notification: Omit<Notification, 'id'>) => void;
  removeNotification: (id: string) => void;
} | null>(null);

export const NotificationProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
  const [notifications, setNotifications] = useState<Notification[]>([]);

  const addNotification = useCallback((notification: Omit<Notification, 'id'>) => {
    const id = Math.random().toString(36);
    setNotifications(prev => [...prev, { ...notification, id }]);
    
    setTimeout(() => removeNotification(id), 5000);
  }, []);

  const removeNotification = useCallback((id: string) => {
    setNotifications(prev => prev.filter(n => n.id !== id));
  }, []);

  return (
    <NotificationContext.Provider value={{ notifications, addNotification, removeNotification }}>
      {children}
      <NotificationContainer notifications={notifications} />
    </NotificationContext.Provider>
  );
};

export const useNotification = () => {
  const context = useContext(NotificationContext);
  if (!context) throw new Error('useNotification must be used within NotificationProvider');
  return context;
};
```

---

### 4. Strategy - Validación de Formularios

**Archivo:** `lib/patterns/validators/ValidationStrategy.ts`

```typescript
interface ValidationStrategy {
  validate(value: any): { valid: boolean; message?: string };
}

class EmailValidator implements ValidationStrategy {
  validate(value: string) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return {
      valid: regex.test(value),
      message: regex.test(value) ? undefined : 'Email inválido'
    };
  }
}

class RequiredValidator implements ValidationStrategy {
  validate(value: any) {
    return {
      valid: value !== null && value !== undefined && value !== '',
      message: value ? undefined : 'Campo requerido'
    };
  }
}

class MinLengthValidator implements ValidationStrategy {
  constructor(private minLength: number) {}
  
  validate(value: string) {
    return {
      valid: value.length >= this.minLength,
      message: value.length >= this.minLength 
        ? undefined 
        : `Mínimo ${this.minLength} caracteres`
    };
  }
}

// Uso
const validators = {
  email: new EmailValidator(),
  required: new RequiredValidator(),
  minLength: (length: number) => new MinLengthValidator(length)
};
```

---

### 5. Decorator - Higher Order Components para Auth

**Archivo:** `lib/patterns/hoc/withAuth.tsx`

```typescript
export function withAuth<P extends object>(
  Component: React.ComponentType<P>,
  requiredRole?: string
) {
  return function AuthenticatedComponent(props: P) {
    const { user, isLoading } = useAuth();
    const router = useRouter();

    useEffect(() => {
      if (!isLoading && !user) {
        router.push('/login');
      }
      
      if (requiredRole && user && !user.roles.includes(requiredRole)) {
        router.push('/unauthorized');
      }
    }, [user, isLoading, router]);

    if (isLoading) return <LoadingSpinner />;
    if (!user) return null;
    if (requiredRole && !user.roles.includes(requiredRole)) return null;

    return <Component {...props} />;
  };
}

// Uso
export default withAuth(DashboardPage, 'admin');
```

---

### 6. Facade - Cliente API Simplificado

**Archivo:** `lib/api/ApiClient.ts`

```typescript
class ApiClient {
  private baseUrl: string;
  private token: string | null = null;

  constructor() {
    this.baseUrl = config.get('apiUrl');
  }

  setToken(token: string) {
    this.token = token;
  }

  private async request<T>(
    endpoint: string, 
    options: RequestInit = {}
  ): Promise<T> {
    const headers = {
      'Content-Type': 'application/json',
      ...(this.token && { Authorization: `Bearer ${this.token}` }),
      ...options.headers,
    };

    const response = await fetch(`${this.baseUrl}${endpoint}`, {
      ...options,
      headers,
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    return response.json();
  }

  // Métodos simplificados
  async get<T>(endpoint: string): Promise<T> {
    return this.request<T>(endpoint);
  }

  async post<T>(endpoint: string, data: any): Promise<T> {
    return this.request<T>(endpoint, {
      method: 'POST',
      body: JSON.stringify(data),
    });
  }

  async put<T>(endpoint: string, data: any): Promise<T> {
    return this.request<T>(endpoint, {
      method: 'PUT',
      body: JSON.stringify(data),
    });
  }

  async delete<T>(endpoint: string): Promise<T> {
    return this.request<T>(endpoint, { method: 'DELETE' });
  }
}

export default new ApiClient();
```

---

### 7. Proxy - Lazy Loading de Componentes

**Archivo:** `components/LazyLoader.tsx`

```typescript
import dynamic from 'next/dynamic';

export const LazyComponent = (
  importFunc: () => Promise<any>,
  options?: { loading?: React.ComponentType }
) => {
  return dynamic(importFunc, {
    loading: options?.loading || (() => <LoadingSpinner />),
    ssr: false
  });
};

// Uso
const HeavyChart = LazyComponent(
  () => import('@/components/charts/HeavyChart'),
  { loading: () => <ChartSkeleton /> }
);
```

---

## 🎨 Componentes Principales

### Layout Principal
```typescript
// app/layout.tsx
export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="es">
      <body>
        <NotificationProvider>
          <AuthProvider>
            <ThemeProvider>
              {children}
            </ThemeProvider>
          </AuthProvider>
        </NotificationProvider>
      </body>
    </html>
  );
}
```

---

## 🛠️ Tecnologías

- **Next.js 14+** - Framework React con App Router
- **TypeScript** - Type safety
- **Tailwind CSS** - Utility-first CSS
- **React Hook Form** - Gestión de formularios
- **Zod** - Validación de esquemas
- **Axios** - Cliente HTTP
- **SWR** - Data fetching con caché
- **Framer Motion** - Animaciones

---

## 📦 Scripts Disponibles

```bash
npm run dev          # Desarrollo
npm run build        # Build producción
npm run start        # Servidor producción
npm run lint         # Linter
npm run test         # Tests
npm run type-check   # Verificar tipos TS
```

---

## 🧪 Testing

```bash
# Tests unitarios
npm test

# Tests con cobertura
npm run test:coverage

# Tests E2E
npm run test:e2e
```

---

## 🔗 Enlaces

- [Volver al Proyecto](../README.md)
- [Backend](../backend/README.md)
- [Next.js Docs](https://nextjs.org/docs)
