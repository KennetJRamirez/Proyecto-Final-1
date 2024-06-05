import java.io.*;
import java.util.StringTokenizer;

public class Persona {
    // Atributos
    private Long CUI;
    private String nombres;
    private String apellidos;
    private String telefonoCelular;

    public Persona() {
    }

    public Persona(Long CUI, String nombres, String apellidos, String telefonoCelular) {
        this.CUI = CUI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonoCelular = telefonoCelular;
    }

    public Long getCUI() {
        return CUI;
    }

    public void setCUI(Long CUI) {
        this.CUI = CUI;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return CUI + "," + nombres + "," + apellidos + "," + telefonoCelular;
    }

    public static class Escritura{

        public void insertarPersona(String nombreArchivo,Persona nuevaPersona){
            try {
                FileWriter fw= new FileWriter(nombreArchivo,true);

                BufferedWriter bw = new BufferedWriter(fw);


                bw.write(nuevaPersona.toString());
                bw.newLine();
                bw.flush();
                bw.close();
            }catch (Exception e){
                System.out.println("Error en fichero!");
                e.printStackTrace();
            }
        }
    }

    public static class Lectura{
        public void leerPersona(String nombreArchivo){
            String aux="";
            FileReader fr;
            try {
                fr= new FileReader(nombreArchivo);
                BufferedReader br= new BufferedReader(fr);

                System.out.println("Mostrando Personas...");

                while ((aux=br.readLine())!=null){
                    StringTokenizer st= new StringTokenizer(aux,",");
                    Persona nuevaPersona= new Persona();

                    nuevaPersona.setCUI((long) Long.parseLong(st.nextToken()));
                    nuevaPersona.setNombres(st.nextToken());
                    nuevaPersona.setApellidos(st.nextToken());
                    nuevaPersona.setTelefonoCelular(st.nextToken());

                    System.out.println("Informacion Ingresada: "+nuevaPersona.toString());
                }
                br.close();
            }catch (FileNotFoundException e){
                System.out.println("Error de fichero! ");
                e.printStackTrace();

            }catch (IOException e){
                System.out.println("Error de contenido!");
                e.printStackTrace();
            }
        }
    }
}
