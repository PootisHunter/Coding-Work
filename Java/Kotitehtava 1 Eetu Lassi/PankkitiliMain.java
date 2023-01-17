import java.util.Scanner;
public class PankkitiliMain {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        Pankkitili pankki = new Pankkitili();
        System.out.println("Anna tilinumero:");
        pankki.Tilinumero(scanner.nextLine());
        System.out.println("Anna Tilin omistajan nimi");
        pankki.Tiliomistaja(scanner.nextLine());
        System.out.println("Anna tilin saldo:");
        pankki.Tilisaldo(scanner.nextDouble());
        System.out.println(pankki.Luetiedot());
        System.out.println("Kuinka paljon rahaa haluat ottaa tililtä");
        pankki.Tiliotto(scanner.nextDouble());
        pankki.Tililtaotto();
        System.out.println(pankki.Luetiedot());
        scanner.close();
    }
}
