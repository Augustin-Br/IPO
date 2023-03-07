
/**
 * Décrivez votre classe Utilisation ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Utilisation
{
    /**
     * Méthode statique de test
     */
    public static void essai()
    {
        CompteCourant vC = new CompteCourant(1000);
        CompteAnnuel vA = new CompteAnnuel(1000,0.06);
        CompteMensuel vM = new CompteMensuel(1000,0.005);
        
        Compte[] vCompte = {vC,vA,vM};
        
        System.out.println(vCompte[0].compareTo(vCompte[1]));
        System.out.println(vCompte[1].compareTo(vCompte[2]));
        System.out.println(vCompte[2].compareTo(vCompte[0]));
        
        for (Compte vCompte2 : vCompte){
            vCompte2.bilanAnnuel();
        }
        
        CompteCourant vC2 = new CompteCourant(1060);
        System.out.println(vC2.compareTo(vCompte[0]));
        System.out.println(vC2.compareTo(vCompte[1]));
        System.out.println(vC2.compareTo(vCompte[2]));
    }// essai ()
}// Utilisation
