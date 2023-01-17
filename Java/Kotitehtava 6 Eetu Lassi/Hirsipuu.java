import java.util.ArrayList;
import java.util.Random;

public class Hirsipuu {

    private int arvaukset;
    private String sana;
    private ArrayList<Character> arvatut_kirjaimet = new ArrayList<>();
    private Sanalista sanalista;

    public Hirsipuu(int arvaukset, String sana, ArrayList<Character> arvatut_kirjaimet, String file) {
        this.arvaukset = arvaukset;
        this.sana = sana;
        this.arvatut_kirjaimet = arvatut_kirjaimet;
        this.sanalista = new Sanalista(file);
    }
    // Laittaa sanalista tiedosta ja valitsee sielta sanan.
    public Hirsipuu(String file, int arvaukset) {
        this.arvaukset = arvaukset;
        Random random = new Random();
        this.sanalista = new Sanalista(file);
        this.sana = sanalista.annaSanat().get(random.nextInt(sanalista.annaSanat().size()));
    }
    public boolean arvaa(Character kirjain){
        arvatut_kirjaimet.add(kirjain);
        if (this.sana.contains(Character.toString(kirjain))){
            return true;
        } else {
            this.arvaukset--;
            return false;
        }
    }

    public int getArvaukset(){
        return arvaukset;
    }
    public String getSana(){
        return sana;
    }
    public ArrayList<Character> getKirjaimet(){
        return arvatut_kirjaimet;
    }
    public void setArvaukset(int arvaukset){
        this.arvaukset = arvaukset;
    }
    public void setSana(String sana){
        this.sana = sana;
    }
    public void setKirjaimet(ArrayList<Character> kirjaimet){
        this.arvatut_kirjaimet = kirjaimet;
    }
    public Sanalista getSanalista() {
        return sanalista;
    }
    public void setSanalista(Sanalista sanalista) {
        this.sanalista = sanalista;
    }
    public boolean onLoppu(char [] paljastettu){
        if (sana.equals(String.valueOf(paljastettu))){
            return true;
        }
        return false;
    }
}

