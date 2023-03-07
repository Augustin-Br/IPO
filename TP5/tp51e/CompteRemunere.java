
/**
 * D�crivez votre classe CompteRemunere ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */

public abstract class CompteRemunere extends Compte
{
    private double aTaux;
    
    /**
     * Constructeur naturel
     * 
     * @param pSolde Solde du compte
     * @param pTaux Taux d'int�r�t du compte
     */
    public CompteRemunere (final double pSolde, final double pTaux)
    {
        super(pSolde);
        this.aTaux = pTaux;
    }// CompteRemunere ()
    
    /**
     * Getter du taux d'int�r�t du compte
     * 
     * @return Le taux d'int�r�t
     */
    public double getTaux ()
    {
        return this.aTaux;
    }// getTaux ()
    
    /**
     * M�thode abstraite qui capitalise les int�rets d'un an
     */
    @Override public abstract void capitaliseUnAn();
}// CompteRemunere
