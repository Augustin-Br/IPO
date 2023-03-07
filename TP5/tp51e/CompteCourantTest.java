import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CompteCourantTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CompteCourantTest
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
    private static veref.MethodContent      sGetter;

    @Test
    public void testClasse_1_1()
    {
        sCla = veref.V.getVClaFName( sClassName );
        sAbstract = sCla.classType().equals( "abstract class" );
        veref.V.vrai( sAbstract, "Vous ne voulez pas avoir le droit de creer des objets de la classe "+sClassName+" ???" );
        veref.V.failIf(); 
    } // testClasse_1()

    @Test
    public void testAttribut_2()
    {
        testClasse_1_1();
        veref.V.verifNbAttOp( sCla, "==", 0 );
    } // testAttribut_2()

    @Test
    public void testConstructeur_3()
    {
        testAttribut_2();
        sCon = veref.V.getVConFProto( sCla, sProtoC );
        veref.V.verifFinal1Type( sFil, sClassName, "double" );
        veref.V.vrai( veref.V.nbCon( sCla ) <= 1 , "Il y a au moins un constructeur de trop ..." );
        veref.V.mesIfNot();      

        double vValue2 = 23.45;
        Object vObj2 = veref.V.getIns0( sCon, new Object[]{vValue2}, true );
        sMetName = "getSolde";
        sMetRT   = "double";
        sProtoM  = "()";
        sGetter = veref.V.getVMetFProto( veref.V.getVClaFName( "Compte" ), sMetName, sMetRT, sProtoM );
        veref.V.verifGetter( vObj2, sGetter, vValue2 );    
    } // testConstructeur_3()

    @Test
    public void testProcedure_4()
    {
        testAttribut_2();
        sMetName = "capitaliseUnAn";
        sMetRT   = "void";
        sProtoM  = "()";
        sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM );
        veref.V.vrai( !sMet.getModifiers().hasModifier( "abstract" ),
            "Dans "+sClassName+", on sait ce que doit faire "+sMetName+" !" );
        veref.V.failIfNot();        
        veref.V.vrai( veref.V.nbMet( sCla ) <= 1 , "Il y a au moins une methode de trop ..." );
        veref.V.mesIfNot();        
        veref.V.verifOverride( sFil, sMetRT, sMetName );

        veref.V.error( "Pour info : le constructeur va etre teste a l'aide de l'accesseur :" );
        testConstructeur_3();
    } // testProcedure_4()

    /**
     * Default constructor for test class SRoomTest
     */
    public CompteCourantTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        sPkg       = "";
        sClassName = "CompteCourant";
        sFil = sClassName + ".java";
        if ( sPkg != "" ) {
            veref.ClassContent.setRefPkg( sPkg );
            sFil = sPkg + "/" + sFil;
        }

        sAttName = "aSolde";
        sAttType = "double";

        sProtoC = "( double p1 )";
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
