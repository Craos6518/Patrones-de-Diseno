# 🪝 hooks/

Custom React Hooks.

## 📝 Descripción

Contiene hooks personalizados que reutilizan lógica entre componentes.

## 📋 Hooks Comunes

- `useAuth.ts` - Autenticación
- `useFetch.ts` - Fetch de datos
- `useLocalStorage.ts` - LocalStorage
- `useForm.ts` - Gestión de formularios
- `useNotification.ts` - Notificaciones

## 🏗️ Ejemplo

```typescript
// useAuth.ts
export const useAuth = () => {
  const [user, setUser] = useState<User | null>(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const checkAuth = async () => {
      const user = await authService.getCurrentUser();
      setUser(user);
      setIsLoading(false);
    };
    checkAuth();
  }, []);

  return { user, isLoading };
};

// useFetch.ts
export const useFetch = <T,>(url: string) => {
  const [data, setData] = useState<T | null>(null);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<Error | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(url);
        const data = await response.json();
        setData(data);
      } catch (err) {
        setError(err as Error);
      } finally {
        setIsLoading(false);
      }
    };
    fetchData();
  }, [url]);

  return { data, isLoading, error };
};
```

## 📚 Referencias

- [React Hooks](https://react.dev/reference/react/hooks)
