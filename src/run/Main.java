package run;
import models.*;


public class Main {

    public static void main(String[] args) {
        Vehiculo[] vehiculos = {
                new Carro("Toyota", "Corolla", 50),
                new Moto("Yamaha", "MT-07"),
                new Camion("Toyota", "FH", 300)
        };

        // Estado inicial
        System.out.println("\n");
        System.out.println("------ Estado inicial ------");
        for (Vehiculo v : vehiculos) {
            System.out.println(describir(v));
        }

        // Recarga estándar (solo a recargables, es decir, carro y camión)
        recargarATodos(vehiculos, 40);

        // Simulación de movimiento
        System.out.println("\n------ Moverse ------");
        for (Vehiculo v : vehiculos) {
            System.out.println(v.mover());
        }

        // Reporte final
        System.out.println("\n------ Reporte final de combustible ------");
        for (Vehiculo v : vehiculos) {
            if (v instanceof Combustible) {
                Combustible c = (Combustible) v;
                System.out.printf("%s -> %.2f L%n",
                        v.getClass().getSimpleName(), c.getNivelCombustible());
            } else {
                System.out.printf("%s -> Sin combustible%n", v.getClass().getSimpleName());
            }
        }

        double total = calcularTotalCombustible(vehiculos);
        System.out.printf("%nTotal combustible disponible: %.2f L%n", total);
    }

    // Helpers

    static String describir(Vehiculo v) {
        if (v instanceof Combustible) {
            Combustible c = (Combustible) v;
            return v.toString() + "combustible: " + c.getNivelCombustible() + " L";
        } else {
            return v.toString() + "sin sistema de combustible";
        }
    }

    static void recargarATodos(Vehiculo[] vs, double litros) {
        System.out.println("\n------ Recarga (" + litros + " L) ------");
        for (Vehiculo v : vs) {
            if (v instanceof Combustible) {
                Combustible c = (Combustible) v;
                double antes = c.getNivelCombustible();
                c.recargar(litros);
                double despues = c.getNivelCombustible();
                System.out.printf("%s: %.2f L -> %.2f L%n",
                        v.getClass().getSimpleName(), antes, despues);
            }
        }
    }

    static double calcularTotalCombustible(Vehiculo[] vs) {
        double total = 0.0;
        for (Vehiculo v : vs) {
            if (v instanceof Combustible) {
                total += ((Combustible) v).getNivelCombustible();
            }
        }
        return total;
    }

}
