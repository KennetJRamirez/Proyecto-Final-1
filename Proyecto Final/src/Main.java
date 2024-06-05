import java.io.*;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Persona.Escritura personaEscritura= new Persona.Escritura();
        Persona.Lectura personaLectura = new Persona.Lectura();

        String archivo="Persona.txt";

        System.out.println("Menu Persona: ");


        while (true){
            System.out.println("Menu: ");
            System.out.println("1. Insertar Persona");
            System.out.println("2. Leer Persona");
            System.out.println("3.  Salir");
            String opc = br.readLine();


            switch (opc){
                case "1" :
                    System.out.println("CUI:");
                    Long CUI = Long.parseLong(br.readLine());

                    System.out.println("Nombres: ");
                    String nombres= br.readLine();

                    System.out.println("Apellidos: ");
                    String apellidos= br.readLine();

                    System.out.println("Telefono Celular: ");
                    String telefonoCelular = br.readLine();

                    Persona nuevaPersona = new Persona(CUI,nombres,apellidos,telefonoCelular);
                    personaEscritura.insertarPersona(archivo, nuevaPersona);
                    break;
                case "2":
                    personaLectura.leerPersona(archivo);
                    break;

                case "3":
                    System.out.println("Finalizando Sistema...");
                    break;

                default:
                    System.out.println("Opcion Invalida!");
            }

        }

        }
    }


