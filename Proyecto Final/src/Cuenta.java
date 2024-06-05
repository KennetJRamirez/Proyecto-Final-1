import java.io.*;
import java.util.StringTokenizer;

public class Cuenta {
    //Atributos
    private static long idNext=1000000;
    private long idCuenta;
    private long IBAN;
    private long CUI;
    private TipoCuenta tipoCuenta;
    private Moneda tipoMoneda;
    private double saldo;


    public Cuenta() {
    }

    public Cuenta(long IBAN, long CUI, TipoCuenta tipoCuenta, Moneda tipoMoneda, double saldo) {
        this.idCuenta = idNext++;
        this.IBAN = IBAN;
        this.CUI = CUI;
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.saldo = saldo;
    }

    public long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Moneda getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(Moneda tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public long getCUI() {
        return CUI;
    }

    public void setCUI(long CUI) {
        this.CUI = CUI;
    }

    public long getIBAN() {
        return IBAN;
    }

    public void setIBAN(long IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public String toString() {
        return idCuenta+ "," + IBAN + "," + CUI + ","+  tipoCuenta+","+tipoMoneda+","+saldo+",";
    }

    public static class Escritura{

        public void insertarCuenta(String nombreArchivo,Cuenta nuevaCuenta){
            try {
                FileWriter fw= new FileWriter(nombreArchivo,true);

                BufferedWriter bw = new BufferedWriter(fw);


                bw.write(nuevaCuenta.toString());
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
        public void leerCuenta(String nombreArchivo){
            String aux="";
            FileReader fr;
            try {
                fr= new FileReader(nombreArchivo);
                BufferedReader br= new BufferedReader(fr);

                System.out.println("Mostrando Cuentas...");

                while ((aux=br.readLine())!=null){
                    StringTokenizer st= new StringTokenizer(aux,",");
                    Cuenta nuevaCuenta= new Cuenta();


                    nuevaCuenta.setIdCuenta(Long.parseLong(st.nextToken()));
                    nuevaCuenta.setIBAN(Long.parseLong(st.nextToken()));
                    nuevaCuenta.setCUI(Long.parseLong(st.nextToken()));
                    nuevaCuenta.setTipoCuenta(TipoCuenta.valueOf(st.nextToken()));
                    nuevaCuenta.setTipoMoneda(Moneda.valueOf(st.nextToken()));
                    nuevaCuenta.setSaldo(Double.parseDouble(st.nextToken()));


                    System.out.println("Cuentas : "+nuevaCuenta.toString());
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
        }}
