import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cuenta.Escritura cuentaEscritura = new Cuenta.Escritura();
        Cuenta.Lectura cuentaLectura = new Cuenta.Lectura();

        String archivo = "Cuenta.txt";

        System.out.println("Menu Cuenta: ");

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Insertar Cuenta");
            System.out.println("2. Leer Cuenta");
            System.out.println("3. Salir");
            String opc = br.readLine();

            switch (opc) {
                case "1":
                    System.out.println("IBAN:");
                    Long IBAN = Long.parseLong(br.readLine());

                    System.out.println("CUI: ");
                    Long CUI = Long.parseLong(br.readLine());

                    System.out.println("Tipo Cuenta (AHORRO / MONETARIA): ");
                    TipoCuenta tipoCuenta = TipoCuenta.valueOf(br.readLine().toUpperCase());

                    System.out.println("Tipo Moneda (QUETZALES / DOLARES): ");
                    Moneda tipoMoneda = Moneda.valueOf(br.readLine().toUpperCase());

                    System.out.println("Saldo: ");
                    double saldo = Double.parseDouble(br.readLine());

                    Cuenta nuevaCuenta = new Cuenta(IBAN, CUI, tipoCuenta, tipoMoneda, saldo);
                    cuentaEscritura.insertarCuenta(archivo, nuevaCuenta);
                    break;

                case "2":
                    cuentaLectura.leerCuenta(archivo);
                    break;

                case "3":
                    System.out.println("Saliendo del programa...");
                    return;

                default:
                    System.out.println("Opcion Invalida!");
            }
        }
    }
}
