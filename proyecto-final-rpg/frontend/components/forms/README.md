# 📝 components/forms/

Componentes de formularios complejos.

## 📝 Descripción

Componentes que encapsulan formularios completos con validación y lógica.

## 📋 Componentes

- `LoginForm.tsx` - Formulario de autenticación
- `UserForm.tsx` - Formulario de creación/edición de usuarios
- `SearchForm.tsx` - Formulario de búsqueda
- `ContactForm.tsx` - Formulario de contacto

## 🎨 Patrón: Strategy

Diferentes estrategias de validación:

```typescript
interface ValidationStrategy {
  validate(value: any): { valid: boolean; message?: string };
}

class EmailValidator implements ValidationStrategy {
  validate(value: string) {
    return {
      valid: /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value),
      message: 'Email inválido'
    };
  }
}
```

## 🏗️ Ejemplo

```typescript
export const LoginForm: React.FC = () => {
  const { register, handleSubmit, errors } = useForm({
    mode: 'onBlur'
  });

  const onSubmit = async (data) => {
    await authService.login(data);
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Input {...register('email')} />
      <Input {...register('password')} type="password" />
      <Button type="submit">Login</Button>
    </form>
  );
};
```
