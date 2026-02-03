# 🧪 tests/

Tests automatizados del backend.

## 📝 Descripción

Contiene tests unitarios e integración:

- `unit/` - Tests unitarios
- `integration/` - Tests de integración
- `fixtures/` - Datos de prueba
- `setup.ts` - Configuración de tests

## 🎯 Propósito

- Validar funcionalidad
- Detectar regresiones
- Facilitar refactoring

## 🏗️ Estructura

```
tests/
├── unit/
│   ├── services/
│   ├── repositories/
│   └── utils/
├── integration/
│   ├── controllers/
│   └── api/
├── fixtures/
└── setup.ts
```

## 🚀 Scripts

```bash
npm test                # Tests
npm run test:coverage   # Cobertura
npm run test:watch     # Watch mode
```

## 📚 Referencias

- [Jest Documentation](https://jestjs.io)
