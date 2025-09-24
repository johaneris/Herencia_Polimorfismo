# Sistema de Vehículos — Herencia, Interfaces y Polimorfismo (Java)

Proyecto didáctico en Java que demuestra **herencia**, **clases abstractas**, **interfaces** y **polimorfismo** usando una jerarquía simple de vehículos.  
El `Main` crea objetos (`Carro`, `Moto`, `Camion`), **recarga combustible** solo a los que implementan `Combustible` y **simula el movimiento** de todos.

---

## Características
- `Vehiculo` (abstracta) con atributos comunes (`marca`, `modelo`) y el método abstracto `mover()`.
- Subclases: `Carro`, `Camion`, `Moto`.
- Interfaz `Combustible` implementada por `Carro` y `Camion` (p. ej., `recargar`, `getNivelCombustible`).
- Arreglo polimórfico `Vehiculo[]` para tratar todas las subclases por igual y llamar `mover()`.
- En `Main`, helpers para:
  - `recargarATodos(Vehiculo[], double)` — recarga solo a quienes implementan `Combustible`.
  - `describir(Vehiculo)` — imprime estado legible de cada vehículo.
  - `calcularTotalCombustible(Vehiculo[])` — suma el combustible disponible.
