
/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    // un tableau constant qui contient toutes les commandes valides
    private static final String[] aValidCommands = {
            "go", "quit", "help", "look", "eat"
    };

//    /**
//     * Constructor - initialise the command words.
//     */
//    public CommandWords()
//    {
//        this.aValidCommands[0] = "go";
//        this.aValidCommands[1] = "help";
//        this.aValidCommands[2] = "quit";
//        this.aValidCommands[3] = "look";
//        this.aValidCommands[4] = "eat";
//    } // CommandWords()

    /**
     * Check whether a given String is a valid command word.
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for ( int vI=0; vI<this.aValidCommands.length; vI++ ) {
            if ( this.aValidCommands[vI].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands :
        return false;
    } // isCommand()

    /**
     * Fonction qui renvoie la liste de toutes les commandes valides
     * @return -> String : liste des commandes valides
     */
    public String getCommandList(){
        String vAllCommands = "";
        for(String command : this.aValidCommands) {
            vAllCommands += command + " ";
        }
        return vAllCommands;
    }

} // CommandWords