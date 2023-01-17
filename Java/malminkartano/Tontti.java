
public class Tontti {

    private String nimi, leveyspiiri, pituuspiiri;
    private Double pinta_ala;
    private Rakennus rakennus;

    public Tontti(String nimi, String leveyspiiri, String pituuspiiri, Double pinta_ala, Rakennus rakennus) {
        this.nimi = nimi;
        this.leveyspiiri = leveyspiiri;
        this.pituuspiiri = pituuspiiri;
        this.pinta_ala = pinta_ala;
        this.rakennus = rakennus;
    }

    public Rakennus getRakennus(){
        return rakennus;
    }

    public void setRakennus(Rakennus rakennus) {
        this.rakennus = rakennus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getLeveyspiiri() {
        return leveyspiiri;
    }

    public void setLeveyspiiri(String leveyspiiri) {
        this.leveyspiiri = leveyspiiri;
    }

    public String getPituusPiiri(){
        return pituuspiiri;
    }

    public void setPituuspiiri(String pituuspiiri){
        this.pituuspiiri = pituuspiiri;
    }

    public Double getPintaAla(){
        return pinta_ala;
    }

    public void setPintaAla(double pinta_ala){
        this.pinta_ala = pinta_ala;
    }

    public void printAll(){
        System.out.println(
            "Tontin nimi: " + nimi + "\n" +
            "Sijainti: " + leveyspiiri + " " + pituuspiiri + "\n" +
            "Pinta-ala: " + pinta_ala + "\n" +

            "Rakennuksen pinta ala: " + rakennus.getPinta_ala() + "\n" +
            "Rakennuksen huoneiden lkm: " + rakennus.getHuoneiden_lkm() + "\n" +
            "Rakennuksen asukkaiden lkm: " + rakennus.getHuoneiden_asukkaat() + "\n"
        );

        for(int i = 0; i < rakennus.getAsukkaat().length; i++){
            System.out.println(
                "Asukkaan nimi: " + rakennus.getAsukkaat()[i].getNimi() + "\n" +
                "Asukkaan syntyma aika: " + rakennus.getAsukkaat()[i].getSyntyma_aika()  + "\n"
            );
        }
    }
}