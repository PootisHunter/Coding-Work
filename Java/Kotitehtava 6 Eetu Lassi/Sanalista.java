import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Sanalista {
    
    private ArrayList<String> sanalista = new ArrayList<String>();

    public Sanalista(ArrayList<String> sanalista) {
        this.sanalista = sanalista;
    }
    public Sanalista(String file) {
       try {
            Scanner reader = new Scanner(new File(file));
            while(reader.hasNextLine()){
                sanalista.add(reader.nextLine());
        }
       } catch (Exception e) {
           System.out.println("Virhe Sanakirjassa: " + e.getMessage());
       } 
    }
    public Sanalista sanatJoidenPituuson(int pituus){
        ArrayList<String> uusilista = new ArrayList<String>();
        for (String word : sanalista){
            if (word.length() == pituus){
                uusilista.add(word);
            }
        }
        return new Sanalista(uusilista);
    }

    public Sanalista sanatJoissaMerkit(String mjono){
        ArrayList<String> uusilista = new ArrayList<String>();
        for (String word : sanalista){
            int oikein = 0;
            for (char kirjain : word.toCharArray())
                for (int i = 0; i < word.length(); i++){
                    if (kirjain == mjono.toCharArray()[i] || kirjain == '_'){
                        oikein++;
                    }
                }
            if (word.length() == oikein){
                uusilista.add(word);
            }
        }
        return new Sanalista(uusilista);
    }
    
    public ArrayList<String> annaSanat(){
        return sanalista;
    }

    public void setSanat(ArrayList<String> list){
        this.sanalista = list;
    }


}
