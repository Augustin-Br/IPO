package tp;


/**
 * Décrivez votre classe PointColore ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PointColore extends Point
{
    private String aCouleur;
    
    public PointColore(final int pX, final int pY, final String pCouleur){
        super(pX, pY);
        this.aCouleur = pCouleur;
    }
    
    public PointColore(final int pX, final int pY){
        this(pX, pY, "N");
    }
    
    public PointColore(){
        // this(10,10, "N");
        this(10,10);
    }
    
    public @Override String toString(){
        return ""+this.aCouleur+":"+super.toString();
    }
}
