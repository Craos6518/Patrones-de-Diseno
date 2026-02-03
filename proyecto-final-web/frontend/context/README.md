# 🎯 context/

Context API Providers.

## 📝 Descripción

Contiene contextos de React para state management global.

## 📋 Contextos

- `AuthContext.tsx` - Contexto de autenticación
- `NotificationContext.tsx` - Sistema de notificaciones
- `ThemeContext.tsx` - Tema (claro/oscuro)
- `LanguageContext.tsx` - Idioma

## 🎨 Patrón: Observer

El Context API implementa el patrón Observer:

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

  const addNotification = (notification: Omit<Notification, 'id'>) => {
    const id = Math.random().toString(36);
    setNotifications(prev => [...prev, { ...notification, id }]);
  };

  return (
    <NotificationContext.Provider value={{ notifications, addNotification, removeNotification }}>
      {children}
    </NotificationContext.Provider>
  );
};

export const useNotification = () => {
  const context = useContext(NotificationContext);
  if (!context) throw new Error('useNotification must be used within NotificationProvider');
  return context;
};
```

## 📚 Referencias

- [Context API](https://react.dev/learn/passing-data-deeply-with-context)
- [Patrón Observer](../../../comportamiento/observer/)
