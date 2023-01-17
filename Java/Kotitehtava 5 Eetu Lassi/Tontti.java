
public class Tontti {
    // Muuttujat
    private String TontinNimi, TonttiOsoite;
    private Double TontinPintaala;
    private Rakennus rakennus;

    public Tontti(String tontinNimi, String tonttiOsoite, Double tontinPintaala, Rakennus rakennus) {
        setTontinNimi(tontinNimi);
        setTonttiOsoite(tonttiOsoite);
        setTontinPintaala(tontinPintaala);
        this.setRakennus(rakennus);
        this.rakennus = new Rakennus();
    }
    public Tontti(){
        this.rakennus = new Rakennus();
    }

    public Rakennus getRakennus() {
        return rakennus;
    }

    public void setRakennus(Rakennus rakennus) {
        this.rakennus = rakennus;
    }

    public Double getTontinPintaala() {
        return TontinPintaala;
    }

    public void setTontinPintaala(Double tontinPintaala) {
        if (tontinPintaala < 0){
            System.out.println("Käytä positiivisia arvoja");
            System.exit(0);
        }
        this.TontinPintaala = tontinPintaala;
    }

    public String getTonttiOsoite() {
        return TonttiOsoite;
    }

    public void setTonttiOsoite(String tonttiOsoite) {
        this.TonttiOsoite = tonttiOsoite;
    }

    public String getTontinNimi() {
        return TontinNimi;
    }

    public void setTontinNimi(String tontinNimi) {
        this.TontinNimi = tontinNimi;
    }

    public void TulostaTonttitiedot(){
        System.out.println(
        "///////" + "\n" +
        "Tontin Nimi: " + TontinNimi + "\n" +
        "Tontin Osoite: " + TonttiOsoite + "\n" +
        "Tontin Pinta-ala: " + TontinPintaala + "\n" +
        "///////");
    }
    
}

