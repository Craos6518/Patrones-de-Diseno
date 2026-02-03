# 🔄 states/

Implementación del State pattern.

## 📝 Descripción

Permite que un objeto cambie su comportamiento cuando su estado interno cambia.

## 🎯 Caso de Uso

Máquina de estados para Pedidos (Order):

```
PENDING → PROCESSING → SHIPPED → DELIVERED
   ↓
CANCELLED (desde cualquier estado)

class PendingState implements OrderState { }
class ProcessingState implements OrderState { }
class ShippedState implements OrderState { }
class DeliveredState implements OrderState { }
class CancelledState implements OrderState { }

const order = new Order();
order.nextState(); // PENDING → PROCESSING
```

## 📚 Referencias

- [Patrón State](../../../../comportamiento/state/)
