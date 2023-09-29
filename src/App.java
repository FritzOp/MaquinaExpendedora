import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MaquinaExpendedore maquina = new MaquinaExpendedore();
        while(!maquina.apagada) {
            System.out.println("Máquina expendedora de golosinas");
            System.out.println("1. Pedir golosina");
            System.out.println("2. Mostrar golosinas");
            System.out.println("3. Rellenar golosinas");
            System.out.println("4. Apagar máquina");
            try{
            int opcion = sc.nextInt();
                switch (opcion) {
                case 1:
                    maquina.pedirGolosina();
                    break;
                case 2:
                    maquina.mostrarGolosinas();
                    break;
                case 3:
                    maquina.rellenarGolosinas();
                    break;
                case 4:
                    maquina.apagarMaquina();
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
            }catch(InputMismatchException e){
                System.out.println("Opción incorrecta");
                sc.nextLine();
            }
        }
    }
}
