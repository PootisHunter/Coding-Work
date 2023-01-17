
public class Rakennus {
    private Double pinta_ala;
    private int huoneiden_lkm, talon_asukkaat;

    private Asukkaat[] asukkaat;

    public Rakennus(Double pinta_ala, int huoneiden_lkm, int talon_asukkaat, Asukkaat[] asukkaat) {
        this.pinta_ala = pinta_ala;
        this.huoneiden_lkm = huoneiden_lkm;
        this.talon_asukkaat = talon_asukkaat;
        this.asukkaat = asukkaat;
    }

    public void setAsukkaat(Asukkaat[] asukkaat){
        this.asukkaat = asukkaat;
    }

    public Asukkaat[] getAsukkaat(){
        return asukkaat;
    }

    public Double getPinta_ala() {
        return pinta_ala;
    }

    public void setPinta_ala(Double pinta_ala) {
        this.pinta_ala = pinta_ala;
    }

    public int getHuoneiden_lkm() {
        return huoneiden_lkm;
    }

    public void setHuoneiden_lkm(int huoneiden_lkm){
        this.huoneiden_lkm = huoneiden_lkm;
    }

    public int getHuoneiden_asukkaat(){
        return huoneiden_lkm;
    }

    public void setHuoneiden_asukkaat(int talon_asukkaat){
        this.talon_asukkaat = talon_asukkaat;
    }

    public void printAll(){
        System.out.println(
            "Pinta-ala: " + pinta_ala + "\n" +
            "Huoneiden lkm: " + huoneiden_lkm + "\n" +
            "Talon asukkaat lkm: " + talon_asukkaat);
    }
    
}
