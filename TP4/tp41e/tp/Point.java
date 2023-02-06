package tp;


/**
 * Décrivez votre classe Point ici.
 *
 * @author (votre nom)
 */
public class Point
{
    private int aX;
    private int aY;
    
    public Point(final int pX, final int pY){
        this.aX = pX;
        this.aY = pY;
    }
    
    public Point(){
        this(10,10);
    }
    
    public void deplace(final int pDeltaX, final int pDeltaY){
        this.aX += pDeltaX;
        this.aY += pDeltaY;
    }
    
    public @Override String toString(){
        return "("+ this.aX + "," + this.aY + ")";
    }
    
    public void affiche(){
        System.out.println(toString());
    }
}
