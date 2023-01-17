
public class Pankkitili {
    // Muuttujat
    private String tNumero;
    private String tOmistaja;
    private double tSaldo;
    private double tOtto;
    // Methodit
    public void Tilinumero(String tNumero){
        this.tNumero = tNumero;
    }
    public void Tiliomistaja(String tOmistaja){
        this.tOmistaja = tOmistaja;
    }
    public void Tilisaldo(Double tSaldo){
        if (tSaldo >= 0){
            this.tSaldo = tSaldo;
        }
        else{
            System.out.println("Tilille ei voi laittaa alle 0");
            System.exit(0);
        }
    }
    public void Tiliotto(Double tOtto){
        if (tOtto >= 0){
            this.tOtto = tOtto;
        }
        else {
            System.out.println("Tilille ei voi ottaa alle 0");
            System.exit(0);
        }
    }
    public String Luetilinumero(){
        return tNumero;
    }
    public String Luetiliomistaja(){
        return tOmistaja;
    }
    public Double Luetilisaldo(){
        return tSaldo;
    }
    public void Tililtaotto(){
        if (tSaldo >= tOtto){
            this.tSaldo = tSaldo - tOtto;
        }
        else{
            System.out.println("Tililta ei voi ottaa niin paljon");
            System.exit(0);
        }
    }
    public String Luetiedot(){

        return String.format("*****" + "%n" + "Tilinumero = " + tNumero + "%n" + "Tilin Omistaja = " + tOmistaja + "%n" + "Tilin Saldo = " +
        tSaldo + "%n" + "*****");
    }

}
