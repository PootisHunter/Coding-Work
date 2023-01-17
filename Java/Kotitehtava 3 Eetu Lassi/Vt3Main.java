import java.util.Scanner;

public class Vt3Main {
    
    public static void main(String [] args) {
        Scanner syote = new Scanner(System.in);
        
        Subscription regi = new RegularSubscription();
        Subscription stadi = new StandingSubscription();

        System.out.println("Kestotilaus:" + "\n" +
        "Anna Tilaajan nimi:");
        regi.setTilaajan_nimi(syote.nextLine());
        System.out.println("Anna Lehden nimi:");
        regi.setLehden_nimi(syote.nextLine());
        System.out.println("Anna toimitusosoite:");
        regi.setToimitusosoite(syote.nextLine());
        System.out.println("Anna kuukausihinta:");
        try {
            regi.setKuukausihinta(syote.nextDouble());
            syote.nextLine();
        } catch (Exception inputMismatchException) {
            System.out.println("Kayta sopivia numeroarvoja");
            System.exit(0);
        }
        System.out.println("Anna Lehden kesto kuukausina:");
        try {
            regi.setKesto(syote.nextInt());
            syote.nextLine();
            
        } catch (Exception inputMismatchException) {
            System.out.println("Kayta sopivia numeroarvoja");
            System.exit(0);
        }
        regi.LaskeTilauksenhinta();


        System.out.println("Jatkuvatilaus:" + "\n" +
        "Anna Tilaajan nimi:");
        stadi.setTilaajan_nimi(syote.nextLine());
        System.out.println("Anna Lehden nimi:");
        stadi.setLehden_nimi(syote.nextLine());
        System.out.println("Anna toimitusosoite:");
        stadi.setToimitusosoite(syote.nextLine());
        System.out.println("Anna kuukausihinta:");
        try {
            stadi.setKuukausihinta(syote.nextDouble());
            syote.nextLine();  
        } catch (Exception inputMismatchException) {
            System.out.println("Kayta sopivia numeroarvoja");
            System.exit(0);
        }
        System.out.println("Anna Alennusprosentti:");
        try {
            stadi.setAlennusprosentti(syote.nextInt());
            syote.nextLine();  
        } catch (Exception inputMismatchException) {
            System.out.println("Kayta sopivia numeroarvoja");
            System.exit(0);
        }
        stadi.LaskeTilauksenhinta();    
    
        printSubscriptionInvoice(regi);
        printSubscriptionInvoice(stadi);

        syote.close();

    }
    static void printSubscriptionInvoice(Subscription sub){
        sub.printInvoice();
    }
}
