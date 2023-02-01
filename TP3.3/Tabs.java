
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
    
    public static int somme(final int[] pTab){
        int sum = 0;
        for (int i = 0; i < pTab.length; i++){
            sum += pTab[i];
        }
        return sum;
    }
    
    public static double minimum(final double[] pTab){
        double min = pTab[0];
        for (int i = 0; i < pTab.length; i++){
            if (pTab[i] < min){
                min = pTab[i];
            }
        }
        return min;
    }
    
    public static int  indiceDuMinimum(final double[] pTab){
        double min = minimum(pTab);
        int indice = 0;
        while (pTab[indice] != min){
            indice += 1;
        }
        
        // pour trouver le plus grand indice de la valeur minimum
        /*
        for (int i = 0; i < pTab.length; i++){
            if (pTab[i] == min){
                indice = i;
            }
        }
        */
        return indice;
    }
}