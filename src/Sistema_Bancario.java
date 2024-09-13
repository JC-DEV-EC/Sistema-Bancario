import java.util.ArrayList;

public class Sistema_Bancario {

    private String nombreTitular;
    private String tipoDeCuenta;
    private double saldo;
    private ArrayList<String> historialTransacciones;

    public Sistema_Bancario(String nombreTitular, String tipoDeCuenta, double saldoInicial) {
        this.nombreTitular = nombreTitular;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = saldoInicial;
        this.historialTransacciones = new ArrayList<>();
        historialTransacciones.add("Cuenta creada con saldo inicial de: $" + saldoInicial);
    }

    // Métodos para operar con el saldo
    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            historialTransacciones.add("Depósito de: $" + cantidad + ". Saldo actual: $" + saldo);
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Ingrese una cantidad válida.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            historialTransacciones.add("Retiro de: $" + cantidad + ". Saldo actual: $" + saldo);
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida. Comuníquese con el banco.");
        }
    }

    // Método para mostrar la información de la cuenta
    public void mostrarDatosCuenta() {
        System.out.println("\n==================================================");
        System.out.println("Nombre del titular: " + nombreTitular);
        System.out.println("Tipo de cuenta: " + tipoDeCuenta);
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("==================================================");
    }

    // Método para mostrar el historial de transacciones
    public void mostrarHistorial() {
        System.out.println("--- Historial de Transacciones ---");
        for (String transaccion : historialTransacciones) {
            System.out.println(transaccion);
        }
    }
}
