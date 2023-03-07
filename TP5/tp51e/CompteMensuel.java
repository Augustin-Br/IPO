
/**
 * Décrivez votre classe CompteMensuel ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CompteMensuel extends CompteRemunere
{
    /**
     * Constructeur naturel
     * 
     * @param pSolde Solde du compte
     * @param pTaux Taux d'intérêt du compte
     */
    public CompteMensuel (final double pSolde, final double pTaux)
    {
        super(pSolde,pTaux);
    }// CompteMensuel

    /**
     * Méthode récursive ajoutant les intérets mois pas mois
     * 
     * @param pMois Nombre de mois dont il faut capitaliser les intérêts
     */
    public void capitaliseUnMois(final int pMois)
    {
        if (pMois == 0){
            return;
        }else{
            super.credite(getSolde()*getTaux());
            this.capitaliseUnMois(pMois-1);
        }// else
    }// capitaliseUnMois
    
    /**
     * Méthode qui capitalise les intérets d'un an
     */
    @Override public void capitaliseUnAn()
    {
        this.capitaliseUnMois(12);
    }// capitaliseUnAn ()
}// CompteMensuel
