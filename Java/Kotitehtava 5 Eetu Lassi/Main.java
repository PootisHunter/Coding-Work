import java.util.Scanner;
public class Main {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        Tontti tontti = new Tontti();
        
        
        System.out.println("Anna tontin nimi:");
        tontti.setTontinNimi(scanner.nextLine());
        
        System.out.println("Anna tontin osoite:");
        tontti.setTonttiOsoite(scanner.nextLine());
        try {
            System.out.println("Anna tontin pinta-ala:");
            tontti.setTontinPintaala(scanner.nextDouble());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Käytä sopivaa arvoa");
            System.exit(0);
        }
        

        System.out.println("Onko rakennus Kerrostalo (K) , Rivitalo (R) tai Omakotitalo (O):");
        tontti.getRakennus().Rakennustyyppi(scanner.nextLine());

        System.out.println("Anna asuntojen lukumaara:");
        tontti.getRakennus().setAsuntojenMaara(scanner.nextInt());
        scanner.nextLine();

        for (int i = 0; i < tontti.getRakennus().getAsuntojenMaara(); i++){
            System.out.println("Anna asunnon huoneiden lukumaara:");
            tontti.getRakennus().getAsunto().setAsunnonHuoneidenlukumaara(scanner.nextInt());
            scanner.nextLine();
            try {
                System.out.println("Anna asunnon pinta-ala:");
                tontti.getRakennus().getAsunto().setAsunnonPintaala(scanner.nextDouble());
                scanner.nextLine();
            } catch (Exception e){
                System.out.println("Käytä sopivaa arvoa");
                System.exit(0);
            }
            System.out.println("Anna asunnon asukkaiden lukumaara");
            tontti.getRakennus().getAsunto().setAsukkaidenLukumaara(scanner.nextInt());
            scanner.nextLine();
            for (int a = 0; a < tontti.getRakennus().getAsunto().getAsukkaidenLukumaara(); a++){
                System.out.println("Anna asukkaan nimi:");
                tontti.getRakennus().getAsunto().getAsukas().Asukkaat(scanner.nextLine());
                tontti.getRakennus().getAsunto().addAsukaslista(tontti.getRakennus().getAsunto().getAsukas().TAsukas());
            }
            tontti.getRakennus().getAsuntolista().add(tontti.getRakennus().getAsunto().getAsuntotiedot(tontti.getRakennus().getAsunto().getAsukaslista()));
            tontti.getRakennus().getAsunto().getAsukaslista().clear();
        }
        tontti.TulostaTonttitiedot();
        tontti.getRakennus().getAsunto().TulostaRakennustiedot();
        scanner.close();
    }
    
}
