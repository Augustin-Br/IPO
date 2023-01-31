
/**
 * Décrivez votre classe Calc ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Calc
{
    public static void expression()
    {
        System.out.println(2 + 3 / 4);
        System.out.println(2.0 + 3 / 4);
        System.out.println(2 + 30E-1 / 4);
        System.out.println(11 % 4);
        System.out.println(Math.cos(Math.PI/4) == Math.sin(Math.PI/4));
    }
    
    public static double racNeg(final double pNb){
        if (pNb > 0){
            return Math.sqrt(pNb);
        }else if (pNb < 0){
            double sqrtNb = Math.sqrt(-pNb);
            return -sqrtNb;
        }else{
            return 0;
        }
    }
    
    public static void afficheMoities(final int pNb){
        int vY = pNb;
        while (vY >= 1){
            System.out.println(vY);
            vY = vY / 2;
        }
    }
    
    public static boolean  sontProches(final double pNbA, final double pNbB){
        return (Math.abs(pNbA-pNbB) <= Math.pow(10, -9));
    }
}
