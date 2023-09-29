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
        System.out.println("Introduce la posición de la golosina que quieres (fila, columna): ");
        String pos = sc.nextLine();
        try {
            if (pos.length() == 2) {
                int fila = Integer.parseInt(pos.substring(0, 1));
                int columna = Integer.parseInt(pos.substring(1));
                System.out.println("Introduce el dinero: ");
                double dinero = sc.nextDouble();
                if (cantidad[fila][columna] > 0 && dinero >= precio[fila][columna]) {
                    double cambio = dinero > precio[fila][columna] ? (int) (dinero - precio[fila][columna]) : 0;
                    // Disminuir la cantidad de golosinas
                    cantidad[fila][columna]--;
                    System.out.println("Aquí tiene su golosina: " + nombresGolosinas[fila][columna]);
                    // Mostrar el cambio y la cantidad de golosinas
                    System.out.println("Precio: $" + precio[fila][columna] + " Cambio: $" + cambio + " Cantidad: "
                            + cantidad[fila][columna]);
                } else {
                    System.out.println("No hay golosinas o no hay dinero suficiente");
                }
            } else {
                System.out.println("Posición incorrecta");
            }
        } catch (Exception e) {
            System.out.println("Posición incorrecta");
        }
    }

    public void apagarMaquina() {
        apagada = true;
    }

    public void mostrarGolosinas() {
        for (int i = 0; i < nombresGolosinas.length; i++) {
            for (int j = 0; j < nombresGolosinas[i].length; j++) {
                System.out.println("Cantidad de " + nombresGolosinas[i][j] + ": " + cantidad[i][j]);
            }
        }
    }

    public void rellenarGolosinas() {

        System.out.println("Introduce la contraseña de técnico: ");
        String password = sc.nextLine();
            if (password.equals("MaquinaExpendedora2017")) {
            System.out.println("Introduce la posición de la golosina que quieres rellenar (fila, columna): ");
            String pos = sc.nextLine();
            try {
                if (pos.length() == 2) {
                    int fila = Integer.parseInt(pos.substring(0, 1));
                    int columna = Integer.parseInt(pos.substring(1));
                    System.out.println("Introduce la cantidad de golosinas que quieres rellenar: ");
                    int cantidadRellenar = sc.nextInt();
                    cantidad[fila][columna] += cantidadRellenar;
                    System.out.println("Cantidad de golosinas rellenadas: " + cantidadRellenar);
                } else {
                    System.out.println("Posición incorrecta");
                }
            } catch (Exception e) {
                System.out.println("Posición incorrecta");
            }
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }
}