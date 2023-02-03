 
/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author Brenner Augustin
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
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
     * La fonction renvoie vrai si le premier mot est null
     */
    public boolean  isUnknown(){
        return this.aCommandWord == null;
    }
} // Command
