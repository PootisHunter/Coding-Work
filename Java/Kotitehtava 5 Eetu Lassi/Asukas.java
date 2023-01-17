public class Asukas {
    // Muuttujat
    private String AsukasNimi;
    
    public Asukas(String Asukas, String Syntyma){
        this.AsukasNimi = Asukas;
    }
    public Asukas(){};
        
    public void Asukkaat(String Asukas){
        this.AsukasNimi = Asukas;
    }

    public String TAsukas(){
        return AsukasNimi;
    }
   
}

