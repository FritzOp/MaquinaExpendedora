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


    public boolean pedirGolosina() {
        String pos;
        System.out.println("Introduce la posición de la golosina que quieres (fila, columna): ");
        pos = sc.nextLine();
        int fila, columna;
        try {

            if (pos.length() == 2) {
                fila = Integer.parseInt(pos.substring(0, 1));
                columna = Integer.parseInt(pos.substring(1));
            }else{
                System.out.println("Posición incorrecta");
                return false;
            }

            System.out.println("Introduce el dinero: ");
            double dinero = sc.nextDouble();
                if (cantidad[fila][columna] > 0 && dinero >= precio[fila][columna]) {
                    double cambio =  (int) (dinero - precio[fila][columna]);
                    System.out.println("Aquí tiene su golosina: " + nombresGolosinas[fila][columna]);
                    cantidad[fila][columna]--;
                    System.out.println("Precio: $" + precio[fila][columna] + " Cambio: $" + cambio);
                    return true;
                } else {
                    System.out.println("No hay golosinas o no hay dinero suficiente");
                    return false;
                }
        } catch (Exception e) {
            System.out.println("posición incorrecta");
            return false;
        }

    }
}