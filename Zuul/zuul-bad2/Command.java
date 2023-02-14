 
/**
 * Analyse des commandes exécuté par l'utilisateur
 *
 * @author Brenner Augustin
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructeur naturel
     * @param pCommandWord -> String : Premier mot de la commande exécuté par l'utilisateur
     * @param pSecondWord -> String : Deuxième mot de la commande exécuté par l'utilisateur
     */
    public Command(final String pCommandWord, final String pSecondWord){
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
     }
     
    /**
     * Accesseur CommandWord
     */
    public String getCommandWord(){
        return this.aCommandWord;
    }
    
    /**
     * Accesseur SecondWord
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }
    
    /**
     * Fonction qui renvoie vraie si il y a un second mot
     */
    public boolean hasSecondWord(){
        return this.aSecondWord != null;
    }
    
    /**
     * La fonction renvoie vrai si le premier mot est null (incorect)
     */
    public boolean  isUnknown(){
        return this.aCommandWord == null;
    }
} // Command
