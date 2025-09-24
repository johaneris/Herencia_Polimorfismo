package models;

public class Camion extends Vehiculo implements Combustible {

    private double capadidadTanque;
    private double nivelCombustible;

    public Camion(String marca, String modelo, double capadidadTanque) {
        super(marca, modelo);
        this.capadidadTanque = capadidadTanque;
    }

    @Override
    public String mover() {
        if (nivelCombustible <= 0) {
            return toString() + " no puede moverse: sin combustible.";
        }
        nivelCombustible = Math.max(0, nivelCombustible - 1.5);
        return toString() + " avanza...";
    }

    @Override
    public void recargar(double litros) {
        if (litros <= 0) return;
        nivelCombustible = Math.min(capadidadTanque, nivelCombustible + litros);
    }

    @Override
    public double getNivelCombustible() {
        return nivelCombustible;
    }
}
