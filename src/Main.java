import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar los datos del usuario
        System.out.println("======================================================================");
        System.out.println("Bienvenido al sistema bancario");
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el tipo de cuenta (Ahorro/Corriente): ");
        String tipoCuenta = sc.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        // Crear la cuenta bancaria
        Sistema_Bancario cuenta = new Sistema_Bancario(nombre, tipoCuenta, saldoInicial);
        System.out.println("======================================================================");

        // Esperar 3 segundos antes de mostrar el menú
        System.out.println("\nCreando su cuenta, por favor espere...");
        try {
            Thread.sleep(3000); // Pausa de 3 segundos (3000 milisegundos)
        } catch (InterruptedException e) {
            System.out.println("Hubo un error en la espera.");
        }

        // Menú de opciones
        int opcion;
        do {
            limpiarPantalla();

            System.out.println("==================================================");
            System.out.println("--- Menú de Opciones ---");
            System.out.println("1. Ver saldo");
            System.out.println("2. Hacer un depósito");
            System.out.println("3. Hacer un retiro");
            System.out.println("4. Ver información de la cuenta");
            System.out.println("5. Ver historial de transacciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            System.out.println("==================================================");
            opcion = sc.nextInt();

            limpiarPantalla();

            switch (opcion) {
                case 1:
                    System.out.println("\nSu saldo actual es: $" + cuenta.getSaldo());
                    break;
                case 2:
                    System.out.print("\nIngrese la cantidad a depositar: $");
                    double depositar = sc.nextDouble();
                    cuenta.depositar(depositar);
                    break;
                case 3:
                    System.out.print("\nIngrese la cantidad a retirar: $");
                    double retiro = sc.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 4:
                    cuenta.mostrarDatosCuenta();
                    break;
                case 5:
                    cuenta.mostrarHistorial();
                    break;
                case 6:
                    System.out.println("\nGracias por usar el sistema bancario.");
                    break;
                default:
                    System.out.println("\nOpción no válida, intente de nuevo.");
                    break;
            }

            // Solo pide presionar Enter si no ha seleccionado la opción de salir
            if (opcion != 6) {
                System.out.println("\nPresione Enter para continuar...");
                sc.nextLine(); // Captura el salto de línea
                sc.nextLine(); // Espera a que el usuario presione Enter
            }
        } while (opcion != 6);
        sc.close();
    }

    // Método para limpiar la pantalla (simulado)
    public static void limpiarPantalla() {
        for (int i = 0; i < 10; i++) {
            System.out.println(); // Imprime 10 líneas en blanco
        }
    }
}
