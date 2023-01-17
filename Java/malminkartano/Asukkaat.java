
public class Asukkaat {
    
    private String nimi, syntyma_aika;

    public Asukkaat(String nimi, String syntyma_aika) {
        this.nimi = nimi;
        this.syntyma_aika = syntyma_aika;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getSyntyma_aika() {
        return syntyma_aika;
    }

    public void setSyntyma_aika(String syntyma_aika) {
        this.syntyma_aika = syntyma_aika;
    }

    public void printAll(){
        System.out.println(
            "Asukkaan nimi: " + nimi + "\n" +
            "Syntymaaika: " + syntyma_aika);
    }
}
