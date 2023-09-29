import java.util.Scanner;

public class MaquinaExpendedore {
    Scanner sc = new Scanner(System.in);
    boolean apagada;
    double recaudado;


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

    public void pedirGolosina() {
        System.out.println("Introduce la posición de la golosina que quieres (fila, columna): ");
        String pos = sc.nextLine();
        try {
            int[] posicion= this.seleccionUsuario(pos);
            if(posicion!=null){
                System.out.println("Introduce el dinero: ");
                double dinero = sc.nextDouble();
                this.darGolosinas(posicion, dinero);
            }
            else{
                System.out.println("la posicion es invalida");
            }
        } catch (Exception e) {
            System.out.println("posición invalida");
        }
    }
    public int[] seleccionUsuario(String pos){
        int[] posicion = new int[2];
        if (pos.length() == 2) {
            posicion[0] = Integer.parseInt(pos.substring(0, 1));
            posicion[1] = Integer.parseInt(pos.substring(1));
            return (posicion[0]<=3&&posicion[0]>=0)&& (posicion[1]<=3&&posicion[1]>=0)? posicion:null;
        }  
        System.out.println("La posicion es invalida");
        return null;
    }
    public void darGolosinas(int[] posicion, double dinero){
        if (cantidad[posicion[0]][posicion[1]] > 0 && dinero >= precio[posicion[0]][posicion[1]]) {
            double cambio =  (int) (dinero - precio[posicion[0]][posicion[1]]);
            System.out.println("Aquí tiene su golosina: " + nombresGolosinas[posicion[0]][posicion[1]]);
            cantidad[posicion[0]][posicion[1]]--;
            recaudado+=precio[posicion[0]][posicion[1]];
            System.out.println("Precio: $" + precio[posicion[0]][posicion[1]] + " Cambio: $" + cambio);
                
        } else {
            System.out.println("No hay golosinas o no hay dinero suficiente");
                
        }

    }
    public void apagarMaquina() {
        apagada = true;
        System.out.println("Máquina apagada");
        double totalVentas = 0;
        int totalGolosinas = 0;
        
        for (int i = 0; i < cantidad.length; i++) {
            for (int j = 0; j < cantidad[i].length; j++) {
                totalGolosinas += cantidad[i][j];
            }
        }
        System.out.println("Total ventas: $" + recaudado);
        System.out.println("Total golosinas restantes: " + totalGolosinas);
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