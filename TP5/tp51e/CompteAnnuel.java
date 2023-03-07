
/**
 * Décrivez votre classe CompteAnnuel ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CompteAnnuel extends CompteRemunere
{
    /**
     * Constructeur naturel
     * 
     * @param pSolde Solde du compte
     * @param pTaux Taux d'intérêt du compte
     */
    public CompteAnnuel (final double pSolde, final double pTaux)
    {
        super(pSolde,pTaux);
    }// CompteAnnuel ()

    /**
     * Méthode qui capitalise les intérets d'un an
     */
    @Override public void capitaliseUnAn()
    {
        super.credite(getSolde()*getTaux());
    }// capitaliseUnAn ()
}// CompteAnnuel
