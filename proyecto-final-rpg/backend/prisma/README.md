# 🗄️ prisma/

Configuración de ORM Prisma.

## 📝 Descripción

Contiene el schema de base de datos y migraciones:

- `schema.prisma` - Definición del modelo de datos
- `migrations/` - Historial de migraciones

## 🎯 Propósito

- Definir estructura de la BD
- Generar tipos TypeScript automáticamente
- Mantener historial de cambios

## 🏗️ Archivo schema.prisma

```prisma
generator client {
  provider = "prisma-client-js"
}

datasource db {
  provider = "postgresql"
  url      = env("DATABASE_URL")
}

model User {
  id    Int     @id @default(autoincrement())
  email String  @unique
  name  String
  password String
  active Boolean @default(true)
  
  createdAt DateTime @default(now())
  updatedAt DateTime @updatedAt
}
```

## 🚀 Comandos

```bash
prisma migrate dev --name init   # Nueva migración
prisma migrate deploy            # Aplicar migraciones
prisma db seed                   # Seeders
prisma studio                    # GUI
```

## 📚 Referencias

- [Prisma Docs](https://www.prisma.io/docs)
