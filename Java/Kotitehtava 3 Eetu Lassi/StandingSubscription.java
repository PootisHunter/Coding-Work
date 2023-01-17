public class StandingSubscription extends Subscription{
    
    private int alennusprosentti;
    private Double kuukausihinta;
    private Double tilauksenhinta;
    

    public StandingSubscription(String lehden_nimi, String tilaajan_nimi, String toimitusosoite, Double kuukausihinta,
            int alennusprosentti, Double tilauksenhinta) {
        super(lehden_nimi, tilaajan_nimi, toimitusosoite);
        this.alennusprosentti = alennusprosentti;
        this.kuukausihinta = kuukausihinta;
        this.tilauksenhinta = tilauksenhinta;
    }

    public StandingSubscription(int alennusprosentti, Double kuukausihinta, Double tilauksenhinta) {
        this.alennusprosentti = alennusprosentti;
        this.kuukausihinta = kuukausihinta;
        this.tilauksenhinta = tilauksenhinta;
    }

    public StandingSubscription(){}

    @Override
    public void LaskeTilauksenhinta() {
        double n = (kuukausihinta - (kuukausihinta * (1.0 * alennusprosentti / 100))) * 12;
        this.tilauksenhinta = n;
    }

    public int getAlennusprosentti() {
        return alennusprosentti;
    }

    public Double getTilauksenhinta() {
        return tilauksenhinta;
    }

    public void setTilauksenhinta(Double tilauksenhinta) {
        this.tilauksenhinta = tilauksenhinta;
    }

    @Override
    public void setKuukausihinta(Double kuukausihinta) {
        if(kuukausihinta > 0.0){
            this.kuukausihinta = kuukausihinta;
        }   
        else{
            System.out.println("Anna positiivisia arvoja");
            System.exit(0);
        }
    }

    public Double getKuukausihinta(){
        return kuukausihinta;
    }

    public void setAlennusprosentti(int alennusprosentti) {
        if (alennusprosentti >= 0 && 100 >= alennusprosentti){
            this.alennusprosentti = alennusprosentti;
        }   
        else{
            System.out.println("Anna numero arvo väliltä 0-100");
            System.exit(0);
        }
    }

    @Override
    public void printInvoice(){
        System.out.println("Jatkuva tilaus:" + "\n");
        Laskutustiedot();
        System.out.println(
            "Kuukausihinta:" + kuukausihinta + "\n" +
            "Laskutettavat kuukaudet: 12" + "\n" +
            "Tilauksen hinta vuodessa:" + tilauksenhinta + "\n"
        );
    }
}
