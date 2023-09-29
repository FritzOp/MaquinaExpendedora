import java.util.Scanner;

public class MaquinaExpendedore {
    Scanner sc = new Scanner(System.in);
    boolean apagada;

    String[][] nombresGolosinas = {
            { "KitKat", "Chicles de fresa", "Lacasitos", "Palotes" },
            { "Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix" },
            { "Kinder Buena", "M&M'S", "Papa Delta", "Chicles de menta" },
            { "Lacasitos", "Crunch", "Milkybar", "KitKat" }
    };

    double[][] precio = {
            { 1.1, 0.8, 1.5, 0.9 },
            { 1.8, 1, 1.2, 1 },
            { 1.8, 1.3, 1.2, 0.8 },
            { 1.5, 1.1, 1.1, 1.1 }
    };

    int[][] cantidad = {
            { 5, 5, 5, 5 },
            { 5, 5, 5, 5 },
            { 5, 5, 5, 5 },
            { 5, 5, 5, 5 }
    };

    public MaquinaExpendedore() {
        apagada = false;
    }

    public void pedirGolosina() {
        String pos;
        System.out.println("Introduce la posición de la golosina que quieres (fila, columna): ");
        pos = sc.nextLine();
        try {
            if (pos.length() == 2) {
                int fila = Integer.parseInt(pos.substring(0, 1));
                int columna = Integer.parseInt(pos.substring(1));
                System.out.println("Introduce el dinero: ");
                double dinero = sc.nextDouble();
                if (cantidad[fila][columna] > 0 && dinero >= precio[fila][columna]) {
                    double cambio = dinero > precio[fila][columna] ? (int) (dinero - precio[fila][columna]) : 0;
                    System.out.println("Aquí tiene su golosina: " + nombresGolosinas[fila][columna]);
                    System.out.println("Precio: $" + precio[fila][columna] + " Cambio: $" + cambio);
                } else {
                    System.out.println("No hay golosinas o no hay dinero suficiente");
                }
            } else {
                System.out.println("Posición incorrecta");
            }
        } catch (Exception e) {
            System.out.println("posición incorrecta");
        }

    }
}