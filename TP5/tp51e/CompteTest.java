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
public class CompteTest
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
    } // testClasse_1()

    @Test
    public void testAttribut_2()
    {
        testClasse_1_1();
        sAtt = veref.V.getV1AttFTN( sCla, sAttType, sAttName );
    } // testAttribut_2()

    @Test
    public void testConstructeur_3()
    {
        testAttribut_2();
        sCon = veref.V.getVConFProto( sCla, sProtoC );
        //         veref.V.verifParamP1Type( sFil, sClassName, "double" );
        veref.V.verifFinal1Type( sFil, sClassName, "double" );
        veref.V.vrai( veref.V.nbCon( sCla ) <= 1 , "Il y a au moins un constructeur de trop ..." );
        veref.V.mesIfNot(); 
        if ( ! sAbstract ) {
            double vValue1 = 12.34;
            veref.V.getAndVerifIns1( sCon, sAtt, vValue1 ); //object discarded
        } // if
        else  veref.V.error( "Pour info : l'instruction du constructeur n'a pas pu etre verifiee." );
        veref.V.verifAttThis( sFil, sAttType, sAttName );
    } // testConstructeur_3()

    @Test
    public void testAccesseur_4()
    {
        testConstructeur_3();
        sMetName = "getSolde";
        sMetRT   = "double";
        sProtoM  = "()";
        sGetter = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM );
        //         veref.V.verifFinal( sFil, vMetName, vProtoM ); // inutile pour 0 param
        //         veref.V.vrai( veref.V.nbMet( sCla ) <= 1 , "Il y a au moins une methode de trop ..." );
        //         veref.V.mesIfNot();        
        if ( ! sAbstract ) {
            double vValue2 = 23.45;
            Object vObj2 = veref.V.getAndVerifIns1( sCon, sAtt, vValue2 );
            veref.V.verifGetter( vObj2, sGetter, vValue2 );    
            veref.V.verifAttThis( sFil, sAttType, sAttName );
        }
    } // testAccesseur_4()

    @Test
    public void testAffecte_5()
    {
        testAccesseur_4();
        sMetName = "affecte";
        sMetRT   = "void";
        sProtoM  = "( double p1 )";
        sMet = veref.V.getVMetFProtoMod( sCla, sMetName, sMetRT, sProtoM, "private", "static final" );
        veref.V.verifAttThis( sFil, sAttType, sAttName );
        if ( ! sAbstract ) {
            double vValue3 = 10.0;
            Object vObj3 = veref.V.getAndVerifIns1( sCon, sAtt, vValue3 );
            sMet.invoke( vObj3, new Object[]{34.567} );    
            double vRes = (Double) veref.V.getValueFromG( vObj3, sGetter ); 
            veref.V.vrai( vRes == vValue3, "Le solde n'est pas modifie ???" );
            veref.V.failIf(); 
            veref.V.vrai( vRes == 34.567, "Le solde n'est pas arrondi ???" );
            veref.V.failIf(); 
            veref.V.vrai( vRes == 34.57, "L'attribut n'a pas ete affecte avec la bonne valeur ???" );
            veref.V.failIfNot(); 
        }
        veref.V.verifMetThis( sFil, "double", "arrondi2", false ); // pas de this.arrondi2(
        veref.V.verifMetThis( sFil, "void",   "affecte",  true  ); // this.affecte(
    } // testAffecte_5()

    @Test
    public void testDC_6()
    {
        testAccesseur_4();
        sMetName = "debite";
        sMetRT   = "void";
        sProtoM  = "( double p1 )";
        sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM );
        if ( ! sAbstract ) {
            double vValue4 = 100.0;
            Object vObj4 = veref.V.getAndVerifIns1( sCon, sAtt, vValue4 );
            sMet.invoke( vObj4, new Object[]{34.567} );    
            double vRes4 = (Double) veref.V.getValueFromG( vObj4, sGetter ); 
            veref.V.vrai( vRes4 == vValue4, "Le solde n'est pas modifie dans "+sMetName+" ???" );
            veref.V.failIf(); 
            veref.V.vrai( vRes4 == 65.433, "Le solde n'est plus arrondi apres "+sMetName+" ???" );
            veref.V.failIf(); 
            veref.V.vrai( vRes4 == 65.43, "L'attribut n'a pas ete affecte avec la bonne valeur dans "+sMetName+" ???" );
            veref.V.failIfNot(); 
        }

        sMetName = "credite";
        sMetRT   = "void";
        sProtoM  = "( double p1 )";
        sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM );
        if ( ! sAbstract ) {
            double vValue5 = 100.0;
            Object vObj5 = veref.V.getAndVerifIns1( sCon, sAtt, vValue5 );
            sMet.invoke( vObj5, new Object[]{34.567} );    
            double vRes5 = (Double) veref.V.getValueFromG( vObj5, sGetter ); 
            veref.V.vrai( vRes5 == vValue5, "Le solde n'est pas modifie dans "+sMetName+" ???" );
            veref.V.failIf(); 
            veref.V.vrai( vRes5 == 134.567, "Le solde n'est plus arrondi apres "+sMetName+" ???" );
            veref.V.failIf(); 
            veref.V.vrai( vRes5 == 134.57, "L'attribut n'a pas ete affecte avec la bonne valeur dans "+sMetName+" ???" );
            veref.V.failIfNot(); 
        }
        veref.V.verifCount(   sFil, "this.affecte\\(",    3     ); // this.affecte(
    } // testDC_6()

    @Test
    public void testCapitalise_7()
    {
        testConstructeur_3();
        sMetName = "capitaliseUnAn";
        sMetRT   = "void";
        sProtoM  = "()";
        sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM );
        //         veref.V.verifFinal( sFil, vMetName, vProtoM ); // inutile pour 0 param
        //         veref.V.vrai( veref.V.nbMet( sCla ) <= 1 , "Il y a au moins une methode de trop ..." );
        veref.V.vrai( sMet.getModifiers().hasModifier( "abstract" ),
            "Ne devriez-vous pas indiquer au compilateur que vous ne pouvez pas savoir quelles instructions ecrire dans $n ?" );
        veref.V.failIfNot();        
        //         String vValue2 = "Room de l'attribut";
        //         Object vObj2 = veref.V.getAndVerifIns1( sCon, sAtt, vValue2 );
        //         veref.V.verifGetter( vObj2, sMet, vValue2 );
        veref.V.verifMetThis( sFil, "void",   "capitaliseUnAn",  true  ); // this.capitaliseUnAn(
    } // testCapitalise_7()

    @Test
    public void testBilan_8()
    {
        testConstructeur_3();
        sMetName = "bilanAnnuel";
        sMetRT   = "void";
        sProtoM  = "()";
        sMet = veref.V.getVMetFProto( sCla, sMetName, sMetRT, sProtoM );
        //         veref.V.verifFinal( sFil, vMetName, vProtoM ); // inutile pour 0 param
        //         veref.V.vrai( veref.V.nbMet( sCla ) <= 1 , "Il y a au moins une methode de trop ..." );
        veref.V.vrai( !sMet.getModifiers().hasModifier( "abstract" ),
          "Il faut écrire les instructions dans $n !" );
        veref.V.failIfNot();        
        //         String vValue2 = "Room de l'attribut";
        //         Object vObj2 = veref.V.getAndVerifIns1( sCon, sAtt, vValue2 );
        //         veref.V.verifGetter( vObj2, sMet, vValue2 );
    } // testBilan_8()

    /**
     * Default constructor for test class SRoomTest
     */
    public CompteTest()
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
        sClassName = "Compte";
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
