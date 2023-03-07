
/**
 * Décrivez votre classe CompteRemunere ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

public abstract class CompteRemunere extends Compte
{
    private double aTaux;
    
    /**
     * Constructeur naturel
     * 
     * @param pSolde Solde du compte
     * @param pTaux Taux d'intérêt du compte
     */
    public CompteRemunere (final double pSolde, final double pTaux)
    {
        super(pSolde);
        this.aTaux = pTaux;
    }// CompteRemunere ()
    
    /**
     * Getter du taux d'intérêt du compte
     * 
     * @return Le taux d'intérêt
     */
    public double getTaux ()
    {
        return this.aTaux;
    }// getTaux ()
    
    /**
     * Méthode abstraite qui capitalise les intérets d'un an
     */
    @Override public abstract void capitaliseUnAn();
}// CompteRemunere
