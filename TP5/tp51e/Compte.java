
/**
 * Décrivez votre classe Compte ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
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
     * @return Montant présent sur le compte
     */
    public double getSolde()
    {
        return this.aSolde;
    }// getSolde ()
    
    /**
     * Setter qui arrondi le montant qu'on lui donne
     * 
     * @param pSolde Montant à mettre
     */
    private void affecte(final double pSolde)
    {
        this.aSolde = arrondi2(pSolde);
    }// affecte ()
    
    /**
     * Méthode arrondissant au centime le double qu'on lui fourni
     * 
     * @param pR Double à arrondir
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
     * Méthode qui retire de l'argent du compte
     * 
     * @param pDeb Montant à débiter du compte
     */
    public void debite(final double pDeb)
    {
        this.affecte(this.aSolde -= pDeb);
    }// debite ()
    
    /**
     * Méthode qui ajoute de l'argent sur le compte
     * 
     * @param pDeb Montant à créditer au compte
     */
    public void credite(final double pCred)
    {
        this.affecte(this.aSolde += pCred);
    }// credite ()
    
    /**
     * Méthode abstraite qui capitalise les intérets d'un an
     */
    public abstract void capitaliseUnAn();
    
    /**
     * Méthode qui affiche le bilan annuel d'un compte avan et après capitalisation
     */
    public void bilanAnnuel()
    {
        System.out.println("solde="+getSolde());
        this.capitaliseUnAn();
        System.out.println(" / après capitalisation, solde= "+getSolde());
    }// bilanAnnuel ()
    
    /**
     * Méthode qui compare deux compte par rapport à leur solde
     * 
     * @param pCompte Compte avec lequel comparer
     * @return 1 si le premier compte est supérieur au deuxième, 0 si ils sont égaux, -1 si le deuxième est supérieur au premier
     */
    @Override public int compareTo (final Compte pCompte)
    {
        Double vDouble1 = (Double)this.getSolde();
        Double vDouble2 = (Double)pCompte.getSolde();
        return vDouble1.compareTo(vDouble2);
    }// compareTo ()
}// Compte
