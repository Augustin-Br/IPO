
/**
 * Décrivez votre classe Utilisation ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Utilisation
{
    public void essai(){
        System.out.println(" expression : \n");
        Calc.expression();
        System.out.println("\n racNeg : \n");
        System.out.println(Calc.racNeg(-12));
        System.out.println("\n afficheMoities : \n");
        Calc.afficheMoities(45);
        System.out.println("\n sontProches : \n");
        System.out.println(Calc.sontProches(0.123456784, 0.123456786));
        System.out.println("\n initTab : \n");
        int[] vTab = new int[6];
        Tabs.initTab(vTab);
        System.out.println("\n affTab : \n");
        Tabs.affTab(vTab);
        System.out.println("\n affTabInv : \n");
        Tabs.affTabInv(vTab);
        
    }
}
