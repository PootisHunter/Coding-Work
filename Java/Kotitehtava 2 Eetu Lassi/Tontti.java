
public class Tontti {
    // Muuttujat
    private String TontinNimi, TontinSijaintiL, TontinSijaintiP;
    private Double TontinPintaala;
    private Rakennus rakennus;

    public Tontti(String Nimi, String SijaintiL, String SijaintiP, Double Pintaala){
        this.TontinNimi = Nimi;
        this.TontinSijaintiL = SijaintiL;
        this.TontinSijaintiP = SijaintiP;
        this.TontinPintaala = Pintaala;
        this.rakennus = new Rakennus(0, 0, 0.0);
    }

    public void setAsukasAmount() {
        rakennus.setAsukasAmount();
    }

    public void setAsukas(int asukas) {
        rakennus.setAsukas(asukas);
    }
    public void setAsukasN(int asukas, String Name){
        rakennus.setAsukasN(asukas, Name);;
    }
    public void setAsukasS(int asukas, String Synty){
        rakennus.setAsukasS(asukas, Synty);
    }


    public void Asukkaat(String Asukas){
        rakennus.Asukkaat(Asukas);
    }

    public void Syntyma(String Syntyma){
        rakennus.Syntyma(Syntyma);
    }


    public void Huoneet(int Huoneet){
        rakennus.Huoneet(Huoneet);
    }
    

    public void setAsukkaat(int Asukkaat){
        rakennus.RAsukkaat(Asukkaat);
    }

    public void RPintaala(Double Pintaala){
        if(Pintaala >= 0){
            rakennus.Pintaala(Pintaala);
        }
        else{
            System.out.println("Arvo ei saa olla negatiivinen");
            System.exit(0);
        }

    }


    public void setRakennukset(Rakennus rakennukset) {
        this.rakennus = rakennukset;
    }

    public void Nimi(String Nimi){
        this.TontinNimi = Nimi;
    }

    public void SijaintiL(String Sijainti){
        this.TontinSijaintiL = Sijainti;
    }

    public void SijaintiP(String Sijainti){
        this.TontinSijaintiP = Sijainti;
    }

    public void TPintaala(Double Pintaala){
        if(Pintaala >= 0){
            this.TontinPintaala = Pintaala;
        }
        else{
            System.out.println("Arvo ei saa olla negatiivinen");
            System.exit(0);
        }
        
    }
    public Asukas getAsukas() {
        return rakennus.getAsukas();
    }
    public Asukas [] getAsukkaat(){
        return rakennus.getAsukkaat();
    }       

    public int RgetAsukkaat(){
        return rakennus.RAsukkaat();
    }

    public int RHuoneet(){
        return rakennus.RHuoneet();
    }

    public Double RPintaala(){
        return rakennus.RPintaala();
    }

    public Rakennus getRakennukset() {
        return rakennus;
    }
    public String TNimi(){
        return TontinNimi;
    }

    public String TSijaintiL(){
        return TontinSijaintiL;
    }

    public String TSijaintiP(){
        return TontinSijaintiP;
    }

    public Double TPintaala(){
        return TontinPintaala;
    }
    public void LueTonttiTiedot(){
        System.out.println(
            "*****" + "\n" +
            "Tontin nimi: " + TontinNimi + "\n" +
            "Sijainti: " + TontinSijaintiL + " " + TontinSijaintiP + "\n" +
            "Pinta-ala: " + TontinPintaala + "\n");
        rakennus.LueRakennusTiedot();
    }
    public void LueAsukasTiedot(int n){
        rakennus.LueAsukasTiedot(n);
    }
}

