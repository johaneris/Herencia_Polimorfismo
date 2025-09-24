package models;

public class Carro extends Vehiculo implements Combustible {

    private double capacidadTanque;
    private double nivelDeCombustible;

    public Carro(String marca, String modelo, double capacidadTanque) {
        super(marca, modelo);
        this.capacidadTanque = capacidadTanque;
    }

    @Override
    public String mover() {
        if (nivelDeCombustible <= 0) {
            return toString() + " no puede moverse: sin combustible.";
        }
        // Consumo simple de demostración
        nivelDeCombustible = Math.max(0, nivelDeCombustible - 0.5);
        return toString() + " avanza...";
    }

    @Override
    public void recargar(double litros){
        if(litros <= 0){
            return;
        }

        nivelDeCombustible = Math.min(capacidadTanque, nivelDeCombustible + litros);
    }

    @Override
    public double getNivelCombustible() {
        return nivelDeCombustible;
    }

}
