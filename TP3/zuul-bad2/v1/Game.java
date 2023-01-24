package v1;

/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author Brenner Augustin
 */
public class Game
{
    private Room aCurrentRoom;
    
    /**
     * Constructeur par défault
     */
    public Game(){
        this.aCurrentRoom
    }
    
    /**
     * Procédure de création de Room
     */
    private void createRooms(){
        Room vPub = new Room("Campus Pub");
        Room vOutside = new Room("Main Entrance");
        Room vLab = new Room("Camputing Lab");
        Room vTheater = new Room("Lecture Theater");
        Room vOffice = new Room("Computing Admin.");
        
        vPub.setExits(null, null, vOutside, null);
        vOutside.setExits(null, vPub, vTheater, vLab);
        vLab.setExits(vOutside, null, vOffice, null);
        vTheater.setExits(null, null, null, vOutside);
        vOffice.setExits(null, null, null, vOffice);
    }

} // Game
