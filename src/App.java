import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MaquinaExpendedore maquina = new MaquinaExpendedore();
        
        int opcion;
        do {
            System.out.println("1. Pedir golosina");
            System.out.println("2. Mostrar golosinas");
            System.out.println("3. Rellenar golosinas");
            System.out.println("4. Apagar máquina");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    maquina.pedirGolosina();
                    break;
                case 2:
                    // mostrarGolosinas();
                    break;
                case 3:
                    // rellenarGolosinas();
                    break;
                case 4:
                    maquina.apagarMaquina();
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (!maquina.apagada);
    }
}
