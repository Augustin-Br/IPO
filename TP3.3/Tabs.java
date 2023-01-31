
/**
 * Décrivez votre classe Tabs ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Tabs
{
    public static void affTab(final int[] pTab){
        for (int i = 0; i < pTab.length; i++){
            System.out.println(pTab[i]);            
        }
    }
    
    public static void affTabInv(final int[] pTab){
        for (int i = pTab.length-1; i >= 0; i--){
            System.out.println(pTab[i]);            
        }
    }    
    
    public static void initTab(final int[] pTab){
        for (int i = 0; i < pTab.length; i++){
            pTab[i] = i*2;
        }
        affTab(pTab);
    }
}