public class RegularSubscription extends Subscription{

    private int kesto;
    private Double kuukausihinta;
    private Double tilauksenhinta;


    public RegularSubscription(String lehden_nimi, String tilaajan_nimi, String toimitusosoite, Double kuukausihinta,
            int kesto, Double tilauksenhinta) {
        super(lehden_nimi, tilaajan_nimi, toimitusosoite);
        this.kesto = kesto;
        this.kuukausihinta = kuukausihinta;
        this.tilauksenhinta = tilauksenhinta;
    }
    public RegularSubscription(int kesto, Double tilauksenhinta) {
        this.kesto = kesto;
        this.tilauksenhinta = tilauksenhinta;
    }
    public RegularSubscription() {}


    public Double getTilauksenhinta() {      
        return tilauksenhinta;
    }

    public void setTilauksenhinta(Double tilauksenhinta ) {
        this.tilauksenhinta = tilauksenhinta;
    }

    public int getKesto() {
        return kesto;
    }

    @Override
    public void setKesto(int kesto) {
        if(kesto > 0){
            this.kesto = kesto;
        }   
        else{
            System.out.println("Anna positiivisia arvoja");
            System.exit(0);
        }
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

    @Override
    public void LaskeTilauksenhinta() {
        double n = kuukausihinta * 1.0 * (kesto);
        this.tilauksenhinta = n;
    }

    @Override
    public void printInvoice(){
        System.out.println("Kestotilaus:" + "\n");
        Laskutustiedot();
        System.out.println(
            "Kuukausihinta:" + kuukausihinta + "\n" +
            "Tilauksen kesto kuukausina:" + kesto + "\n" +
            "Tilauksen hinta kokonaisuudessaan:" + tilauksenhinta + "\n"
        );
    }

}