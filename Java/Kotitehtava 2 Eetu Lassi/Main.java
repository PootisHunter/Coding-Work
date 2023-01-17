import java.util.Scanner;
public class Main {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        Tontti tontti = new Tontti("", "", "", 0.0);
        

        System.out.println("Anna tontin nimi: ");
        String tonttiNimi = (scanner.nextLine());

        System.out.println("Anna tontin koordinaatit leveytena: ");
        String tonttiSijaintiL (scanner.nextLine());

        System.out.println("Anna tontin koordinaatit pituutena: ");
        String .SijaintiP(scanner.nextLine());

        System.out.println("Anna tontin pinta-ala lukuna: ");
        tontti.TPintaala(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Anna Rakennuksen asukkaat lukuna: ");
        tontti.setAsukkaat(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Anna Rakennuksen huoneet lukuna: ");
        tontti.Huoneet(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Anna Rakennuksen pinta-ala lukuna: ");
        tontti.RPintaala(scanner.nextDouble());
        scanner.nextLine();

        tontti.setAsukasAmount();
        for(int i = 0; i < tontti.RgetAsukkaat(); i++){
            tontti.setAsukas(i);

            System.out.println("Anna Asukkaan nimi: ");
            tontti.setAsukasN(i,scanner.nextLine());

            System.out.println("Anna Asukkaan Syntymäaika: ");
            tontti.setAsukasS(i, scanner.nextLine());

        }

        tontti.LueTonttiTiedot();
        
        System.out.println("Asukkaat:");

        for(int i = 0; i < tontti.RgetAsukkaat(); i++){
            tontti.LueAsukasTiedot(i);
        }
        System.out.println("*****" + "\n");
        scanner.close();

    }
    
}
