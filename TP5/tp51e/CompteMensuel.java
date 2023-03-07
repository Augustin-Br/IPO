
/**
 * D�crivez votre classe CompteMensuel ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class CompteMensuel extends CompteRemunere
{
    /**
     * Constructeur naturel
     * 
     * @param pSolde Solde du compte
     * @param pTaux Taux d'int�r�t du compte
     */
    public CompteMensuel (final double pSolde, final double pTaux)
    {
        super(pSolde,pTaux);
    }// CompteMensuel

    /**
     * M�thode r�cursive ajoutant les int�rets mois pas mois
     * 
     * @param pMois Nombre de mois dont il faut capitaliser les int�r�ts
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
     * M�thode qui capitalise les int�rets d'un an
     */
    @Override public void capitaliseUnAn()
    {
        this.capitaliseUnMois(12);
    }// capitaliseUnAn ()
}// CompteMensuel
