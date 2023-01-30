package v1;

/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author Brenner Augustin
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    /**
     * Constructeur par défault
     */
    public Game(){
        this.createRooms();
        this.aParser = new Parser();
        //printWelcome();
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
        
        if (vNextRoom == null){
            System.out.println("There is no door !");
            return;
        }
   
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
    
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul! \n World of Zuul is a new, incredibly boring adventure game. \n Type 'help' if you need help. \n \n");
        String vNorth = "";
        String vSouth = "";
        String vEast = "";
        String vWest = "";
        if (this.aCurrentRoom.aNorthExit != null){
            vNorth = "north ";
        }
        if (this.aCurrentRoom.aSouthExit != null){
            vSouth = "south";
        }
        if (this.aCurrentRoom.aEastExit != null){
            vEast = "east";
        }
        if (this.aCurrentRoom.aWestExit != null){
            vWest = "west";
        }
        System.out.println("You are" + aCurrentRoom.getDescription() + "\n Exits" + vNorth + " " + vSouth + " " + vEast + " " + vWest);
        // You are outside the main entrance of the university \n Exits: east south west
    }
    
    private void printHelp(){
        System.out.println("You are lost. You are alone. \n You wander around at the university. \n \n Your command words are: \n  go quit help");
    }
    
    private boolean quit(final Command pQuit){
        if (pQuit.hasSecondWord()){
            System.out.println("Quit what?");
            return false;
        }else{
            return true;
        }
    }
    
    private boolean processCommand(final Command pInstruction){
        if(pInstruction.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }else if(pInstruction.getCommandWord().equals("quit")){
            return quit(pInstruction);
        }else if (pInstruction.getCommandWord().equals("help")){
            printHelp();
            return false;
        }else if(pInstruction.getCommandWord().equals("go")){
            goRoom(pInstruction);
            return false;
        }else{
            System.out.println("I don't know what you mean...");
            return false;
        }
    }
    
    public void play(){
        printWelcome();
        boolean vFinished = false;
        while (vFinished == false){
            Command vCommand = aParser.getCommand();
            vFinished = processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
} // Game
