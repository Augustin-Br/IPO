
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
        System.out.println("\n somme : \n");
        int[] vTab1 = {1, 2, 3, 4, 5, 6};
        System.out.println(Tabs.somme(vTab1));
        System.out.println("\n minimum : \n");
        double[] vTab2 = {14.45, 2.15, 34.25, 0.24, 5.87, 0.64, 0.24, 0.65, 0.63, 4};
        System.out.println(Tabs.minimum(vTab2));
        System.out.println("\n indice du minimum : \n");
        System.out.println(Tabs.indiceDuMinimum(vTab2));
    }
}
