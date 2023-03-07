
/**
 * D�crivez votre classe Compte ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public abstract class Compte implements Comparable <Compte>
{
    private double aSolde; // Solde du compte
    
    /**
     * Constructeur naturel
     * 
     * @param pSolde Solde de base du compte
     */
    public Compte (final double pSolde)
    {
        this.aSolde = arrondi2(pSolde);
    }// Compte ()
    
    /**
     * Getter du solde du compte
     * 
     * @return Montant pr�sent sur le compte
     */
    public double getSolde()
    {
        return this.aSolde;
    }// getSolde ()
    
    /**
     * Setter qui arrondi le montant qu'on lui donne
     * 
     * @param pSolde Montant � mettre
     */
    private void affecte(final double pSolde)
    {
        this.aSolde = arrondi2(pSolde);
    }// affecte ()
    
    /**
     * M�thode arrondissant au centime le double qu'on lui fourni
     * 
     * @param pR Double � arrondir
     * @return Montant arrondi
     */
    private static double arrondi2( final double pR )
    {
        double vR = Math.abs( pR );
        int    vI = (int)(vR * 1000);
        if ( vI%10 >= 5 ){
            vR = vR + 0.01;
        }// if
        return Math.copySign(((int)(vR*100))/100.0, pR);
    } // arrondi2 ()
    
    /**
     * M�thode qui retire de l'argent du compte
     * 
     * @param pDeb Montant � d�biter du compte
     */
    public void debite(final double pDeb)
    {
        this.affecte(this.aSolde -= pDeb);
    }// debite ()
    
    /**
     * M�thode qui ajoute de l'argent sur le compte
     * 
     * @param pDeb Montant � cr�diter au compte
     */
    public void credite(final double pCred)
    {
        this.affecte(this.aSolde += pCred);
    }// credite ()
    
    /**
     * M�thode abstraite qui capitalise les int�rets d'un an
     */
    public abstract void capitaliseUnAn();
    
    /**
     * M�thode qui affiche le bilan annuel d'un compte avan et apr�s capitalisation
     */
    public void bilanAnnuel()
    {
        System.out.println("solde="+getSolde());
        this.capitaliseUnAn();
        System.out.println(" / apr�s capitalisation, solde= "+getSolde());
    }// bilanAnnuel ()
    
    /**
     * M�thode qui compare deux compte par rapport � leur solde
     * 
     * @param pCompte Compte avec lequel comparer
     * @return 1 si le premier compte est sup�rieur au deuxi�me, 0 si ils sont �gaux, -1 si le deuxi�me est sup�rieur au premier
     */
    @Override public int compareTo (final Compte pCompte)
    {
        Double vDouble1 = (Double)this.getSolde();
        Double vDouble2 = (Double)pCompte.getSolde();
        return vDouble1.compareTo(vDouble2);
    }// compareTo ()
}// Compte
