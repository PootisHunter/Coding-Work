import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int asukkkaiden_lkm;

        System.out.println("Anna rakennuksen asukkaiden lkm: ");
        asukkkaiden_lkm = scanner.nextInt();
        scanner.nextLine();

        Asukkaat asukaslista[] = new Asukkaat[asukkkaiden_lkm];

        for (int i = 0; i < asukkkaiden_lkm; i++) {
            asukaslista[i] = new Asukkaat("", "");

            System.out.println("Anna asukkaan nimi: ");
            asukaslista[i].setNimi(scanner.nextLine());

            System.out.println("Anna asukkaan syntymaaika: ");
            asukaslista[i].setSyntyma_aika(scanner.nextLine());
        }

        Rakennus rakennus = new Rakennus(0.0, 0, 0, asukaslista);

        System.out.println("Anna rakennuksen pinta ala: ");
        rakennus.setPinta_ala(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Anna rakennuksen huoneiden lkm: ");
        rakennus.setHuoneiden_lkm(scanner.nextInt());
        scanner.nextLine();

        rakennus.setHuoneiden_asukkaat(asukkkaiden_lkm);

        Tontti tontti = new Tontti("", "", "", 0.0, rakennus);

        System.out.println("Anna tontin nimi: ");
        tontti.setNimi(scanner.nextLine());

        System.out.println("Anna tontin leveyspiiri: ");
        tontti.setLeveyspiiri(scanner.nextLine());

        System.out.println("Anna tontin pituuspiiri: ");
        tontti.setPituuspiiri(scanner.nextLine());

        System.out.println("Anna tontin pinta ala: ");
        tontti.setPintaAla(scanner.nextDouble());
        scanner.nextLine();
        
        scanner.close();

        tontti.printAll();
    }
}
