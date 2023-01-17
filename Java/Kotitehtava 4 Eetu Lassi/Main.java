import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner syote = new Scanner(System.in);
        InsuranceInfo info = new InsuranceInfo();
        InsInfoContainer container = new InsInfoContainer();

        System.out.println("Anna 5 vakuutuksen tiedot");

        for (int i = 0; i < 5; ++i){
            System.out.println("Anna vakuutuksen tyyppi:");
            info.setTyyppi(syote.nextLine());
            System.out.println("Anna vakuutuksen sijainti:");
            info.setSijainti(syote.nextLine());
            System.out.println("Anna vakuutuksen vakuutusarvo:");
            try {
                info.setVakuutusarvo(syote.nextDouble());
                syote.nextLine();
            } catch (Exception e) {
                System.out.println("Anna sopiva arvo vakuutusarvoille");
                System.exit(0);
            }
            container.AddInfoToContainer(info);
        }
        
    
        System.out.println("Vakuutusten tiedot:");
        container.PrintContainerInfo();

        System.out.println("\nAnna arvo, jonka alapuolelta näytetään vakuutukset:");
        Double raja = syote.nextDouble();
        try {
            if (raja < 0){
                System.out.println("Anna sopivia vertailuarvoja");
                System.exit(0);
            }
            else{
                container.PrintContainerBelow(raja);
                syote.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Anna sopivia vertailuarvoja");
            System.exit(0);
        }
        
        

        System.out.println("\n Anna arvo, jonka yläpuolelta näytetään vakuutukset:");
        raja = syote.nextDouble();
        try {
            if (raja < 0){
                System.out.println("Anna sopivia vertailuarvoja");
                System.exit(0);
            }
            else{
                container.PrintContainerAbove(raja);
                syote.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Anna sopivia vertailuarvoja");
            System.exit(0);
        }
        

        syote.close();
    }
}
