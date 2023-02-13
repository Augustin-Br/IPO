 /**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author Brenner Augustin
 */

import java.util.HashMap;
import java.util.Set;

public class Room
{
    private String aDescription; // Description des lieux
    private HashMap<String, Room> aExits; //HashMap
    
    /* Les quatres directions sorties
    public Room aNorthExit;
    public Room aSouthExit;
    public Room aEastExit;
    public Room aWestExit;
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
     * @param -> String : direction
     * @return -> Room : sortie dans la direction indiqué par le joueur
     */
    public Room getExit(final String pDirection){
        return aExits.get(pDirection);
    }
    
    /**
     * Cet accesseur renvoie les sorties de la salle dans laquel le joueur est présent sous forme de String
     * @return -> String : liste des différentes directions permettant de sortir de la pièce
     */
    public String getExitString(){
        String vExit = "Exits : ";
        /*
        if(this.getExit("north") != null){
            vExit += "north ";
        }
        
        if(this.getExit("south") != null){
            vExit += "south ";
        }
        
        if(this.getExit("east") != null){
            vExit += "east ";
        }
        
        if(this.getExit("west") != null){
            vExit += "west ";
        }
        */
        Set<String> vI = this.aExits.keySet();
        for (String vE : vI){
            vExit += " " + vE;
        }        
        return vExit;
    }
    
    // public void setExits(final Room pNorthExit, final Room pSouthExit, final Room pEastExit, final Room pWestExit){
        // this.aNorthExit = pNorthExit;
        // this.aSouthExit = pSouthExit;
        // this.aEastExit = pEastExit;
        // this.aWestExit  = pWestExit;
    // }
    
    /**
     * Définition des sorties de chaque pieces. Chaque direction conduit à une autre pièces ou est "null"
     * @param : les différentes directions du type "Room"
     */
    public void setExits(final String pDirection, final Room pNeighbor){
        /*
        if(pNorthExit != null){
            aExits.put("north", pNorthExit);
        }
        
        if(pSouthExit != null){
            aExits.put("south", pSouthExit);
        }
        
        if(pEastExit != null){
            aExits.put("east", pEastExit);
        }
        
        if(pWestExit != null){
            aExits.put("west", pWestExit);
        }
        */
        aExits.put(pDirection, pNeighbor);
    }
} // Room
