

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CompteRemunereTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CompteRemunereTest
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
    @Before
    public void setUp()
    {
        sPkg       = "";
        sClassName = "CompteRemunere";
        sFil = sClassName + ".java";
        if ( sPkg != "" ) {
            veref.ClassContent.setRefPkg( sPkg );
            sFil = sPkg + "/" + sFil;
        }
        
        sAttName = "aTaux";
        sAttType = "double";
        
        sProtoC = "( double p1, double p2 )";
    }
    
    @Test
    public void testClasse_1()
    {
        sCla = veref.V.getVClaFName( sClassName );
        sAbstract = sCla.classType().equals( "abstract class" );
        veref.V.vrai( sAbstract, "On se sait pas encore si ce sera un compte Annuel ou Mensuel, donc ?" );
        veref.V.failIfNot(); 
    } // testClasse_1()

    @Test
    public void testAttribut_2()
    {
        testClasse_1();
        sAtt = veref.V.getV1AttFTN( sCla, sAttType, sAttName );
    } // testAttribut_2()
    
    @Test
    public void testConstructeur_3()
    {
        testAttribut_2();
        sCon = veref.V.getVConFProto( sCla, sProtoC );
//         veref.V.verifFinal1Type( sFil, sClassName, "double" );
//         veref.V.verifParamP1Type( sFil, sClassName, "double" );
        veref.V.vrai( veref.V.nbCon( sCla ) <= 1 , "Il y a au moins un constructeur de trop ..." );
        veref.V.mesIfNot();        
//         double vValue1 = 12.34;
//         veref.V.getAndVerifIns1( sCon, sAtt, vValue1 ); //object discarded
        veref.V.verifAttThis( sFil, sAttType, sAttName );
    } // testConstructeur_3()
    
    @Test
    public void testAccesseur_4()
    {
        testConstructeur_3();
        sMetName = "getTaux";
        sMetRT   = "double";
        sProtoM  = "()";
        sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM );
//         veref.V.verifFinal( sFil, vMetName, vProtoM ); // inutile pour 0 param
        veref.V.vrai( veref.V.nbMet( sCla ) <= 2 , "Il y a au moins une methode de trop ..." );
        veref.V.mesIfNot();        
        // String vValue2 = "Taux";
        // ne fonctionnera pas car constructeur a 2 param
        // Object vObj2 = veref.V.getAndVerifIns1( sCon, sAtt, vValue2 );
        // veref.V.verifGetter( vObj2, sMet, vValue2 );    
    } // testAccesseur_4()

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
