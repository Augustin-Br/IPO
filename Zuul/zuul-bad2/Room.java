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
    private HashMap<String, Room> aExits; //HashMap qui contient les différentes sorties de la pièce

    /**
     * Constructeur naturel
     * @param pDescription (String) -> description de la pièce
     */
    public Room(final String pDescription){
        this.aDescription = pDescription;
        aExits = new HashMap<String, Room>(); // Création d'une HashMap vide
    }

    /**
     * Accesseur Description
     */
    public String getDescription(){
        return this.aDescription;
    }

    /**
     * Cette fonction renvoie la pièce dans la direction indiqué
     * @param pDirection (String) -> direction de la sortie
     * @return -> Room : la pièce dans la direction indiqué
     */
    public Room getExit(final String pDirection){
        return aExits.get(pDirection);
    }

       /**
        * Cette fonction renvoie la liste des sorties de la pièce
        * @return -> String : liste des sorties
        */
    public String getExitString(){
        StringBuilder vExitString = new StringBuilder("Exits : ");
        Set<String> vKeys = this.aExits.keySet();
        for (String vExit : vKeys){
            vExitString.append(" " + vExit);
        }
        return vExitString.toString();
    }

    /**
     * Définition des sorties de chaque piece. Chaque direction conduit à une autre pièces ou est "null"
     * @param pDirection (String) -> La direction de la sortie
     * @param pNeighbor (Room) -> La piece dans la direction indiqué
     */
    public void setExits(final String pDirection, final Room pNeighbor){
        aExits.put(pDirection, pNeighbor);
    }

    /**
     * Retourne une description complete de cette pièce, de la forme :
     *    You are in the kitchen.
     *    Exits : north west
     * @return -> String : description de la pièce
     */
    public String getLongDescription(){
        return "You are " + this.aDescription + ".\n" + this.getExitString();
    }
} // Room
