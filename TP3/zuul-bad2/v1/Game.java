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
        this.createRooms();
    }
    
    /**
     * Procédure de création de Room
     */
    private void createRooms(){
        Room vPub = new Room("in the campus pub");
        Room vOutside = new Room("outside the main entrance of the university");
        Room vLab = new Room("in the computing lab");
        Room vTheatre = new Room("in a lecture theatre");
        Room vOffice = new Room("in the computing admin office");
        
        vPub.setExits(null, null, vOutside, null);
        vOutside.setExits(null, vLab, vTheatre, vPub);
        vTheatre.setExits(null, null, null, vOutside);
        vLab.setExits(vOutside, null, vOffice, null);
        vOffice.setExits(null, null, null, vLab);
        
        this.aCurrentRoom = vOutside;
    }
    
    /**
     * Procédure qui permet un changement de pièce
     * @param -> pInstruction (Command)
     */
    private void goRoom(final Command pInstruction)
    {
        //Partie A
        if (!pInstruction.hasSecondWord()){
            System.out.println("Go where ?");
            return;
        }
        
        //Partie B
        Room vNextRoom = null;
        String vDirection = pInstruction.getSecondWord();
        if (vDirection.equals("north")){
            vNextRoom = this.aCurrentRoom.aNorthExit;
        }else if (vDirection.equals("south")){
            vNextRoom = this.aCurrentRoom.aSouthExit;
        }else if (vDirection.equals("east")){
            vNextRoom = this.aCurrentRoom.aEastExit;
        }else if (vDirection.equals("west")){
            vNextRoom = this.aCurrentRoom.aWestExit;
        }else{
            System.out.println("Unknown direction!");
            return;
        }
        
        //Partie C
        if (vNextRoom == null){
            System.out.println("There is no door !");
            return;
        }
        
        //Partie D
        this.aCurrentRoom = vNextRoom;
        System.out.println(this.aCurrentRoom.getDescription());
        System.out.print("Exits: ");
        if (this.aCurrentRoom.aNorthExit != null){
            System.out.print("north ");
        }
        if (this.aCurrentRoom.aSouthExit != null){
            System.out.print("south ");
        }
        if (this.aCurrentRoom.aEastExit != null){
            System.out.print("east ");
        }
        if (this.aCurrentRoom.aWestExit != null){
            System.out.print("west ");
        }
        System.out.println("");
    }   
} // Game
