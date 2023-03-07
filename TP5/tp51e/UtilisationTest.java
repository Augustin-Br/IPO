import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UtilisationTest
{
    private static String                   sClassName;
    private static String                   sPkg;
    private static String                   sFil;
    private static veref.ClassContent       sCla;
    private static boolean                  sAbstract;
    private static String                   sAttName;
    private static String                   sAttType;
    private static veref.FieldContent       sAtt;
    private static String                   sProtoC;
    private static veref.ConstructorContent sCon;
    private static String                   sMetName;
    private static String                   sMetRT;
    private static String                   sProtoM;
    private static veref.MethodContent      sMet;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        sPkg       = "";
        sClassName = "Utilisation";
        sFil = sClassName + ".java";
        if ( sPkg != "" ) {
            veref.ClassContent.setRefPkg( sPkg );
            sFil = sPkg + "/" + sFil;
        }
        
        sProtoC = "()";
    }
    
    @Test
    public void testClasse_1()
    {
        sCla = veref.V.getVClaFName( sClassName );
    } // testClasse_1()

    @Test
    public void testAttribut_2()
    {
        testClasse_1();
        veref.V.verifNbAttOp( sCla, "==", 0 );
    } // testAttribut_2()
    
    @Test
    public void testConstructeur_3()
    {
        testAttribut_2();
        sCon = veref.V.getVConFProto( sCla, sProtoC );
        veref.V.vrai( veref.V.nbCon( sCla ) <= 1 , "Il y a au moins un constructeur de trop ..." );
        veref.V.failIfNot();        
    } // testConstructeur_3()
    
    @Test
    public void testEssai_4()
    {
        testConstructeur_3();
        sMetName = "essai";
        sMetRT   = "void";
        sProtoM  = "()";
        sMet = veref.V.getVMetFProtoMod( sCla, sMetName, sMetRT, sProtoM,
               "public static", "" );
        veref.V.verifCount(   sFil, "CompteCourant\\(",    1     ); // CompteCourant(
        veref.V.verifCount(   sFil, "CompteAnnuel\\(",     1     ); // CompteAnnuel(
        veref.V.verifCount(   sFil, "CompteMensuel\\(",    1     ); // CompteMensuel(
        veref.V.verifCount(   sFil, "bilanAnnuel\\(",      1     ); // BilanAnnuel(
        veref.V.verifCount(   sFil, "for\\s*\\(",          1     ); // for (
    } // testEssai_4()
    
    @Test
    public void testCompare_5()
    {
        testEssai_4();
        veref.V.verifCount(   sFil, "CompteCourant\\(",    2     ); // CompteCourant(
        veref.V.verifCount(   sFil, "compareTo\\(",        3     ); // compareTo(
        veref.V.verifCount(   sFil, "System.out.println\\(", 3   ); // System.out.println(
    } // testCompare_5()

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
}
