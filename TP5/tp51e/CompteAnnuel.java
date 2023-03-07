
/**
 * D�crivez votre classe CompteAnnuel ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class CompteAnnuel extends CompteRemunere
{
    /**
     * Constructeur naturel
     * 
     * @param pSolde Solde du compte
     * @param pTaux Taux d'int�r�t du compte
     */
    public CompteAnnuel (final double pSolde, final double pTaux)
    {
        super(pSolde,pTaux);
    }// CompteAnnuel ()

    /**
     * M�thode qui capitalise les int�rets d'un an
     */
    @Override public void capitaliseUnAn()
    {
        super.credite(getSolde()*getTaux());
    }// capitaliseUnAn ()
}// CompteAnnuel
