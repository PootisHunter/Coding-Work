import java.util.ArrayList;

public class Rakennus {

    private int AsuntojenMaara;
    private ArrayList<ArrayList<String>> asuntolista = new ArrayList<ArrayList<String>>();
    private Asunto asunto;
    private String rakennustyyppi;

    
    public Rakennus(int asuntojenMaara, ArrayList<ArrayList<String>> asuntolista, Rakennus.Asunto asunto,
            String rakennustyyppi) {
        AsuntojenMaara = asuntojenMaara;
        this.asuntolista = asuntolista;
        this.asunto = asunto;
        this.rakennustyyppi = rakennustyyppi;
    }
    public Rakennus(int asuntojenMaara, ArrayList<ArrayList<String>> asuntolista) {
            AsuntojenMaara = asuntojenMaara;
            this.asuntolista = asuntolista;
            this.asunto = new Asunto();

    }
    public Rakennus(){
        this.asunto = new Asunto();
    }

    public String getRakennustyyppi() {
        return rakennustyyppi;
    }
    public void setRakennustyyppi(String rakennustyyppi) {
        this.rakennustyyppi = rakennustyyppi;
    }
    public Asunto getAsunto() {
        return asunto;
    }

    public void setAsunto(Asunto asunto) {
        this.asunto = asunto;
    }
    
    public ArrayList<ArrayList<String>> getAsuntolista() {
        return asuntolista;
    }
    public void setAsuntolista(ArrayList<ArrayList<String>> asuntolista) {
        this.asuntolista = asuntolista;
    }
    public void lisaaAsunto(ArrayList<String> asunto){
        asuntolista.add(asunto);
    }

    public int getAsuntojenMaara() {
        return AsuntojenMaara;
    }

    public void setAsuntojenMaara(int asuntojenMaara) {
        this.AsuntojenMaara = asuntojenMaara;
    }
    public void Rakennustyyppi(String valinta){
        if (valinta.matches("O|o|Omakotitalo|omakotitalo")){
            setRakennustyyppi("omakotitalo");
        }
        else if (valinta.matches("R|r|Rivitalo|rivitalo")){
            setRakennustyyppi("rivitalo");
        }
        else if (valinta.matches("kerrostalo|Kerrostalo|k|K")){
            setRakennustyyppi( "kerrostalo");
            
        }
        else{
            System.out.println("Anna sopiva rakennustyyppi");
            System.exit(0);   
        }
        
    } 
    public class Asunto{

        private int AsunnonHuoneidenlukumaara, AsukkaidenLukumaara;
        private Double AsunnonPintaala;
        private Asukas asukas;
        private ArrayList<String> asukaslista = new ArrayList<String>();

        public Asunto(int asunnonHuoneidenlukumaara, int asukkaidenLukumaara, Double asunnonPintaala,
                        Asukas asukas, ArrayList<String> asukaslista) {
                    AsunnonHuoneidenlukumaara = asunnonHuoneidenlukumaara;
                    AsukkaidenLukumaara = asukkaidenLukumaara;
                    AsunnonPintaala = asunnonPintaala;
                    this.asukas = new Asukas();
                    this.asukaslista = asukaslista;
        }
        
        public Asunto(){
            this.asukas = new Asukas();
        }
        public ArrayList<String> getAsukaslista() {
                return asukaslista;
            }
        public void setAsukaslista(ArrayList<String> asukaslista) {
                this.asukaslista = asukaslista;
            }

        public void addAsukaslista(String asukas){
            asukaslista.add(asukas);
        }
        public int getAsukkaidenLukumaara() {
            return AsukkaidenLukumaara;
        }

        public void setAsukkaidenLukumaara(int asukkaidenLukumaara) {
            this.AsukkaidenLukumaara = asukkaidenLukumaara;
        }

        public Asukas getAsukas() {
            return asukas;
        }
        public void setAsukas(Asukas asukas) {
            this.asukas = asukas;
        }
        public Double getAsunnonPintaala() {
            return AsunnonPintaala;
        }
        public void setAsunnonPintaala(Double asunnonPintaala) {
            if (asunnonPintaala < 0){
                System.out.println("Käytä positiivisia arvoja");
                System.exit(0);
            }
            this.AsunnonPintaala = asunnonPintaala;
        }
        public int getAsunnonHuoneidenlukumaara() {
            return AsunnonHuoneidenlukumaara;
        }
        public void setAsunnonHuoneidenlukumaara(int asunnonHuoneidenlukumaara) {
            this.AsunnonHuoneidenlukumaara = asunnonHuoneidenlukumaara;
        }
        public ArrayList<String> getAsuntotiedot(ArrayList<String> asukaslista){
            ArrayList<String> lista = new ArrayList<String>();
            lista.add(Integer.toString(AsunnonHuoneidenlukumaara));
            lista.add(AsunnonPintaala + "");
            lista.add(Integer.toString(AsukkaidenLukumaara));
            lista.addAll(asukaslista);
            return lista;
            
        }
        public void TulostaRakennustiedot(){
            System.out.println(
                "Rakennuksen tyyppi: " + rakennustyyppi + "\n" +
                "Asuntojen lukumäärä: " + AsuntojenMaara);
            for (int i = 0; i < asuntolista.size(); i++){
                System.out.println(
                    "///////" + "\n" +
                    "Asunnon " + (i + 1) + " huoneiden määrä: " + asuntolista.get(i).get(0) + "\n" +
                    "Asunnon " + (i + 1) + " pinta-ala: " + asuntolista.get(i).get(1) + "\n" +
                    "Asukkaiden määrä: " + asuntolista.get(i).get(2) + "\n" +
                    "///////" + "\n" +
                    "Asunnon " + (i + 1) + " asukkaat:");
                for (int a = 3; a - 3 < Integer.valueOf(asuntolista.get(i).get(2)); a++){
                    System.out.println(asuntolista.get(i).get(a));
                }
            }
            System.out.println("///////" + "\n");
        }
    }
}
class Kerrostalo extends Rakennus{}
class Omakotitalo extends Rakennus{}
class Rivitalo extends Rakennus{}



    