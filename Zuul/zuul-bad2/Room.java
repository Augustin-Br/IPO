 

/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author Brenner Augustin
 */
public class Room
{
    private String aDescription; // Description des lieux
    public Room aNorthExit;
    public Room aSouthExit;
    public Room aEastExit;
    public Room aWestExit;
    
    public Room(final String pDescription){
        this.aDescription = pDescription;
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
        if (pDirection.equals("north")){
            return aNorthExit;
        }
        
        if (pDirection.equals("south")){
            return aSouthExit;
        }
        
        if (pDirection.equals("east")){
            return aEastExit;
        }
        
        if (pDirection.equals("west")){
            return aWestExit;
        }
        return null;
    }
    
    /**
     * Cet accesseur renvoie les sorties de la salle dans laquel le joueur est présent sous forme de String
     * @return -> String : liste des différentes directions permettant de sortir de la pièce
     */
    public String getExitString(){
        String vExit = "Exits : ";
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
    public void setExits(final Room pNorthExit, final Room pSouthExit, final Room pEastExit, final Room pWestExit){
        if(pNorthExit != null){
            aNorthExit = pNorthExit;
        }
        
        if(pSouthExit != null){
            aSouthExit = pSouthExit;
        }
        
        if(pEastExit != null){
            aEastExit = pEastExit;
        }
        
        if(pWestExit != null){
            aWestExit = pWestExit;
        }
    }
} // Room
