package tp;


/**
 * Décrivez votre classe Utilisation ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Utilisation extends PointColore
{
    public static void essai(){
        Point vPoint = new Point(10, 15);
        vPoint.affiche();
        PointColore vPointColor = new PointColore(23, 12, "R");
        vPointColor.affiche();
        vPointColor.deplace(2, 3);
        vPointColor.affiche();
        Point vPoint2 = new Point();
        Point vPoint3 = new Point();
        System.out.println( vPoint.equals(vPoint2) + ", " + vPoint2.equals(vPoint3) );         
        Point vPointColore2 = new PointColore();
        Point vPointColore3 = new PointColore();
        System.out.println( vPointColor.equals(vPointColore2) + ", " + vPointColore2.equals(vPointColore3) );
        System.out.println( vPoint3.equals(vPointColore3) + ", " + vPointColore3.equals(vPoint3) );
        return;
    }
}
