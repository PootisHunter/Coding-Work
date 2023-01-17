public class Asukas {
    // Muuttujat
    private String AsukasNimi, AsukasSyntymaaika;
    

    public Asukas(String Asukas, String Syntyma){
        this.AsukasNimi = Asukas;
        this.AsukasSyntymaaika = Syntyma;
        
    }
        
    public void Asukkaat(String Asukas){
        this.AsukasNimi = Asukas;
    }

    public void Syntyma(String Syntyma){
        this.AsukasSyntymaaika = Syntyma;
    }

    public String TAsukas(){
        return AsukasNimi;
    }

    public String TSyntyma(){
        return AsukasSyntymaaika;
    }

    
    public void LueAsukasTiedot( ){
        System.out.println(
            "\n" +
            "Asukas: " + AsukasNimi + "\n" +
            "Syntymaaika: " + AsukasSyntymaaika + "\n");
        }
}

