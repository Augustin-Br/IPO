 /**
 * Définition de l'environement du jeux (lieux/carte)
 *
 * @author Brenner Augustin
 */

import java.util.HashMap;
import java.util.Set;

public class Room
{
    private String aDescription; // Description des lieux
    private HashMap<String, Room> aExits; //HashMap

    /**
     * Constructeur naturel
     * @param pDescription -> La description de la pièce
     */
    public Room(final String pDescription){
        this.aDescription = pDescription;
        aExits = new HashMap<String, Room>(); // Création d'une HashMap vide
    }
    
    /**
    * Renvoie la description de la salle où le joueur se trouve (celle qui a été définie dans le constructeur)
    */
    public String getDescription(){
        return this.aDescription;
    }
    
    /**
     * Renvoie les valeurs des différentes sorties en fonctions de la direction indiqué. La valeur retourné est de type "Room"
     * @param pDirection -> String : direction
     * @return -> Room : sortie dans la direction indiqué par le joueur
     */
    public Room getExit(final String pDirection){
        return aExits.get(pDirection);
    }
    
    /**
     * Cette fonction renvoie les sorties de la salle dans laquel le joueur est présent sous forme de String
     * @return -> String : liste des différentes directions permettant de sortir de la pièce
     */
    public String getExitString(){
        String vExitString = "Exits : ";
        Set<String> vKeys = this.aExits.keySet();
        for (String vExit : vKeys){
            vExitString += " " + vExit;
        }        
        return vExitString;
    }
     
    /**
     * Définition des sorties de chaque piece. Chaque direction conduit à une autre pièces ou est "null"
     * @param pDirection -> La direction de la sortie
     * @param pNeighbor -> La piece dans la direction indiqué
     */
    public void setExits(final String pDirection, final Room pNeighbor){
        aExits.put(pDirection, pNeighbor);
    }
} // Room
