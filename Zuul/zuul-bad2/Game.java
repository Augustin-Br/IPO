 
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
        Room vPlace = new Room("In the public place");
        Room vForest = new Room("In the forest");
        Room vClearing = new Room("In the strange clearing");
        Room vBar = new Room("In the bar");
        Room vHotel = new Room("In the hotel");
        Room vMarket = new Room("In the market");
        Room vPort = new Room("In the port");
        Room vCove = new Room("On the cove");
        Room vAgroundBoat = new Room("In the aground boat");
        Room vBeach = new Room("On the beach");
        
        vPlace.setExits(vForest, vMarket, vBar, vHotel);
        vForest.setExits(null, vPlace, vClearing, null);
        vClearing.setExits(null, null, null, vForest);
        vBar.setExits(null, null, null, vPlace);
        vHotel.setExits(null, null, vPlace, null);
        vMarket.setExits(vPlace, null, vPort, vBeach);
        vPort.setExits(null, null, null, vMarket);
        vCove.setExits(null, vBeach, null, null);
        vAgroundBoat.setExits(vBeach, null, null, null);
        vBeach.setExits(vCove, vAgroundBoat, vMarket, null);
        
        this.aCurrentRoom = vPlace;
    }
    
    /**
     * Procédure qui affiche les informations de la localisation
     */
    private void printLocationInfo(){
        System.out.println("You are " + aCurrentRoom.getDescription());
        /*
        System.out.println("Exits : ");
        if(aCurrentRoom.aNorthExit != null){
            System.out.println("north ");
        }
        if(aCurrentRoom.aSouthExit != null){
            System.out.println("south ");
        }
        if(aCurrentRoom.aEastExit != null){
            System.out.println("east ");
        }
        if(aCurrentRoom.aWestExit != null){
            System.out.println("west ");
        }
        */
       System.out.println(this.aCurrentRoom.getExitString());
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
        /*
        if (vDirection.equals("north")){
            vNextRoom = aCurrentRoom.getExit("north");
        }else if (vDirection.equals("south")){
            vNextRoom = aCurrentRoom.getExit("south");
        }else if (vDirection.equals("east")){
            vNextRoom = aCurrentRoom.getExit("east");
        }else if (vDirection.equals("west")){
            vNextRoom = aCurrentRoom.getExit("west");
        }else{
            System.out.println("Unknown direction!");
            return;
        }
        */
        if(vDirection.equals("north") || vDirection.equals("south") || vDirection.equals("east") ||vDirection.equals("west")){
            vNextRoom = aCurrentRoom.getExit(vDirection);
        }else{
            System.out.println("Unknown direction!");
            return;
        }
        
        
        if (vNextRoom == null){
            System.out.println("There is no door !");
            return;
        }
   
        this.aCurrentRoom = vNextRoom;
        /*System.out.println(this.aCurrentRoom.getDescription());
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
        */
        printLocationInfo();
    }   
    
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul! \n World of Zuul is a new, incredibly boring adventure game. \n Type 'help' if you need help. \n \n");
        /*String vNorth = "";
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
        System.out.println("You are " + aCurrentRoom.getDescription().toLowerCase() + "\n Exits : " + vNorth + " " + vSouth + " " + vEast + " " + vWest);
        // You are outside the main entrance of the university \n Exits: east south west
        
        */
        printLocationInfo();
    }
    
    private void printHelp(){
        System.out.println("You are lost. You are alone. \n You wander around the island. \n \n Your command words are: \n  go quit help");
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
        this.printWelcome();
        boolean vFinished = false;
        while (vFinished == false){
            Command vCommand = aParser.getCommand();
            vFinished = processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
} // Game
