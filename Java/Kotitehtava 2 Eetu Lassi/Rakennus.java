public class Rakennus {

    private int RakennusAsukkaat, RakennusHuoneet;
    private Double RakennusPintaala;
    private Asukas asukas;
    private Asukas [] asukkaat;

    public Rakennus(int Asukkaat, int Huoneet, Double Pintaala){
        this.RakennusAsukkaat = Asukkaat;
        this.RakennusHuoneet = Huoneet;
        this.RakennusPintaala = Pintaala;
        this.asukas = new Asukas("", "");
    }
    public void setAsukasAmount() {
        this.asukkaat = new Asukas [RakennusAsukkaat];
    }

    public void setAsukas(int asukas) {
        this.asukas = new Asukas("", "");
    }
    public void setAsukasN(int asukas, String Name){
        asukkaat[asukas].Asukkaat(Name);
    }
    public void setAsukasS(int asukas, String Synty){
        asukkaat[asukas].Syntyma(Synty);
    }

    public void Asukkaat(String Asukas){
        asukas.Asukkaat(Asukas);
    }
    public void Syntyma(String Syntyma){
        asukas.Syntyma(Syntyma);
    }


    public void RAsukkaat(int Asukkaat){
        this.RakennusAsukkaat = Asukkaat;
    }

    public void Huoneet(int Huoneet){
        this.RakennusHuoneet = Huoneet;
    }

    public void Pintaala(Double Pintaala){
        if(Pintaala >= 0){
            this.RakennusPintaala = Pintaala;
        }
        else{
            System.out.println("Arvo ei saa olla negatiivinen");
            System.exit(0);
        }

    }

    public String TAsukas(){
        return asukas.TAsukas();
    }

    public String TSyntyma(){
        return asukas.TSyntyma();
    }



    public Asukas getAsukas() {
        return asukas;
    }
    public Asukas [] getAsukkaat(){
        return asukkaat;
    }       

    public int RAsukkaat(){
        return RakennusAsukkaat;
    }

    public int RHuoneet(){
        return RakennusHuoneet;
    }

    public Double RPintaala(){
        return RakennusPintaala;
    }

    public void LueRakennusTiedot(){
        System.out.println(
            "Asukkaat: " + RakennusAsukkaat + "\n" +
            "Huoneet: " + RakennusHuoneet + "\n" +
            "Pinta-ala: " + RakennusPintaala + "\n");
    }
    public void LueAsukasTiedot(int n){
        asukkaat[n].LueAsukasTiedot();
    }
}

