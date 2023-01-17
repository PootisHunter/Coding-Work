public abstract class Subscription {
    
    private String lehden_nimi;
    private String tilaajan_nimi;
    private String toimitusosoite;
    
    
    public Subscription(String lehden_nimi, String tilaajan_nimi, String toimitusosoite) {
        this.lehden_nimi = lehden_nimi;
        this.tilaajan_nimi = tilaajan_nimi;
        this.toimitusosoite = toimitusosoite;
        
    }

    public Subscription(){}

    public String getLehden_nimi() {
        return lehden_nimi;
    }

    public void setLehden_nimi(String lehden_nimi) {
        this.lehden_nimi = lehden_nimi;
    }

    public String getTilaajan_nimi() {
        return tilaajan_nimi;
    }

    public void setTilaajan_nimi(String tilaajan_nimi) {
        this.tilaajan_nimi = tilaajan_nimi;
    }

    public String getToimitusosoite() {
        return toimitusosoite;
    }

    public void setToimitusosoite(String toimitusosoite) {
        this.toimitusosoite = toimitusosoite;
    }

    public void Laskutustiedot(){
        System.out.println(
            "Lehden Nimi:" + lehden_nimi + "\n" +
            "Tilaaja:" + tilaajan_nimi + "\n" +
            "Toimitusosoite:" + toimitusosoite
        );
    }
    public void setKuukausihinta(Double kuukausihinta){}

    public void printInvoice(){}

    public void LaskeTilauksenhinta(){}

    public void setKesto(int kesto){}

    public void setAlennusprosentti(int alennusprosentti){}
}
