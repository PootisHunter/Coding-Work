import java.util.Scanner;
import java.lang.Character;

public class Main {
    public static void main(String[] args) {
        Scanner skanner = new Scanner(System.in);

        System.out.println("Anna sanalistan tiedostonimi: ");
        String file = skanner.nextLine();
        Hirsipuu hirsipuu = new Hirsipuu(file, 6);

        String sana = hirsipuu.getSana();
        char [] paljastettu = new char [sana.length()];
        for (int i = 0; i < sana.length(); i++){
            paljastettu[i] = '_';
            if (sana.charAt(i) == ' '){
                paljastettu[i] = ' ';
            }
        }

        System.out.println("Hirsipuu");
        System.out.println(""" 
            ____
            |/   |
            |   
            |    
            |    
            |    
            |
            |_____
            """);
        System.out.println(paljastettu);
        System.out.println("Arvauksia jäljellä: " + hirsipuu.getArvaukset());
        while (true){
            char arvaus = arvaaKirjain();
            boolean lapi = hirsipuu.arvaa(arvaus);
            if (lapi){
                System.out.println("Arvasit oikein");
                for (int i = 0; i < sana.length(); i++){
                    if (sana.charAt(i) == arvaus){
                        paljastettu[i] = arvaus;
                    }
                }
                if (hirsipuu.onLoppu(paljastettu)){
                    System.out.println(paljastettu);
                    System.out.println("Voitit pelin");
                    skanner.close();
                    break;
                } else {
                    System.out.println(paljastettu);
                    System.out.println(hirsipuu.getKirjaimet());
                    System.out.println("Arvauksia jäljellä: " + hirsipuu.getArvaukset());
                } 
            } else {
                System.out.println("Arvasit väärin");
                if (hirsipuu.getArvaukset() == 5){
                    System.out.println("""
                        ____
                        |/   |
                        |   (_)
                        |    
                        |    
                        |    
                        |
                        |_____
                        """);
                    System.out.println(paljastettu);
                    System.out.println(hirsipuu.getKirjaimet());
                    System.out.println("Arvauksia jäljellä: " + hirsipuu.getArvaukset());
                } else if (hirsipuu.getArvaukset() == 4) {
                    System.out.println("""
                        ____
                        |/   |
                        |   (_)
                        |    |
                        |    |    
                        |    
                        |
                        |_____
                        """);
                    System.out.println(paljastettu);
                    System.out.println(hirsipuu.getKirjaimet());
                    System.out.println("Arvauksia jäljellä: " + hirsipuu.getArvaukset());
                } else if (hirsipuu.getArvaukset() == 3) {
                    System.out.println("""
                        ____
                        |/   |
                        |   (_)
                        |   /|
                        |    |
                        |    
                        |
                        |_____
                        """);
                    System.out.println(paljastettu);
                    System.out.println(hirsipuu.getKirjaimet());
                    System.out.println("Arvauksia jäljellä: " + hirsipuu.getArvaukset());
                } else if (hirsipuu.getArvaukset() == 2) {
                    System.out.println("""
                        ____
                        |/   |
                        |   (_)
                        |   /|\\
                        |    |
                        |    
                        |
                        |_____
                        """);
                    System.out.println(paljastettu);
                    System.out.println(hirsipuu.getKirjaimet());
                    System.out.println("Arvauksia jäljellä: " + hirsipuu.getArvaukset());
                } else if (hirsipuu.getArvaukset() == 1){
                    System.out.print("""
                        ____
                        |/   |
                        |   (_)
                        |   /|\\
                        |    |
                        |   / 
                        |
                        |_____
                        """);
                    System.out.println(paljastettu);
                    System.out.println(hirsipuu.getKirjaimet());
                    System.out.println("Arvauksia jäljellä: " + hirsipuu.getArvaukset());
                } else {
                    System.out.println("""
                        ____
                        |/   |
                        |   (_)
                        |   /|\\
                        |    |
                        |   | |
                        |
                        |_____
                        """);
                    System.out.println("Hävisit pelin");
                    System.out.println("Oikea sana oli: "+ sana);
                    skanner.close();
                    break;
                }    
            }
        }
    }
    public static Character arvaaKirjain(){
        Scanner skanneri = new Scanner(System.in);
        boolean kysely = true;
        while (kysely){
            try {
                System.out.println("Arvaa Kirjain: ");
                String arvaus = skanneri.nextLine();
                char kirjain = Character.toLowerCase(arvaus.charAt(0));
                kysely = false;
                return kirjain;
            } catch (Exception e) {
                System.out.println("Virhe Syötössä");
            }
        }
        skanneri.close();
        return null;
    }
}
